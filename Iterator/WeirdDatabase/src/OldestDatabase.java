import javax.xml.crypto.Data;
import java.util.Arrays;
import java.util.Iterator;

public class OldestDatabase implements DatabaseIterator{
    DatabaseInfo[] oldestDatabase;
    int arrayValue = 0;

    public OldestDatabase() {
        oldestDatabase = new DatabaseInfo[3];

        addSong("Guard entered the guard house", 1);
        addSong("Guard logged into the computer", 2);
        addSong("Guard watching recorded activities", 3);
    }

    private void addSong(String records, int recordNumber) {
        DatabaseInfo song = new DatabaseInfo(records, recordNumber);
        oldestDatabase[arrayValue] = song;
        arrayValue++;
    }


    @Override
    public Iterator createIterator() {
        return Arrays.asList(oldestDatabase).iterator();
    }
}
