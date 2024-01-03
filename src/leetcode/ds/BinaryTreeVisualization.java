package leetcode.ds;

import javax.swing.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class BinaryTreeVisualization extends JFrame {
    TreeNode root;
    int node1,node2,ans;

    public BinaryTreeVisualization(TreeNode root,int node1,int node2,int ans) {
        this.root = root;
        setPreferredSize(new Dimension(800, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        this.node1=node1;
        this.node2=node2;
        this.ans=ans;
    }


    private void drawTree(Graphics g, TreeNode node, int x, int y, int dx) {
        if (node == null) return;
        g.drawString(Integer.toString(node.val), x, y);
        if (node.left != null) {
            g.drawLine(x, y, x - dx, y + 50);
            drawTree(g, node.left, x - dx, y + 50, dx / 2);
        }
        if (node.right != null) {
            g.drawLine(x, y, x + dx, y + 50);
            drawTree(g, node.right, x + dx, y + 50, dx / 2);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawTree(g, root, getWidth() / 2, 60, getWidth() / 4);
        g.drawString("LCA of "+node1+" and "+node2+" is "+ans,getWidth(),getWidth()*2);

    }

}
