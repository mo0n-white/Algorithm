import java.util.*;
import java.lang.*;

class Solution {
    public String solution(String s) {
        char[] arr = s.toCharArray();
        
        Arrays.sort(arr);
        
        // 내림차순 reverse
        StringBuilder stb = new StringBuilder(new String(arr)).reverse();
       
        return String.valueOf(stb);
    }
}