import java.util.Scanner;

public class FibonacciSum {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int iterations = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < iterations; i++) {
			int num = Integer.parseInt(scan.nextLine());
			//Determine a sequence of fibonacci numbers that add up to num
			int[] fib = new int[100];
			fib[0] = 1;
			fib[1] = 1;
			int fibindex = 1;
			while(fib[fibindex] < num){
				fibindex++;
				fib[fibindex] = fib[fibindex-1] + fib[fibindex-2];
			}
			//Print the sequence
			String output = "";
			while(num > 0){
				if(fib[fibindex] <= num){
					output += fib[fibindex] + " ";
					num -= fib[fibindex];
				}
				fibindex--;
			}
			System.out.println(output);
		}
	}
}
