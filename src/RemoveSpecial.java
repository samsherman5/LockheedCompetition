import java.util.Scanner;

public class RemoveSpecial {
    public static void main(String[] args) {
        Scanner scan =  new Scanner(System.in);
        int iterations = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < iterations; i++) {
            System.out.println(removeSpecial(scan.nextLine()));
        }
    }
    // Remove all characters except letters, spaces, and digits.
    public static String removeSpecial(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLetterOrDigit(c) || c == ' ') {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
