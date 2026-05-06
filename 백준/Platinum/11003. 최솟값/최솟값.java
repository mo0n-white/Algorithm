import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());    // N 입력
        int L = Integer.parseInt(st.nextToken());    // L 입력

        st = new StringTokenizer(br.readLine());

        Deque<Node> dq = new ArrayDeque<>();  // 덱(Deque), 수와 인덱스를 저장해야 함

        // 이거 파싱 어케 하지.. -> BigDecimal으로 파싱
        Node node = new Node(new BigDecimal(st.nextToken()), 1);
        dq.add(node);  // 덱에 첫번째 수와 인덱스 저장

        System.out.print(dq.peekFirst().value + " ");

        for(int i=2; i<=N; i++) {    // for i = 2~N
            BigDecimal now = new BigDecimal(st.nextToken());    // A_i 입력 -> Node
            Node newNode = new Node(now, i);    

                // 덱은 양방향에서 요소를 추가/제거 가능
            // 추가는 덱의 끝
            while(!dq.isEmpty() && now.compareTo(dq.peekLast().value) <= 0) {    // 새 요소가 덱의 마지막 요소보다 작거나 같으면, 덱의 마지막 요소 제거
                dq.removeLast();
            }
            dq.addLast(newNode);   // 새 요소 추가

            // 제거는 덱의 앞
            if(!dq.isEmpty() && dq.peekFirst().index <= i - L) {    // 인덱스를 비교해서, i-L보다 작거나 같으면 제거
                dq.removeFirst();
            }

            System.out.print(dq.peekFirst().value + " ");    // 최솟값은 덱의 첫번째 요소의 값
        }
    }

    public static class Node {
        BigDecimal value;
        int index;

        public Node(BigDecimal value, int index) {  //생성자
            this.value = value;
            this.index = index;
        }
    }
}
