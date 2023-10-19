package com.wy.guihua;

import java.util.List;

/**
 * @author: lichengcan
 * @date: 2023-10-18 18:52
 * @description
 **/
public class back {
    public static List<Item> findOptimalItems(Item[] items, int capacity) {

        for (int i = 0; i < capacity; i++) {
            //每一层容量我都遍历一遍

            //判断当前物品是否能放入

            //判断是否更加值得放入


        }
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
