package Trees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class AVLTreeTest {

    private AVLTree<Integer> tree;

    @BeforeEach
    void setUp() {
        tree = new AVLTree<Integer>();
        AVLNode<Integer> one = new AVLNode<>(33);
        AVLNode<Integer> two = new AVLNode<>(13);
        AVLNode<Integer> three = new AVLNode<>(53);
        AVLNode<Integer> four = new AVLNode<>(11);
        AVLNode<Integer> five = new AVLNode<>(21);
        AVLNode<Integer> six = new AVLNode<>(61);
        AVLNode<Integer> seven = new AVLNode<>(8);
        seven.right = new AVLNode<>(9);

        four.left = seven;
        two.left = four;
        two.right = five;
        three.right = six;
        one.left = two;
        one.right = three;
        tree.root = one;
    }

    @Test
    void testCountBalance() {
//        tree.updateBalanceFactor(tree.root);

    }

    @Test
    void testRotateLeft() {
        assertEquals(false, tree.isBalanced(tree.root));
        tree.rotateLeft(tree.root.left.left, tree.root.left.left.left);
        assertEquals(true, tree.isBalanced(tree.root));
    }
}