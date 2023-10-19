package com.wy.algos.search;

/**
 * 非递归形式
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
        // 这是我们要搜索的数组（必须是有序的）
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        // 我们要查找的目标值
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

    // 二分查找算法实现
    static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;  // 防止可能的溢出

            // 检查中间元素
            if (arr[mid] == target)
                return mid;

            // 如果目标值大于中间元素，则只考虑右半部分
            if (arr[mid] < target)
                left = mid + 1;

                // 如果目标值小于中间元素，则只考虑左半部分
            else
                right = mid - 1;
        }

        // 如果我们到达这里，目标元素不存在
        return -1;
    }

}
