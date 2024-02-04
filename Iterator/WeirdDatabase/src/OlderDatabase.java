import java.util.ArrayList;
import java.util.Iterator;

public class OlderDatabase implements DatabaseIterator {

    ArrayList<DatabaseInfo> oldestDatabase;

    public OlderDatabase() {
        oldestDatabase = new ArrayList<DatabaseInfo>();

        addSong("Guard entered The washroom", 310);
        addSong("Someone entered the guard house", 311);
        addSong("Someone tried to log into the computer", 312);
    }

    private void addSong(String records, int recordNumber) {
        DatabaseInfo databaseInfo = new DatabaseInfo(records, recordNumber);
        oldestDatabase.add(databaseInfo);
    }

    @Override
    public Iterator createIterator() {
        return oldestDatabase.iterator();
    }
}
