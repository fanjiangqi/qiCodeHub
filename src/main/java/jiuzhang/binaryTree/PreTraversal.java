package jiuzhang.binaryTree;

import jiuzhang.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by fanjiangqi on 2017/5/22.
 * 前序遍历二叉树的三种方法：递归，分治，迭代
 */
public class PreTraversal {
    /**
     *  递归方法
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal01(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        /*if (root == null){ //不需要
            return list;
        }*/
        preTraversalHelper(root, list);
        return list;
    }

    private void preTraversalHelper(TreeNode node, List<Integer> list){
        if (node == null){
            return;
        }

        list.add(node.val);
        preTraversalHelper(node.left, list);
        preTraversalHelper(node.right, list);

        return;
    }

    /**
     * 分治的方法
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        //divide
        List<Integer> leftList = preorderTraversal(root.left);
        List<Integer> rightList = preorderTraversal(root.right);

        //conquer
        list.add(root.val);
        list.addAll(leftList); //list.addAll以前没用过
        list.addAll(rightList);

        return list;
    }

    /**
     *  迭代实现，通过显示的栈
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal02(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node;

        stack.push(root);
        while(!stack.isEmpty()){
            node = stack.pop();
            list.add(node.val);
            if (node.right != null){  //先添加右节点，因为stack数据结构
                stack.push(node.right);
            }
            if (node.left != null){
                stack.push(node.left);
            }
        }

        return list;
    }

}
