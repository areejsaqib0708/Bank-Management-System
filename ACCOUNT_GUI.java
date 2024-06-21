package BANK_MANAGEMEMNT_SYSYTEM;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
class ACCOUNT_GUI_ implements ActionListener {
    JFrame frame;
    JLabel BANK_TITLE1, BANK_TITLE2;
    Container c;
    JButton ADD_ACCOUNT_BUTTON, DELETE_ACCOUNT_BUTTON, SHOW_ALL_ACCOUNT_BUTTON, SEARCH_ACCOUNT_BUTTON, BACK_BUTTON,SHOW_ALL_MONEY_BUTTON,DEPOSIT_MONEY_BUTTON,WITHDRAW_MONEY_BUTTON,SHOW_ALL_MONEY_OF_CLIENT;

    public ACCOUNT_GUI_(){
        frame = new JFrame();
        frame.setVisible(true);
        frame.setTitle("\t\t\t\tACCOUNTS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(150, 50, 770, 590);
        c = frame.getContentPane();
        frame.setResizable(false);
        Font f = new Font("Arial", Font.BOLD, 25);
        String imagePath = "C:\\Users\\Public\\untitled\\src\\BANK_MANAGEMEMNT_SYSYTEM\\ACCOUNT_GUI.png";
        ImageIcon backgroundImage = resizeImageIcon(imagePath, 765, 550);
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
        ADD_ACCOUNT_BUTTON = new JButton("OPEN ACCOUNT ");
        ADD_ACCOUNT_BUTTON.setBounds(60, 230, 315, 50);
        Font BUTTONS_FONT = new Font("Arial", Font.BOLD, 25);
        ADD_ACCOUNT_BUTTON.setFont(BUTTONS_FONT);
        backgroundLabel.add(ADD_ACCOUNT_BUTTON);
        ADD_ACCOUNT_BUTTON.setFocusable(false);
        ADD_ACCOUNT_BUTTON.addActionListener(this);
        ADD_ACCOUNT_BUTTON.setBackground(Color.LIGHT_GRAY);
        ADD_ACCOUNT_BUTTON.setForeground(Color.WHITE);


//        ADD_ACCOUNT_BUTTON.setContentAreaFilled(false);
//        ADD_ACCOUNT_BUTTON.setBorderPainted(false);
//
//        // Set foreground and background colors
//        ADD_ACCOUNT_BUTTON.setBackground(new Color(0, 0, 0, 0));
//        ADD_ACCOUNT_BUTTON.setForeground(Color.WHITE);
//***************** BACK BUTTON***************
        ImageIcon buttonIcon = new ImageIcon("C:\\Users\\Public\\untitled\\src\\BANK_MANAGEMEMNT_SYSYTEM\\backkkk.png");
        Image img = buttonIcon.getImage();
        Image resizedImage = img.getScaledInstance(115, 115, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        BACK_BUTTON = new JButton("Back ");
        BACK_BUTTON.setBounds(15, 15, 90, 50);
        BACK_BUTTON.setFont(BUTTONS_FONT);
        BACK_BUTTON.setFocusable(false);
        BACK_BUTTON.addActionListener(this);
        BACK_BUTTON.setIcon(resizedIcon);
        BACK_BUTTON.setBorderPainted(false);
        backgroundLabel.add(BACK_BUTTON);
//***************** DELETE ACCOUNT BUTTON***************
        DELETE_ACCOUNT_BUTTON = new JButton("CLOSE ACCOUNT ");
        DELETE_ACCOUNT_BUTTON.setBounds(390, 230, 315, 50);
        DELETE_ACCOUNT_BUTTON.setFont(BUTTONS_FONT);
        backgroundLabel.add(DELETE_ACCOUNT_BUTTON);
        DELETE_ACCOUNT_BUTTON.setFocusable(false);
        DELETE_ACCOUNT_BUTTON.addActionListener(this);
        DELETE_ACCOUNT_BUTTON.setBackground(Color.LIGHT_GRAY);
        DELETE_ACCOUNT_BUTTON.setForeground(Color.WHITE);
//***************** DEPOSIT MONEY BUTTON***************
        DEPOSIT_MONEY_BUTTON = new JButton("DEPOSIT MONEY ");
        DEPOSIT_MONEY_BUTTON.setBounds(60, 290, 315, 50);
        DEPOSIT_MONEY_BUTTON.setFont(BUTTONS_FONT);
        backgroundLabel.add(DEPOSIT_MONEY_BUTTON);
        DEPOSIT_MONEY_BUTTON.setFocusable(false);
        DEPOSIT_MONEY_BUTTON.addActionListener(this);
        DEPOSIT_MONEY_BUTTON.setBackground(Color.LIGHT_GRAY);
        DEPOSIT_MONEY_BUTTON.setForeground(Color.WHITE);
//***************** WITHDRAW MONEY BUTTON***************
        WITHDRAW_MONEY_BUTTON = new JButton("WITHDRAW MONEY");
        WITHDRAW_MONEY_BUTTON.setBounds(390, 290, 315, 50);
        WITHDRAW_MONEY_BUTTON.setFont(BUTTONS_FONT);
        backgroundLabel.add(WITHDRAW_MONEY_BUTTON);
        WITHDRAW_MONEY_BUTTON.setFocusable(false);
        WITHDRAW_MONEY_BUTTON.addActionListener(this);
        WITHDRAW_MONEY_BUTTON.setBackground(Color.LIGHT_GRAY);
        WITHDRAW_MONEY_BUTTON.setForeground(Color.WHITE);
//***************** SEARCH PERSON BUTTON***************
        SEARCH_ACCOUNT_BUTTON = new JButton("SEARCH ACCOUNT");
        SEARCH_ACCOUNT_BUTTON.setBounds(60, 350, 315, 50);
        SEARCH_ACCOUNT_BUTTON.setFont(BUTTONS_FONT);
        backgroundLabel.add(SEARCH_ACCOUNT_BUTTON);
        SEARCH_ACCOUNT_BUTTON.setFocusable(false);
        SEARCH_ACCOUNT_BUTTON.addActionListener(this);
        SEARCH_ACCOUNT_BUTTON.setBackground(Color.LIGHT_GRAY);
        SEARCH_ACCOUNT_BUTTON.setForeground(Color.WHITE);
//*****************SHOW ALL PERSON BUTTON***************
        SHOW_ALL_ACCOUNT_BUTTON = new JButton("SHOW ALL ACCOUNTS");
        SHOW_ALL_ACCOUNT_BUTTON.setBounds(390, 350, 315, 50);
        SHOW_ALL_ACCOUNT_BUTTON.setFont(BUTTONS_FONT);
        backgroundLabel.add(SHOW_ALL_ACCOUNT_BUTTON);
        SHOW_ALL_ACCOUNT_BUTTON.setFocusable(false);
        SHOW_ALL_ACCOUNT_BUTTON.addActionListener(this);
        SHOW_ALL_ACCOUNT_BUTTON.setBackground(Color.LIGHT_GRAY);
        SHOW_ALL_ACCOUNT_BUTTON.setForeground(Color.WHITE);
//*****************SHOW ALL PERSON BUTTON***************
        SHOW_ALL_MONEY_OF_CLIENT = new JButton("TOTAL MONEY OF A CLIENT");
        SHOW_ALL_MONEY_OF_CLIENT.setBounds(190, 470, 375, 50);
        SHOW_ALL_MONEY_OF_CLIENT.setFont(BUTTONS_FONT);
        backgroundLabel.add(SHOW_ALL_MONEY_OF_CLIENT);
        SHOW_ALL_MONEY_OF_CLIENT.setFocusable(false);
        SHOW_ALL_MONEY_OF_CLIENT.addActionListener(this);
        SHOW_ALL_MONEY_OF_CLIENT.setBackground(Color.LIGHT_GRAY);
        SHOW_ALL_MONEY_OF_CLIENT.setForeground(Color.WHITE);
//*****************SHOW ALL PERSON BUTTON***************
        SHOW_ALL_MONEY_BUTTON = new JButton(" TOTAL MONEY IN A BANK");
        SHOW_ALL_MONEY_BUTTON.setBounds(190, 410, 375, 50);
        SHOW_ALL_MONEY_BUTTON.setFont(BUTTONS_FONT);
        backgroundLabel.add(SHOW_ALL_MONEY_BUTTON);
        SHOW_ALL_MONEY_BUTTON.setFocusable(false);
        SHOW_ALL_MONEY_BUTTON.addActionListener(this);
        SHOW_ALL_MONEY_BUTTON.setBackground(Color.LIGHT_GRAY);
        SHOW_ALL_MONEY_BUTTON.setForeground(Color.WHITE);
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
        } else if (e.getSource()==ADD_ACCOUNT_BUTTON) {
            frame.dispose();
            OPEN_ACCOUNT_GUI open_account_gui=new OPEN_ACCOUNT_GUI();
        } else if (e.getSource()==DELETE_ACCOUNT_BUTTON) {
            DELETE_ACCOUNT_GUI delete_account_gui=new DELETE_ACCOUNT_GUI();
            frame.dispose();
        } else if (e.getSource()==DEPOSIT_MONEY_BUTTON) {
            DEPOSIT_MONEY_GUI deposit_money_gui=new DEPOSIT_MONEY_GUI();
        } else if (e.getSource()==WITHDRAW_MONEY_BUTTON) {
            WITHDRAW_MONEY_GUI withdraw_money_gui=new WITHDRAW_MONEY_GUI();
        } else if (e.getSource()==SEARCH_ACCOUNT_BUTTON) {
            SEARCH_ACCOUNT_GUI search_account_gui=new SEARCH_ACCOUNT_GUI();
            frame.dispose();
        } else if (e.getSource()==SHOW_ALL_ACCOUNT_BUTTON) {
            Account account=new Account();
            account.LOAD_ACCOUNTS_DATA_FROM_FILE();
            ArrayList<Account> accounts_list=account.GET_ACCOUNT_LIST();
            SHOW_ALL_ACCOUNTS_GUI show_all_accounts_gui=new SHOW_ALL_ACCOUNTS_GUI(accounts_list);
        } else if (e.getSource()==SHOW_ALL_MONEY_OF_CLIENT) {
            SHOW_TOTAL_MONEY_OF_CLIENT_GUI show_total_money_of_client_gui=new SHOW_TOTAL_MONEY_OF_CLIENT_GUI();
        } else if (e.getSource()==SHOW_ALL_MONEY_BUTTON) {
            SHOW_TOTAL_MONEY_GUI show_total_money_gui=new SHOW_TOTAL_MONEY_GUI();
        }
    }
}
class OPEN_ACCOUNT_GUI implements ActionListener{
//    Account account=new Account();
    JFrame frame;
    JLabel l1;
    Container c;
    TextField CLIENT_ID_TO_SEARCH_CLIENT;
    JTextArea SEARCHED_ACCOUNT;
    JScrollPane scrollPane;

