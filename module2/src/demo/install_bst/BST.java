package demo.install_bst;

import java.util.LinkedList;
import java.util.Queue;

public class BST<E extends Comparable<E>> extends AbstractTree<E> {
    protected TreeNode<E> root;
    protected int size = 0;

    public BST() {

    }

    public BST(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            insert(objects[i]);
    }

    @Override
    public boolean insert(E e) {
        if (root == null)
            root = createNewNode(e); /*create a new root*/
        else {
            /*locate the parent node*/
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else
                    return false; /*Duplicate node not inserted*/
            }
            if (e.compareTo(parent.element) < 0)
                parent.left = createNewNode(e);
            else
                parent.right = createNewNode(e);
        }
        size++;
        return true; /*element inserted successfully*/
    }

    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }

    @Override
    public void inorder() {
        inorder(root);
    }

    protected void inorder(TreeNode<E> root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.element + " ");
        inorder(root.right);
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void postorder() {
        postorder(root);
    }

    protected void postorder(TreeNode<E> root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.element + " ");
    }

    @Override
    public void preorder() {
        preorder(root);
    }

    protected void preorder(TreeNode<E> root) {
        if (root == null) return;
        System.out.print(root.element + " ");
        preorder(root.left);
        preorder(root.right);
    }

    @Override
    public void breathFirst() {
        breathFirst(root);
    }

    public void deleteNode(E key) {
        root = deleteNode(root, key);
    }

    private TreeNode deleteNode(TreeNode<E> root, E key) {
        if (root == null) return null;
        if (key.compareTo(root.element) < 0) {
            root.left = deleteNode(root.left, key);
        } else {
            if (key.compareTo(root.element) > 0) {
                root.right = deleteNode(root.right, key);
            } else {
                //if same
                if (root.left == null) return root.right;
                if (root.right == null) return root.left;
                //otherwise, find min at right subtree
                TreeNode<E> temp = root.right;
                while (temp != null) {
                    if (temp.left == null) break;
                    temp = temp.left;
                }
                E min_at_right = temp.element;
                root.element = min_at_right;
                root.right = deleteNode(root.right, min_at_right);
            }
        }
        return root;
    }

    public boolean search(E key) {
        return search(root, key);
    }

    private boolean search(TreeNode<E> root, E key) {
        if (root == null) return false;
        if (key.compareTo(root.element) < 0)
            return search(root.left, key);
        else if (key.compareTo(root.element) > 0)
            return search(root.right, key);
        else
            return true;
    }

    protected void breathFirst(TreeNode<E> root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return;
        queue.add(root);
        TreeNode<E> temp;
        while (!queue.isEmpty()) {
            temp = queue.peek();
            System.out.print(queue.poll().element + " ");

            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }
}
