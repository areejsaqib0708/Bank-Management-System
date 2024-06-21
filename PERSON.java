
package BANK_MANAGEMEMNT_SYSYTEM;
import java.io.Serializable;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
public class PERSON implements Serializable {
    private String name;
    private String CNIC;
    private String Phone_Number;
    public ArrayList<PERSON> PERSON_LIST = new ArrayList<>();
    private static final String FILE_NAME="PERSONS_DATA.dat";
    public PERSON(String name, String CNIC, String Phone_Number) {
        this.name = name;
        this.CNIC = CNIC;
        this.Phone_Number = Phone_Number;
    }

    public PERSON() {
    }
    public void setPersonList(ArrayList<PERSON> personList) {
        this.PERSON_LIST = personList;
    }

    public String getCNIC() {
        return CNIC;
    }
    public String getName(){
        return name;
    }
    public String getPhone_Number(){
        return Phone_Number;
    }
    public ArrayList<PERSON> getPersonList() {
        return PERSON_LIST;
    }

    public void ADD_PERSON() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\u001B[4m\u001B[34mENTER NAME OF PERSON:\u001B[30m\u001B[0m ");
        String name = sc.next();
        System.out.println("\u001B[4m\u001B[34mENTER CNIC OF PERSON:\u001B[30m\u001B[0m ");
        String CNIC = sc.next();
        System.out.print("\u001B[4m\u001B[34mENTER PHONE NO. OF PERSON:\u001B[30m\n+92\u001B[0m ");
        String PHONE_NO = "+92" +sc.next();
        PERSON pers = new PERSON(name, CNIC, PHONE_NO);
        PERSON_LIST.add(pers);
        SAVE_DATA_TO_FILE();
        System.out.println("\u001B[33m>>>PERSON HAS BEEN SUCCESSFULLY ADDED\u001B[0m");
    }
    public void DELETE_PERSON(PERSON p) {
        if (PERSON_LIST.contains(p)) {
            PERSON_LIST.remove(p);
            SAVE_DATA_TO_FILE();
            System.out.println("\u001B[33m>>>PERSON HAS BEEN SUCCESSFULLY DELETED\u001B[0m");
        } else {
            System.out.println("\u001B[31m>>>PERSON NOT FOUND\u001B[0m");
        }
    }
    public PERSON SEARCH_PERSON(String CNIC) {
        LOAD_DATA_FROM_FILE();
        for (PERSON pe : PERSON_LIST) {
            if (pe.CNIC.equals(CNIC)) {
                return pe;
            }
        }
        return null;
    }
    public void SHOW_PERSON() {
        LOAD_DATA_FROM_FILE();
        if (PERSON_LIST.isEmpty()){
            System.out.println("NO PERSON YET");
        }
        else {
            for (PERSON ALL_PERSONS : PERSON_LIST) {
                System.out.println(ALL_PERSONS+"\n");
            }
        }
    }
    public void SAVE_DATA_TO_FILE(){
        try {
            FileOutputStream fileOutputStream=new FileOutputStream("C:\\Users\\Public\\untitled\\src\\BANK_MANAGEMEMNT_SYSYTEM\\PERSON_DATA.txt");
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(PERSON_LIST);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void LOAD_DATA_FROM_FILE(){
        try {
            FileInputStream fileInputStream=new FileInputStream("C:\\Users\\Public\\untitled\\src\\BANK_MANAGEMEMNT_SYSYTEM\\PERSON_DATA.txt");
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
            PERSON_LIST=(ArrayList<PERSON>) objectInputStream.readObject();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public String toString() {
        return
                "\tNAME = " + name +
                        "\n\tCNIC= " + CNIC +
                        "\n\tPHONE NUMBER = " + Phone_Number;
    }
}

