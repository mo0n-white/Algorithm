import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1); // 모든 요소를 -1로 초기화

        // 이것도 덱으로 하면 되는 거 아닌가. 일단 뭐 스택/큐니까 그걸로 풀어봄
        // 덱이 맞았다고 한다~~
        
        Deque<Node> stack = new ArrayDeque<>();
        int i = 0;

        // 스택
        for(int value:numbers) {
            int now = value; // now = 수 입력
            
            while (!stack.isEmpty() && (now > stack.peekLast().value)) {// while 스택이 비지 않고, top과 비교해서 now가 크면 pop(node.answer->now)
                if(answer[stack.peekLast().index] == -1) {
                    answer[stack.peekLast().index] = now; // answer[stack.peekLast().index] = now
                }
                stack.removeLast(); // pop
            }
            stack.addLast(new Node(now, i)); // now push
            i++;
        }
        
        // answer들 출력
        return answer;
    }

    public class Node {
        int value;
        int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}