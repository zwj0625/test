import java.util.ArrayList;
import java.util.List;

public class BasicSearch {
    public static void main(String[] args) {
        int[] arr = {7,5,3,5,9,0,2,1,3,8,9};
        int target = 5;
        System.out.println(basicSearch(arr, target));
    }

    // 基本查找/顺序查找
    public static List<Integer> basicSearch(int[] arr, int target){
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == target){
                result.add(i);
            }
        }
        return result;
    }
}
