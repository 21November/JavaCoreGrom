package lesson11.HomeWork;

public class BookingComAPI implements API{
    private Room[] rooms;

    public BookingComAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    public Room[] getRooms() {
        return rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        //находит комнаты по заданным параметрам, а так же комнаты, которые по цене отличаются на 100 единиц в обе стороны.
        // Например если пользователь ищет комнату с ценой 50 и другими параметрами, BookingComAPI вернет все комнаты с ценой в диапазоне 0 - 150

        int n = 0;
        for (Room room : rooms) {
            if (room != null){
                if ((price - 100 <= room.getPrice()) && (room.getPrice() <= price + 100) && room.getPersons() == persons && room.getCityName() == city && room.getHotelName() == hotel){
                    n++;}
            }
        }


        int i = 0;
        Room[] foundRooms = new Room[n];
        for (Room room : rooms) {
            if (room != null)
                if (((price - 100) <= room.getPrice()) && (room.getPrice() <= (price + 100)) && room.getPersons() == persons && room.getCityName() == city && room.getHotelName() == hotel) {
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
