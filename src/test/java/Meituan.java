import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by fanjiangqi on 2017/8/31.
 */
public class Meituan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeSet<String> urls = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            urls.add(sc.next());
        }
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            String url = sc.next();
            if (urls.contains(url)) {
                urls.remove(url);
            }
        }
        sc.close();
        for (String s : urls) {
            System.out.println(s);
        }
    }
}
