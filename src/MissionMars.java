import java.util.Scanner;

public class MissionMars {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int iterations = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < iterations; i++) {
			String[] line = scan.nextLine().split(" ");
			double distance = Double.parseDouble(line[0])*1000000;
			double speed = Double.parseDouble(line[1]);
			double timeHours = distance / speed;
			double days = timeHours / 24;
			double minutes = (days - (int) days) * 24 * 60;
			double seconds = (minutes - (int) minutes) * 60;
			System.out.println("Time to Mars: " + (int) days + "days, " + (int) timeHours + "hours, " + (int) minutes + "minutes, " + (int) seconds + "seconds");

		}
	}
}
