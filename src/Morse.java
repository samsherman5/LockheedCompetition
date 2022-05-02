import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Morse {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int iterations = Integer.parseInt(scan.nextLine());
        ArrayList<Character> alphabet = new ArrayList<Character>(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'));
        for (int i = 0; i < iterations; i++) {
            String[] morse = new String[26];
            HashMap<String, String> morseToAlphabet = new HashMap<String, String>();
            for (int j = 0; j < 26; j++) {
                String morsed = scan.nextLine().substring(2);
                morse[j] = morsed;
                morseToAlphabet.put(morsed, alphabet.get(j).toString());
            }
            String rawinput[] = scan.nextLine().split(" ");
            //loop through characters in rawinput
            String encodedoutput = ""; 
            for (int j = 0; j < rawinput.length; j++) {
                for (int k = 0; k < rawinput[j].length(); k++) {
                    encodedoutput += morse[alphabet.indexOf(rawinput[j].charAt(k))];
                    if(k != rawinput[j].length()-1) {
                        encodedoutput += "   ";
                    }
                }
                encodedoutput += "       ";
            }
            System.out.println(encodedoutput.trim());
            String[] encodedinput = scan.nextLine().split("       ");
            String decodedoutput = "";
            for (int j = 0; j < encodedinput.length; j++) {
                String[] currentword = encodedinput[j].split("   ");
                for (int k = 0; k < currentword.length; k++) {
                    decodedoutput += morseToAlphabet.get(currentword[k]);
                }
                decodedoutput+=" ";
            }
            System.out.println(decodedoutput.trim());
        }
    }
}
