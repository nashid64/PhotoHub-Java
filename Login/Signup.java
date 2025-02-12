
package Login;

import java.awt.*;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.awt.Font;
import javax.swing.*;

import User.Photographer;
import User.Customer;

public class Signup implements ActionListener {
  Photographer[] photographer = new Photographer[100];
  Customer[] customers = new Customer[100];

  JFrame signupFrame;
  JPanel signupPanel, customerSignUp, photographersSignUp, signupComplete;
  JLabel l1, l2, l3, l4, l19, poster1, poster2, poster3, poster4;
  JLabel l5, l6, l7, l8, l9, l10, l11, l12, l13, l20;
  JLabel l14, l15, l16, l17, l18;
  JTextField tf1, tf2, tf3;
  JTextField tf4, tf5, tf6, tf7, tf8, tf9;
  JPasswordField cp1, ccp1;
  JPasswordField dp1, dcp1;
  JButton driSignUp, cusSignUp, returnToLogin, returnToSignup, signUp1, signUp2;
  JComboBox<String> experience, carType;
  String[] PhotographyTypes = {"Fine-art photography", " Portrait Photography", "Fashion Photography", "Landscape Photography", "Product Photography", " Wedding Photography", "FILIM","Sports Photography" };
  String[] PhotographyExperience = { "1-3 years", "2-5 years", "5-10 years", "10-15 years" };

