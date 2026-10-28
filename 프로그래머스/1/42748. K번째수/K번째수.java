import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];    // int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++) {    // for i 0 -> commands.length
            int[] tmp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);    // int[] tmp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            answer[i] = findK(tmp, 0, tmp.length - 1, commands[i][2] - 1);    // answer[i] = findK(tmp, 0, tmp.length - 1, commands[i][2] - 1);
        }

        return answer;
    }

    public int findK(int[] array, int low, int high, int k) {    // quickSort 함수 array, low, high
        if(low == high) {    // if low == high
            return array[low];    // return array[low];
        }
        if(high - low == 1) {    // if high - low == 1
            if(array[low] > array[high]) {    // if array[low] > array[high]
                swap(array, low, high);    // swap(array, low, high)
            }
            return array[k];    // return array[k];
        }

        int pivot = sort(array, low, high);    // int pivot = sort(array, low, high);
        if(k < pivot) {    // if k < pivot
            return findK(array, low, pivot - 1, k);    // return findK(array, low, pivot - 1, k);
        } else if(k > pivot) {    // else if k > pivot
            return findK(array, pivot + 1, high, k);    // return findK(array, pivot + 1, high, k);
        } else {    // else
            return array[pivot];    // return array[pivot];
        }
    }

    public int sort(int[] array, int low, int high) {    // sort 함수 array, low, high
        int pivot = low++;    // pivot = array[low++];
        while(low < high) {    // while low < high {
            while(low <= high && array[low] < array[pivot]) low++;    // while array[low] < pivot low++;
            while(low <= high &&array[high] > array[pivot]) high--;    // while array[high] > pivot high--;
            if(low < high) {    // if low < high
                swap(array, low, high);    // swap(array, low, high)
                high--;
            }
        }    
        swap(array, pivot, high);    // swap(array, pivot, high)
        return high;    // return high;
    }


    public void swap(int[] array, int i, int j) {    // swap 함수 array, low, high
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}