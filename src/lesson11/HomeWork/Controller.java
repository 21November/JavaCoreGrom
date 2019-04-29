package lesson11.HomeWork;

public class Controller {

    private API[] apis;

    public Controller(API[] apis) {
        this.apis = apis;
    }

    public API[] getApis() {
        return apis;
    }

    public Room[] requestRooms(int price, int persons, String city, String hotel){
        //Который находит комнаты по заданным параметрам по всем АПИ

        int n = 0;
        for (API api : apis) {
            if (api != null)
                n += api.findRooms(price, persons, city, hotel).length;
        }

        Room[] requestedRooms = new Room[n];
        int i = 0;
        for (API api : apis) {
            if (api != null) {
                for (Room room : api.findRooms(price, persons, city, hotel)) {
                    requestedRooms[i] = room;
                    i++;
                }
            }
        }
        return requestedRooms;
    }

    public Room[] check(API api1, API api2){
        //Который находит общие комнаты у двух API (в результирующий массив добавлять комнаты с api1).
        // Комнаты будем считать равными, если у них одинаковые все поля кроме id и dateAvailableFrom.
        // Гарантируется что id комнаты уникальный во всей системе
        Room[] result;

        int counter = 0;
        int indexLong = 0;
        for (Room roomLong : api1.getAll()) {
            int indexShort = 0;
            if (api2 != null){
                for (Room roomShort : api2.getAll()) {
                    if (roomLong != null && roomShort != null){
                        if (roomLong.getPrice() == roomShort.getPrice() &&
                                roomLong.getPersons() == roomShort.getPersons() &&
                                roomLong.getHotelName() == roomShort.getHotelName() &&
                                roomLong.getCityName() == roomShort.getCityName())
                            counter++;
                        indexShort++;
                    }

                }
                indexLong++;
            }

        }

        result = new Room[counter];

        int index = 0;
        int firstCount = 0;
        for (Room roomLong : api1.getAll()) {
            int secondCount = 0;
            if (api2 != null){
                for (Room roomShort : api2.getAll()) {
                    if (roomLong != null && roomShort != null){
                        if (roomLong.getPrice() == roomShort.getPrice() &&
                                roomLong.getPersons() == roomShort.getPersons() &&
                                roomLong.getHotelName() == roomShort.getHotelName() &&
                                roomLong.getCityName() == roomShort.getCityName()) {
                            result[index] = roomLong;
                            index++;
                        }
                        secondCount++;
                    }
                }
                firstCount++;
            }

        }
        return result;
    }



}
