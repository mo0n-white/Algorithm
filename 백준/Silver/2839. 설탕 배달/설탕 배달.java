import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sugarCount = scanner.nextInt();
        int bagCount = -1;

        if((sugarCount%5)%3 == 0)
            bagCount = sugarCount/5 + (sugarCount%5/3);
        else {
            for(int i=0; i<sugarCount/5+1; i++) {
                if((sugarCount%5 + i*5)%3 == 0) {
                    bagCount = (sugarCount/5 - i) + ((sugarCount%5 + i*5)/3);
                    break;
                }
            }

        }

//        if(sugarCount%3 == 0) {
//            if(bagCount == -1)
//                bagCount = sugarCount/3;
//            else
//                bagCount = Math.min(bagCount, (sugarCount/3));
//        }

        System.out.println(bagCount);
    }
}
