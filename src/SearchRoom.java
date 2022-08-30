



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class SearchRoom extends JFrame implements ActionListener{

    JButton Jback, JSearchRoom, JSearch;
    JTable table;
    JFrame frame;
    DefaultTableModel defaultTableModel;
    JComboBox bed_type;
    JCheckBox JCBavail;

    SearchRoom(){

        //setting the properties of JFrame
        frame = new JFrame("Search Rooms Details");
        frame.setLayout(null);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 50));
        frame.setBounds(200, 200, 1000, 670);

        JLabel lblbed = new JLabel("Search bed Type");
        lblbed.setBounds(60, 350, 120, 30);
        lblbed.setFont(new Font("Tahoma",Font.PLAIN,17));
        frame.add(lblbed);


        // create drop down list
        String str3[] = { "Single Bed", "Double Bed" };
        bed_type = new JComboBox(str3);
        bed_type.setBounds(200, 350, 150, 30);
        bed_type.setBackground(Color.WHITE);
        frame.add(bed_type);

        JCBavail = new JCheckBox("Only display available");
        JCBavail.setBounds(700, 350, 150, 30);
        JCBavail.setBackground(Color.WHITE);
        frame.add(JCBavail);


        //Setting the properties of JTable and DefaultTableModel
        defaultTableModel = new DefaultTableModel();
        table = new JTable(defaultTableModel);
        table.setPreferredScrollableViewportSize(new Dimension(950, 400));
        
        
        // set scroll bar and coloumn headings
        table.setFillsViewportHeight(true);
        frame.add(new JScrollPane(table));
        defaultTableModel.addColumn("Room Number");
        defaultTableModel.addColumn("Availability");
        defaultTableModel.addColumn("Cleaning Status");
        defaultTableModel.addColumn("Price");
        defaultTableModel.addColumn("Bed Type");

        

        JSearch = new JButton("SEARCH ROOM");
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
                String querry1 = "select * from room where bed_type = '"+bed_type.getSelectedItem()+"'";
                String querry2 = "select * from room where bed_type = '"+bed_type.getSelectedItem()+"' AND availability = 'Available'";
                if(JCBavail.isSelected()){
                     rs = cc.s.executeQuery(querry2);
                }
                else{
                    rs = cc.s.executeQuery(querry1);
    
                }
                 // clear past rows of table
                defaultTableModel.setRowCount(0);
    
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


        }

        else if(ae.getSource()==Jback){
            frame.setVisible(false);
            new Reception();

        }
    }

    public static void main (String [] args){
        new SearchRoom();
    }
}