import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.hibernate.Query;
import org.hibernate.Session;

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
	public boolean PeselValidate() {
		enteredPesel = this.getText();
//		System.out.println("Wprowadzono PESEL: " + enteredPesel);
		if (checkPeselLength(enteredPesel)) {
			if (checkPeselInDB(enteredPesel)) {
				return true;
			} else {			
				return false;
			}
		} else {
			return false;
		}

	}
// check if entered PESEL is in ElectionsDB
	private boolean checkPeselInDB(String enteredPesel) {
		Query query = session
				.createQuery("from Voters V where V.pesel =:pesel ");
		query.setParameter("pesel", enteredPesel);

		List<Voters> peselList = query.list();
		if (peselList.isEmpty()) {
			JOptionPane.showMessageDialog(null,
					"Podany PESEL nie jest uprawniony do glosowania");
			return false;
		} else {
			return true;
		}

	}

	// check if entered PESEL is 11 digits length
	private boolean checkPeselLength(String ePesel) {
		if (ePesel.length() == PESEL_LENGTH) {
			return true;
		} else if (ePesel.length() == 0) {
			JOptionPane.showMessageDialog(null, "Podaj PESEL!");
			System.out.println("Wprowadzono za krotki PESEL");
			return false;
		} else {
			JOptionPane.showMessageDialog(null, "Wprowadzono za krotki PESEL");
			return false;
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
