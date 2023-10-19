package com.wy.algos.sort;
/**
 * 选择排序
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
			//min 定义的最小数
			//num 是新找到的比min更小的数
			//i 是 num对应的下标
			//exec：将i下标和min下标的值进行互换
			if(min!=i)
				Utils.exec(num,i,min);
		}
	}
}
