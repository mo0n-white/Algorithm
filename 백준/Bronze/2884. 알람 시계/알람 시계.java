import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int timeH, timeM = 0;
        int changeH, changeM = 0;

        Scanner scanner = new Scanner(System.in);

        timeH = scanner.nextInt();
        timeM = scanner.nextInt();

        if(timeM >= 45) {
            changeH = timeH;
            changeM = timeM-45;
        }
        else {
            changeM = 60 - (45-timeM);
            changeH = (timeH == 0)? 23 : timeH-1;
        }

        System.out.printf("%d %d", changeH, changeM);
    }
}
