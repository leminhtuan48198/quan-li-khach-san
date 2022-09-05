package controller;

import model.Room;
import storage.IReadWriteData;
import storage.ReadWriteFileRoom;

import java.util.ArrayList;
import java.util.List;

public class RoomController {
    private String name;

    public RoomController() {
    }

    public RoomController(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    static IReadWriteData iReadWriteData=new ReadWriteFileRoom();
    public static List<Room> roomList=iReadWriteData.readData();
    public void addNewRoom(Room room){
        roomList.add(room);
        iReadWriteData.writeData(roomList);
    }
    public void deleteRoomById(String roomId){
        int index=findRoomById(roomId);
        if(index>-1){
            roomList.remove(index);
            iReadWriteData.writeData(roomList);
        }

    }
    public void setRoomInformation(int index,Room room){
        roomList.get(index).setRoomId(room.getRoomId());
        roomList.get(index).setRoomType(room.getRoomType());
        roomList.get(index).setPrice(room.getPrice());

        iReadWriteData.writeData(roomList);
    }
    public int findRoomById(String roomId){
        for (int i = 0; i < roomList.size(); i++) {
            if(roomList.get(i).getRoomId().equals(roomId)){
                return i;
            }
        }

        return -1;
    }
    public void displayRooms(){
        for (int i = 0; i < roomList.size(); i++) {
            System.out.println(roomList.get(i).toString());
        }
    }
}
