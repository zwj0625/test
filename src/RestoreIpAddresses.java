import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class RestoreIpAddresses {
    public static void main(String[] args) {

    }
}

class Solution{
    public List<String> restoreIpAddresses(String s) {
        int len = s.length(); // 记录字符串长度
        List<String> res = new ArrayList<>(); // 创建结果列表
        // 如果字符串长度不在IP地址的合法范围内，直接返回空列表
        if (len < 4 || len > 12) {
            return res;
        }

        Deque<String> path = new ArrayDeque<>(4); // 创建用于记录路径的双端队列
        int splitTimes = 0; // 初始化分割次数
        dfs(s, len, splitTimes, 0, path, res); // 深度优先搜索
        return res; // 返回结果列表
    }

    /**
     * 判断字符串s的子区间[left, right]能否成为一个IP段。
     * 同时将子区间转换为整数。
     *
     * @param s 原始字符串
     * @param left 子区间的起始索引
     * @param right 子区间的结束索引
     * @return 如果是合法的IP段，返回转换后的整数，否则返回-1
     */
    private int judgeIfIpSegment(String s, int left, int right) {
        int len = right - left + 1; // 计算子区间长度

        // 如果长度大于1且以0开头，则不是合法的IP段
        if (len > 1 && s.charAt(left) == '0') {
            return -1;
        }

        // 将子区间转换为整数
        int res = 0;
        for (int i = left; i <= right; i++) {
            res = res * 10 + s.charAt(i) - '0'; // 逐位累加
        }

        // 如果整数大于255，则不是合法的IP段
        if (res > 255) {
            return -1;
        }
        return res; // 返回转换后的整数
    }

    /**
     * 深度优先搜索方法，用于找到所有可能的IP地址。
     *
     * @param s 原始字符串
     * @param len 字符串长度
     * @param split 当前分割的IP段数
     * @param begin 当前搜索的起始索引
     * @param path 记录当前路径的双端队列
     * @param res 结果列表
     */
    private void dfs(String s, int len, int split, int begin, Deque<String> path, List<String> res) {
        if (begin == len) {
            // 如果到达字符串末尾且分割了4个IP段，则添加到结果列表
            if (split == 4) {
                res.add(String.join(".", path));
            }
            return;
        }

        // 如果剩余的字符串长度不足以分割成更多的IP段，或者超过需要的段数，则退出
        if (len - begin < (4 - split) || len - begin > 3 * (4 - split)) {
            return;
        }

        for (int i = 0; i < 3; i++) {
            // 尝试分割出3个字符长度的IP段
            if (begin + i >= len) {
                break; // 如果超出字符串长度，结束循环
            }

            int ipSegment = judgeIfIpSegment(s, begin, begin + i); // 判断当前子区间是否为合法的IP段
            if (ipSegment != -1) {
                // 如果是合法的IP段，则添加到路径中，并递归搜索
                path.addLast(ipSegment + "");
                dfs(s, len, split + 1, begin + i + 1, path, res);
                path.removeLast(); // 回溯，移除最后一个元素
            }
        }
    }
}
