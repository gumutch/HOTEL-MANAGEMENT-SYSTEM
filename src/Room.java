

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class Room extends JFrame implements ActionListener{

    JButton Jback;
    JTable table;
    JFrame frame;
    DefaultTableModel defaultTableModel;

    Room(){

     

        //setting the properties of JFrame
        frame = new JFrame("Rooms Details");
        frame.setLayout(null);
        frame.setLayout(new FlowLayout());
        frame.setBounds(200, 200, 1000, 670);


        //Setting the properties of JTable and DefaultTableModel
        defaultTableModel = new DefaultTableModel();
        table = new JTable(defaultTableModel);
        table.setPreferredScrollableViewportSize(new Dimension(950, 500));
        
        
        // set scroll bar and coloumn headings
        table.setFillsViewportHeight(true);
        frame.add(new JScrollPane(table));
        defaultTableModel.addColumn("Room Number");
        defaultTableModel.addColumn("Availability");
        defaultTableModel.addColumn("Cleaning Status");
        defaultTableModel.addColumn("Price");
        defaultTableModel.addColumn("Bed Type");

        try{

            Conn cc = new Conn();
            String querry = "select * from room";

            ResultSet rs = cc.s.executeQuery(querry);

            while(rs.next()){

                String roomnum = rs.getString("roomnumber");
                String avail = rs.getNString("availability") ;
                String clean_sts = rs.getString("cleaning_status");
                String pric = rs.getString("price");
                String bed_ty = rs.getString("bed_type");
                String tupple[] = {roomnum,avail,clean_sts,pric,bed_ty};
                defaultTableModel.addRow(tupple);//Adding row in Table
                frame.setVisible(true);//Setting the visibility of second Frame
                frame.validate();

            }


        }
        catch(Exception e){
            e.printStackTrace();
        }

        Jback = new JButton("BACK");
        Jback.setBackground(Color.BLACK);
        Jback.setForeground(Color.WHITE);
        Jback.addActionListener(this);
        frame.add(Jback);


        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==Jback){
            frame.setVisible(false);
            new Reception();

        }
    }

    public static void main (String [] args){
        new Room();
    }
}