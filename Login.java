import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login,SignUp,Clear;
    JTextField cardTextField;
    JPasswordField pinTextField;


    Login(){

        setTitle("AUTOMATED TELLER MACHINE");

        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);
       
        // set label for Heading of Welcome to ATM
        JLabel text=new JLabel("Welcome to ATM ");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);

        // set label for Card no.
        JLabel Cardno=new JLabel("Card No: ");
        Cardno.setFont(new Font("Raleway",Font.BOLD,28));
        Cardno.setBounds(120,150,150,40);
        add(Cardno);
        
        //to add textField for Card no.
        cardTextField=new JTextField();
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);

        // set label for pin
        JLabel pin =new JLabel("Pin:");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120,220,250,30);
        add(pin);
        //to add Textfield for Pin
        pinTextField=new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);


        //to add login button
        login=new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        //to add Clear button
        Clear=new JButton("CLEAR");
        Clear.setBounds(430, 300, 100, 30);
        Clear.setBackground(Color.BLACK);
        Clear.setForeground(Color.WHITE);
        Clear.addActionListener(this);
        add(Clear);

        SignUp=new JButton("SIGN UP");
        SignUp.setBounds(300, 350, 230, 30);
        SignUp.setBackground(Color.BLACK);
        SignUp.setForeground(Color.WHITE);
        SignUp.addActionListener(this);
        add(SignUp);



        getContentPane().setBackground(Color.WHITE);


        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);


    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==Clear){

            cardTextField.setText("");
            pinTextField.setText("");
}
else if( ae.getSource()==login){
    Conn conn=new Conn();
    String cardnumber=cardTextField.getText();
    String pinnumber=pinTextField.getText();  //pinnumber is a password field not a textfield that's why it get line over the getText
    String query="Select * from login where cardnumber='"+cardnumber+"' and pinnumber='"+pinnumber+"'";
    try{
       ResultSet rs=conn.s.executeQuery(query);
     if(rs.next()){
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);

     }
     else {
        JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
     }

    }
    catch(Exception e){
        System.out.println(e);
    }
}else if(ae.getSource()==SignUp){
   setVisible(false);
   new SignupOne().setVisible(true);
}

    }

    public static void main(String[] args) {
    new Login();
        


    }
    
}
