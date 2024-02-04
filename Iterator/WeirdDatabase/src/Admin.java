public class Admin {

    public static void main(String[] args) {

        OldestDatabase OldestDB = new OldestDatabase();
        OlderDatabase OlderDB = new OlderDatabase();
        OldDatabase OldDB = new OldDatabase();
//        NewDatabase newDB = new NewDatabase();

        DatabaseAdministrator admin = new DatabaseAdministrator(OldestDB, OlderDB, OldDB/* , newDB*/);
        admin.showTheDatabase();
    }
}
