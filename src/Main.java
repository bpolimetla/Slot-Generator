//Apache License 2.0

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Problem: Supermarket opens from 7 AM to 5 PM. Total 720 Apartments Provide
 * slot to each unit to visit supermarket
 * 
 * Assumptions: Only 50% or less will come to shop on daily basis. Few unit may
 * be vacant.
 * 
 * Final Results: Copy paste data to CSV file. Open in excel and format it.
 * 
 * @author Bhavani P Polimetla
 * @since March-29-2020
 *
 */
public class Main {

	// Considering all unit irrespective of vacant or not.
	public static final int TOTAL_APARTMENTS = 720;

	// It should be multiples of 4, if change is required
	public static final int TOTAL_SLOTS = 20;

	public static Integer[] apartments = new Integer[TOTAL_APARTMENTS];
	public static Integer[] apartments_g1 = new Integer[TOTAL_APARTMENTS / 4]; // 180
	public static Integer[] apartments_g2 = new Integer[TOTAL_APARTMENTS / 4]; // 180
	public static Integer[] apartments_g3 = new Integer[TOTAL_APARTMENTS / 4]; // 180
	public static Integer[] apartments_g4 = new Integer[TOTAL_APARTMENTS / 4]; // 180

	public static Integer[][] slots_d1 = new Integer[TOTAL_SLOTS][TOTAL_APARTMENTS / TOTAL_SLOTS];
	public static Integer[][] slots_d2 = new Integer[TOTAL_SLOTS][TOTAL_APARTMENTS / TOTAL_SLOTS];
	public static Integer[][] slots_d3 = new Integer[TOTAL_SLOTS][TOTAL_APARTMENTS / TOTAL_SLOTS];
	public static Integer[][] slots_d4 = new Integer[TOTAL_SLOTS][TOTAL_APARTMENTS / TOTAL_SLOTS];
	public static Integer[][] slots_d5 = new Integer[TOTAL_SLOTS][TOTAL_APARTMENTS / TOTAL_SLOTS];
	public static Integer[][] slots_d6 = new Integer[TOTAL_SLOTS][TOTAL_APARTMENTS / TOTAL_SLOTS];
	public static Integer[][] slots_d7 = new Integer[TOTAL_SLOTS][TOTAL_APARTMENTS / TOTAL_SLOTS];

	public static void main(String[] args) {

		// Prepare seed data
		prepareApartmentsList();
		// System.out.println(Arrays.toString(apartments_g1));
		// System.out.println(Arrays.toString(apartments_g2));
		// System.out.println(Arrays.toString(apartments_g3));
		// System.out.println(Arrays.toString(apartments_g4));

		prepareDay(slots_d1, apartments_g1, apartments_g2, apartments_g3, apartments_g4);
		prepareDay(slots_d2, apartments_g2, apartments_g3, apartments_g4, apartments_g1);
		prepareDay(slots_d3, apartments_g3, apartments_g4, apartments_g1, apartments_g2);
		prepareDay(slots_d4, apartments_g4, apartments_g1, apartments_g2, apartments_g3);
		prepareDay(slots_d5, apartments_g1, apartments_g2, apartments_g3, apartments_g4);
		prepareDay(slots_d6, apartments_g2, apartments_g3, apartments_g4, apartments_g1);
		prepareDay(slots_d7, apartments_g3, apartments_g4, apartments_g1, apartments_g2);

		// printData(slots_d1);
		// print7Days();

		print7DaysWithText();
	}

	/**
	 * This data can use used to open with Excel and analyze data or convert into
	 * printable format. Use for testing
	 */
	private static void print7Days() {
		for (int slot = 1; slot <= TOTAL_SLOTS; slot++) { // 20
			for (int flat = 1; flat <= TOTAL_APARTMENTS / TOTAL_SLOTS; flat++) { // 36
				String line;
				line = slots_d1[slot - 1][flat - 1] + ";" + slot + ";";
				line = line + slots_d2[slot - 1][flat - 1] + ";" + slot + ";";
				line = line + slots_d3[slot - 1][flat - 1] + ";" + slot + ";";
				line = line + slots_d4[slot - 1][flat - 1] + ";" + slot + ";";
				line = line + slots_d5[slot - 1][flat - 1] + ";" + slot + ";";
				line = line + slots_d6[slot - 1][flat - 1] + ";" + slot + ";";
				line = line + slots_d7[slot - 1][flat - 1] + ";" + slot + ";";
				System.out.println(line);
			}
		}
	}

