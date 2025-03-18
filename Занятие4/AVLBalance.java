package Algorithms.Lesson4;

import java.util.Scanner;

class AVLBalance {
    private int val;
    private AVLBalance left;
    private AVLBalance right;

    public AVLBalance(int val) {
        this.val = val;
    }
    public void Insert(int val) {
        var tree = this;
        while (true) {
            if (tree.val == val) {
                return;
            }
            if (tree.val < val) {
                if (tree.right == null) {
                    tree.right = new AVLBalance(val);
                    return;
                }
                tree = tree.right;
            } else if (tree.val > val) {
                if (tree.left == null) {
                    tree.left = new AVLBalance(val);
                    return;
                }
                tree = tree.left;
            }
        }
    }
    public int height() {
        return height(this);
    }
    private int height(AVLBalance node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }
    public boolean isBalanced() {
        return isBalanced(this);
    }
    private boolean isBalanced(AVLBalance node) {
        if (node == null) {
            return true;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);
    }
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var tree = new AVLBalance(scanner.nextInt());
        while (true) {
            var val = scanner.nextInt();
            if (val != 0) {
                tree.Insert(val);
            } else {
                break;
            }
        }
        if (tree.isBalanced()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        scanner.close();
    }
}
