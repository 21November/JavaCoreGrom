package lesson28;

import java.util.Comparator;

public class FullComparator implements Comparator<Capability> {

    @Override
    public int compare(Capability o1, Capability o2) {


        DateComparator dateComparator = new DateComparator();

        //если поле ChannelName не равно  - сравниваю по нему
        //если равно  - перехожу к fingerprint
        // если fingerprint не равно   - сравниваю по нему
        //если равно   - перехожу к dateCreated
        //если dateCreated не равно   - сравниваем по нему
        // если равно   - обьекты равны возвращаем 0

        if (compareNulls(o1.getChannelName(), o2.getChannelName()) != 10) //&& !o1.getChannelName().equals(o2))
            return compareNulls(o1.getChannelName(), o2.getChannelName());
        else if (compareNulls(o1.getFingerprint(), o2.getFingerprint()) != 10)
            return compareNulls(o1.getFingerprint(), o2.getFingerprint());
        else return dateComparator.compare(o1, o2);
    }

    private int compareNulls(String o1, String o2) {
        if (o1 == null && o2 != null)
            return 1;
        else if (o1 != null && o2 == null)
            return -1;
        else if (o1 == null && o2 == null)
            return 0;
        else if (o1 != null && o2 != null && !o1.equals(o2))
            return o1.compareTo(o2);
        else return 10;
    }
}
