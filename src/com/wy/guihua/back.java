package com.wy.guihua;

import java.util.List;

/**
 * @author: lichengcan
 * @date: 2023-10-18 18:52
 * @description
 **/
public class back {
    public static List<Item> findOptimalItems(Item[] items, int capacity) {

        //两层for，第一层遍历行，就是 水、书、食物。。。。
        //第二层遍历大小，将capacity分成1，2，3，4，5，6....小份的
        //每次判断当前二维数组应该放什么值，和 (hang - 1, lie) 进行比较，如果加入当前行更大则替换
        final int rowLength = items.length;
        int[][] res = new int[rowLength][capacity+1];
        for (int row = 0; row < items.length; row++) {
            for (int col = 0; col <= capacity; col++) {
                //判断当前物品是否能放入
                Item item = items[row];
                if (item.getWeight() <= col) {
                    if (row > 0) {
                        //当前价值 > 上一个容量价值
                        if (item.getValue() > res[row - 1][col]) {
                            res[row][col] = item.getValue();
                        } else {
                            res[row][col] = res[row - 1][col];
                        }
                    } else {
                        //初始化
                        res[row][col]=item.getValue();
                    }
                }else {
                    //啥也放不了
                    res[row][col]=0;
                }
            }
        }

        //判断是否更加值得放入


        return null;
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

        List<Item> optimalItems = findOptimalItems(items, capacity);

        System.out.println("Optimal items to carry:");
        for (Item item : optimalItems) {
            System.out.println(item.getName());
        }
    }

}
