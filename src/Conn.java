
import java.sql.*;
//import java.lang.*;

public class Conn {

    Connection c;
    Statement s;
    Conn(){
        try{
           // System.out.println("hi how are you 1 ");
            // register the jdbc with mysql
           Class.forName("com.mysql.cj.jdbc.Driver");
          //  System.out.println("hi how are you 2 ");

            // establish connection with database of hotelmanagementsystem
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem","root","1234");

            //create statement for querry from database
            s = c.createStatement();
           // System.out.println("hi how are you");
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

 /*   public static void main(String [] args){
        System.out.println("hi how are you in main ");
        new Conn();
    } */
    

}


/*
create database hotelmanagementsystem;
show databases;
use hotelmanagementsystem;
create table login(username varchar(25), password varchar(25));
select *from login;
insert into login values('Gumutch', 'Gumutch@mysql');
select *from login;
 */
