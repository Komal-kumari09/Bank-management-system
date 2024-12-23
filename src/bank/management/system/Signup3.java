/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Signup3 extends JFrame implements ActionListener {
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton  submit,cancel;
    String formno;
    Signup3(String Formno){
        setLayout(null);
        JLabel l1=new JLabel("PAGE3 : Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(200,40,400,40);
        add(l1);
//        JLabel =new JLabel("");
//       .setFont(new Font("Raleway",Font.BOLD,22));
//       .setBounds(100,140,200,30);
//        add();
         JLabel type =new JLabel("Account Type");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,140,200,30);
        add( type);
        r1 =new JRadioButton("Saving Account");
       r1.setFont(new Font("Raleway",Font.BOLD,16));
       r1.setBounds(100,180,250,20);
       r1.setBackground(Color.white);
        add(r1);
         r2 =new JRadioButton("Fixed Deposit Account");
       r2.setFont(new Font("Raleway",Font.BOLD,16));
       r2.setBounds(350,220,250,20);
       r2.setBackground(Color.white);
        add(r2);
         r3 =new JRadioButton("current Account");
       r3.setFont(new Font("Raleway",Font.BOLD,16));
       r3.setBounds(100,220,250,20);
       r3.setBackground(Color.white);
        add(r3);
         r4 =new JRadioButton("Recurring Deposit Account");
       r4.setFont(new Font("Raleway",Font.BOLD,16));
       r4.setBounds(350,180,250,20);
       r4.setBackground(Color.white);
        add(r4);
        ButtonGroup GroupAccount =new    ButtonGroup();
        GroupAccount.add(r1);
       GroupAccount.add(r2);
       GroupAccount.add(r3);
       GroupAccount.add(r4);
       
         JLabel  card=new JLabel("Card Number");
       card.setFont(new Font("Raleway",Font.BOLD,22));
       card.setBounds(100,300,200,30);
        add(card);
         JLabel number =new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(330,300,300,30);
        add( number);
//           JLabel =new JLabel(" ");
//       .setFont(new Font("Raleway",Font.BOLD,22));
//       .setBounds(100,140,200,30);
//        add();
         JLabel pin=new JLabel("PIN");
       pin.setFont(new Font("Raleway",Font.BOLD,22));
       pin.setBounds(100,370,200,30);
        add(pin);
         JLabel pnumber =new JLabel("XXXXXX");
       pnumber.setFont(new Font("Raleway",Font.BOLD,22));
       pnumber.setBounds(330,370,300,30);
        add(pnumber);
           JLabel pindetails =new JLabel("Your 4 digit Password");
       pindetails .setFont(new Font("Raleway",Font.BOLD,12));
       pindetails .setBounds(100,400,300,20);
        add(pindetails );
          JLabel  services=new JLabel(" services Reqired");
       services.setFont(new Font("Raleway",Font.BOLD,22));
       services.setBounds(100,450,200,30);
        add(services);
      
//        c =new JCheckBox("");
//        c.setBackground(Color.white);
//        c.setFont(new Font("Raleway",Font.BOLD,16));
//        c.setBounds(100,500,200,30);
//        add(c);
         c1 =new JCheckBox("ATM Card");
        c1.setBackground(Color.white);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,500,200,30);
        add(c1);
         c2 =new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,500,200,30);
        add(c2);
         c3 =new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,550,200,30);
        add(c3);
         c4 =new JCheckBox("Email aletrs");
        c4.setBackground(Color.white);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,550,200,30);
        add(c4);
                 c5 =new JCheckBox("Cheque Book");
        c5.setBackground(Color.white);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,600,200,30);
        add(c5);
         c6 =new JCheckBox("E-Statement");
        c6.setBackground(Color.white);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,600,200,30);
        add(c6);
         c7 =new JCheckBox("i hereby declare that above details are correct");
        c7.setBackground(Color.white);
        c7.setFont(new Font("Raleway",Font.BOLD,16));
        c7.setBounds(100,680,600,30);
        add(c7);
        submit=new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Raleways",Font.BOLD,14));
        submit.setBounds(250, 720, 100, 30);
        submit.addActionListener(this);
        add(submit);
        
        cancel=new JButton("Cancel");
          cancel.setBackground(Color.black);
          cancel.setForeground(Color.white);
         cancel.setFont(new Font("Raleways",Font.BOLD,14));
          cancel.setBounds(420, 720, 100, 30);
          cancel.addActionListener(this);
        add(  cancel);

        
        
        getContentPane().setBackground(Color.white);
        
        setVisible(true);
        setSize(850,820);
        setLocation(350,0);
    }
     @Override
    public void actionPerformed(ActionEvent ae) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        if(ae.getSource() == submit){
             String accountType=null;
          if(r1.isSelected()){
              accountType="Saving account";
          }  else if (r2.isSelected()){
               accountType="Fixed Deposit Account";
          }
           else if (r3.isSelected()){
               accountType="Current Account";
          }
           else if (r4.isSelected()){
               accountType="Reccuring Deposit  Account";
          }
          
          Random random =new Random();
          String cardnumber= "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
          String pinnumber= "" + Math.abs((random.nextLong() % 9000L)) + 1000L;
          
          String facility="";
          if(c1.isSelected()){
              facility= facility +"ATM Card";
          }else if(c2.isSelected()){
              facility= facility +"internet Banking";
          }else if(c3.isSelected()){
              facility= facility +"Mobile Banking";
          }else if(c4.isSelected()){
              facility= facility +"Emails Alerts";
          }else if(c5.isSelected()){
              facility= facility +"Cheque Book ";
          }else if(c6.isSelected()){
              facility= facility +"E-Statement";
          }
          
          try{
              if (accountType.equals("")){
              JOptionPane.showMessageDialog(null,"Account Type is reqired");
              }else{
                  Conn conn =new Conn();
                String query1 = "insert into signupthree values('"+formno+"' ,'"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
               String query2= "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
             conn.s.executeUpdate(query1);
             conn.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null,"cardNumber" +cardnumber+ "\n Pin: " + pinnumber);
             
              
              setVisible(false);
              new Deposit(pinnumber).setVisible(false);
              }
          }catch (Exception e){
              System.out.println(e);
          }
          
 
        }else if(ae.getSource()== cancel){
             setVisible(false);
              new Login().setVisible(true);
        }
    }
    
    public static void main(String args[] ){
        new Signup3("");
    }

   
}
