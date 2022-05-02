import java.util.Scanner;

public class Sensors {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int iterations = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < iterations; i++) {
            int numsensors = Integer.parseInt(scan.nextLine());
            String[] sensors = scan.nextLine().split(" ");
            int temp = 0;
            while(numsensors > 0){
                temp += numsensors;
                numsensors--;
            }
            //subtract all numbers in sensors from temp
            for (int j = 0; j < sensors.length; j++) {
                temp -= Integer.parseInt(sensors[j]);
            }
            System.out.println(temp);
        }
    }
}
