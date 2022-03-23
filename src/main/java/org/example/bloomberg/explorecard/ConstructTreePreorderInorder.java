package org.example.bloomberg.explorecard;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreePreorderInorder {
    static int preOrderIndex = 0;

    public static void ConstructTreePreorderInorder(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNodeBloom root = constructTree(preorder, map, 0, preorder.length -1);
        System.out.println("TreeNodeBloom :: " + root);
    }

    public static TreeNodeBloom constructTree(int[] preorder, Map<Integer, Integer> map, int left, int right) {
        if (left > right) {
            return null;
        }

        int value = preorder[preOrderIndex++];
        TreeNodeBloom root = new TreeNodeBloom(value);

        root.left = constructTree(preorder, map, left , map.get(value) - 1);
        root.right = constructTree(preorder, map, map.get(value) + 1, right);

        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7}, inorder = {9, 3, 15, 20, 7};
        ConstructTreePreorderInorder(preorder, inorder);
    }
}