  public Signup() {
    signupFrame = new JFrame();
    // main signup panel
    signupPanel = new JPanel();

    l14 = new JLabel("Sign up on FOTOHUB");
    l14.setBounds(300, 100, 400, 80);
    Font bigFont = l14.getFont().deriveFont(Font.PLAIN, 30f);
    l14.setFont(bigFont);
    l14.setForeground(Color.WHITE);

    l15 = new JLabel("Sign-up and become a part of our journey!");
    l15.setBounds(300, 150, 500, 80);
	l15.setForeground(Color.WHITE);

   

    cusSignUp = new JButton("Sign-up as Client");
    cusSignUp.setBounds(300, 400, 200, 30);
    cusSignUp.addActionListener(this);
    cusSignUp.setOpaque(true);
    cusSignUp.setContentAreaFilled(true);
    cusSignUp.setBackground(Color.GREEN);
    cusSignUp.setBorderPainted(true);
    cusSignUp.setForeground(Color.BLACK);

    driSignUp = new JButton("Sign-up as photographer");
    driSignUp.setBounds(300, 450, 200, 30);
    driSignUp.addActionListener(this);
    driSignUp.setOpaque(true);
    driSignUp.setContentAreaFilled(true);
    driSignUp.setBackground(Color.GREEN);
    driSignUp.setBorderPainted(true);
    driSignUp.setForeground(Color.BLACK);

    ImageIcon image1 = new ImageIcon("Images/1.png");
    poster1 = new JLabel(image1);
    poster1.setBounds(0, 0, 1100, 700);

    signupPanel.add(l14);
    signupPanel.add(l15);
    // signupPanel.add(l16);
    // signupPanel.add(l17);
    signupPanel.add(cusSignUp);
    signupPanel.add(driSignUp);
    signupPanel.add(poster1);
    signupPanel.setLayout(null);
    signupPanel.setBounds(0, 0, 1100, 700);
    signupPanel.setVisible(true);

    // customer signup panel;

    customerSignUp = new JPanel();

    l1 = new JLabel("Name:");
    l1.setBounds(300, 180, 150, 40);
    Font midFont = l1.getFont().deriveFont(Font.PLAIN, 23f);
    l1.setFont(midFont);
	l1.setForeground(Color.WHITE);

    l2 = new JLabel("Phone Number:");
    l2.setBounds(300, 250, 300, 40);
    l2.setFont(midFont);
	l2.setForeground(Color.WHITE);

    l3 = new JLabel("E-mail Address: ");
    l3.setBounds(300, 300, 400, 80);
    l3.setFont(midFont);
	l3.setForeground(Color.WHITE);

    l4 = new JLabel("Password:");
    l4.setBounds(300, 350, 400, 80);
    l4.setFont(midFont);
	l4.setForeground(Color.WHITE);

    l19 = new JLabel("Confirm Password:");
    l19.setBounds(300, 400, 400, 80);
    l19.setFont(midFont);
	l19.setForeground(Color.WHITE);

    tf1 = new JTextField("", 2);
    tf1.setBounds(500, 183, 220, 32);
    tf1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GREEN));
    tf1.setFont(midFont);
    tf1.setOpaque(false);
	tf1.setForeground(Color.WHITE);

    tf2 = new JTextField("", 2);
    tf2.setBounds(500, 252, 220, 32);
    tf2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GREEN));
    tf2.setFont(midFont);
    tf2.setOpaque(false);
	tf2.setForeground(Color.WHITE);
	

    tf3 = new JTextField("", 2);
    tf3.setBounds(500, 318, 220, 32);
    tf3.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GREEN));
    tf3.setFont(midFont);
    tf3.setOpaque(false);
	tf3.setForeground(Color.WHITE);

    cp1 = new JPasswordField("", 2);
    cp1.setBounds(500, 375, 220, 32);
    cp1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GREEN));
    cp1.setFont(midFont);
    cp1.setOpaque(false);
	cp1.setForeground(Color.WHITE);

    ccp1 = new JPasswordField("", 2);
    ccp1.setBounds(500, 423, 220, 32);
    ccp1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GREEN));
    ccp1.setFont(midFont);
    ccp1.setOpaque(false);
	ccp1.setForeground(Color.WHITE);

    signUp1 = new JButton("Sign-up");
    signUp1.setBounds(440, 480, 150, 30);
    signUp1.addActionListener(this);
    signUp1.setOpaque(true);
    signUp1.setContentAreaFilled(true);
    signUp1.setBackground(Color.GREEN);
    signUp1.setBorderPainted(true);
    signUp1.setForeground(Color.BLACK);

    ImageIcon image2 = new ImageIcon("Images/2.png");
    poster2 = new JLabel(image2);
    poster2.setBounds(0, 0, 1100, 700);

    customerSignUp.add(l1);
    customerSignUp.add(l2);
    customerSignUp.add(l3);
    customerSignUp.add(l4);
    customerSignUp.add(l19);
    customerSignUp.add(tf1);
    customerSignUp.add(tf2);
    customerSignUp.add(tf3);
    customerSignUp.add(cp1);
    customerSignUp.add(ccp1);
    customerSignUp.add(signUp1);
    customerSignUp.add(poster2);
    customerSignUp.setLayout(null);
    customerSignUp.setBounds(0, 0, 1100, 700);
    customerSignUp.setVisible(false);

    // driver sign up panel

    photographersSignUp = new JPanel();

    l5 = new JLabel("Name:");
    l5.setBounds(150, 70, 150, 40);
    l5.setFont(midFont);
	l5.setForeground(Color.WHITE);

    l6 = new JLabel("Phone Number:");
    l6.setBounds(150, 120, 200, 40);
    l6.setFont(midFont);
	l6.setForeground(Color.WHITE);
   

    l7 = new JLabel("E-mail Address: ");
    l7.setBounds(150, 170, 200, 40);
    l7.setFont(midFont);
	l7.setForeground(Color.WHITE);

    l8 = new JLabel("NID Number:");
    l8.setBounds(150, 220, 150, 40);
    l8.setFont(midFont);
	l8.setForeground(Color.WHITE);

    l9 = new JLabel("License No:");
    l9.setBounds(150, 270, 200, 40);
    l9.setFont(midFont);
	l9.setForeground(Color.WHITE);

    l10 = new JLabel("Select Years of experience:");
    l10.setBounds(150, 320, 300, 40);
    l10.setFont(midFont);
	l10.setForeground(Color.WHITE);

    l11 = new JLabel("Preferred photography type:");
    l11.setBounds(150, 370, 300, 40);
    l11.setFont(midFont);
	l11.setForeground(Color.WHITE);

    l12 = new JLabel("Enter your hourly rate:");
    l12.setBounds(150, 420, 250, 40);
    l12.setFont(midFont);
	l12.setForeground(Color.WHITE);

    l13 = new JLabel("Password:");
    l13.setBounds(150, 470, 150, 40);
    l13.setFont(midFont);
	l13.setForeground(Color.WHITE);

    l20 = new JLabel("Confirm Password:");
    l20.setBounds(150, 520, 200, 40);
    l20.setFont(midFont);
	l20.setForeground(Color.WHITE);

    tf4 = new JTextField();
    tf4.setBounds(430, 75, 220, 32);
    tf4.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GREEN));
    tf4.setFont(midFont);
    tf4.setOpaque(false);
	tf4.setForeground(Color.WHITE);

    tf5 = new JTextField();
    tf5.setBounds(430, 130, 220, 32);
    tf5.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GREEN));
    tf5.setFont(midFont);
    tf5.setOpaque(false);
	tf5.setForeground(Color.WHITE);

    tf6 = new JTextField();
    tf6.setBounds(430, 180, 220, 32);
    tf6.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GREEN));
    tf6.setFont(midFont);
    tf6.setOpaque(false);
	tf6.setForeground(Color.WHITE);

    tf7 = new JTextField();
    tf7.setBounds(430, 228, 220, 32);
    tf7.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GREEN));
    tf7.setFont(midFont);
    tf7.setOpaque(false);
	tf7.setForeground(Color.WHITE);

    tf8 = new JTextField();
    tf8.setBounds(430, 277, 220, 32);
    tf8.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GREEN));
    tf8.setFont(midFont);
    tf8.setOpaque(false);
	tf8.setForeground(Color.WHITE);

    tf9 = new JTextField();
    tf9.setBounds(430, 427, 220, 32);
    tf9.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GREEN));
    tf9.setFont(midFont);
    tf9.setOpaque(false);
	tf9.setForeground(Color.WHITE);

    dp1 = new JPasswordField("", 2);
    dp1.setBounds(430, 475, 180, 32);
    dp1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GREEN));
    dp1.setFont(midFont);
    dp1.setOpaque(false);
	dp1.setForeground(Color.WHITE);

    dcp1 = new JPasswordField("", 2);
    dcp1.setBounds(430, 525, 180, 32);
    dcp1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GREEN));
    dcp1.setFont(midFont);
    dcp1.setOpaque(false);
	dcp1.setForeground(Color.WHITE);

    carType = new JComboBox<>(PhotographyTypes);
    carType.setBounds(460, 380, 140, 20);

    experience = new JComboBox<>(PhotographyExperience);
    experience.setBounds(460, 330, 140, 20);

    signUp2 = new JButton("Sign-up");
    signUp2.setBounds(250, 600, 150, 30);
    signUp2.addActionListener(this);
    signUp2.setOpaque(true);
    signUp2.setContentAreaFilled(true);
    signUp2.setBackground(Color.GREEN);
    signUp2.setBorderPainted(true);
    signUp2.setForeground(Color.BLACK);

    ImageIcon image3 = new ImageIcon("Images/3.png");
    poster3 = new JLabel(image3);
    poster3.setBounds(0, 0, 1100, 700);

    photographersSignUp.add(l5);
    photographersSignUp.add(l6);
    photographersSignUp.add(l7);
    photographersSignUp.add(l8);
    photographersSignUp.add(l9);
    photographersSignUp.add(l10);
    photographersSignUp.add(l11);
    photographersSignUp.add(l12);
    photographersSignUp.add(l13);
    photographersSignUp.add(l20);
    photographersSignUp.add(tf4);
    photographersSignUp.add(tf5);
    photographersSignUp.add(tf6);
    photographersSignUp.add(tf7);
    photographersSignUp.add(tf8);
    photographersSignUp.add(tf9);
    photographersSignUp.add(dp1);
    photographersSignUp.add(dcp1);
    photographersSignUp.add(carType);
    photographersSignUp.add(experience);
    photographersSignUp.add(signUp2);
    photographersSignUp.add(poster3);
    photographersSignUp.setLayout(null);
    photographersSignUp.setBounds(0, 0, 1100, 700);
    photographersSignUp.setVisible(false);

    // signup complete panel

    signupComplete = new JPanel();

    l14 = new JLabel("Account has been successfully created!");
    l14.setBounds(280, 100, 600, 80);
    l14.setFont(bigFont);
	l14.setForeground(Color.WHITE);

    returnToLogin = new JButton("Go back to Log-in page");
    returnToLogin.setBounds(340, 300, 200, 30);
    returnToLogin.addActionListener(this);
    returnToLogin.setOpaque(true);
    returnToLogin.setContentAreaFilled(true);
    returnToLogin.setBackground(Color.RED);
    returnToLogin.setBorderPainted(true);
    returnToLogin.setForeground(Color.BLACK);

    returnToSignup = new JButton("Go back to Sign-up page");
    returnToSignup.setBounds(340, 380, 200, 30);
    returnToSignup.addActionListener(this);
    returnToSignup.setOpaque(true);
    returnToSignup.setContentAreaFilled(true);
    returnToSignup.setBackground(Color.RED);
    returnToSignup.setBorderPainted(true);
    returnToSignup.setForeground(Color.BLACK);

    ImageIcon image4 = new ImageIcon("Images/4.png");
    poster4 = new JLabel(image4);
    poster4.setBounds(0, 0, 1100, 700);

    signupComplete.add(l14);
    signupComplete.add(returnToLogin);
    signupComplete.add(returnToSignup);
    signupComplete.add(poster4);
    signupComplete.setLayout(null);
    signupComplete.setBounds(0, 0, 1100, 700);
    signupComplete.setVisible(false);

    signupFrame.add(signupPanel);
    signupFrame.add(customerSignUp);
    signupFrame.add(photographersSignUp);
    signupFrame.add(signupComplete);
    signupFrame.setLayout(null);
    signupFrame.setBounds(0, 0, 1100, 700);
    signupFrame.setLocationRelativeTo(null);
    signupFrame.setVisible(true);

  }

  public void addCustomer(Customer c)// function for adding an account to the array
  {
    int count = 0;

    for (int i = 0; i < customers.length; i++) {
      if (customers[i] == null) {
        customers[i] = c;
        count++;
        this.customers = customers;
        break;
      }
    }
    if (count == 0) {
      System.out.println("Customer Account not added");
    } else {
      System.out.println("Customer Account added");
    }
  }

  public Customer[] getCus() {

    return customers;

  }

  public void addPhotographer(Photographer d)// function for adding an account to the array
  {
    int count = 0;

    for (int i = 0; i < photographer.length; i++) {
      if (photographer[i] == null) {
        photographer[i] = d;
        count++;
        this.photographer = photographer;
        break;
      }
    }
    if (count == 0) {
      System.out.println("Photographer Account not added");
    } else {
      System.out.println("Photographer Account added");
    }
  }

  public Photographer[] getPhotographer() {

    return photographer;

  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == cusSignUp) {
      signupPanel.setVisible(false);
      customerSignUp.setVisible(true);

    }

    if (e.getSource() == driSignUp) {
      signupPanel.setVisible(false);
      photographersSignUp.setVisible(true);

    }

    if (e.getSource() == signUp1) {
      String cname = tf1.getText();
      String cphoneNo = tf2.getText();
      String cemail = tf3.getText();
      String cpass = cp1.getText();
      String cconfPass = ccp1.getText();

      if (cname.length() >= 3 && cphoneNo.length() >= 3 && cemail.length() >= 3 && cpass.equals(cconfPass)) {
        try {
          Customer c = new Customer(cname, cphoneNo, cemail, cpass);
          addCustomer(c);
          customerSignUp.setVisible(false);
          signupComplete.setVisible(true);
          System.out.println("Cuszzz addedd");
          File file = new File(".\\Data\\customers.txt");
          if (!file.exists()) {
            file.createNewFile();
          }
          FileWriter fw = new FileWriter(file, true);
          BufferedWriter bw = new BufferedWriter(fw);
          PrintWriter pw = new PrintWriter(bw);

          pw.println("User Name : " + cname);
          pw.println("Password : " + cpass);
          pw.println("Phone : " + cphoneNo);

          pw.close();

        } catch (Exception ex) {
          System.out.print(ex);
        }

      }
    }

    if (e.getSource() == signUp2) {
      String dname = tf4.getText();
      String dphoneNo = tf5.getText();
      String demail = tf6.getText();
      String dnid = tf7.getText();
      String dlicense = tf8.getText();
      String dtype = carType.getSelectedItem().toString();
      String dexp = experience.getSelectedItem().toString();
      String drate = tf9.getText();
      String dpass = dp1.getText();
      String dconfPass = dcp1.getText();

      if (dname.length() >= 3 && dphoneNo.length() >= 3 && demail.length() >= 3 && dnid.length() >= 3
          && dlicense.length() >= 3 && drate.length() >= 1 && dpass.equals(dconfPass)) {
        try {
          Photographer d = new Photographer(dname, dphoneNo, demail, dpass, dnid, dlicense, dexp,
              dtype, drate);
          addPhotographer(d);
          photographersSignUp.setVisible(false);
          signupComplete.setVisible(true);
          File file = new File(".\\Data\\drivers.txt");
          if (!file.exists()) {
            file.createNewFile();
          }
          FileWriter fw = new FileWriter(file, true);
          BufferedWriter bw = new BufferedWriter(fw);
          PrintWriter pw = new PrintWriter(bw);

          pw.println("User Name : " + dname);
          pw.println("Password : " + dpass);
          pw.println("Phone : " + dphoneNo);

          pw.close();

        } catch (Exception ex) {
          System.out.print(ex);
        }

      }
    }

    if (e.getSource() == returnToSignup) {
      signupComplete.setVisible(false);
      signupPanel.setVisible(true);
    }

    if (e.getSource() == returnToLogin) {
      if (e.getSource() == returnToLogin) {
        signupFrame.setVisible(false);
        new Login(customers, photographer);

      }
    }

  }
}
