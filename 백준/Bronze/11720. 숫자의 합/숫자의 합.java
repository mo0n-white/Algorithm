import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt(); // N값 입력
        int[] arr = new int[count];
        int total = 0;

        String numList = sc.next(); // N자리 수 String으로 저장

        for (int i = 0; i < count; i++) {
            arr[i] = numList.charAt(i) - '0'; // 각 자리수를 char형으로 가져온 후 '0'을 빼서 int로 형 변환
            total += arr[i]; // 누적합
        }

        System.out.println(total);

        sc.close();
    }
}
