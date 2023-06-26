public class User {
    private User personReaching;     //user reaching out to
    private Mailbox mailbox;        //user's mailbox

    private boolean busy = false;    //see if user is busy

    public User(){
        mailbox = new Mailbox();
    }

    public void call(User user){
        //person reaching out to
        personReaching=user;

        //set busy to true
        busy=true;

        //check to see if person reaching is busy
        if(personReaching.isBusy()){
            //inform the caller the user on the other line is busy
            System.out.println("The person on the other line is busy.");

            // open Mailbox
            personReaching.getMailbox().leaveMsg();
        }
        else
        {
            System.out.println("Connecting to caller...");
        }
    }

    public User getPersonReaching(){
        return personReaching;
    }

    private void setPersonReaching(User personReaching){
        this.personReaching=personReaching;
    }

    public Mailbox getMailbox() {
        return mailbox;
    }

    public boolean isBusy(){
        return busy;
    }

    public void setBusy(boolean busy){
        this.busy=busy;
    }
}
