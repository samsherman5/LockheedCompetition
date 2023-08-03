import java.util.Scanner;

public class TicTacToe {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int iterations = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < iterations; i++) {
			String boardLine = scan.nextLine();
			int[][] board = new int[3][3];
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					if(boardLine.charAt(j*3+k) == 'X') {
						board[j][k] = 1;
					} else if(boardLine.charAt(j*3+k) == 'O') {
						board[j][k] = 2;
					} else {
						board[j][k] = 0;
					}
				}
			}
			int winner = 0;
			for (int j = 0; j < 3; j++) {
				int rowsum = 0;
				int colsum = 0;
				for (int k = 0; k < 3; k++) {
					rowsum += board[j][k];
					colsum += board[k][j];
				}
				if(rowsum==3){
					winner = 1;
				} else if(rowsum==6){
					winner = 2;
				}

				if(colsum==3){
					winner = 1;
				} else if(colsum==6){
					winner = 2;
				}
			}
			int diagsum = 0;
			int diagsum2 = 0;
			for (int j = 0; j < 3; j++) {
				diagsum += board[j][j];
				diagsum2 += board[j][2-j];
			}
			if(diagsum==3){
				winner = 1;
			} else if(diagsum==6){
				winner = 2;
			}
			if(diagsum2==3){
				winner = 1;
			} else if(diagsum2==6){
				winner = 2;
			}

			if(winner==0){
				System.out.println(boardLine + " = TIE");
			}
			if(winner==1){
				System.out.println(boardLine + " = X WINS");
			}
			if(winner==2){
				System.out.println(boardLine + " = O WINS");
			}
		}
	}
}
