import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import static javax.swing.UIManager.put;

public class theoryA3 {
    public static void main(String[] args)  {
        String s="((())())(()((())))";
        boolean b=theoryA3.isValid(s);
        System.out.println(b);

    }
    public static boolean isValid(String s) {
        int n = s.length();
//        if (n % 2 == 1) {
//            return false;
//        }
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch==')') {
                if (stack.isEmpty() ) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }


}
