package jiuzhang;

/**
 * Created by fanjiangqi on 2017/5/22.
 *
 * 题目：对于一个给定的 source 字符串和一个 target 字符串，
 * 你应该在 source 字符串中找出 target 字符串出现的第一个位置(从0开始)。如果不存在，则返回 -1。
 */
public class FindString {
    public int findString(String source, String target){
        if (source == null || target == null){
            return -1;
        }
        int i, j;
        for (i = 0; i < source.length() - target.length() + 1; i++){  // ① i 处需要 + 1
            for (j = 0; j < target.length(); j++) {
                if (source.charAt(i + j) != target.charAt(j)){ //②此处判断需注意，原来我是先判断等于，结果很麻烦
                   break;
                }
            }
            if (j == target.length() - 1){  //③直接return
                return i;
            }
        }
        return -1;
    }
}
