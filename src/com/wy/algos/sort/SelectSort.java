package com.wy.algos.sort;
/**
 * ѡ������
 * @author Administrator
 *
 */
public class SelectSort {
	public static void main(String[] args) {
		int num[] = { 3, 1, 5, 4, 123, 55, 33, 123 };
		new SelectSort().sort(num);
		for (int n : num) {
			System.out.print(n + " ");
		}
	}
	void sort(int num[]){
		for(int i=0;i<num.length-1;i++){
			int min = i;
			for(int j=i+1;j<num.length;j++){
				if(num[min]>num[j]){
					min = j;
				}
			}
			//min �������С��
			//num �����ҵ��ı�min��С����
			//i �� num��Ӧ���±�
			//exec����i�±��min�±��ֵ���л���
			if(min!=i)
				Utils.exec(num,i,min);
		}
	}
}
