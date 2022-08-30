//package hotel.management.system;

// swing package for GUI interface 
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

// JFrame is a class in swing package act as parent class for HotelManagementSystem
public class HotelManagementSystem extends JFrame implements ActionListener{
    
    // constructor for HotelManagementSystem
    HotelManagementSystem(){
        
        // setSize method present in JFrame class which is used to set frame size
        setSize(1366,565);

        // setLocation method present in JFrame class which is used to set frame 
        //origin from top left position over pc screen default is (0,0)
        setLocation(100, 100);

        setLayout(null);
        
        // set a image over the frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1366,565);  // combination of setSize+setLocation
        add(image);

        // for text over image on the frame
        JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(20, 430, 900,50);  // combination of setSize+setLocation
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif",Font.PLAIN,50));
        image.add(text);

        
        // for button over image on the frame
        JButton next = new JButton("Next");
        next.setBounds(1150, 450, 150,50);  // combination of setSize+setLocation
        next.setForeground(Color.BLACK);
        // set Action on click the next button
        next.addActionListener(this);
        next.setFont(new Font("serif",Font.PLAIN,30));
        image.add(next);
        

        // setVisible method present in JFrame class which is used to set visible frame over pc screen
        setVisible(true);
        
        // for dipper functionality
        while(true){
            text.setVisible(false);
            try{
                Thread.sleep(500);
            } catch (Exception e){
                   e.printStackTrace(); 
            }

            text.setVisible(true);
            try{
                Thread.sleep(500);
            } catch (Exception e){
                   e.printStackTrace(); 
            }
        }
    }
    
    // implement actionPerformed method of class ActionListener
    // when next button is clicked
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }

    public static void main(String[] args){

        // call constructor
        new HotelManagementSystem();
    }
}