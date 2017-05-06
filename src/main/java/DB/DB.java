package DB;

import Constractor.Record;
import StoreGUI.ConsgnmentShelf;
import StoreGUI.SubWindow1;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by mash4 on 5/4/2017.
 */
public class DB {

    private static final String JDBC_Driver = "com.mysql.cj.jdbc.Driver";
    private static final String DB_CONNECTION_URL = "jdbc:mysql://localhost:3306/Mystore";
    private static final String USER = ("mash4peace");
    private static final String PASSWORDS = System.getenv("MYSQL_pw");
    //private static final String TABLE_NAME = "records";

    private static Connection conn = null;
    private static final Statement statement = null;
    private ResultSet rs = null;

    public DB() {
        try {
            Class.forName(JDBC_Driver);
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Can't instantiate driver class; " +
                    "check you have drives and classpath configured" +
                    " correctly?");
            cnfe.printStackTrace();
            System.exit(-1);  //No driver? Need to fix before anything else will work. So quit the program

        }
        try {
            conn = DriverManager.getConnection(DB_CONNECTION_URL, USER, PASSWORDS);
            System.out.println("Your connection is OK");

        } catch (SQLException sqle) {
            System.out.println("Can't connect to database. " +
                    "\nIs MySQL running? " +
                    "\nHave you created the database? " +
                    "\nVerify username and password. " +
                    "\nHave you granted the right permissions to your user?");
            sqle.printStackTrace();

        }

    }




    public void getConsgrWithID(Record record) {
        try(Connection conn = DriverManager.getConnection(DB_CONNECTION_URL, USER, PASSWORDS)){
           // int id = record.getConsgrID();
            String search = "Select consgrID from records where consgrID = ? ";
            ResultSet rs = statement.executeQuery(search);
            System.out.println(rs);


        }catch (SQLException sql ){
            sql.getErrorCode();
            sql.getCause();
            sql.printStackTrace();
        }

    }

    public void addingConsgrInfo(Record rcd) {
        try(Connection cnn = DriverManager.getConnection(DB_CONNECTION_URL, USER, PASSWORDS)){
            String addConsgrDetails = "INSERT INTO consignors (consgrName, phone, email) VALUES ( ?, ?, ?)";
            PreparedStatement addcongsrDetailsPS = conn.prepareStatement(addConsgrDetails);

            addcongsrDetailsPS.setString(1, rcd.getConsgr_name());
            addcongsrDetailsPS.setString(2, rcd.getConsgr_phoneNumber());
            addcongsrDetailsPS.setString(3, rcd.getConsgr_Email());

            addcongsrDetailsPS.execute();
            System.out.println("Added data into  consignor table ");

            addcongsrDetailsPS.close();
            conn.close();

        }catch (SQLException sql){
            sql.getCause();
            sql.getErrorCode();
            sql.printStackTrace();
        }
    }

    public void getConsgmnetsFromDatabase() {
        try(Connection cnn  = DriverManager.getConnection(DB_CONNECTION_URL, USER, PASSWORDS) ){
            String fetchAllData = " Select * From records ";
            rs = statement.executeQuery(fetchAllData);


        }catch (SQLException sql){
            sql.getErrorCode();
            sql.printStackTrace();
            sql.getCause();
        }
    }

    public void saveRecordInfo(Record record) {


    }

    public ArrayList<Record> fetchAllConsgrNmeRecords() {
        ArrayList<Record> allCONSGRNAMES = new ArrayList();
        try (Connection conn = DriverManager.getConnection(DB_CONNECTION_URL, USER, PASSWORDS);
             Statement statement = conn.createStatement()){
            String selctAllconsgrNames = "SELECT  consgrName FROM consignors ";
            ResultSet rs = statement.executeQuery(selctAllconsgrNames);

            while (rs.next()){
                String name = rs.getString("consignors");
                Record r = new Record(name);
                allCONSGRNAMES.add(r);

            }
            System.out.println("We sent all consignor names ");
            rs.close();
            statement.close();
            conn.close();

            return allCONSGRNAMES;

        }catch (SQLException sql){
                 sql.getErrorCode();
                 sql.getCause();
                 return null;
        }
    }

    public void getConsgrsFromData() {
        try(Connection cnn = DriverManager.getConnection(DB_CONNECTION_URL, USER, PASSWORDS)){
            Statement statement = cnn.createStatement();
            String consgrName = "SELECT consgrName FROM consignors ";

            ResultSet rs = statement.executeQuery(consgrName);
            while (rs.next()){
                String name = rs.getString("consgrName");
                Record r = new Record(name);
                LinkedList<Record> dumpDate = new LinkedList<Record>();
                dumpDate.add(r);
                SubWindow1.takeBackData(dumpDate);
                //System.out.println(name);
            }
            rs.close();
            statement.close();

        }catch (SQLException sql){
            sql.getErrorCode();
            sql.getErrorCode();
            sql.getCause();

        }
    }


    public void saveRecordInfoIntoRecordsTable(Record record) {
        try (Connection conn = DriverManager.getConnection(DB_CONNECTION_URL, USER, PASSWORDS)){

            String addConsgnmtInfo = "INSERT INTO  records ( consgrID, consgrName, quantity, salePrx,  artist,   title  , Date ) VALUES (  ?,?, ?, ?, ?, ?, ?) ";
            PreparedStatement addConsgrDetails = conn.prepareStatement(addConsgnmtInfo);


            addConsgrDetails.setInt(1, record.getConsgrID());
            addConsgrDetails.setString (2, record.getConsgr_name ());
            addConsgrDetails.setInt(3, record.getQuantity());
            addConsgrDetails.setDouble(4, record.getSalePrx());
            addConsgrDetails.setString(5, record.getArtist());
            addConsgrDetails.setString(6, record.getTitle() );
            addConsgrDetails.setDate(7, record.getSmDate());

            addConsgrDetails.execute();
            System.out.println("Added data into records table ");
            addConsgrDetails.close();
            conn.close();
        }catch (SQLException sql){
            sql.getCause();
            sql.getErrorCode();
            sql.printStackTrace();
        }
    }

    public void getDataFromDB( ) {

        try(Connection conn = DriverManager.getConnection(DB_CONNECTION_URL, USER, PASSWORDS)){
            Statement statement = conn.createStatement();
            String consmntRecord = "SELECT  recordID,  artist, title, quantity, salePrx,  Date FROM records ";
            ResultSet rsAll = statement.executeQuery(consmntRecord);
            while (rsAll.next()){
                int recordID = rsAll.getInt("recordID");
//                int consgrID = rsAll.getInt("consgrID");
                String artistNAme = rsAll.getString("artist");
                String title = rsAll.getString("title");
                int quantity = rsAll.getInt("quantity");
                double salePrx = rsAll.getDouble("salePrx");
                Date date = rsAll.getDate("Date");
                Record record = new Record(recordID,  artistNAme, title, quantity, salePrx, date);
                LinkedList<Record> receivedData = new LinkedList<Record>();
                receivedData.add(record);
                ConsgnmentShelf.dumpData(receivedData);
                System.out.println(record.toString());


            }
            //System.out.println("We sent ");
            rsAll.close();
            statement.close();
            conn.close();


        }catch (SQLException sql){
            sql.getCause();
            sql.getErrorCode();
            sql.printStackTrace();
        }
    }
}
