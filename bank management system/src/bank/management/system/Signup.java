
package bank.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Date;

public class Signup extends JFrame implements ActionListener{
    
    JLabel lblformno,lblpd,lblname,lblfname,lbldob,lblgender,lblemail,lblmarital,lbladdress,lblcity,lblpin,lblstate,lbldate,lblmonth,lblyear;
    JTextField tfname,tffname,tfemail,tfaddress,tfcity,tfpin,tfstate;
    JRadioButton r1,r2,r3,r4,r5;
    JButton b;
    JDateChooser dateChooser;
    JTextFieldDateEditor editor;
    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    String first = "" + Math.abs(first4);
    
    
    Signup(){
        
        setTitle("NEW ACCOUNT APPLICATION FORM");
       
        setLayout(null);
         
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(300, 0, 100, 100);
        add(l11);
        
        lblformno = new JLabel("APPLICATION FORM NO. "+first);
        lblformno.setFont(new Font("Raleway", Font.BOLD, 38));
        lblformno.setBounds(500,20,900,40);
        add(lblformno);
        
        lblpd = new JLabel("Page 1: Personal Details");
        lblpd.setFont(new Font("Raleway", Font.BOLD, 22));
        lblpd.setBounds(650,80,600,30);
        add(lblpd);
  
        lblname = new JLabel("Name:");
        lblname.setFont(new Font("Raleway", Font.BOLD, 20));
        lblname.setBounds(100,140,100,30);
        add(lblname);
       
        tfname= new  JTextField(20);
        tfname.setDocument(new JTextFieldCharLimit(15));
        tfname.setFont(new Font("Raleway", Font.BOLD, 14));
        tfname.setBounds(300,140,400,30);
        add(tfname);
        
        lblfname = new JLabel("Father's Name:");
        lblfname.setFont(new Font("Raleway", Font.BOLD, 20));
        lblfname.setBounds(100,190,200,30);
        add(lblfname);
         
        tffname = new JTextField(20);
        tffname.setDocument(new JTextFieldCharLimit(15));
        tffname.setFont(new Font("Raleway", Font.BOLD, 14));
        tffname.setBounds(300,190,400,30);
        add(tffname);
           
        lbldob = new JLabel("Date of Birth:");
        lbldob.setFont(new Font("Raleway", Font.BOLD, 20));
        lbldob.setBounds(100,240,200,30);
        add(lbldob);
       
        lbldate = new JLabel("Date");
        lbldate.setFont(new Font("Raleway", Font.BOLD, 14));
        
        lblmonth = new JLabel("Month");
        lblmonth.setFont(new Font("Raleway", Font.BOLD, 14));
        
        lblyear = new JLabel("Year");
        lblyear.setFont(new Font("Raleway", Font.BOLD, 14));
    
    //     Date date = new Date();
         //date.before(today);
     //   date.before(2004,1,1);
    
        
        dateChooser = new JDateChooser();
        editor = (JTextFieldDateEditor) dateChooser.getDateEditor();
        editor.setEditable(false);
     
	dateChooser.setForeground(new Color(105, 105, 105));
        dateChooser.setBounds(300, 240, 400, 30);
        
        
        dateChooser.setMaxSelectableDate(new Date());
	add(dateChooser);
        
        
      
        lblgender = new JLabel("Gender:");
        lblgender.setFont(new Font("Raleway", Font.BOLD, 20));
        lblgender.setBounds(100,290,200,30);
        add(lblgender);       
        
  
        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(Color.WHITE);
        r1.setBounds(300,290,60,30);
        add(r1);
        
        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(Color.WHITE);
        r2.setBounds(450,290,90,30);
        add(r2);

        ButtonGroup groupgender = new ButtonGroup();
        groupgender.add(r1);
        groupgender.add(r2);
        
        
        lblemail = new JLabel("Email Address:");
        lblemail.setFont(new Font("Raleway", Font.BOLD, 20));
        lblemail.setBounds(100,340,200,30);
        add(lblemail);
        
        
        tfemail = new JTextField();
        tfemail.setFont(new Font("Raleway", Font.BOLD, 14));
        tfemail.setBounds(300,340,400,30);
        add(tfemail);
        
        
        lblmarital = new JLabel("Marital Status:");
        lblmarital.setFont(new Font("Raleway", Font.BOLD, 20));
        lblmarital.setBounds(100,390,200,30);
        add(lblmarital);
       
        r3 = new JRadioButton("Married");
        r3.setFont(new Font("Raleway", Font.BOLD, 14));
        r3.setBackground(Color.WHITE);
        r3.setBounds(300,390,100,30);
        add(r3);
        
        r4 = new JRadioButton("Unmarried");
        r4.setFont(new Font("Raleway", Font.BOLD, 14));
        r4.setBackground(Color.WHITE); 
        r4.setBounds(450,390,100,30);
        add(r4);
        
        r5 = new JRadioButton("Other");
        r5.setFont(new Font("Raleway", Font.BOLD, 14));
        r5.setBackground(Color.WHITE);
        r5.setBounds(635,390,100,30);
        add(r5);
 
        ButtonGroup groupstatus = new ButtonGroup();
        groupstatus.add(r3);
        groupstatus.add(r4);
        groupstatus.add(r5);
           
        lbladdress = new JLabel("Address:");
        lbladdress.setFont(new Font("Raleway", Font.BOLD, 20));
        lbladdress.setBounds(100,440,200,30);
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setFont(new Font("Raleway", Font.BOLD, 14));
        tfaddress.setBounds(300,440,400,30);
        add(tfaddress);
            
        lblcity = new JLabel("City:");
        lblcity.setFont(new Font("Raleway", Font.BOLD, 20));
        lblcity.setBounds(100,490,200,30);
        add(lblcity);
        
        tfcity = new JTextField();
        tfcity.setFont(new Font("Raleway", Font.BOLD, 14)); 
        tfcity.setBounds(300,490,400,30);
        add(tfcity); 
        
        
        
        lblpin = new JLabel("Pin Code:");
        lblpin.setFont(new Font("Raleway", Font.BOLD, 20));
        lblpin.setBounds(100,540,200,30);
        add(lblpin);
        
        
        tfpin = new JTextField(6);
        tfpin.setDocument(new JTextFieldPin(6));
        tfpin.setFont(new Font("Raleway", Font.BOLD, 14));
        tfpin.setBounds(300,540,400,30);
        add(tfpin);
        
        
        
        lblstate = new JLabel("State:");
        lblstate.setFont(new Font("Raleway", Font.BOLD, 20));
        lblstate.setBounds(100,590,200,30);
        add(lblstate);
        
        tfstate = new JTextField();
        tfstate.setFont(new Font("Raleway", Font.BOLD, 14));
        tfstate.setBounds(300,590,400,30);
        add(tfstate);

        b = new JButton("Next");
        b.setFont(new Font("Raleway", Font.BOLD, 14));
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE); 
        b.setBounds(620,660,80,30);
        b.addActionListener(this); 
        add(b);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(1600,900);
        //setLocation(500,120);
        setVisible(true);
  
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        
        try{
        if(ae.getSource()==b){
        String formno = first;
        String name = tfname.getText();
        String fname = tffname.getText();
        
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
      // System.out.println("dob: " + dob);
       
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH);
            Date dateOfBirth = sdf.parse(dob);
            
           // System.out.println("dateOfBirth: " + dateOfBirth);
            
            Calendar dobCal = Calendar.getInstance();
            dobCal.setTime(dateOfBirth);
            
             Calendar minDate = Calendar.getInstance();
            minDate.add(Calendar.YEAR, -18);
       

            
        String gender = null;
        if(r1.isSelected())
        { 
            gender = "Male";
        }
        else if(r2.isSelected()){ 
            gender = "Female";
        }
            
        String email = tfemail.getText();
        String marital = null;
        if(r3.isSelected()){ 
            marital = "Married";
        }else if(r4.isSelected()){ 
            marital = "Unmarried";
        }else if(r5.isSelected()){ 
            marital = "Other";
        }
           
        String address = tfaddress.getText();
        String city = tfcity.getText();
        String pincode = tfpin.getText();
        String state = tfstate.getText();
        
        
        
        Pattern p1 = Pattern.compile("^[a-zA-Z\\s]+$"); //name
        Matcher m1 = p1.matcher( tfname.getText());
        
        Pattern p2 = Pattern.compile("^[a-zA-Z\\s]+$");//fname
        Matcher m2 = p2.matcher( tffname.getText());
        
        Pattern p3 = Pattern.compile("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$");//email check
        Matcher m3 = p3.matcher( tfemail.getText());
        
        Pattern p4 = Pattern.compile("^[a-zA-Z0-9\\s\\-/]+$");// address
        Matcher m4 = p4.matcher( tfaddress.getText());
        
        Pattern p5 = Pattern.compile("^[a-zA-Z\\s]+$");//city cheack
        Matcher m5 = p5.matcher( tfcity.getText());
        
        Pattern p6 = Pattern.compile("^[1-9]{1}[0-9]{2}\\s{0,1}[0-9]{3}$");//pin
        Matcher m6 = p6.matcher( tfpin.getText());
        
           
        Pattern p7 = Pattern.compile("^[a-zA-Z\\s]+$");//State
        Matcher m7 = p7.matcher( tfstate.getText());
        
     
          
          if(name.isEmpty() )
          {
            JOptionPane.showMessageDialog(this, "Please fill your Name");
          }else if (!m1.matches()) {
            JOptionPane.showMessageDialog(null, "Please fill valid user Name");
        } 
         else if( fname.isEmpty()){
              JOptionPane.showMessageDialog(this, "Please fill Father's Name");
          } else if (!m2.matches()) {
            JOptionPane.showMessageDialog(null, "Please fill valid Father's Name");
        
        }
         else if(dob.isEmpty()){
                JOptionPane.showMessageDialog(this, "Please fill your Date of Birth");
          } else if (dobCal.after(minDate)) {
            JOptionPane.showMessageDialog(this, "User must be 18+ of age");
            return;
        }
          
          
         else if(r1.isSelected()== false && r2.isSelected()==false){
                JOptionPane.showMessageDialog(this, "Please select your Gender");
          }
         else if(email.isEmpty()){
                JOptionPane.showMessageDialog(this, "Please fill the Email ");
          } else if (!m3.matches()) {
            JOptionPane.showMessageDialog(null, "Please fill valid Email");
       
        }
          
         else if(r3.isSelected()== false && r4.isSelected()==false && r5.isSelected()==false){
                JOptionPane.showMessageDialog(this, "Please select the Marital Status");
          }
         else if( address.isEmpty()){
              JOptionPane.showMessageDialog(this, "Please fill your address ");
          }  else if (!m4.matches()) {
            JOptionPane.showMessageDialog(null, "Please fill valid Address");
      
        }
         else if( city.isEmpty()){
             JOptionPane.showMessageDialog(this, "Please fill your City");  
          } else if (!m5.matches()) {
            JOptionPane.showMessageDialog(null, "Fill valid city fields");
       
        }
         else if(pincode.isEmpty()){
               JOptionPane.showMessageDialog(this, "Please fill the PinCode");
          }   else if (!m6.matches()) {
            JOptionPane.showMessageDialog(null, "Fill valid pin codefields");
       
        }
         else  if(state.isBlank()){
               JOptionPane.showMessageDialog(this, "Please fill the State ");
         }else  if (!m7.matches()) {
            JOptionPane.showMessageDialog(null, "Fill valid State fields");
         }       
          
          
        
        else{
      
                Conn c1 = new Conn();
                String q1 = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
                c1.s.executeUpdate(q1);
                setVisible(false);
                    new Signup2(first).setVisible(true);
              
          }
        }   
        }catch(Exception e){
             e.printStackTrace();
        }      
        }
    
    public static void main(String[] args){
        new Signup();
    }
}