	/**
	 * Generate data which is ready to use
	 */
	private static void print7DaysWithText() {

		Integer[][] day1 = new Integer[TOTAL_APARTMENTS][2];
		Integer[][] day2 = new Integer[TOTAL_APARTMENTS][2];
		Integer[][] day3 = new Integer[TOTAL_APARTMENTS][2];
		Integer[][] day4 = new Integer[TOTAL_APARTMENTS][2];
		Integer[][] day5 = new Integer[TOTAL_APARTMENTS][2];
		Integer[][] day6 = new Integer[TOTAL_APARTMENTS][2];
		Integer[][] day7 = new Integer[TOTAL_APARTMENTS][2];

		// Step 1 - Convert two dimension apartments to slots
		int day_row = 0;
		for (int slot = 1; slot <= TOTAL_SLOTS; slot++) { // 20
			for (int flat = 1; flat <= TOTAL_APARTMENTS / TOTAL_SLOTS; flat++) { // 36

				day1[day_row][0] = slots_d1[slot - 1][flat - 1];
				day1[day_row][1] = slot;

				day2[day_row][0] = slots_d2[slot - 1][flat - 1];
				day2[day_row][1] = slot;

				day3[day_row][0] = slots_d3[slot - 1][flat - 1];
				day3[day_row][1] = slot;

				day4[day_row][0] = slots_d4[slot - 1][flat - 1];
				day4[day_row][1] = slot;

				day5[day_row][0] = slots_d5[slot - 1][flat - 1];
				day5[day_row][1] = slot;

				day6[day_row][0] = slots_d6[slot - 1][flat - 1];
				day6[day_row][1] = slot;

				day7[day_row][0] = slots_d7[slot - 1][flat - 1];
				day7[day_row][1] = slot;

				day_row++;
			}
		}

		// Step 2 - Sort Data

		Arrays.sort(day1, Comparator.comparingInt(a -> a[0]));
		Arrays.sort(day2, Comparator.comparingInt(a -> a[0]));
		Arrays.sort(day3, Comparator.comparingInt(a -> a[0]));
		Arrays.sort(day4, Comparator.comparingInt(a -> a[0]));
		Arrays.sort(day5, Comparator.comparingInt(a -> a[0]));
		Arrays.sort(day6, Comparator.comparingInt(a -> a[0]));
		Arrays.sort(day7, Comparator.comparingInt(a -> a[0]));

		/*
		 * // Step 3 - Print Data for mathematical validation for (int unit = 0; unit <
		 * TOTAL_APARTMENTS; unit++) { // 20 String line; line = day1[unit][0] + ";" +
		 * day1[unit][1] + ";"; line = line + day2[unit][1] + ";"; line = line +
		 * day3[unit][1] + ";"; line = line + day4[unit][1] + ";"; line = line +
		 * day5[unit][1] + ";"; line = line + day6[unit][1] + ";"; line = line +
		 * day7[unit][1] + ";"; System.out.println(line);
		 * 
		 * }
		 */

		// Step 4 - Print Data for distribution
		System.out.println("APT,day1,day2,day3,day4,day5,day6,day7");
		for (int unit = 0; unit < TOTAL_APARTMENTS; unit++) { // 20
			String line;
			line = APT_NAMES[day1[unit][0] - 1] + "," + SLOT_NAMES[day1[unit][1] - 1] + ",";
			line = line + SLOT_NAMES[day2[unit][1] - 1] + ",";
			line = line + SLOT_NAMES[day3[unit][1] - 1] + ",";
			line = line + SLOT_NAMES[day4[unit][1] - 1] + ",";
			line = line + SLOT_NAMES[day5[unit][1] - 1] + ",";
			line = line + SLOT_NAMES[day6[unit][1] - 1] + ",";
			line = line + SLOT_NAMES[day7[unit][1] - 1] + ",";
			System.out.println(line);

		}
	}

	/**
	 * Use for testing
	 * 
	 * @param day
	 * 
	 */
	private static void printData(Integer[][] day) {
		for (int slot = 1; slot <= TOTAL_SLOTS; slot++) { // 20
			for (int flat = 1; flat <= TOTAL_APARTMENTS / TOTAL_SLOTS; flat++) { // 36
				System.out.println(day[slot - 1][flat - 1] + ";" + slot);
			}
		}
	}

