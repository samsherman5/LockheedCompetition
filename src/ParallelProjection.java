import java.util.Scanner;
public class ParallelProjection {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int iterations = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < iterations; i++) {
			String[] roomLine = scan.nextLine().split(" ");
			int w = Integer.parseInt(roomLine[0]);
			int d = Integer.parseInt(roomLine[1]);
			int h = Integer.parseInt(roomLine[2]);
			String[] computerLine = scan.nextLine().split(" ");
			int xComputer = Integer.parseInt(computerLine[0]);
			int yComputer = Integer.parseInt(computerLine[1]);
			int xProjector = Integer.parseInt(computerLine[2]);
			int yProjector = Integer.parseInt(computerLine[3]);

			int distance1 = 0;
			distance1+= Math.abs(xProjector-xComputer);
			distance1+=h;
			distance1+= Math.abs(yComputer);
			distance1+=Math.abs(yProjector);

			int distance2 = 0;
			distance2+= Math.abs(xProjector-xComputer);
			distance2+=h;
			distance2+= Math.abs(d-yComputer);
			distance2+=Math.abs(d-yProjector);

			int distance3 = 0;
			distance3+= Math.abs(yProjector-yComputer);
			distance3+=h;
			distance3+= Math.abs(xComputer);
			distance3+=Math.abs(xProjector);

			int distance4 = 0;
			distance4+= Math.abs(yProjector-yComputer);
			distance4+=h;
			distance4+= Math.abs(w-xComputer);
			distance4+=Math.abs(w-xProjector);

			//print the smallest distance
			System.out.println(Math.min(Math.min(distance1, distance2), Math.min(distance3, distance4)));
		}
	}
}
