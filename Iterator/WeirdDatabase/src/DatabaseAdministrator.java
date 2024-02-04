import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

public class DatabaseAdministrator {

    DatabaseIterator iterOldestDB;
    DatabaseIterator iterOlderDB;
    DatabaseIterator iterOldDB;
//    DatabaseIterator iternewDB;


    public DatabaseAdministrator(DatabaseIterator newIterOldestDB, DatabaseIterator newIterOlderDB, DatabaseIterator newIterOldDB /*, DatabaseIterator newIterNewDB */) {
        iterOldestDB = newIterOldestDB;
        iterOlderDB = newIterOlderDB;
        iterOldDB = newIterOldDB;
//        iternewDB = newIterNewDB;
    }

    public void showTheDatabase(){

        Iterator oldestDB = iterOldestDB.createIterator();
        Iterator olderDB = iterOlderDB.createIterator();
        Iterator oldDB = iterOldDB.createIterator();
//        Iterator newDB = iternewDB.createIterator();l

        System.out.println("Records in the oldest Database\n");
        printTheDatabase(oldestDB);
        System.out.println();

        System.out.println("Records in the older Database\n");
        printTheDatabase(olderDB);
        System.out.println();

        System.out.println("Records in the old Database\n");
        printTheDatabase(oldDB);
        System.out.println();

//        System.out.println("Records in the new Database\n");
//        printTheDatabase(newDB);
//        System.out.println();

    }

    public void printTheDatabase(Iterator iterator){
        while(iterator.hasNext()){
            DatabaseInfo songInfo = (DatabaseInfo) iterator.next();
            System.out.print("record Number: ");
            System.out.println(songInfo.getRecordNumber());
            System.out.print("record: ");
            System.out.println(songInfo.getRecords());
        }
    }
}
