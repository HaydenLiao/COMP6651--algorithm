import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] firstline=input.nextLine().split(" ");
        int N=Integer.parseInt(firstline[0]);
        int K=Integer.parseInt(firstline[1]);
        int[][] schedule=new int[N][2];
        for(int i=0;i<N;i++){
            String[] nextline=input.nextLine().split(" ");
            schedule[i][0]=Integer.parseInt(nextline[0]);
            schedule[i][1]=Integer.parseInt(nextline[1]);
        }
        Arrays.sort(schedule, Comparator.comparing(a->a[1]));
        int[][] recorder=new int[K][2];
        recorder[0]=schedule[0];
        int counter=1;
        for(int j=1;j<N;j++){
            int min=Integer.MAX_VALUE;
            int location=-1;
            for(int i=0;i<K;i++){
                int currentmin;
                if(recorder[i][1]>schedule[j][0]){
                    currentmin=recorder[i][1]-schedule[j][0];
                }
                else
                    currentmin=schedule[j][0]-recorder[i][1];
                if(schedule[j][0]>=recorder[i][1]&&currentmin<=min){
                    min=currentmin;
                    location=i;
                }
            }
            if(location>-1&&schedule[j][0]>=recorder[location][1]){
                counter++;
                recorder[location]=schedule[j];
            }
        }
        System.out.println(counter);



    }

}
//
//
//
//import java.io.FileNotFoundException;
//        import java.io.FileReader;
//        import java.io.Reader;
//        import java.util.ArrayList;
//        import java.util.Scanner;
//
//public class A2 {
//    public static void main(String[] args)  {
//        //scan the input
//        Scanner scan = new Scanner(System.in);
//        int l= scan.nextInt();
//        int k=scan.nextInt();
//        int[] s=new int[l];
//        int[] f=new int[l];
//        String line=scan.nextLine();
//        ArrayList<int[]> video=new ArrayList<>();
//        for(int i=0;i<l;i++){
//            String[] time=line.split(" ");
//
//            video.add()
//        }
//
//        //according the finish time to sort the arrays
//        A2 test=new A2();
//        A2.quickSort1(s,f,0,s.length-1);
//        int count=A2.countNumbers(s,f,k,l);
//        System.out.println(count);
//
//    }
//    public static int countNumbers(int[] s,int[] f,int k,int l){
//        if(k>f.length){
//            return f.length;
//        }
//        int[] recorder_s=new int[k];
//        int[] recorder_f=new int[k];
//        recorder_s[0]=s[0];
//        recorder_f[0]=f[0];
//        int count=1;
//        for(int i=1;i<l;i++){
//            int mingap=Integer.MAX_VALUE;
//            int cur=-1;
//            for(int j=0;j<k;j++){
//                int tempgap=0;
//                if(recorder_f[j]>s[i]){
//                    tempgap=recorder_f[j]-s[i];
//                }
//                else
//                    tempgap=s[i]-recorder_f[j];
//                if(s[i]>=recorder_f[j]&&tempgap<mingap){
//                    mingap=tempgap;
//                    cur=j;
//                }
//            }
//            if(cur!=-1&&s[i]>=recorder_f[cur]){
//                recorder_s[cur]=s[i];
//                recorder_f[cur]=f[i];
//                count++;
//            }
//        }
//        return count;
//    }
//
//
//    public static int countNumbers1(int[] s,int[] f,int k,int l){
//        if(k>f.length){
//            return f.length;
//        }
//        int count=k;
//        int[] recorder_s=new int[k];
//        int[] recorder_f=new int[k];
//        for(int i=0;i<k;i++){
//            recorder_s[i]=s[i];
//            recorder_f[i]=f[i];
//        }
//        for(int i=k;i<l;i++){
//            int mingap=Integer.MAX_VALUE;
//            int cur=-1;
//            for(int j=0;j<k;j++){
//                int tempgap=0;
//                if(s[i]>=recorder_f[j]){
//                    tempgap=s[i]-recorder_f[j];
//                    if(tempgap<mingap){
//                        mingap=tempgap;
//                        cur=j;
//                    }
//                }
//            }
//            if(cur!=-1){
//                recorder_s[cur]=s[i];
//                recorder_f[cur]=f[i];
//                count++;
//            }
//        }
//        return count;
//    }
//
//
//
//    public static void quickSort1(int[] f,int[] arr,int low,int high){
//        int i,j,temp,t;
//        if(low>high){
//            return;
//        }
//        i=low;
//        j=high;
//        //temp就是基准位
//        temp = arr[low];
//        while (i<j) {
//            //先看右边，依次往左递减
//            while (temp<=arr[j]&&i<j) {
//                j--;
//            }
//            //再看左边，依次往右递增
//            while (temp>=arr[i]&&i<j) {
//                i++;
//            }
//            //如果满足条件则交换
//            if (i<j) {
//                t = arr[j];
//                arr[j] = arr[i];
//                arr[i] = t;
//                //exchange the corresponding position of f[i]&f[j]
//                t=f[j];
//                f[j]=f[i];
//                f[i]=t;
//            }
//
//        }
//        //最后将基准为与i和j相等位置的数字交换
//        arr[low] = arr[i];
//        arr[i] = temp;
//        temp=f[low];
//        f[low]=f[i];
//        f[i]=temp;
//        //递归调用左半数组
//        quickSort1(arr,f ,low, j-1);
//        //递归调用右半数组
//        quickSort1(arr, f,j+1, high);
//    }
//
//
//
//
//
//}
//
///*
//3 1
//1 2
//2 3
//2 3
//ou:2
//
//
//------
//5 2
//1 4
//5 9
//2 7
//3 8
//6 10
//ou:3
//
//
//---
//4 1
//1 3
//4 6
//7 8
//2 5
//ou:3
//
//----
//7 3
//7 8
//8 10
//4 6
//3 5
//3 7
//2 4
//1 3
//ou:7
//------
//
//9 3
//0 2
//1 3
//1 4
//3 6
//4 5
//3 7
//5 8
//9 10
//7 10
//ou:9
//---
//5 2
//1 6
//2 4
//1 3
//7 8
//3 9
//ou:4
//
//
//
// */
//
