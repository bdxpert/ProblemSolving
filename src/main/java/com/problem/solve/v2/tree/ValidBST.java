package com.problem.solve.v2.tree;

import java.util.Stack;
//https://leetcode.com/problems/validate-binary-search-tree/solutions/32112/learn-one-iterative-inorder-traversal-apply-it-to-multiple-tree-questions-java-solution/
//check valid binary search tree
public class ValidBST {
    public boolean isValidBSTV2(TreeNode root) {
        if(root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while(root!=null || !stack.isEmpty()){
            while(root !=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre !=null && root.val <=pre.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }
}
