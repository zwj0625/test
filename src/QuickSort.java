public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {4,5,8,2,0,9,7,4,1,5};
        int startIndex = 0;
        int endIndex = arr.length-1;
        quickSort(arr,startIndex,endIndex);
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
    /**
     * TODO 快速排序
     * @param arr 待排数组
     * @param startIndex 开始索引
     * @param endIndex 结束索引
     */
    public static void quickSort(int[] arr,int startIndex,int endIndex){
        //递归出口
        if(startIndex > endIndex){
            return;
        }
        //定义两个变量记录查找范围是必要的！！！
        int start = startIndex;
        int end = endIndex;

        //选择基准数
        int baseNumber = arr[startIndex];

        //开始定位基准数的位置，停在start=end
        while(start!=end){
            //先从后往前移动end指针，找比基准数小的，停下(有可能没有找到)
            while(end!=start && arr[end]>=baseNumber){
                end--;
            }
            //先从前往后移动start指针，找比基准数大的，停下
            while(end!=start && arr[start]<=baseNumber){
                start++;
            }
            //交换start和end
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }

        //start=end了，把基准数和start(end)交换
        arr[startIndex] = arr[start];
        arr[start] = baseNumber;

        //-------以上完成一轮快速排序---------
        quickSort(arr,startIndex,end-1);
        quickSort(arr,start+1,endIndex);
    }
}
