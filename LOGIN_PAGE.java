package BANK_MANAGEMEMNT_SYSYTEM;
import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class GUI_OF_LOGIN_PAGE implements ActionListener {
    REGISTER_PAGE registerPage;
    JFrame frame;
    JLabel PASSWORD_LABEL, EMAIL_ID_LABEL,MAIN_LABEL;
    Container c;
    TextField EMAIL_ID;
    JPasswordField PASSWORD_FIELD;
    JButton SIGN_IN_BUTTON, SIGN_UP_BUTTON;
    public GUI_OF_LOGIN_PAGE() {
        frame = new JFrame();
        frame.setVisible(true);
        frame.setTitle("LOGIN PAGE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(150, 50, 770, 540);
        c = frame.getContentPane();
        frame.setResizable(false);
        Font f = new Font("Arial", Font.BOLD, 25);
        String imagePath = "C:\\Users\\Public\\untitled\\src\\BANK_MANAGEMEMNT_SYSYTEM\\LOGIN_PAGE.png";
        ImageIcon backgroundImage = resizeImageIcon(imagePath,750,550);
        JLabel backgroundLabel = new JLabel(backgroundImage);
        c.add(backgroundLabel);
// *******************************MAIN LABEL*********************************
        MAIN_LABEL = new JLabel("VIRTUAL BANK ");
        MAIN_LABEL.setBounds(70, 20, 280, 50);
        backgroundLabel.add(MAIN_LABEL);
        MAIN_LABEL.setForeground(Color.GRAY);
        Font main_f = new Font("Courier New", Font.BOLD, 30);
        MAIN_LABEL.setFont(main_f);
// ******************EMAIL ID LABEL**********************
        EMAIL_ID_LABEL = new JLabel("User Name: ");
        EMAIL_ID_LABEL.setBounds(20, 90, 150, 50);
        backgroundLabel.add(EMAIL_ID_LABEL);
        EMAIL_ID_LABEL.setForeground(Color.black);
        EMAIL_ID_LABEL.setFont(f);
// ******************EMAIL ID TEXT FIELD**********************
        EMAIL_ID = new TextField();
        EMAIL_ID.setBounds(20, 140, 370, 50);
        backgroundLabel.add(EMAIL_ID);
        Font f1 = new Font("Arial", Font.BOLD, 35);
        EMAIL_ID.setFont(f1);
// ******************PASSWORD ID LABEL**********************
        PASSWORD_LABEL = new JLabel("Password: ");
        PASSWORD_LABEL.setBounds(20, 190, 170, 50);
        backgroundLabel.add(PASSWORD_LABEL);
        PASSWORD_LABEL.setForeground(Color.black);
        PASSWORD_LABEL.setFont(f);
// ******************EMAIL ID TEXT FIELD**********************
        PASSWORD_FIELD = new JPasswordField();
        PASSWORD_FIELD.setBounds(20, 240, 370, 50);
        backgroundLabel.add(PASSWORD_FIELD);
        PASSWORD_FIELD.setFont(f1);
//***************** SIGN IN BUTTON***************
        SIGN_IN_BUTTON = new JButton("Sign in");
        SIGN_IN_BUTTON.setBounds(29, 315, 340, 50);
        Font BUTTONS_FONT = new Font("Arial", Font.BOLD, 25);
        SIGN_IN_BUTTON.setFont(BUTTONS_FONT);
        backgroundLabel.add(SIGN_IN_BUTTON);
        SIGN_IN_BUTTON.setFocusable(false);
        SIGN_IN_BUTTON.addActionListener(this);
//***************** SIGN UP BUTTON***************
        SIGN_UP_BUTTON = new JButton("Sign up");
        SIGN_UP_BUTTON.setBounds(155, 415, 125, 55);
        SIGN_UP_BUTTON.setFont(BUTTONS_FONT);
        backgroundLabel.add(SIGN_UP_BUTTON);
        SIGN_UP_BUTTON.setFocusable(false);
        SIGN_UP_BUTTON.addActionListener(this);
    }
    public static ImageIcon resizeImageIcon(String imagePath, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == SIGN_UP_BUTTON) {
//            registerPage=new REGISTER_PAGE();
            registerPage = new REGISTER_PAGE();
        } else if (e.getSource() == SIGN_IN_BUTTON) {
            String email = EMAIL_ID.getText();
            String password = new String(PASSWORD_FIELD.getPassword());
//            registerPage.L
            if (registerPage != null) {
                ArrayList<String> SIGNED_DATA = registerPage.DATA;
                boolean ACCOUNT_MATCH = false;
                for (int i = 0; i < SIGNED_DATA.size(); i += 1) {
                    String storedEmail = SIGNED_DATA.get(i);
                    String storedPassword = SIGNED_DATA.get(i + 1);

                    if (storedEmail.equals(email) && storedPassword.equals(password)) {
                        ACCOUNT_MATCH = true;
                        System.out.println("Login successful!");
                        break;
                    }
                }
                if (ACCOUNT_MATCH) {
                    System.out.println("found");
                    MAIN_GUI_ main_gui_=new MAIN_GUI_();
                } else {
                    JOptionPane.showMessageDialog(frame, "Account Not Found");
                }
            }else {
                JOptionPane.showMessageDialog(frame, "Please sign up first.");
            }
        }
    }
}
public class LOGIN_PAGE {
    public static void main(String[] args) {

        GUI_OF_LOGIN_PAGE gui = new GUI_OF_LOGIN_PAGE();
    }

}

