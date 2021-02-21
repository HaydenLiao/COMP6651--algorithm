import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class test {
    static final int N = 30+5;
    static final int M = 1000+10;
    static int n,B;
    static int DP[] = new int[M],
            value[] = new int[N];
    public static void main(String []args) throws Exception{
        int t,cs=1,i,j;
        //Scanner cin = new Scanner(new FileInputStream("input.txt"));
         Scanner cin = new Scanner(System.in);
         t = cin.nextInt();
         while(t--!=0){
             n = cin.nextInt();
             B = cin.nextInt();
             for(i=0;i< n;++i) {
                 value[i] = cin.nextInt();
             }
             Arrays.sort(value,0,n);
             System.out.println(cs+" "+solve()); cs++; }
    }
    public static int solve(){
        int i,j,t,sum=0;
        for(t=0;t< n;++t){
            init(t);
            for(i=t+1;i< n;++i){
                for(j=B;j>=value[i];--j){
                    DP[j] += DP[j-value[i]];
                }
            }
            for(i=B;i>B-value[t] && i>0;--i)
                sum+=DP[i];
        }
        return sum;
    }
    public static void init(int t){
        int i,j=0;
        for(i=0;i<=B;i++){
            DP[i] = 0;
            System.out.println("i="+i+" B="+B);
        }

        for(i=0;i< t;++i)
            j+=value[i];
        if(j<=B) DP[j] = 1;
    }

//    public static void main(String[] args)
//    {
//        Scanner scan = new Scanner(System.in);
//
//        int T=scan.nextInt();
//        int B=scan.nextInt();
//        while(T>0){
//            int n=scan.nextInt();
//            int[] gifts=new int[n];
//            for(int i=0;i<n;i++){
//                gifts[i]=scan.nextInt();
//
//            }
//            for(int i:gifts){
//                System.out.println(i);
//            }
//            T--;
//        }
//
//    }

}

//
//public class Pass{
//    ...
//    private Participant participant;
//    private Event event;
//    public Pass(Participant p, Event e){
//        this.participant=p;
//        this.event=e;
//    }
//}
