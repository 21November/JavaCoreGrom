package lesson11.HomeWork;

import lesson10.abstractbigexample.BankAccount;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {

        Room room1 = new Room(1001, 50, 1, new Date(), "Hotel", "City1");
        Room room2 = new Room(1002, 50, 2, new Date(), "Hotel1", "City1");
        Room room3 = new Room(1003, 150, 3, new Date(), "Hotel1", "City1");
        Room room4 = new Room(1004, 500, 5, new Date(), "Hotel2", "City1");
        Room room5 = new Room(1005, 250, 2, new Date(), "Hotel3", "City3");
        Room room6 = new Room(1006, 250, 3, null, "Hotel", "City1");
        Room[] rooms1 = new Room[]{room1, room2, room3, room4, room5, room6, null};
        Room[] rooms2 = new Room[]{};
        Room[] rooms3 = new Room[]{room1,room6, null};

        API bookingComAPI = new BookingComAPI(rooms1);
        API tripAdvisorAPI = new TripAdvisorAPI(rooms1);
        API googleAPI = new GoogleAPI(rooms1);


        // 1. комнаты, которые соответствуют требованиям для всех APIs
        // 2. проверка на NullPointerException
        // 3. rooms that do not match the requirements (id1 and id4) not found for all API

        API[] apis = new API[]{bookingComAPI, tripAdvisorAPI, googleAPI, null};

        for (API api : apis) {
            if (api == null){
                System.out.println("!!!!!!!!!null");}
            else {
                System.out.println("1" + Arrays.toString(api.findRooms(50, 1, "City1", "Hotel")));
                System.out.println("2" + Arrays.toString(api.findRooms(100, 2, "City1", "Hotel1")));
                System.out.println("3" + Arrays.toString(api.findRooms(200, 3, "City1", "Hotel1")));
                System.out.println("4" + Arrays.toString(api.findRooms(250, 1, "City3", "Hotel3")));

                System.out.println();
            }
        }

        System.out.println("-----------------------------------------------------------------------------------");

        Controller controller = new Controller(apis);

//         check

        API bookingComAPI_Y = new BookingComAPI(rooms3);
        System.out.println(Arrays.deepToString(controller.check(bookingComAPI, bookingComAPI_Y)));
        System.out.println(Arrays.deepToString(controller.check(bookingComAPI, null)));

        System.out.println("-----------------------------------------------------------------------------------");

//        requestRooms

        System.out.println(Arrays.deepToString(controller.requestRooms(100, 2, "City1", "Hotel1")));
        System.out.println(Arrays.deepToString(controller.requestRooms(200, 2, "City1", "Hotel")));
        System.out.println(Arrays.deepToString(controller.requestRooms(250, 3, "City1", "Hotel1")));
    }
}
