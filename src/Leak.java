import java.util.Scanner;

public class Leak {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int iterations = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < iterations; i++) {
            String[] line = scan.nextLine().split(" ");
            int volume = Integer.parseInt(line[0]);
            int enter = Integer.parseInt(line[1]);
            int exit = Integer.parseInt(line[2]);
            long answer = Math.round(volume/(enter*1.0-exit) * exit);
            System.out.println(answer);
        }
    }
}
