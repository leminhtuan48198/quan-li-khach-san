package model;

import java.io.Serializable;

public class Room implements Serializable {
    private String roomId;
    private String roomType;
    private double price;

    public Room() {
    }

    public Room(String roomId, String roomType, double price) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.price = price;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId='" + roomId + '\'' +
                ", roomType='" + roomType + '\'' +
                ", price=" + price +
                '}';
    }
}
