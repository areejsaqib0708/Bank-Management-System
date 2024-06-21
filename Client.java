
package BANK_MANAGEMEMNT_SYSYTEM;
import java.io.Serializable;
import java.io.*;
import java.util.ArrayList;
class Client implements Serializable{
    String id;
    PERSON person ;
    ArrayList<Client> CLIENT_LIST = new ArrayList<>();
    private static final String FILE_NAME="CLIENTS_DATA.dat";
    private static int count= 1 ;
    public Client(PERSON PERSON) {
        this.id = "C" + count;
        this.person = PERSON;
        System.out.println("CLIENT ID: C"+(count));
        count++;
    }
    public Client() {
    }
    public String getId() {
        return id;
    }
    public ArrayList<Client> getCLIENT_LIST(){
        return CLIENT_LIST;
    }
    public void addPersonToClientList(String clientID, String cnic) {
        PERSON person = new PERSON();
        person.LOAD_DATA_FROM_FILE();
        PERSON foundPerson = person.SEARCH_PERSON(cnic);

        if (foundPerson != null) {
            LOAD_DATA_FROM_CLIENT_FILE();
            Client newClient = new Client(foundPerson);
            newClient.id = clientID;
            CLIENT_LIST.add(newClient);
            System.out.println("Person added to client list with ID: " + clientID);
            SAVE_DATA_TO_CLIENT_FILE();
        } else {
            System.out.println("Person not found.");
        }
    }
    public void ADD_CLIENT(Client p) {
        CLIENT_LIST.add(p);
        SAVE_DATA_TO_CLIENT_FILE();
        System.out.println("\u001B[33m>>>CLIENT HAS BEEN SUCCESSFULLY ADDED\u001B[0m");
    }
    //***********************SEARCH CLIENT TO DELETE WITH PERSON***********************************
    public Client sesrch_client(String cc){
        LOAD_DATA_FROM_CLIENT_FILE();
        for (Client client:CLIENT_LIST){
            if (client.person.getCNIC().equals(cc)){
                return client;
            }
        }
        return null;
    }
    public Client SEARCH_CLIENT(String ccc) {
        LOAD_DATA_FROM_CLIENT_FILE();
        for (Client cl : CLIENT_LIST) {
            if (cl.id.equals(ccc)) {
                return cl;
            }
        }
        System.out.println("\u001B[31mCLIENT NOT FOUND\u001B[0m");
        System.out.println(ccc);
        return null;}
    //***********************TO DELETE CLIENT WITH PERSON********************************************
    public void DELETE_CLIENT(Client CC){
        if(CLIENT_LIST.contains(CC)) {
            CLIENT_LIST.remove(CC);
            SAVE_DATA_TO_CLIENT_FILE();
        }
    }
    //************************** DELETE CLIENT WITH CLIENT ID***************************************
    public void delete_client(String ID) {
        Client clientToRemove = null;
        for (Client client : CLIENT_LIST) {
            if (client.id.equals(ID)) {
                clientToRemove = client;
                break;
            }
        }
        if (clientToRemove != null) {
            CLIENT_LIST.remove(clientToRemove);
            SAVE_DATA_TO_CLIENT_FILE();
            System.out.println("\u001B[33m>>>CLIENT WITH ID \u001B[0m" + ID + "\u001B[33m HAS BEEN DELETED SUCCESSFULLY.\u001B[0m");
        } else {
            System.out.println("\u001B[31mCLIENT WITH ID \u001B[0m" + ID + "\u001B[31m WAS NOT FOUND.\u001B[0m");
        }
    }
    public void SHOW_ALL_CLIENTS(){
        LOAD_DATA_FROM_CLIENT_FILE();
        if (CLIENT_LIST.isEmpty()){
            System.out.println("NO CLIENT YET");
        }
        else {
            for (Client ccc : CLIENT_LIST) {
                System.out.println(ccc);
            }
        }
    }
    public void SAVE_DATA_TO_CLIENT_FILE(){
        try {
            FileOutputStream  fileOutputStream=new FileOutputStream("C:\\Users\\Public\\untitled\\src\\BANK_MANAGEMEMNT_SYSYTEM\\CLIENT_DATA.txt");
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(CLIENT_LIST);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

public void LOAD_DATA_FROM_CLIENT_FILE()  {
        try {

            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Public\\untitled\\src\\BANK_MANAGEMEMNT_SYSYTEM\\CLIENT_DATA.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            CLIENT_LIST = (ArrayList<Client>) objectInputStream.readObject();
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
                "\n" + person+
                        "\n\tCLIENT ID =" + id
                ;
    }
}