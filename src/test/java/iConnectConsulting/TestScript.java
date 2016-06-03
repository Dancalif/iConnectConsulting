package iConnectConsulting;

import java.util.Random;

public class TestScript {

	public static void main(String args[]) {
		Random rand = new Random();
		int yyyy = 1900 + rand.nextInt(116);
		int mm = 1 + rand.nextInt(12);
		int dd = 0;

		switch (mm) {
		case 2:
			if (yyyy % 4 == 0) {
				dd = 1 + rand.nextInt(29);
			} else {
				dd = 1 + rand.nextInt(28);
			}
			break;
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			dd = 1 + rand.nextInt(31);
		default:
			dd = 1 + rand.nextInt(30);
		}
		String year = Integer.toString(yyyy);
		String month = Integer.toString(mm);
		String day = Integer.toString(dd);
		if (mm < 10) {
			month = "0" + mm;
		}
		if (dd < 10) {
			day = "0" + dd;
		}
		System.out.print(month + '/' + day + '/' + year);
	}

	// GregorianCalendar gc = new GregorianCalendar();
	// int year = randBetween(1900, 2010);
	// gc.set(gc.YEAR, year);
	// int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
	// gc.set(gc.DAY_OF_YEAR, dayOfYear);
	// System.out.println(gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) +
	// "-" + gc.get(gc.DAY_OF_MONTH));
	// public static int randBetween(int start, int end) {
	// return start + (int) Math.round(Math.random() * (end - start));
	// }
}
