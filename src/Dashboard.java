
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.awt.*;

public class Dashboard extends JFrame implements ActionListener{
    Dashboard(){

        // set frame size
        setBounds(0, 0, 1900, 1000);
        
        // if setLayout is null , setBounds method work
        setLayout(null);

        // set a image over the frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        // resize the image
        Image i2 = i1.getImage().getScaledInstance(1900, 1000, Image.SCALE_DEFAULT);
        //convert i2 into imageicon object
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1900,1000);  
        add(image);


        // for text over image on the frame
        JLabel text = new JLabel("THE TAJ GROUP WELCOMES YOU");
        text.setBounds(400, 80, 1300,70);  // combination of setSize+setLocation
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Tahoma",Font.PLAIN,80));
        image.add(text);


        //add a menubar strip
        JMenuBar mb = new JMenuBar();
        mb.setBounds(0, 0, 1900, 30);
        mb.setBackground(Color.LIGHT_GRAY);
        image.add(mb);


        // add menu list one by one along menu bar strip
        JMenu hotel = new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.RED);
        mb.add(hotel);

        //add menu items in each menu
        JMenuItem reception = new JMenuItem("RECEPTION");
        reception.setForeground(Color.BLACK);
        reception.addActionListener(this);
        hotel.add(reception);
        

        // add menu list one by one along menu bar strip
        JMenu admin = new JMenu("ADMIN");
        admin.setForeground(Color.BLUE);
        mb.add(admin);

        //add menu items in each menu
        JMenuItem addemployee = new JMenuItem("ADD EMPLOYEE");
        addemployee.setForeground(Color.BLACK);
        addemployee.addActionListener(this);
        admin.add(addemployee);

        JMenuItem addrooms = new JMenuItem("ADD ROOMS");
        addrooms.setForeground(Color.BLACK);
        addrooms.addActionListener(this);
        admin.add(addrooms);

        JMenuItem adddrivers = new JMenuItem("ADD DRIVERS");
        adddrivers.setForeground(Color.BLACK);
        adddrivers.addActionListener(this);
        admin.add(adddrivers);


        setVisible(true);

    }

    // implement actionPerformed method of class ActionListener
    // when menu element is clicked
    public void actionPerformed(ActionEvent ae){

        if(ae.getActionCommand().equals("ADD EMPLOYEE")){
            new addEmployee();

        }
        else  if(ae.getActionCommand().equals("ADD ROOMS")){
            new AddRooms();

        }
        else  if(ae.getActionCommand().equals("ADD DRIVERS")){
            new AddDriver();

        }
        else  if(ae.getActionCommand().equals("RECEPTION")){
            new Reception();

        }
     
    }
    

    public static void main(String [] args){
        new Dashboard();
    }
}
