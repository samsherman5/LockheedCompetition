import java.util.Scanner;

/*
The first line contains an integer 𝑛
 — the number of matches played by the team (1≤𝑛≤100
). The second line contains an integer 𝑎
 — the total number of goals scored by the team in all 𝑛
 matches (0≤𝑎≤1000
). The third line contains an integer 𝑏
 — the total number of goals conceded by the team in all 𝑛
 matches (0≤𝑏≤1000
).
 */
/*
In the first line, print a single integer 𝑑
 — the minimum number of draws.

In the following 𝑛
 lines, print a list of match scores, each line in the format "𝑥
:𝑦
", where 𝑥
 is the number of goals scored in the match, and 𝑦
 – the number of goals conceded, so that exactly 𝑑
 of these matches have ended in a draw. In case multiple such lists of match scores exist, print any of them.
 */

public class Football {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		int totalGoals = Integer.parseInt(scan.nextLine());
		int totalConcededGoals = Integer.parseInt(scan.nextLine());
		//create code to solve:
		//in n matches, distribute goals and conceded so that there is a maximum number of draws
		//print the number of draws and the scores of the matches

		//find the number of draws - must use all totalGoals and totalConcededGoals
		if(totalGoals/n==0){

		}
		for (int i = 0; i < n; i++) {

		}
		//System.out.println(draws);
	}
}
