package com.wy.guihua;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: lichengcan
 * @date: 2023-10-18 18:52
 * @description
 **/
public class back {
    public static int[][] findOptimalItems(Item[] items, int capacity) {

        //如果是暴力破解：不考虑容量，每个商品有两种情况，放入、不放入，进行穷举，时间复杂度是 2的n次方
        //动态规划将大问题划分成一小块、最后将小块的答案合并以此解决大问题，时间复杂度是 n*m (物品数量*容量大小)
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
        System.out.println("6========================" + optimalItems[items.length - 1][capacity]);

        Item[] items1 = {
                new Item("帐篷", 20, 100),
                new Item("水壶", 10, 60),
                new Item("食品", 30, 120),
                new Item("雨衣", 15, 70),
                new Item("灯笼", 10, 50),
                new Item("睡袋", 25, 80),
                new Item("地图", 1, 150),
                new Item("刀具", 5, 60),
                new Item("防熊喷雾", 3, 40),
                new Item("医疗包", 10, 100),
                new Item("烹饪用具", 15, 60),
                new Item("爬山绳索", 12, 80),
                new Item("望远镜", 8, 100)
        };
        int maxWeight = 150;
        int[][] optimalItems1 = findOptimalItems(items1, maxWeight);
        System.out.println("150==============" + optimalItems1[items1.length - 1][maxWeight]);

        List<Item> selectedItems = maximizeValue(items1, maxWeight);
        System.out.println("Selected items:");
        int sum = 0;
        for (Item item : selectedItems) {
            sum += item.getValue();
            System.out.println(item.getName() + " - Weight: " + item.getWeight() + ", Value: " + item.getValue());
        }
        System.out.println("150Max==============" + sum);
    }


    public static List<Item> maximizeValue(Item[] items, int maxWeight) {
        int[][] dp = new int[items.length + 1][maxWeight + 1];

        for (int i = 1; i <= items.length; i++) {
            Item item = items[i - 1];
            for (int j = 1; j <= maxWeight; j++) {
                if (item.getWeight() > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], item.getValue() + dp[i - 1][j - item.getWeight()]);
                }
            }
        }

        // Backtracking to find the items included
        List<Item> selectedItems = new ArrayList<>();
        int remainingWeight = maxWeight;
        for (int i = items.length; i > 0; i--) {
            if (dp[i][remainingWeight] != dp[i - 1][remainingWeight]) {
                Item item = items[i - 1];
                selectedItems.add(item);
                remainingWeight -= item.getWeight();
            }
        }

        Collections.reverse(selectedItems);
        return selectedItems;
    }

}
