package BANK_MANAGEMEMNT_SYSYTEM;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
class PERSON_GUI_ implements ActionListener {
    JFrame frame;
    JLabel BANK_TITLE1, BANK_TITLE2;
    Container c;
    JButton ADD_PERSON, DELETE_PERSON_BUTTON, SHOW_ALL_PERSON_BUTTON, SEARCH_PERSON_BUTTON, BACK_BUTTON;

    public PERSON_GUI_() {
        frame = new JFrame();
        frame.setVisible(true);
        frame.setTitle("\t\t\t\tBANK MANAGEMENT SYSTEM");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(150, 50, 770, 540);
        c = frame.getContentPane();
        frame.setResizable(false);
        Font f = new Font("Arial", Font.BOLD, 25);
        String imagePath = "C:\\Users\\Public\\untitled\\src\\BANK_MANAGEMEMNT_SYSYTEM\\PERSON_BANK.png";
        ImageIcon backgroundImage = resizeImageIcon(imagePath, 760, 550);
        JLabel backgroundLabel = new JLabel(backgroundImage);
        c.add(backgroundLabel);
        // *******************************MAIN LABEL*********************************
        BANK_TITLE1 = new JLabel("");
        BANK_TITLE2 = new JLabel("");
        BANK_TITLE1.setBounds(150, 20, 760, 50);
        BANK_TITLE2.setBounds(195, 10, 760, 50);
        backgroundLabel.add(BANK_TITLE1);
        backgroundLabel.add(BANK_TITLE2);
        BANK_TITLE1.setForeground(Color.BLACK);
        BANK_TITLE2.setForeground(Color.BLACK);
        Font main_f = new Font("Courier New", Font.BOLD, 45);
        BANK_TITLE1.setFont(main_f);
        BANK_TITLE2.setFont(main_f);

//************************ ADD PERSON BUTTON***************
        ADD_PERSON = new JButton("ADD PERSON ");
        ADD_PERSON.setBounds(230, 130, 285, 50);
        Font BUTTONS_FONT = new Font("Arial", Font.BOLD, 25);
        ADD_PERSON.setFont(BUTTONS_FONT);
        backgroundLabel.add(ADD_PERSON);
        ADD_PERSON.setFocusable(false);
        ADD_PERSON.addActionListener(this);
//***************** BACK BUTTON***************
        ImageIcon buttonIcon = new ImageIcon("C:\\Users\\Public\\untitled\\src\\BANK_MANAGEMEMNT_SYSYTEM\\—Pngtree—3d icon of red arrow_7267740.png");
        Image img = buttonIcon.getImage();
        Image resizedImage = img.getScaledInstance(135, 135, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        BACK_BUTTON = new JButton("");
        BACK_BUTTON.setBounds(10, 10, 130, 100);
        BACK_BUTTON.setFont(BUTTONS_FONT);
        BACK_BUTTON.setFocusable(false);
        BACK_BUTTON.addActionListener(this);
        BACK_BUTTON.setIcon(resizedIcon);
        BACK_BUTTON.setBorderPainted(false);
        backgroundLabel.add(BACK_BUTTON);
        BACK_BUTTON.setContentAreaFilled(false);
        BACK_BUTTON.setBorderPainted(false);
        BACK_BUTTON.setBackground(new Color(0, 0, 0, 0));
        BACK_BUTTON.setForeground(Color.WHITE);
//***************** SEARCH PERSON BUTTON***************
        SEARCH_PERSON_BUTTON = new JButton("SEARCH PERSON ");
        SEARCH_PERSON_BUTTON.setBounds(230, 200, 285, 50);
        SEARCH_PERSON_BUTTON.setFont(BUTTONS_FONT);
        backgroundLabel.add(SEARCH_PERSON_BUTTON);
        SEARCH_PERSON_BUTTON.setFocusable(false);
        SEARCH_PERSON_BUTTON.addActionListener(this);
//***************** DELETE PERSON BUTTON***************
        DELETE_PERSON_BUTTON = new JButton("DELETE PERSON ");
        DELETE_PERSON_BUTTON.setBounds(230, 270, 285, 50);
        DELETE_PERSON_BUTTON.setFont(BUTTONS_FONT);
        backgroundLabel.add(DELETE_PERSON_BUTTON);
        DELETE_PERSON_BUTTON.setFocusable(false);
        DELETE_PERSON_BUTTON.addActionListener(this);
//*****************SHOW ALL PERSON BUTTON***************
        SHOW_ALL_PERSON_BUTTON = new JButton("SHOW ALL PERSON");
        SHOW_ALL_PERSON_BUTTON.setBounds(230, 340, 285, 50);
        SHOW_ALL_PERSON_BUTTON.setFont(BUTTONS_FONT);
        backgroundLabel.add(SHOW_ALL_PERSON_BUTTON);
        SHOW_ALL_PERSON_BUTTON.setFocusable(false);
        SHOW_ALL_PERSON_BUTTON.addActionListener(this);
    }

    public static ImageIcon resizeImageIcon(String imagePath, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==BACK_BUTTON){
            MAIN_GUI_ main_gui_=new MAIN_GUI_();
        } else if (e.getSource()==ADD_PERSON) {
            ADD_PERSON_GUI addPersonGui=new ADD_PERSON_GUI();
        } else if (e.getSource()==SHOW_ALL_PERSON_BUTTON) {
            PERSON person = new PERSON();
            person.LOAD_DATA_FROM_FILE();
            ArrayList<PERSON> personList = person.getPersonList();
            SHOW_ALL_PERSON_GUI showAllPersonGui = new SHOW_ALL_PERSON_GUI(personList);
        } else if (e.getSource()==SEARCH_PERSON_BUTTON) {
            SEARCH_PERSON_GUI search_person_gui=new SEARCH_PERSON_GUI();
        } else if (e.getSource()==DELETE_PERSON_BUTTON) {
            DELETE_PERSON_GUI delete_person_gui=new DELETE_PERSON_GUI();
        }
    }
}
class ADD_PERSON_GUI implements ActionListener{
    JFrame frame;
    JLabel l1, l2, l3;
    Container c;
    TextField t1, t2, t3;
    JButton ADD_PERSON_BUTTON,BACK_BUTTON;
    String NAME,CNIC,PHONE_NO;
    public ADD_PERSON_GUI(){
        frame = new JFrame();
        frame.setTitle("PERSON DATA");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(150, 50, 770, 540);
        frame.setVisible(true);
        c = frame.getContentPane();

        String imagePath = "C:\\Users\\Public\\untitled\\src\\BANK_MANAGEMEMNT_SYSYTEM\\PERSON_BANK.png";
        ImageIcon backgroundImage = resizeImageIcon(imagePath,760,550);
        JLabel backgroundLabel = new JLabel(backgroundImage);
        c.add(backgroundLabel);

        l1 = new JLabel("Enter Name: ");
        l1.setBounds(15, 110, 180, 50);
        backgroundLabel.add(l1);
        l1.setForeground(Color.BLACK);
        Font f = new Font("Arial", Font.BOLD, 20);
        l1.setFont(f);
        t1 = new TextField();
        t1.setBounds(300, 110, 280, 50);
        backgroundLabel.add(t1);
        Font f1 = new Font("Arial", Font.PLAIN, 35);
        t1.setFont(f1);

        l2 = new JLabel("Enter CNIC: ");
        l2.setBounds(15, 190, 190, 50);
        backgroundLabel.add(l2);
        l2.setForeground(Color.BLACK);
        l2.setFont(f);

        t2 = new TextField();
        t2.setBounds(300, 190, 280, 50);
        backgroundLabel.add(t2);
        t2.setFont(f1);

        l3 = new JLabel("Enter Contact Number: ");
        l3.setBounds(15, 270, 230, 50);
        backgroundLabel.add(l3);
        l3.setForeground(Color.BLACK);
        l3.setFont(f);

        t3 = new TextField();
        t3.setBounds(300, 270, 280, 50);
        backgroundLabel.add(t3);
        t3.setFont(f1);

//******************* ADD PERSON BUTTON *************************
        ADD_PERSON_BUTTON = new JButton("ADD");
        ADD_PERSON_BUTTON.setBounds(290, 390, 155, 50);
        Font BUTTONS_FONT = new Font("Arial", Font.BOLD, 25);
        ADD_PERSON_BUTTON.setFont(BUTTONS_FONT);
        backgroundLabel.add(ADD_PERSON_BUTTON);
        ADD_PERSON_BUTTON.setFocusable(false);
        ADD_PERSON_BUTTON.addActionListener(this);
// ****************** BACK BUTTON ****************************
        ImageIcon buttonIcon = new ImageIcon("C:\\Users\\Public\\untitled\\src\\BANK_MANAGEMEMNT_SYSYTEM\\—Pngtree—3d icon of red arrow_7267740.png");
        Image img = buttonIcon.getImage();
        Image resizedImage = img.getScaledInstance(135, 135, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        BACK_BUTTON = new JButton("Back ");
        BACK_BUTTON.setBounds(15, 10, 120, 50);
        BACK_BUTTON.setFont(BUTTONS_FONT);
        backgroundLabel.add(BACK_BUTTON);
        BACK_BUTTON.setFocusable(false);
        BACK_BUTTON.addActionListener(this);
        BACK_BUTTON.setIcon(resizedIcon);
        BACK_BUTTON.setContentAreaFilled(false);
        BACK_BUTTON.setBorderPainted(false);
        BACK_BUTTON.setBackground(new Color(0, 0, 0, 0));
        BACK_BUTTON.setForeground(Color.WHITE);
    }
    public static ImageIcon resizeImageIcon(String imagePath, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==ADD_PERSON_BUTTON){
            NAME = t1.getText();
            CNIC = t2.getText();
            PHONE_NO = t3.getText();
            PERSON person = new PERSON(NAME, CNIC, PHONE_NO);
            PERSON p = new PERSON();
            p.LOAD_DATA_FROM_FILE();
            ArrayList<PERSON> personList = p.getPersonList();
            personList.add(person);
            p.SAVE_DATA_TO_FILE();

            JOptionPane.showMessageDialog(c, "PERSON ADDED SUCCESSFULLY");
        } else if (e.getSource()==BACK_BUTTON) {
            PERSON_GUI_ person_gui_=new PERSON_GUI_();

        }
    }
}
class DELETE_PERSON_GUI implements ActionListener{
    JFrame frame;
    JLabel l1;
    JButton SEARCH, BACK_BUTON,DELETE_PERSON_BUTTON;
    JTextArea SEARCHED_PERSON;
    JScrollPane SEARCHED_PERSON_IN_SCROLL_PANE;
    TextField CNIC_TO_SEARCH_PERSON;

