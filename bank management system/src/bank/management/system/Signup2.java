
package bank.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Signup2 extends JFrame implements ActionListener{
    
    JLabel lblheading,lblreligion,lblcategory,lblincome,lbleducation,lbloccupation,lblpan,lblaadhar,lblsrc,lblexistingacc,lblqualification,lblform,l13;
    JButton btnsubmit;
    JRadioButton r1,r2,r3,r4;
    JTextField tfpan,tfaadhar,t3;
    JComboBox creligion,ccategory,cincome,ceducation,coccupation;
    String formno;
         
    Signup2(String formno){
      
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l14 = new JLabel(i3);
        l14.setBounds(150, 0, 100, 100);
        add(l14);
               
        this.formno = formno;
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
            
        setLayout(null);
        
        lblheading = new JLabel("Page 2: Additonal Details");
        lblheading.setFont(new Font("Raleway", Font.BOLD, 22));
        lblheading.setBounds(280,30,600,40);
        add(lblheading);
        
        lblreligion = new JLabel("Religion:");
        lblreligion.setFont(new Font("Raleway", Font.BOLD, 18));
        lblreligion.setBounds(100,120,100,30);
        add(lblreligion);
       
        String religion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        creligion = new JComboBox(religion);
         creligion.setSelectedItem(null);
        creligion.setBackground(Color.WHITE);
        creligion.setFont(new Font("Raleway", Font.BOLD, 14));
        creligion.setBounds(350,120,320,30);
        add(creligion);
        
        
        lblcategory = new JLabel("Category:");
        lblcategory.setFont(new Font("Raleway", Font.BOLD, 18));
        lblcategory.setBounds(100,170,100,30);
        add(lblcategory);
        
        String category[] = {"General","OBC","SC","ST","Other"};
        ccategory = new JComboBox(category);
        ccategory.setSelectedItem(null);
        ccategory.setBackground(Color.WHITE);
        ccategory.setFont(new Font("Raleway", Font.BOLD, 14));
        ccategory.setBounds(350,170,320,30);
        add(ccategory);
        
        lblincome = new JLabel("Income:");
        lblincome.setFont(new Font("Raleway", Font.BOLD, 18));
        lblincome.setBounds(100,220,100,30);
        add(lblincome); 
        
        
        String income[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};
        cincome = new JComboBox(income);
        cincome.setSelectedItem(null);
        cincome.setBackground(Color.WHITE);
        cincome.setFont(new Font("Raleway", Font.BOLD, 14));
        cincome.setBounds(350,220,320,30);
        add(cincome);
        
        
        lbleducation = new JLabel("Educational");
        lbleducation.setFont(new Font("Raleway", Font.BOLD, 18));
        lbleducation.setBounds(100,270,150,30);
        add(lbleducation);
        
        
        lblqualification = new JLabel("Qualification:");
        lblqualification.setFont(new Font("Raleway", Font.BOLD, 18));
        lblqualification.setBounds(100,290,150,30);
        add(lblqualification);
        
        
        String education[] = {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
        ceducation = new JComboBox(education);
        ceducation.setSelectedItem(null);
        ceducation.setBackground(Color.WHITE);
        ceducation.setFont(new Font("Raleway", Font.BOLD, 14));
        ceducation.setBounds(350,270,320,30);
        add(ceducation);
        
        lbloccupation = new JLabel("Occupation:");
        lbloccupation.setFont(new Font("Raleway", Font.BOLD, 18));
        lbloccupation.setBounds(100,340,150,30);
        add(lbloccupation);
        
        
        String occupation[] = {"Salaried","Self-Employmed","Business","Student","Retired","Others"};
        coccupation = new JComboBox(occupation);
        coccupation.setSelectedItem(null);
        coccupation.setBackground(Color.WHITE);
        coccupation.setFont(new Font("Raleway", Font.BOLD, 14));
        coccupation.setBounds(350,340,320,30);
        add(coccupation);
        
        
        lblpan = new JLabel("PAN Number:");
        lblpan.setFont(new Font("Raleway", Font.BOLD, 18));
        lblpan.setBounds(100,390,150,30);
        add(lblpan);  
        
        tfpan = new JTextField(10);
        tfpan.setDocument(new JTextFieldPan(10));
        tfpan.setFont(new Font("Raleway", Font.BOLD, 14));
        tfpan.setBounds(350,390,320,30);
        add(tfpan);
        
        
        lblaadhar = new JLabel("Aadhar Number:");
        lblaadhar.setFont(new Font("Raleway", Font.BOLD, 18));
        lblaadhar.setBounds(100,440,180,30);
        add(lblaadhar);  
        
        
        tfaadhar = new JTextField(12);
        tfaadhar.setDocument(new JTextFieldAadhar(12));
        tfaadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        tfaadhar.setBounds(350,440,320,30);
        add(tfaadhar);
        
        
        lblsrc = new JLabel("Senior Citizen:");
        lblsrc.setFont(new Font("Raleway", Font.BOLD, 18));
        lblsrc.setBounds(100,490,150,30);
        add(lblsrc);
       
        
        r1 = new JRadioButton("Yes");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(Color.WHITE);  
        r1.setBounds(350,490,100,30);
        add(r1);
        
        
        r2 = new JRadioButton("No");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(Color.WHITE);
        r2.setBounds(460,490,100,30);
        add(r2);
        
        ButtonGroup groupstatus = new ButtonGroup();
        groupstatus.add(r1);
        groupstatus.add(r2);
        
        
        lblexistingacc = new JLabel("Existing Account:");
        lblexistingacc.setFont(new Font("Raleway", Font.BOLD, 18));
        lblexistingacc.setBounds(100,540,180,30);
        add(lblexistingacc);
        
        r3 = new JRadioButton("Yes");
        r3.setFont(new Font("Raleway", Font.BOLD, 14));
        r3.setBackground(Color.WHITE);
        r3.setBounds(350,540,100,30);
        add(r3);
        
        r4 = new JRadioButton("No");
        r4.setFont(new Font("Raleway", Font.BOLD, 14));
        r4.setBackground(Color.WHITE);
        r4.setBounds(460,540,100,30);
        add(r4);
      
          ButtonGroup groupstatus1 = new ButtonGroup();
        groupstatus1.add(r3);
        groupstatus1.add(r4);
        
        lblform = new JLabel("Form No:");
        lblform.setFont(new Font("Raleway", Font.BOLD, 13));
        lblform.setBounds(700,10,60,30);
        add(lblform);
        
        l13 = new JLabel(formno);
        l13.setFont(new Font("Raleway", Font.BOLD, 13));      
        l13.setBounds(760,10,60,30);
        add(l13);
        
        btnsubmit = new JButton("Next");
        btnsubmit.setFont(new Font("Raleway", Font.BOLD, 14));
        btnsubmit.setBackground(Color.BLACK);
        btnsubmit.setForeground(Color.WHITE);
        btnsubmit.setBounds(570,640,100,30);
        btnsubmit.addActionListener(this);
        add(btnsubmit);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,750);
        setLocation(500,120);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==btnsubmit){
        try{
        String religion = (String)creligion.getSelectedItem(); 
        String category = (String)ccategory.getSelectedItem();
        String income = (String)cincome.getSelectedItem();
        String education = (String)ceducation.getSelectedItem();
        String occupation = (String)coccupation.getSelectedItem();
        
        String pan = tfpan.getText();
        String aadhar = tfaadhar.getText();
        
        String scitizen = "";
        if(r1.isSelected()){ 
            scitizen = "Yes";
        }
        else if(r2.isSelected()){ 
            scitizen = "No";
        }
           
        String eaccount = "";
        if(r3.isSelected()){ 
            eaccount = "Yes";
        }else if(r4.isSelected()){ 
            eaccount = "No";
        }
        
        Pattern p1 = Pattern.compile("[A-Z]{5}[0-9]{4}[A-Z]{1}");// Pan card 
        Matcher m1 = p1.matcher( tfpan.getText());
        
        Pattern p2 = Pattern.compile("^[2-9]{1}[0-9]{3}[0-9]{4}[0-9]{4}$");//aadhar card
        Matcher m2 = p2.matcher( tfaadhar.getText());
        
        if(religion==null){
          JOptionPane.showMessageDialog(this, "Please select your Religion");  
        } 
        else if(category==null){
          JOptionPane.showMessageDialog(this, "Please select your Category");  
        } 
        else if(income==null){
          JOptionPane.showMessageDialog(this, "Please select your Income");  
        } 
        else if(education==null){
          JOptionPane.showMessageDialog(this, "Please select your education");  
        }
        else if(occupation==null){
          JOptionPane.showMessageDialog(this, "Please select your occupation");  
        }
        else if(pan.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please fill PAN Number");
        }else if(!m1.matches()){
             JOptionPane.showMessageDialog(null, "Please fill valid PAN Number");
        }
        else if(aadhar.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please fill Aadhar Number");
        }else if (!m2.matches()) {
            JOptionPane.showMessageDialog(null, "Please fill valid Aadhar Number");
        
        }
        else if(r1.isSelected()==false && r2.isSelected()==false){
            JOptionPane.showMessageDialog(this, "Please select the Senior Citizen or Not ");
        }
        else if(r3.isSelected()==false && r4.isSelected()==false){
            JOptionPane.showMessageDialog(this, "Please select the Existing Account or Not");
        }
           
        else{
                Conn c1 = new Conn();
                String q1 = "insert into signuptwo values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+aadhar+"','"+scitizen+"','"+eaccount+"')";
                c1.s.executeUpdate(q1);
                
                new Signup3(formno).setVisible(true);
                setVisible(false);
            }
        
        }catch(Exception ex){
             ex.printStackTrace();
        }               
    }
    }
    public static void main(String[] args){
        new Signup2("").setVisible(true);
    }
}