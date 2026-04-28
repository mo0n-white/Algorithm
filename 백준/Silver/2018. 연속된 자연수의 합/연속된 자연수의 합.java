import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();     // 자연수 N 입력
        int count = 0;
        int i = 1;

        while((double)N/i >= (double)i/2) { // N/x가 x/2보다 같거나 클때까지 x++ while?
            if(i%2 != 0) {  // x가 홀수면 N%x==0일때 answer++
                if(N%i == 0) count++;
            } else {        // x가 짝수면 N*2 % x == 0일때 answer++ 
                if((N%i != 0) && ((N*2)%i == 0)) count++;
            }
            i++;
        }
        System.out.println(count);
        sc.close();
    }
}
