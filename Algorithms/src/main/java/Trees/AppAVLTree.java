package Trees;

public class AppAVLTree {
    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<>();
        tree.add(33);
        tree.add(13);
        tree.add(53);
        tree.add(11);
        tree.add(21);
        tree.add(61);
        tree.add(8);
        tree.add(9);
        tree.add(52);
        tree.add(50);
        tree.add(49);
        tree.DFS();
//
//        tree.delete(49);
//        tree.DFS();
//        tree.delete(9);
//        System.out.println("LAST");
//        tree.DFS();
    }
}
