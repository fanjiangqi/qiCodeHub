import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by fanjiangqi on 2017/6/3.
 * geeksforgeeks中的题目
 * http://practice.geeksforgeeks.org/problems/permutations-of-a-given-string/0
 */
public class PermutationString {
    private static void permutation(String s, List<Character> list, List<String> res){
        if (list.size() == s.length()){
            res.add(listToString(list));
            return;
        }
        for (int i = 0; i < s.length(); i++){
            if (list.contains(s.charAt(i))){
                continue;
            }
            list.add(s.charAt(i));
            permutation(s, list, res);
            list.remove(list.size() - 1);
        }
    }
    private static String listToString(List<Character> list){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++){
            sb.append(list.get(i));
        }
        return sb.toString();
    }
    public static void main (String[] args) {
        //code
        int[] arr = new int[100];
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();


        while(t > 0){
            String s = sc.next();
            List<String> res = new ArrayList<>();
            permutation(s, new ArrayList<Character>(), res);
            for (String str : res){
                System.out.print(str + " ");
            }
            System.out.println();
            t--;
        }
        sc.close();

    }
}
