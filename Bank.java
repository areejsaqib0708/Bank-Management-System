package BANK_MANAGEMEMNT_SYSYTEM;

import java.util.Scanner;
import java.util.ArrayList;
class Bank {
    static PERSON global_person = new PERSON();
    static Client global_Client = new Client();
    static Account global_Account=new Account();

    public static void main(String[] args) {
        System.out.println("\u001B[1m\u001B[32m\t\t\t\t\t\tWELCOME TO MONEY MAGNET BANK \uD83C\uDFE6\u001B[0m\u001B[0m");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\u001B[1m\u001B[37m\n1.PERSON\n2.CLIENT\n3.ACCOUNT\n4.EXIT\u001B[0m\u001B[0m");
            int CHOICE = sc.nextInt();
//"""""""""""""""""""""""""""""""PERSON""""""""""""""""""""""""""""""
            if (CHOICE == 1) {
                System.out.println("\u001B[35m1.ADD PERSON\n2.DELETE PERSON\n3.SEARCH PERSON\n4.SHOW ALL PERSONS\u001B[0m");
                int PERSON_CHOICE = sc.nextInt();
//*******************************ADD PERSON**************************
                if (PERSON_CHOICE == 1) {
                    global_person.ADD_PERSON();
                }
//****************************DELETE PERSON***************************
                else if (PERSON_CHOICE == 2) {
                    System.out.println("\u001B[4m\u001B[34mENTER THE CNIC OF THE PERSON WHICH YOU WANT TO DELETE\u001B[0m\u001B[0m");
                    String NIC = sc.next();
                    PERSON search_person_to_delete = new PERSON();
                    search_person_to_delete = global_person.SEARCH_PERSON(NIC);
                    Client search_client_to_delete = new Client();
                    search_client_to_delete = global_Client.sesrch_client(NIC);
                    ArrayList<Account> search_account_to_delete = new ArrayList<>();
                    search_account_to_delete = global_Account.SEARACH_ACCOUNT_TO_DELETE_WITH_PERSON(NIC);
                    if (search_person_to_delete != null) {
                        global_person.DELETE_PERSON(search_person_to_delete);
                        if (search_client_to_delete != null && !search_account_to_delete.isEmpty()) {
                            global_Client.DELETE_CLIENT(search_client_to_delete);
                            global_Account.DELTE_ACCOUNT_TO_DELTE_WITH_PERSON(NIC);
                            System.out.println("\u001B[33m>>>CLIENT AND ASSOCIATED ACCOUNT HAS ALSO BEEN DELETED\u001B[0m");
                        } else if (search_client_to_delete != null) {
                            global_Client.DELETE_CLIENT(search_client_to_delete);
                            System.out.println("\u001B[33mCLIENT HAS ALSO BEEN DELETED\u001B[0m");
                        }
                    }
                }
//********************************SEARCH PERSON******************************
                else if (PERSON_CHOICE == 3) {
                    System.out.println("\u001B[4m\u001B[34mENTER THE CNIC OF THE PERSON WHICH YOU WANT TO SEARCH\u001B[0m\u001B[0m");
                    String NIC = sc.next();
                    PERSON search_person = new PERSON();
                    search_person = global_person.SEARCH_PERSON(NIC);
                    if (search_person != null) {
                        System.out.println(search_person);
                    }
                }
//****************************SHOW ALL PERSONS********************************
                else if (PERSON_CHOICE == 4) {
                    global_person.SHOW_PERSON();
                }
            }
//""""""""""""""""""""""""""""""""CLIENT"""""""""""""""""""""""""""""""""""""""
            else if (CHOICE == 2) {
                System.out.println("\u001B[35m1.ADD CLIENT\n2.DELETE CLIENT\n3.SEARCH CLIENT\n4.SHOW ALL CLIENTS\u001B[0m");
                int CLIENT_CHOICE = sc.nextInt();
//*********************************** ADD CLIENT********************************
                if (CLIENT_CHOICE == 1) {
                    System.out.println("\u001B[4m\u001B[34mEnter the CNIC of the Person: \u001B[0m\u001B[0m");
                    String CNIC = sc.next();
                    PERSON pp = new PERSON();
                    pp = global_person.SEARCH_PERSON(CNIC);
                    if (pp != null) {
                        Client cl = new Client(pp);
                        global_Client.ADD_CLIENT(cl);
                    } else {
                        System.out.println("\u001B[31mYOU ARE NOT IN THE PERSON LIST.\nFIRST ADD YOURSELF IN PERSON.THEN YOU CAN BECOME OUR CLIENT\u001B[0m");
                    }
                }

//**********************************DELETE CLIENT**********************************
                else if (CLIENT_CHOICE == 2) {
                    System.out.println("\u001B[4m\u001B[34mENTER THE ID OF THE CLIENT WHICH YOU WANT TO DELETE\u001B[0m\u001B[0m");
                    String ID_TO_DELETE_CLIENT = sc.next();
                    global_Client.delete_client(ID_TO_DELETE_CLIENT);
                    Account ACC=new Account();
                    ArrayList<Account> accountsToDelete=global_Account.SEARCH_ACCOUNTS_WITH_ID(ID_TO_DELETE_CLIENT);
                    if (!accountsToDelete.isEmpty()){
                        global_Account.DELETE_ACCOUNTS_WITH_CLIENT(ID_TO_DELETE_CLIENT);
                    }
                    else {
                        System.out.println("\u001B[31mCLIENT WITH ID \u001B[0m"+ID_TO_DELETE_CLIENT+"\u001B[31m HAVE NO ACCOUNT\u001B[0m");
                    }
                }
//*********************************SEARCH CLIENT***********************************
                else if (CLIENT_CHOICE==3) {
                    System.out.println("\u001B[4m\u001B[34mENTER THE ID OF THE CLIENT WHICH YOU WANT TO SEARCH\u001B[0m\u001B[0m");
                    String ID_TO_SEARCH_CLIENT = sc.next();
                    Client search_client = new Client();
                    search_client = global_Client.SEARCH_CLIENT(ID_TO_SEARCH_CLIENT);
                    if (search_client != null) {
                        System.out.println(search_client);
                    }
                }
//********************************SHOW ALL CLIENTS**********************************
                else if (CLIENT_CHOICE == 4) {
                    global_Client.SHOW_ALL_CLIENTS();
                }
            }
//"""""""""""""""""""""""""""""""""""ACCOUNT"""""""""""""""""""""""""""""""""""""""""
            else if (CHOICE == 3) {
                System.out.println("\u001B[35m1.ADD ACCOUNT\n2.DELETE ACCOUNT\n3.DEPOSIT MONEY\n4.WITHDRAW MONEY\n5.SEARCH ACCOUNT\n6.SHOW ALL ACCOUNTS\n7.SHOW ALL MONEY OF CLIENT\n8.SHOW ALL MONEY IN YOUR BANK\u001B[0m");
                int ACCOUNT_CHOICE=sc.nextInt();
//*************************************ADD ACCOUNT***********************************
                if(ACCOUNT_CHOICE==1){
                    System.out.println("\u001B[4m\u001B[34mENTER THE ID OF THE CLIENT TO OPEN ACCOUNT\u001B[0m\u001B[0m");
                    String CLIENT_ID_TO_OPEN_ACCOUNT=sc.next();
                    Client SEARCH_CLIENT_ID_TO_OPEN_ACCOUNT=new Client();
                    SEARCH_CLIENT_ID_TO_OPEN_ACCOUNT=global_Client.SEARCH_CLIENT(CLIENT_ID_TO_OPEN_ACCOUNT);
                    if (SEARCH_CLIENT_ID_TO_OPEN_ACCOUNT!=null){
                        Account acc=new Account(SEARCH_CLIENT_ID_TO_OPEN_ACCOUNT);
                        global_Account.ADD_ACCOUNT(acc);
                    }
                }
//***************************************DELETE ACCOUNT******************************
                else if (ACCOUNT_CHOICE==2) {
                    System.out.println("\u001B[4m\u001B[34mENTER ACCOUNT NUMBER:\u001B[0m\u001B[0m ");
                    String ACCOUNT_NUMBER_TO_DELETE_ACCOUNT=sc.next();
                    Account SEARCH_ACCOUNT_NUMBER_TO_DELETE_ACCOUNT=new Account();
                    SEARCH_ACCOUNT_NUMBER_TO_DELETE_ACCOUNT=global_Account.SEARCH_ACCOUNT(ACCOUNT_NUMBER_TO_DELETE_ACCOUNT);
                    if(SEARCH_ACCOUNT_NUMBER_TO_DELETE_ACCOUNT!=null){
                        global_Account.DELETE_ACCOUNT(ACCOUNT_NUMBER_TO_DELETE_ACCOUNT);
                    }
                }
//***************************************DEPOSIT MONEY********************************
                else if (ACCOUNT_CHOICE==3) {
                    System.out.println("\u001B[4m\u001B[34mENTER ACCOUNT NUMBER:\u001B[0m\u001B[0m ");
                    String ACCOUNT_NUMBER_TO_ADD_MONEY=sc.next();
                    System.out.println("\u001B[4m\u001B[34mENTER THE MONEY YOU WANT TO ADD\u001B[0m\u001B[0m");
                    int AMOUNT_TO_ADD=sc.nextInt();
                    global_Account.DEPOST_MONEY(ACCOUNT_NUMBER_TO_ADD_MONEY,AMOUNT_TO_ADD);
                }
//**************************************WITHDRAW MONEY********************************
                else if (ACCOUNT_CHOICE==4) {
                    System.out.println("\u001B[4m\u001B[34mENTER ACCOUNT NUMBER:\u001B[0m\u001B[0m ");
                    String ACCOUNT_NUMBER_TO_ADD_MONEY=sc.next();
                    System.out.println("\u001B[4m\u001B[34mENTER THE MONEY YOU WANT TO WITHDRAW\u001B[0m\u001B[0m");
                    int AMOUNT_TO_ADD=sc.nextInt();
                    global_Account.WITHDRAW_MONEY(ACCOUNT_NUMBER_TO_ADD_MONEY,AMOUNT_TO_ADD);
                }
//************************************SEARCH ACCOUNT***********************************
                else if (ACCOUNT_CHOICE==5) {
                    System.out.println("\u001B[4m\u001B[35m1.ONLY ONE ACCOUNT\n2.MORE THEN ONE ACCOUNT\u001B[0m\u001B[0m ");
                    int SEARCH_ACCOUNT_OPTION=sc.nextInt();
                    if (SEARCH_ACCOUNT_OPTION==1) {
                        System.out.println("\u001B[4m\u001B[34mENTER ACCOUNT NUMBER TO SEARCH ACCOUNT:\u001B[0m \u001B[0m");
                        String ACCOUNT_NO_TO_SEARCH_ACCOUNT = sc.next();
                        Account ACCOUNT_SEARCH = new Account();
                        ACCOUNT_SEARCH = global_Account.SEARCH_ACCOUNT(ACCOUNT_NO_TO_SEARCH_ACCOUNT);
                        if (ACCOUNT_SEARCH != null) {
                            System.out.println(ACCOUNT_SEARCH);
                        }
                    } else if (SEARCH_ACCOUNT_OPTION==2) {
                        System.out.println("\u001B[4m\u001B[34mENTER CLIENT ID TO SEARCH ACCOUNT:\u001B[0m\u001B[0m ");
                        String CLIENT_ID_TO_SEARCH_ACCOUNT = sc.next();
                        ArrayList<Account> SEARCH_MORE_THAN_ONE_ACCOUNTS=global_Account.SEARCH_ACCOUNTS_WITH_ID(CLIENT_ID_TO_SEARCH_ACCOUNT);
                        System.out.println(SEARCH_MORE_THAN_ONE_ACCOUNTS);
                    }
                }
// ***********************************SHOW ALL ACCOUNTS*********************************
                else if (ACCOUNT_CHOICE==6) {
                    global_Account.SHOW_ALL_ACCOUNTS();
                }
// ***********************************SHOW ALL MONEY OF A CLIENT*********************************
                else if (ACCOUNT_CHOICE==7) {
                    System.out.println("\u001B[4m\u001B[34mENTER CLIENT ID TO SHOW ALL MONEY: \u001B[0m\u001B[0m");
                    String CLIENT_ID_TO_SEARCH_ACCOUNT = sc.next();
                    global_Account.SHOW_MONEY_OF_ALL_ACCOUNTS(CLIENT_ID_TO_SEARCH_ACCOUNT);
                }
//******************************SHOW ALL MONEY IN BANK***********************************
                else if (ACCOUNT_CHOICE==8) {
                    global_Account.SHOW_ALL_MONEY();
                }
            }// MAIN IF BRACKET
//"""""""""""""""""""""""""""""""""""""BREAK"""""""""""""""""""""""""""""""""""""""""""""
            else if (CHOICE == 4) {
                System.out.println("\t\t\t\tTHANK YOU!!!");
                break;
            }
        }
    }
}
