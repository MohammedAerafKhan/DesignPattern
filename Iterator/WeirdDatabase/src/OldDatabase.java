import java.util.Hashtable;
import java.util.Iterator;

public class OldDatabase implements DatabaseIterator {

    Hashtable<Integer, DatabaseInfo> oldDatabase = new Hashtable<Integer, DatabaseInfo>();
    int hashKey = 0;

    public OldDatabase() {
        addSong("House number 501 reported robbery", 501);
        addSong("House number 502 reported robbery", 502);
        addSong("House number 503 reported robbery", 503);
    }

    public void addSong(String records, int recordNumber){
        DatabaseInfo songInfo = new DatabaseInfo(records, recordNumber);
        oldDatabase.put(hashKey, songInfo);
        hashKey++;
    }

    @Override
    public Iterator createIterator() {
        return oldDatabase.values().iterator();
    }
}
