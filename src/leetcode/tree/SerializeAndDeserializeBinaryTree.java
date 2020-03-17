// Serialize and Deserialize Binary Tree
// See: https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.initTree;

import java.util.Arrays;
import java.util.LinkedList;

import leetcode.util.tree.TreeNode;

public class SerializeAndDeserializeBinaryTree {

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "x";
            return root.val + "," + serialize(root.left) + "," + serialize(root.right);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            LinkedList<String> list = new LinkedList<>(Arrays.asList(data.split(",")));
            return deser(list);
        }

        private TreeNode deser(LinkedList<String> data) {
            String val = data.remove();
            if (val.equals("x"))
                return null;

            TreeNode node = new TreeNode(Integer.parseInt(val));
            node.left = deser(data);
            node.right = deser(data);
            return node;
        }
    }

    public static void main(String[] args) {
        Codec codec = new SerializeAndDeserializeBinaryTree().new Codec();
        TreeNode tree1 = initTree(1, 2, 3, null, null, 4, 5);
        TreeNode tree2 = initTree(5, 3, 8, 1, 4, 7, 9, null, null, null, null, null, null, null,
                11);
        System.out.println(codec.serialize(tree1));
        System.out.println(codec.serialize(tree2));

        TreeNode t1 = codec.deserialize(codec.serialize(tree1));
        System.out.println(t1);
        
        TreeNode t2 = codec.deserialize(codec.serialize(tree2));
        System.out.println(t2);
    }

}