    Container c;
    public DELETE_PERSON_GUI(){
        frame = new JFrame();
        frame.setTitle("SEARCH PERSON DATA");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(150, 50, 770, 540);
        frame.setVisible(true);
        c = frame.getContentPane();

        String imagePath = "C:\\Users\\Public\\untitled\\src\\BANK_MANAGEMEMNT_SYSYTEM\\PERSON_BANK.png";
        ImageIcon backgroundImage = resizeImageIcon(imagePath, 760, 550);
        JLabel backgroundLabel = new JLabel(backgroundImage);
        c.add(backgroundLabel);

        l1 = new JLabel("Enter CNIC of a Person: ");
        l1.setBounds(24, 72, 290, 50);
        backgroundLabel.add(l1);
        Color customColor = new Color(24, 84, 112);
        l1.setForeground(customColor);
        Font f = new Font("Arial", Font.BOLD, 25);
        l1.setFont(f);

        Font f1 = new Font("Arial", Font.PLAIN, 35);
        CNIC_TO_SEARCH_PERSON = new TextField();
        CNIC_TO_SEARCH_PERSON.setBounds(330, 70, 280, 50);
        backgroundLabel.add(CNIC_TO_SEARCH_PERSON);
        CNIC_TO_SEARCH_PERSON.setFont(f1);
//******************** SEARCH BUTTON **********************
        SEARCH = new JButton("Search ");
        SEARCH.setBounds(310, 150, 130, 45);
        Font BUTTONS_FONT = new Font("Arial", Font.BOLD, 25);
        SEARCH.setFont(BUTTONS_FONT);
        backgroundLabel.add(SEARCH);
        SEARCH.setFocusable(false);
        SEARCH.addActionListener(this);

        ImageIcon buttonIcon = new ImageIcon("C:\\Users\\Public\\untitled\\src\\BANK_MANAGEMEMNT_SYSYTEM\\—Pngtree—3d icon of red arrow_7267740.png");
        Image img = buttonIcon.getImage();
        Image resizedImage = img.getScaledInstance(135, 135, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        BACK_BUTON = new JButton("BACK ");
        BACK_BUTON.setBounds(15, 10, 110, 50);
        BACK_BUTON.setFont(BUTTONS_FONT);
        backgroundLabel.add(BACK_BUTON);
        BACK_BUTON.setFocusable(false);
        BACK_BUTON.addActionListener(this);
        BACK_BUTON.setIcon(resizedIcon);
        BACK_BUTON.setContentAreaFilled(false);
        BACK_BUTON.setBorderPainted(false);
        BACK_BUTON.setBackground(new Color(0, 0, 0, 0));
        BACK_BUTON.setForeground(Color.WHITE);

        DELETE_PERSON_BUTTON = new JButton("Delete Person ");
        DELETE_PERSON_BUTTON.setBounds(270, 410, 210, 45);
        DELETE_PERSON_BUTTON.setFont(BUTTONS_FONT);
        backgroundLabel.add(DELETE_PERSON_BUTTON);
        DELETE_PERSON_BUTTON.setFocusable(false);
        DELETE_PERSON_BUTTON.addActionListener(this);

        SEARCHED_PERSON = new JTextArea();
        SEARCHED_PERSON.setEditable(false);
        SEARCHED_PERSON_IN_SCROLL_PANE = new JScrollPane(SEARCHED_PERSON);
        SEARCHED_PERSON_IN_SCROLL_PANE.setBounds(110, 230, 550, 150);
        backgroundLabel.add(SEARCHED_PERSON_IN_SCROLL_PANE);
    }
    public static ImageIcon resizeImageIcon(String imagePath, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==BACK_BUTON){
            PERSON_GUI_ person_gui_=new PERSON_GUI_();
        } else if (e.getSource()==SEARCH) {
            String cnicToSearch = CNIC_TO_SEARCH_PERSON.getText();
            PERSON p = new PERSON();
            p.LOAD_DATA_FROM_FILE();
            ArrayList<PERSON> personList = p.getPersonList();
            SEARCHED_PERSON.setText("");
            PERSON foundPerson = null;
            for (PERSON person : personList) {
                if (person.getCNIC().equals(cnicToSearch)) {
                    foundPerson = person;
                    break;
                }
            }
            if (foundPerson != null) {
                SEARCHED_PERSON.append("\n\n" + foundPerson);
            } else {
                SEARCHED_PERSON.append("Person not found with CNIC: " + cnicToSearch);
            }
        } else if (e.getSource()==DELETE_PERSON_BUTTON) {
            String cnicToDelete = CNIC_TO_SEARCH_PERSON.getText();
            PERSON p = new PERSON();
            p.LOAD_DATA_FROM_FILE();
            ArrayList<PERSON> personList = p.getPersonList();
            boolean isclient=false;
            boolean personDeleted = false;
            for (int i = 0; i < personList.size(); i++) {
                PERSON person = personList.get(i);
                if (person.getCNIC().equals(cnicToDelete)) {
                    personList.remove(i);
                    personDeleted = true;
                    SEARCHED_PERSON.setText("Person with CNIC" + cnicToDelete + " has been deleted");
                    break;

                }
            }
            if (personDeleted) {
                p.setPersonList(personList);
                p.SAVE_DATA_TO_FILE();
                Client client = new Client();
                Account account=new Account();
                client.LOAD_DATA_FROM_CLIENT_FILE();
                ArrayList<Client> clientList = client.getCLIENT_LIST();
                for (int i = 0; i < clientList.size(); i++) {
                    if (clientList.get(i).person.getCNIC().equals(cnicToDelete)) {
                        client.DELETE_CLIENT(clientList.get(i));
                        SEARCHED_PERSON.setText("ASSOCIATED CLIENT ALSO DELETED");
                        isclient =true;
                        break;
                    }
                }
                account.DELTE_ACCOUNT_TO_DELTE_WITH_PERSON(cnicToDelete);
                SEARCHED_PERSON.setText("ASSOCIATED ACCOUNT ALSO DELETED");
            } else {
                SEARCHED_PERSON.setText("Person not found with CNIC: " + cnicToDelete);
            }
            if (personDeleted) {
                p.setPersonList(personList);
                p.SAVE_DATA_TO_FILE();

                if (isclient) {
                    SEARCHED_PERSON.setText("Person with CNIC " + cnicToDelete + " has been deleted. Person is no longer a client,and associated client also deleted.");
                } else {
                    SEARCHED_PERSON.setText("Person with CNIC " + cnicToDelete + " has been deleted.");
                }
            } else {
                SEARCHED_PERSON.setText("Person not found with CNIC: " + cnicToDelete);
            }
        }
    }
}
class SEARCH_PERSON_GUI implements ActionListener {
    JFrame frame;
    JLabel l1, l2, l3;
    Container c;
    TextField CNIC_TO_SEARCH_PERSON;
    JButton SEARCH, BACK_BUTON;
    JTextArea SEARCHED_PERSON;
    JScrollPane SEARCHED_PERSON_IN_SCROLL_PANE;
    public SEARCH_PERSON_GUI() {
        frame = new JFrame();
        frame.setTitle("SEARCH PERSON DATA");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(150, 50, 770, 540);
        frame.setVisible(true);
        c = frame.getContentPane();

        String imagePath = "C:\\Users\\Public\\untitled\\src\\BANK_MANAGEMEMNT_SYSYTEM\\PERSON_BANK.png";
        ImageIcon backgroundImage = resizeImageIcon(imagePath, 760, 550);
        JLabel backgroundLabel = new JLabel(backgroundImage);
        c.add(backgroundLabel);

        l1 = new JLabel("Enter CNIC of a Person: ");
        l1.setBounds(24, 72, 290, 50);
        backgroundLabel.add(l1);
        Color customColor = new Color(24, 84, 112);
        l1.setForeground(customColor);
        Font f = new Font("Arial", Font.BOLD, 25);
        l1.setFont(f);

        Font f1 = new Font("Arial", Font.PLAIN, 35);
        CNIC_TO_SEARCH_PERSON = new TextField();
        CNIC_TO_SEARCH_PERSON.setBounds(330, 70, 280, 50);
        backgroundLabel.add(CNIC_TO_SEARCH_PERSON);
        CNIC_TO_SEARCH_PERSON.setFont(f1);

        SEARCH = new JButton("Search ");
        SEARCH.setBounds(310, 150, 130, 45);
        Font BUTTONS_FONT = new Font("Arial", Font.BOLD, 25);
        SEARCH.setFont(BUTTONS_FONT);
        backgroundLabel.add(SEARCH);
        SEARCH.setFocusable(false);
        SEARCH.addActionListener(this);
//************************* BACK_BUTON ************************************
        ImageIcon buttonIcon = new ImageIcon("C:\\Users\\Public\\untitled\\src\\BANK_MANAGEMEMNT_SYSYTEM\\—Pngtree—3d icon of red arrow_7267740.png");
        Image img = buttonIcon.getImage();
        Image resizedImage = img.getScaledInstance(135, 135, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        BACK_BUTON = new JButton("BACK ");
        BACK_BUTON.setBounds(15, 10, 110, 50);
        BACK_BUTON.setFont(BUTTONS_FONT);
        backgroundLabel.add(BACK_BUTON);
        BACK_BUTON.setFocusable(false);
        BACK_BUTON.addActionListener(this);
        BACK_BUTON.setIcon(resizedIcon);
        BACK_BUTON.setContentAreaFilled(false);
        BACK_BUTON.setBorderPainted(false);
        BACK_BUTON.setBackground(new Color(0, 0, 0, 0));
        BACK_BUTON.setForeground(Color.WHITE);
        SEARCHED_PERSON = new JTextArea();
        SEARCHED_PERSON.setEditable(false);
        SEARCHED_PERSON_IN_SCROLL_PANE = new JScrollPane(SEARCHED_PERSON);
        SEARCHED_PERSON_IN_SCROLL_PANE.setBounds(110, 230, 550, 150);
        backgroundLabel.add(SEARCHED_PERSON_IN_SCROLL_PANE);
    }

    public static ImageIcon resizeImageIcon(String imagePath, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == BACK_BUTON) {
            PERSON_GUI_ person_gui_ = new PERSON_GUI_();
        } else if (e.getSource() == SEARCH) {
            String cnicToSearch = CNIC_TO_SEARCH_PERSON.getText();
            PERSON p = new PERSON();
            p.LOAD_DATA_FROM_FILE();
            ArrayList<PERSON> personList = p.getPersonList();
            SEARCHED_PERSON.setText("");
            PERSON foundPerson = null;
            for (PERSON person : personList) {
                if (person.getCNIC().equals(cnicToSearch)) {
                    foundPerson = person;
                    break;
                }
            }
            if (foundPerson != null) {
                SEARCHED_PERSON.append("Person Found:\n\n" + foundPerson);
            } else {
                SEARCHED_PERSON.append("Person not found with CNIC: " + cnicToSearch);
            }
        }
    }
}
class SHOW_ALL_PERSON_GUI implements ActionListener {
    JFrame frame;
    Container c;
    JTextArea PERSON_TEXT_AREA;
    JButton BACK_BUTTON;

