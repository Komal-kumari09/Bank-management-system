
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;


public class SignupTwo extends JFrame implements ActionListener {
    
    JTextField  pan,aadhar;
    JButton next;
    JRadioButton eyes,eno;
    JComboBox religion,income,category,occupation,education;
    String formno;

    SignupTwo(String formno) {
        this.formno= formno;
        setLayout(null);
        setTitle("PAGE2");

        JLabel additionalDetails = new JLabel("Page 2: ADDITIONAL DETAILS");
       additionalDetails.setBounds(290, 80, 400, 30);
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        add(additionalDetails);

        JLabel name = new JLabel("Religion");
        name.setBounds(100, 140, 100, 30);
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        add(name);
        
        String valReligion[] ={ "hindu","muslim","sikh","christian","other"};
        
         religion =new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
//        religion.setFont(new Font("Arial", Font.BOLD, 14));
        religion.setBackground(Color.white);
        add(religion);
       

        JLabel fname = new JLabel("Category");
        fname.setBounds(100, 190, 200, 30);
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        add(fname);
        String valcategory[] ={ "General","OBC","SC","ST","other"};
        category =new JComboBox(valcategory);
         category.setBounds(300, 190, 400, 30);
//        religion.setFont(new Font("Arial", Font.BOLD, 14));
        category.setBackground(Color.white);
        add(category);

       

        JLabel dob = new JLabel("Income");
        dob.setBounds(100, 240, 200, 30);
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        add(dob);
        
         String incomecategory[] ={ "null","<1,50,500","< 2,50,00","<5,00,000","upto 10,00,00"};
        income=new JComboBox(incomecategory);
        income.setBounds(300, 240, 400, 30);
//        religion.setFont(new Font("Arial", Font.BOLD, 14));
        income.setBackground(Color.white);
        add(income);
//
//        dateChooser = new JDateChooser();
//        dateChooser.setBounds(300, 240, 400, 30);
//        dateChooser.setFont(new Font("Arial", Font.BOLD, 14));
//        add(dateChooser);

        JLabel gender = new JLabel("Educational");
        gender.setBounds(100, 290, 200, 30);
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        add(gender);
        


        JLabel email = new JLabel("Qualification");
        email.setBounds(100, 315, 200, 30);
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        add(email);
        
         String educationValues[] ={ "non Graduate","Graduate","pg","Doctrate","Others"};
        education  =new JComboBox(educationValues);
         education.setBounds(300, 315, 400, 30);
//        religion.setFont(new Font("Arial", Font.BOLD, 14));
        education.setBackground(Color.white);
        add(education);
        
        JLabel marital = new JLabel("occupation");
        marital.setBounds(100, 390, 200, 30);
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        add(marital);
        
        String occupationValues[] ={ "Salaried","Self-employed","Bussiness","Student","Others"};

        occupation =new JComboBox(occupationValues);
         occupation.setBounds(300, 390, 400, 30);
//        religion.setFont(new Font("Arial", Font.BOLD, 14));
        occupation.setBackground(Color.white);
        add(occupation);
//        married = new JRadioButton("Married");
//        married.setBounds(300, 390, 100, 30);
//        married.setBackground(Color.white);
//        add(married);
//        unmarried = new JRadioButton("Unmarried");
//        unmarried.setBounds(450, 390, 100, 30);
//        unmarried.setBackground(Color.white);
//        add(unmarried);
//        other = new JRadioButton("Other");
//        other.setBounds(630, 390, 100, 30);
//        other.setBackground(Color.white);
//        add(other);
//        ButtonGroup maritalGroup = new ButtonGroup();
//        maritalGroup.add(married);
//        maritalGroup.add(unmarried);
//        maritalGroup.add(other);

        JLabel address = new JLabel("Pan number");
        address.setBounds(100, 440, 200, 30);
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        add(address);
        pan= new JTextField();
        pan.setBounds(300, 440, 400, 30);
        pan.setFont(new Font("Arial", Font.BOLD, 14));
        add(pan);

        JLabel state = new JLabel("Aadhar number:");
        state.setBounds(100, 490, 200, 30);
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        add(state);
        aadhar = new JTextField();
        aadhar.setBounds(300, 490, 400, 30);
        aadhar.setFont(new Font("Arial", Font.BOLD, 14));
        add(aadhar );

        JLabel country = new JLabel("Existing Account:");
        country.setBounds(100, 540, 200, 30);
        country.setFont(new Font("Raleway", Font.BOLD, 20));
        add(country);
        
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 540, 200, 30);
        eyes.setBackground(Color.white);
        add(eyes);
        eno = new JRadioButton("No");
        eno.setBounds(450, 540, 200, 30);
        eno.setBackground(Color.white);
        add(eno);
          ButtonGroup emaritalGroup = new ButtonGroup();
       emaritalGroup.add(eyes);
        emaritalGroup.add(eno);
       

        next = new JButton("Next");
        next.setBounds(620, 660, 80, 30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.white);
        setSize(800, 800);  // Increase the size to accommodate all components
        setVisible(true);
        setLocation(350, 200);
    }

    public void actionPerformed(ActionEvent ae) {

        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();


      
        String existingaccount = null;
        if (eyes.isSelected()) {
             existingaccount= "YES";
        } else if (eno.isSelected()) {
             existingaccount= "NO";
        }

        String span = pan.getText();
        String saadhar = aadhar.getText();
     
        // Validation for all required fields
        try {
          
                // Assuming Conn is a custom class for DB connection
                Conn c = new Conn();
                String query = "INSERT INTO signuptwo (formno, religion,category ,income, education,occupation, pan,aadhar, existingaccount) " +
                               "VALUES ('" + formno + "','" + sreligion + "','" + scategory + "','" + sincome+ "','" +seducation + "','" + soccupation + "','" + span+ "','" + saadhar + "','" +existingaccount + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Submitted Successfully!");
             setVisible(false);
              new Signup3(formno).setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new SignupTwo("");
    }
}

