import java.util.*;
// 인접 리스트 - 재귀 함수
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;

        boolean[] visited = new boolean[n];    // 방문 배열 선언
        Arrays.fill(visited, false);    // 방문 배열 초기화
        
        // 인접 리스트
        ArrayList<Integer>[] adjList = new ArrayList[n];

        for(int i=0 ;i<n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(computers[i][j] == 1 && i!=j) {
                    adjList[i].add(j);
                }
            }
        }

        for(int i=0; i<n; i++) {    // 방문 배열 다 true될 때까지 false인 index를 start로 dfs 호출
            if(!visited[i]) {
                dfsList(adjList, visited, i);    // start i로 dfs 호출
                answer++;
            }
        }
        
        return answer;
    }

    public void dfsList(ArrayList<Integer>[] adjList, boolean[] visited, int start) {
        visited[start] = true;
        for(int i=0; i<adjList[start].size(); i++) {
            int next = adjList[start].get(i);
            if(!visited[next]) {
                dfsList(adjList, visited, next);
            }
        }
        return;
    }
}

// 인접 행렬 - 재귀 함수
// class Solution {
//     public int solution(int n, int[][] computers) {
//         int answer = 0;

//         boolean[] visited = new boolean[n];    // 방문 배열 선언
//         Arrays.fill(visited, false);    // 방문 배열 초기화
//         // 재귀 함수...로 해보자
    
//         for(int i=0; i<n; i++) {    // 방문 배열 다 true될 때까지 false인 index를 start로 dfs 호출
//             if(!visited[i]) {
//                 dfs(n, computers, visited, i);    // start i로 dfs 호출
//                 answer++;
//             }
//         }
        
//         return answer;
//     }

//     public void dfs(int n, int[][] computers, boolean[] visited, int start) {
//         visited[start] = true;    // 방문 처리
//         for(int i=0; i<n; i++) {    // computers[start][i] == 1이면 dfs 호출
//             if(computers[start][i] == 1 && !visited[i]) {
//                 dfs(n, computers, visited, i);
//             }
//         }
//         return;
//     }
// }