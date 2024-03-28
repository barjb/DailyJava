package Trees;

import java.util.Objects;

public class AVLTree<T extends Comparable<T>> extends BinaryTree<T> {
    @Override
    public void add(T value) {
        super.add(value);
        updateBalanceFactor(root);
        System.out.println("balance factor");
        recursiveDFS(root);
        while (!isBalanced(root)) {
            balanceTree(null, root);
            updateBalanceFactor(root);
            System.out.println("new while() balance factor");
            recursiveDFS(root);
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
        if (y.left != null) {
            node.right = y.left;
        }
        if (parent == null) {
            y.left = node;
            root = y;
        } else if (parent.left == node) {
            parent.left = y;
        } else {
            parent.right = y;
        }
        y.left = node;
    }

    public void rotateRight(Node<T> parent, Node<T> node) {
        Node<T> x = node.left;
        if (x.right != null) {
            node.left = x.right;
        }
        if (parent == null) {
            x.right = node;
            root = x;
        } else if (parent.right == node) {
            parent.right = x;
        } else {
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

    public void balanceTree(Node<T> parent, Node<T> node) {
        if (Math.abs(((AVLNode<T>) node).getBf()) > 1) {
            if (Objects.nonNull(node.left) && Math.abs(((AVLNode<T>) node.left).getBf()) > 1) {
                balanceTree(node, node.left);
            } else if (Objects.nonNull(node.right) && Math.abs(((AVLNode<T>) node.right).getBf()) > 1) {
                balanceTree(node, node.right);
            }
            if (((AVLNode<T>) node).getBf() > 0) {
                if(node.left.getLeft() != null){
                    rotateRight(node,node.left);
                }else {
                    leftRight(parent,node);
                }
            } else if (((AVLNode<T>) node).getBf() < 0) {
                if(node.right.getRight() != null){
                    rotateLeft(node,node.right);
                }else {
                    rightLeft(parent,node);
                }
            }
        }
    }

    public boolean isBalanced(Node<T> node) {
        if (node == null) return true;

        if ((Objects.nonNull(node.left) && Math.abs(((AVLNode<T>) node.left).getBf()) <= 1) ||
                (Objects.nonNull(node.right) && Math.abs(((AVLNode<T>) node.right).getBf()) <= 1)) {
            return isBalanced(node.left) && isBalanced(node.right);
        }
        if (Objects.isNull(node.left) && Objects.isNull(node.right)) return true;
        return false;
    }
}
