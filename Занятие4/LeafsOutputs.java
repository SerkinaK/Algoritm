package Algorithms.Lesson4;

import java.util.Scanner;

class TreeLeaf {
    private int val;
    private TreeLeaf left;
    private TreeLeaf right;

    public TreeLeaf(int value) {
        this.val = value;
    }
    public void Insert(int value) {
        var tree = this;
        while (true) {
            if (tree.val == value) {
                return;
            }
            if (tree.val < value) {
                if (tree.right == null) {
                    tree.right = new TreeLeaf(value);
                    return;
                }
                tree = tree.right;
            } else if (tree.val > value) {
                if (tree.left == null) {
                    tree.left = new TreeLeaf(value);
                    return;
                }
                tree = tree.left;
            }
        }
    }
    public void Print() {
        Print(this);
    }
    private void Print(TreeLeaf tree) {
        if (tree.left != null) {
            Print(tree.left);
        }
        if (tree.right != null) {
            Print(tree.right);
        }
        if (tree.right == null && tree.left == null) {
            System.out.println(tree.val);
        }
    }
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var tree = new TreeLeaf(scanner.nextInt());
        while (true){
            var val = scanner.nextInt();
            if (val != 0 ){
                tree.Insert(val);
            }
            else{
                break;
            }
        }
        tree.Print();
        scanner.close();
    }
}
