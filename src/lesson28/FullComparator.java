package lesson28;

import java.util.Comparator;

public class FullComparator implements Comparator<Capability> {

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
}
