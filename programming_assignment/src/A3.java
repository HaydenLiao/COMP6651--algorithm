import java.util.Scanner;
/*
https://www.geeksforgeeks.org/count-groupings-number-sum-digits-every-sub-group-less-equals-immediate-right-sub-group/
 */
public class A3 {
    public static void main(String[] args)  {
        //scan and parse to int[]
        Scanner scan = new Scanner(System.in);
        String s=scan.nextLine().trim();//  remove the blank
        int k=1;
        while(!s.equals("bye")){
            int[] num=new int[String.valueOf(s).length()];
            for(int i=0;i<num.length;i++){
                num[i]=Integer.parseInt(String.valueOf(s.charAt(i)));
            }
            //initial the DP array
            int n=num.length;
            int dp[][]=new int[n][9*n+1];
            for(int i=0;i<n;i++){
                for(int j=0;j<9*n+1;j++){
                    dp[i][j]=-1;
                }
            }
            int res=A3.dpCountGroups(0,0,n,num,dp);
            System.out.println(""+k+". "+res);
            s=scan.nextLine().trim();
            k++;
        }





    }
    static int dpCountGroups(int position,int previous_sum,int n,int[] num,int[][] dp){
        if (position == n)
            return 1;
        //if res already sloved before, just return the value
        if(dp[position][previous_sum]!=-1)
            return dp[position][previous_sum];

        dp[position][previous_sum]=0;
        int res = 0;//the number of group it can have when cut in position
        int sum = 0;
        for(int i=position;i<n;i++){
            sum=sum+num[i];
            if(sum>=previous_sum){
                res=res+dpCountGroups(i+1,sum,n,num,dp);
            }
        }
        dp[position][previous_sum]=res;
        return res;
    }



}
/*
test cases:
635
1117
9876
9785623503467134789034654
12345
54234168765123541251234
bye

ou:
1. 2
2. 7
3. 2
4.115
5.10
6.158
 */


//
//
//    //递归
//    static int reurcountGroups(int position,
//                               int previous_sum,
//                               int length,
//                               String num)
//    {
//        // Terminating Condition
//        if (position == length)
//            return 1;
//        int res = 0;
//        // sum of digits
//        int sum = 0;
//
//        // Traverse all digits from
//        // current position to rest
//        // of the length of string
//        for (int i = position; i < length; i++)
//        {
//            sum += (num.charAt(i) - '0');
//            // If forward_sum is greater
//            // than the previous sum,
//            // then call the method again
//            if (sum >= previous_sum)
//                // Note : We pass current
//                // sum as previous sum
//                res += reurcountGroups(i + 1, sum,
//                        length, num);
//        }
//        // Total number of subgroups
//        // till current position
//        return res;
//    }