    JButton OPEN_ACCOUNT_BUTTON,BACK_BUTTON;
    public OPEN_ACCOUNT_GUI(){
        frame = new JFrame();
        frame.setTitle("OPEN ACCOUNT");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(150, 50, 770, 540);
        frame.setVisible(true);
        c = frame.getContentPane();

        String imagePath = "C:\\Users\\Public\\untitled\\src\\BANK_MANAGEMEMNT_SYSYTEM\\ACCOUNT_GUI.png";
        ImageIcon backgroundImage = resizeImageIcon(imagePath, 760, 550);
        JLabel backgroundLabel = new JLabel(backgroundImage);
        c.add(backgroundLabel);

        l1 = new JLabel("Enter Client ID: ");
        l1.setBounds(40, 72, 270, 50);
        backgroundLabel.add(l1);
        Color customColor = new Color(5, 19, 1);
        l1.setForeground(customColor);
        Font f = new Font("Arial", Font.BOLD, 28);
        l1.setFont(f);

        Font f1 = new Font("Arial", Font.PLAIN, 35);
        CLIENT_ID_TO_SEARCH_CLIENT = new TextField();
        CLIENT_ID_TO_SEARCH_CLIENT.setBounds(320, 70, 280, 50);
        backgroundLabel.add(CLIENT_ID_TO_SEARCH_CLIENT);
        CLIENT_ID_TO_SEARCH_CLIENT.setFont(f1);

        OPEN_ACCOUNT_BUTTON = new JButton("Open Account ");
        OPEN_ACCOUNT_BUTTON.setBounds(240, 148, 240, 47);
        Font BUTTONS_FONT = new Font("Arial", Font.BOLD, 25);
        OPEN_ACCOUNT_BUTTON.setFont(BUTTONS_FONT);
        backgroundLabel.add(OPEN_ACCOUNT_BUTTON);
        OPEN_ACCOUNT_BUTTON.setFocusable(false);
        OPEN_ACCOUNT_BUTTON.addActionListener(this);
//************************* BACK_BUTON ************************************
        ImageIcon buttonIcon = new ImageIcon("C:\\Users\\Public\\untitled\\src\\BANK_MANAGEMEMNT_SYSYTEM\\backkkk.png");
        Image img = buttonIcon.getImage();
        Image resizedImage = img.getScaledInstance(115, 115, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        BACK_BUTTON = new JButton("BACK ");
        BACK_BUTTON.setBounds(10, 15, 90, 50);
        BACK_BUTTON.setFont(BUTTONS_FONT);
        BACK_BUTTON.setBorderPainted(false);
        backgroundLabel.add(BACK_BUTTON);
        BACK_BUTTON.setFocusable(false);
        BACK_BUTTON.addActionListener(this);
        BACK_BUTTON.setIcon(resizedIcon);
        SEARCHED_ACCOUNT = new JTextArea();
        SEARCHED_ACCOUNT.setEditable(false);
        scrollPane = new JScrollPane(SEARCHED_ACCOUNT);
        scrollPane.setBounds(40, 210, 680, 250);
        backgroundLabel.add(scrollPane);
        ;
    }
    public static ImageIcon resizeImageIcon(String imagePath, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==BACK_BUTTON){
            ACCOUNT_GUI_ accountGui=new ACCOUNT_GUI_();
        } else if (e.getSource() == OPEN_ACCOUNT_BUTTON) {
            String clientID = CLIENT_ID_TO_SEARCH_CLIENT.getText();
            Client ccc = new Client();
            ccc.LOAD_DATA_FROM_CLIENT_FILE();

            boolean clientExists = false;

            // Check if the client exists in the loaded client list
            for (Client cl : ccc.getCLIENT_LIST()) {
                if (cl.getId().equals(clientID)) {
                    clientExists = true;
                    break;
                }
            }

            if (clientExists) {
                Account account = new Account();
                account.LOAD_ACCOUNTS_DATA_FROM_FILE();
                Client client = null;

                // Find the client object associated with the provided clientID
                for (Client cl : ccc.getCLIENT_LIST()) {
                    if (cl.getId().equals(clientID)) {
                        client = cl;
                        break;
                    }
                }
                if (client != null) {
                    Account newAccount = new Account(client);
                    account.ADD_ACCOUNT(newAccount);
                    account.SAVE_ACCOUNTS_DATA_TO_FILE();

                    String details = "Name: " + client.person.getName() +
                            "\nCNIC: " + client.person.getCNIC() +
                            "\nPhone No: " + client.person.getPhone_Number() +
                            "\nClient ID: " + client.getId() +
                            "\nAccount Number: " + newAccount.ACCOUNT_ID +
                            "\nCurrent Balance: " + newAccount.Amount;
                    SEARCHED_ACCOUNT.setText(details);
                    JOptionPane.showMessageDialog(c, "CONGRATULATIONS!!! Your Account has been Opened " + clientID);
                } else {
                    JOptionPane.showMessageDialog(c, "Error: Client not found with ID: " + clientID);
                }
            } else {
                JOptionPane.showMessageDialog(c, "First add yourself as a Client");
            }
        }

    }
}
class DELETE_ACCOUNT_GUI implements ActionListener{
    JFrame frame;
    Container c;
    JLabel l1;
    JButton SEARCH, BACK_BUTON,DELETE_ACCOUNT_BUTTON;
    JTextArea SEARCHED_ACCOUNT;
    JScrollPane SEARCHED_ACCOUNT_IN_SCROLL_PANE;
    TextField ACCOUNT_NO_TO_SEARCH_ACCOUNT;
    public DELETE_ACCOUNT_GUI(){
        frame = new JFrame();
        frame.setTitle("DELETE ACCOUNT ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(150, 50, 770, 540);
        frame.setVisible(true);
        c = frame.getContentPane();

        String imagePath = "C:\\Users\\Public\\untitled\\src\\BANK_MANAGEMEMNT_SYSYTEM\\PERSON_BANK.png";
        ImageIcon backgroundImage = resizeImageIcon(imagePath, 760, 550);
        JLabel backgroundLabel = new JLabel(backgroundImage);
        c.add(backgroundLabel);

        l1 = new JLabel("Enter Account NO. ");
        l1.setBounds(24, 72, 290, 50);
        backgroundLabel.add(l1);
        Color customColor = new Color(24, 84, 112);
        l1.setForeground(customColor);
        Font f = new Font("Arial", Font.BOLD, 25);
        l1.setFont(f);

        Font f1 = new Font("Arial", Font.PLAIN, 35);
        ACCOUNT_NO_TO_SEARCH_ACCOUNT = new TextField();
        ACCOUNT_NO_TO_SEARCH_ACCOUNT.setBounds(330, 70, 280, 50);
        backgroundLabel.add(ACCOUNT_NO_TO_SEARCH_ACCOUNT);
        ACCOUNT_NO_TO_SEARCH_ACCOUNT.setFont(f1);
//******************** SEARCH BUTTON **********************
        SEARCH = new JButton("Search ");
        SEARCH.setBounds(310, 150, 130, 45);
        Font BUTTONS_FONT = new Font("Arial", Font.BOLD, 25);
        SEARCH.setFont(BUTTONS_FONT);
        backgroundLabel.add(SEARCH);
        SEARCH.setFocusable(false);
        SEARCH.addActionListener(this);

        ImageIcon buttonIcon = new ImageIcon("C:\\Users\\Public\\untitled\\src\\BANK_MANAGEMEMNT_SYSYTEM\\BACK_ARROW.png");
        Image img = buttonIcon.getImage();
        Image resizedImage = img.getScaledInstance(110, 50, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        BACK_BUTON = new JButton("BACK ");
        BACK_BUTON.setBounds(10, 10, 90, 40);
        BACK_BUTON.setFont(BUTTONS_FONT);
        backgroundLabel.add(BACK_BUTON);
        BACK_BUTON.setFocusable(false);
        BACK_BUTON.addActionListener(this);
        BACK_BUTON.setIcon(resizedIcon);


        DELETE_ACCOUNT_BUTTON = new JButton("Close Account ");
        DELETE_ACCOUNT_BUTTON.setBounds(270, 410, 230, 45);
        DELETE_ACCOUNT_BUTTON.setFont(BUTTONS_FONT);
        backgroundLabel.add(DELETE_ACCOUNT_BUTTON);
        DELETE_ACCOUNT_BUTTON.setFocusable(false);
        DELETE_ACCOUNT_BUTTON.addActionListener(this);

        SEARCHED_ACCOUNT = new JTextArea();
        SEARCHED_ACCOUNT.setEditable(false);
        SEARCHED_ACCOUNT_IN_SCROLL_PANE = new JScrollPane(SEARCHED_ACCOUNT);
        SEARCHED_ACCOUNT_IN_SCROLL_PANE.setBounds(110, 230, 550, 150);
        backgroundLabel.add(SEARCHED_ACCOUNT_IN_SCROLL_PANE);
    }
    public static ImageIcon resizeImageIcon(String imagePath, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == BACK_BUTON) {
            ACCOUNT_GUI_ account_gui_ = new ACCOUNT_GUI_();
            frame.dispose();
        } else if (e.getSource() == SEARCH) {
            String accountNumber = ACCOUNT_NO_TO_SEARCH_ACCOUNT.getText();
            Account account = new Account();
            Account found_account = account.SEARCH_ACCOUNT(accountNumber);

            if (found_account != null) {
                SEARCHED_ACCOUNT.append("Name: " + found_account.OWNER.person.getName() + "\n");
                SEARCHED_ACCOUNT.append("CNIC: " + found_account.OWNER.person.getCNIC() + "\n");
                SEARCHED_ACCOUNT.append("Phone No: " + found_account.OWNER.person.getPhone_Number() + "\n");
                SEARCHED_ACCOUNT.append("Client ID: " + found_account.OWNER.getId() + "\n");
                SEARCHED_ACCOUNT.append("Account Number: " + found_account.getACCOUNT_ID() + "\n");
            } else {
                JOptionPane.showMessageDialog(frame, "Account not found!");
            }
        } else if (e.getSource() == DELETE_ACCOUNT_BUTTON) {
            String accountNumber = ACCOUNT_NO_TO_SEARCH_ACCOUNT.getText();
            Account account = new Account();
            Account found_account = account.SEARCH_ACCOUNT(accountNumber);
            if (found_account != null) {
                account.DELETE_ACCOUNT(accountNumber);
                account.LOAD_ACCOUNTS_DATA_FROM_FILE();

                account.SAVE_ACCOUNTS_DATA_TO_FILE();
                JOptionPane.showMessageDialog(frame, "Account deleted successfully!");
                SEARCHED_ACCOUNT.setText("ACCOUNT DELETED ");
            } else {
                JOptionPane.showMessageDialog(frame, "Account not found!");
            }
        }
    }

}
class DEPOSIT_MONEY_GUI implements ActionListener{
    JFrame frame;
    Container c;
    JLabel l1,ENTERED_AMOUNT_LABEL;
    JButton SEARCH, BACK_BUTON,DEPOSIT_MONEY_BUTTON;
    JTextArea SEARCHED_ACCOUNT;
    JScrollPane SEARCHED_ACCOUNT_IN_SCROLL_PANE;
    TextField ACCOUNT_NO_TO_SEARCH_ACCOUNT,ENTERED_AMOUNT;
    public DEPOSIT_MONEY_GUI(){
        frame = new JFrame();
        frame.setTitle("DEPOSIT MONEY ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(150, 50, 770, 540);
        frame.setVisible(true);
        c = frame.getContentPane();

        String imagePath = "C:\\Users\\Public\\untitled\\src\\BANK_MANAGEMEMNT_SYSYTEM\\ACCOUNT_GUI.png";
        ImageIcon backgroundImage = resizeImageIcon(imagePath, 760, 550);
        JLabel backgroundLabel = new JLabel(backgroundImage);
        c.add(backgroundLabel);

        l1 = new JLabel("Enter Account NO. ");
        l1.setBounds(49, 58, 290, 50);
        backgroundLabel.add(l1);
        Color customColor = new Color(231, 170, 14);
        l1.setForeground(customColor);
        Font f = new Font("Arial", Font.BOLD, 25);
        l1.setFont(f);

        ENTERED_AMOUNT_LABEL =new JLabel( "Enter Amount");
        ENTERED_AMOUNT_LABEL.setBounds(49, 370, 280, 50);
        backgroundLabel.add(ENTERED_AMOUNT_LABEL);
        Color customColors = new Color(231, 170, 14);
        ENTERED_AMOUNT_LABEL.setForeground(customColors);
        ENTERED_AMOUNT_LABEL.setFont(f);

        Font f1 = new Font("Arial", Font.PLAIN, 35);
        ACCOUNT_NO_TO_SEARCH_ACCOUNT = new TextField();
        ACCOUNT_NO_TO_SEARCH_ACCOUNT.setBounds(340, 58, 280, 50);
        backgroundLabel.add(ACCOUNT_NO_TO_SEARCH_ACCOUNT);
        ACCOUNT_NO_TO_SEARCH_ACCOUNT.setFont(f1);

        ENTERED_AMOUNT=new TextField();
        ENTERED_AMOUNT = new TextField();
        ENTERED_AMOUNT.setBounds(340, 370, 280, 50);
        backgroundLabel.add(ENTERED_AMOUNT);
        ENTERED_AMOUNT.setFont(f1);
        //******************** SEARCH BUTTON **********************
        SEARCH = new JButton("Search ");
        SEARCH.setBounds(310, 120, 130, 45);
        Font BUTTONS_FONT = new Font("Arial", Font.BOLD, 25);
        SEARCH.setFont(BUTTONS_FONT);
        backgroundLabel.add(SEARCH);
        SEARCH.setFocusable(false);
        SEARCH.addActionListener(this);

        ImageIcon buttonIcon = new ImageIcon("C:\\Users\\Public\\untitled\\src\\BANK_MANAGEMEMNT_SYSYTEM\\backkkk.png");
        Image img = buttonIcon.getImage();
        Image resizedImage = img.getScaledInstance(115, 115, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        BACK_BUTON = new JButton("BACK ");
        BACK_BUTON.setBounds(10, 10, 90, 50);
        BACK_BUTON.setFont(BUTTONS_FONT);
        BACK_BUTON.setBorderPainted(false);
        backgroundLabel.add(BACK_BUTON);
        BACK_BUTON.setFocusable(false);
        BACK_BUTON.setIcon(resizedIcon);
        BACK_BUTON.addActionListener(this);

        DEPOSIT_MONEY_BUTTON = new JButton("Deposit Money ");
        DEPOSIT_MONEY_BUTTON.setBounds(270, 435, 230, 45);
        DEPOSIT_MONEY_BUTTON.setFont(BUTTONS_FONT);
        backgroundLabel.add(DEPOSIT_MONEY_BUTTON);
        DEPOSIT_MONEY_BUTTON.setFocusable(false);
        DEPOSIT_MONEY_BUTTON.addActionListener(this);

        SEARCHED_ACCOUNT = new JTextArea();
        SEARCHED_ACCOUNT.setEditable(false);
        SEARCHED_ACCOUNT_IN_SCROLL_PANE = new JScrollPane(SEARCHED_ACCOUNT);
        SEARCHED_ACCOUNT_IN_SCROLL_PANE.setBounds(110, 180, 550, 150);
        backgroundLabel.add(SEARCHED_ACCOUNT_IN_SCROLL_PANE);
    }
    public static ImageIcon resizeImageIcon(String imagePath, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==BACK_BUTON){
            ACCOUNT_GUI_ account_gui_=new ACCOUNT_GUI_();
        }if ((e.getSource()==SEARCH)){
            String accountNumber = ACCOUNT_NO_TO_SEARCH_ACCOUNT.getText();
            Account account=new Account();
            Account found_account=account.SEARCH_ACCOUNT(accountNumber);
            if (found_account!=null){
                SEARCHED_ACCOUNT.append("Name: " + found_account.OWNER.person.getName() + "\n");
                SEARCHED_ACCOUNT.append("CNIC: " + found_account.OWNER.person.getCNIC() + "\n");
                SEARCHED_ACCOUNT.append("Phone No: " + found_account.OWNER.person.getPhone_Number() + "\n");
                SEARCHED_ACCOUNT.append("Client ID: " + found_account.OWNER.getId() + "\n");
                SEARCHED_ACCOUNT.append("Account Number: " +found_account.getACCOUNT_ID() + "\n");
                SEARCHED_ACCOUNT.append("Current Balance: " +found_account.GET_BALANCE() + "\n");
            }else {
                JOptionPane.showMessageDialog(frame, "Account not found!");
            }
        }
        if (e.getSource()==DEPOSIT_MONEY_BUTTON){
            String accountNumber = ACCOUNT_NO_TO_SEARCH_ACCOUNT.getText();
            int amountToDeposit = Integer.parseInt(ENTERED_AMOUNT.getText());
            Account account=new Account();
            account.LOAD_ACCOUNTS_DATA_FROM_FILE();
            account.DEPOST_MONEY(accountNumber,amountToDeposit);
            account.SAVE_ACCOUNTS_DATA_TO_FILE();
            Account found_account = account.SEARCH_ACCOUNT(accountNumber);
            if (found_account!=null) {
                SEARCHED_ACCOUNT.append("Name: " + found_account.OWNER.person.getName() + "\n");
                SEARCHED_ACCOUNT.append("CNIC: " + found_account.OWNER.person.getCNIC() + "\n");
                SEARCHED_ACCOUNT.append("Phone No: " + found_account.OWNER.person.getPhone_Number() + "\n");
                SEARCHED_ACCOUNT.append("Client ID: " + found_account.OWNER.getId() + "\n");
                SEARCHED_ACCOUNT.append("Account Number: " + found_account.getACCOUNT_ID() + "\n");
                SEARCHED_ACCOUNT.append("Current Balance: " + found_account.GET_BALANCE() + "\n");
            }else {
                JOptionPane.showMessageDialog(frame, "Account not found!");
            }
        }
    }
}
class WITHDRAW_MONEY_GUI implements ActionListener{
    JFrame frame;
    Container c;
    JLabel l1,ENTERED_AMOUNT_LABEL;
    JButton SEARCH, BACK_BUTON,WITHDRAW_MONEY_BUTTON;
    JTextArea SEARCHED_ACCOUNT;
    JScrollPane SEARCHED_ACCOUNT_IN_SCROLL_PANE;
    TextField ACCOUNT_NO_TO_SEARCH_ACCOUNT,ENTERED_AMOUNT;
    public WITHDRAW_MONEY_GUI(){
        frame = new JFrame();
        frame.setTitle("WITHDRAW MONEY ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(150, 50, 770, 540);
        frame.setVisible(true);
        c = frame.getContentPane();

        String imagePath = "C:\\Users\\Public\\untitled\\src\\BANK_MANAGEMEMNT_SYSYTEM\\ACCOUNT_GUI.png";
        ImageIcon backgroundImage = resizeImageIcon(imagePath, 760, 550);
        JLabel backgroundLabel = new JLabel(backgroundImage);
        c.add(backgroundLabel);

        l1 = new JLabel("Enter Account NO. ");
        l1.setBounds(49, 58, 290, 50);
        backgroundLabel.add(l1);
        Color customColor = new Color(231, 170, 14);
        l1.setForeground(customColor);
        Font f = new Font("Arial", Font.BOLD, 25);
        l1.setFont(f);

        ENTERED_AMOUNT_LABEL =new JLabel( "Enter Amount");
        ENTERED_AMOUNT_LABEL.setBounds(49, 370, 280, 50);
        backgroundLabel.add(ENTERED_AMOUNT_LABEL);
        Color customColors = new Color(231, 170, 14);
        ENTERED_AMOUNT_LABEL.setForeground(customColors);
        ENTERED_AMOUNT_LABEL.setFont(f);

        Font f1 = new Font("Arial", Font.PLAIN, 35);
        ACCOUNT_NO_TO_SEARCH_ACCOUNT = new TextField();
        ACCOUNT_NO_TO_SEARCH_ACCOUNT.setBounds(340, 58, 280, 50);
        backgroundLabel.add(ACCOUNT_NO_TO_SEARCH_ACCOUNT);
        ACCOUNT_NO_TO_SEARCH_ACCOUNT.setFont(f1);

        ENTERED_AMOUNT=new TextField();
        ENTERED_AMOUNT = new TextField();
        ENTERED_AMOUNT.setBounds(340, 370, 280, 50);
        backgroundLabel.add(ENTERED_AMOUNT);
        ENTERED_AMOUNT.setFont(f1);
        //******************** SEARCH BUTTON **********************
        SEARCH = new JButton("Search ");
        SEARCH.setBounds(310, 120, 130, 45);
        Font BUTTONS_FONT = new Font("Arial", Font.BOLD, 25);
        SEARCH.setFont(BUTTONS_FONT);
        backgroundLabel.add(SEARCH);
        SEARCH.setFocusable(false);
        SEARCH.addActionListener(this);

        ImageIcon buttonIcon = new ImageIcon("C:\\Users\\Public\\untitled\\src\\BANK_MANAGEMEMNT_SYSYTEM\\backkkk.png");
        Image img = buttonIcon.getImage();
        Image resizedImage = img.getScaledInstance(115, 115, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        BACK_BUTON = new JButton("BACK ");
        BACK_BUTON.setBounds(10, 10, 90, 50);
        BACK_BUTON.setFont(BUTTONS_FONT);
        BACK_BUTON.setBorderPainted(false);
        backgroundLabel.add(BACK_BUTON);
        BACK_BUTON.setFocusable(false);
        BACK_BUTON.addActionListener(this);
        BACK_BUTON.setIcon(resizedIcon);

        WITHDRAW_MONEY_BUTTON = new JButton("Withdraw Money ");
        WITHDRAW_MONEY_BUTTON.setBounds(270, 435, 240, 45);
        WITHDRAW_MONEY_BUTTON.setFont(BUTTONS_FONT);
        backgroundLabel.add(WITHDRAW_MONEY_BUTTON);
        WITHDRAW_MONEY_BUTTON.setFocusable(false);
        WITHDRAW_MONEY_BUTTON.addActionListener(this);

        SEARCHED_ACCOUNT = new JTextArea();
        SEARCHED_ACCOUNT.setEditable(false);
        SEARCHED_ACCOUNT_IN_SCROLL_PANE = new JScrollPane(SEARCHED_ACCOUNT);
        SEARCHED_ACCOUNT_IN_SCROLL_PANE.setBounds(110, 180, 550, 150);
        backgroundLabel.add(SEARCHED_ACCOUNT_IN_SCROLL_PANE);
    }
    public static ImageIcon resizeImageIcon(String imagePath, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==BACK_BUTON){
            ACCOUNT_GUI_ account_gui_=new ACCOUNT_GUI_();
        }if ((e.getSource()==SEARCH)){
            String accountNumber = ACCOUNT_NO_TO_SEARCH_ACCOUNT.getText();
            Account account=new Account();
            Account found_account=account.SEARCH_ACCOUNT(accountNumber);
            if (found_account!=null){
                SEARCHED_ACCOUNT.append("Name: " + found_account.OWNER.person.getName() + "\n");
                SEARCHED_ACCOUNT.append("CNIC: " + found_account.OWNER.person.getCNIC() + "\n");
                SEARCHED_ACCOUNT.append("Phone No: " + found_account.OWNER.person.getPhone_Number() + "\n");
                SEARCHED_ACCOUNT.append("Client ID: " + found_account.OWNER.getId() + "\n");
                SEARCHED_ACCOUNT.append("Account Number: " +found_account.getACCOUNT_ID() + "\n");
                SEARCHED_ACCOUNT.append("Current Balance: " +found_account.GET_BALANCE() + "\n");
            }else {
                JOptionPane.showMessageDialog(frame, "Account not found!");
            }
        }
        if (e.getSource()==WITHDRAW_MONEY_BUTTON){
            String accountNumber = ACCOUNT_NO_TO_SEARCH_ACCOUNT.getText();
            int amountToWithdraw = Integer.parseInt(ENTERED_AMOUNT.getText());
            Account account=new Account();
            account.LOAD_ACCOUNTS_DATA_FROM_FILE();
            account.WITHDRAW_MONEY(accountNumber,amountToWithdraw);
            account.SAVE_ACCOUNTS_DATA_TO_FILE();
            Account found_account = account.SEARCH_ACCOUNT(accountNumber);
            if (found_account!=null) {
                int currentBalance = found_account.GET_BALANCE();
                if (amountToWithdraw > currentBalance) {
                    JOptionPane.showMessageDialog(frame, "Withdrawal amount exceeds the current balance!");
                } else {
                    account.WITHDRAW_MONEY(accountNumber, amountToWithdraw);
                    account.SAVE_ACCOUNTS_DATA_TO_FILE();
                    SEARCHED_ACCOUNT.append("Name: " + found_account.OWNER.person.getName() + "\n");
                    SEARCHED_ACCOUNT.append("CNIC: " + found_account.OWNER.person.getCNIC() + "\n");
                    SEARCHED_ACCOUNT.append("Phone No: " + found_account.OWNER.person.getPhone_Number() + "\n");
                    SEARCHED_ACCOUNT.append("Client ID: " + found_account.OWNER.getId() + "\n");
                    SEARCHED_ACCOUNT.append("Account Number: " + found_account.getACCOUNT_ID() + "\n");
                    SEARCHED_ACCOUNT.append("Current Balance: " + found_account.GET_BALANCE() + "\n");
                }
            }else {
                JOptionPane.showMessageDialog(frame, "Account not found!");
            }
        }
    }
}
class  SEARCH_ACCOUNT_GUI implements ActionListener{
    JFrame frame;
    Container c;
    JLabel l1;
    JButton SEARCH, BACK_BUTON;
    JTextArea SEARCHED_ACCOUNT;
    JScrollPane SEARCHED_ACCOUNT_IN_SCROLL_PANE;
    TextField ACCOUNT_NO_TO_SEARCH_ACCOUNT;
    public SEARCH_ACCOUNT_GUI(){
        frame = new JFrame();
        frame.setTitle("SEARCH ACCOUNT ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(150, 50, 770, 540);
        frame.setVisible(true);
        c = frame.getContentPane();

        String imagePath = "C:\\Users\\Public\\untitled\\src\\BANK_MANAGEMEMNT_SYSYTEM\\PERSON_BANK.png";
        ImageIcon backgroundImage = resizeImageIcon(imagePath, 760, 550);
        JLabel backgroundLabel = new JLabel(backgroundImage);
        c.add(backgroundLabel);

        l1 = new JLabel("Enter Account NO. ");
        l1.setBounds(24, 72, 290, 50);
        backgroundLabel.add(l1);
        Color customColor = new Color(24, 84, 112);
        l1.setForeground(customColor);
        Font f = new Font("Arial", Font.BOLD, 25);
        l1.setFont(f);

        Font f1 = new Font("Arial", Font.PLAIN, 35);
        ACCOUNT_NO_TO_SEARCH_ACCOUNT = new TextField();
        ACCOUNT_NO_TO_SEARCH_ACCOUNT.setBounds(330, 70, 280, 50);
        backgroundLabel.add(ACCOUNT_NO_TO_SEARCH_ACCOUNT);
        ACCOUNT_NO_TO_SEARCH_ACCOUNT.setFont(f1);
//******************** SEARCH BUTTON **********************
        SEARCH = new JButton("Search ");
        SEARCH.setBounds(310, 150, 130, 45);
        Font BUTTONS_FONT = new Font("Arial", Font.BOLD, 25);
        SEARCH.setFont(BUTTONS_FONT);
        backgroundLabel.add(SEARCH);
        SEARCH.setFocusable(false);
        SEARCH.addActionListener(this);
//********************  BACK BUTTON **********************
        ImageIcon buttonIcon = new ImageIcon("C:\\Users\\Public\\untitled\\src\\BANK_MANAGEMEMNT_SYSYTEM\\BACK_ARROW.png");
        Image img = buttonIcon.getImage();
        Image resizedImage = img.getScaledInstance(110, 50, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        BACK_BUTON = new JButton("Back");
        BACK_BUTON.setBounds(10, 10, 90, 40);
        BACK_BUTON.setFont(BUTTONS_FONT);
        backgroundLabel.add(BACK_BUTON);
        BACK_BUTON.setFocusable(false);
        BACK_BUTON.setIcon(resizedIcon);
        BACK_BUTON.addActionListener(this);

        SEARCHED_ACCOUNT = new JTextArea();
        SEARCHED_ACCOUNT.setEditable(false);
        SEARCHED_ACCOUNT_IN_SCROLL_PANE = new JScrollPane(SEARCHED_ACCOUNT);
        SEARCHED_ACCOUNT_IN_SCROLL_PANE.setBounds(110, 230, 550, 150);
        backgroundLabel.add(SEARCHED_ACCOUNT_IN_SCROLL_PANE);
    }
    public static ImageIcon resizeImageIcon(String imagePath, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==BACK_BUTON){
            ACCOUNT_GUI_ account_gui_=new ACCOUNT_GUI_();
            frame.dispose();
        } else if (e.getSource() == SEARCH) {
            String accountNumber = ACCOUNT_NO_TO_SEARCH_ACCOUNT.getText();
            Account account=new Account();
            Account found_account=account.SEARCH_ACCOUNT(accountNumber);
            if (found_account!=null){
                SEARCHED_ACCOUNT.append("Name: " + found_account.OWNER.person.getName() + "\n");
                SEARCHED_ACCOUNT.append("CNIC: " + found_account.OWNER.person.getCNIC() + "\n");
                SEARCHED_ACCOUNT.append("Phone No: " + found_account.OWNER.person.getPhone_Number() + "\n");
                SEARCHED_ACCOUNT.append("Client ID: " + found_account.OWNER.getId() + "\n");
                SEARCHED_ACCOUNT.append("Account Number: " +found_account.getACCOUNT_ID() + "\n");
                SEARCHED_ACCOUNT.append("Current Balance: " +found_account.GET_BALANCE() + "\n");
            }else {
                JOptionPane.showMessageDialog(frame, "Account not found!");
            }
        }
    }
}
class SHOW_ALL_ACCOUNTS_GUI implements ActionListener{
    JFrame frame;
    Container c;
    JTextArea ACCOUNTS_TEXT_AREA;
    JButton BACK_BUTTON;
    public SHOW_ALL_ACCOUNTS_GUI(ArrayList<Account> ACCOUNTLST){
        frame = new JFrame();
        frame.setTitle("ALL ACCOUNTS DATA");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(150, 50, 770, 540);
        frame.setVisible(true);
        c = frame.getContentPane();

        String imagePath = "C:\\Users\\Public\\untitled\\src\\BANK_MANAGEMEMNT_SYSYTEM\\CLIENT_GUI.png";
        ImageIcon backgroundImage = resizeImageIcon(imagePath, 760, 550);
        JLabel backgroundLabel = new JLabel(backgroundImage);
        c.add(backgroundLabel);
        ImageIcon buttonIcon = new ImageIcon("C:\\Users\\Public\\untitled\\src\\BANK_MANAGEMEMNT_SYSYTEM\\BACK_ARROW.png");
        Image img = buttonIcon.getImage();
        Image resizedImage = img.getScaledInstance(110, 50, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        BACK_BUTTON = new JButton("BACK ");
        BACK_BUTTON.setBounds(10, 10, 90, 40);
        Font BUTTONS_FONT = new Font("Arial", Font.BOLD, 25);
        BACK_BUTTON.setFont(BUTTONS_FONT);
        backgroundLabel.add(BACK_BUTTON);
        BACK_BUTTON.setFocusable(false);
        BACK_BUTTON.addActionListener(this);
        BACK_BUTTON.setIcon(resizedIcon);
        ACCOUNTS_TEXT_AREA = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(ACCOUNTS_TEXT_AREA);
        ACCOUNTS_TEXT_AREA.setEditable(false);
        scrollPane.setBounds(50, 100, 660, 350);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        backgroundLabel.add(scrollPane);
        displayAllACCOUNT(ACCOUNTLST);
    }
    public static ImageIcon resizeImageIcon(String imagePath, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }
    private void displayAllACCOUNT(ArrayList<Account> ACCOUNTLST) {
        if (ACCOUNTLST != null && !ACCOUNTLST.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Account acc : ACCOUNTLST) {
                sb.append(acc.toString()).append("\n\n");
            }
            ACCOUNTS_TEXT_AREA.setText(sb.toString());
        } else {
            ACCOUNTS_TEXT_AREA.setText("NO ACCOUNTS YET.");
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==BACK_BUTTON){
            ACCOUNT_GUI_ account_gui_=new ACCOUNT_GUI_();
        }
    }
}
class SHOW_TOTAL_MONEY_OF_CLIENT_GUI implements ActionListener{
    JFrame frame;
    Container c;
    JLabel l1;
    JButton SEARCH, BACK_BUTON;
    JTextArea SEARCHED_ACCOUNT;
    JScrollPane SEARCHED_ACCOUNT_IN_SCROLL_PANE;
    TextField ACCOUNT_NO_TO_SEARCH_ACCOUNT;
    public  SHOW_TOTAL_MONEY_OF_CLIENT_GUI(){
        frame = new JFrame();
        frame.setTitle("SEARCH ACCOUNT ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(150, 50, 770, 540);
        frame.setVisible(true);
        c = frame.getContentPane();

        String imagePath = "C:\\Users\\Public\\untitled\\src\\BANK_MANAGEMEMNT_SYSYTEM\\ACCOUNT_GUI.png";
        ImageIcon backgroundImage = resizeImageIcon(imagePath, 760, 550);
        JLabel backgroundLabel = new JLabel(backgroundImage);
        c.add(backgroundLabel);

        l1 = new JLabel("Enter Client ID");
        l1.setBounds(24, 72, 290, 50);
        backgroundLabel.add(l1);
        Color customColor = new Color(24, 84, 112);
        l1.setForeground(customColor);
        Font f = new Font("Arial", Font.BOLD, 25);
        l1.setFont(f);

        Font f1 = new Font("Arial", Font.PLAIN, 35);
        ACCOUNT_NO_TO_SEARCH_ACCOUNT = new TextField();
        ACCOUNT_NO_TO_SEARCH_ACCOUNT.setBounds(330, 70, 280, 50);
        backgroundLabel.add(ACCOUNT_NO_TO_SEARCH_ACCOUNT);
        ACCOUNT_NO_TO_SEARCH_ACCOUNT.setFont(f1);
//******************** SEARCH BUTTON **********************
        SEARCH = new JButton("Search ");
        SEARCH.setBounds(310, 150, 130, 45);
        Font BUTTONS_FONT = new Font("Arial", Font.BOLD, 25);
        SEARCH.setFont(BUTTONS_FONT);
        backgroundLabel.add(SEARCH);
        SEARCH.setFocusable(false);
        SEARCH.addActionListener(this);
//********************  BACK BUTTON **********************
        ImageIcon buttonIcon = new ImageIcon("C:\\Users\\Public\\untitled\\src\\BANK_MANAGEMEMNT_SYSYTEM\\backkkk.png");
        Image img = buttonIcon.getImage();
        Image resizedImage = img.getScaledInstance(110, 50, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        BACK_BUTON = new JButton("Back");
        BACK_BUTON.setBounds(10, 10, 80, 40);
        BACK_BUTON.setFont(BUTTONS_FONT);
        backgroundLabel.add(BACK_BUTON);
        BACK_BUTON.setFocusable(false);
        BACK_BUTON.addActionListener(this);
        BACK_BUTON.setIcon(resizedIcon);

        SEARCHED_ACCOUNT = new JTextArea();
        SEARCHED_ACCOUNT.setEditable(false);
        Font textFont = new Font("Arial", Font.PLAIN, 18);
        SEARCHED_ACCOUNT.setFont(textFont);
        SEARCHED_ACCOUNT_IN_SCROLL_PANE = new JScrollPane(SEARCHED_ACCOUNT);
        SEARCHED_ACCOUNT_IN_SCROLL_PANE.setBounds(110, 230, 550, 150);
        backgroundLabel.add(SEARCHED_ACCOUNT_IN_SCROLL_PANE);
    }
    public static ImageIcon resizeImageIcon(String imagePath, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==BACK_BUTON){
            ACCOUNT_GUI_ account_gui_=new ACCOUNT_GUI_();
        }if (e.getSource()==SEARCH) {
            String CLIENT_ID = ACCOUNT_NO_TO_SEARCH_ACCOUNT.getText();
            Account account = new Account();
            account.LOAD_ACCOUNTS_DATA_FROM_FILE();
            String clientMoneyDetails = account.SHOW_TOTAL_MONEY_OF_ALL_ACCOUNTS(CLIENT_ID);
            SEARCHED_ACCOUNT.setText(clientMoneyDetails);
        }
    }
}
class SHOW_TOTAL_MONEY_GUI implements ActionListener{
    JFrame frame;
    Container c;
    JTextArea ACCOUNTS_TEXT_AREA;
    JButton BACK_BUTTON;
    public SHOW_TOTAL_MONEY_GUI(){
        frame = new JFrame();
        frame.setTitle("ALL ACCOUNTS DATA");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(150, 50, 770, 540);
        frame.setVisible(true);
        c = frame.getContentPane();

        String imagePath = "C:\\Users\\Public\\untitled\\src\\BANK_MANAGEMEMNT_SYSYTEM\\ACCOUNT_GUI.png";
        ImageIcon backgroundImage = resizeImageIcon(imagePath, 760, 550);
        JLabel backgroundLabel = new JLabel(backgroundImage);
        c.add(backgroundLabel);
        ImageIcon buttonIcon = new ImageIcon("C:\\Users\\Public\\untitled\\src\\BANK_MANAGEMEMNT_SYSYTEM\\backkkk.png");
        Image img = buttonIcon.getImage();
        Image resizedImage = img.getScaledInstance(110, 50, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        BACK_BUTTON = new JButton("BACK ");
        BACK_BUTTON.setBounds(10, 10, 80, 40);
        Font BUTTONS_FONT = new Font("Arial", Font.BOLD, 25);
        BACK_BUTTON.setFont(BUTTONS_FONT);
        backgroundLabel.add(BACK_BUTTON);
        BACK_BUTTON.setFocusable(false);
        BACK_BUTTON.setIcon(resizedIcon);
        BACK_BUTTON.addActionListener(this);

        ACCOUNTS_TEXT_AREA = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(ACCOUNTS_TEXT_AREA);
        Font textFont = new Font("Arial", Font.PLAIN, 30);
        ACCOUNTS_TEXT_AREA.setFont(textFont);
        ACCOUNTS_TEXT_AREA.setEditable(false);
        scrollPane.setBounds(50, 200, 660, 110);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        backgroundLabel.add(scrollPane);

        Account account=new Account();
        account.LOAD_ACCOUNTS_DATA_FROM_FILE();
        int TOTAL_MONEY=account.SHOW_ALL_MONEY();
        ACCOUNTS_TEXT_AREA.setText("\n            Total Money in Bank: $" +TOTAL_MONEY);
    }
    public static ImageIcon resizeImageIcon(String imagePath, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
            if (e.getSource()==BACK_BUTTON){
                ACCOUNT_GUI_ account_gui_=new ACCOUNT_GUI_();
            }
    }
}
public class ACCOUNT_GUI {
    public static void main(String[] args) {
        ACCOUNT_GUI_ account_gui=new ACCOUNT_GUI_();
    }
}
