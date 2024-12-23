/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;
  import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;


public class BalanceEnquiry  extends JFrame implements ActionListener{
    JButton exit;
    String pinnumber;
       int balance= 0;
    BalanceEnquiry(String pinnumber){
         this.pinnumber=pinnumber;
         setLayout(null);
         ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
         Image i2= i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
         ImageIcon i3 =new ImageIcon(i2);
         JLabel image =new JLabel(i3);
         image.setBounds(0, 0, 900, 900);
         add(image);
         
        JLabel text =new JLabel("your current balance is" +balance);
         text.setBounds(170, 300, 400, 30);
         text.setForeground(Color.white);
         text.setFont(new Font("System",Font.BOLD,16));
         image.add(text); 
    
     setSize(900,900);
         setLocation(300,0);
         setUndecorated(true);
         setVisible(true);
    
    
     exit  = new JButton("back");
          exit.setBounds(355, 520, 150, 30);
          exit.addActionListener(this);
          image.add(exit);
          
           Conn c =new Conn();
         
            try {
              ResultSet rs =c.s.executeQuery("select * from bank where pin = '"+pinnumber+"' ");
             
              while(rs.next()){
                  if(rs.getString("type").equals("Deposit")){
                      balance += Integer.parseInt(rs.getString("amount"));
                  }else{
                      balance -= Integer.parseInt(rs.getString("amount")); 
                  }
              }
            }catch(Exception e){
                System.out.println(e);
            }
              
        
                  
                  
        } 
    
      @Override
    public void actionPerformed(ActionEvent ae) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
             setVisible(false);
              new Transaction(pinnumber).setVisible(true);
     
    }
     public static void main(String args[]){
         new BalanceEnquiry("");
     }
     }

  

