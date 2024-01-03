package coach.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;

public class Program {














    public static class CoinChange {
        public  int numberOfWaysToMakeChange(int n, int[] denoms) {
            // Write your code here.
            //to keep track of number of ways of achieving a sum of j using denoms till index i ;
            //dp[i][j] to represent the number of ways
            //
            CoinChange pg = new CoinChange();
            Arrays.sort(denoms);
            long st1 = System.currentTimeMillis();
            int ans1 = pg.numberofWaysUtil(denoms.length - 1, n, denoms);
            long et1 = System.currentTimeMillis();
            System.out.println(" appraoch  1# " + (et1 - st1) + " ans is " + ans1);
            long st2 = System.currentTimeMillis();
            int[][] dp = new int[denoms.length][n + 1];
            for (int i = 0; i < denoms.length; i++) {
                for (int j = 0; j < n + 1; j++) {
                    dp[i][j] = -1;
                }
            }

            int ans2 = pg.numberofWaysUtilDp(denoms.length - 1, n, denoms, dp);
            long et2 = System.currentTimeMillis();
            System.out.println(" appraoch  2# " + (et2 - st2) + " ans is " + ans2);
            return ans2;

        }

        int numberofWaysUtil(int denomIndex, int sum, int[] denoms) {
            if (sum < 0) return 0;
            if (denomIndex < 0) return 0;
            if (sum == 0) return 1;
            return numberofWaysUtil(denomIndex, sum - denoms[denomIndex], denoms) + numberofWaysUtil(denomIndex - 1, sum, denoms);

        }

        int numberofWaysUtilDp(int denomIndex, int sum, int[] denoms, int[][] dp) {
            if (sum < 0) return 0;
            if (denomIndex < 0) return 0;
            if (sum == 0) {
                dp[denomIndex][sum] = 1;

            }
            if (dp[denomIndex][sum] != -1) return dp[denomIndex][sum];
            dp[denomIndex][sum] = numberofWaysUtilDp(denomIndex, sum - denoms[denomIndex], denoms, dp) + numberofWaysUtilDp(denomIndex - 1, sum, denoms, dp);

            return dp[denomIndex][sum];
        }

    }
}
