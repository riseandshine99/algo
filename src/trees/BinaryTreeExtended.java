package trees;

import java.util.ArrayList;

public class BinaryTreeExtended extends BinarySearchTree {

	public void reverseAlternateLevels() {
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		getNodesInorderAlt(root, list, false);
		System.out.println();
		for (int i = 0; i < list.size(); i++) {
			System.out.print(" " + list.get(i).data);
		}
		populateNodes(root, list, list.size() - 1, false);
	}

	private void populateNodes(TreeNode node, ArrayList<TreeNode> list, int start,
                               boolean isOdd) {
		if (node == null || start < 0)
			return;
		System.out.println(" Current node " + node.data + " start is "
				+ list.size());

		populateNodes(node.left, list, start, !isOdd);
		if (isOdd) {
			System.out.println("Changing node " + node.data + "to "
					+ list.get(list.size() - 1).data);
			node.data = list.get(list.size() - 1).data;

			list.remove(list.size() - 1);
		}
		populateNodes(node.right, list, start, !isOdd);
	}

	private void getNodesInorderAlt(TreeNode node, ArrayList<TreeNode> list,
                                    boolean isOdd)

	{
		if (node == null)
			return;
		System.out.println(" Node is " + node.data + " isOdd is " + isOdd);
		getNodesInorderAlt(node.left, list, !isOdd);
		if (isOdd) {
			list.add(node);
		}
		getNodesInorderAlt(node.right, list, !isOdd);

	}

	public void getMirrorImage()

	{
		getMirrorUtil(root);
	}

	private TreeNode getMirrorUtil(TreeNode node) {
		if (node == null) {
			return null;
		}
		TreeNode temp = node.left;
		node.left = getMirrorUtil(node.right);
		node.right = getMirrorUtil(temp);
		return node;
	}

	public void constructTree() {
		root = new TreeNode(11);
		root.left = new TreeNode(2);
		root.right = new TreeNode(29);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(7);
		// root.left.left.left = new Tnode(2);
		// root.left.left.right = new Tnode(6);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(40);

		root.right.right.left = new TreeNode(35);

	}

	public void convertToSumtree() {
		convertToSumUtil(root, 0);
	}

	private int convertToSumUtil(TreeNode node, int sum) {
		if (node == null)
			return 0;
		int rightS = convertToSumUtil(node.right, sum);
		Integer d = (Integer) node.data;
		node.data = sum + rightS;
		int leftS = convertToSumUtil(node.left, d + rightS + sum);
		return leftS + rightS + d;
	}

	public void checkBST() {
		if (checkBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
			System.out.println("This is a BST");
		} else
			System.out.println(" This is not a BST");
	}

	private boolean checkBSTUtil(TreeNode node, int min, int max) {
		if (node == null)
			return true;
		boolean l, r = false;
		l = checkBSTUtil(node.left, min, (Integer) node.data);
		r = checkBSTUtil(node.right, (Integer) node.data, max);
		if (l & r) {
			if (node.data.compareTo(min) > 0 && node.data.compareTo(max) < 0)
				return true;

		}
		return false;

	}

	public void getRightView() {
		System.out.println();
		getRightViewUtil(root, 1, 0);

	}

	private int getRightViewUtil(TreeNode node, int current_level, int maxLevel) {
		if (node == null)
			return 0;
		if (maxLevel < current_level) {
			System.out.print(" " + node.data);
			maxLevel = current_level;
		}
		int lRight = getRightViewUtil(node.right, current_level + 1, maxLevel);
		if (lRight > maxLevel)
			maxLevel = lRight;
		getRightViewUtil(node.left, current_level + 1, maxLevel);
		return maxLevel;
	}

	public void getLeftView() {
		getLeftViewUtil(root, 1, 0);
	}

	private int getLeftViewUtil(TreeNode node, int currentLevel, int maxLevel) {
		if (node == null)
			return 0;
		if (maxLevel < currentLevel) {
			System.out.print(" " + node.data);
			maxLevel = currentLevel;
		}
		int lLeft = getLeftViewUtil(node.left, currentLevel + 1, maxLevel);
		if (lLeft > maxLevel) {
			maxLevel = lLeft;
		}
		getLeftViewUtil(node.right, currentLevel + 1, maxLevel);
		return maxLevel;
	}

	public void printBoundary() {

	}

	public void printLevels() {
		System.out.println();
		printLevels(root, root);
	}

	private void printLevels(TreeNode node1, TreeNode node2) {
		if (node1 == null || node2 == null)
			return;
		printLevels(node1.left, node2.right);
		printLevels(node1.right, node2.left);
		System.out.print(" node1 " + node1.data + " node2 " + node2.data);
	}

	public void convertLeavestoDLL() {
		TreeNode[] headRef = new TreeNode[1];

		getHeadofLeaves(root, headRef);
		System.out.println(" headRef is " + headRef[0]);
		if (headRef[0] != null)
			System.out.println(" head is " + headRef[0].data);
		TreeNode temp = headRef[0];
		while (headRef[0] != null) {
			System.out.print(" " + headRef[0].data);
			headRef[0] = headRef[0].right;

		}

	}

	private TreeNode getHeadofLeaves(TreeNode node, TreeNode[] headRef) {

		if (node == null)
			return node;
		System.out.println("node data is " + node.data);
		if (node.isLeafNode()) {
			node.right = headRef[0];
			if (headRef[0] != null) {
				headRef[0].left = node;
			}
			headRef[0] = node;
			return null;

		}
		node.right = getHeadofLeaves(node.right, headRef);
		node.left = getHeadofLeaves(node.left, headRef);
		return node;

	}
	
	
	//Convert to douby linked list
	
	public void convertToDoublyLinkedList(){
		TreeNode[] tail=new TreeNode[1];
		
		TreeNode head=convertToDLLUtil(root, tail);
		System.out.println();
		while(head!=null)
		{
			System.out.print( " "+head.data);
			head=head.right;
		}
	}
	
	private TreeNode convertToDLLUtil(TreeNode node, TreeNode[] tail){
		if(node==null)
			return null;
		TreeNode head_left=convertToDLLUtil(node.left,tail);
		TreeNode head=head_left;
		if(head_left!=null)
		{
			tail[0].right=node;
			node.left=tail[0];
		
		}else{
			head=node;
			tail[0]=node;
			
			
		}
		TreeNode head_right;
		head_right=convertToDLLUtil(node.right,tail);
		node.right=head_right;
		
		return head;
		
		
	}
	
	
	public void getMaxAtLevel(int k)
	{
		
	}
private void getMaxAtLevelUtil(TreeNode node, int level, Comparable[] max){
	
	
	
}
}
