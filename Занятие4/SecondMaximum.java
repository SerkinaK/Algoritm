package Algorithms.Lesson4;

import java.util.*;

class SecondMaximum {
    private int val;
    private SecondMaximum left;
    private SecondMaximum right;

    public SecondMaximum(int val){
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
                    tree.right = new SecondMaximum(val);
                    return;
                }
                tree= tree.right;
            }
            else if (tree.val > val){
                if (tree.left == null){
                    tree.left= new SecondMaximum(val);
                    return;
                }
                tree=tree.left;
            }
        }
    }
    public int find() {
        ArrayList<Integer> values = new ArrayList<>();
        add(this, values);
        Collections.sort(values);
        return values.get(values.size() - 2);
    }
    private void add(SecondMaximum node, ArrayList<Integer> values) {
        if (node != null) {
            add(node.left, values);
            values.add(node.val);
            add(node.right, values);
        }
    }
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var tree = new SecondMaximum(scanner.nextInt());

        while (true){
            var val = scanner.nextInt();
            if (val != 0 ){
                tree.Insert(val);
            }
            else{
                break;
            }
        }
        System.out.println(tree.find());
        scanner.close();
    }
}
