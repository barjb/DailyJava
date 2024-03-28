package Trees;

import java.util.Objects;

public class AVLTree<T extends Comparable<T>> extends BinaryTree<T> {
    @Override
    public void add(T value) {
        super.add(value);
        balanceTree(root);
    }

    @Override
    public Node<T> addRecursive(Node<T> current, T value) {
        if (current == null) {
            return new AVLNode<>(value);
        }
        if (current.getValue().compareTo(value) > 0) {
            current.setLeft(addRecursive(current.getLeft(), value));
        } else if (current.getValue().compareTo(value) < 0) {
            current.setRight(addRecursive(current.getRight(), value));
        } else {
            return current;
        }
        return current;
    }

    private void balanceTree(Node<T> node) {
        if (node == null) return;
        updateBalanceFactor(node);
        balanceTree(node.left);
        balanceTree(node.right);
    }


    public int updateBalanceFactor(Node<T> node) {
        if (Objects.isNull(node)) {
            return 0;
        }
        int bf = updateBalanceFactor(node.getLeft()) - updateBalanceFactor(node.getRight());
        ((AVLNode<T>) node).setBf(bf);
        return bf;
    }

    @Override
    protected void recursiveDFS(Node<T> node) {
        if (node != null) {
            System.out.println("N(" + node.getValue() + ") " + ((AVLNode<T>) node).getBf());
            recursiveDFS(node.getLeft());
            recursiveDFS(node.getRight());
        }
    }
}
