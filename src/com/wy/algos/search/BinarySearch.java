package com.wy.algos.search;

/**
 * �ǵݹ���ʽ
 *
 * @author Administrator
 */
public class BinarySearch {
    int search(int num[], int key) {
        int low = 0;
        int high = num.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (num[mid] < key) {
                low = mid + 1;
            } else if (num[mid] > key) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        // ��������Ҫ���������飨����������ģ�
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        // ����Ҫ���ҵ�Ŀ��ֵ
        int target = 7;

        int result = binarySearch(arr, target);
        int result1 = binarySearch1(arr, target);

        if (result == -1) {
            System.out.println("Element not present");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }

    private static int binarySearch1(int[] arr, int target) {

        return 0;
    }

    // ���ֲ����㷨ʵ��
    static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;  // ��ֹ���ܵ����

            // ����м�Ԫ��
            if (arr[mid] == target)
                return mid;

            // ���Ŀ��ֵ�����м�Ԫ�أ���ֻ�����Ұ벿��
            if (arr[mid] < target)
                left = mid + 1;

                // ���Ŀ��ֵС���м�Ԫ�أ���ֻ������벿��
            else
                right = mid - 1;
        }

        // ������ǵ������Ŀ��Ԫ�ز�����
        return -1;
    }

}
