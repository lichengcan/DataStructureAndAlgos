package com.wy.tree;

import java.util.LinkedList;

public class BinaryTree {
    //节点个数
    private int size;
    //根节点
    private Node root;

    public BinaryTree() {

    }

    //有参构造方法
    public BinaryTree(Integer[] c) {
        //这个this干啥的？
        this();
        root = addAllRecur(c);
    }

    //前序遍历数据创建二叉树（递归）
    private Node addAllRecur(Integer[] c) {
        //获取下一个值，size计数器
        Integer var = c[size++];
        //判断当前节点是否空
        if (var == null) {
            return null;
        }
        //创建节点
        Node node = new Node(var);
        //递归调用当前节点作为左子树
        node.left = addAllRecur(c);
        node.right = addAllRecur(c);
        //返回构建的字数的根节点
        return node;
    }

    //前序遍历，递归
    public void preOrderRecur() {
        preOrderRecur(root);
    }

    public void preOrderRecur(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " -> ");
        preOrderRecur(root.left);
        preOrderRecur(root.right);
    }

    //前序遍历，非递归
    public void preOrder() {
        if (root == null)
            return;
        Node current;
        //利用栈特点
        LinkedList<Node> s = new LinkedList<Node>();
        //头节点压栈
        s.addFirst(root);

        while (!s.isEmpty()) {
            //移除当前节点并返回给current
            current = s.removeFirst();
            //打印当前节点
            System.out.print(current.data + " -> ");
            //判断当前节点是否有右节点（先将右节点压栈，这样左节点就先出，后进先出）
            if (current.right != null)
                s.addFirst(current.right);
            if (current.left != null)
                s.addFirst(current.left);
        }
    }

    //中序遍历，递归
    public void inOrderRecur() {
        inOrderRecur(root);
    }

    public void inOrderRecur(Node root) {
        if (root == null) {
            return;
        }
        inOrderRecur(root.left);
        System.out.print(root.data + " -> ");
        inOrderRecur(root.right);
    }

    //中序遍历，非递归
    public void inOrder() {
        Node current = root;
        LinkedList<Node> s = new LinkedList<Node>();
        while (current != null || !s.isEmpty()) {
            while (current != null) {
                s.addFirst(current);
                current = current.left;
            }
            if (!s.isEmpty()) {
                current = s.removeFirst();
                System.out.print(current.data + " -> ");
                current = current.right;
            }
        }
    }

    //后序遍历，遍历
    public void postOrderRecur() {
        postOrderRecur(root);
    }

    public void postOrderRecur(Node root) {
        if (root == null) {
            return;
        }
        postOrderRecur(root.left);
        postOrderRecur(root.right);
        System.out.print(root.data + " -> ");
    }

    //后序遍历，非遍历
    public void postOrder() {
        Node current = root;
        LinkedList<Node> s1 = new LinkedList<Node>();
        LinkedList<Node> s2 = new LinkedList<Node>();
        while (current != null || !s1.isEmpty()) {
            while (current != null) {
                //s1起到前序遍历非递归2的作用
                s1.addFirst(current);
                s2.addFirst(current);
                current = current.right;
            }
            if (!s1.isEmpty()) {
                current = s1.removeFirst();
                current = current.left;
            }
        }
        while (!s2.isEmpty()) {
            System.out.print(s2.removeFirst().data + " -> ");
        }
    }

    //层次遍历
    public void levelOrder() {
        if (root == null) {
            return;
        }
        LinkedList<Node> q = new LinkedList<Node>();
        q.addFirst(root);
        Node current;
        while (!q.isEmpty()) {
            current = q.removeLast();
            System.out.print(current.data + " -> ");
            if (current.left != null)
                q.addFirst(current.left);
            if (current.right != null)
                q.addFirst(current.right);
        }
    }

    /* 用一维数组存储
     * 目前只支持完全二叉树
     */
    public Integer[] toArray() {
        //先用LinkedList存储一下，最后再转化为数组
        LinkedList<Integer> list = new LinkedList<Integer>();
        if (root == null) {
            return null;
        }
        LinkedList<Node> q = new LinkedList<Node>();
        q.addFirst(root);
        Node current;
        while (!q.isEmpty()) {
            current = q.removeLast();
            list.add(current.data);
            if (current.left != null)
                q.addFirst(current.left);
            if (current.right != null)
                q.addFirst(current.right);
        }
        //将list转化为数组
        Integer[] arr = new Integer[list.size()];
        arr = list.toArray(arr);
        return arr;
    }

    private static class Node {

        Integer data;
        Node right;
        Node left;

        Node(Integer data) {
            this.data = data;
        }
    }

}
