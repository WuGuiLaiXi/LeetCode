package com.leetcode.hot_100;

import java.util.ArrayList;

public class easy_101 {
/*
 * 101. 对称二叉树
给定一个二叉树，检查它是否是镜像对称的。

 

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3
 

但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3
 

进阶：

你可以运用递归和迭代两种方法解决这个问题吗？
 * 
 * */

    public boolean isSymmetric(TreeNode root) {
    	return check(root, root);
    }
    public boolean check(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null)
            return true;
        if(node1 == null || node2 == null)
        	return false;
        
        return node1.val == node2.val && check(node1.left, node2.right) && check(node1.right, node2.left);
    }
	
}

 //Definition for a binary tree node.
class TreeNode {
     
	 int val;
	 TreeNode left;
	 TreeNode right;
	 TreeNode() {}
	 TreeNode(int val) { this.val = val; }
	 TreeNode(int val, TreeNode left, TreeNode right) {
		 this.val = val;
		 this.left = left;
		 this.right = right;
	 }
}


