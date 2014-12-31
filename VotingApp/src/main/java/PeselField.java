import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

public class PeselField extends JTextField {

	private static final int PESEL_LENGTH = 11;
	private String enteredPesel;

	// set size of PESEL field
	public PeselField() {
		this.setColumns(PESEL_LENGTH);
	}

	// check if entered PESEL is valid
	public boolean PeselValidate() {
		enteredPesel = this.getText();
		System.out.println("Wprowadzono PESEL: " + enteredPesel);

		if (checkPeselLength(enteredPesel)) {
			return true;
		} else {
			return false;
		}
	}

	// check if entered PESEL is 11 digits length
	private boolean checkPeselLength(String ePesel) {
		if (ePesel.length() == PESEL_LENGTH) {
			return true;
		} else {
			System.out.println("Wprowadzono za krotki PESEL");
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
