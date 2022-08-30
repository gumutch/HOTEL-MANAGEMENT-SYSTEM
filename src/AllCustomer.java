


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class AllCustomer extends JFrame implements ActionListener{

    JButton Jback;
    JTable table;
    JFrame frame;
    DefaultTableModel defaultTableModel;

    AllCustomer(){

        //setting the properties of JFrame
        frame = new JFrame("Customers Details");
        frame.setLayout(null);
        frame.setLayout(new FlowLayout());
        frame.setBounds(200, 200, 1650, 670);


        //Setting the properties of JTable and DefaultTableModel
        defaultTableModel = new DefaultTableModel();
        table = new JTable(defaultTableModel);
        table.setPreferredScrollableViewportSize(new Dimension(1600, 500));
        
        
        // set scroll bar and coloumn headings
        table.setFillsViewportHeight(true);
        frame.add(new JScrollPane(table));
        defaultTableModel.addColumn("ID Type");
        defaultTableModel.addColumn("ID Number");
        defaultTableModel.addColumn("Name");
        defaultTableModel.addColumn("Gender");
        defaultTableModel.addColumn("Country");
        defaultTableModel.addColumn("Allocated Room N.");
        defaultTableModel.addColumn("Check-in-time");
        defaultTableModel.addColumn("Deposit");
        defaultTableModel.addColumn("Phone");

        try{

            Conn cc = new Conn();
            String querry = "select * from customer";

            ResultSet rs = cc.s.executeQuery(querry);

            while(rs.next()){

                String idType = rs.getString("id");
                String idNumber = rs.getNString("idNumber") ;
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                String country = rs.getString("country");
                String allocRoom = rs.getString("allocatedRoomNumber");
                String checkintime = rs.getString("check_in_time");
                String dep = rs.getString("deposit");
                String phone = rs.getString("phone");
                String tupple[] = {idType,idNumber,name,gender,country,allocRoom,checkintime,dep,phone};
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
        new AllCustomer();
    }
}

