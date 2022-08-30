
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class PickupService extends JFrame implements ActionListener{

    JButton Jback, JSearchRoom, JSearch;
    JTable table;
    JFrame frame;
    DefaultTableModel defaultTableModel;
    JComboBox bed_type;
    JCheckBox JCBavail;

    PickupService(){

        //setting the properties of JFrame
        frame = new JFrame("Search Drivers Details");
        frame.setLayout(null);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 50));
        frame.setBounds(200, 200, 1300, 670);

     

      
        //Setting the properties of JTable and DefaultTableModel
        defaultTableModel = new DefaultTableModel();
        table = new JTable(defaultTableModel);
        table.setPreferredScrollableViewportSize(new Dimension(1250, 400)); 
        
        // set scroll bar and coloumn headings
        table.setFillsViewportHeight(true);
        frame.add(new JScrollPane(table));
        defaultTableModel.addColumn("Name");
        defaultTableModel.addColumn("Age");
        defaultTableModel.addColumn("Gender");
        defaultTableModel.addColumn("Car Company");
        defaultTableModel.addColumn("Car Model");
        defaultTableModel.addColumn("Availability");
        defaultTableModel.addColumn("Car Location");
        defaultTableModel.addColumn("Car Number");
        defaultTableModel.addColumn("Aadhar");
        defaultTableModel.addColumn("Phone");

        

        JSearch = new JButton("SEARCH DRIVER");
        JSearch.setBackground(Color.BLACK);
        JSearch.setForeground(Color.WHITE);
        JSearch.addActionListener(this);
        frame.add(JSearch);

        Jback = new JButton("BACK");
        Jback.setBackground(Color.BLACK);
        Jback.setForeground(Color.WHITE);
        Jback.addActionListener(this);
        frame.add(Jback);


        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==JSearch){
            try{

                Conn cc = new Conn();
                ResultSet rs;
                String querry1 = "select * from driver"; 
              
               
                     rs = cc.s.executeQuery(querry1);
              
               
                 // clear past rows of table
                defaultTableModel.setRowCount(0);
    
                while(rs.next()){
    
                    String name = rs.getString("name");
                    String age = rs.getNString("age") ;
                    String gender = rs.getString("gender");
                    String carComp = rs.getString("carCompany");
                    String carModel = rs.getString("carModel");
                    String avail = rs.getString("availability");
                    String carLocation = rs.getString("carLocation");
                    String carnum = rs.getString("carNumber");
                    String aadhar = rs.getString("aadhar");
                    String phone = rs.getString("phone");
                    String tupple[] = {name,age, gender, carComp, carModel, avail,carLocation,carnum, aadhar,phone};
                    defaultTableModel.addRow(tupple);//Adding row in Table
                    frame.setVisible(true);//Setting the visibility of second Frame
                    frame.validate();
    
                }
    
    
            }
            catch(Exception e){
                e.printStackTrace();
            }


        }

        else if(ae.getSource()==Jback){
            frame.setVisible(false);
            new Reception();

        }
    }

    public static void main (String [] args){
        new PickupService();
    }
}
