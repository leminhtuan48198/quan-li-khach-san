package controller;

import model.Person;
import storage.IReadWriteData;
import storage.ReadWriteFilePerson;

import java.util.ArrayList;
import java.util.List;

public class PersonController {
    private String name;

    public PersonController() {
    }

    public PersonController(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    static IReadWriteData iReadWriteData=new ReadWriteFilePerson();
    public static List<Person> personList=iReadWriteData.readData();
    public void addNewPerson(Person person){
        personList.add(person);
        iReadWriteData.writeData(personList);
    }
    public void setPerson(int index,Person person){
        personList.set(index,person);
        iReadWriteData.writeData(personList);
    }
    public void deletePerson(int index){
        personList.remove(index);
        iReadWriteData.writeData(personList);
    }
    public void displayPersons(){
        for (int i = 0; i < personList.size(); i++) {
            System.out.println(personList.get(i));
        }
    }
    public double getMoney(String idCard){
        int index=findPersonByIdCard(idCard);
        try{
            return personList.get(index).getNumberOfRentDay()*personList.get(index).getRoom().getPrice();
        }catch (ArrayIndexOutOfBoundsException e){
            System.err.println("Không tìm thấy số CMND này");
            return 0;
        }

    }

    private int findPersonByIdCard(String idCard) {
        for (int i = 0; i < personList.size(); i++) {
            if(personList.get(i).getIdCard().equals(idCard)){
                return i;
            }

        }
        return -1;
    }
}
