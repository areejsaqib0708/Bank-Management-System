package BANK_MANAGEMEMNT_SYSYTEM;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MAIN_GUI_ implements ActionListener {
    JFrame frame;
    JLabel BANK_TITLE1,BANK_TITLE2;
    Container c;
    JButton PERSON_BUTTON, CLIENT_BUTTON,ACCOUNT_BUTTON;
    public MAIN_GUI_(){
        frame = new JFrame();
        frame.setVisible(true);
        frame.setTitle("\t\t\t\tBANK MANAGEMENT SYSTEM");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(150, 50, 770, 540);
        c = frame.getContentPane();
        frame.setResizable(false);
        Font f = new Font("Arial", Font.BOLD, 25);
        String imagePath = "C:\\Users\\Public\\untitled\\src\\BANK_MANAGEMEMNT_SYSYTEM\\MAIN_BANK_GUI.png";
        ImageIcon backgroundImage = resizeImageIcon(imagePath,790,550);
        JLabel backgroundLabel = new JLabel(backgroundImage);
        c.add(backgroundLabel);
 // *******************************MAIN LABEL*********************************
        BANK_TITLE1 = new JLabel("WELCOME TO MONEY");
        BANK_TITLE2 = new JLabel(" MAGNET BANK ");
        BANK_TITLE1.setBounds(150, 20, 760, 50);
        BANK_TITLE2.setBounds(195, 70, 760, 50);
        backgroundLabel.add(BANK_TITLE1);
        backgroundLabel.add(BANK_TITLE2);
        BANK_TITLE1.setForeground(Color.BLACK);
        BANK_TITLE2.setForeground(Color.BLACK);
        Font main_f = new Font("Courier New", Font.BOLD, 45);
        BANK_TITLE1.setFont(main_f);
        BANK_TITLE2.setFont(main_f);
//***************** PERSON BUTTON***************
        ImageIcon buttonIcon = new ImageIcon("C:\\Users\\Public\\untitled\\src\\BANK_MANAGEMEMNT_SYSYTEM\\PERSON.png");
        Image img = buttonIcon.getImage();
        Image resizedImage = img.getScaledInstance(245, 100, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        PERSON_BUTTON = new JButton("");
        PERSON_BUTTON.setBounds(250, 140, 260, 100);
        Font BUTTONS_FONT = new Font("Arial", Font.BOLD, 25);
        PERSON_BUTTON.setFont(BUTTONS_FONT);
        backgroundLabel.add(PERSON_BUTTON);
        PERSON_BUTTON.setFocusable(false);
        PERSON_BUTTON.addActionListener(this);
        PERSON_BUTTON.setIcon(resizedIcon);
        PERSON_BUTTON.setBorderPainted(false);

        PERSON_BUTTON.setContentAreaFilled(false);
        PERSON_BUTTON.setBorderPainted(false);

        PERSON_BUTTON.setBackground(new Color(0, 0, 0, 0));
        PERSON_BUTTON.setForeground(Color.WHITE);
//***************** CLIENT BUTTON***************
        ImageIcon CLIENT_buttonIcon = new ImageIcon("C:\\Users\\Public\\untitled\\src\\BANK_MANAGEMEMNT_SYSYTEM\\CLIENT.png");
        Image CLIENT_img = CLIENT_buttonIcon.getImage();
        Image CLIENT_resizedImage = CLIENT_img.getScaledInstance(245, 100, Image.SCALE_SMOOTH);
        ImageIcon CLIENT_resizedIcon = new ImageIcon(CLIENT_resizedImage);
        CLIENT_BUTTON = new JButton("");
        CLIENT_BUTTON.setBounds(250, 250, 260, 100);
        CLIENT_BUTTON.setFont(BUTTONS_FONT);
        backgroundLabel.add(CLIENT_BUTTON);
        CLIENT_BUTTON.setFocusable(false);
        CLIENT_BUTTON.addActionListener(this);
        CLIENT_BUTTON.setIcon(CLIENT_resizedIcon);
        CLIENT_BUTTON.setBorderPainted(false);

        CLIENT_BUTTON.setContentAreaFilled(false);
        CLIENT_BUTTON.setBorderPainted(false);

        CLIENT_BUTTON.setBackground(new Color(0, 0, 0, 0));
        CLIENT_BUTTON.setForeground(Color.WHITE);
//***************** ACCOUNT BUTTON***************
        ImageIcon ACCOUNTCLIENT_buttonIcon = new ImageIcon("C:\\Users\\Public\\untitled\\src\\BANK_MANAGEMEMNT_SYSYTEM\\ACCOUNT.png");
        Image ACCOUNT_img = ACCOUNTCLIENT_buttonIcon.getImage();
        Image ACCOUNT_resizedImage = ACCOUNT_img.getScaledInstance(245, 100, Image.SCALE_SMOOTH);
        ImageIcon ACCOUNT_resizedIcon = new ImageIcon(ACCOUNT_resizedImage);
        ACCOUNT_BUTTON = new JButton("");
        ACCOUNT_BUTTON.setBounds(250, 345, 260, 150);
        ACCOUNT_BUTTON.setFont(BUTTONS_FONT);
        backgroundLabel.add(ACCOUNT_BUTTON);
        ACCOUNT_BUTTON.setFocusable(false);
        ACCOUNT_BUTTON.addActionListener(this);
        ACCOUNT_BUTTON.setIcon(ACCOUNT_resizedIcon);
        ACCOUNT_BUTTON.setBorderPainted(false);

        ACCOUNT_BUTTON.setContentAreaFilled(false);
        ACCOUNT_BUTTON.setBorderPainted(false);

        ACCOUNT_BUTTON.setBackground(new Color(0, 0, 0, 0));
        ACCOUNT_BUTTON.setForeground(Color.WHITE);
    }
    public static ImageIcon resizeImageIcon(String imagePath, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==PERSON_BUTTON){
            PERSON_GUI_ person_gui_=new PERSON_GUI_();
            frame.dispose();
        } else if (e.getSource()==CLIENT_BUTTON) {
            CLIENT_GUI_ clientGui=new CLIENT_GUI_();
            frame.dispose();
        } else if (e.getSource()==ACCOUNT_BUTTON) {
            ACCOUNT_GUI_ account_gui_=new ACCOUNT_GUI_();
            frame.dispose();
        }
    }
}
public class MAIN_GUI {
    public static void main(String[] args) {
        MAIN_GUI_ main_gui_=new MAIN_GUI_();
    }
}
