/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myproject;

/**
 *
 * @author Asus
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{

    JButton login, cancel;
    JTextField tfusername, tfpassword;
    
    Login () {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 40, 100, 40);
        add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(150, 40, 150, 30);
        add(tfusername);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 90, 100, 40);
        add(lblpassword);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(150, 90, 150, 30);
        add(tfpassword);
        
        login = new JButton("Login");
        login.setBounds(40, 160, 120,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(login);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(180, 160, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/log.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 3, 200, 200);
        add(image);
        
        setSize(600, 300);
        setLocation(500, 250);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
        String username = tfusername.getText();
         String password = tfpassword.getText();
         String q = "Select * from login where username = '"+ username + "' and password = '"+password+"'";
         try{
           conn c = new conn();
           ResultSet rs = c.s.executeQuery(q);
           if(rs.next()){
               setVisible(true);
               new Project();
               setVisible(false);
               
           }else{
               JOptionPane.showMessageDialog(null,"Invalid userr name and password");
           }
           c.s.close();
         }catch(Exception e){
             e.printStackTrace();
         }
        
        }
        else if(ae.getSource()==cancel){
              setVisible(false);  
        }}

    public static void main(String[] args) {
        new Login();
    }
}