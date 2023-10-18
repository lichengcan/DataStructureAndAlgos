package com.wy.tree;

public class Demo {

	public static void main(String[] args) {
		//ǰ���������
		Integer[] arr = { 1, 2, 4, null, null, 5, null, null, 3, null, null };
		BinaryTree tree = new BinaryTree(arr);
		System.out.print("ǰ�����(�ݹ�)��");
		tree.preOrderRecur();
		System.out.println();

		System.out.print("ǰ�����(�ǵݹ�)��");
		tree.preOrder();
		System.out.println();

		System.out.print("�������(�ݹ�)��");
		tree.inOrderRecur();
		System.out.println();

		System.out.print("�������(�ǵݹ�)��");
		tree.inOrder();
		System.out.println();

		System.out.print("����������ݹ飩��");
		tree.postOrderRecur();
		System.out.println();

		System.out.print("�������(�ǵݹ�)��");
		tree.postOrder();
		System.out.println();

		System.out.print("��α�����");
		tree.levelOrder();
		System.out.println();

		System.out.print("һά����洢��");
		Integer[] array = tree.toArray();
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ",");
		}
	}
}
