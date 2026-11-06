import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        // 인접 행렬 board
        // 그냥 보고는 모르겠어서 지피티한테 힌트 달라함. 한 행에 하나씩 놓는다 생각하고 해보라길래 그렇게 해보려 함
        // 각 행에서 놓을 수 있는 열 확인하고 큐에 입력
        // 음 아무리 생각해도 dfs로밖에 생각이 안나서 결국 헬프 침

        ArrayList<int[]> adjList = new ArrayList<>();    // board를 꼭 2차원 배열로 생각하지 않고, 어차피 한 행에는 하나의 퀸만 놓을 수 있으니까 1차원 배열로 위치 표기
        int rm = 0;

        for(int i=0; i<n; i++) {
            adjList.add(new int[] {i});
        }

        while(!adjList.isEmpty()) {
            if(adjList.get(rm).length == n) {   // 배열 길이가 n개 되는 애들은 answer++;
                answer++;
                adjList.remove(rm);
                continue;   // 퀸 다 찾으면 루프 건너뛰기
            }

            // 0번째 행에서 놓을 수 있는 칸 이후에는 0,0 이후에 1번째 행에서 놓을 수 있는 칸 큐에 입력
            // 이후에 0,1 놓으면 1번째 행에서 놓을 수 있는 칸 큐에 입력 -> 반복

            int[] tmp = adjList.remove(rm);
            int skip = 0;
            for(int j=0; j<n; j++) {
                for(int k=0; k<tmp.length; k++) {
                    if(tmp[k] == j || Math.abs(tmp.length-k) == Math.abs(tmp[k] - j)) {
                        skip = 1;
                        break;
                    }
                }
                if(skip == 1) {
                    skip = 0;
                    continue;
                }
                
                int[] next = new int[tmp.length+1];
                next = Arrays.copyOf(tmp, next.length);
                next[next.length-1] = j;
                adjList.add(next);
            }
        }
        return answer;
    }
}