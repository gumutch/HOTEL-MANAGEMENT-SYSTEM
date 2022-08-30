

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class UpdateCheck extends JFrame implements ActionListener{
  Choice chID;
  JButton JBcheck, JBupdate, JBback;
  JTextField tfname ,tfcheckin, tfamt, tfpamt, tfroom;

    UpdateCheck(){
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        setBounds(350, 200, 850, 540);


        // heading of frame
        JLabel lblheading = new JLabel("Update Customer Status");
        lblheading.setBounds(40, 30, 350, 30);
        lblheading.setForeground(Color.RED);
        lblheading.setFont(new Font("Tahoma",Font.PLAIN,30));
        add(lblheading);


        // set a image over the frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        // resize the image
        Image i2 = i1.getImage().getScaledInstance(450, 350, Image.SCALE_DEFAULT);
        //convert i2 into imageicon object
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 60, 450,350);  
        add(image);

        JLabel lblid = new JLabel("Customer ID");
        lblid.setBounds(60, 100, 120, 30);
        lblid.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblid);

        chID = new Choice();

        // extract available rooms num from database and list in chRoomNum

        try{
            
            Conn cc = new Conn();
            String querry = "select * from customer";
            ResultSet rs = cc.s.executeQuery(querry);
            while(rs.next()){
                chID.add(rs.getString("idNumber"));
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }

        chID.setBounds(200, 100, 150, 30);
        chID.setBackground(Color.WHITE);
        add(chID);


        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(60, 150, 120, 30);
        lblroom.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblroom);

        tfroom = new JTextField();
        tfroom.setBounds(200, 150, 150, 30);
        add(tfroom);


        JLabel lblname = new JLabel("Customer Name");
        lblname.setBounds(60, 200, 120, 30);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 200, 150, 30);
        add(tfname);


        JLabel lblcheckin = new JLabel("Check in");
        lblcheckin.setBounds(60, 250, 120, 30);
        lblcheckin.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblcheckin);

        tfcheckin = new JTextField();
        tfcheckin.setBounds(200, 250, 150, 30);
        add(tfcheckin);


        JLabel lblamt = new JLabel("Amount Paid");
        lblamt.setBounds(60, 300, 120, 30);
        lblamt.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblamt);

        tfamt = new JTextField();
        tfamt.setBounds(200, 300, 150, 30);
        add(tfamt);


        JLabel lblpamt = new JLabel("Pending Amount");
        lblpamt.setBounds(60, 350, 150, 30);
        lblpamt.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblpamt);

        tfpamt = new JTextField();
        tfpamt.setBounds(200, 350, 150, 30);
        add(tfpamt);

        JBcheck= new JButton("CHECK");
        JBcheck.setBounds(60, 420, 150, 30);
        JBcheck.setBackground(Color.BLACK);
        JBcheck.setForeground(Color.WHITE);
        JBcheck.addActionListener(this);
        add(JBcheck);

        JBupdate = new JButton("UPDATE");
        JBupdate.setBounds(240, 420, 150, 30);
        JBupdate.setBackground(Color.BLACK);
        JBupdate.setForeground(Color.WHITE);
        JBupdate.addActionListener(this);
        add(JBupdate);

        JBback = new JButton("BACK");
        JBback.setBounds(430, 420, 150, 30);
        JBback.setBackground(Color.BLACK);
        JBback.setForeground(Color.WHITE);
        JBback.addActionListener(this);
        add(JBback);


        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==JBcheck){
            String selID = chID.getSelectedItem();
            String querry = "select * from customer where idNumber = '"+selID+"'";
           

            try{

                Conn cc =new Conn();
                ResultSet rs = cc.s.executeQuery(querry);
                while(rs.next()){
                    tfroom.setText(rs.getString("allocatedRoomNumber"));
                    tfname.setText(rs.getString("name"));
                    tfcheckin.setText(rs.getString("check_in_time"));
                    tfamt.setText(rs.getString("deposit"));
                }
                String querry2 = "select * from room where roomnumber ='"+tfroom.getText()+"' ";
                ResultSet rs2 = cc.s.executeQuery(querry2);
                while(rs2.next()){
                    String price = rs2.getString("price");
                    int balance = Integer.parseInt(price) - Integer.parseInt(tfamt.getText());
                    tfpamt.setText("" + balance);
                }

            }

            catch(Exception e){
                e.printStackTrace();
            }
        }

        else if(ae.getSource()==JBupdate){
            String number = chID.getSelectedItem();
            String name = tfname.getText();
            String room = tfroom.getText();
            String checkin = tfcheckin.getText();
            String deposit = tfamt.getText();
            String querry3 = "update customer set allocatedRoomNumber = '"+room+"', name = '"+name+"', check_in_time = '"+checkin+"', deposit = '"+deposit+"'";

            try{

                Conn cc = new Conn();
                cc.s.executeUpdate(querry3);
                JOptionPane.showMessageDialog(null, "Data Updated Successfully");

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
        new UpdateCheck();
    }
}