	/**
	 * Fills the shuffled apartments into slots.
	 * 
	 * TODO Parameterize constants later.
	 * 
	 * @param day
	 * @param g1  - Group 1 Apartments
	 * @param g2  - Group 2 Apartments
	 * @param g3  - Group 3 Apartments
	 * @param g4  - Group 4 Apartments
	 */
	private static void prepareDay(Integer[][] day, Integer[] g1, Integer[] g2, Integer[] g3, Integer[] g4) {

		// Shuffling second time
		g1 = shuffle(g1);
		g2 = shuffle(g2);
		g3 = shuffle(g3);
		g4 = shuffle(g4);

		int group = 0;
		for (int slot = 1; slot <= 5; slot++) {
			for (int flat = 1; flat <= 36; flat++) {
				day[slot - 1][flat - 1] = g1[group++];
			}
		}

		group = 0;
		for (int slot = 6; slot <= 10; slot++) {
			for (int flat = 1; flat <= 36; flat++) {
				day[slot - 1][flat - 1] = g2[group++];
			}
		}

		group = 0;
		for (int slot = 11; slot <= 15; slot++) {
			for (int flat = 1; flat <= 36; flat++) {
				day[slot - 1][flat - 1] = g3[group++];
			}
		}

		group = 0;
		for (int slot = 16; slot <= 20; slot++) {
			for (int flat = 1; flat <= 36; flat++) {
				day[slot - 1][flat - 1] = g4[group++];
			}
		}

	}

	/**
	 * Shuffles array of integers.
	 * 
	 * @param group
	 * @return
	 */
	private static Integer[] shuffle(Integer[] group) {
		List<Integer> intList = Arrays.asList(group);
		Collections.shuffle(intList);
		intList.toArray(group);
		group = intList.toArray(group);
		return group;
	}

	/**
	 * Prepares random list of apartments and putting them into 4 groups. This is
	 * first shuffle
	 * 
	 * TODO parameterize later
	 */
	private static void prepareApartmentsList() {
		for (int i = 1; i <= 720; i++) {
			apartments[i - 1] = Integer.valueOf(i);
		}
		List<Integer> intList = Arrays.asList(apartments);
		Collections.shuffle(intList);
		intList.toArray(apartments);
		apartments = intList.toArray(apartments);

		for (int i = 1; i <= 180; i++) {
			apartments_g1[i - 1] = apartments[i - 1];
		}

		for (int i = 181; i <= 360; i++) {
			apartments_g2[i - 181] = apartments[i - 1];
		}

		for (int i = 361; i <= 540; i++) {
			apartments_g3[i - 361] = apartments[i - 1];
		}

		for (int i = 541; i <= 720; i++) {
			apartments_g4[i - 541] = apartments[i - 1];
		}

	}

	public static final String[] SLOT_NAMES = { "7 to 7:30 AM", "7:30 to 8 AM", "8 to 8:30 AM", "8:30 to 9 AM",
			"9 to 9:30 AM", "9:30 to 10 AM", "10 to 10:30 AM", "10:30 to 11 AM", "11 to 11:30 AM", "11:30 to 12 PM",
			"12 to 12:30 PM", "12:30 to 1 PM", "1 to 1:30 PM", "1:30 to 2 PM", "2 to 2:30 PM", "2:30 to 3 PM",
			"3 to 3:30 PM", "3:30 to 4 PM", "4 to 4:30 PM", "4:30 to 5 PM" };

