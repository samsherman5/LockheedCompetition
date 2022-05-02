import java.util.Scanner;

public class SelfDriving {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int iterations = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < iterations; i++) {
            String line = scan.nextLine();
            String[] tokens = line.split(":");
            double speed = Double.parseDouble(tokens[0]);
            double distance = Double.parseDouble(tokens[1]);
            double time = distance/ speed;
            if(time <= 1.0) {
                System.out.println("SWERVE");
            } else if(time <= 5.0) {
                System.out.println("BRAKE");
            } else {
                System.out.println("SAFE");
            }
        }
    }


}
