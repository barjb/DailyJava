package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T extends Comparable<T>> {
    protected Node<T> root;

    public void add(T value) {
        root = addRecursive(root, value);
    }

    public Node<T> addRecursive(Node<T> current, T value) {
        if (current == null) {
            return new Node<>(value);
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

    public boolean contains(T value) {
        return containsRecursive(root, value);
    }

    public boolean containsRecursive(Node<T> current, T value) {
        if (current == null) return false;
        if (current.getValue().compareTo(value) == 0) return true;
        return (current.getValue().compareTo(value) > 0) ? containsRecursive(current.getLeft(), value) : containsRecursive(current.getRight(), value);

    }

    public void DFS() {
        recursiveDFS(root);
    }

    protected void recursiveDFS(Node<T> node) {
        if (node != null) {
            System.out.print("N(" + node.getValue() + ") ");
            recursiveDFS(node.getLeft());
            recursiveDFS(node.getRight());
        }
    }

    public void BFS() {
        if (root == null) {
            return;
        }
        Queue<Node<T>> children = new LinkedList<>();
        children.add(root);
        while (!children.isEmpty()) {
            Node<T> node = children.remove();
            System.out.print(node.getValue() + " ");
            if (node.getLeft() != null) {
                children.add(node.getRight());
            }
            if (node.getLeft() != null) {
                children.add(node.getRight());
            }
        }
    }
}
