package com.wy.guihua;

public class Item {
    private String name; // ��Ʒ������
    private int weight; // ��Ʒ������
    private int value; // ��Ʒ�ļ�ֵ

    // ���캯�������ڴ���һ������Ʒ
    public Item(String name, int weight, int value) {
        this.name = name;
        this.weight = weight;
        this.value = value;
    }

    // ��ȡ��Ʒ����
    public String getName() {
        return name;
    }

    // ��ȡ��Ʒ����
    public int getWeight() {
        return weight;
    }

    // ��ȡ��Ʒ��ֵ
    public int getValue() {
        return value;
    }

    // ������Ҫ���������ڴ�������������͹���
}
