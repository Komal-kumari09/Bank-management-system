/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;


public class FastCash  extends JFrame implements ActionListener{
    JButton deposit,withdrawl,ministatement,pinchange,fastcash,balanceenquiry,exit;
    String pinnumber;
    FastCash(String pinnumber){
         this .pinnumber=pinnumber;
         setLayout(null);
         ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
         Image i2= i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
         ImageIcon i3 =new ImageIcon(i2);
         JLabel image =new JLabel(i3);
         image.setBounds(0, 0, 900, 900);
         add(image);
         
         JLabel text =new JLabel("PLease select withrawl amount:");
         text.setBounds(210, 300, 700, 35);
         text.setForeground(Color.white);
         text.setFont(new Font("System",Font.BOLD,16));
         image.add(text);
          deposit  = new JButton("100");
          deposit.setBounds(170, 415, 150, 30);
           deposit.addActionListener(this);
          image.add(deposit);
          
         withdrawl = new JButton("500");
          withdrawl.setBounds(355, 415, 150, 30); 
            withdrawl .addActionListener(this);
          image.add(withdrawl);
          
           fastcash = new JButton("1000");
          fastcash.setBounds(170, 450, 150, 30);
          fastcash .addActionListener(this);
          image.add(fastcash);
          
           ministatement  = new JButton("2000");
          ministatement.setBounds(355, 450, 150, 30);
           ministatement.addActionListener(this);
          image.add(ministatement);
                  
          
           pinchange  = new JButton("5000 ");
           pinchange .setBounds(170, 485, 150, 30);
           pinchange .addActionListener(this);
          image.add( pinchange );
          
            balanceenquiry = new JButton("10000 ");
          balanceenquiry .setBounds(355, 485, 150, 30);
          balanceenquiry.addActionListener(this);
          image.add(balanceenquiry );
          
           exit  = new JButton("back");
          exit.setBounds(355, 520, 150, 30);
          exit.addActionListener(this);
          image.add(exit); 
          
                  
                  
         setSize(900,900);
         setLocation(300,0);
         setUndecorated(true);
         setVisible(true);
     }
     
     
     @Override
    public void actionPerformed(ActionEvent ae) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        if(ae.getSource()== exit){
             setVisible(false);
                   new Transaction(pinnumber).setVisible(true); 
        }
        
       else {
            String amount =((JButton)ae.getSource()).getText().substring(3);
           Conn c =new Conn();
            try {
              ResultSet rs =c.s.executeQuery("select * from bank where pin = '"+pinnumber+"' ");
              int balance= 0;
              while(rs.next()){
                  if(rs.getString("type").equals("Deposit")){
                      balance += Integer.parseInt(rs.getString("amount"));
                  }else{
                      balance -= Integer.parseInt(rs.getString("amount")); 
                  }
              }
              
              if(ae.getSource() !=exit && balance < Integer.parseInt(amount)){
                  JOptionPane.showMessageDialog(null, "insufficient Balance");
                  return;
              }
               
              Date date =new Date();
              String query ="insert into bank values('"+pinnumber+"','"+date+"','+Withrawl+','"+amount+"'  )";
              c.s.executeUpdate(query);
              JOptionPane.showMessageDialog(null, "rs"+amount+"debited ");
              setVisible(false);
              new Transaction(pinnumber).setVisible(true);
     
            }catch(Exception e){
           
       }
        }
    }
     
     public static void main(String args[]){
         new FastCash("");
     }

    
}
