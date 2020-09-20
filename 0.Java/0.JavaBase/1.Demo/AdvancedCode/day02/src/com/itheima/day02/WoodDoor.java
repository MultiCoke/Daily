package com.itheima.day02;

public class WoodDoor extends Door {
    public WoodDoor() {
    }

    public WoodDoor(int width, int height, String color) {
        super(width, height, color);
    }

    @Override
    public void openDoor() {
        System.out.println("width:" + getWidth() + "cm, " + "height:" + getHeight() + "cm, "
                            + "color:" + getColor() + "门已经打开，请进");
    }

    @Override
    public void closeDoor() {
        System.out.println("width:" + getWidth() + "cm, " + "height:" + getHeight() + "cm, "
                + "color:" + getColor() + "门已经关闭，禁止进入！");
    }
}
