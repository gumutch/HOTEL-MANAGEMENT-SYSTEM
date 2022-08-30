


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;



public class AddDriver extends JFrame implements ActionListener{

    JTextField tfname, tfage, tfcarCompany, tfcarModel, tflocation, tfaadhar, tfcarNumber, tfphone;
    JComboBox cbavailable,cbgender;
    JButton addDriver, cancel;

    AddDriver(){

        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        setBounds(350, 200, 850, 700);


        // heading of frame
        JLabel lblheading = new JLabel("ADD DRIVERS");
        lblheading.setBounds(100, 30, 200, 30);
        lblheading.setForeground(Color.BLUE);
        lblheading.setFont(new Font("Tahoma",Font.PLAIN,30));
        add(lblheading);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 100, 120, 30);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 100, 150, 30);
        add(tfname);


        JLabel lblage = new JLabel("Age");
        lblage.setBounds(60, 150, 120, 30);
        lblage.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblage);


        
        tfage = new JTextField();
        tfage.setBounds(200, 150, 150, 30);
        tfage.setBackground(Color.WHITE);
        add(tfage);


        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60, 200, 120, 30);
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblgender);


        // create drop down list
        String str2[] = { "Male", "Female" };
        cbgender = new JComboBox(str2);
        cbgender.setBounds(200, 200, 150, 30);
        cbgender.setBackground(Color.WHITE);
        add(cbgender);


        JLabel lblcarCompany= new JLabel("Car Company");
        lblcarCompany.setBounds(60, 250, 120, 30);
        lblcarCompany.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblcarCompany);

        tfcarCompany = new JTextField();
        tfcarCompany .setBounds(200, 250, 150, 30);
        add(tfcarCompany);


        JLabel lblcarModel= new JLabel("Car Model");
        lblcarModel.setBounds(60, 300, 120, 30);
        lblcarModel.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblcarModel);

        tfcarModel = new JTextField();
        tfcarModel .setBounds(200, 300, 150, 30);
        add(tfcarModel);


        JLabel lblavailability = new JLabel("Availability");
        lblavailability.setBounds(60, 350, 120, 30);
        lblavailability.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblavailability);


        // create drop down list
        String str3[] = { "Available", "Not Available" };
        cbavailable = new JComboBox(str3);
        cbavailable.setBounds(200, 350, 150, 30);
        cbavailable.setBackground(Color.WHITE);
        add(cbavailable);


        JLabel lbllocation= new JLabel("Location");
        lbllocation.setBounds(60, 400, 120, 30);
        lbllocation.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbllocation);

        tflocation = new JTextField();
        tflocation .setBounds(200, 400, 150, 30);
        add(tflocation);

        JLabel lblcarNumber= new JLabel("Car Number");
        lblcarNumber.setBounds(60, 450, 120, 30);
        lblcarNumber.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblcarNumber);

        tfcarNumber = new JTextField();
        tfcarNumber.setBounds(200, 450, 150, 30);
        add(tfcarNumber);

        JLabel lblaadhar= new JLabel("Driver Aadhar");
        lblaadhar.setBounds(60, 500, 120, 30);
        lblaadhar.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblaadhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(200, 500, 150, 30);
        add(tfaadhar);

        JLabel lblphone= new JLabel("Phone");
        lblphone.setBounds(60, 550, 120, 30);
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(200, 550, 150, 30);
        add(tfphone);


        addDriver = new JButton("ADD DRIVER");
        addDriver.setBackground(Color.BLACK);
        addDriver.setForeground(Color.WHITE);
        addDriver.setBounds(60, 620, 150, 30);
        addDriver.addActionListener(this);
        add(addDriver);


        cancel = new JButton("CANCEL");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(240, 620, 100, 30);
        cancel.addActionListener(this);
        add(cancel);


       // set a image over the frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        // resize the image
        Image i2 = i1.getImage().getScaledInstance(450, 550, Image.SCALE_DEFAULT);
        //convert i2 into imageicon object
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 30, 450,550);  
        add(image);

        


        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==addDriver){
            String name = tfname.getText();
            String age = tfage.getText();
            String availability = (String) cbavailable.getSelectedItem();
            String gender = (String) cbgender.getSelectedItem();
            String carCompany = tfcarCompany.getText();
            String carModel = tfcarModel.getText();
            String carNumber = tfcarNumber.getText();
            String location = tflocation.getText();
            String aadhar = tfaadhar.getText();
            String phone = tfphone.getText();
           
    
            try{
    
                Conn cc = new Conn();
    
                String querry = "insert into driver values('"+name+"','"+age+"','"+gender+"','"+carCompany+"','"+carModel+"','"+availability+"','"+location+"','"+carNumber+"','"+aadhar+"','"+phone+"')";
    
                cc.s.executeUpdate(querry);
    
                JOptionPane.showMessageDialog(null, "New Driver details added successfully");
    
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
        new AddDriver();
    }
}
