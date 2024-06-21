package BANK_MANAGEMEMNT_SYSYTEM;
import java.io.Serializable;
import java.io.*;
import java.util.ArrayList;
public class Account implements Serializable {
    int Amount;
    Client client;
    PERSON person;
    String ACCOUNT_ID;
    static int count = 1;
    Client OWNER;
    ArrayList<Account> ACCOUNTS_LIST=new ArrayList<>();
    private static final String FILE_NAME="ACCOUNTS_DATA.dat";
    public Account(Client client){
        this.Amount=Amount;
        this.OWNER=client;
        this.ACCOUNT_ID="A"+count;
        System.out.println("\u001B[35mYOUR ACCOUNT NUMBER IS \u001B[0m"+ACCOUNT_ID);
        count++;
    }
    public ArrayList<Account> GET_ACCOUNT_LIST(){
        return ACCOUNTS_LIST;
    }
    public String getACCOUNT_ID(){
        return ACCOUNT_ID;
    }
    public int GET_BALANCE(){
        return Amount;
    }
    public Account(){
    }
    public void ADD_ACCOUNT(Account OPEN_ACCOUNT_BY_THEIR_ID){
        Client ccc=new Client();
        ccc.LOAD_DATA_FROM_CLIENT_FILE();
        ACCOUNTS_LIST.add(OPEN_ACCOUNT_BY_THEIR_ID);
        SAVE_ACCOUNTS_DATA_TO_FILE();
        System.out.println("\u001B[1m\u001B[33mCONGRATULATIONS!YOUR ACCOUNT HAS BEEN OPENED\u001B[0m\u001B[0m");
    }
    //**********************************SEARCH CLIENT TO DELETE ACCOUNT**********************************************************
    public ArrayList<Account> SEARCH_ACCOUNTS_WITH_ID(String CLIENT_ID) {
        Client clients=new Client();
        clients.LOAD_DATA_FROM_CLIENT_FILE();
        LOAD_ACCOUNTS_DATA_FROM_FILE();
        ArrayList<Account> SAME_MATCHING_ACCOUNTS = new ArrayList<>();
        for (Account ACCC : ACCOUNTS_LIST) {
            if (ACCC.OWNER.getId().equals(CLIENT_ID)) {
                SAME_MATCHING_ACCOUNTS.add(ACCC);
            }
//            if (SAME_MATCHING_ACCOUNTS.isEmpty()){
//                System.out.println("\u001B[31mCLIENT WITH ID \u001B[0m"+CLIENT_ID+"\u001B[31m HAVE NO ACCOUNT\u001B[0m");
//            }
        }
        SAVE_ACCOUNTS_DATA_TO_FILE();
        return SAME_MATCHING_ACCOUNTS;
    }
    //********************************SEARCH ACCOUNT TO DELETE WITH PERSON*****************************************************
    public ArrayList<Account> SEARACH_ACCOUNT_TO_DELETE_WITH_PERSON(String CNIC){
        LOAD_ACCOUNTS_DATA_FROM_FILE();
//        LOAD_DATA_FROM_ACCOUNT_LIST();
        ArrayList<Account> SAME_MATCHING_ACCOUNTS = new ArrayList<>();
        for (Account ACCCC:ACCOUNTS_LIST){
            if (ACCCC.OWNER.person.getCNIC().equals(CNIC)){
                SAME_MATCHING_ACCOUNTS.add(ACCCC);
            }
            if (SAME_MATCHING_ACCOUNTS.isEmpty()){
                System.out.println("\u001B[31mPERSON WITH CNIC \u001B[0m"+CNIC+"\u001B[31m HAVE NO ACCOUNT\u001B[0m");
            }
        }
        SAVE_ACCOUNTS_DATA_TO_FILE();
//        SAVE_DATA_TO_ACCOUNT_LIST();
        return SAME_MATCHING_ACCOUNTS;
    }
    //******************************DELETE ACCOUNT TO DELETE WITH PERSON BY CNIC*************************************************
    public void DELTE_ACCOUNT_TO_DELTE_WITH_PERSON(String CNIC){
        LOAD_ACCOUNTS_DATA_FROM_FILE();
//        LOAD_DATA_FROM_ACCOUNT_LIST();
        ArrayList<Account> accountsToDelete = SEARACH_ACCOUNT_TO_DELETE_WITH_PERSON(CNIC);
        if (!accountsToDelete.isEmpty()) {
            for (Account account : accountsToDelete) {
//                String accountID = account.ACCOUNT_ID;
                 ACCOUNTS_LIST.remove(account);
//                ACCOUNTS_LIST.remove(accountID);
//                int amount = account.Amount;
            }
            SAVE_ACCOUNTS_DATA_TO_FILE();
        }
        else {
            System.out.println("\u001B[31mPERSON WITH CNIC: \u001B[0m" + CNIC+"\u001B[31m HAVE NO ACCOUNT\u001B[0m");
        }
    }
    //*****************************DELETE ACCOUNT WITH CLIENT BY CLIENT  ID******************************************************
    public void DELETE_ACCOUNTS_WITH_CLIENT(String CLIENT_ID) {
        LOAD_ACCOUNTS_DATA_FROM_FILE();
        ArrayList<Account> accountsToDelete = SEARCH_ACCOUNTS_WITH_ID(CLIENT_ID);

        if (!accountsToDelete.isEmpty()) {
            for (Account account : accountsToDelete) {
                ACCOUNTS_LIST.remove(account);
            }
            SAVE_ACCOUNTS_DATA_TO_FILE();
            System.out.println("\u001B[33mACCOUNTS HAVE ALSO BEEN DELETED\u001B[0m");
        } else {
            System.out.println("\u001B[31mNO ACCOUNTS FOUND FOR CLIENT ID: \u001B[0m" + CLIENT_ID);
        }
    }
    //*********************************DELETE ACCOUNT BY ACCOUNT NUMBER**********************************************************
    public void DELETE_ACCOUNT(String ACCOUNT_ID) {
        LOAD_ACCOUNTS_DATA_FROM_FILE();
        Account ACCOUNT_TO_REMOVE = null;
        for (Account acc : ACCOUNTS_LIST) {
            if (acc.getACCOUNT_ID().equals(ACCOUNT_ID)) {
                ACCOUNT_TO_REMOVE = acc;
                break;
            }
        }
        if (ACCOUNT_TO_REMOVE != null) {
            ACCOUNTS_LIST.remove(ACCOUNT_TO_REMOVE);
            SAVE_ACCOUNTS_DATA_TO_FILE();
            System.out.println("Account " + ACCOUNT_ID + " has been deleted successfully");
        } else {
            System.out.println("Account with ID " + ACCOUNT_ID + " not found");
        }
    }


