package regx;

/**
 * Created by fanjiangqi on 2017/6/2.
 * 编写一个正则表达式，检查一个句子是否以大写字母开头，以句号结尾。
 */
public class RegxTest7 {
    public static boolean checkSentence(String sentence){
        return sentence.matches("[A-Z].*\\.");
    }
    public static void main(String[] args) {
        String s1 = "fan love lulu.";
        String s2 = "Fan love lulu.";
        System.out.println(RegxTest7.checkSentence(s1));
        System.out.println(RegxTest7.checkSentence(s2));
    }
}
