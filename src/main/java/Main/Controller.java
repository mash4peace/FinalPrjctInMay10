package Main;

import Constractor.Record;
import DB.DB;
import StoreGUI.MainWindow;

import java.util.ArrayList;

/**
 * Created by mash4 on 5/4/2017.
 */
public class Controller {
     static DB db ;
     static Record record;
    public static void main(String[] args) {
        MainWindow m = new MainWindow();
        db = new DB();

    }

    public static ArrayList<Record> getDateFromDatabase() {


        return db.fetchAllConsgrNmeRecords();
    }
    public static void loadDataFromDB( ) {
        db.getDataFromDB();
    }



    public static void getIDfromDatabase(Record id) {
        db.getConsgrWithID(record);
    }

    public static void addConsignrDetails(Record rcd) {
        db.addingConsgrInfo(rcd);
    }

    public static void getAllDataFromDB() {
        db.getConsgmnetsFromDatabase();
    }

    public static void saveConsgrInfo(Record record) {
        db.saveRecordInfo( record);
    }


    public static void dumpIntoComBox() {
        db.getConsgrsFromData();
    }



    public static void saveRecordInfo(Record record) {
        db.saveRecordInfoIntoRecordsTable(record);
    }




    public static void removeDataFromrecords(Record r) {
        db.romveDataFromTableToanother(r);
    }

   
/*
    public static void loadSoldTables( ) {
        db.sold_recordsUploading();
    }
    */


}
