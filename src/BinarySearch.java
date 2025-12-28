public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        int target = 3;
        System.out.println(binarySearch(arr, target));
    }

    //二分查找，前提是数组已经有序
    public static int binarySearch(int[] arr, int target){
        int min = 0;
        int max = arr.length-1;
        int mid;
        while(true){
            if(min>max){
                return -1;//没找到
            }
            mid = (min+max)/2;
            if(arr[mid] > target){
                max = mid - 1;
            }else if(arr[mid] < target){
                min = mid + 1;
            }else{       //arr[mid] = target
                return mid;
            }
        }
    }
}
