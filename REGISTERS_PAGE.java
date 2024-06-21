package BANK_MANAGEMEMNT_SYSYTEM;


import BANK_MANAGEMEMNT_SYSYTEM.Account;
//import GUI_OF_LOGIN_PAGE;

import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

class REGISTER_PAGE implements ActionListener {
    JFrame frame_of_registre_page;
    TextField EMAIL_ID, PASSWORD_FIELD, CONFIRM_PASSWORD;
    JButton SIGN_UP_BUTTON,BACK_BUTTON;
    JLabel backgroundLabel, EMAIL_ID_LABEL, PASSWORD_LABEL, CONFIRM_PASSWORD_LABEL;

    Container c;
    public ArrayList<String> DATA = new ArrayList<>();

    public REGISTER_PAGE() {
        LOAD_ACCOUNTS_DATA_FROM_FILE();
        frame_of_registre_page = new JFrame();
        frame_of_registre_page.setVisible(true);
        frame_of_registre_page.setTitle("Register Page");
        frame_of_registre_page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame_of_registre_page.setBounds(150, 50, 500, 600);
        c = frame_of_registre_page.getContentPane();

        String imagePath = "C:\\Users\\Public\\untitled\\src\\BANK_MANAGEMEMNT_SYSYTEM\\MATH_BACKGROUND.jpg";
        ImageIcon backgroundImage = resizeImageIcon(imagePath,500,550);
        JLabel backgroundLabel = new JLabel(backgroundImage);
        c.add(backgroundLabel);
        frame_of_registre_page.setResizable(false);
        Font f = new Font("Arial", Font.BOLD, 25);

// ******************EMAIL ID LABEL**********************
        EMAIL_ID_LABEL = new JLabel("User Name: ");
        EMAIL_ID_LABEL.setBounds(20, 90, 150, 50);
        backgroundLabel.add(EMAIL_ID_LABEL);
        EMAIL_ID_LABEL.setForeground(Color.black);
        EMAIL_ID_LABEL.setFont(f);
// ******************EMAIL ID TEXT FIELD**********************
        EMAIL_ID = new TextField();
        EMAIL_ID.setBounds(20, 140, 420, 50);
        backgroundLabel.add(EMAIL_ID);
        Font f1 = new Font("Arial", Font.PLAIN, 25);
        EMAIL_ID.setFont(f1);
// ******************PASSWORD ID LABEL**********************
        PASSWORD_LABEL = new JLabel("Password: ");
        PASSWORD_LABEL.setBounds(20, 190, 170, 50);
        backgroundLabel.add(PASSWORD_LABEL);
        PASSWORD_LABEL.setForeground(Color.black);
        PASSWORD_LABEL.setFont(f);
// ******************EMAIL ID TEXT FIELD**********************
        PASSWORD_FIELD = new TextField();
        PASSWORD_FIELD.setBounds(20, 240, 420, 50);
        backgroundLabel.add(PASSWORD_FIELD);
        PASSWORD_FIELD.setFont(f1);
// ******************CONFIRM PASSWORD LABEL**********************
        CONFIRM_PASSWORD_LABEL = new JLabel("Confirm Password: ");
        CONFIRM_PASSWORD_LABEL.setBounds(20, 290, 250, 50);
        backgroundLabel.add(CONFIRM_PASSWORD_LABEL);
        CONFIRM_PASSWORD_LABEL.setForeground(Color.black);
        CONFIRM_PASSWORD_LABEL.setFont(f);
// ***************************CONFIRM PASSWORD TEXT FIELD***********************************
        CONFIRM_PASSWORD = new TextField();
        CONFIRM_PASSWORD.setBounds(20, 340, 420, 50);
        backgroundLabel.add(CONFIRM_PASSWORD);
        CONFIRM_PASSWORD.setFont(f1);
//*********************************** SIGN Up BUTTON****************************************
        SIGN_UP_BUTTON = new JButton("Sign up");
        SIGN_UP_BUTTON.setBounds(20, 410, 420, 50);
        Font BUTTONS_FONT = new Font("Arial", Font.BOLD, 25);
        SIGN_UP_BUTTON.setFont(BUTTONS_FONT);
//        SIGN_UP_BUTTON.setBackground(Color.PINK);
        backgroundLabel.add(SIGN_UP_BUTTON);
        SIGN_UP_BUTTON.setFocusable(false);
        SIGN_UP_BUTTON.addActionListener(this);
        System.out.println(DATA);
//************************************* BACK BUTTON*****************************************
        BACK_BUTTON = new JButton("Back");
        BACK_BUTTON.setBounds(10, 10, 100, 50);
        BACK_BUTTON.setFont(BUTTONS_FONT);
        backgroundLabel.add(BACK_BUTTON);
        BACK_BUTTON.setFocusable(false);
        BACK_BUTTON.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == SIGN_UP_BUTTON) {
            String email = EMAIL_ID.getText();
            String password = PASSWORD_FIELD.getText();
            String confirmPassword = CONFIRM_PASSWORD.getText();
            if (!email.isEmpty() && !password.isEmpty() && !confirmPassword.isEmpty()) {
                if (password.equals(confirmPassword)) {
                    DATA.add(email);
                    DATA.add(password);
                    SAVE_ACCOUNTS_DATA_TO_FILE();
                    System.out.println(DATA);
//                    GUI_OF_LOGIN_PAGE loginPage=new GUI_OF_LOGIN_PAGE();
                    frame_of_registre_page.dispose();
                }else {
                    JOptionPane.showMessageDialog(frame_of_registre_page, "Password do not match.");
                }
            } else {
                JOptionPane.showMessageDialog(frame_of_registre_page, "Please fill all fields.");
            }
        } else if (e.getSource()==BACK_BUTTON) {
            frame_of_registre_page.dispose();
            GUI_OF_LOGIN_PAGE guiOfLoginPage=new GUI_OF_LOGIN_PAGE();
        }
    }
    public static ImageIcon resizeImageIcon(String imagePath, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }
    private void SAVE_ACCOUNTS_DATA_TO_FILE(){
        try {
            FileOutputStream fileOutputStream=new FileOutputStream("C:\\Users\\Public\\untitled\\src\\GUI\\CLIENTS_DATA.txt");
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(DATA);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void LOAD_ACCOUNTS_DATA_FROM_FILE() {
        File file = new File("C:\\Users\\Public\\untitled\\src\\GUI\\CLIENTS_DATA.txt");

        if (file.exists() && file.length() > 0) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                Object obj = objectInputStream.readObject();

                if (obj instanceof ArrayList) {
                    DATA = (ArrayList<String>) obj;
                } else {
                    System.out.println("Invalid data format in the file.");
                }

                objectInputStream.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("File does not exist or is empty.");
        }
    }

    @Override
    public String toString() {
        return "REGISTER_PAGE{" +
                "EMAIL_ID=" + EMAIL_ID +
                ", PASSWORD_FIELD=" + PASSWORD_FIELD +
                ", CONFIRM_PASSWORD=" + CONFIRM_PASSWORD +
                '}';
    }
}
public class REGISTERS_PAGE{
    public static void main(String[] args) {
        REGISTER_PAGE registerPage = new REGISTER_PAGE();
    }
}

