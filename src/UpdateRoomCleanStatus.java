



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class UpdateRoomCleanStatus extends JFrame implements ActionListener{
  Choice chID;
  JButton JBcheck, JBupdate, JBback;
  JTextField tfavail ,tfcleaningStatus, tfamt, tfpamt, tfroom;

  UpdateRoomCleanStatus(){
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        setBounds(350, 200, 850, 540);


        // heading of frame
        JLabel lblheading = new JLabel("Update Room Cleaning Status");
        lblheading.setBounds(50, 30, 450, 40);
        lblheading.setForeground(Color.RED);
        lblheading.setFont(new Font("Tahoma",Font.PLAIN,30));
        add(lblheading);


        // set a image over the frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        // resize the image
        Image i2 = i1.getImage().getScaledInstance(450, 350, Image.SCALE_DEFAULT);
        //convert i2 into imageicon object
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 70, 450,350);  
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


        JLabel lblavailability = new JLabel("Availability");
        lblavailability.setBounds(60, 200, 120, 30);
        lblavailability.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblavailability);

        tfavail = new JTextField();
        tfavail.setBounds(200, 200, 150, 30);
        add(tfavail);


        JLabel lblcleaningStatus = new JLabel("Cleaning Status");
        lblcleaningStatus.setBounds(60, 250, 120, 30);
        lblcleaningStatus.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblcleaningStatus);

        tfcleaningStatus = new JTextField();
        tfcleaningStatus.setBounds(200, 250, 150, 30);
        add(tfcleaningStatus);




        JBcheck= new JButton("CHECK");
        JBcheck.setBounds(140, 340, 150, 30);
        JBcheck.setBackground(Color.BLACK);
        JBcheck.setForeground(Color.WHITE);
        JBcheck.addActionListener(this);
        add(JBcheck);

        JBupdate = new JButton("UPDATE");
        JBupdate.setBounds(60, 420, 150, 30);
        JBupdate.setBackground(Color.BLACK);
        JBupdate.setForeground(Color.WHITE);
        JBupdate.addActionListener(this);
        add(JBupdate);

        JBback = new JButton("BACK");
        JBback.setBounds(230, 420, 150, 30);
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
                  //  tfavail.setText(rs.getString("name"));
                  //  tfcleaningStatus.setText(rs.getString("check_in_time"));
                  //  tfamt.setText(rs.getString("deposit"));
                }
                String querry2 = "select * from room where roomnumber ='"+tfroom.getText()+"' ";
                ResultSet rs2 = cc.s.executeQuery(querry2);
                while(rs2.next()){
                    tfavail.setText(rs2.getString("availability"));
                    tfcleaningStatus.setText(rs2.getString("cleaning_status"));
                    
                }

            }

            catch(Exception e){
                e.printStackTrace();
            }
        }

        else if(ae.getSource()==JBupdate){
            String number = tfroom.getText();
            String cleaningStatus = tfcleaningStatus.getText();
            String avail = tfavail.getText();

            String querry3 = "update room set cleaning_status = '"+cleaningStatus+"', availability = '"+avail+"' where roomnumber = '"+number+"'";

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
        new UpdateRoomCleanStatus();
    }
}