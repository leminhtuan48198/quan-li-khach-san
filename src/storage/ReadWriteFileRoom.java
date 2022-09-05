package storage;

import model.Room;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFileRoom implements IReadWriteData<Room>{
    @Override
    public List<Room> readData() {
        List<Room> roomList=new ArrayList<>();
        try{
        FileInputStream fis=new FileInputStream("phongtro.txt");
        ObjectInputStream ois=new ObjectInputStream(fis);
        roomList=(List<Room>) ois.readObject();
        ois.close();
        fis.close();

        } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }return roomList;
    }

    @Override
    public void writeData(List<Room> roomList) {
        try{
        FileOutputStream fos =new FileOutputStream("phongtro.txt");
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(roomList);
        oos.close();
        fos.close();
        } catch (FileNotFoundException e) {
          e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
