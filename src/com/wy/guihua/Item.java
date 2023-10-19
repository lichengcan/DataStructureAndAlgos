package com.wy.guihua;

public class Item {
    private String name; // 物品的名称
    private int weight; // 物品的重量
    private int value; // 物品的价值

    // 构造函数，用于创建一个新物品
    public Item(String name, int weight, int value) {
        this.name = name;
        this.weight = weight;
        this.value = value;
    }

    // 获取物品名称
    public String getName() {
        return name;
    }

    // 获取物品重量
    public int getWeight() {
        return weight;
    }

    // 获取物品价值
    public int getValue() {
        return value;
    }

    // 根据需要，您可以在此添加其他方法和功能
}
