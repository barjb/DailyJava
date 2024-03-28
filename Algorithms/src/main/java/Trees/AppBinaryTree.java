package Trees;

public class AppBinaryTree {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(0);
        tree.add(1);
        tree.add(2);
        tree.add(-2);
        tree.add(-3);
        tree.add(-1);
        tree.BFS();
        System.out.println(tree.contains(1));
        System.out.println(tree.contains(5));
    }
}
