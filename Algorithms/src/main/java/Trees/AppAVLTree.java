package Trees;

public class AppAVLTree {
    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<>();
        tree.add(1);
        System.out.println("after 1");
        tree.add(2);
        System.out.println("after 2");
        tree.add(3);
        System.out.println("after 3");
        tree.add(4);
        System.out.println("after 4");
//        tree.DFS();
//        System.out.println("before");
//        System.out.println(tree.isBalanced(tree.root));
//        System.out.println("done");
    }
}
