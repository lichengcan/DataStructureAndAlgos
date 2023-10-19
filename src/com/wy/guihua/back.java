package com.wy.guihua;

import java.util.List;

/**
 * @author: lichengcan
 * @date: 2023-10-18 18:52
 * @description
 **/
public class back {
    public static List<Item> findOptimalItems(Item[] items, int capacity) {

        //����for����һ������У����� ˮ���顢ʳ�������
        //�ڶ��������С����capacity�ֳ�1��2��3��4��5��6....С�ݵ�
        //ÿ���жϵ�ǰ��ά����Ӧ�÷�ʲôֵ���� (hang - 1, lie) ���бȽϣ�������뵱ǰ�и������滻
        final int rowLength = items.length;
        int[][] res = new int[rowLength][capacity+1];
        for (int row = 0; row < items.length; row++) {
            for (int col = 0; col <= capacity; col++) {
                //�жϵ�ǰ��Ʒ�Ƿ��ܷ���
                Item item = items[row];
                if (item.getWeight() <= col) {
                    if (row > 0) {
                        //��ǰ��ֵ > ��һ��������ֵ
                        if (item.getValue() > res[row - 1][col]) {
                            res[row][col] = item.getValue();
                        } else {
                            res[row][col] = res[row - 1][col];
                        }
                    } else {
                        //��ʼ��
                        res[row][col]=item.getValue();
                    }
                }else {
                    //ɶҲ�Ų���
                    res[row][col]=0;
                }
            }
        }

        //�ж��Ƿ����ֵ�÷���


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
