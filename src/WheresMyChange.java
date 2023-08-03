import java.util.Scanner;

public class WheresMyChange {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int iterations = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < iterations; i++) {
			double total = Double.parseDouble(scan.nextLine());
			int[] denominations = new int[11];
			while(total/100 >= 1) {
				denominations[0]++;
				total -= 100;
				total = round(total);
			}
			while(total/50 >= 1) {
				denominations[1]++;
				total -= 50;
				total = round(total);
			}
			while(total/20 >= 1) {
				denominations[2]++;
				total -= 20;
				total = round(total);
			}
			while(total/10 >= 1) {
				denominations[3]++;
				total -= 10;
				total = round(total);
			}
			while(total/5 >= 1) {
				denominations[4]++;
				total -= 5;
				total = round(total);
			}
			while(total/2 >= 1) {
				denominations[5]++;
				total -= 2;
				total = round(total);
			}
			while(total >= 1) {
				denominations[6]++;
				total -= 1;
				total = round(total);
			}
			while(total/0.25 >= 1) {
				denominations[7]++;
				total -= 0.25;
				total = round(total);
			}
			while(total/0.1 >= 1) {
				denominations[8]++;
				total -= 0.1;
				total = round(total);
			}
			while(total/0.05 >= 1) {
				denominations[9]++;
				total -= 0.05;
				total = round(total);
			}
			while(total/0.01 >= 1) {
				denominations[10]++;
				total -= 0.01;
				total = round(total);
			}
			for (int j = 0; j < 11; j++) {
				System.out.print(denominations[j]);
			}
			System.out.println();
		}
	}

	public static double round(double number){
		//round to nearest hundredth
		return Math.round(number * 100.0) / 100.0;
	}
}
