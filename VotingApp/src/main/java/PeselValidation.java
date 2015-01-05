public class PeselValidation {

	private String enteredPesel;
	private static final int PESEL_LENGTH = 11;

	public PeselValidation(String ePesel) {
		enteredPesel = ePesel;
	}

	public boolean checkIfFemale() {
		int digit10 = getDigit(10);
		if (digit10 == 0 || digit10 == 2 || digit10 == 4 || digit10 == 6
				|| digit10 == 8) {
			return true;
		} else {
			return false;

		}

	}

	public boolean checkIfMale() {
		int digit10 = getDigit(10);
		if (digit10 == 1 || digit10 == 3 || digit10 == 5 || digit10 == 7
				|| digit10 == 9) {
			return true;
		} else {
			return false;

		}

	}

	public int getDigit(int d) {
		if (d > enteredPesel.length()) {
			return -1;
		} else {
			int digit = Integer.parseInt(enteredPesel.substring(d - 1, d));

			return digit;
		}
	}

	public boolean checkIFDigitsOnly() {
		for (int i = 0; i < enteredPesel.length(); i++) {
			if (!Character.isDigit(enteredPesel.charAt(i))) {
				return false;
			}
		}
		return true;

	}

	public boolean checkIfValidLength() {
		if (enteredPesel.length() == PESEL_LENGTH) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkIfEmpty() {
		if (enteredPesel.length() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public MyDate getBirthDate() {
		int year = Integer.parseInt("19" + enteredPesel.substring(0, 2));
		int month = Integer.parseInt(enteredPesel.substring(2, 4));
		int day = Integer.parseInt(enteredPesel.substring(4, 6));
		MyDate birthDate = new MyDate();
		birthDate.setDate(year, month, day);
		return birthDate;
	}

	public boolean checkIfCorrect() {
		int[] p = new int[11];

		int controlDigit;
		for (int i = 0; i < enteredPesel.length(); i++) {
			p[i] = Integer.parseInt(enteredPesel.substring(i, i + 1));

		}

		int n = p[0] + 3 * p[1] + 7 * p[2] + 9 * p[3] + p[4] + 3 * p[5] + 7
				* p[6] + 9 * p[7] + p[8] + 3 * p[9];
		int mod10 = n % 10;

		if (mod10 == 0) {
			controlDigit = 0;
		} else {
			controlDigit = 10 - mod10;
		}

		if (controlDigit == p[10]) {
			return true;
		} else {
			return false;

		}

	}
}
