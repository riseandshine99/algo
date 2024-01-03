package educative;

public class KnapSack
{
    static int Knapsack(int profits[], int profitsLength, int weights[], int weightsLength, int capacity)
    {
        //Calculating the maximum profit possible
        //when we have used elements till profitsLength length and with a maximum
        //total weight of knapsack bag as cap.
        int [][] dp=new int[profitsLength+1][capacity+1];
        //Iterate from left to right in theincreasing of weights
        for(int i=0;i<profitsLength+1;i++){
            for(int j=0;j<capacity+1;j++){
                if(i==0||j==0) dp[i][j]=0;
                else{
                    if(weights[i-1]<=j){
                        dp[i][j]=Math.max(profits[i-1]+dp[i-1][j-weights[i-1]],dp[i-1][j]);
                    }else
                        dp[i][j]=dp[i-1][j];
                }
            }
        }

        return dp[profitsLength][capacity];
    }


}
