package coach.example;
import java.util.*;
class Program {
    public static void invertBinaryTree(BinaryTree node) {
        // Write your code here.
        if(node==null) return;
        invertBinaryTree(node.left);
        invertBinaryTree(node.right);
        BinaryTree leftNode=node.left;
        BinaryTree rightNode=node.right;
        node.left=rightNode;
        node.right=leftNode;
    }
   // static BinaryTree invertTreeUtil(BinaryTree)
   public int binaryTreeDiameter(BinaryTree tree) {
       // Write your code here.
       int[] finalResult=new int[]{0};
       diameterUtil(tree,finalResult);

       return finalResult[0];
   }
   //Returns the length of longest one way path in this node,
    //dads
   public int diameterUtil(BinaryTree node,int[] finalResult){
        if(node==null) return 0;
        //Find the longest one way path in the left node and right node
       //longest path taking this node as root would be
       //longest_left_path+longest_right_path
       int left_path_length=diameterUtil(node.left,finalResult);
       int right_path_length=diameterUtil(node.right,finalResult);
       int longest_one_way_path_including_this_node_length=Math.max(left_path_length,right_path_length)+1;
       finalResult[0]=Math.max(left_path_length+right_path_length+1,finalResult[0]);
       return longest_one_way_path_including_this_node_length;
   }


    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}