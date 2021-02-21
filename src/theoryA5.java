import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/*
https://www.techiedelight.com/3-partition-problem/
 */
public class theoryA5 {
    // Helper function for solving 3 partition problem.
    // It returns true if there exist three subsets with the given sum
    public static boolean subsetSum(int[] S, int n, int a, int b, int c,
                                    Map<String, Boolean> lookup)
    {
        // return true if the subset is found
        if (a == 0 && b == 0 && c == 0) {
            return true;
        }

        // base case: no items left
        if (n < 0) {
            return false;
        }

        // construct a unique map key from dynamic elements of the input
        String key = a + "|" + b + "|" + c + "|" + n;

        // if the subproblem is seen for the first time, solve it and
        // store its result in a map
        if (!lookup.containsKey(key))
        {
            // Case 1. The current item becomes part of the first subset
            boolean A = false;
            if (a - S[n] >= 0) {
                A = subsetSum(S, n - 1, a - S[n], b, c, lookup);
            }

            // Case 2. The current item becomes part of the second subset
            boolean B = false;
            if (!A && (b - S[n] >= 0)) {
                B = subsetSum(S, n - 1, a, b - S[n], c, lookup);
            }

            // Case 3. The current item becomes part of the third subset
            boolean C = false;
            if ((!A && !B) && (c - S[n] >= 0)) {
                C = subsetSum(S, n - 1, a, b, c - S[n], lookup);
            }

            // return true if we get a solution
            lookup.put(key, A || B || C);
        }

        // return the subproblem solution from the map
        return lookup.get(key);
    }

    // Function for solving the 3–partition problem. It returns true if the given
    // set `S` can be divided into three subsets with an equal sum
    public static boolean partition(int[] S)
    {
        if (S.length < 3) {
            return false;
        }

        // create a map to store solutions to a subproblem
        Map<String, Boolean> lookup = new HashMap<>();

        // get the sum of all elements in the set
        int sum = Arrays.stream(S).sum();

        // return true if the sum is divisible by 3 and the set `S` can
        // be divided into three subsets with an equal sum
        return (sum % 3) == 0 && subsetSum(S, S.length - 1, sum/3,
                sum/3, sum/3, lookup);
    }

    public static void main(String[] args)
    {
        // Input: a set of integers
        int[] S = { 7, 3, 2, 1, 5, 4, 8 };

        if (partition(S)) {
            System.out.println("Set can be partitioned");
        } else {
            System.out.println("Set cannot be partitioned");
        }
    }
}
