public class DatabaseInfo {

    String records;
    int recordNumber;

    public DatabaseInfo(String newRecords, int newRecordNumber){
        records = newRecords;
        recordNumber = newRecordNumber;
    }

    public String getRecords(){ return records; }
    public int getRecordNumber(){ return recordNumber; }

}
