import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        for(int i=1; i<num+1; i++) {
            for(int j=num-i; j>0; j--) {
                System.out.print(' ');
            }
            for(int k=0; k<i; k++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }
}