	public static final String[] APT_NAMES = { "A G1", "A G2", "A G3", "A G4", "A 101", "A 102", "A 103", "A 104",
			"A 201", "A 202", "A 203", "A 204", "A 301", "A 302", "A 303", "A 304", "A 401", "A 402", "A 403", "A 404",
			"A 501", "A 502", "A 503", "A 504", "A 601", "A 602", "A 603", "A 604", "A 701", "A 702", "A 703", "A 704",
			"A 801", "A 802", "A 803", "A 804", "A 901", "A 902", "A 903", "A 904", "A 1001", "A 1002", "A 1003",
			"A 1004", "A 1101", "A 1102", "A 1103", "A 1104", "A 1201", "A 1202", "A 1203", "A 1204", "A 1301",
			"A 1302", "A 1303", "A 1304", "A 1401", "A 1402", "A 1403", "A 1404", "A 1501", "A 1502", "A 1503",
			"A 1504", "A 1601", "A 1602", "A 1603", "A 1604", "A 1701", "A 1702", "A 1703", "A 1704", "A 1801",
			"A 1802", "A 1803", "A 1804", "A 1901", "A 1902", "A 1903", "A 1904", "B G1", "B G2", "B G3", "B G4",
			"B 101", "B 102", "B 103", "B 104", "B 201", "B 202", "B 203", "B 204", "B 301", "B 302", "B 303", "B 304",
			"B 401", "B 402", "B 403", "B 404", "B 501", "B 502", "B 503", "B 504", "B 601", "B 602", "B 603", "B 604",
			"B 701", "B 702", "B 703", "B 704", "B 801", "B 802", "B 803", "B 804", "B 901", "B 902", "B 903", "B 904",
			"B 1001", "B 1002", "B 1003", "B 1004", "B 1101", "B 1102", "B 1103", "B 1104", "B 1201", "B 1202",
			"B 1203", "B 1204", "B 1301", "B 1302", "B 1303", "B 1304", "B 1401", "B 1402", "B 1403", "B 1404",
			"B 1501", "B 1502", "B 1503", "B 1504", "B 1601", "B 1602", "B 1603", "B 1604", "B 1701", "B 1702",
			"B 1703", "B 1704", "B 1801", "B 1802", "B 1803", "B 1804", "B 1901", "B 1902", "B 1903", "B 1904", "C G1",
			"C G2", "C G3", "C G4", "C 101", "C 102", "C 103", "C 104", "C 201", "C 202", "C 203", "C 204", "C 301",
			"C 302", "C 303", "C 304", "C 401", "C 402", "C 403", "C 404", "C 501", "C 502", "C 503", "C 504", "C 601",
			"C 602", "C 603", "C 604", "C 701", "C 702", "C 703", "C 704", "C 801", "C 802", "C 803", "C 804", "C 901",
			"C 902", "C 903", "C 904", "C 1001", "C 1002", "C 1003", "C 1004", "C 1101", "C 1102", "C 1103", "C 1104",
			"C 1201", "C 1202", "C 1203", "C 1204", "C 1301", "C 1302", "C 1303", "C 1304", "C 1401", "C 1402",
			"C 1403", "C 1404", "C 1501", "C 1502", "C 1503", "C 1504", "C 1601", "C 1602", "C 1603", "C 1604",
			"C 1701", "C 1702", "C 1703", "C 1704", "C 1801", "C 1802", "C 1803", "C 1804", "C 1901", "C 1902",
			"C 1903", "C 1904", "D G1", "D G2", "D G3", "D G4", "D 101", "D 102", "D 103", "D 104", "D 201", "D 202",
			"D 203", "D 204", "D 301", "D 302", "D 303", "D 304", "D 401", "D 402", "D 403", "D 404", "D 501", "D 502",
			"D 503", "D 504", "D 601", "D 602", "D 603", "D 604", "D 701", "D 702", "D 703", "D 704", "D 801", "D 802",
			"D 803", "D 804", "D 901", "D 902", "D 903", "D 904", "D 1001", "D 1002", "D 1003", "D 1004", "D 1101",
			"D 1102", "D 1103", "D 1104", "D 1201", "D 1202", "D 1203", "D 1204", "D 1301", "D 1302", "D 1303",
			"D 1304", "D 1401", "D 1402", "D 1403", "D 1404", "D 1501", "D 1502", "D 1503", "D 1504", "D 1601",
			"D 1602", "D 1603", "D 1604", "D 1701", "D 1702", "D 1703", "D 1704", "D 1801", "D 1802", "D 1803",
			"D 1804", "D 1901", "D 1902", "D 1903", "D 1904", "E G1", "E G2", "E G3", "E G4", "E 101", "E 102", "E 103",
			"E 104", "E 201", "E 202", "E 203", "E 204", "E 301", "E 302", "E 303", "E 304", "E 401", "E 402", "E 403",
			"E 404", "E 501", "E 502", "E 503", "E 504", "E 601", "E 602", "E 603", "E 604", "E 701", "E 702", "E 703",
			"E 704", "E 801", "E 802", "E 803", "E 804", "E 901", "E 902", "E 903", "E 904", "E 1001", "E 1002",
			"E 1003", "E 1004", "E 1101", "E 1102", "E 1103", "E 1104", "E 1201", "E 1202", "E 1203", "E 1204",
			"E 1301", "E 1302", "E 1303", "E 1304", "E 1401", "E 1402", "E 1403", "E 1404", "E 1501", "E 1502",
			"E 1503", "E 1504", "E 1601", "E 1602", "E 1603", "E 1604", "E 1701", "E 1702", "E 1703", "E 1704",
			"E 1801", "E 1802", "E 1803", "E 1804", "E 1901", "E 1902", "E 1903", "E 1904", "F G1", "F G2", "F G3",
			"F G4", "F 101", "F 102", "F 103", "F 104", "F 201", "F 202", "F 203", "F 204", "F 301", "F 302", "F 303",
			"F 304", "F 401", "F 402", "F 403", "F 404", "F 501", "F 502", "F 503", "F 504", "F 601", "F 602", "F 603",
			"F 604", "F 701", "F 702", "F 703", "F 704", "F 801", "F 802", "F 803", "F 804", "F 901", "F 902", "F 903",
			"F 904", "F 1001", "F 1002", "F 1003", "F 1004", "F 1101", "F 1102", "F 1103", "F 1104", "F 1201", "F 1202",
			"F 1203", "F 1204", "F 1301", "F 1302", "F 1303", "F 1304", "F 1401", "F 1402", "F 1403", "F 1404",
			"F 1501", "F 1502", "F 1503", "F 1504", "F 1601", "F 1602", "F 1603", "F 1604", "F 1701", "F 1702",
			"F 1703", "F 1704", "F 1801", "F 1802", "F 1803", "F 1804", "F 1901", "F 1902", "F 1903", "F 1904", "G G1",
			"G G2", "G G3", "G G4", "G 101", "G 102", "G 103", "G 104", "G 201", "G 202", "G 203", "G 204", "G 301",
			"G 302", "G 303", "G 304", "G 401", "G 402", "G 403", "G 404", "G 501", "G 502", "G 503", "G 504", "G 601",
			"G 602", "G 603", "G 604", "G 701", "G 702", "G 703", "G 704", "G 801", "G 802", "G 803", "G 804", "G 901",
			"G 902", "G 903", "G 904", "G 1001", "G 1002", "G 1003", "G 1004", "G 1101", "G 1102", "G 1103", "G 1104",
			"G 1201", "G 1202", "G 1203", "G 1204", "G 1301", "G 1302", "G 1303", "G 1304", "G 1401", "G 1402",
			"G 1403", "G 1404", "G 1501", "G 1502", "G 1503", "G 1504", "G 1601", "G 1602", "G 1603", "G 1604",
			"G 1701", "G 1702", "G 1703", "G 1704", "G 1801", "G 1802", "G 1803", "G 1804", "G 1901", "G 1902",
			"G 1903", "G 1904", "H G1", "H G2", "H G3", "H G4", "H 101", "H 102", "H 103", "H 104", "H 201", "H 202",
			"H 203", "H 204", "H 301", "H 302", "H 303", "H 304", "H 401", "H 402", "H 403", "H 404", "H 501", "H 502",
			"H 503", "H 504", "H 601", "H 602", "H 603", "H 604", "H 701", "H 702", "H 703", "H 704", "H 801", "H 802",
			"H 803", "H 804", "H 901", "H 902", "H 903", "H 904", "H 1001", "H 1002", "H 1003", "H 1004", "H 1101",
			"H 1102", "H 1103", "H 1104", "H 1201", "H 1202", "H 1203", "H 1204", "H 1301", "H 1302", "H 1303",
			"H 1304", "H 1401", "H 1402", "H 1403", "H 1404", "H 1501", "H 1502", "H 1503", "H 1504", "H 1601",
			"H 1602", "H 1603", "H 1604", "H 1701", "H 1702", "H 1703", "H 1704", "H 1801", "H 1802", "H 1803",
			"H 1804", "H 1901", "H 1902", "H 1903", "H 1904", "I G1", "I G2", "I G3", "I G4", "I 101", "I 102", "I 103",
			"I 104", "I 201", "I 202", "I 203", "I 204", "I 301", "I 302", "I 303", "I 304", "I 401", "I 402", "I 403",
			"I 404", "I 501", "I 502", "I 503", "I 504", "I 601", "I 602", "I 603", "I 604", "I 701", "I 702", "I 703",
			"I 704", "I 801", "I 802", "I 803", "I 804", "I 901", "I 902", "I 903", "I 904", "I 1001", "I 1002",
			"I 1003", "I 1004", "I 1101", "I 1102", "I 1103", "I 1104", "I 1201", "I 1202", "I 1203", "I 1204",
			"I 1301", "I 1302", "I 1303", "I 1304", "I 1401", "I 1402", "I 1403", "I 1404", "I 1501", "I 1502",
			"I 1503", "I 1504", "I 1601", "I 1602", "I 1603", "I 1604", "I 1701", "I 1702", "I 1703", "I 1704",
			"I 1801", "I 1802", "I 1803", "I 1804", "I 1901", "I 1902", "I 1903", "I 1904" };

}
