import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arrCount = sc.nextInt();
        
        int[] numArr = new int[arrCount];
        int i, j;
        int maxIndex;

        for(i=0; i<arrCount; i++) { // 변수를 배열에 입력
            numArr[i] = sc.nextInt();
        }

        for(i=0; i<arrCount-1; i++) { // 선택 정렬(최댓값을 swap)
            maxIndex = 0;
            for(j=1; j<arrCount-i; j++) {
                maxIndex = (numArr[maxIndex] > numArr[j])? maxIndex : j; // 최댓값 찾기
            }
            swap(numArr, arrCount-1-i, maxIndex); // swap
        }

        for(int k:numArr) { // 출력
            System.out.println(k);
        }
        
        sc.close();
    }

    public static void swap(int[] numArr, int index1, int index2) {
        int temp = numArr[index1];

        numArr[index1] = numArr[index2];
        numArr[index2] = temp;
    }
}