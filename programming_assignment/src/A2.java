
import java.util.*;

public class A2 {
    public static void main(String[] args)  {
        //scan the input
        Scanner scan = new Scanner(System.in);
//        int l= scan.nextInt();
//        int k=scan.nextInt();
//        int[] s=new int[l];
//        int[] f=new int[l];
        String[] line1=scan.nextLine().split(" ");
        int l=Integer.parseInt(line1[0]);
        int k=Integer.parseInt(line1[1]);
        int[][] video=new int[l][2];
       for(int i=0;i<l;i++){
           String[] line=scan.nextLine().split(" ");
           int s=Integer.parseInt(line[0]);
           int f=Integer.parseInt(line[1]);
           video[i][0]=s;
           video[i][1]=f;

       }
        Arrays.sort(video, Comparator.comparing(a->a[1]));

        //according the finish time to sort the arrays

       int count=A2.countNumbers(video,k,l);
       System.out.println(count);

    }
    public static int countNumbers(int[][] video,int k,int l){

        if(k>video.length){
            return video.length;
        }
        int[] recorder_s=new int[k];
        int[] recorder_f=new int[k];
        recorder_s[0]=video[0][0];
        recorder_f[0]=video[0][1];
        int count=1;
        for(int i=1;i<l;i++){
            int mingap=Integer.MAX_VALUE;
            int cur=-1;
            for(int j=0;j<k;j++){
                int tempgap=0;
                if(recorder_f[j]>video[i][0]){
                    tempgap=recorder_f[j]-video[i][0];
                }
                else
                    tempgap=video[i][0]-recorder_f[j];
                if(video[i][0]>=recorder_f[j]&&tempgap<mingap){
                    mingap=tempgap;
                    cur=j;
                }
            }
            if(cur!=-1&&video[i][0]>=recorder_f[cur]){
                recorder_s[cur]=video[i][0];
                recorder_f[cur]=video[i][1];
                count++;
            }
        }
        return count;
    }


    public static int countNumbers1(int[] s,int[] f,int k,int l){
        if(k>f.length){
            return f.length;
        }
        int count=k;
        int[] recorder_s=new int[k];
        int[] recorder_f=new int[k];
        for(int i=0;i<k;i++){
            recorder_s[i]=s[i];
            recorder_f[i]=f[i];
        }
        for(int i=k;i<l;i++){
            int mingap=Integer.MAX_VALUE;
            int cur=-1;
            for(int j=0;j<k;j++){
                int tempgap=0;
                if(s[i]>=recorder_f[j]){
                    tempgap=s[i]-recorder_f[j];
                    if(tempgap<mingap){
                        mingap=tempgap;
                        cur=j;
                    }
                }
            }
            if(cur!=-1){
                recorder_s[cur]=s[i];
                recorder_f[cur]=f[i];
                count++;
            }
        }
        return count;
    }



}

/*
3 1
1 2
2 3
2 3
ou:2


------
5 2
1 4
5 9
2 7
3 8
6 10
ou:3


---
4 1
1 3
4 6
7 8
2 5
ou:3

----
7 3
7 8
8 10
4 6
3 5
3 7
2 4
1 3
ou:7
------

9 3
0 2
1 3
1 4
3 6
4 5
3 7
5 8
9 10
7 10
ou:9
---
5 2
1 6
2 4
1 3
7 8
3 9
ou:4



 */