import java.util.Scanner;

public class DependOnMe {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int iterations = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < iterations; i++) {
            String[] input = scan.nextLine().split(" ");
            int dependencies = Integer.parseInt(input[0]);
            int errors = Integer.parseInt(input[1]);
            for (int j = 0; j < dependencies; j++) {
                String[] dependency = scan.nextLine().split(" ");
                String parent = dependency[0];
                String child = dependency[1];

            }
            for (int j = 0; j < errors; j++) {

            }
        }
    }
}
//create tree node
class TreeNode {
    String name;
    TreeNode parent;
    TreeNode child;
    TreeNode(String name) {
        this.name = name;
    }
}
