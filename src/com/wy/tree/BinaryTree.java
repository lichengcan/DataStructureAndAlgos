package com.wy.tree;

import java.util.LinkedList;

public class BinaryTree {
    //�ڵ����
    private int size;
    //���ڵ�
    private Node root;

    public BinaryTree() {

    }

    //�вι��췽��
    public BinaryTree(Integer[] c) {
        //���this��ɶ�ģ�
        this();
        root = addAllRecur(c);
    }

    //ǰ��������ݴ������������ݹ飩
    private Node addAllRecur(Integer[] c) {
        //��ȡ��һ��ֵ��size������
        Integer var = c[size++];
        //�жϵ�ǰ�ڵ��Ƿ��
        if (var == null) {
            return null;
        }
        //�����ڵ�
        Node node = new Node(var);
        //�ݹ���õ�ǰ�ڵ���Ϊ������
        node.left = addAllRecur(c);
        node.right = addAllRecur(c);
        //���ع����������ĸ��ڵ�
        return node;
    }

    //ǰ��������ݹ�
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

    //ǰ��������ǵݹ�
    public void preOrder() {
        if (root == null)
            return;
        Node current;
        //����ջ�ص�
        LinkedList<Node> s = new LinkedList<Node>();
        //ͷ�ڵ�ѹջ
        s.addFirst(root);

        while (!s.isEmpty()) {
            //�Ƴ���ǰ�ڵ㲢���ظ�current
            current = s.removeFirst();
            //��ӡ��ǰ�ڵ�
            System.out.print(current.data + " -> ");
            //�жϵ�ǰ�ڵ��Ƿ����ҽڵ㣨�Ƚ��ҽڵ�ѹջ��������ڵ���ȳ�������ȳ���
            if (current.right != null)
                s.addFirst(current.right);
            if (current.left != null)
                s.addFirst(current.left);
        }
    }

    //����������ݹ�
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

    //����������ǵݹ�
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

    //�������������
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

    //����������Ǳ���
    public void postOrder() {
        Node current = root;
        LinkedList<Node> s1 = new LinkedList<Node>();
        LinkedList<Node> s2 = new LinkedList<Node>();
        while (current != null || !s1.isEmpty()) {
            while (current != null) {
                //s1��ǰ������ǵݹ�2������
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

    //��α���
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

    /* ��һά����洢
     * Ŀǰֻ֧����ȫ������
     */
    public Integer[] toArray() {
        //����LinkedList�洢һ�£������ת��Ϊ����
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
        //��listת��Ϊ����
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
