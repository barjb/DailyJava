package Trees;

import java.util.Objects;

public class AVLNode<T extends Comparable<T>> extends Node<T> {
    private int bf;

    public AVLNode(T value) {
        super(value);
    }

    public int getBf() {
        return bf;
    }
    public void setBf(int value){
        bf = value;
    }
    @Override
    public void setLeft(Node<T> node) {
        if (!(node instanceof AVLNode)) throw new IllegalArgumentException("Argument must be AVLNode instance");
        this.left = node;
    }

    @Override
    public void setRight(Node<T> node) {
        if (!(node instanceof AVLNode)) throw new IllegalArgumentException("Argument must be AVLNode instance");
        this.right = node;
    }


}
