package lesson28;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

public class DemoComparator {
    public static void main(String[] args) {
        Capability capability1 = new Capability(1001, "test", "rr11", true, null);
        Capability capability2 = new Capability(1005, "test", "rr11", false, new Date());
        Capability capability3 = new Capability(900, "test", "rr11", true, null);
        Capability capability4 = new Capability(901, "test", "rr11", false, new Date());

        ArrayList<Capability> capabilities = new ArrayList<>();
        capabilities.add(capability1);
        capabilities.add(capability2);
        capabilities.add(capability3);
        capabilities.add(capability4);

        System.out.println(capabilities);

        //capabilities.sort(new IsActiveComparator());
        capabilities.sort(new FullComparator());

        System.out.println(capabilities);

/*
        Comparator<Capability> comparator = new Comparator<Capability>() {
            @Override
            public int compare(Capability o1, Capability o2) {

                //если поле ChannelName не равно  - сравниваю по нему
                //если равно  - перехожу к fingerprint
                // если fingerprint не равно   - сравниваю по нему
                //если равно   - перехожу к dateCreated
                //если dateCreated не равно   - сравниваем по нему
                // если равно   - обьекты равны возвращаем 0

                if (!o1.getChannelName().equals(o2))
                    return o1.getChannelName().compareTo(o2.getChannelName());
                else if (!o1.getFingerprint().equals(o2))
                    return o1.getFingerprint().compareTo(o2.getFingerprint());
                else if (!o1.getDateCreated().equals(o2))
                    return o1.getDateCreated().compareTo(o2.getDateCreated());
                else return 0;
            }
        };*/
    }
}
