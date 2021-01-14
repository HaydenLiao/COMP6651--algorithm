public class sort {

    public static void main(String[] args) {
        sort s=new sort();
        int[] test=new int[]{5,2,4,6,1,3};
        s.insertionSort(test);
        for(int k:test){
            System.out.println(k);
        }

    }

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
