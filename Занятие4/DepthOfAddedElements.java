package Algorithms.Lesson4;

import java.util.Scanner;

class DepthOfAddedElements {
    private int val;
    private DepthOfAddedElements left;
    private DepthOfAddedElements right;
    public DepthOfAddedElements(int val) {
        this.val = val;
    }
    public int Insert(int val) {
        return Insert(this, val, 1);
    }
    private int Insert(DepthOfAddedElements tree, int val, int depth) {
        if (tree.val == val) {
            return 0;
        }
        if (val < tree.val) {
            if (tree.left == null) {
                tree.left = new DepthOfAddedElements(val);
                return depth + 1;
            } else {
                return Insert(tree.left, val, depth + 1);
            }
        } else {
            if (tree.right == null) {
                tree.right = new DepthOfAddedElements(val);
                return depth + 1;
            } else {
                return Insert(tree.right, val, depth + 1);
            }
        }
    }
    public boolean Contain(int val) {
        if (this == null) {
            return false;
        }
        var tree = this;
        while (true) {
            if (tree.val == val) {
                return true;
            } else if (tree.val < val) {
                if (tree.right == null) {
                    return false;
                }
                tree = tree.right;
            } else {
                if (tree.left == null) {
                    return false;
                }
                tree = tree.left;
            }
        }
    }
    public int height() {
        return height(this);
    }
    private int height(DepthOfAddedElements node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var tree = new DepthOfAddedElements(scanner.nextInt());

        System.out.println(1);

        while (true) {
            var val = scanner.nextInt();
            if (val != 0) {
                if (!tree.Contain(val)) {
                    int depth = tree.Insert(val);
                    System.out.println(depth);
                }
            } else {
                break;
            }
        }
        scanner.close();
    }
}
