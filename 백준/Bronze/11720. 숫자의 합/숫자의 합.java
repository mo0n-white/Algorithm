import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] arr = new int[count];
        int total = 0;

        String numList = sc.next();

        for (int i = 0; i < count; i++) {
            arr[i] = numList.charAt(i) - '0';
            total += arr[i];
        }

        System.out.println(total);

        sc.close();
    }
}