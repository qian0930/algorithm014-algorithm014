package com.hbq.aop.algorithm.week02;

import java.util.ArrayList;
import java.util.List;

public class NAaryTreeLevelorderTraversal {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(Node root) {
        travel(root, 0);
        return res;
    }

    private void travel(Node node, int level) {
        if (null == node) {
            return;
        }
        if (level >= res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(node.val);
        for (Node child : node.children) {
            travel(child, level + 1);
        }
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
