package regx;

import java.util.Scanner;

/**
 * Created by fanjiangqi on 2017/8/31.
 */
public class Meituan2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[i-1]) {
                dp[i] = dp[i-1] + 1;
            } else {
                dp[i] = dp[i-1];
            }
        }
        System.out.println(dp[n-1]);
        sc.close();
    }

}
