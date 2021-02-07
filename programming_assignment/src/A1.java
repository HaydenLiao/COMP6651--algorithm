import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class A1 {
    public static int right_most_binary_search(int[] arr,int index,int target){
        int left = index;
        int right = arr.length-1;
        while(left<right){
            int mid = left + (right-left+1)/2;
            if(arr[mid]==target){left=mid;}
            else if(arr[mid] > target){right = mid-1 ;}
            else{left = mid + 1;}
        }
        return left;
    }

    public static void main(String[] args) {
        ArrayList result=new ArrayList();
        Scanner scan = new Scanner(System.in);
         label1:
        while(true) {
            String number = scan.nextLine();
            if(number.equals("0 0 0 0 0")){
                break label1;
            }

            if (!number.isEmpty()) {
                String[] five = number.split(" ");
                int l = Integer.parseInt(five[0]);//price limit
                int f = Integer.parseInt(five[1]);//first dishes
                int m = Integer.parseInt(five[2]);//main dishes
                int d = Integer.parseInt(five[3]);//drinks
                int c = Integer.parseInt(five[4]);//candies

                //price for first dishes
                String p = scan.nextLine();
                String[] p_a = p.split(" ");
                int[] f_p = new int[p_a.length];
                for (int i = 0; i < f_p.length; i++) {
                    f_p[i] = Integer.parseInt(p_a[i]);
                }

                //main dishes
                p = scan.nextLine();
                p_a = p.split(" ");
                int[] m_p = new int[p_a.length];
                for (int i = 0; i < m_p.length; i++) {
                    m_p[i] = Integer.parseInt(p_a[i]);
                }

                //drink
                p = scan.nextLine();
                p_a = p.split(" ");
                int[] d_p = new int[p_a.length];
                for (int i = 0; i < d_p.length; i++) {
                    d_p[i] = Integer.parseInt(p_a[i]);
                }

                //candies
                p = scan.nextLine();
                p_a = p.split(" ");
                int[] c_p = new int[p_a.length];
                for (int i = 0; i < c_p.length; i++) {
                    c_p[i] = Integer.parseInt(p_a[i]);
                }

                //combine first & main
                int[] f_m_p = new int[f_p.length * m_p.length];
                int k = 0;
                for (int i = 0; i < f_p.length; i++) {
                    for (int j = 0; j < m_p.length; j++) {
                        f_m_p[k] = f_p[i] + m_p[j];
                        k++;
                    }
                }

                Arrays.sort(f_m_p);

                //combine drink & candy
                int[] d_c_p = new int[d_p.length * c_p.length];
                k = 0;
                for (int i = 0; i < d_p.length; i++) {
                    for (int j = 0; j < c_p.length; j++) {
                        d_c_p[k] = d_p[i] + c_p[j];
                        k++;
                    }
                }

                Arrays.sort(d_c_p);

                long meals = 0;
                int target=0;
                int index=0;
                int t=0;
//                for (int i = 0; i < f_m_p.length; i++) {
//                    target=l-f_m_p[i];
//                    if(target<d_c_p[0]){
//                        continue;
//                    }
//                    else if(target>d_c_p[d_c_p.length-1]){
//                        meals=meals+d_c_p.length;
//                    }
//                    else{
//                        index=Arrays.binarySearch(d_c_p,target);//直接用binarySearch会导致返回的是第一个重复元素
//                        while((index< d_c_p.length-1)&&d_c_p[index+1]==d_c_p[index]){
//                            index++;
//                        }
//                        meals=meals+index+1;
//                    }
//
//                }
                for (int i = 0; i < f_m_p.length; i++) {
                    target=l-f_m_p[i];
                    index=Arrays.binarySearch(d_c_p,target);
                    if(index<0){
                        t=-1-index;
                    }
                    else{
                        t=right_most_binary_search(d_c_p,index,target)+1;
                    }
                    meals=meals+t;
                }
                result.add(meals);
//                System.out.println((long)meals);
            }
        }


        for( Object ou:result){
            System.out.println((long)ou);
        }


        /*
11 3 1 1 1
4 5 6
3
2
1

10 4 5 4 2
3 2 5 7
1 1 8 4 2
3 5 2 1
2 3

0 0 0 0 0

10 3 2 2 1
1 2 3
1 1
2 2
2

10 3 2 2 1
3 3 3
3 3
3 3
3


2 48 12 0
         */




    }
}
