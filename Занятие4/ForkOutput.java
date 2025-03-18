package Algorithms.Lesson4;

import java.util.*;

class ForkOutput {
    private int val;
    private ForkOutput left;
    private ForkOutput right;

    public ForkOutput(int val) {
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
                    tree.right = new ForkOutput(val);
                    return;
                }
                tree = tree.right;
            } else if (tree.val > val) {
                if (tree.left == null) {
                    tree.left = new ForkOutput(val);
                    return;
                }
                tree = tree.left;
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
    public List<Integer> find() {
        List<Integer> result = new ArrayList<>();
        find(this, result);
        Collections.sort(result);
        return result;
    }
    private void find(ForkOutput node, List<Integer> result) {
        if (node == null) {
            return;
        }
        if (node.left != null && node.right != null) {
            result.add(node.val);
        }
        find(node.left, result);
        find(node.right, result);
    }
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var tree = new ForkOutput(scanner.nextInt());

        while (true) {
            var val = scanner.nextInt();
            if (val != 0) {
                if (!tree.Contain(val)) {
                    tree.Insert(val);
                }
            } else {
                break;
            }
        }
        List<Integer> fork = tree.find();
        for (int i = 0; i < fork.size(); i++) {
            System.out.print(fork.get(i));
            if (i < fork.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
        scanner.close();
    }
}
