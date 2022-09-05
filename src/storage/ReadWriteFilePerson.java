package storage;

import model.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFilePerson implements IReadWriteData<Person>{
    @Override
    public List<Person> readData() {
        List<Person> personList=new ArrayList<>();
        try {
        FileInputStream fis=new FileInputStream("person.txt");
        ObjectInputStream ois=new ObjectInputStream(fis);
        personList=(List<Person>) ois.readObject();
        ois.close();
        fis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
           e.printStackTrace();
        }
        return personList;
    }

    @Override
    public void writeData(List<Person> personList) {
       try{
           FileOutputStream fos=new FileOutputStream("person.txt");
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(personList);
        oos.close();
        fos.close();
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }

    }
}
