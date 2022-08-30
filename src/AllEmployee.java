
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class AllEmployee extends JFrame implements ActionListener{

    JButton Jback;
    JTable table;
    JFrame frame;
    DefaultTableModel defaultTableModel;

    AllEmployee(){

        //setting the properties of JFrame
        frame = new JFrame("Employees Details");
        frame.setLayout(null);
        frame.setLayout(new FlowLayout());
        frame.setBounds(200, 200, 1200, 670);


        //Setting the properties of JTable and DefaultTableModel
        defaultTableModel = new DefaultTableModel();
        table = new JTable(defaultTableModel);
        table.setPreferredScrollableViewportSize(new Dimension(1150, 500));
        
        
        // set scroll bar and coloumn headings
        table.setFillsViewportHeight(true);
        frame.add(new JScrollPane(table));
        defaultTableModel.addColumn("Name");
        defaultTableModel.addColumn("Age");
        defaultTableModel.addColumn("Gender");
        defaultTableModel.addColumn("Job");
        defaultTableModel.addColumn("Salary");
        defaultTableModel.addColumn("Phone");
        defaultTableModel.addColumn("Email");
        defaultTableModel.addColumn("Aadhar");

        try{

            Conn cc = new Conn();
            String querry = "select * from employee";

            ResultSet rs = cc.s.executeQuery(querry);

            while(rs.next()){

                String name = rs.getString("name");
                String age = rs.getNString("age") ;
                String gender = rs.getString("gender");
                String job = rs.getString("job");
                String salary = rs.getString("salary");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String aadhar = rs.getString("aadhar");
                String tupple[] = {name,age,gender,job,salary,phone,email,aadhar};
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
        new AllEmployee();
    }
}
