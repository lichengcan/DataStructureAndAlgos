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

        //����Ǳ����ƽ⣺������������ÿ����Ʒ��������������롢�����룬������٣�ʱ�临�Ӷ��� 2��n�η�
        //��̬�滮�������⻮�ֳ�һС�顢���С��Ĵ𰸺ϲ��Դ˽�������⣬ʱ�临�Ӷ��� n*m (��Ʒ����*������С)
        //����for����һ������У����� ˮ���顢ʳ�������
        //�ڶ��������С����capacity�ֳ�1��2��3��4��5��6....С�ݵ�
        //ÿ���жϵ�ǰ��ά����Ӧ�÷�ʲôֵ���� (hang - 1, lie) ���бȽϣ�������뵱ǰ�и������滻
        final int rowLength = items.length;
        int[][] res = new int[rowLength][capacity + 1];
        for (int row = 0; row < items.length; row++) {
            for (int col = 0; col <= capacity; col++) {
                // �жϵ�ǰ��Ʒ�Ƿ��ܷ���
                final Item item = items[row];
                if (item.getWeight() <= col) {
                    if (row == 0) {
                        // ��һ�У�û��֮ǰ����Ʒ������ֱ���ǵ�ǰ��Ʒ�ļ�ֵ
                        res[row][col] = item.getValue();
                    } else {
                        // ��ǰ��Ʒ��ֵ + ʣ��ռ�ļ�ֵ �� ��һ�У���������ǰ��Ʒ���ļ�ֵ���бȽ�
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
                        // ��һ�У��ҵ�ǰ��Ʒ�Ų���ȥ����ֵΪ0
                        res[row][col] = 0;
                    } else {
                        // ��ǰ��Ʒ�Ų���ȥ���̳�֮ǰ��Ʒ����ͬ�����µļ�ֵ
                        res[row][col] = res[row - 1][col];
                    }
                }

            }
        }
        return res;
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
        int[][] optimalItems = findOptimalItems(items, capacity);
        System.out.println("6========================" + optimalItems[items.length - 1][capacity]);

        Item[] items1 = {
                new Item("����", 20, 100),
                new Item("ˮ��", 10, 60),
                new Item("ʳƷ", 30, 120),
                new Item("����", 15, 70),
                new Item("����", 10, 50),
                new Item("˯��", 25, 80),
                new Item("��ͼ", 1, 150),
                new Item("����", 5, 60),
                new Item("��������", 3, 40),
                new Item("ҽ�ư�", 10, 100),
                new Item("����þ�", 15, 60),
                new Item("��ɽ����", 12, 80),
                new Item("��Զ��", 8, 100)
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
