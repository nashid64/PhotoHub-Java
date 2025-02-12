
package Dashboard;

import java.awt.*;
import java.awt.Color;
import javax.swing.ImageIcon;

import User.Customer;
import User.Photographer;
import Login.Login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.*;

public class CustomerDashboard implements ActionListener {

  JFrame dashboardFrame;
  JPanel customerPanel1, results, customerPanel2, searchResults, resultsp;
  JButton bSearchPhotographer, bCustomerLogout, bBackToCustomerPanel1, bHirePhotographer, b10, b9;
  JButton[] hirePhotographer = new JButton[100];
  JLabel customerPanelBackground, lCp1, lCp2, lCp3, lCp4, lCp5, lSp1, dName, dNamel, dExp, dExpl, poster1, poster2 , dRate ,dRatel;
  boolean b;
  int flag = 0;
  JComboBox<String> experience, carType;
  Photographer[] searchResult = new Photographer[100];
  Photographer[] photographer = new Photographer[100];
  Customer[] customers = new Customer[100];
  
  String[] PhotographyTypes = { "Fine-art photography", " Portrait Photography", "Fashion Photography", "Landscape Photography", "Product Photography", " Wedding Photography", "FILIM","Sports Photography" };
  String[] PhotographyExperience = { "1-3 years", "2-5 years", "5-10 years", "10-15 years" };

  public CustomerDashboard(Customer[] customers , Photographer[] photographer) // Customer c)
  {
    this.customers = customers;
    this.photographer = photographer;
    dashboardFrame = new JFrame();

    /////////// Customer Panel /////////////////

    customerPanel1 = new JPanel();

    lCp1 = new JLabel("Welcome to FotoHub");
    lCp1.setBounds(410, 100, 300, 40);
    Font medFont = lCp1.getFont().deriveFont(Font.PLAIN, 30f);
    lCp1.setForeground(Color.BLACK);
    lCp1.setFont(medFont);

    lCp2 = new JLabel("Search for Photographer");
    lCp2.setBounds(490, 170, 200, 20);
    Font smallFont = lCp2.getFont().deriveFont(Font.PLAIN, 20f);
    lCp2.setForeground(Color.BLACK);
    lCp2.setFont(smallFont);

    lCp3 = new JLabel("Your required car type:");
    lCp3.setBounds(370, 250, 250, 20);
    lCp3.setForeground(Color.BLACK);
    lCp3.setFont(smallFont);

    lCp5 = new JLabel("Years of experience:");
    lCp5.setBounds(370, 350, 250, 20);
    lCp5.setForeground(Color.BLACK);
    lCp5.setFont(smallFont);

    bSearchPhotographer = new JButton("Search for Photographer");
    bSearchPhotographer.setBounds(450, 460, 200, 50);
    bSearchPhotographer.addActionListener(this);
    bSearchPhotographer.setOpaque(true);
    bSearchPhotographer.setContentAreaFilled(true);
    bSearchPhotographer.setBackground(Color.BLACK);
    bSearchPhotographer.setBorderPainted(true);
    bSearchPhotographer.setForeground(Color.WHITE);

    bCustomerLogout = new JButton("Logout");
    bCustomerLogout.setBounds(5, 600, 100, 40);
    bCustomerLogout.addActionListener(this);
    bCustomerLogout.setOpaque(true);
    bCustomerLogout.setContentAreaFilled(true);
    bCustomerLogout.setBackground(Color.BLACK);
    bCustomerLogout.setBorderPainted(true);
    bCustomerLogout.setForeground(Color.WHITE);

    b9 = new JButton("Exit");
    b9.setBounds(1000, 620, 80, 30);
    b9.addActionListener(this);
    b9.setOpaque(false);
    b9.setContentAreaFilled(false);
    b9.setBorderPainted(false);
    b9.setForeground(Color.BLACK);

    carType = new JComboBox<>(PhotographyTypes);
    carType.setBounds(600, 250, 140, 20);

    experience = new JComboBox<>(PhotographyExperience);
    experience.setBounds(600, 350, 140, 20);

    ImageIcon img = new ImageIcon("Images/1.png");
    poster1 = new JLabel(img);
    poster1.setBounds(0, 0, 1100, 700);

    customerPanel1.add(lCp1);
    customerPanel1.add(lCp2);
    customerPanel1.add(lCp3);
    customerPanel1.add(lCp5);
    customerPanel1.add(carType);
    customerPanel1.add(experience);
    customerPanel1.add(bSearchPhotographer);
    customerPanel1.add(bCustomerLogout);
    customerPanel1.add(b9);
    customerPanel1.add(poster1);
    customerPanel1.setLayout(null);
    customerPanel1.setBounds(0, 0, 1100, 700);
    customerPanel1.setBackground(Color.gray);
    customerPanel1.setVisible(true);

    /////////// search results //////////////////
    customerPanel2 = new JPanel();

    lSp1 = new JLabel("Photographer available");
    lSp1.setBounds(400, 100, 200, 20);
    lSp1.setForeground(Color.BLACK);
    lSp1.setFont(smallFont);

    bBackToCustomerPanel1 = new JButton("Search Again");
    bBackToCustomerPanel1.setBounds(475, 580, 150, 40);
    bBackToCustomerPanel1.addActionListener(this);
    bBackToCustomerPanel1.setOpaque(true);
    bBackToCustomerPanel1.setContentAreaFilled(true);
    bBackToCustomerPanel1.setBackground(Color.BLACK);
    bBackToCustomerPanel1.setBorderPainted(true);
    bBackToCustomerPanel1.setForeground(Color.WHITE);

    searchResults = new JPanel();

    searchResults.setLayout(null);
    searchResults.setBounds(260, 70, 600, 500);
    searchResults.setBackground(Color.WHITE);
    searchResults.setVisible(true);
    customerPanel2.add(searchResults);

    b10 = new JButton("Exit");
    b10.setBounds(1000, 620, 80, 30);
    b10.addActionListener(this);
    b10.setOpaque(false);
    b10.setContentAreaFilled(false);
    b10.setBorderPainted(false);
    b10.setForeground(Color.BLACK);

    ImageIcon img2 = new ImageIcon("Images/2.png");
    poster2 = new JLabel(img2);
    poster2.setBounds(0, 0, 1100, 700);

    customerPanel2.add(bBackToCustomerPanel1);
    customerPanel2.add(b10);
    customerPanel2.add(poster2);
    customerPanel2.setLayout(null);
    customerPanel2.setBounds(0, 0, 1100, 700);
    customerPanel2.setBackground(Color.gray);
    customerPanel2.setVisible(false);

    // dashboardFrame.setIconImage(icon.getImage());
    dashboardFrame.add(customerPanel1);
    dashboardFrame.add(customerPanel2);
    dashboardFrame.setLayout(null);
    dashboardFrame.setTitle("Dashboard FotoHub");
    dashboardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    dashboardFrame.setSize(1100, 700);
    dashboardFrame.setLocationRelativeTo(null);
    dashboardFrame.setVisible(true);

  }

