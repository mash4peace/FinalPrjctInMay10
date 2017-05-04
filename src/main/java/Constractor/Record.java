package Constractor;

import java.util.Date;

/**
 * Created by mash4 on 5/4/2017.
 */
public class Record {
    int  consgrID;
    String consgr_name ;
    String consgr_phoneNumber;
    String consgr_Email;
    String artist;
    String title;

    static  int consgrIDIncremet = 1;

    public int getConsgrID() {
        return consgrID;
    }

    public String getConsgr_name() {
        return consgr_name;
    }

    public String getConsgr_phoneNumber() {
        return consgr_phoneNumber;
    }

    public String getConsgr_Email() {
        return consgr_Email;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public double getSalePrx() {
        return salePrx;
    }

    public int getQuantity() {
        return quantity;
    }


    double salePrx;
    int quantity;

    Date date = new Date();

    public java.sql.Date getSmDate() {
        return smDate;
    }

    java.sql.Date smDate= new java.sql.Date(date.getTime());


    public Record(int consrID, String name,  int quantity, double salePrx, String artist, String title,  java.sql.Date smDate) {
        this.quantity = quantity;
        this.artist = artist;
        this.title = title;
        this.salePrx = salePrx;
        this.smDate = smDate;
        this.consgr_name = name;
        this.consgrID = consgrIDIncremet;
        consgrIDIncremet ++;

    }
    public Record(int quantity, double salePrx, String artist, String title,  java.sql.Date smDate){
        this.quantity = quantity;
        this.artist = artist;
        this.title = title;
        this.salePrx = salePrx;
        this.smDate = smDate;
    }


    public Record(int consgrID, String artist, String title, double salePrx, java.sql.Date smDAte){
        this.consgrID = consgrID;

    }



    @Override
    public String toString() {
        return consgr_name;   }

    //Consignor's database constractor
    public Record(String name, String phone , String email){
        this.consgr_name = name;
        this.consgr_phoneNumber = phone;
        this.consgr_Email = email;

    }
    public Record(int consgrID){
        this.consgrID = consgrID;
    }
    // A combobox constractor

    public Record(String  consgName){
        this.consgr_name = consgName;
    }




    /*


    public Record(int quantity, String artist, String title, double salePrx, java.sql.Date smDate) {
        this.quantity = quantity;
        this.artist = artist;
        this.title = title;
        this.salePrx = salePrx;
        this.smDate = smDate;

    }
    */

}
