package StoreGUI;

import Constractor.Record;
import Main.Controller;

import javax.swing.*;

/**
 * Created by mash4 on 5/4/2017.
 */
public class ConsignmentShelf  extends JFrame {
    //private JTable consgmtShelftable1;
    private JPanel shelfpanel;
    private JButton saleItemButton;
    private JButton moveAnItemToButton;
    private JButton goToMainButton;
    private JList<Record> consmtList;
    private JList<Record> soldLits;
    private JList<Record> burgainedList;

    private DefaultListModel<Record> consgmmentShelfModel;
    private DefaultListModel<Record> soldShelfModel;
    private DefaultListModel<Record> burgainedListModel;

    public ConsignmentShelf() {
        setContentPane(shelfpanel);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        Controller.getAllDataFromDB();

        consgmmentShelfModel = new DefaultListModel<Record>();
        consmtList.setModel(consgmmentShelfModel);


    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
