package com.wy.tree;

public class Demo {

	public static void main(String[] args) {
		//前序遍历建树
		Integer[] arr = { 1, 2, 4, null, null, 5, null, null, 3, null, null };
		BinaryTree tree = new BinaryTree(arr);
		System.out.print("前序遍历(递归)：");
		tree.preOrderRecur();
		System.out.println();

		System.out.print("前序遍历(非递归)：");
		tree.preOrder();
		System.out.println();

		System.out.print("中序遍历(递归)：");
		tree.inOrderRecur();
		System.out.println();

		System.out.print("中序遍历(非递归)：");
		tree.inOrder();
		System.out.println();

		System.out.print("后序遍历（递归）：");
		tree.postOrderRecur();
		System.out.println();

		System.out.print("后序遍历(非递归)：");
		tree.postOrder();
		System.out.println();

		System.out.print("层次遍历：");
		tree.levelOrder();
		System.out.println();

		System.out.print("一维数组存储：");
		Integer[] array = tree.toArray();
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ",");
		}
	}
}
