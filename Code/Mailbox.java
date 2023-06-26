import java.io.*;
import java.util.*;

public class Mailbox {
    private User owner;     //mailbox owner
    public Stack<String> messages = new Stack<String>();

    private final int MESSAGESIZE = 5;  // max number of messages
    private String greeting="Please leave voice mail message: ";

    private User getOwner(){
        return owner;
    }

    private void setOwner(User owner){
        this.owner = owner;
    }

    public void openMailbox(){
        System.out.println("Welcome to your voice mail!");

        //create scanner for user input
        Scanner myScanner = new Scanner(System.in);
        int choice = 3;

        //prompt user choices
        while(choice != 1 && choice !=2 && choice!=0){
            System.out.println("Press 1 to retrieve messages.");
            System.out.println("Press 2 to change greeting.");
            System.out.println("(Press 0 to hang up)");
            choice = Integer.parseInt(myScanner.nextLine());
        }

        // retrieve msg
        if (choice == 1) retrieveMsg();

        // change greeting
        else if (choice == 2)changeGreeting();

        // hang up
        else return;
    }

    //check to see if vm hits
    private boolean isFull(){
        if (messages.size()==MESSAGESIZE) return true;
        else return false;
    }

    private boolean isOwner(User user){
        if (this.owner==user)return true;
        else return false;
    }

    private void changeGreeting(){
        Scanner myScanner = new Scanner(System.in);
        int choice = 3;

        //prompt user for greeting
        System.out.println("Please record new greeting");

        //get new greeting from user
        String newGreeting=myScanner.nextLine();

        //prompt user for decision
        while(choice != 1 && choice != 2 && choice != 0){
            System.out.println("Press 1 to commit greeting.");
            System.out.println("Press 2 to redo greeting.");
            System.out.println("(Press 0 to hang up)");
            choice = Integer.parseInt(myScanner.nextLine());
        }

        //commit greeting
        if(choice==1){
            //update greeting
            greeting=newGreeting;
            //go back to mailbox
            openMailbox();
        }
        //redo greeting
        else if(choice==2)
        {
            changeGreeting();
        }

        //user hangs up
        else return;

    }

    public void leaveMsg(){
        //check to see if mailbox is full
        if(isFull()) {
            System.out.println("Mailbox is full");
            // exit program
            return;
        }

        // Prompt user to leave msg
        Scanner myScanner = new Scanner(System.in);
        System.out.println(greeting);
        String voiceMail = myScanner.nextLine();

        // Prompt user to commit to message
        int choice = 0;
        while(choice != 1 && choice != 2){
            System.out.println("Press 1 to commit message.");
            System.out.println("Press 2 to redo message.");
            choice = Integer.parseInt(myScanner.nextLine());
        }

        //commit voicemail
        if (choice == 1){
            messages.push(voiceMail);
            System.out.println("Voice mail sent.");
        }

        //redo message
        else{
            leaveMsg();
        }
    }

    private void retrieveMsg(){

        //check if mailbox is empty
        if(messages.empty()){
            System.out.println("You have no messages.");
            openMailbox();
        }

        Scanner myScanner = new Scanner(System.in);
        int choice = 5;

        //prompt user to select option
        while(choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 0){
            System.out.println("Press 1 to listen to current message.");
            System.out.println("Press 2 to delete to current message.");
            System.out.println("Press 3 to save to current message.");
            System.out.println("Press 4 to return to menu.");
            System.out.println("(Press 0 to hang up.)");
            choice = Integer.parseInt(myScanner.nextLine());
        }

        //listen to current message
        if(choice == 1)listenMsg();

        //delete current message
        else if(choice == 2)deleteMsg();

        //save current message
        else if(choice == 3)saveMsg();

        //return to menu
        else if(choice == 4)openMailbox();

        //exit voice mail when user hits 0
        else return;
    }

    private void listenMsg(){
        //prints message
        System.out.println(messages.peek());
        //go back to menu
        retrieveMsg();
    }

    private void deleteMsg(){
        //remove msg from stack
        messages.pop();
        System.out.println("Message deleted.");
        //go back to menu
        retrieveMsg();
    }

    private void saveMsg(){
        //copy current msg to end of stack
        messages.add(0,messages.peek());
        //remove current msg
        messages.pop();
        //go back to menu
        retrieveMsg();
    }

}
