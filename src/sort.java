import java.util.Arrays;

public class sort {

    public static void main(String[] args) {
        sort s=new sort();
        int[] test=new int[]{5,2,4,6,1,3};
        s.mergeSort(test,0,test.length-1);
        for(int k:test){
            System.out.println(k);
        }

    }

    //归并排序
    public void mergeSort(int[] test,int p,int r){
        int q=-1;
        if(p<r){
            q=(p+r)/2;
            mergeSort(test,p,q);
            mergeSort(test,q+1,r);
            merge(test, p,q, r);
        }
    }

    public void merge(int[] test,int p,int q,int r){
        int n1=q-p+2;
        int n2=r-q+1;
        int[] left=new int[n1];
        int[] right=new int[n2];
        for(int x=0;x<left.length-1;x++){
            left[x]=test[p+x];
        }
        left[left.length-1]=999;
        for(int x=0;x<right.length-1;x++){
            right[x]=test[x+q+1];
        }
        right[right.length-1]=999;
        int i=0;
        int j=0;
        for(int k=p;k<r+1;k++){
            if(left[i]<=right[j]){
                test[k]=left[i];
                i++;
            }
            else{
                test[k]=right[j];
                j++;
            }
        }


    }





    //插入排序
    public int[] insertionSort(int[] test){
        int i=-1;
        for(int j=1;j<test.length;j++){
            int key=test[j];
            i=j-1;
            while(i>=0&&test[i]>key){
                test[i+1]=test[i];
                i--;
            }
            test[i+1]=key;
        }
        return test;
    }


}
