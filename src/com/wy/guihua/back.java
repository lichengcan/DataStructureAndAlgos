package com.wy.guihua;

/**
 * @author: lichengcan
 * @date: 2023-10-18 18:52
 * @description
 **/
public class back {
    public static int[][] findOptimalItems(Item[] items, int capacity) {

        //��̬�滮�������⻮�ֳ�һС�顢���С��Ĵ𰸺ϲ��Դ˽��������
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
        System.out.println(optimalItems[items.length - 1][capacity]);
    }

}
