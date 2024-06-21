package BANK_MANAGEMEMNT_SYSYTEM;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
class CLIENT_GUI_ implements ActionListener {
    JFrame frame;
    JLabel BANK_TITLE1, BANK_TITLE2;
    Container c;
    JButton ADD_CLIENT, DELETE_CLIENT_BUTTON, SHOW_ALL_CLIENT_BUTTON, SEARCH_CLIENT_BUTTON, BACK_BUTTON;

    public CLIENT_GUI_(){
        frame = new JFrame();
        frame.setVisible(true);
        frame.setTitle("\t\t\t\tBANK MANAGEMENT SYSTEM");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(150, 50, 770, 540);
        c = frame.getContentPane();
        frame.setResizable(false);
        Font f = new Font("Arial", Font.BOLD, 25);
        String imagePath = "C:\\Users\\Public\\untitled\\src\\BANK_MANAGEMEMNT_SYSYTEM\\CLIENT_GUI.png";
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
        ADD_CLIENT = new JButton("ADD CLIENT ");
        ADD_CLIENT.setBounds(230, 130, 285, 50);
        Font BUTTONS_FONT = new Font("Arial", Font.BOLD, 25);
        ADD_CLIENT.setFont(BUTTONS_FONT);
        backgroundLabel.add(ADD_CLIENT);
        ADD_CLIENT.setFocusable(false);
        ADD_CLIENT.addActionListener(this);
//***************** BACK BUTTON***************
        BACK_BUTTON = new JButton("Back ");
        BACK_BUTTON.setBounds(10, 10, 100, 50);
        BACK_BUTTON.setFont(BUTTONS_FONT);
        backgroundLabel.add(BACK_BUTTON);
        BACK_BUTTON.setFocusable(false);
        BACK_BUTTON.addActionListener(this);
//***************** SEARCH CLIENT BUTTON***************
        SEARCH_CLIENT_BUTTON = new JButton("SEARCH CLIENT ");
        SEARCH_CLIENT_BUTTON.setBounds(230, 200, 285, 50);
        SEARCH_CLIENT_BUTTON.setFont(BUTTONS_FONT);
        backgroundLabel.add(SEARCH_CLIENT_BUTTON);
        SEARCH_CLIENT_BUTTON.setFocusable(false);
        SEARCH_CLIENT_BUTTON.addActionListener(this);
//***************** DELETE CLIENT BUTTON***************
        DELETE_CLIENT_BUTTON = new JButton("DELETE CLIENT ");
        DELETE_CLIENT_BUTTON.setBounds(230, 270, 285, 50);
        DELETE_CLIENT_BUTTON.setFont(BUTTONS_FONT);
        backgroundLabel.add(DELETE_CLIENT_BUTTON);
        DELETE_CLIENT_BUTTON.setFocusable(false);
        DELETE_CLIENT_BUTTON.addActionListener(this);
//*****************SHOW ALL PERSON BUTTON***************
        SHOW_ALL_CLIENT_BUTTON = new JButton("SHOW ALL CLIENTS");
        SHOW_ALL_CLIENT_BUTTON.setBounds(230, 340, 285, 50);
        SHOW_ALL_CLIENT_BUTTON.setFont(BUTTONS_FONT);
        backgroundLabel.add(SHOW_ALL_CLIENT_BUTTON);
        SHOW_ALL_CLIENT_BUTTON.setFocusable(false);
        SHOW_ALL_CLIENT_BUTTON.addActionListener(this);
    }
    public static ImageIcon resizeImageIcon(String imagePath, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==BACK_BUTTON){
            frame.dispose();
            MAIN_GUI_ main_gui_=new MAIN_GUI_();
        } else if (e.getSource()==ADD_CLIENT) {
            ADD_CLIENT_GUI add_client_gui=new ADD_CLIENT_GUI();
            frame.dispose();
        } else if (e.getSource()==SHOW_ALL_CLIENT_BUTTON) {
            Client client=new Client();
            client.LOAD_DATA_FROM_CLIENT_FILE();
            ArrayList<Client> clients_list=client.getCLIENT_LIST();
            SHOW_ALL_CLIENT_GUI show_all_client_gui=new SHOW_ALL_CLIENT_GUI(clients_list);
            frame.dispose();
        } else if (e.getSource()==SEARCH_CLIENT_BUTTON) {
            frame.dispose();
            SEARCH_CLIENT_GUI search_client_gui =new SEARCH_CLIENT_GUI();
        } else if (e.getSource()==DELETE_CLIENT_BUTTON) {
            frame.dispose();
            DELETE_CLIENT_GUI delete_client_gui=new DELETE_CLIENT_GUI();
        }
    }

}
class  ADD_CLIENT_GUI implements ActionListener{
    JFrame frame;
    JLabel l1, l2, l3;
    Container c;
    TextField CLIENT_ID_TO_SEARCH_PERSON;
    JButton ADD, BACK_BUTON;
    JTextArea SEARCHED_CLIENT;
    JScrollPane scrollPane;
    Client clientManager;
//    static int count= 1;
    public ADD_CLIENT_GUI(){
        clientManager = new Client();
        frame = new JFrame();
        frame.setTitle("ADD CLIENT ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(150, 50, 770, 540);
        frame.setVisible(true);
        c = frame.getContentPane();

        String imagePath = "C:\\Users\\Public\\untitled\\src\\BANK_MANAGEMEMNT_SYSYTEM\\CLIENT_GUI.png";
        ImageIcon backgroundImage = resizeImageIcon(imagePath, 760, 550);
        JLabel backgroundLabel = new JLabel(backgroundImage);
        c.add(backgroundLabel);

        l1 = new JLabel("Enter CNIC of a Person: ");
        l1.setBounds(40, 72, 340, 50);
        backgroundLabel.add(l1);
        Color customColor = new Color(5, 19, 1);
        l1.setForeground(customColor);
        Font f = new Font("Arial", Font.BOLD, 28);
        l1.setFont(f);

        Font f1 = new Font("Arial", Font.PLAIN, 35);
        CLIENT_ID_TO_SEARCH_PERSON = new TextField();
        CLIENT_ID_TO_SEARCH_PERSON.setBounds(390, 70, 280, 50);
        backgroundLabel.add(CLIENT_ID_TO_SEARCH_PERSON);
        CLIENT_ID_TO_SEARCH_PERSON.setFont(f1);

        ADD = new JButton("ADD ");
        ADD.setBounds(310, 150, 130, 45);
        Font BUTTONS_FONT = new Font("Arial", Font.BOLD, 25);
        ADD.setFont(BUTTONS_FONT);
        backgroundLabel.add(ADD);
        ADD.setFocusable(false);
        ADD.addActionListener(this);
//************************* BACK_BUTON ************************************
        BACK_BUTON = new JButton("BACK ");
        BACK_BUTON.setBounds(10, 10, 110, 40);
        BACK_BUTON.setFont(BUTTONS_FONT);
        backgroundLabel.add(BACK_BUTON);
        BACK_BUTON.setFocusable(false);
        BACK_BUTON.addActionListener(this);
        SEARCHED_CLIENT = new JTextArea();
        SEARCHED_CLIENT.setEditable(false);
        scrollPane = new JScrollPane(SEARCHED_CLIENT);
        scrollPane.setBounds(40, 210, 680, 250);
        backgroundLabel.add(scrollPane);

    }
    public static ImageIcon resizeImageIcon(String imagePath, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==BACK_BUTON){
            frame.dispose();
            CLIENT_GUI_ clientGui=new CLIENT_GUI_();
        }if (e.getSource()==ADD){
            String enteredCNIC = CLIENT_ID_TO_SEARCH_PERSON.getText();
            PERSON person = new PERSON();
            person.LOAD_DATA_FROM_FILE();
            ArrayList<PERSON> personList = person.getPersonList();
            boolean personExists = false;
            for (PERSON p : personList) {
                if (p.getCNIC().equals(enteredCNIC)) {
                    personExists = true;
                    break;
                }
            }
            if (personExists) {
                Client client = new Client(person);
                String clientID = client.getId();
                client.addPersonToClientList(clientID, enteredCNIC);
                client.SAVE_DATA_TO_CLIENT_FILE();
                JOptionPane.showMessageDialog(c, "Client added successfully! Generated ID: " + clientID);
            } else {
                JOptionPane.showMessageDialog(c, "Person not found. Please add the person first.");
            }
        }
        }
    }
