package StoreGUI;

import Constractor.Record;
import Main.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

/**
 * Created by mash4 on 5/6/2017.
 */
public class ConsgnmentShelf  extends  JFrame{
    private JPanel consgnmentPanel;
    private JList <Record> consmentList;
    private JList soldlist;
    private JList burgainedlist;
    private JButton saleItemButton;
    private JButton button2;

    static DefaultListModel<Record> allConsgmnetListModel;

    ConsgnmentShelf(MainWindow parentWindow){
        allConsgmnetListModel = new DefaultListModel<>();
        setContentPane(consgnmentPanel);
        pack();
        setVisible(true);
        parentWindow.setEnabled(true);
        Controller.loadDataFromDB();


        saleItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("hhh");
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }
// recordID | artist    | title   | quantity | salePrx | Date
    public static void dumpData(LinkedList<Record> recordData) {
        for(Record r : recordData){
            int recodID = r.getRecordID();
           // int consID = r.getConsgrID();
            String artist = r.getArtist();
            String title = r.getTitle();
            int quantity = r.getQuantity();
            double salePrx = r.getSalePrx();
            java.sql.Date date = r.getSmDate();
            Record record = new Record(recodID, artist, title, quantity, salePrx, date);
            allConsgmnetListModel.addElement(record);



        }
    }
}
