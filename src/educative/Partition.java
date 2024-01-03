package educative;

import java.util.Arrays;

public class Partition {

        public static boolean canPartitionRecursive(int num[], int sum, int currentIndex)
        {

            int length=num.length;
            if(sum==0) return true;
            if(length==0||currentIndex>=length) return false;
            //Thought process here is to find if by including the current number or not this can return a sum of s/2;
            if(num[currentIndex]<=sum)
            {
                if(canPartitionRecursive(num,sum-num[currentIndex],currentIndex+1))
                    return true;
            }
            return canPartitionRecursive(num,sum,currentIndex+1);



        }

        public static Object canPartition(int num[])
        {
            int sum=0;
           for(Integer i:num){
               sum+=i;
           }
           if(sum%2!=0) return false;

            return canPartitionRecursive(num, sum / 2, 0);
        }
        public static void main(String args[])
        {
            int set1[] = {1, 2, 3, 4};
            System.out.println(Arrays.toString(set1) + "\t--->\t" + canPartition(set1));
            int set2[] = {1, 1, 3, 4, 7};
            System.out.println(Arrays.toString(set2) + "\t--->\t" + canPartition(set2));
            int set3[] = {2, 3, 4, 6};
            System.out.println(Arrays.toString(set3) + "\t--->\t" + canPartition(set3));
        }
    };

