package view;

import controller.PersonController;
import controller.RoomController;
import model.Person;
import model.Room;

import java.time.LocalDate;
import java.util.Scanner;

import static controller.RoomController.roomList;

public class Main {
    public static void main(String[] args) {
        PersonController tuan=new PersonController("Tuan");
        RoomController boss=new RoomController();
        int choice;
        do{
            showMenu();
            Scanner scanner=new Scanner(System.in);
            choice=scanner.nextInt();
            switch(choice){
                case 1:
                    Room room=getRoomInformation();
                    boss.addNewRoom(room);
                    break;
                case 2:
                    int index=getRoomIndex();
                    room=getRoomInformation();
                    boss.setRoomInformation(index,room);
                    break;
                case 3:
                    String roomId=getRoomId();
                    boss.deleteRoomById(roomId);
                    break;
                case 4:
                    Person person= creatNewPerson();
                    tuan.addNewPerson(person);
                    break;
                case 5:
                    index=getIndexOfPerson();
                    person=creatNewPerson();
                    tuan.setPerson(index,person);
                    break;
                case 6:
                    index=getIndexOfPerson();
                    tuan.deletePerson(index);
                    break;
                case 7:
                    String idCard=getIdCard();
                    double money= tuan.getMoney(idCard);
                    System.out.println("Số tiền khách cần trả là "+money);
                    break;
                case 8:
                    boss.displayRooms();
                    break;
                case 9:
                    tuan.displayPersons();
                    break;
                case 0:
                    System.exit(0);
            }

        }while (choice!=0);
    }

    private static void showMenu() {
        System.out.println("--Danh mục--");
        System.out.println("1. Thêm phòng trọ");
        System.out.println("2. Sửa thông tin phòng trọ");
        System.out.println("3. Xóa phòng trọ");
        System.out.println("4. Thêm khách thuê phòng");
        System.out.println("5. Sửa thông tin khách thuê phòng");
        System.out.println("6. Xóa thông tin khách trọ");
        System.out.println("7. Tính số tiền khách cần trả");
        System.out.println("8. Hiển thị danh sách phòng trọ");
        System.out.println("9. Hiển thị danh sách khách trọ");
        System.out.println("0 .Thoát");
    }

    private static String getIdCard() {
        System.out.println("Nhập số CMND");
        Scanner scanner2=new Scanner(System.in);
        String idCard =scanner2.nextLine();
        return idCard;
    }

    private static int getIndexOfPerson() {
        System.out.println("Nhập vị trí khách hàng cần sửa đổi hoặc xóa");
        Scanner scanner=new Scanner(System.in);
        int index=scanner.nextInt();
        return index;
    }

    private static Person creatNewPerson() {
        System.out.println("Nhập tên khách");
        Scanner scanner=new Scanner(System.in);
        String name =scanner.nextLine();
        System.out.println("Nhập ngày sinh");
        Scanner scanner1=new Scanner(System.in);
        String dateOfBirth =scanner1.nextLine();
        System.out.println("Nhập số CMND");
        Scanner scanner2=new Scanner(System.in);
        String idCard =scanner2.nextLine();
        System.out.println("Nhập số phòng");
        Scanner scanner3=new Scanner(System.in);
        String roomId =scanner3.nextLine();
        System.out.println("Nhập ngày bắt đầu thuê trọ");
        Scanner scanner4=new Scanner(System.in);
        int day =scanner4.nextInt();
        System.out.println("Nhập tháng bắt đầu thuê trọ");
        Scanner scanner5=new Scanner(System.in);
        int month =scanner5.nextInt();
        System.out.println("Nhập năm bắt đầu thuê trọ");
        Scanner scanner6=new Scanner(System.in);
        int year =scanner6.nextInt();
        boolean check=false;
        Person person=null;
        Room room =null;
        for (int i = 0; i < roomList.size(); i++) {
            if(roomList.get(i).getRoomId().equals(roomId)){
                check=true;
                room=roomList.get(i);
            }
        }
        if(check){
            person=new Person(name,dateOfBirth,idCard,room, LocalDate.of(year,month,day));
        }
        return person;
    }

    private static String getRoomId() {
        System.out.println("Nhập số phòng");
        Scanner scanner=new Scanner(System.in);
        String roomId=scanner.nextLine();
        return roomId;
    }

    private static int getRoomIndex() {
        System.out.println("Mời nhập vị trí phòng cần thay đổi thông tin");
        Scanner scanner=new Scanner(System.in);
        int index=scanner.nextInt();
        return index;
    }

    private static Room getRoomInformation() {
        System.out.println("Nhập số phòng");
        Scanner scanner=new Scanner(System.in);
        String roomId=scanner.nextLine();
        System.out.println("Nhập loại phòng");
        Scanner scanner1=new Scanner(System.in);
        String roomType=scanner1.nextLine();
        System.out.println("Nhập giá phòng");
        Scanner scanner2=new Scanner(System.in);
        Double roomPrice=scanner2.nextDouble();
        return new Room(roomId,roomType,roomPrice);
    }

}
