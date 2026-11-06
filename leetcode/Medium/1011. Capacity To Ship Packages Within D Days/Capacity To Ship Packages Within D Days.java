import java.util.*;
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int[] tmp = new int[weights.length];
        tmp = weights.clone();
        Arrays.sort(tmp);
        int maxWeight = tmp[tmp.length-1];    // 최대값 = 배열의 마지막 값

        int[] sSum = new int[weights.length+1];
        sSum[0] = 0;
        sSum[1] = weights[0];
        for(int i=2; i<weights.length+1; i++) {    // 누적합 만들기
            sSum[i] = sSum[i-1] + weights[i-1];
        }

        int min = maxWeight;    // 최소값 = 배열의 최대값
        int max = sSum[weights.length];    // 최대값 = 총합
        int mid = (min + max) / 2;    // 최소값과 최대값의 중간값

        if(days == 1) {
            return max;
        }
        
        while(min < max) {
            int count = 0;
            int left = 0;
            int right = 1;
            while(left < weights.length) {
                while(right < weights.length+1 && sSum[right] - sSum[left] <= mid) {
                    right++;
                }
                count++;
                if(left == right - 1) {
                    right++;
                }
                left = right - 1;
            }

            if(count <= days) {    // 중간값으로 부분합 계산해서 days보다 작으면 중간값을 최대값으로
                max = mid;
            } else {    // days보다 크면 중간값을 최소값으로
                min = mid + 1;
            }    // 반복
            mid = (min + max) / 2;

        }

        return min;
    }
}