class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        if(A.length == 1) return A[0] * B[0];    // A 배열의 길이가 1이면 A[0] * B[0] 반환

        for(int i=0; i<A.length-1; i++) {    // A 배열 오름차순 정렬
            for(int j=i+1; j>0; j--) {
                if(A[j-1] > A[j]) {
                    swap(A, j-1, j);
                }
            }
        }

        for(int i=0; i<B.length-1; i++) {    // B 배열 내림차순 정렬
            for(int j=i+1; j>0; j--) {
                if(B[j-1] < B[j]) {
                    swap(B, j-1, j);
                }
            }
        }
        
        for(int i=0; i<A.length; i++) { // A 배열의 첫 번째 요소와 B 배열의 첫 번째 요소를 곱한 값을 answer에 더함
            answer += A[i] * B[i];
        }

        return answer;
    }
    
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}