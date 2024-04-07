import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String strInput = scanner.next();
        int[] strCount = new int[26];
        int maxCount = 0;
        int maxIndex = 0;
        int sameFlag = 0;

        for(int i=0; i<26; i++) {
            for(int j=0; j<strInput.length(); j++)
                if(strInput.charAt(j) == (char)(i+'a') || strInput.charAt(j) == (char)(i+'A'))
                    strCount[i]++;
            if(maxCount<strCount[i]) {
                maxCount = strCount[i];
                maxIndex = i;
                sameFlag = 0;
            }
            else if (maxCount == strCount[i]) {
                sameFlag = 1;
            }
        }

        if(sameFlag == 1)
            System.out.print('?');
        else
            System.out.print((char) (maxIndex+'A'));
    }
}
