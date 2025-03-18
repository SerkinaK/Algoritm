package Algorithms.Lesson4;

import java.util.Scanner;

class BinaryTreeTraversal {
    private int val;
    private BinaryTreeTraversal left;
    private BinaryTreeTraversal right;

    public BinaryTreeTraversal(int val){
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
                    tree.right = new BinaryTreeTraversal(val);
                    return;
                }
                tree= tree.right;
            }
            else if (tree.val > val){
                if (tree.left == null){
                    tree.left=new BinaryTreeTraversal(val);
                    return;
                }
                tree=tree.left;
            }
        }
    }
    public void Print(){
        Print(this);
    }
    private void Print(BinaryTreeTraversal tree){
        if (tree.left != null){
            Print(tree.left);
        }
        System.out.println(tree.val);
        if (tree.right != null){
            Print(tree.right);
        }
    }
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var tree = new BinaryTreeTraversal(scanner.nextInt());
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


