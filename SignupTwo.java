import java.awt.Color;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{


    JTextField pan, aadhar;
    JButton next;
    JRadioButton Syes, Sno, eyes, eno;
    JComboBox religion, category, occupation, education, income;

    String formno;

    SignupTwo(String formno){
        this.formno=formno;

        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2 ");



        JLabel additionalDetails=new JLabel(" Page 2: Additonal Details." );
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);

        JLabel name=new JLabel(" Religion: " );
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);

        String valReligion[]={"Hindu","Muslim","Sikh","Christian","Other"};
        religion=new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);

         
        
        JLabel fname=new JLabel(" Category: " );
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);

        String valCategory[]={"General","OBC","SC","ST","Other"};
        category=new JComboBox(valCategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);

    
        JLabel dob=new JLabel(" Income : " );
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);

        String incomeCategory[]={"Null"," < 1,50,000 "," < 2,50,000 ","< 5,00,000","Upto 10,00,00"};
        income=new JComboBox(incomeCategory);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);

       

        JLabel Education=new JLabel(" Educational " );
        Education.setFont(new Font("Raleway", Font.BOLD,20));
        Education.setBounds(100,290,200,30);
        add(Education);




        JLabel Qualification=new JLabel(" Qualification : " );
        Qualification.setFont(new Font("Raleway",Font.BOLD,20));
        Qualification.setBounds(100,315,200,30);
        add(Qualification);


        

        String educationValues[]={"Non Graduate"," Graduate "," Post Graduation ","Doctrate","Others"};
        education=new JComboBox(educationValues);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.WHITE);
        add(education);


        JLabel Occupation=new JLabel(" Occuaption : " );
        Occupation.setFont(new Font("Raleway",Font.BOLD,20));
        Occupation.setBounds(100,390,200,30);
        add(Occupation);

        
        String occupationValues[]={"Salaried"," Self Employed "," Business  ","Student","Retired","Others"};
        occupation=new JComboBox(occupationValues);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        


        JLabel PAN=new JLabel(" PAN Number.: " );
        PAN.setFont(new Font("Raleway",Font.BOLD,20));
        PAN.setBounds(100,440,200,30);
        add(PAN);

        pan=new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD,14));
        pan.setBounds(300,440,400,30);
        add(pan);

        JLabel Adhar=new JLabel(" Aadhar Number: " );
        Adhar.setFont(new Font("Raleway",Font.BOLD,20));
        Adhar.setBounds(100,490,200,30);
        add(Adhar);

        aadhar=new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD,14));
        aadhar.setBounds(300,490,400,30);
        add(aadhar);

        JLabel State=new JLabel(" Senior Citizens: " );
        State.setFont(new Font("Raleway",Font.BOLD,20));
        State.setBounds(100,540,200,30);
        add(State);

        Syes=new JRadioButton("yes");
        Syes.setBounds(300, 540, 100, 30);
        Syes.setBackground(Color.WHITE);
        add(Syes);

        Sno=new JRadioButton("No");
        Sno.setBounds(450, 540, 100, 30);
        Sno.setBackground(Color.WHITE);
        add(Sno);


        ButtonGroup sGroup = new ButtonGroup();
        sGroup.add(Syes);
        sGroup.add(Sno);
        
        JLabel Pincode=new JLabel(" Existing Account: " );
        Pincode.setFont(new Font("Raleway",Font.BOLD,20));
        Pincode.setBounds(100,590,200,30);
        add(Pincode);

        
        eyes=new JRadioButton("yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno=new JRadioButton("No");
        eno.setBounds(450, 590, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);


        ButtonGroup eGroup = new ButtonGroup();
        eGroup.add(eyes);
        eGroup.add(eno);
        


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
        String sreligion=(String) religion.getSelectedItem();
        String scategory=(String) category.getSelectedItem();
        String sincome=(String)   income.getSelectedItem();
        String seducation=(String) education.getSelectedItem();  
        String soccupation=(String) occupation.getSelectedItem();  
        String seniorcitizen=null;
        if(Syes.isSelected()){
            seniorcitizen="Yes";

        }else if(Sno.isSelected()){
            seniorcitizen="No";
        }


        String existingaccount=null;
        if(eyes.isSelected()){
            existingaccount="Yes";

        }else if(eno.isSelected()){
            existingaccount="Unmarried";
        }

        String span = pan.getText();
        String saadhar=aadhar.getText();
     
        try{
                Conn c = new Conn();
                String query="INSERT INTO signuptwo VALUES('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingaccount+"')"; 
                c.s.executeUpdate(query);
            

                //Signup3 Object
                setVisible(false);
                new SignupThree(formno).setVisible(true);
        }catch(Exception e){
            System.out.println(e);
        }

}

   //    "String'"+variable+"'String"

    public static void main(String args[]){

        new SignupTwo("");

    }
}
