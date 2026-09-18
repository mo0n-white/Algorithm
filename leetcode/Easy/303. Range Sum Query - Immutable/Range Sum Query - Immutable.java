class NumArray {
    int[] sArr;     // 누적 합 배열 sArr 선언

    public NumArray(int[] nums) {
        sArr = new int[nums.length];
        sArr[0] = nums[0];
        for(int i=1; i<nums.length; i++) {   // 누적 합 배열 sArr 저장
            sArr[i] = sArr[i-1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        if(left == 0) return sArr[right];    // s[right] - s[left-1] 배열 저장
        else return sArr[right] - sArr[left-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */