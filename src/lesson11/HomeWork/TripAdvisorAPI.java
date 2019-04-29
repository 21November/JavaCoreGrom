package lesson11.HomeWork;

public class TripAdvisorAPI implements API {
    private Room[] rooms;

    public TripAdvisorAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    public Room[] getRooms() {
        return rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        //находит комнаты по заданным параметрам, а так же, количество гостей ищется в диапазоне +-1.
        // Например если пользователь ищет комнату с ко-вом гостей 3 и другими параметрами, TripAdvisorAPI вернет все комнаты с ко-вом гостей от 2 до четырех

        int n = 0;
        for (Room room : rooms) {
            if (room != null)
                if (room.getPrice() == price && room.getPersons() >= (persons - 1) && room.getPersons() <= (persons + 1) && room.getCityName() == city && room.getHotelName() == hotel)
                    n++;
        }

        int i = 0;
        Room[] foundRooms = new Room[n];
        for (Room room : rooms) {
            if (room != null)
                if (room.getPrice() == price && room.getPersons() >= (persons - 1) && room.getPersons() <= (persons + 1) && room.getCityName() == city && room.getHotelName() == hotel) {
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
