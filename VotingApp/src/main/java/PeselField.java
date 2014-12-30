import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

public class PeselField extends JTextField {

	private static final int PESEL_LENGTH = 11;

	// private static final String PESEL_FORMAT = "###########";
	private String enteredPesel;

	// set pesel field to 11 digits formats
	public PeselField() {
		this.setColumns(PESEL_LENGTH);
	}

	// check if entered Pesel is valid
	public boolean PeselValidate() {
		enteredPesel = this.getText();

		System.out.println(enteredPesel);
		// if (PeselNotEmpty(enteredPesel)) {
		if (checkPeselLength(enteredPesel)) {
			return true;
		} else {
			return false;
		}
	}

	// }

	// check if entered Pesel is 11 digits length
	private boolean checkPeselLength(String ePesel) {

		if (ePesel.length() == PESEL_LENGTH) {
			System.out.println("bhsadfksa");
			return true;
		} else {
			return false;
		}

	}

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
