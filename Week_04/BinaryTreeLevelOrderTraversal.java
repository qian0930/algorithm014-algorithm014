package com.hbq.aop.algorithm.week04;

import com.hbq.aop.algorithm.week03.SerializeAndDeserializeBinaryTree2;
import com.hbq.aop.algorithm.week03.SerializeAndDeserializeBinaryTree2.*;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res= new ArrayList<>();
        travel(res, root, 0);
        return res;
    }

    private void travel(List<List<Integer>> res, TreeNode node, int level) {
        if (null == node) {
            return;
        }
        if (level >= res.size()) {
            res.add(new ArrayList<>());
        }
        List<Integer> levelRes = res.get(level);
        levelRes.add(node.getVal());

        travel(res, node.getLeft(), level + 1);
        travel(res, node.getRight(), level + 1);
    }

    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree2 ts2 = new SerializeAndDeserializeBinaryTree2();
        TreeNode node = ts2.deserialize("3,9,20,null,null,15,7");

        BinaryTreeLevelOrderTraversal ot = new BinaryTreeLevelOrderTraversal();
        System.out.println(ot.levelOrder(node));
    }
}
