import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ship {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int iterations = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < iterations; i++) {
            String[] line = scan.nextLine().split(" ");
            int expected = Integer.parseInt(line[0]);
            int actual = Integer.parseInt(line[1]);
            ArrayList<String> expectedlist = new ArrayList<>();
            ArrayList<String> actuallist = new ArrayList<>();
            for (int j = 0; j < expected; j++) {
                expectedlist.add(scan.nextLine());
            }
            for (int j = 0; j < actual; j++) {
                actuallist.add(scan.nextLine());
            }
            //create arraylist of values in expectedlist but not in actuallist
            ArrayList<String> missing = new ArrayList<>();
            for (int j = 0; j < expected; j++) {
                if (!actuallist.contains(expectedlist.get(j))) {
                    missing.add(expectedlist.get(j));
                }
            }
            Collections.sort(missing);
            for (int j = 0; j < missing.size(); j++) {
                System.out.println(missing.get(j));
            }
        }
    }
}
