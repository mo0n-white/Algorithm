/*
008. '좋은 수' 구하기
- [프로그래머스] 연속된 부분 수열의 합
2026.09.19
*/

// 투 포인터 left, right 선언 = 0
// 누적 합 sArr 선언
// sArr[i] = sArr[i-1] + sequence[i]
// int answer[2] 선언

// sArr[right] - sArr[left-1] 와 k 비교 ( left > right 이나 right > sequence.length 이면 종료 )
// 1. sArr[right] - sArr[left-1] < k 
//   right++
// 2. sArr[right] - sArr[left-1] > k
//   left++
// 3. sArr[right] - sArr[left-1] == k
// if(answer[0] == 0 && answer[1] == 0) {
//   answer[0] = left, answer[1] = right
// else if(answer[1] - answer[0] > right - left) {
//   answer[0] = left, answer[1] = right
//   left++, right++

import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 1, right = 1; // 투 포인터 left, right 선언 = 0
        int[] sArr = new int[sequence.length + 1]; // 누적 합 sArr 선언
        sArr[0] = 0;
        for(int i=1; i<sequence.length+1; i++) {    // sArr[i] = sArr[i-1] + sequence[i]
            sArr[i] = sArr[i-1] + sequence[i-1];
        }
        int[] answer = new int[]{-1, -1};    // int answer[2] 선언
            
        while(right <= sequence.length && left <= right) {    // sArr[right] - sArr[left-1] 와 k 비교 ( left > right 이나 right > sequence.length 이면 종료 )
            if(sArr[right] - sArr[left-1] < k) {    // 1. sArr[right] - sArr[left-1] < k 
                right++; //   right++
            } else if(sArr[right] - sArr[left-1] > k) { // 2. sArr[right] - sArr[left-1] > k
                left++;//   left++
            } else {    // 3. sArr[right] - sArr[left-1] == k
                if(answer[0] == -1 && answer[1] == -1) {    // if(answer[0] == -1 && answer[1] == -1)
                    answer[0] = left-1;   //   answer[0] = left, answer[1] = right
                    answer[1] = right-1;
                    left++; right++;
                } else if(answer[1] - answer[0] > right - left) {
                    answer[0] = left-1;   //   answer[0] = left, answer[1] = right
                    answer[1] = right-1;
                    left++; right++;   //   left++, right++
                } else {
                    left++; right++;   //   left++, right++
                }
            }
        }
        return answer;
    }
}