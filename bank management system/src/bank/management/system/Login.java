
package bank.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JLabel heading,lblcardno,lblpin,image1;
    JTextField tfcardno ;
    JPasswordField pfpassword;
    JButton  btnsignin ,btnclear,btnsignup;
    JToggleButton toggleButton;
     ImageIcon eyeOpenIcon;
    ImageIcon eyeClosedIcon;
    ImageIcon i7,i5;
  
    Login(){
        
        setTitle("AUTOMATED TELLER MACHINE");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(350, 100, 100, 100);
        add(l11);
        
        heading = new JLabel("WELCOME TO ATM");
        heading.setFont(new Font("Osward", Font.BOLD, 60));
        heading.setBounds(500,100,800,100);
        add(heading);
        
        lblcardno = new JLabel("Card No:");
        lblcardno.setFont(new Font("Raleway", Font.BOLD, 28));
        lblcardno.setBounds(500,300,375,40);
        add(lblcardno);
        
        tfcardno = new JTextField(16);
        tfcardno.setDocument(new JTextFieldCardNumber(16));
        tfcardno .setBounds(700,300,350,40);
        tfcardno .setFont(new Font("Arial", Font.BOLD, 24));
        add(tfcardno );
        
        lblpin = new JLabel("PIN:");
        lblpin.setFont(new Font("Raleway", Font.BOLD, 28));
        lblpin.setBounds(500,400,500,40);
        add(lblpin);
        
        pfpassword = new JPasswordField(15);
        pfpassword.setDocument(new JTextFieldPin(4));
        pfpassword.setFont(new Font("Arial", Font.BOLD, 24));
        pfpassword.setBounds(700,400,310,40);
        add(pfpassword);
        

        
       eyeOpenIcon=new ImageIcon(ClassLoader.getSystemResource("icons/openeye.png"));
        
        Image i4 = eyeOpenIcon.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT);
         i5 = new ImageIcon(i4);
        
        toggleButton = new JToggleButton(i5);
        toggleButton.setBackground(Color.WHITE);
        toggleButton.setBounds(1010, 400, 40, 40);
        toggleButton.addActionListener(this);
        add(toggleButton);        
       
        
        eyeClosedIcon= new ImageIcon(ClassLoader.getSystemResource("icons/closeeye.png"));
        Image i6 = eyeClosedIcon.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT);
        i7 = new ImageIcon(i6);
       
        
       
        
        btnsignin = new JButton("LOGIN");
        btnsignin .setBackground(Color.BLACK);
        btnsignin .setForeground(Color.WHITE);
        btnsignin .setFont(new Font("Arial", Font.BOLD, 20));
        btnsignin .setBounds(700,500,125,40);
         btnsignin .addActionListener(this);
        add( btnsignin );
        
        btnclear = new JButton("CLEAR");
        btnclear.setBackground(Color.BLACK);
        btnclear.setForeground(Color.WHITE);
        btnclear.setFont(new Font("Arial", Font.BOLD, 20));
        btnclear.setBounds(925,500,125,40);
        btnclear.addActionListener(this);
        add(btnclear);
        
        btnsignup = new JButton("NEW USER");
        btnsignup.setBackground(Color.BLACK);
        btnsignup.setForeground(Color.WHITE);
        btnsignup.setFont(new Font("Arial", Font.BOLD, 20));
        btnsignup.setBounds(700,580,350,40);
         btnsignup.addActionListener(this);
        add(btnsignup);
        
        setLayout(null);
        
    
        getContentPane().setBackground(Color.WHITE);
        
        setSize(1600,900);
        //setLocation(100,100);
       //setBounds(0,0,1600,800);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
      
        if (ae.getSource() == toggleButton) {
            if (toggleButton.isSelected()) {
                pfpassword.setEchoChar((char) 0); 
                toggleButton.setIcon(i7); 
            } else {
                pfpassword.setEchoChar('\u2022'); 
                toggleButton.setIcon(i5); 
            }
        }
 
        
        try
        {        
            if(ae.getSource()== btnsignin )
            {
                Conn c1 = new Conn();
                String cardno  = tfcardno .getText();
                String pin  = pfpassword.getText();
                String q  = "select * from login where cardnumber = '"+cardno+"' and pin = '"+pin+"'";

                ResultSet rs = c1.s.executeQuery(q);
                if(rs.next())
                {
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                   
                }
            }
            else if(ae.getSource()==btnclear)
            {
                tfcardno .setText("");
               pfpassword.setText("");
            }
            else if (ae.getSource()==btnsignup)
            {
                setVisible(false);
                new Signup().setVisible(true);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args)
    {
        new Login().setVisible(true);

    }
}