package educative;

public class Main {
    public static void main (String [] args){
        System.out.println(" "+Knapsack(new int[]{60,100,120},3,new int[]{10,20,30},3,50));
    }

    public static int LCSLength(String s1, String s2)
    {
        // write your code here
        s1 = "www.educative.io/explore";
        s2 = "educative.io/edpresso";
        int m=s1.length();
        int n=s2.length();
        // array to keep the length of longest common subsequence ,
        // string s1 of length i ending at index i and string s2 of ending at index j;
        //
        int[][] dp=new int[m+1][n+1];

        //
        //
        return -1;
    }
    int lcs(String s1,String s2,int i,int j,int[][] dp){
        int m=s1.length();
        int n=s2.length();
        if(i==0||j==0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        else if(s1.charAt(i-1)==s2.charAt(j-1)) {dp[i][j]=1+dp[i-1][j-1];}
        else {
            dp[i][j]=Math.max(lcs(s1,s2,i-1,j,dp),lcs(s1,s2,i-1,j,dp));
        }
        return dp[j][j];
    }



    static int Knapsack(int profits[], int profitsLength, int weights[], int weightsLength, int capacity)
    {
        int[][] dp=new int[profitsLength+1][capacity+1];
        for(int i=0;i<profitsLength+1;i++){
            for(int j=0;j<capacity+1;j++){
                if(j==0||i==0) dp[i][j]=0;
                else{
                    if(weights[i-1]<=j){
                        dp[i][j]=Math.max(profits[i-1]+dp[i-1][j-weights[i-1]],dp[i-1][j]);
                    }else
                        dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[profitsLength][capacity];

        // return knapsackRecur(profitsLength-1,profits,weights,capacity);
    }
   static  int knapsackRecur(int index,int[] profit, int[] weights,int cap){
        if(index<0) return 0;
        if(cap<=0) return 0;
        //Calculate profit including the item at indexW and
        //also excluding the item at indexW and then return the maximum of the
        //two.
        if(weights[index]>cap) return knapsackRecur(index-1,profit,weights,cap);
        int maxProfit=Math.max(profit[index]+knapsackRecur(index-1,profit,weights,cap-weights[index]),
                knapsackRecur(index-1,profit,weights,cap));
        return maxProfit;

    }
}
