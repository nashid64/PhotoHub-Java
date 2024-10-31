
package Login;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

import User.*;
import Login.*;
import Dashboard.*;
import User.Photographer;

public class PhotographerSignUp implements ActionListener {

  Photographer[] photographer = new Photographer[100];

  JFrame driSignupFrame;
  JPanel photographerSignUp;
  JPanel signupComplete;
  JLabel l1, l2;
  JTextField tf1, tf2, tf3, tf4, tf5, tf6;
  JPasswordField cp1, ccp1;
  JButton signUp, returnToLogin, returnToSignup;
  JComboBox<String> experience, carType;
  String[] PhotographyTypes = { "Fine-art photography", " Portrait Photography", "Fashion Photography", "Landscape Photography", "Product Photography", " Wedding Photography", "FILIM","Sports Photography" };
  String[] PhotographyExperience = { "1-3 years", "2-5 years", "5-10 years", "10-15 years" };

  PhotographerSignUp() {
    driSignupFrame = new JFrame();

    photographerSignUp = new JPanel();

    l1 = new JLabel("Signup as Photographer");
    l1.setBounds(300, 100, 400, 80);
    Font bigFont = l1.getFont().deriveFont(Font.PLAIN, 40f);
    l1.setFont(bigFont);

    tf1 = new JTextField("Name");
    tf1.setBounds(300, 200, 150, 30);

    tf1.setFont(bigFont);

    tf2 = new JTextField("Phone Number");
    tf2.setBounds(300, 300, 150, 30);
    tf2.setFont(bigFont);

    tf3 = new JTextField("Email");
    tf3.setBounds(300, 400, 150, 30);
    tf3.setFont(bigFont);

    cp1 = new JPasswordField("Admin Password", 7);
    cp1.setBounds(750, 200, 150, 80);
    cp1.setFont(bigFont);

    ccp1 = new JPasswordField("Confirm Password", 7);
    ccp1.setBounds(750, 300, 150, 80);
    ccp1.setFont(bigFont);

    tf4 = new JTextField("NID Number");
    tf4.setBounds(300, 480, 150, 30);
    tf4.setFont(bigFont);

    tf5 = new JTextField("Lisence Number");
    tf5.setBounds(300, 540, 150, 30);
    tf5.setFont(bigFont);

    carType = new JComboBox<>(PhotographyTypes);
    carType.setBounds(400, 250, 140, 20);

    experience = new JComboBox<>(PhotographyExperience);
    experience.setBounds(400, 350, 140, 20);

    signUp = new JButton("Sign-up");
    signUp.setBounds(150, 200, 70, 30);
    signUp.addActionListener(this);
    signUp.setOpaque(false);
    signUp.setContentAreaFilled(false);
    signUp.setBorderPainted(true);
    signUp.setForeground(Color.BLACK);

    photographersSignUp.add(l1);
    photographersSignUp.add(tf1);
    photographersSignUp.add(tf2);
    photographersSignUp.add(tf3);
    photographersSignUp.add(tf4);
    photographersSignUp.add(tf5);
    photographersSignUp.add(experience);
    photographersSignUp.add(carType);
    photographersSignUp.add(cp1);
    photographersSignUp.add(ccp1);
    photographersSignUp.add(signUp);
    photographersSignUp.setLayout(null);
    photographersSignUp.setBounds(0, 0, 1000, 700);
    photographersSignUp.setBackground(Color.green);
    photographersSignUp.setVisible(true);

    signupComplete = new JPanel();

    l2 = new JLabel("Account has been successfully created!");
    l2.setBounds(300, 100, 400, 80);
    l2.setFont(bigFont);

    returnToLogin = new JButton("Return to Login");
    returnToLogin.setBounds(150, 200, 150, 30);
    returnToLogin.addActionListener(this);
    returnToLogin.setOpaque(false);
    returnToLogin.setContentAreaFilled(false);
    returnToLogin.setBorderPainted(true);
    returnToLogin.setForeground(Color.BLACK);

    returnToSignup = new JButton("Return to Sign-up");
    returnToSignup.setBounds(150, 300, 150, 30);
    returnToSignup.addActionListener(this);
    returnToSignup.setOpaque(false);
    returnToSignup.setContentAreaFilled(false);
    returnToSignup.setBorderPainted(true);
    returnToSignup.setForeground(Color.BLACK);

    signupComplete.add(l2);
    signupComplete.add(returnToLogin);
    signupComplete.add(returnToSignup);
    signupComplete.setLayout(null);
    signupComplete.setBounds(0, 0, 1000, 700);
    signupComplete.setBackground(Color.green);
    signupComplete.setVisible(false);

    driSignupFrame.add(photographersSignUp);
    driSignupFrame.add(signupComplete);
    driSignupFrame.setLayout(null);
    driSignupFrame.setTitle("Customer Signup - Fotohub");
    driSignupFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    driSignupFrame.setSize(1000, 700);
    driSignupFrame.setLocationRelativeTo(null);
    driSignupFrame.setVisible(true);

  }

  public void addPhotographer(Photographer a)// function for adding an account to the array
  {
    int count = 0;

    for (int i = 0; i < photographer.length; i++) {
      if (photographer[i] == null) {
        photographer[i] = a;
        count++;
        this.photographer = photographer;
        break;
      }
    }
    if (count == 0) {
      System.out.println("Account not added");
    } else {
      System.out.println("Account added");
    }
  }

  public Photographer[] getPhotographer() {

    return photographer;

  }

  public void actionPerformed(ActionEvent e) {

    if (e.getSource() == signUp) {
      String name = tf1.getText();
      String phoneNo = tf2.getText();
      String email = tf3.getText();
      String nid = tf4.getText();
      String lisence = tf5.getText();
      String type = carType.getSelectedItem().toString();
      String exp = experience.getSelectedItem().toString();
      String pass = cp1.getText();
      String confPass = ccp1.getText();
      String rate = tf6.getText();

      if (name != null && phoneNo != null && email != null && pass.equals(confPass)) {
        Photographer a = new Photographer(name, phoneNo, email, pass, nid, lisence, exp, type,
            rate);

        addPhotographer(a);
        photographersSignUp.setVisible(false);
        signupComplete.setVisible(true);

      }
    }

    if (e.getSource() == returnToLogin) {
      driSignupFrame.setVisible(false);
      Customer[] dummyc = new Customer[1];
      new Login(dummyc, photographer);

    }

    if (e.getSource() == returnToSignup) {
      signupComplete.setVisible(false);
      photographersSignUp.setVisible(true);

    }

  }

}
