// Serialize and Deserialize BST
// See: https://leetcode.com/problems/serialize-and-deserialize-bst/

package leetcode.tree;

import static leetcode.util.tree.BinTreeUtil.*;

import leetcode.util.tree.TreeNode;

public class SerializeAndDeserializeBST {

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "";
            String left = serialize(root.left);
            String right = serialize(root.right);
            if (!left.isEmpty()) left = "," + left;
            if (!right.isEmpty()) right = "," + right;
            return root.val + left + right;
        }
        
        // Decodes your encoded data to tree.
        // Recursive solution.
        public TreeNode deserialize(String data) {
            if (data.isEmpty()) return null;
            String[] vals = data.split(",");
            TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
            for (int i = 1; i < vals.length; i++) 
                insert(root, Integer.parseInt(vals[i]));
            return root;
        }
        
        private TreeNode insert(TreeNode root, int val) {
            if (root == null) return new TreeNode(val);
            if (val < root.val)
                root.left = insert(root.left, val);
            else
                root.right = insert(root.right, val);

            return root;
        }

        // Decodes your encoded data to tree.
        // Iterative solution.
        public TreeNode deserialize_va1(String data) {
            if (data.isEmpty()) return null;
            String[] vals = data.split(",");
            TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
            for (int i = 1; i < vals.length; i++) {
                int val = Integer.parseInt(vals[i]);
                TreeNode curr = root;
                while (curr != null) {
                    if (val < curr.val && curr.left != null) {
                        curr = curr.left;
                    } else if (val < curr.val && curr.left == null) {
                        curr.left = new TreeNode(val);
                        break;
                    } else if(curr.right != null) {
                        curr = curr.right;
                    } else {
                        curr.right = new TreeNode(val);
                        break;
                    }
                }
            }
            return root;
        }
        
    }

    public static void main(String[] args) {
        Codec codec = new SerializeAndDeserializeBST().new Codec();
        
        TreeNode root1 = initTree(5, 3, 8, 1, 4, 7, 9, null, null, null, null, null, null, null, 11);
        TreeNode root2 = initTree();

        System.out.println(codec.serialize(root1));
        System.out.println(codec.serialize(root2));

        TreeNode deserTree1 = codec.deserialize(codec.serialize(root1));
        System.out.println(deserTree1);
        
        TreeNode deserTree2 = codec.deserialize(codec.serialize(root2));
        System.out.println(deserTree2);
    }

}
