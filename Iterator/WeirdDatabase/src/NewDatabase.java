import java.util.Iterator;
import java.util.LinkedHashMap;

public class NewDatabase implements DatabaseIterator {

    LinkedHashMap<Integer, DatabaseInfo> newDatabase = new LinkedHashMap<>();
    int key = 0;

    public NewDatabase() {
        addRecord("Guard was fired", 1001);
        addRecord("Guard House was bombarded", 1002);
        addRecord("More robbers were invited", 1003);
    }

    public void addRecord(String data, int recordNumber) {
        DatabaseInfo recordInfo = new DatabaseInfo(data, recordNumber);
        newDatabase.put(key, recordInfo);
        key++;
    }

    @Override
    public Iterator createIterator() {
        return newDatabase.values().iterator();
    }
}