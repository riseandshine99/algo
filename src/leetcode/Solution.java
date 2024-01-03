package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {


    }
    public static int levenshteinDistance(String str1,String str2){
        return 0;
    }
    public static int levenshteinDistance(String str1, String str2,int i, int j) {
        // Write your code here.
        if(i==0) return j;
        if(j==0) return i;
        if(str1.charAt(i-1)==str2.charAt(j-1))
            return levenshteinDistance(str1,str2,i-1,j-1);
        else
        {
            return 1+minUtil(levenshteinDistance(str1,str2,i-1,j-1),
                    levenshteinDistance(str1,str2,i-1,j),
                    levenshteinDistance(str1,str2,i,j-1));
        }

    }
    public static int minUtil(int a, int b, int c ){
        return Math.min(Math.min(a,b),c);
    }
    public static int levenshteinDistanceDp(String str1, String str2,int i, int j,int[][] dp) {
        // Write your code here.

       return 0;

    }


    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < words.length) {
            int start = i;
            int end = i;
            int currentWordsSize = words[start].length();
            while (currentWordsSize + end - start < maxWidth) {
                if (currentWordsSize + end - start + words[end].length() + 1 <= maxWidth) {
                    currentWordsSize += words[end].length();
                    end++;


                }
            }

        }
        return null;
    }
    //Find max length of concatenated strings
//write program to find max length of concatenated strings



    /**
     * All leetcode programs.
     */
    public Solution() {
        super();
    }
    //Give largest possisble length of concatenated strings in the list with all unique characters
    public int maxLength(List<String> arr) {
        //sanitize the input
        //we will go through the the list and remove unwanted items such s a
        //String containng duplicate string
        // Sanitize the input  list
        for(String s: arr){
           if(s.length()!=s.chars().distinct().count()) arr.remove(s);
        }



        return maxLengthUtil(1,arr,0,"");
    }
    public int maxLengthUtil(int maxLength,List<String> list,int index,String currentChain){
        if(index==list.size()) return maxLength;
        String word=list.get(index);
        maxLength=Math.max(maxLength,maxLengthUtil(maxLength,list,index+1,currentChain));
        if(!hasSharedChars(currentChain,currentChain+word)){
            maxLength=Math.max(maxLength,maxLengthUtil(maxLength,list,index+1,currentChain+word));
        }
        return maxLength;
    }
    public static boolean hasSharedChars(String s1, String s2) {
        Set<Character> set1 = new HashSet<>();
        for (char c : s1.toCharArray()) {
            set1.add(c);
        }
        for (char c : s2.toCharArray()) {
            if (set1.contains(c)) {
                return true;
            }
        }
        return false;
    }
}
