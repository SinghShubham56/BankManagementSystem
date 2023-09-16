
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.*;

public class FastCash extends JFrame implements ActionListener{

    JButton amount1,amount2,amount3,amount4,amount5,amount6,back;
    String pinnumber;
  

    FastCash(String pinnumber){
          this.pinnumber=pinnumber;

        setLayout(null);


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text=new JLabel("SELECT WITHDRAW AMOUNT");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        amount1=new JButton("Rs 100");
        amount1.setBounds(170,415,150,30);
        amount1.addActionListener(this);
        image.add(amount1);
  
        amount2=new JButton("Rs 500");
        amount2.setBounds(355,415,150,30);
        amount2.addActionListener(this);
        image.add(amount2);

        amount3=new JButton("Rs 1000");
        amount3.setBounds(170,450,150,30);
        amount3.addActionListener(this);
        image.add(amount3);

        amount4=new JButton("RS 2000");
        amount4.setBounds(355,450,150,30);
        amount4.addActionListener(this);
        image.add(amount4);
    
        amount5=new JButton("Rs 5000");
        amount5.setBounds(355,450,150,30);
        amount5.addActionListener(this);
        image.add(amount5);
    


        amount6=new JButton("Rs 10000");
        amount6.setBounds(355,485,150,30);
        amount6.addActionListener(this);
        image.add(amount6);


        back=new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
  




        setSize(900,900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
       


    }

    public void actionPerformed(ActionEvent ae){
    
        if(ae.getSource()==back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }else {
          String amount=((JButton)ae.getSource()).getText().substring(3);  //Rs 500
          System.out.println("This is the chosen amount " + amount);
          Conn c=new Conn();
          try{
            ResultSet rs=c.s.executeQuery("Select * from bank where pin='"+pinnumber+"'");
            int balance=0;
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance+=Integer.parseInt(rs.getString("amount"));
                    System.out.println(balance);
                }else{
                    balance-=Integer.parseInt(rs.getString("amount"));
                    System.out.println(balance);
                }
            }

            if (ae.getSource() !=back && balance < Integer.parseInt(amount)){
             JOptionPane.showMessageDialog(null,"Insufficient Balance");
             return;
            }

            Date date=new Date();
            String query="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog( null,"Rs"+amount+"Debited Successfully");

            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
          }catch(Exception e){
            System.out.println(e);
          }
        }

    }
    public static void main(String[] args) {
         new FastCash("");
        
    }
    
}
