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
        //定义左右指针
        int left = 0;
        int right = arr.length - 1;
        //循环条件：左指针<=右指针
        while (left <= right) {
            //定义一个temp指针 初始值为arr的一半
            int temp = left + (right - left) / 2;
            //判断temp元素是否等于target
            if (arr[temp] == target) {
                return temp;
            }
            //中间值 大于 目标值，目标值 中间值
            if (arr[temp] > target)
                //右指针左移
                right=temp-1;
            else
                left=temp+1;
        }
        //找不到就 -1
        return -1;
    }

    // 二分查找算法实现
    static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;  // 防止可能的溢出

            // 检查中间元素
            if (arr[mid] == target)
                return mid;

            // 中间值小于目标值，中间值在左，目标值在右，所有左指针往右边找
            if (arr[mid] < target)
                left = mid + 1;

            // 中间值大于目标值
            else
                right = mid - 1;
        }

        // 如果我们到达这里，目标元素不存在
        return -1;
    }

}
