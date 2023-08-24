package com.problem.solve.v2.tree;

import java.util.ArrayList;
import java.util.List;

public class MinDiffInBST {
    public int minDiffInBST(TreeNode root) {
        int min = Integer.MAX_VALUE;
        List<Integer> res = new ArrayList<>();
        preTreeTraverse(root, res);
        for(int i=1;i<res.size();i++){
            min = Math.min(min, res.get(i)-res.get(i-1));
        }
        return min;
    }
    /*
    Inorder -> left , current , right
    Pre-order -> current , left , right
    Post order -> left , right , current
     */
    // pre order traverse
    void inTreeTraverse(TreeNode root, List<Integer> res){
        if(root == null) return;

        preTreeTraverse(root.left, res);
        res.add(root.val);
        preTreeTraverse(root.right, res);
    }
    void postTreeTraverse(TreeNode root, List<Integer> res){
        if(root == null) return;

        preTreeTraverse(root.left, res);
        preTreeTraverse(root.right, res);
        res.add(root.val);
    }

    void preTreeTraverse(TreeNode root, List<Integer> res) {
        if(root == null) return;
        res.add(root.val);
        preTreeTraverse(root.left, res);
        preTreeTraverse(root.right, res);
    }
}
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