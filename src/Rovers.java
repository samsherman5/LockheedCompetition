import java.util.Scanner;

public class Rovers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int iterations = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < iterations; i++) {
            String[] input = scan.nextLine().split(" ");
            //diameter of wheel (cm)
            double diameter = Integer.parseInt(input[0]);
            //number of motor revolutions in one wheel rotation
            double motorRevolutions = Integer.parseInt(input[1]);
            //power required to complete one motor revolution (W)
            double power = Integer.parseInt(input[2]);
            //Speed of motor in revolutions per minute
            double motorSpeed = Integer.parseInt(input[3]);
            //power capacity of the rover ampere hours
            double powerCapacity = Integer.parseInt(input[4]);
            //Voltage requirement of the motor
            double voltage = Integer.parseInt(input[5]);
            //Distance the rover has to travel (m)
            double distance = Integer.parseInt(input[6]);

            double circumference = diameter * Math.PI;
            double distanceInCentimeters = distance * 100;
            double rotations = distanceInCentimeters / circumference;
            double revolutions = rotations * motorRevolutions;
            double time = revolutions / motorSpeed;
            double powerRequired = revolutions * power;
            double amps = powerRequired / voltage;
            double ampereMinutes = amps * time;
            double ampereHours = ampereMinutes / 60;

            //round time to 4 deciaml places
            double roundedTime = Math.round(time * 10000.0) / 10000.0;
            if(ampereHours > powerCapacity){
                System.out.println("Fail");
            } else {
                System.out.println("Success " + roundedTime);
            }
        }
    }
}
