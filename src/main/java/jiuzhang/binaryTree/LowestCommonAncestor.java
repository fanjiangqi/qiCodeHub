package jiuzhang.binaryTree;

import jiuzhang.TreeNode;

/**
 * Created by fanjiangqi on 2017/5/22.
 * 最短公共祖先，这个分治也很值得思考，第一次没写出来
 * 核心思路：是找到那个节点，并不是判断是否相等
 *
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/#/description
 */
public class LowestCommonAncestor {
    //核心思路：是找到那个节点，并不是判断是否相等
    // 在root为根的二叉树中找A,B的LCA:
    // 如果找到了就返回这个LCA
    // 如果只碰到A，就返回A
    // 如果只碰到B，就返回B
    // 如果都没有，就返回null
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null){
            return root;
        }
        if (left != null){
            return left;
        }
        if (right != null){
            return right;
        }
        return null;


    }
}
