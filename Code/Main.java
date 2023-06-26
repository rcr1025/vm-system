

public class Main {
    public static void main(String[] args) {
        User caller = new User();
        User owner = new User();

        owner.setBusy(true);

        owner.getMailbox().messages.push("Apple");
        owner.getMailbox().messages.push("Orange");
        owner.getMailbox().messages.push("Banana");
        owner.getMailbox().messages.push("Pair");

        owner.getMailbox().openMailbox();
        caller.call(owner);
    }
}