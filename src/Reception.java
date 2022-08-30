
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class Reception extends JFrame implements ActionListener{

    JButton bNewCustomerForm, bRoom, bDepartment, bAllEmployeeInfo, bCustomerInfo, bManagerInfo, bCheckOut, bUpdateStatus, bUpdateRoomStatus, bPickupService, bSearchRoom, bLogout;

    Reception(){

        setLayout(null);

        getContentPane().setBackground(Color.WHITE);
        setBounds(350, 200, 850, 600);

        bNewCustomerForm = new JButton("New Customer Form");
        bNewCustomerForm.setBounds(10, 30, 200, 30);
        bNewCustomerForm.setBackground(Color.BLACK);
        bNewCustomerForm.setForeground(Color.WHITE);
        bNewCustomerForm.addActionListener(this);
        add(bNewCustomerForm);


        bRoom = new JButton("ROOM");
        bRoom.setBounds(10, 70, 200, 30);
        bRoom.setBackground(Color.BLACK);
        bRoom.setForeground(Color.WHITE);
        bRoom.addActionListener(this);
        add(bRoom);


        bDepartment = new JButton("DEPARTMENT");
        bDepartment.setBounds(10, 110, 200, 30);
        bDepartment.setBackground(Color.BLACK);
        bDepartment.setForeground(Color.WHITE);
        bDepartment.addActionListener(this);
        add(bDepartment);


        bAllEmployeeInfo = new JButton("ALL EMPLOYEE INFO");
        bAllEmployeeInfo.setBounds(10, 150, 200, 30);
        bAllEmployeeInfo.setBackground(Color.BLACK);
        bAllEmployeeInfo.setForeground(Color.WHITE);
        bAllEmployeeInfo.addActionListener(this);
        add(bAllEmployeeInfo);


        bCustomerInfo = new JButton("CUSTOMER INFO");
        bCustomerInfo.setBounds(10, 190, 200, 30);
        bCustomerInfo.setBackground(Color.BLACK);
        bCustomerInfo.setForeground(Color.WHITE);
        bCustomerInfo.addActionListener(this);
        add(bCustomerInfo);


        bManagerInfo = new JButton("MANAGER INFO");
        bManagerInfo.setBounds(10, 230, 200, 30);
        bManagerInfo.setBackground(Color.BLACK);
        bManagerInfo.setForeground(Color.WHITE);
        bManagerInfo.addActionListener(this);
        add(bManagerInfo);


        bCheckOut = new JButton("CHECK OUT");
        bCheckOut.setBounds(10, 270, 200, 30);
        bCheckOut.setBackground(Color.BLACK);
        bCheckOut.setForeground(Color.WHITE);
        bCheckOut.addActionListener(this);
        add(bCheckOut);


        bUpdateStatus = new JButton("UPDATE CUSTOMER STATUS");
        bUpdateStatus.setBounds(10, 310, 200, 30);
        bUpdateStatus.setBackground(Color.BLACK);
        bUpdateStatus.setForeground(Color.WHITE);
        bUpdateStatus.addActionListener(this);
        add(bUpdateStatus);


        bUpdateRoomStatus = new JButton("UPDATE ROOM STATUS");
        bUpdateRoomStatus.setBounds(10, 350, 200, 30);
        bUpdateRoomStatus.setBackground(Color.BLACK);
        bUpdateRoomStatus.setForeground(Color.WHITE);
        bUpdateRoomStatus.addActionListener(this);
        add(bUpdateRoomStatus);


        bPickupService = new JButton("PICK UP SERVICE");
        bPickupService.setBounds(10, 390, 200, 30);
        bPickupService.setBackground(Color.BLACK);
        bPickupService.setForeground(Color.WHITE);
        bPickupService.addActionListener(this);
        add(bPickupService);


        bSearchRoom = new JButton("SEARCH ROOM");
        bSearchRoom.setBounds(10, 430, 200, 30);
        bSearchRoom.setBackground(Color.BLACK);
        bSearchRoom.setForeground(Color.WHITE);
        bSearchRoom.addActionListener(this);
        add(bSearchRoom);


        bLogout = new JButton("LOGOUT");
        bLogout.setBounds(10, 470, 200, 30);
        bLogout.setBackground(Color.BLACK);
        bLogout.setForeground(Color.WHITE);
        bLogout.addActionListener(this);
        add(bLogout);



        // set a image over the frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        // resize the image
        Image i2 = i1.getImage().getScaledInstance(600, 500, Image.SCALE_DEFAULT);
        //convert i2 into imageicon object
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(220, 20, 600,500);  
        add(image);





        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==bNewCustomerForm){
            setVisible(false);
            new AddCustomer();

        }

        else if(ae.getSource()==bRoom){
            setVisible(false);
            new Room();

        }
        else if(ae.getSource()==bDepartment){
            setVisible(false);
            new Department();

        }
        else if(ae.getSource()==bAllEmployeeInfo){
            setVisible(false);
            new AllEmployee();

        }
        else if(ae.getSource()==bCustomerInfo){
            setVisible(false);
            new AllCustomer();

        }
        else if(ae.getSource()==bManagerInfo){
            setVisible(false);
            new ManagerInfo();

        }
        else if(ae.getSource()==bSearchRoom){
            setVisible(false);
            new SearchRoom();

        }
        else if(ae.getSource()==bUpdateStatus){
            setVisible(false);
            new UpdateCheck();

        }

        else if(ae.getSource()==bUpdateRoomStatus){
            setVisible(false);
            new UpdateRoomCleanStatus();
        }

        else if(ae.getSource()==bPickupService){
            setVisible(false);
            new PickupService();
        }
        else if(ae.getSource()==bLogout){
            setVisible(false);
           // new HotelManagementSystem();
        }
        else if(ae.getSource()==bCheckOut){
            setVisible(false);
            new CheckOut();
        }
    }


    public static void main(String [] args){
        new Reception();
    }
    
}
