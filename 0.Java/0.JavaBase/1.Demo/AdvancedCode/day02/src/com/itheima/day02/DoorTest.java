package com.itheima.day02;

public class DoorTest {
    public static void main(String[] args) {
        Door door = new Door(100, 200, "白色");
        door.openDoor();
        door.closeDoor();

        WoodDoor woodDoor = new WoodDoor(100, 200, "白色");
        woodDoor.openDoor();
        woodDoor.closeDoor();
    }
}
