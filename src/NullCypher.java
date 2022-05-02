import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class NullCypher {
    public static void main(String[] args) {
        ArrayList<Character> vowels = new ArrayList<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        Scanner scan = new Scanner(System.in);
        int iterations = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < iterations; i++) {
            String encoded = scan.nextLine();
            String solution = "";
            for(int index = 0; index < encoded.length(); index++) {
                if(vowels.contains(encoded.charAt(index))) {
                    if(index == encoded.length() - 1) {
                        continue;
                    }
                    if(encoded.charAt(index)==encoded.charAt(index+1)){
                        index++;
                        continue;
                    }
                    solution += encoded.charAt(index+1);
                    index++;
                }
            }
            System.out.println(solution);
        }
    }
}
