package com.hbq.aop.algorithm.week02;

import java.util.ArrayList;
import java.util.List;

public class NAaryTreePostorderTraversal {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        travel(root, res);
        return res;
    }

    private void travel(Node node, List<Integer> res) {
        if (null != node) {
            if (null != node.children) {
                for (Node child : node.children) {
                    travel(child, res);
                }
            }
            res.add(node.val);
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