    public void DEPOST_MONEY(String ACCOUNT_NUMBER,int AMOUNT){
        LOAD_ACCOUNTS_DATA_FROM_FILE();
        boolean ACCOUNT_FOUND = false;
        for (Account ACCC:ACCOUNTS_LIST) {
            if (ACCC.ACCOUNT_ID.equals(ACCOUNT_NUMBER)) {
                ACCC.Amount += AMOUNT;
                SAVE_ACCOUNTS_DATA_TO_FILE();
                System.out.println("$" + AMOUNT + "\u001B[33m HAS BEEN DEPOSITED IN ACCOUNT \u001B[0m" + ACCOUNT_NUMBER + "\n\u001B[33mNEW BALANCE:\u001B[0m $" + ACCC.Amount);
                ACCOUNT_FOUND = true;
                break;
            }
        }
        if (!ACCOUNT_FOUND){
            System.out.println("\u001B[31mACCOUNT \u001B[0m"+ACCOUNT_NUMBER+"\u001B[31m NOT FOUND\u001B[0m");
        }
    }
    public void WITHDRAW_MONEY(String ACCOUNT_NUMBER, int AMOUNT) {
        LOAD_ACCOUNTS_DATA_FROM_FILE();
        boolean ACCOUNT_FND = false;

        for (Account ACCC : ACCOUNTS_LIST) {
            if (ACCC.ACCOUNT_ID.equals(ACCOUNT_NUMBER)) {
                ACCOUNT_FND = true;
                if (ACCC.Amount >= AMOUNT) {
                    ACCC.Amount = ACCC.Amount - AMOUNT;
                    SAVE_ACCOUNTS_DATA_TO_FILE();
                    System.out.println("$" + AMOUNT + "\u001B[33m HAS BEEN WITHDRAWN FROM ACCOUNT \u001B[0m" + ACCOUNT_NUMBER + "\n\u001B[33mREMAINING BALANCE:\u001B[0m $" + ACCC.Amount);
                } else {
                    System.out.println("\u001B[31mYOUR CURRENT BALANCE IS LESS THAN \u001B[0m" + AMOUNT);
                }
            }
        }
        if (!ACCOUNT_FND) {
            System.out.println("\u001B[31mACCOUNT \u001B[0m" + ACCOUNT_NUMBER + "\u001B[31m NOT FOUND\u001B[0m");
        }
    }

