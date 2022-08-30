
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;




public class AddRooms extends JFrame implements ActionListener{

    JTextField tfroomnum, tfprice;
    JComboBox cbavailable,cbcleaningStatus, cbbedType;
    JButton addRoom, cancel;

    AddRooms(){

        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        setBounds(350, 200, 850, 540);


        // heading of frame
        JLabel lblheading = new JLabel("ADD ROOMS");
        lblheading.setBounds(100, 30, 200, 30);
        lblheading.setForeground(Color.BLUE);
        lblheading.setFont(new Font("Tahoma",Font.PLAIN,30));
        add(lblheading);

        JLabel lblroomnum = new JLabel("Room Number");
        lblroomnum.setBounds(60, 100, 120, 30);
        lblroomnum.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblroomnum);

        tfroomnum = new JTextField();
        tfroomnum.setBounds(200, 100, 150, 30);
        add(tfroomnum);


        JLabel lblavailable = new JLabel("Availability");
        lblavailable.setBounds(60, 150, 120, 30);
        lblavailable.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblavailable);


        // create drop down list
        String str1[] = { "Available", "Occupied" };
        cbavailable = new JComboBox(str1);
        cbavailable.setBounds(200, 150, 150, 30);
        cbavailable.setBackground(Color.WHITE);
        add(cbavailable);


        JLabel lblcleaningStatus = new JLabel("Cleaning Status");
        lblcleaningStatus.setBounds(60, 200, 120, 30);
        lblcleaningStatus.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblcleaningStatus);


        // create drop down list
        String str2[] = { "Cleaned", "Dirty" };
        cbcleaningStatus = new JComboBox(str2);
        cbcleaningStatus.setBounds(200, 200, 150, 30);
        cbcleaningStatus.setBackground(Color.WHITE);
        add(cbcleaningStatus);


        JLabel lblprice= new JLabel("Price");
        lblprice.setBounds(60, 250, 120, 30);
        lblprice.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblprice);

        tfprice = new JTextField();
        tfprice .setBounds(200, 250, 150, 30);
        add(tfprice);


        JLabel lblbedType = new JLabel("Bed Type");
        lblbedType.setBounds(60, 300, 120, 30);
        lblbedType.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblbedType);


        // create drop down list
        String str3[] = { "Single Bed", "Double Bed" };
        cbbedType = new JComboBox(str3);
        cbbedType.setBounds(200, 300, 150, 30);
        cbbedType.setBackground(Color.WHITE);
        add(cbbedType);


        addRoom = new JButton("ADD ROOM");
        addRoom.setBackground(Color.BLACK);
        addRoom.setForeground(Color.WHITE);
        addRoom.setBounds(60, 370, 150, 30);
        addRoom.addActionListener(this);
        add(addRoom);


        cancel = new JButton("CANCEL");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(240, 370, 100, 30);
        cancel.addActionListener(this);
        add(cancel);


       // set a image over the frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        // resize the image
        Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        //convert i2 into imageicon object
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 30, 450,450);  
        add(image);

        


        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==addRoom){
            String roomnum = tfroomnum.getText();
            String price = tfprice.getText();
            String availability = (String) cbavailable.getSelectedItem();
            String cleaningStatus = (String) cbcleaningStatus.getSelectedItem();
            String bedType = (String) cbbedType.getSelectedItem();
    
            try{
    
                Conn cc = new Conn();
    
                String querry = "insert into room values('"+roomnum+"','"+availability+"','"+cleaningStatus+"','"+price+"','"+bedType+"')";
    
                cc.s.executeUpdate(querry);
    
                JOptionPane.showMessageDialog(null, "New Room details added successfully");
    
                setVisible(false);
    
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }

        else if(ae.getSource()==cancel){
            setVisible(false);
        }



    }
    
    public static void main(String [] args){
        new AddRooms();
    }
}
