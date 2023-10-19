package com.wy.guihua;

/**
 * @author: lichengcan
 * @date: 2023-10-18 18:52
 * @description
 **/
public class back {
    public static int[][] findOptimalItems(Item[] items, int capacity) {

        //动态规划将大问题划分成一小块、最后将小块的答案合并以此解决大问题
        //两层for，第一层遍历行，就是 水、书、食物。。。。
        //第二层遍历大小，将capacity分成1，2，3，4，5，6....小份的
        //每次判断当前二维数组应该放什么值，和 (hang - 1, lie) 进行比较，如果加入当前行更大则替换
        final int rowLength = items.length;
        int[][] res = new int[rowLength][capacity + 1];
        for (int row = 0; row < items.length; row++) {
            for (int col = 0; col <= capacity; col++) {
                // 判断当前物品是否能放入
                final Item item = items[row];
                if (item.getWeight() <= col) {
                    if (row == 0) {
                        // 第一行，没有之前的物品，所以直接是当前物品的价值
                        res[row][col] = item.getValue();
                    } else {
                        // 当前物品价值 + 剩余空间的价值 与 上一行（不包括当前物品）的价值进行比较
                        int currentValue = item.getValue() + res[row - 1][col - item.getWeight()];
                        int lastValue = res[row - 1][col];
                        if (currentValue > lastValue) {
                            res[row][col] = currentValue;
                        } else {
                            res[row][col] = lastValue;
                        }
                    }
                } else {
                    if (row == 0) {
                        // 第一行，且当前物品放不进去，价值为0
                        res[row][col] = 0;
                    } else {
                        // 当前物品放不进去，继承之前物品在相同容量下的价值
                        res[row][col] = res[row - 1][col];
                    }
                }

            }
        }
        return res;
    }

    public static void main(String[] args) {
        Item[] items = {
                new Item("水", 3, 10),
                new Item("书", 1, 3),
                new Item("食物", 2, 9),
                new Item("夹克", 2, 5),
                new Item("相机", 1, 6)
        };
        int capacity = 6;
        int[][] optimalItems = findOptimalItems(items, capacity);
        System.out.println(optimalItems[items.length - 1][capacity]);
    }

}
