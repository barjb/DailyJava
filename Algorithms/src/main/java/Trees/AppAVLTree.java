package Trees;

public class AppAVLTree {
    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<>();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.DFS();
    }
}
