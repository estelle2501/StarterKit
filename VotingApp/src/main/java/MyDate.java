import java.math.BigDecimal;

public class MyDate {
	private int year;
	private int month;
	private int day;

	MyDate setDate(int y, int m, int d) {
		this.year = y;
		this.month = m;
		this.day = d;

		return this;
	}

	public boolean isEqual(MyDate md) {
		if (md.year == this.year && md.month == this.month
				&& md.day == this.day) {
			return true;
		} else {
			return false;
		}
	}
}
