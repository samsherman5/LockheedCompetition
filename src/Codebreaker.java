import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class Codebreaker {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int iterations = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < iterations; i++) {
            HashMap<String, Integer> digraphToOccurances = new HashMap<>();
            HashMap<String, Integer> trigraphToOccurances = new HashMap<>();
            int lines = Integer.parseInt(scan.nextLine());
            for (int j = 0; j < lines; j++) {
                String line = scan.nextLine().toUpperCase(Locale.ROOT);
                //remove punctuation and numbers from line and leave only letters and spaces
                line = line.replaceAll("[^a-zA-Z ]", "");
                String[] words = line.split(" ");
                for (int k = 0; k < words.length; k++) {
                    //get digraphs in word and add to hashmap
                    for (int l = 0; l < words[k].length() - 1; l++) {
                        String digraph = words[k].substring(l, l + 2);
                        if (digraphToOccurances.containsKey(digraph)) {
                            digraphToOccurances.put(digraph, digraphToOccurances.get(digraph) + 1);
                        }
                        else {
                            digraphToOccurances.put(digraph, 1);
                        }
                    }
                    //get trigraphs in word and add to hashmap
                    for (int l = 0; l < words[k].length() - 2; l++) {
                        String trigraph = words[k].substring(l, l + 3);
                        if (trigraphToOccurances.containsKey(trigraph)) {
                            trigraphToOccurances.put(trigraph, trigraphToOccurances.get(trigraph) + 1);
                        }
                        else {
                            trigraphToOccurances.put(trigraph, 1);
                        }
                    }
                }
            }
            //calcuate all occurances of digraphs
            int digraphscount = 0;
            for (String digraph : digraphToOccurances.keySet()) {
                digraphscount += digraphToOccurances.get(digraph);
            }
            //calculate all occurances of trigraphs
            int trigraphscount = 0;
            for (String trigraph : trigraphToOccurances.keySet()) {
                trigraphscount += trigraphToOccurances.get(trigraph);
            }
            //get digraphs in alphabetical order
            String[] digraphs = digraphToOccurances.keySet().toArray(new String[digraphToOccurances.size()]);
            java.util.Arrays.sort(digraphs);
            for (int j = 0; j < digraphs.length; j++) {
                double relativefrequency = 1.0 * digraphToOccurances.get(digraphs[j])/digraphscount * 100;
                System.out.printf("%s: %.3f%%\n", digraphs[j], relativefrequency);
            }
            //get trigraphs in alphabetical order
            String[] trigraphs = trigraphToOccurances.keySet().toArray(new String[trigraphToOccurances.size()]);
            java.util.Arrays.sort(trigraphs);
            for (int j = 0; j < trigraphs.length; j++) {
                double relativefrequency = 1.0 * trigraphToOccurances.get(trigraphs[j])/trigraphscount * 100;
                //print "trigraph: relativefrequency%" and keep trailing zeroes
                System.out.printf("%s: %.3f%%\n", trigraphs[j], relativefrequency);
            }
        }
    }
}
