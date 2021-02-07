import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
/*
greedy
排序之后用最小值与最大值配对，依次匹配后可得整体最大，然后取其最小值得max_v
 */
public class A0 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number= scan.nextInt();
        int[] rating=new int[number];
        for(int i=0;i<number;i++){
            rating[i]=scan.nextInt();
        }
        int max_v=2000000;
        int temp=0;
        Arrays.sort(rating);
        for(int i=0;i<rating.length/2;i++){
            temp=rating[i]+rating[rating.length-1-i];
            if(temp<max_v){
                max_v=temp;
            }
        }
        System.out.println(max_v);


    }
}
