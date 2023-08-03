import java.util.Scanner;

public class MatrixRotation {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int iterations = Integer.parseInt(scan.nextLine());
		outer:
		for (int i = 0; i < iterations; i++) {
			String[] line1 = scan.nextLine().split(" ");
			String[] line2 = scan.nextLine().split(" ");
			int[][] matrix = new int[2][2];
			matrix[0][0] = Integer.parseInt(line1[0]);
			matrix[0][1] = Integer.parseInt(line1[1]);
			matrix[1][0] = Integer.parseInt(line2[0]);
			matrix[1][1] = Integer.parseInt(line2[1]);
			for (int j = 0; j < 4; j++) {
				if(matrix[0][0] < matrix[0][1] && matrix[1][0] < matrix[1][1] && matrix[0][0] < matrix[1][0] && matrix[0][1] < matrix[1][1]) {
					System.out.println("YES");
					continue outer;
				}
				matrix = rotate(matrix);
			}
			System.out.println("NO");
			//check if first number in each column is less than the second
			//check if first number in each row is less than the second
		}
	}
	//create method to rotate matrix clockwise 90 degrees
	public static int[][] rotate(int[][] matrix){
		int[][] rotated = new int[2][2];
		rotated[0][0] = matrix[1][0];
		rotated[0][1] = matrix[0][0];
		rotated[1][1] = matrix[0][1];
		rotated[1][0] = matrix[1][1];
		return rotated;
	}
}
