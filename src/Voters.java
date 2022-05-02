import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Voters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int iterations = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < iterations; i++) {
            String[] input = scan.nextLine().split(" ");
            int voters = Integer.parseInt(input[0]);
            int candidates = Integer.parseInt(input[1]);
            String[] ballots = new String[voters];
            for (int j = 0; j < voters; j++) {
                ballots[j] = scan.nextLine();
            }
            int tallies = 1;
            boolean running = true;
            while(running){
                HashMap<Character, Integer> candidateVotes = new HashMap<>();
                for (int j = 0; j < voters; j++) {
                    String vote = ballots[j];
                    char c = vote.charAt(0);
                    if (candidateVotes.containsKey(c)) {
                        candidateVotes.put(c, candidateVotes.get(c) + 1);
                    }
                    else {
                        candidateVotes.put(c, 1);
                    }
                }
                //Find the candidate with the most votes
                int maxVotes = 0;
                char winner = ' ';
                for (char c : candidateVotes.keySet()) {
                    if (candidateVotes.get(c) > maxVotes) {
                        maxVotes = candidateVotes.get(c);
                        winner = c;
                    }
                }
                if(maxVotes > voters/2) {
                    //Print "Candidate winner won with (maxVotes/Voters)*100% of the vote after tallies" including trailing zeroes
                    System.out.printf("Candidate %c won with %.1f%% of the vote after %d tallies\n", winner, ((double)maxVotes/(double)voters)*100, tallies);
                    running = false;
                }
                else {
                    //find the candidate with the least votes
                    int minVotes = Integer.MAX_VALUE;
                    char loser = ' ';
                    for (char c : candidateVotes.keySet()) {
                        if (candidateVotes.get(c) < minVotes) {
                            minVotes = candidateVotes.get(c);
                            loser = c;
                        }
                    }
                    //remove the loser from the ballots
                    //find all candidates with minvotes
                    ArrayList<Character> losers = new ArrayList<>();
                    for (char c : candidateVotes.keySet()) {
                        if (candidateVotes.get(c) == minVotes) {
                            losers.add(c);
                        }
                    }
                    //remove losers from the ballots
                    for (char c : losers) {
                        for (int j = 0; j < voters; j++) {
                            ballots[j] = ballots[j].substring(0,ballots[j].indexOf(loser)) + ballots[j].substring(ballots[j].indexOf(loser)+1);
                        }
                    }
                    tallies++;
                }
            }
        }
    }
}
