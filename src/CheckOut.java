

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

public class CheckOut extends JFrame implements ActionListener{
  Choice chID;
  JButton JBcheck, JBcheckout, JBback;
  JTextField tfname ,tfcheckin, tfamt, tfpamt, tfroom;
  JLabel Jlroom, Jlcheckin, Jlcheckout;

    CheckOut(){
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        setBounds(350, 200, 850, 540);


        // heading of frame
        JLabel lblheading = new JLabel("Check Out");
        lblheading.setBounds(40, 30, 350, 30);
        lblheading.setForeground(Color.BLUE);
        lblheading.setFont(new Font("Tahoma",Font.PLAIN,30));
        add(lblheading);


        // set a image over the frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        // resize the image
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        //convert i2 into imageicon object
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(360, 100, 20,20);  
        add(image);



        // set a image over the frame
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        // resize the image
        Image i5 = i4.getImage().getScaledInstance(400, 350, Image.SCALE_DEFAULT);
        //convert i2 into imageicon object
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image1 = new JLabel(i6);
        image1.setBounds(400, 100, 400,350);  
        add(image1);  



        JLabel lblid = new JLabel("Customer ID");
        lblid.setBounds(60, 100, 120, 30);
        lblid.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblid);

        chID = new Choice();



        chID.setBounds(200, 100, 150, 30);
        chID.setBackground(Color.WHITE);
        add(chID);

        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(60, 150, 120, 30);
        lblroom.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblroom);

        Jlroom = new JLabel();
        Jlroom.setBounds(200, 150, 150, 30);
        add(Jlroom);

        JLabel lblcheckin = new JLabel("Check in Time");
        lblcheckin.setBounds(60, 200, 120, 30);
        lblcheckin.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblcheckin);

        Jlcheckin = new JLabel();
        Jlcheckin.setBounds(200, 200, 200, 30);
        add(Jlcheckin);

        JLabel lblcheckout = new JLabel("Check out Time");
        lblcheckout.setBounds(60, 250, 120, 30);
        lblcheckout.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblcheckout);

        Date date = new Date();

        Jlcheckout = new JLabel("" + date);
        Jlcheckout.setBounds(200, 250, 200, 30);
        add(Jlcheckout);

        
        // extract available rooms num from database and list in chRoomNum

        try{
            
            Conn cc = new Conn();
            String querry = "select * from customer";
            ResultSet rs = cc.s.executeQuery(querry);
            while(rs.next()){
                chID.add(rs.getString("idNumber"));
                Jlroom.setText(rs.getString("allocatedRoomNumber"));
                Jlcheckin.setText(rs.getString("check_in_time"));
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }



    

        JBcheckout = new JButton("CHECK OUT");
        JBcheckout.setBounds(60, 320, 150, 30);
        JBcheckout.setBackground(Color.BLACK);
        JBcheckout.setForeground(Color.WHITE);
        JBcheckout.addActionListener(this);
        add(JBcheckout);

        JBback = new JButton("BACK");
        JBback.setBounds(230, 320, 150, 30);
        JBback.setBackground(Color.BLACK);
        JBback.setForeground(Color.WHITE);
        JBback.addActionListener(this);
        add(JBback);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){ 

        if(ae.getSource()==JBcheckout){
            String querry = "delete  from customer where idNumber = '"+chID.getSelectedItem()+"'";
            String querry2 = "update room set availability = 'Available' where roomnumber = '"+Jlroom.getText()+"'";

            try{
                Conn cc = new Conn();
                cc.s.executeUpdate(querry);
                cc.s.executeUpdate(querry2);
                JOptionPane.showMessageDialog(null, "Check out Done Successfully");

                setVisible(false);
                new Reception();

            }
            catch(Exception e){
                e.printStackTrace();
            }

        }
        else if(ae.getSource()==JBback){
            setVisible(false);
            new Reception();
        }

    }

    public static void main(String [] args){
        new CheckOut();
    }
}