class DELETE_CLIENT_GUI implements ActionListener{
    JFrame frame;
    JLabel l1, l2, l3;
    JButton SEARCH, BACK_BUTON,DELETE_CLIENT_BUTTON;
    JTextArea SEARCHED_CLIENT;
    JScrollPane SEARCHED_CLIENT_IN_SCROLL_PANE;
    TextField ID_TO_SEARCH_Client;

    Container c;
    public DELETE_CLIENT_GUI(){
        frame = new JFrame();
        frame.setTitle("DELETE CLIENT ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(150, 50, 770, 540);
        frame.setVisible(true);
        c = frame.getContentPane();

        String imagePath = "C:\\Users\\Public\\untitled\\src\\BANK_MANAGEMEMNT_SYSYTEM\\PERSON_BANK.png";
        ImageIcon backgroundImage = resizeImageIcon(imagePath, 760, 550);
        JLabel backgroundLabel = new JLabel(backgroundImage);
        c.add(backgroundLabel);

        l1 = new JLabel("Enter Client ID: ");
        l1.setBounds(24, 72, 290, 50);
        backgroundLabel.add(l1);
        Color customColor = new Color(24, 84, 112);
        l1.setForeground(customColor);
        Font f = new Font("Arial", Font.BOLD, 25);
        l1.setFont(f);

        Font f1 = new Font("Arial", Font.PLAIN, 35);
        ID_TO_SEARCH_Client = new TextField();
        ID_TO_SEARCH_Client.setBounds(330, 70, 280, 50);
        backgroundLabel.add(ID_TO_SEARCH_Client);
        ID_TO_SEARCH_Client.setFont(f1);
//******************** SEARCH BUTTON **********************
        SEARCH = new JButton("Search ");
        SEARCH.setBounds(310, 150, 130, 45);
        Font BUTTONS_FONT = new Font("Arial", Font.BOLD, 25);
        SEARCH.setFont(BUTTONS_FONT);
        backgroundLabel.add(SEARCH);
        SEARCH.setFocusable(false);
        SEARCH.addActionListener(this);

        BACK_BUTON = new JButton("BACK ");
        BACK_BUTON.setBounds(10, 10, 110, 40);
        BACK_BUTON.setFont(BUTTONS_FONT);
        backgroundLabel.add(BACK_BUTON);
        BACK_BUTON.setFocusable(false);
        BACK_BUTON.addActionListener(this);

        DELETE_CLIENT_BUTTON = new JButton("Delete Client ");
        DELETE_CLIENT_BUTTON.setBounds(270, 410, 210, 45);
        DELETE_CLIENT_BUTTON.setFont(BUTTONS_FONT);
        backgroundLabel.add(DELETE_CLIENT_BUTTON);
        DELETE_CLIENT_BUTTON.setFocusable(false);
        DELETE_CLIENT_BUTTON.addActionListener(this);

        SEARCHED_CLIENT = new JTextArea();
        SEARCHED_CLIENT.setEditable(false);
        SEARCHED_CLIENT_IN_SCROLL_PANE = new JScrollPane(SEARCHED_CLIENT);
        SEARCHED_CLIENT_IN_SCROLL_PANE.setBounds(110, 230, 550, 150);
        backgroundLabel.add(SEARCHED_CLIENT_IN_SCROLL_PANE);
    }
    public static ImageIcon resizeImageIcon(String imagePath, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==BACK_BUTON){
            CLIENT_GUI_ client_gui_=new CLIENT_GUI_();
        } else if (e.getSource()==SEARCH) {
            String clientIDToSearch = ID_TO_SEARCH_Client.getText();
            Client client=new Client();
            client.LOAD_DATA_FROM_CLIENT_FILE();
            ArrayList<Client> client_list=client.getCLIENT_LIST();
            SEARCHED_CLIENT.setText("");
            Client found_client=null;
            for (Client c : client_list) {
                if (c.getId().equals(clientIDToSearch)) {
                    found_client = c;
                    break;
                }
            }if (found_client!=null){
                SEARCHED_CLIENT.append("Client Found:\n\n" + found_client);
            }else {
                SEARCHED_CLIENT.append("\t\tClient not Found with ID:" + clientIDToSearch);

            }
        } else if (e.getSource()==DELETE_CLIENT_BUTTON) {
            String clientIDToDelete = ID_TO_SEARCH_Client.getText();
            Client c = new Client();
            c.LOAD_DATA_FROM_CLIENT_FILE();
            ArrayList<Client> client_List = c.getCLIENT_LIST();
            boolean foundClient = false;

            for (int i = 0; i < client_List.size(); i++) {
                Client client = client_List.get(i);
                if (client.getId().equals(clientIDToDelete)) {
                    client_List.remove(i);
                    foundClient = true;
                    break;
                }
            }

            if (foundClient) {
                SEARCHED_CLIENT.setText("Client Deleted with ID: " + clientIDToDelete);
                c.SAVE_DATA_TO_CLIENT_FILE();

                Account account = new Account();
                account.LOAD_ACCOUNTS_DATA_FROM_FILE();
                ArrayList<Account> accountsToDelete = account.SEARCH_ACCOUNTS_WITH_ID(clientIDToDelete);
                if (!accountsToDelete.isEmpty()) {
                    account.DELETE_ACCOUNTS_WITH_CLIENT(clientIDToDelete);
                    account.SAVE_ACCOUNTS_DATA_TO_FILE();
                    SEARCHED_CLIENT.setText("Account(s) also deleted for Client ID: " + clientIDToDelete);
                }
            } else {
                SEARCHED_CLIENT.setText("\t\tClient not Found with ID: " + clientIDToDelete);
            }

        }
    }
        }
