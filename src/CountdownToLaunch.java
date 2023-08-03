import java.util.Scanner;

public class CountdownToLaunch {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int iterations = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < iterations; i++) {
			int windows = Integer.parseInt(scan.nextLine());
			boolean launched = false;
			WeatherDay[] weather = new WeatherDay[windows];
			for (int j = 0; j < windows; j++) {
				weather[j] = new WeatherDay(scan.nextLine());
			}
			for (int j = 0; j < windows && !launched; j++) {
				if(weather[j].launchable()){
					System.out.println(weather[j].TimeData);
					launched = true;
				}
			}
			if(!launched)
				System.out.println("ABORT LAUNCH");
		}
	}
}

class WeatherDay{
	String TimeData;

	int cloudCover;
	double windSpeed;
	int windDirection;

	public WeatherDay(String data){
		String[] line = data.split(" ");
		TimeData = line[0] + " " + line[1];
		cloudCover = Integer.parseInt(line[2]);
		windSpeed = Double.parseDouble(line[3]);
		windDirection = Integer.parseInt(line[4]);
	}

	public boolean launchable(){
		if(cloudCover>1000){
			return false;
		}
		//check if the speed * the sin of the angle is greater than 40
		//check if the speed * the cos of the angle is greater than 20
		if(windSpeed*Math.sin(Math.toRadians(windDirection))>40){
			return false;
		}
		if(windSpeed*Math.cos(Math.toRadians(windDirection))>20){
			return false;
		}

		return true;
	}
}