  public void filter(Photographer[] photographer) {

    String type = carType.getSelectedItem().toString();
    String exp = experience.getSelectedItem().toString();

    for (int i = 0; i < photographer.length; i++) {
      // int flag = 0;
      if (photographer[i] != null) {
        String driType = photographer[i].getCarType();
        String driExp = photographer[i].getYearsExp();
        if (type.equals(driType) && exp.equals(driExp)) {
          addResult(photographer[i]);
        }
      }
    }
  }

  public void addResult(Photographer d) {

    for (int i = 0; i < searchResult.length; i++) {

      if (searchResult[i] == null) {
        searchResult[i] = d;
        // searchResult[i].showDriverDetails();
        // System.out.println(i);
        break;

      }

    }
  }

  public void newGIG(Photographer searchResult, int gap) {
    int posY = gap * 110;

    resultsp = new JPanel();

    bHirePhotographer = new JButton("Hire");
    bHirePhotographer.setBounds(495, 32, 70, 27);
    bHirePhotographer.addActionListener(this);
    bHirePhotographer.setOpaque(true);
    bHirePhotographer.setContentAreaFilled(true);
    bHirePhotographer.setBackground(Color.BLACK);
    bHirePhotographer.setBorderPainted(true);
    bHirePhotographer.setForeground(Color.WHITE);

    dNamel = new JLabel("Name: ");
    dNamel.setBounds(5, 5, 80, 20);
    dNamel.setForeground(Color.BLACK);

    dName = new JLabel(searchResult.getName());
    dName.setBounds(50, 5, 200, 20);
    dName.setForeground(Color.BLACK);

    dExpl = new JLabel("Years of experience: ");
    dExpl.setBounds(5, 40, 200, 20);
    dExpl.setForeground(Color.BLACK);

    dExp = new JLabel(searchResult.getYearsExp());
    dExp.setBounds(130, 40, 150, 20);
    dExp.setForeground(Color.BLACK);

    dRatel = new JLabel("Hourly rate: ");
    dRatel.setBounds(5,75, 200, 20);
    dRatel.setForeground(Color.BLACK);

    dRate = new JLabel(searchResult.getRate());
    dRate.setBounds(90, 75, 150, 20);
    dRate.setForeground(Color.BLACK);

    resultsp.add(bHirePhotographer);
    resultsp.add(dNamel);
    resultsp.add(dName);
    resultsp.add(dExp);
    resultsp.add(dExpl);
    resultsp.add(dRate);
    resultsp.add(dRatel);
    resultsp.setLayout(null);
    resultsp.setBounds(10, 10 + posY, 580, 100);
    resultsp.setBackground(Color.gray);
    resultsp.setVisible(true);

    searchResults.add(resultsp);

    hirePhotographer[gap] = bHirePhotographer;

  }

  public void actionPerformed(ActionEvent e) {
    for (int i = 0; i < hirePhotographer.length; i++) {
      if (e.getSource() == hirePhotographer[i]) {

        JOptionPane.showMessageDialog(null, "Photographer Hired!", "Success!",
        JOptionPane.WARNING_MESSAGE);

      }
    }

    if (e.getSource() == bSearchPhotographer) {

      customerPanel2.setVisible(true);
      customerPanel1.setVisible(false);
      filter(photographer);
      for (int i = 0; i < searchResult.length; i++) {
        if (searchResult[i] != null) {
          newGIG(searchResult[i], i);

        }
      }
    }

    if (e.getSource() == bBackToCustomerPanel1) {
      customerPanel2.setVisible(false);
      // searchResults.removeAll();
      // resultsp.removeAll();
      customerPanel1.setVisible(true);
      for (int i = 0; i < searchResult.length; i++) {
        if (searchResult[i] != null) {
          searchResult[i] = null;
        }
        searchResults.removeAll();

      }
    }

    if (e.getSource() == bCustomerLogout) {

      dashboardFrame.setVisible(false);
      new Login(customers, photographer);

    }

    if (e.getSource() == b9) {

      System.exit(0);

    }
    if (e.getSource() == b10) {

      System.exit(0);

    }
  }
}
