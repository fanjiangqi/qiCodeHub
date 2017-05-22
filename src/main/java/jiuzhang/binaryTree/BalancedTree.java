package jiuzhang.binaryTree;

import jiuzhang.TreeNode;

/**
 * Created by fanjiangqi on 2017/5/22.
 * 判断一个二叉树是不是平衡二叉树，用分治法，很有启发性，
 * 思路： int isBalancedHelper(TreeNode root)
 * 返回 该节点的高度，返回-1 表示以该节点为根节点的树不是平衡二叉树
 *  ** 开始错误少了这一句，if (leftHight == -1 || rightHight == -1) return -1 **
 *
 * https://leetcode.com/problems/balanced-binary-tree/#/description
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more than 1.
 */
public class BalancedTree {

    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        if (isBalancedHelper(root) == -1){
            return false;
        }
        return true;
    }

    /**
     * 返回 root节点的高度，如果返回-1 表示以该节点为根节点的树不是平衡二叉树
     * @param root
     * @return
     */
    private int isBalancedHelper(TreeNode root){
        if (root == null){
            return 0;
        }
        //divide
        int leftHight = isBalancedHelper(root.left);
        int rightHight = isBalancedHelper(root.right);

        //conquer
        if (leftHight == -1 || rightHight == -1){
            return -1;
        }

        if (Math.abs(leftHight - rightHight) > 1){
            return -1;
        }else {
            return leftHight > rightHight ? leftHight + 1 : rightHight + 1;
        }
    }
}
