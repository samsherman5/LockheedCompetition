import java.util.Scanner;

public class Calculator {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int iterations = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < iterations; i++) {
			String line = scan.nextLine();
			String[] tokens = line.split(" ");
			int num1I = Integer.parseInt(tokens[0]);
			int num2I = Integer.parseInt(tokens[2]);
			double num1 = (double) num1I;
			double num2 = (double) num2I;
			String operator = tokens[1];
			switch(operator){
				case "+":
					System.out.println(round(num1 + num2) + " " + round(num1 + num2));
					break;
				case "-":
					System.out.println(round(num1 - num2) + " " + round(num2 - num1));
					break;
				case "*":
					System.out.println(round(num1 * num2) + " " + round(num1 * num2));
					break;
				case "/":
					System.out.println(round(num1 / num2) + " " + round(num2/num1));
					break;
			}
		}
	}

	// round to 1 decimal place
	public static double round(double num) {
		return Math.round(num * 10.0) / 10.0;
	}
}
