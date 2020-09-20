package com.itheima.day02;

public class Door {
    private int width;
    private int height;
    private String color;

    public Door() {
    }

    public Door(int width, int height, String color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void openDoor(){
        System.out.println("门已经打开，请进！");
    }

    public void closeDoor(){
        System.out.println("门已经关闭，禁止进入！");
    }
}
