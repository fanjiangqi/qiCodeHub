package jiuzhang.binaryTree;

import jiuzhang.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by fanjiangqi on 2017/5/22.
 * 二叉树的宽度优先搜索模板（一个队列实现），很重要
 */
public class Bfs {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        int len;

        queue.offer(root);
        while (!queue.isEmpty()){
            len = queue.size();  //一个队列实现的关键
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < len; i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            res.add(list);
        }

        return res;
    }
}
