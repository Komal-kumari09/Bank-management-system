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

public class PinChange extends JFrame implements ActionListener{
    JLabel image,text,pintext;
    JTextField pin,repin;
    JButton change,back;
    String pinnumber;
   PinChange(String pinnumber){
         this .pinnumber=pinnumber;
         setLayout(null);
         ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
         Image i2= i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
         ImageIcon i3 =new ImageIcon(i2);
          image =new JLabel(i3);
         image.setBounds(0, 0, 900, 900);
         add(image);
           text=new JLabel("CHANGE YOUR PIN");
         text.setFont(new Font("System",Font.BOLD,16));
         text.setBounds(250, 280, 500, 35);
         text.setForeground(Color.WHITE);
         image.add(text);
         
             pintext =new JLabel("New PIN");
         pintext.setFont(new Font("raleway",Font.BOLD,16));
         pintext.setBounds(160, 320, 100, 25);
         pintext.setForeground(Color.WHITE);
         image.add(pintext);
         
    
       pin = new JTextField();
        pin.setBounds(330, 320, 180, 25);
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        image.add(pin);
           JLabel repintext =new JLabel("Re-Enter New PIN");
         repintext.setFont(new Font("Raleway",Font.BOLD,16));
         repintext.setBounds(165, 360, 180, 25);
         repintext.setForeground(Color.WHITE);
         image.add(repintext);
         
    
         repin = new JTextField();
        repin.setBounds(330, 360, 180, 25);
        repin.setFont(new Font("Raleway", Font.BOLD, 25));
        image.add(repin);
        
         change =new JButton("change");
        change .setBackground(Color.black);
        change.setForeground(Color.white);
           change.setFont(new Font("Raleways",Font.BOLD,14));
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this);
        image.add(change);
           back=new JButton("BACK");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setFont(new Font("Raleways",Font.BOLD,14));
         back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
       image.add(back);
        
         
         
         
         
         
//            JLabel =new JLabel("");
//         .setFont(new Font("raleway",Font.BOld,16));
//         .setBounds(170, 350, 400, 20);
//         .setForeground(Color.WHITE);
//      JLabel =new JLabel("");
//         .setFont(new Font("raleway",Font.BOld,16));
//         .setBounds(170, 350, 400, 20);
//         .setForeground(Color.WHITE);
    
////         JTextField = new JTextField();
////        .setBounds(300, 190, 400, 30);
////        .setFont(new Font("Arial", Font.BOLD, 14));
////        add();
////        

    
    
    
          setSize(900,900);
         setLocation(300,0);
         setUndecorated(true);
         setVisible(true);
    }
   
    @Override
    public void actionPerformed(ActionEvent ae) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        if(ae.getSource() == change){
           try{
              String npin= pin.getText();
              String rpin= pin.getText();
                
              if(!npin.equals(rpin)){
                  JOptionPane.showMessageDialog(null,"enterd pin doesnot match" );
                  return;
              }
              
              Conn conn =new Conn();
              String query1 ="update bank set pin= '"+rpin+"' where pin= '"+pinnumber+"'";
              String query2 ="update login set pin= '"+rpin+"' where pin= '"+pinnumber+"'";
              String query3 ="update signupthree set pin= '"+rpin+"' where pin= '"+pinnumber+"'";
                  
              conn.s.execute(query1);
              conn.s.execute(query2);
              conn.s.execute(query3);
            JOptionPane.showMessageDialog(null,"PIN changes successfully" );
                 setVisible(false);
        new Transaction(pinnumber).setVisible(true);
              
          } catch(Exception e){
              System.out.println(e);
          } 
        } 
         else{
        
             setVisible(false);
        new Transaction(pinnumber).setVisible(true);
    }



    }
   
     public static void main(String args[]){
         new PinChange("");
     }

   
}