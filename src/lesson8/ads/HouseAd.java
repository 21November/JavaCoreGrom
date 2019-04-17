package lesson8.ads;

public class HouseAd extends Ad{
    String ownerName;
    String adress;
    double squale;
    int floors;

    public HouseAd(long id, int price, String ownerName, String adress, double squale, int floors) {
        super(id, price);
        this.ownerName = ownerName;
        this.adress = adress;
        this.squale = squale;
        this.floors = floors;
    }

    boolean checkOwner(){
        Owners owners = new Owners();

        for (String owner : owners.owners){
            if (ownerName == owner)
                return true;
        }

        return false;
    }
}
