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
            //ÿһ�������Ҷ�����һ��

            //�жϵ�ǰ��Ʒ�Ƿ��ܷ���

            //�ж��Ƿ����ֵ�÷���


        }
        return null;
    }

    public static void main(String[] args) {
        Item[] items = {
                new Item("ˮ", 3, 10),
                new Item("��", 1, 3),
                new Item("ʳ��", 2, 9),
                new Item("�п�", 2, 5),
                new Item("���", 1, 6)
        };

        int capacity = 6;

        List<Item> optimalItems = findOptimalItems(items, capacity);

        System.out.println("Optimal items to carry:");
        for (Item item : optimalItems) {
            System.out.println(item.getName());
        }
    }

}
