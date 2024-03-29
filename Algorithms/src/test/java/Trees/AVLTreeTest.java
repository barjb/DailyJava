package Trees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


class AVLTreeTest {

    private AVLTree<Integer> tree;
    private AVLNode<Integer> N33;
    private AVLNode<Integer> N13;
    private AVLNode<Integer> N53;
    private AVLNode<Integer> N11;
    private AVLNode<Integer> N21;
    private AVLNode<Integer> N61;
    private AVLNode<Integer> N8;
    private AVLNode<Integer> N9;
    @BeforeEach
    void setUp() {
        tree = new AVLTree<Integer>();
        N33 = new AVLNode<>(33);
        N13 = new AVLNode<>(13);
        N53 = new AVLNode<>(53);
        N11 = new AVLNode<>(11);
        N21 = new AVLNode<>(21);
        N61 = new AVLNode<>(61);
        N8= new AVLNode<>(8);
        N9 = new AVLNode<>(9);

        N8.right = N9;
        N11.left = N8;
        N13.left = N11;
        N13.right = N21;
        N53.right = N61;
        N33.left = N13;
        N33.right = N53;
        tree.root = N33;
        tree.updateBalanceFactor(tree.root);
    }
    @Test
    void testIsBalanced() {
        assertEquals(false, tree.isBalanced(tree.root));
    }

    @Test
    void testBalancing(){
        tree.updateBalanceFactor(tree.root);
        tree.balanceTree(null,tree.root);
        while (!tree.isBalanced(tree.root)){
            tree.balanceTree(null,tree.root);
        }
    }

    @Test
    void testRotateLeft() {
        assertEquals(false, tree.isBalanced(tree.root));
        tree.rotateLeft(N11,N8);
        assertEquals(N9.left, N8);
    }
    @Test
    void testRotateRight(){
        assertEquals(false,tree.isBalanced(tree.root));
        Node<Integer> N60 = new Node<>(60);
        N61.left = N60;
        tree.rotateRight(N53,N61);
        assertEquals(N60.right,N61);
    }
    @Test
    void testRotateLeftRoot(){
        tree.root = new Node<Integer>(0);
        tree.root.right = new Node<>(1);
        tree.rotateLeft(null,tree.root);
        assertEquals(1,tree.root.value);
        assertEquals(0,tree.root.left.value);
    }
    @Test
    void testRotateRightRoot(){
        tree.root = new Node<Integer>(0);
        tree.root.left = new Node<>(-1);
        tree.rotateRight(null,tree.root);
        assertEquals(-1,tree.root.value);
        assertEquals(0,tree.root.right.value);
    }

}