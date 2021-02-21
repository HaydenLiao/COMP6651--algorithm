import java.util.Arrays;
import java.util.Scanner;
/*
http://poj.org/problem?id=3093
 */
public class A4 {
    public static void main(String[] args)  {
        Scanner scan = new Scanner(System.in);
        int T=scan.nextInt();//number of test case (1 ≤ T ≤ 1000)
        int count=1;
        while(T>0){
            int n=scan.nextInt();//number of gifts (1 ≤ n ≤ 30)
            int B=scan.nextInt();//budgets (1 ≤ B ≤ 1000)
            int[] price=new int[n];
            for(int i=0;i<n;i++){
                price[i]=scan.nextInt();
            }
            Arrays.sort(price);
            int dp[]=new int[B+1];
            int combination=A4.Combination(price,n,B,dp);
            System.out.println(count+" "+combination);
            count++;
            T--;
        }
    }
    public static int Combination(int[] price,int n,int B,int dp[]) {
        int sum=0;
        for(int i=0;i<n;i++){
            {//initial dp array
                int x = 0;
                for (int y = 0; y <= B; y++) {
                    dp[y] = 0;
                }
                for (int z = 0; z < i; z++) {
                    x = x + price[z];
                }
                if (x <= B) {
                    dp[x] = 1;
                }
            }
            for(int j=i+1;j<n;j++){
                for(int k=B;k>=price[j];k--){
                    dp[k]=dp[k]+dp[k-price[j]];
                }
            }
            for (int j=B;j>B-price[i]&&j>0;j--){
                sum=sum+dp[j];
            }
        }
        return sum;
    }

}
/*
4
6 25
8 9 8 7 16 5
30 250
1 2 3 4 5 6 7 8 9 10 11
12 13 14 15 16 17 18 19 20
21 22 23 24 25 26 27 28 29 30
29 1
2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30
29 2
2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30
30 466 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30

ou:
1 15
2 16509438
3 0
4 1
 */