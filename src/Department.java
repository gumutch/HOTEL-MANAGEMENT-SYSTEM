

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class Department extends JFrame implements ActionListener{

    JButton Jback;
    JTable table;
    JFrame frame;
    DefaultTableModel defaultTableModel;

    Department(){

     

        //setting the properties of JFrame
        frame = new JFrame("Department Details");
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
        defaultTableModel.addColumn("Department");
        defaultTableModel.addColumn("Budget");


        try{

            Conn cc = new Conn();
            String querry = "select * from department";

            ResultSet rs = cc.s.executeQuery(querry);

            while(rs.next()){

                String dept = rs.getString("departmentName");
                String budg = rs.getNString("budget") ;

                String tupple[] = {dept,budg};
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
        new Department();
    }
}