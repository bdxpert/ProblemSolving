package com.problem.solve.v2.tree;

import java.util.*;
//https://leetcode.com/problems/validate-binary-search-tree/solutions/32112/learn-one-iterative-inorder-traversal-apply-it-to-multiple-tree-questions-java-solution/

public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0;
        Stack<TreeNode> stk = new Stack<>();
        while(root!=null || !stk.isEmpty()){
            while(root !=null){
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            if(--k == 0) break;
            root = root.right;
        }
        return root.val;
    }
}
