import java.util.Scanner;

public class Minecraft {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] line = scan.nextLine().split(" ");
		int columns = Integer.parseInt(line[0]);
		int quests = Integer.parseInt(line[1]);
		String[] worldLine = scan.nextLine().split(" ");
		int[] world = new int[columns];
		for (int i = 0; i < columns; i++) {
			world[i] = Integer.parseInt(worldLine[i]);
		}
		//print world array
		for (int i = 0; i < quests; i++) {
			String[] questLine = scan.nextLine().split(" ");
			int start = Integer.parseInt(questLine[0])-1;
			int end = Integer.parseInt(questLine[1])-1;
			int totalDamage = 0;
			if(start > end){
				for (int j = end; j < start; j++) {
					if(world[j+1] > world[j]) {
						totalDamage += world[j+1] - world[j];
					}
				}
			} else {
				for (int j = start; j < end; j++) {
					if(world[j+1] < world[j]) {
						totalDamage += world[j] - world[j+1];
					}
				}
			}
			System.out.println(totalDamage);
		}
	}
}
