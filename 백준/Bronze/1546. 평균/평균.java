import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt(); // N 입력
        int[] arr = new int[count];
        int max = 0;
        int total = 0;
        double avg = 0.0;

        for (int i = 0; i < count; i++) {// 점수 입력(정수 배열) + 최댓값 탐색 + 총합 계산(평균 계산을 위해)
            arr[i] = sc.nextInt();
            if (arr[i] > max) {
                max = arr[i];
            }
            total += arr[i];
        }
        
        avg = ((double) total / count) / max * 100; // 수정 후 평균 = (평균/최댓값) * 100
        
        System.out.println(avg);

        sc.close();
    }
}
