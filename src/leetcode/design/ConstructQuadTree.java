// Given a n * n matrix grid of 0's and 1's only. We want to represent the grid with a Quad-Tree.
// See: https://leetcode.com/problems/construct-quad-tree/

package leetcode.design;

public class ConstructQuadTree {

    // See another solution(very elegant): 
    // https://leetcode.com/problems/construct-quad-tree/discuss/535716/Java-recursion-and-backtrack 
    public Node construct(int[][] grid) {
        return helper(grid, 0, grid.length, 0, grid.length);
    }
    
    private Node helper(int[][] grid, int left, int right, int top, int bottom) {
        int val = isLeaf(grid, left, right, top, bottom);
        if (val != -1)
            return new Node(val == 1 ? true : false, true);
        
        Node tLeft = helper(grid, left, (left + right)/2, top, (top + bottom)/2);
        Node tRight = helper(grid, (left + right)/2, right, top, (top + bottom)/2);
        Node bLeft = helper(grid, left, (left + right)/2, (top + bottom)/2, bottom);
        Node bRight = helper(grid, (left + right)/2, right, (top + bottom)/2, bottom);
        
        return new Node(false, false, tLeft, tRight, bLeft, bRight);
    }
    
    public int isLeaf(int[][] grid, int left, int right, int top, int bottom) {
        int val = grid[top][left];
        for (int i = top; i < bottom; i++) 
            for (int j = left; j < right; j++)
                if (grid[i][j] != val) return -1;
        return val;
    }

    public static void main(String[] args) {
        ConstructQuadTree sln = new ConstructQuadTree();
        int[][] grid = {
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0}};
        
        Node root = sln.construct(grid);
        System.out.println(root);
        
        // isLeaf() tests
        System.out.println(sln.isLeaf(grid, 0, 4, 0, 4));
        System.out.println(sln.isLeaf(grid, 4, 8, 0, 4));
        System.out.println(sln.isLeaf(grid, 6, 8, 0, 2));
        System.out.println(sln.isLeaf(grid, 0, 8, 0, 8));
        System.out.println(sln.isLeaf(grid, 4, 8, 4, 8));
        System.out.println(sln.isLeaf(grid, 0, 4, 0, 4));
        System.out.println(sln.isLeaf(grid, 0, 4, 4, 8));
        System.out.println(sln.isLeaf(grid, 6, 8, 2, 4));
    }

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft,
                Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

}