    public SHOW_ALL_PERSON_GUI(ArrayList<PERSON> personList) {
        frame = new JFrame();
        frame.setTitle("SEARCH PERSON DATA");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(150, 50, 770, 540);
        frame.setVisible(true);
        c = frame.getContentPane();

        String imagePath = "C:\\Users\\Public\\untitled\\src\\BANK_MANAGEMEMNT_SYSYTEM\\PERSON_BANK.png";
        ImageIcon backgroundImage = resizeImageIcon(imagePath, 760, 550);
        JLabel backgroundLabel = new JLabel(backgroundImage);
        c.add(backgroundLabel);

        ImageIcon buttonIcon = new ImageIcon("C:\\Users\\Public\\untitled\\src\\BANK_MANAGEMEMNT_SYSYTEM\\—Pngtree—3d icon of red arrow_7267740.png");
        Image img = buttonIcon.getImage();
        Image resizedImage = img.getScaledInstance(135, 135, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        BACK_BUTTON = new JButton("BACK ");
        BACK_BUTTON.setBounds(15, 10, 110, 50);
        Font BUTTONS_FONT = new Font("Arial", Font.BOLD, 25);
        BACK_BUTTON.setFont(BUTTONS_FONT);
        backgroundLabel.add(BACK_BUTTON);
        BACK_BUTTON.setFocusable(false);
        BACK_BUTTON.addActionListener(this);
        BACK_BUTTON.setIcon(resizedIcon);
        BACK_BUTTON.setContentAreaFilled(false);
        BACK_BUTTON.setBorderPainted(false);
        BACK_BUTTON.setBackground(new Color(0, 0, 0, 0));
        BACK_BUTTON.setForeground(Color.WHITE);
        PERSON_TEXT_AREA = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(PERSON_TEXT_AREA);
        PERSON_TEXT_AREA.setEditable(false);
        scrollPane.setBounds(50, 100, 660, 350);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        backgroundLabel.add(scrollPane);
        displayAllPersons(personList);
    }
    public static ImageIcon resizeImageIcon(String imagePath, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }

    public void displayAllPersons(ArrayList<PERSON> personList) {
        if (personList != null && !personList.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (PERSON p : personList) {
                sb.append(p.toString()).append("\n\t\t\n\n");
            }
            PERSON_TEXT_AREA.setText(sb.toString());
        } else {
            PERSON_TEXT_AREA.setText("No persons available.");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==BACK_BUTTON){
            PERSON_GUI_ person_gui_=new PERSON_GUI_();
        }
    }
}

public class PERSON_GUI {
    public static void main(String[] args) {
        PERSON_GUI_ person_gui_=new PERSON_GUI_();
//        SHOW_ALL_PERSON_GUI showAllPersonGui=new SHOW_ALL_PERSON_GUI();
//        ADD_PERSON_GUI addPersonGui=new ADD_PERSON_GUI();
//        SEARCH_PERSON_GUI searchPersonGui = new SEARCH_PERSON_GUI();
//        DELETE_PERSON_GUI deletePersonGui=new DELETE_PERSON_GUI();
    }
}