    public int SHOW_ALL_MONEY() {
        LOAD_ACCOUNTS_DATA_FROM_FILE();
        int TOTAL_MONEY_IN_BANK = 0;
        for (Account ACCC : ACCOUNTS_LIST) {
            TOTAL_MONEY_IN_BANK += ACCC.Amount;
        }
        System.out.println("\u001B[1m\u001B[33mBANK HAS\u001B[0m $" + TOTAL_MONEY_IN_BANK + "\u001B[33m MONEY\u001B[0m\u001B[0m");
        return TOTAL_MONEY_IN_BANK;
    }
    public  Account SEARCH_ACCOUNT(String ACCOUNT_NUMBER){
        LOAD_ACCOUNTS_DATA_FROM_FILE();
        for (Account accccc:ACCOUNTS_LIST){
            if(accccc.ACCOUNT_ID.equals(ACCOUNT_NUMBER)){
                return accccc;
            }
            else {
                System.out.println("\u001B[31mACCOUNT NOT FOUND\u001B[0m");
            }
        }
        return null;
    }
    public void SHOW_ALL_ACCOUNTS() {
        LOAD_ACCOUNTS_DATA_FROM_FILE();
//        LOAD_DATA_FROM_ACCOUNT_LIST();
        if (ACCOUNTS_LIST.isEmpty()) {
            System.out.println("\u001B[31mNO ACCOUNTS YET\u001B[0m");
        } else {
            for (Account ACCC : ACCOUNTS_LIST) {
                System.out.println(ACCC);
            }
        }
    }
    public int SHOW_MONEY_OF_ALL_ACCOUNTS(String CLIENT_ID) {
        LOAD_ACCOUNTS_DATA_FROM_FILE();
        ArrayList<Account> SAME_ACCOUNTS_TOTAL_MONEY = new ArrayList<>();
        boolean foundClient = false;

        for (Account ACCC : ACCOUNTS_LIST) {
            if (ACCC.OWNER.getId().equals(CLIENT_ID)) {
                SAME_ACCOUNTS_TOTAL_MONEY.add(ACCC);
                foundClient = true;
            }
        }

        if (!foundClient) {
            System.out.println("\u001B[31mCLIENT WITH ID \u001B[0m" + CLIENT_ID + "\u001B[31m NOT FOUND\u001B[0m");
            return 0; // Return 0 as the client ID wasn't found
        }

        int TOTAL_AMOUNT = 0;
        for (Account MONEY_OF_BOTH_ACCOUNTS : SAME_ACCOUNTS_TOTAL_MONEY) {
            if (MONEY_OF_BOTH_ACCOUNTS.Amount != 0) {
                TOTAL_AMOUNT += MONEY_OF_BOTH_ACCOUNTS.Amount;
            } else {
                System.out.println("\u001B[31mYOUR ACCOUNT HAS $0\u001B[0m");
            }
        }

        System.out.println("\u001B[33mTOTAL MONEY IN YOUR ACCOUNTS IS:\u001B[0m $" + TOTAL_AMOUNT);
        return TOTAL_AMOUNT; // Return the total amount
    }
    public String SHOW_TOTAL_MONEY_OF_ALL_ACCOUNTS(String CLIENT_ID) {
        LOAD_ACCOUNTS_DATA_FROM_FILE();
        ArrayList<Account> SAME_ACCOUNTS_TOTAL_MONEY = new ArrayList<>();
        boolean foundClient = false;

        for (Account ACCC : ACCOUNTS_LIST) {
            if (ACCC.OWNER.getId().equals(CLIENT_ID)) {
                SAME_ACCOUNTS_TOTAL_MONEY.add(ACCC);
                foundClient = true;
            }
        }
        if (!foundClient) {
            return "Client with ID " + CLIENT_ID + " not found";
        }
        StringBuilder clientMoneyDetails = new StringBuilder();
        int totalAmount = 0;

        for (Account MONEY_OF_BOTH_ACCOUNTS : SAME_ACCOUNTS_TOTAL_MONEY) {
            int accountAmount = MONEY_OF_BOTH_ACCOUNTS.Amount;
            totalAmount += accountAmount;
            clientMoneyDetails.append("Account ").append(MONEY_OF_BOTH_ACCOUNTS.getACCOUNT_ID()).append(" has $").append(accountAmount).append("\n");
        }

        clientMoneyDetails.append("Total Money for Client ID ").append(CLIENT_ID).append(" is $").append(totalAmount);
        return clientMoneyDetails.toString();
    }


    public void SAVE_ACCOUNTS_DATA_TO_FILE(){
        try {
            FileOutputStream fileOutputStream=new FileOutputStream("C:\\Users\\Public\\untitled\\src\\BANK_MANAGEMEMNT_SYSYTEM\\ACCOUNT_DATA.txt");
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(ACCOUNTS_LIST);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void LOAD_ACCOUNTS_DATA_FROM_FILE(){
        try {
            FileInputStream fileInputStream=new FileInputStream("C:\\Users\\Public\\untitled\\src\\BANK_MANAGEMEMNT_SYSYTEM\\ACCOUNT_DATA.txt");
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
            ACCOUNTS_LIST=(ArrayList<Account>) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public int SEARCH_ACCOUNT_FUNCTION_FOR_GUI(String ACCOUNT_NUMBER) {
        LOAD_ACCOUNTS_DATA_FROM_FILE();
        for (int i = 0; i < ACCOUNTS_LIST.size(); i++) {
            if (ACCOUNTS_LIST.get(i).getACCOUNT_ID().equals(ACCOUNT_NUMBER)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return  "\n" + OWNER+
                "\n\tAMOUNT=" + Amount +
                "\n\tACCOUNT_NUMBER=" + ACCOUNT_ID;
    }
}
