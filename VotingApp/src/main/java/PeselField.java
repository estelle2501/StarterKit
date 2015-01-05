import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class PeselField extends JTextField {

	private static final int PESEL_LENGTH = 11;
	private String enteredPesel;
	private Session session;

	// set size of PESEL field
	public PeselField(Session s) {
		this.setColumns(PESEL_LENGTH);
		session = s;
	}

	// check if entered PESEL is valid
	public boolean PeselValidate(String enteredZipCode) {
		enteredPesel = this.getText();
		PeselValidation pv = new PeselValidation(enteredPesel);
		
		if (pv.checkIfEmpty()) {
			JOptionPane.showMessageDialog(null, "Podaj PESEL!");
			return false;
		}

		if (pv.checkIfValidLength()) {
			if (checkPeselInDB(enteredPesel, enteredZipCode)) {
				return true;
			} else {
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(null, "Wprowadzono za krotki PESEL");
			return false;
		}

	}

	// check if entered PESEL is in ElectionsDB
	private boolean checkPeselInDB(String enteredPesel, String enteredZipCode) {

		// get entered zipCode Id
		Query query1 = session
				.createQuery("from ZipCodes Z where Z.zipCode =:zipCode");
		query1.setParameter("zipCode", enteredZipCode);
		List<ZipCodes> zipCodeList = query1.list();
		ZipCodes z = zipCodeList.get(0);
		long zipCodeId = z.getId();
		// System.out.println(zipCodeId);
		// System.out.println(enteredZipCode);
		// System.out.println(enteredPesel);

		// check if PESEL has correct ZipCodeId
		Query query2 = session
				.createQuery("select V from Voters as V where zip_codes_id =:zip_codes_id and V.pesel =:pesel");
		query2.setParameter("pesel", enteredPesel);
		query2.setParameter("zip_codes_id", zipCodeId);
		List<Voters> peselList = query2.list();

		// for (Voters v : peselList) {
		// System.out.println(v.getId() + "," + v.getPesel());
		// }

		if (peselList.isEmpty()) {
			JOptionPane.showMessageDialog(null,
					"Podany PESEL nie jest uprawniony do glosowania w okregu "
							+ enteredZipCode);
			return false;
		} else {
			System.out
					.println("Podany PESEL jest uprawniony do glosowania w okregu "
							+ enteredZipCode);
			return true;
		}

	}

	// allow only 11 digits in PESEl field
	public void addListener() {
		this.addKeyListener(new KeyListener() {

			public void keyTyped(KeyEvent e) {
				checkIfCorrectKey(e);
			}

			public void keyReleased(KeyEvent e) {
			}

			public void keyPressed(KeyEvent e) {
			}

			public void checkIfCorrectKey(KeyEvent e) {
				if (!(e.getKeyChar() >= '0' && e.getKeyChar() <= '9')) {
					e.consume();
				}
				if (getText().length() >= 11) {
					e.consume();
				}
			}
		});
	}
}
