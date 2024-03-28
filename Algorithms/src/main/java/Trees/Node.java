package Trees;

public class Node<T extends Comparable> {
    protected T value;
    protected Node<T> left;
    protected Node<T> right;
    public Node(T value){
        this.value = value;
        left = null;
        right = null;
    }
    public void setLeft(Node<T> node){
        left = node;
    }
    public void setRight(Node<T> node){
        right = node;
    }
    public void setValue(T value){
        this.value = value;
    }
    public T getValue() {
        return value;
    }

    public Node<T> getLeft() {
        return left;
    }

    public Node<T> getRight() {
        return right;
    }
}
