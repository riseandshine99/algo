package leetcode.interviews.microsoft;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main (String[] args){


    }
    // 19 in base 2
    // 2, 9,1
    //2, 4,1+1
    //2,2,1+10

    //2,1,
    //10011= 1+2^2+2^4
    public String convertToTitle(int columnNumber) {
        List<Integer> result=new ArrayList<>();
        int remaining=columnNumber;

        while(remaining>0){
            int q=remaining%26;
            result.add(0,q);
            remaining=remaining/26;
        }
        StringBuilder sb=new StringBuilder();
       return null;

    }
    public static String removeDuplicates(String s) {

        // Replace this placeholder return statement with your code
        return "";
    }

}
