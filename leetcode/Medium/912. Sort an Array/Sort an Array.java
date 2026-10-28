class Solution {
    public int[] sortArray(int[] nums) {
        nums = preSort(nums);
        return nums;
    }

    public int[] preSort(int[] array) {
        if(array.length <= 1) {
            return array;
        }

        int mid = array.length/2;
        int[] left = preSort(Arrays.copyOfRange(array, 0, mid));    // left 배열
        int[] right = preSort(Arrays.copyOfRange(array, mid, array.length));    // right 배열

        return mergeSort(left, right);    // left, right 배열 합치기
    }

    public int[] mergeSort(int[] arr1, int[] arr2) {
        int[] tmp = new int[arr1.length + arr2.length];
        int i=0, j=0;
        while(i+j < tmp.length) {    // while i<arr1.length && j<arr2.length
            if(i == arr1.length) {    // arr1이 다 끝났으면 arr2 남은 값 tmp에 넣기
                tmp[i + j] = arr2[j];
                j++;
            } else if(j == arr2.length) {    // arr2가 다 끝났으면 arr1 남은 값 tmp에 넣기
                tmp[i + j] = arr1[i];
                i++;
            } else {
                if(arr1[i] < arr2[j]) {    // arr1[i] arr2[j] 비교해서 작은 값 tmp에 넣기
                    tmp[i + j] = arr1[i];
                    i++;
                } else {
                    tmp[i + j] = arr2[j];
                    j++;
                }
            }
        }
        return tmp;    // return tmp;
    }
}