import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AroundTheTown {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int iterations = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < iterations; i++) {
			String[] line = scan.nextLine().split(" ");
			int numLandmarks = Integer.parseInt(line[0]);
			int numStops = Integer.parseInt(line[1]);
			List<Landmark> landmarks = new ArrayList<Landmark>();
			double[][] stops = new double[numStops][2];
			for (int j = 0; j < numLandmarks; j++) {
				String[] landmarkLine = scan.nextLine().split(" ");
				landmarks.add(new Landmark(Integer.parseInt(landmarkLine[0]), Integer.parseInt(landmarkLine[1])));
			}
			for (int j = 0; j < numStops; j++) {
				String[] stopLine = scan.nextLine().split(" ");
				stops[j][0] = Integer.parseInt(stopLine[0]);
				stops[j][1] = Integer.parseInt(stopLine[1]);
			}
			while(true){
				for (Landmark landmark : landmarks) {
					int lowestStop = 0;
					for (int k = 0; k < numStops; k++) {
						if (distance(landmark, stops[k][0], stops[k][1]) < distance(landmark, stops[lowestStop][0], stops[lowestStop][1])) {
							lowestStop = k;
						} else if(distance(landmark, stops[k][0], stops[k][1]) == distance(landmark, stops[lowestStop][0], stops[lowestStop][1])) {
							if(stops[k][0] < stops[lowestStop][0]){
								lowestStop = k;
							} else if(stops[k][1] < stops[lowestStop][1]) {
								lowestStop = k;
							}
						}
					}
					landmark.clusterNum = lowestStop;
				}
				boolean isMoved = false;
				for (int j = 0; j < numStops; j++) {
					int xTotal = 0;
					int yTotal = 0;
					int count = 0;
					for (int k = 0; k < numLandmarks; k++) {
						if(landmarks.get(k).clusterNum==j){
							xTotal+=landmarks.get(k).x;
							yTotal+=landmarks.get(k).y;
							count++;
						}
					}
					double xAvg = xTotal*1.0/count;
					double yAvg = yTotal*1.0/count;


					if(xAvg != stops[j][0] || yAvg != stops[j][1]){
						stops[j][0] = xAvg;
						stops[j][1] = yAvg;
						isMoved = true;
					}
				}
				if(!isMoved){
					break;
				}
			}
			for (int j = 0; j < numStops; j++) {
				System.out.println(roundToNearestTenths(stops[j][0]) + " " + roundToNearestTenths(stops[j][1]));
			}
		}
	}
	public static double distance(Landmark lm, double x, double y){
		return Math.sqrt(Math.pow(lm.x-x, 2) + Math.pow(lm.y-y, 2));
	}

	public static double roundToNearestTenths(double number) {
		double powerOfTen = 10;
		double exp = number * powerOfTen;
		double remainder = Math.abs(exp) - Math.floor(Math.abs(exp));
		if (remainder >= 0.5) {
			if (exp > 0.0) {
				exp += 1.0;
			} else {
				exp -= 1.0;
			}
		}
		return ((int)exp)/powerOfTen;
	}
}

class Landmark{
	int x;
	int y;
	int clusterNum;

	public Landmark(int x, int y){
		this.x = x;
		this.y = y;
		this.clusterNum = -1;
	}

	@Override
	public String toString() {
		return "Landmark{" +
				"x=" + x +
				", y=" + y +
				", clusterNum=" + clusterNum +
				'}';
	}
}
