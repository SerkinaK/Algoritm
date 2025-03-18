package Algorithms.Lesson4;

import java.util.Scanner;

class TreeHeight {
    private int val;
    private TreeHeight left;
    private TreeHeight right;

    public TreeHeight(int val){
        this.val = val;
    }
    public void Insert(int val){
        var tree = this;
        while(true){
            if (tree.val == val){
                return;
            }
            if (tree.val<val){
                if (tree.right == null){
                    tree.right = new TreeHeight(val);
                    return;
                }
                tree= tree.right;
            }
            else if (tree.val > val){
                if (tree.left == null){
                    tree.left= new TreeHeight(val);
                    return;
                }
                tree=tree.left;
            }
        }
    }
    public boolean Contain(int val){
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
    private int height(TreeHeight node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var tree = new TreeHeight(scanner.nextInt());
        while (true){
            var val = scanner.nextInt();
            if (val != 0 ){
                if (!tree.Contain(val)) {
                    tree.Insert(val);
                }
            }
            else{
                break;
            }
        }
        System.out.println(tree.height());
        scanner.close();
    }
}

