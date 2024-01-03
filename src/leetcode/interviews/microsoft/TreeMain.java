package leetcode.interviews.microsoft;

import com.sun.source.tree.Tree;
import leetcode.ds.BinaryTreeVisualization;
import leetcode.ds.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.*;

public class TreeMain {


    public TreeMain() {
    }



    public static void main(String[] args){
        TreeMain main=new TreeMain();
        TreeNode root=new TreeNode(1);
        root.right=new TreeNode(3);
        root.left=new TreeNode(2);
        root.right.left=new TreeNode(4);
        root.right.right=new TreeNode(5);
       String ans= main.serialize(root);
       TreeNode tree=main.deserialize(ans);
       main.displayInorder(tree);
       System.out.println();
       main.displayPreOrder(tree);
       System.out.println("");
       int ans1=main.lowestCommonAncestor(root,root.right.right,root.left).val;

       System.out.println(" LCA is "+ans1);
        new BinaryTreeVisualization(root,root.right.right.val,root.left.val,ans1);


    }
    public TreeNode invertTree(TreeNode node) {
        if(node==null) return null;
        TreeNode left=invertTree(node.left);
        TreeNode right=invertTree(node.right);
        node.left=right;
        node.right=left;


        return node;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //Process is find the first root
        //iteratively find the inorder of the left hand side of this tree
        //and also the right hand side of the tree
        //So essentially
        // find the index of the target node in the inorder array and the left of it you have
        //the inorder of left half of the tree and right half of tree ,
        // Keep doing this till you get only one item in preorder and inorder .
        //



       return null;
    }
    public TreeNode buildTreeUtil(int startIn,int endIn,int index,int[] preOrder,int[] inorder,int n){
        if(endIn>=n||endIn<0||startIn<0||startIn>=n) return null;

        TreeNode node=new TreeNode(preOrder[index]);
        //Find index of this node in the inorder array
        int indexInInorderArray=find(inorder,startIn,endIn,node.val);
        // find number of elements in the array in the left half

        int elementsInLeftHalf=indexInInorderArray==-1?0:indexInInorderArray-startIn+1;
        int elementsInRightHalf=indexInInorderArray==-1?0:endIn-indexInInorderArray+1;
return null;



    }
    int find(int[] array , int start , int end , int target){
        for(int i=start;i<=end;i++){
            if(array[i]==target) return i;
        }
        return -1;
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        System.out.println("Finding LCA of "+p.val+" and "+q.val);
        boolean[] b1 = new boolean[1];
        boolean[] b2 = new boolean[1];

        return lowestCommonAUtil(root,p,q, b1,b2);
    }
    public TreeNode lowestCommonAUtil(TreeNode node,TreeNode node1,TreeNode node2, boolean[] node1Found,boolean[] node2Found){
        if(node==null)
            return null;

          TreeNode lca_left=lowestCommonAUtil(node.left,node1,node2,node1Found,node2Found);
          if(lca_left!=null) return lca_left;


          TreeNode lca_right=lowestCommonAUtil(node.right,node1,node2,node1Found,node2Found);
          if(lca_right!=null) return lca_right;
          if(node1Found[0]&&node2Found[0]) return node;

          if(node==node1) {
              node1Found[0]=true;

          }
          if(node==node2) {
              node2Found[0]=true;
          }
        return null;


    }
    public List<Integer> rightSideView(TreeNode root) {
        TreeMap<Integer,LevelHolder> map=new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        new TreeMap<Integer,TreeNode>((o1,o2)->o1-o2);
        rightSideUtil(root,map,0,0);
        List<Integer> result=new ArrayList<>();
        Iterator<LevelHolder> it=map.values().iterator();
        while(it.hasNext()){
            result.add(it.next().node.val);
        }
        return result;
    }
    void rightSideUtil(TreeNode node,TreeMap<Integer,LevelHolder> map,int level,int lateralDistance){
        if(node==null) return;

        rightSideUtil(node.right,map,level+1,lateralDistance+1);
        map.computeIfAbsent(level,(c)->new LevelHolder(lateralDistance,node));
        LevelHolder levelHolder=map.get(level);
        if(levelHolder.lateralDistance<lateralDistance){
            map.put(level,new LevelHolder(lateralDistance,node));
        }
        rightSideUtil(node.left,map,level+1,lateralDistance-1);

    }
    static class LevelHolder
    {
        int lateralDistance;
        TreeNode node;
        public LevelHolder(int lateralDistance,TreeNode node){
            this.lateralDistance=lateralDistance;
            this.node=node;
        }
    }





       void displayInorder(TreeNode node){
           if(node!=null){
               displayInorder(node.left);
               System.out.print(" "+node.val+"->");
               displayInorder(node.right);
           }
        }
    void displayPreOrder(TreeNode node){
        if(node!=null){

            System.out.print(" "+node.val+"->");
            displayPreOrder(node.left);
            displayPreOrder(node.right);
        }
    }


    // Encodes a tree to a single string.
        public String serialize(TreeNode root) {

            // We will serialize level by level.
            // so level 0 will have 1 node
            // Level i will have 2^i
            //We will keep this in string comma-separated format , while keeping null values for empty childs
            // First lets do a level order traversal
            int height=height(root);
            Stack<TreeNode> currentLevel=new Stack<>();
            Stack<TreeNode> nextLevel=new Stack<>();
            int currenHeight=1;

            StringBuilder sb=new StringBuilder();
            int n= (int) (Math.pow(2,height)-1);
            TreeNode[] res=new TreeNode[n];
            currentLevel.add(root);
            res[0]=root;
            for(int i=0;i<res.length;i++){
                TreeNode node=res[i];
                int leftChildIndex=2*i+1;
                int rightChildIndex=2*i+2;
                if(leftChildIndex<res.length&&rightChildIndex<res.length){
                    res[leftChildIndex]=node==null?null:node.left;
                    res[rightChildIndex]=node==null?null:node.right;
                }
                sb.append(res[i]==null?"NULL":res[i].val);
                sb.append(",");

            }
                sb.deleteCharAt(sb.length()-1);
                System.out.println(sb.toString());
                return sb.toString();
        }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String [] arr=data.split(",");
        int n=arr.length;
        TreeNode root=null;

        return construct(arr,0,n);
    }

        TreeNode construct( String[] arr, int index, int n) {
            if (index >= n) return null;
            if (arr[index].equals("NULL")) return null;
            TreeNode node = new TreeNode(Integer.parseInt(arr[index]));
            node.left = construct(arr, 2 * index + 1, n);
            node.right = construct(arr, 2 * index + 2, n);
            return node;
        }
        int height(TreeNode node){
            if(node==null) return 0;
            return Math.max(height(node.left),height(node.right))+1;
        }




}
