import java.awt.Color;
import java.awt.Font;
import java.util.*;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{

    long random;
    JTextField nameTextField,fnameTextField,dobTextField,EmailTextField,addressTextField,CityTextField,StateTextField,PinTextField;
    JButton next;
    JRadioButton male,female, Others,married,unmarried;
    JDateChooser dateChooser;

    SignupOne(){
        Random ran=new Random();
        random=Math.abs((ran.nextLong() % 9000L) + 1000L);

        setLayout(null);

        JLabel formno=new JLabel("APPLICATION FORM NO ." + random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);

        JLabel personDetails=new JLabel(" Page 1: Personal Details." );
        personDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personDetails.setBounds(290,80,400,30);
        add(personDetails);

        JLabel name=new JLabel(" Name: " );
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);

        nameTextField=new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD,14));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);

        JLabel fname=new JLabel(" Father's Name: " );
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);

        fnameTextField=new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD,14));
        fnameTextField.setBounds(300,190,400,30);
        add(fnameTextField);


        JLabel dob=new JLabel(" Date of Birth : " );
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);

        dateChooser=new JDateChooser();
        dateChooser.setBounds(300,240,200,30);
        dateChooser.setForeground(Color.RED);
        add(dateChooser);

        JLabel Gender=new JLabel(" Gender: " );
        Gender.setFont(new Font("Raleway", Font.BOLD,20));
        Gender.setBounds(100,290,200,30);
        add(Gender);

        male=new JRadioButton("Male");
        male.setBounds(300, 290, 60, 30);
        male.setBackground(Color.WHITE);
        add(male);

        female=new JRadioButton("Female");
        female.setBounds(450, 290, 120, 30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup genderGroup=new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel Email=new JLabel(" Email Address: " );
        Email.setFont(new Font("Raleway",Font.BOLD,20));
        Email.setBounds(100,340,200,30);
        add(Email);

        EmailTextField=new JTextField();
        EmailTextField.setFont(new Font("Raleway", Font.BOLD,14));
        EmailTextField.setBounds(300,340,400,30);
        add(EmailTextField);


        JLabel marital=new JLabel(" Marital Status: " );
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,390,200,30);
        add(marital);

        married=new JRadioButton("Married");
        married.setBounds(300, 390, 100, 30);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried=new JRadioButton("UnMarried");
        unmarried.setBounds(450, 390, 100, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        Others=new JRadioButton("Other");
        Others.setBounds(630, 390, 100, 30);
        Others.setBackground(Color.WHITE);
        add(Others);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(Others);

        JLabel address=new JLabel(" Address: " );
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);

        addressTextField=new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD,14));
        addressTextField.setBounds(300,440,400,30);
        add(addressTextField);

        JLabel City=new JLabel(" City: " );
        City.setFont(new Font("Raleway",Font.BOLD,20));
        City.setBounds(100,490,200,30);
        add(City);

        CityTextField=new JTextField();
        CityTextField.setFont(new Font("Raleway", Font.BOLD,14));
        CityTextField.setBounds(300,490,400,30);
        add(CityTextField);

        JLabel State=new JLabel(" State: " );
        State.setFont(new Font("Raleway",Font.BOLD,20));
        State.setBounds(100,540,200,30);
        add(State);

        StateTextField=new JTextField();
        StateTextField.setFont(new Font("Raleway", Font.BOLD,14));
        StateTextField.setBounds(300,540,400,30);
        add(StateTextField);

        JLabel Pincode=new JLabel(" Pincode: " );
        Pincode.setFont(new Font("Raleway",Font.BOLD,20));
        Pincode.setBounds(100,590,200,30);
        add(Pincode);

        PinTextField=new JTextField();
        PinTextField.setFont(new Font("Raleway", Font.BOLD,14));
        PinTextField.setBounds(300,590,400,30);
        add(PinTextField);


        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850,800);
        setLocation(350,10);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        String formno=String.valueOf(random);  //long
        String name=nameTextField.getText();//Set Text
      //  String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();

        String gender=null;
        if(male.isSelected()){
            gender="Male";

        }else if(female.isSelected()){
            gender="Female";
        }

        String Email=EmailTextField.getText();

        String marital=null;
        if(married.isSelected()){
            marital="Married";

        }else if(unmarried.isSelected()){
            marital="Unmarried";
        }else if(Others.isSelected()){
            marital="Other";
        }

        String fname = fnameTextField.getText();
        String address=addressTextField.getText();
        String city=CityTextField.getText() ;
        String state=StateTextField.getText();
        String pin=PinTextField.getText();
        String dob=PinTextField.getText();

        try{

            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is Required");
            }else{
                Conn c = new Conn();
                String query="INSERT INTO signups VALUES('"+formno+"','"+name+"','"+fname+"','"+gender+"','"+Email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);
        }

}

   //    "String'"+variable+"'String"

    public static void main(String args[]){

        new SignupOne();

    }
}