public class Sort {
    public static void main(String []args){
        int[] num = {3,45,78,64,52,11,64,55,99,11,18};
        System.out.println(arrayToString(num,"未排序"));
       // QuickSort(num,0,num.length-1);
        //selectionSort(num);
        //bubbleSort(num);
        insertSort(num);

        System.out.println(arrayToString(num,"排序"));
        System.out.println(find(num,99,0,num.length-1));

    }

    //快排
    private static void QuickSort(int[] num, int left, int right) {
        //如果左面大于等于右面，说明遍历已经结束，返回
        if(left>=right){
            return;
        }

        //以最做左边的数为基准
        int key = num[left];

        //遍历最右面的数，找到比key小的与key所在位置替换
        int i=left;
        int j=right;
        while(i<j){

            //当右面数值大于key时 j向左移动
            while(num[j]>=key && i<j){
                j--;
            }
            //当右面数值小于key时 i向右移动i
            while(num[i]<=key && i<j){
                i++;
            }

            //前面找到了对应的位置，进行i j数据的交换
            if(i<j){
                //替换
                int temp=num[i];
                num[i]=num[j];
                num[j]=temp;
            }
        }
        num[left]=num[j];
        num[j]=key;
        QuickSort(num,left,i-1);
        QuickSort(num,i+1,right);

    }

    //选择排序
    public static void selectionSort(int[] arr) {
        int mix;
        for(int i=0;i<arr.length;i++){
            mix=i;
            for (int j=i;j<arr.length;j++){
                //查找最小值
                if(arr[mix]>arr[j]){
                    mix=j;
                }
            }
            int temp = arr[i];
            arr[i]=arr[mix];
            arr[mix]=temp;
        }

    }

    //冒泡算法
    /**
     * * 冒泡排序只会操作相邻的两个数据。每次冒泡操作都会对相邻的两个元素进行比较，看是否满足大小关系要求。
     *  * 如果不满足就让它俩互换。一次冒泡会让至少一个元素移动到它应该在的位置，重复n 次，
     *  * 就完成了 n 个数据的排序工作。
     * */
    public static void bubbleSort(int[] arr) {

        for (int i=0;i<arr.length;i++){

            for (int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp =arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    /**
     * 插入排序
     *认为是有序的，从后面向前插
     */
    public static void insertSort(int[] arr) {

        for (int i=1;i<arr.length;i++){
            for (int j=0;j<i;j++){
                if(arr[j]>arr[i]){
                    //取出j的值
                    int temp = arr[i];
                    //将i之后 j之前的数据向后移
                    for(int k=i;k>j;k--){
                        arr[k]=arr[k-1];
                    }
                    arr[j]=temp;
                }
            }
        }
    }

    public static int find(int[] arr,int key,int left,int right){
        //设置分值
        if(left<right){
            int mid = left+right/2;
            if(arr[mid]==key){
                return mid;
            }else if(arr[mid]>key){
                return find(arr,key,left,mid-1);
            }else if(arr[mid]<key){
                return find(arr,key,mid,right);
            }
        }
        return -1;
    }

    private static String arrayToString(int[] arr,String flag) {
        String str = "数组为(" + flag + ")：";
        for (int a : arr) {
            str += a + "\t";
        }
        return str;

    }
}
