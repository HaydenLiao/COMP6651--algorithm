public class theoryA2 {
    public static void main(String[] args) {
        theoryA2 s=new theoryA2();
        int[] a=new int[]{6,4,7,8,1,2};  //6
//        int[] a=new int[]{10,1,2,8,7,3};//3
        int ans =s.mergeSort(a,0,a.length-1);
        for(int c:a){
            System.out.println(c);
        }
        System.out.println("逆序数对数为："+ans);


    }

    //归并排序
    public int mergeSort(int[] test,int p,int r){
        int ret=0;
        int q=-1;
        if(p<r){
            q=(p+r)/2;
            int ans1=mergeSort(test,p,q);
            int ans2=mergeSort(test,q+1,r);
            int ans3=merge(test, p,q, r);
            ret=ans1+ans2+ans3;
        }
        return ret;
    }

    public int merge(int[] test,int p,int q,int r){
        int count=0;
        int i=p;
        int j=q+1;
        for(int k=p;k<r+1;k++){
            if(test[i]<=test[j]){
                i++;
            }
            else{
                if(test[i]>3*test[j]){
                    count++;
                }
                j++;

            }
        }
        return count;


    }



}
