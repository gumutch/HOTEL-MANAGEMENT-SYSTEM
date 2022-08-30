
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.util.Date;

public class AddCustomer extends JFrame implements ActionListener{

    JTextField tfname, tfIdNumber, tfCountry, tfDeposite, tfPhone;
    JRadioButton rbmale, rbfemale;
    JComboBox cbId;
    Choice chRoomNum;
    JLabel checkinTime;
    JButton addCustomer, back;


    AddCustomer(){
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        setBounds(350, 200, 850, 670);

        // heading of frame
        JLabel lblheading = new JLabel("NEW CUSTOMER FORM");
        lblheading.setBounds(100, 30, 350, 30);
        lblheading.setForeground(Color.BLUE);
        lblheading.setFont(new Font("Tahoma",Font.PLAIN,30));
        add(lblheading);

        JLabel lblId = new JLabel("ID");
        lblId.setBounds(60, 100, 120, 30);
        lblId.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblId);

        // create drop down list
        String str1[] = { "Passport", "Driving Licence","Aadhar","Other" };
        cbId = new JComboBox(str1);
        cbId.setBounds(200, 100, 150, 30);
        cbId.setBackground(Color.WHITE);
        add(cbId);

        JLabel lblIdNumber = new JLabel("ID NUMBER");
        lblIdNumber.setBounds(60, 150, 120, 30);
        lblIdNumber.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblIdNumber);

        tfIdNumber = new JTextField();
        tfIdNumber.setBounds(200, 150, 150, 30);
        tfIdNumber.setBackground(Color.WHITE);
        add(tfIdNumber);

        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(60, 200, 120, 30);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 200, 150, 30);
        tfname.setBackground(Color.WHITE);
        add(tfname);

        JLabel lblgender = new JLabel("GENDER");
        lblgender.setBounds(60, 250, 120, 30);
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblgender);

        rbmale = new JRadioButton("Male");
        rbmale.setBounds(200, 250, 70, 30);
        rbmale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);

        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(280, 250, 70, 30);
        rbfemale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
         
        // provide functionality to select only one radio button from list of radio button
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);

        JLabel lblcountry = new JLabel("COUNTRY");
        lblcountry.setBounds(60, 300, 120, 30);
        lblcountry.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblcountry);

        tfCountry = new JTextField();
        tfCountry.setBounds(200, 300, 150, 30);
        tfCountry.setBackground(Color.WHITE);
        add(tfCountry);

        JLabel lblroomnum = new JLabel("ROOM NUMBER");
        lblroomnum.setBounds(60, 350, 120, 30);
        lblroomnum.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblroomnum);

        // going to use choice method in place of JComboBox
        // because in choice at run time value can be listed
        // but in JComboBox value should be listed at compile time
         
        chRoomNum = new Choice();

        // extract available rooms num from database and list in chRoomNum

        try{
            
            Conn cc = new Conn();
            String querry = "select * from room where availability = 'Available'";
            ResultSet rs = cc.s.executeQuery(querry);
            while(rs.next()){
                chRoomNum.add(rs.getString("roomnumber"));
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }

        chRoomNum.setBounds(200, 350, 150, 30);
        chRoomNum.setBackground(Color.WHITE);
        add(chRoomNum);


        JLabel lblcheckInTime = new JLabel("Check-in-time");
        lblcheckInTime.setBounds(60, 400, 120, 30);
        lblcheckInTime.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblcheckInTime);
        
        // date obj fetches current date and time
        Date date = new Date();
        checkinTime = new JLabel(""+ date);
        checkinTime.setBounds(200, 400, 200, 30);
        checkinTime.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(checkinTime);

        JLabel lblDeposit = new JLabel("DEPOSIT");
        lblDeposit.setBounds(60, 450, 120, 30);
        lblDeposit.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblDeposit);

        tfDeposite = new JTextField();
        tfDeposite.setBounds(200, 450, 150, 30);
        tfDeposite.setBackground(Color.WHITE);
        add(tfDeposite);


        JLabel lblphone = new JLabel("PHONE");
        lblphone.setBounds(60, 500, 120, 30);
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblphone);

        tfPhone = new JTextField();
        tfPhone.setBounds(200, 500, 150, 30);
        tfPhone.setBackground(Color.WHITE);
        add(tfPhone);


        addCustomer = new JButton("ADD CUSTOMER");
        addCustomer.setBackground(Color.BLACK);
        addCustomer.setForeground(Color.WHITE);
        addCustomer.setBounds(60, 570, 150, 30);
        addCustomer.addActionListener(this);
        add(addCustomer);

        back = new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(230, 570, 150, 30);
        back.addActionListener(this);
        add(back);


        // set a image over the frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        // resize the image
        Image i2 = i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        //convert i2 into imageicon object
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 100, 500,500);  
        add(image);

        


         setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==addCustomer){

            String id = (String) cbId.getSelectedItem();
            String number = tfIdNumber.getText();
            String name = tfname.getText();
            String gender = null;

            if(rbmale.isSelected()){
                gender = "Male";
            }
            else if(rbfemale.isSelected()){
                gender = "Female";
            }

            String country = tfCountry.getText();
            String allocatedRoom = chRoomNum.getSelectedItem();
            String time = checkinTime.getText();
            String deposit = tfDeposite.getText();
            String phone =tfPhone.getText();
            String querry1 = "insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+allocatedRoom+"','"+time+"','"+deposit+"','"+phone+"')";
            String querry2 = "update room set availability = 'Occupied' where roomnumber = '"+ allocatedRoom +"'";
            
            try{

                Conn cc = new Conn();
                cc.s.executeUpdate(querry1);
                cc.s.executeUpdate(querry2);

                JOptionPane.showMessageDialog(null, "New Customer added successfully");

                setVisible(false);
                new Reception();
                

            }
            catch(Exception e){
                e.printStackTrace();
            }

        }

        else if(ae.getSource()==back){
            setVisible(false);
            new Reception();

        }

    }
    

    public static void main (String [] args){
        new AddCustomer();
    }
}
