package Trees;

import java.util.Objects;

public class AVLTree<T extends Comparable<T>> extends BinaryTree<T> {
    @Override
    public void add(T value) {
        super.add(value);
        updateBalanceFactor(root);
        while (!isBalanced(root)) {
            Node<T> unbalanced = findUnbalanced(root);
            if (Objects.nonNull(unbalanced.left) && Math.abs(((AVLNode<T>) unbalanced.left).getBf()) > 1) {
                balanceTree(unbalanced, unbalanced.left);
            } else if (Objects.nonNull(unbalanced.right) && Math.abs(((AVLNode<T>) unbalanced.right).getBf()) > 1) {
                balanceTree(unbalanced, unbalanced.right);
            }
//            balanceTree(null, root);
            updateBalanceFactor(root);
        }
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

    public int updateBalanceFactor(Node<T> node) {
        if (Objects.isNull(node)) {
            return 0;
        }
        int heightLeft = updateBalanceFactor(node.left);
        int heightRight = updateBalanceFactor(node.right);
        int height = Math.max(heightLeft, heightRight) + 1;
        ((AVLNode<T>) node).setBf(heightLeft - heightRight);
        return height;
    }

    public int getHeight(Node<T> node) {
        if (Objects.isNull(node)) {
            return 0;
        }
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    @Override
    protected void recursiveDFS(Node<T> node) {
        if (node != null) {
            System.out.println("N(" + node.getValue() + ") " + ((AVLNode<T>) node).getBf());
            recursiveDFS(node.getLeft());
            recursiveDFS(node.getRight());
        }
    }

    public void rotateLeft(Node<T> parent, Node<T> node) {
        Node<T> y = node.right;
        node.right = y.left;
        if (parent == null) {
            y.left = node;
            root = y;
        } else if (parent.left == node) {
            parent.left = y;
        } else if (parent.right == node) {
            parent.right = y;
        }
        y.left = node;
    }

    public void rotateRight(Node<T> parent, Node<T> node) {
        Node<T> x = node.left;
        node.left = x.right;
        if (parent == null) {
            root = x;
        } else if (parent.right == node) {
            parent.right = x;
        } else if (parent.left == node) {
            parent.left = x;
        }
        x.right = node;
    }

    public void leftRight(Node<T> parent, Node<T> node) {
        rotateLeft(node, node.left);
        rotateRight(parent, node);
    }

    public void rightLeft(Node<T> parent, Node<T> node) {
        rotateRight(node, node.right);
        rotateLeft(parent, node);
    }

    public Node<T> findUnbalanced(Node<T> node) {
        if (Objects.isNull(node)) {
            return null;
        }
        if ((Objects.nonNull(node.left) && Math.abs(((AVLNode<T>) node.left).getBf()) > 1) || (Objects.nonNull(node.right) && Math.abs(((AVLNode<T>) node.right).getBf()) > 1)) {
            return node;
        }
        Node<T> left = findUnbalanced(node.left);
        Node<T> right = findUnbalanced(node.right);
        return Objects.nonNull(left) ? left : right;

    }

    public void balanceTree(Node<T> parent, Node<T> node) {

        if (Math.abs(((AVLNode<T>) node).getBf()) > 1) {
            if (Objects.nonNull(node.left) && Math.abs(((AVLNode<T>) node.left).getBf()) > 1) {
                balanceTree(node, node.left);
            } else if (Objects.nonNull(node.right) && Math.abs(((AVLNode<T>) node.right).getBf()) > 1) {
                balanceTree(node, node.right);
            } else if (((AVLNode<T>) node).getBf() > 0) {
                // node.left cannot be null here due to BF value
                if (node.left.left != null && node.left.right == null) {
                    rotateRight(parent, node);
                } else {
                    leftRight(parent, node);
                }
            } else if (((AVLNode<T>) node).getBf() < 0) {
                // node.right cannot be null here due to BF value
                if (node.right.right != null && node.right.left == null) {
                    rotateLeft(parent, node);
                } else {
                    rightLeft(parent, node);
                }
            }
        }
    }

    public boolean isBalanced(Node<T> node) {
        if (node == null) return true;
        if (Math.abs(((AVLNode<T>) node).getBf()) > 1) {
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);
    }
}
