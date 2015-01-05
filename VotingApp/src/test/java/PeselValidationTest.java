import org.fest.assertions.Assertions;
import org.junit.Test;

public class PeselValidationTest {

	@Test
	public void ShouldReturnEmptyTrue() {
		String enteredPesel = "";
		PeselValidation pv = new PeselValidation(enteredPesel);
		boolean result = pv.checkIfEmpty();
		Assertions.assertThat(result).isEqualTo(true);

	}

	@Test
	public void ShouldReturnEmptyFalse() {
		String enteredPesel = "90012500807";
		PeselValidation pv = new PeselValidation(enteredPesel);
		boolean result = pv.checkIfEmpty();
		Assertions.assertThat(result).isEqualTo(false);

	}

	@Test
	public void ShouldReturnLengthTrue() {
		String enteredPesel = "90012500807";
		PeselValidation pv = new PeselValidation(enteredPesel);
		boolean result = pv.checkIfValidLength();
		Assertions.assertThat(result).isEqualTo(true);

	}

	@Test
	public void ShouldReturnLengthFalse() {
		String enteredPesel = "9001250080";
		PeselValidation pv = new PeselValidation(enteredPesel);
		boolean result = pv.checkIfValidLength();
		Assertions.assertThat(result).isEqualTo(false);

	}

	@Test
	public void ShouldReturnDigit10as0() {
		String enteredPesel = "90012500807";
		PeselValidation pv = new PeselValidation(enteredPesel);
		int result = pv.getDigit(10);
		Assertions.assertThat(result).isEqualTo(0);

	}

	@Test
	public void ShouldReturnDigit1as9() {
		String enteredPesel = "90012500807";
		PeselValidation pv = new PeselValidation(enteredPesel);
		int result = pv.getDigit(1);
		Assertions.assertThat(result).isEqualTo(9);

	}

	@Test
	public void ShouldReturnDigit11as7() {
		String enteredPesel = "90012500807";
		PeselValidation pv = new PeselValidation(enteredPesel);
		int result = pv.getDigit(11);
		Assertions.assertThat(result).isEqualTo(7);

	}

	@Test
	public void ShouldReturnDigit12asErr() {
		String enteredPesel = "90012500807";
		PeselValidation pv = new PeselValidation(enteredPesel);
		int result = pv.getDigit(12);
		Assertions.assertThat(result).isEqualTo(-1);

	}

	@Test
	public void ShouldBeAllDigitsFalse() {
		String enteredPesel = "9001a500807";
		PeselValidation pv = new PeselValidation(enteredPesel);
		boolean result = pv.checkIFDigitsOnly();
		Assertions.assertThat(result).isEqualTo(false);

	}

	@Test
	public void ShouldBeAllDigitsTrue() {
		String enteredPesel = "90012500807";
		PeselValidation pv = new PeselValidation(enteredPesel);
		boolean result = pv.checkIFDigitsOnly();
		Assertions.assertThat(result).isEqualTo(true);

	}

	@Test
	public void ShouldReturnWomanTrue90012500807() {
		String enteredPesel = "90012500807";
		PeselValidation pv = new PeselValidation(enteredPesel);
		boolean result = pv.checkIfFemale();
		Assertions.assertThat(result).isEqualTo(true);

	}

	@Test
	public void ShouldReturnMaleFalse90012500807() {
		String enteredPesel = "90012500807";
		PeselValidation pv = new PeselValidation(enteredPesel);
		boolean result = pv.checkIfMale();
		Assertions.assertThat(result).isEqualTo(false);

	}

	@Test
	public void ShouldReturnWomanFalse56020714838() {
		String enteredPesel = "56020714838";
		PeselValidation pv = new PeselValidation(enteredPesel);
		boolean result = pv.checkIfFemale();
		Assertions.assertThat(result).isEqualTo(false);

	}

	@Test
	public void ShouldReturnMaleTrue56020714838() {
		String enteredPesel = "56020714838";
		PeselValidation pv = new PeselValidation(enteredPesel);
		boolean result = pv.checkIfMale();
		Assertions.assertThat(result).isEqualTo(true);

	}

	@Test
	public void ShouldReturn25011990for90012500807() {
		String enteredPesel = "90012500807";
		PeselValidation pv = new PeselValidation(enteredPesel);

		MyDate myDate = new MyDate();
		myDate.setDate(1990, 1, 25);

		MyDate resultDate = pv.getBirthDate();
		Assertions.assertThat(resultDate.isEqual(myDate)).isEqualTo(true);

	}

	@Test
	public void ShouldReturnCorrectTrue() {
		String enteredPesel = "90012500807";
		PeselValidation pv = new PeselValidation(enteredPesel);
		boolean result = pv.checkIfCorrect();
		Assertions.assertThat(result).isEqualTo(true);

	}

	@Test
	public void ShouldReturnCorrectFalse() {
		String enteredPesel = "90412500807";
		PeselValidation pv = new PeselValidation(enteredPesel);
		boolean result = pv.checkIfCorrect();
		Assertions.assertThat(result).isEqualTo(false);

	}

}
