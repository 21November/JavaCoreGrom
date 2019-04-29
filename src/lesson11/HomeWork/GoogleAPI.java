package lesson11.HomeWork;

public class GoogleAPI implements API {
    private Room[] rooms;

    public GoogleAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    public Room[] getRooms() {
        return rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        //ищет сторого по заданным параметрам
        int n = 0;
        for (Room room : rooms) {
            if (room != null)
                if (room.getPrice() == price && room.getPersons() == persons && room.getCityName() == city && room.getHotelName() == hotel)
                    n++;
        }

        Room[] foundRooms = new Room[n];
        int i = 0;
        for (Room room : rooms) {
            if (room != null)
                if (room.getPrice() == price && room.getPersons() == persons && room.getCityName() == city && room.getHotelName() == hotel) {
                    foundRooms[i] = room;
                    i++;
                }
        }
        return foundRooms;
    }

    @Override
    public Room[] getAll() {
        return rooms;
    }
}