class SEARCH_CLIENT_GUI implements ActionListener{
    JFrame frame;
    JLabel l1, l2, l3;
    Container c;
    TextField CLIENT_ID_TO_SEARCH_PERSON;
    JButton SEARCH, BACK_BUTON;
    JTextArea SEARCHED_CLIENT;
    JScrollPane SEARCHED_CLIENT_IN_SCROLL_PANE;
    public SEARCH_CLIENT_GUI(){
        frame = new JFrame();
        frame.setTitle("SEARCH CLIENT ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(150, 50, 770, 540);
        frame.setVisible(true);
        c = frame.getContentPane();

        String imagePath = "C:\\Users\\Public\\untitled\\src\\BANK_MANAGEMEMNT_SYSYTEM\\CLIENT_GUI.png";
        ImageIcon backgroundImage = resizeImageIcon(imagePath, 760, 550);
        JLabel backgroundLabel = new JLabel(backgroundImage);
        c.add(backgroundLabel);

        l1 = new JLabel("Enter Client ID: ");
        l1.setBounds(70, 72, 220, 50);
        backgroundLabel.add(l1);
        Color customColor = new Color(5, 19, 1);
        l1.setForeground(customColor);
        Font f = new Font("Arial", Font.BOLD, 28);
        l1.setFont(f);

        Font f1 = new Font("Arial", Font.PLAIN, 35);
        CLIENT_ID_TO_SEARCH_PERSON = new TextField();
        CLIENT_ID_TO_SEARCH_PERSON.setBounds(330, 70, 280, 50);
        backgroundLabel.add(CLIENT_ID_TO_SEARCH_PERSON);
        CLIENT_ID_TO_SEARCH_PERSON.setFont(f1);

        SEARCH = new JButton("Search ");
        SEARCH.setBounds(310, 150, 130, 45);
        Font BUTTONS_FONT = new Font("Arial", Font.BOLD, 25);
        SEARCH.setFont(BUTTONS_FONT);
        backgroundLabel.add(SEARCH);
        SEARCH.setFocusable(false);
        SEARCH.addActionListener(this);
//************************* BACK_BUTON ************************************
        BACK_BUTON = new JButton("BACK ");
        BACK_BUTON.setBounds(10, 10, 110, 40);
        BACK_BUTON.setFont(BUTTONS_FONT);
        backgroundLabel.add(BACK_BUTON);
        BACK_BUTON.setFocusable(false);
        BACK_BUTON.addActionListener(this);
        SEARCHED_CLIENT = new JTextArea();
        SEARCHED_CLIENT.setEditable(false);
        SEARCHED_CLIENT_IN_SCROLL_PANE = new JScrollPane(SEARCHED_CLIENT);
        SEARCHED_CLIENT_IN_SCROLL_PANE.setBounds(110, 230, 550, 150);
        backgroundLabel.add(SEARCHED_CLIENT_IN_SCROLL_PANE);
    }
    public static ImageIcon resizeImageIcon(String imagePath, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==BACK_BUTON){
            CLIENT_GUI_ clientGui=new CLIENT_GUI_();
        }if (e.getSource()==SEARCH){
            String clientIDToSearch = CLIENT_ID_TO_SEARCH_PERSON.getText();
            Client client=new Client();
            client.LOAD_DATA_FROM_CLIENT_FILE();
            ArrayList<Client> client_list=client.getCLIENT_LIST();
            SEARCHED_CLIENT.setText("");
            Client found_client=null;
            for (Client c : client_list) {
                if (c.getId().equals(clientIDToSearch)) {
                    found_client = c;
                    break;
                }
            }if (found_client!=null){
                SEARCHED_CLIENT.append("Client Found:\n\n" + found_client);
            }else {
                SEARCHED_CLIENT.append("\t\tClient not Found with ID:" + clientIDToSearch);
            }
        }
    }
}
class SHOW_ALL_CLIENT_GUI implements ActionListener{
    JFrame frame;
    Container c;
    JTextArea CLIENT_TEXT_AREA;
    JButton BACK_BUTTON;
    public SHOW_ALL_CLIENT_GUI(ArrayList<Client>client_List){
        frame = new JFrame();
        frame.setTitle("ALL CLIENTS DATA");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(150, 50, 770, 540);
        frame.setVisible(true);
        c = frame.getContentPane();

        String imagePath = "C:\\Users\\Public\\untitled\\src\\BANK_MANAGEMEMNT_SYSYTEM\\CLIENT_GUI.png";
        ImageIcon backgroundImage = resizeImageIcon(imagePath, 760, 550);
        JLabel backgroundLabel = new JLabel(backgroundImage);
        c.add(backgroundLabel);

        BACK_BUTTON = new JButton("BACK ");
        BACK_BUTTON.setBounds(10, 10, 110, 40);
        Font BUTTONS_FONT = new Font("Arial", Font.BOLD, 25);
        BACK_BUTTON.setFont(BUTTONS_FONT);
        backgroundLabel.add(BACK_BUTTON);
        BACK_BUTTON.setFocusable(false);
        BACK_BUTTON.addActionListener(this);
        CLIENT_TEXT_AREA = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(CLIENT_TEXT_AREA);
        CLIENT_TEXT_AREA.setEditable(false);
        scrollPane.setBounds(50, 100, 660, 350);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        backgroundLabel.add(scrollPane);
        displayAllPersons(client_List);
    }
    public static ImageIcon resizeImageIcon(String imagePath, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }
    private void displayAllPersons(ArrayList<Client> clientList) {
        if (clientList != null && !clientList.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Client client : clientList) {
                sb.append(client.toString()).append("\n\n");
            }
            CLIENT_TEXT_AREA.setText(sb.toString());
        } else {
            CLIENT_TEXT_AREA.setText("No clients available.");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==BACK_BUTTON){
            CLIENT_GUI_ client_gui_=new CLIENT_GUI_();
        }
    }
}
public class CLIENT_GUI {
    public static void main(String[] args) {
//        SEARCH_CLIENT_GUI searchClientGui=new SEARCH_CLIENT_GUI();
        CLIENT_GUI_ clientGui=new CLIENT_GUI_();
//        ADD_CLIENT_GUI addClientGui=new ADD_CLIENT_GUI();
//        SEARCH_CLIENT_GUI search_client_gui=new SEARCH_CLIENT_GUI();
//            DELETE_CLIENT_GUI delete_client_gui=new DELETE_CLIENT_GUI();
    }
}
