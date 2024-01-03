package leetcode.curated170;

import leetcode.ds.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class Solution {


    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int prevWindowPoisonStartTime=timeSeries[0];
        int prevWindowPoisonEndTime=timeSeries[0]+duration-1;
        int totalPoisonTime=duration;
        for(int i=1;i<timeSeries.length;i++){
            int thisWindowPoisonEndTime=timeSeries[i]+duration-1;
            int thisWindowPoisonStartTime=timeSeries[i];
            int overlap=0;
            if(prevWindowPoisonEndTime>=thisWindowPoisonStartTime){
                overlap=prevWindowPoisonEndTime-thisWindowPoisonStartTime+1;

            }
            totalPoisonTime+=duration-overlap;
            prevWindowPoisonEndTime=thisWindowPoisonEndTime;


        }
        return totalPoisonTime;
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        TreeMap<Integer,List<Integer>> result=new TreeMap<>();
        traverse(root,0,result);
        List<List<Integer>> list=new ArrayList<>();
        for (List<Integer> values : result.values()) {
            list.add(values);
        }
        return list;
    }
    void traverse(TreeNode root, int column, TreeMap<Integer,List<Integer>> result){
        if(root==null) return;
        traverse(root.left,column-1,result);
        List<Integer> list=result.computeIfAbsent(column,(k)-> new ArrayList<Integer>());
        list.add(root.val);
        traverse(root.right,column+1,result);
    }
}
