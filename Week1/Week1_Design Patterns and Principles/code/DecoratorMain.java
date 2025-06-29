public class DecoratorMain {

    interface Notifier {
        void send(String message);
    }

    static class EmailNotifier implements Notifier {
        public void send(String message) {
            System.out.println("Sending EMAIL: " + message);
        }
    }

    static abstract class NotifierDecorator implements Notifier {
        protected Notifier notifier;

        public NotifierDecorator(Notifier notifier) {
            this.notifier = notifier;
        }

        public void send(String message) {
            notifier.send(message);  // Delegates to wrapped notifier
        }
    }

    static class SMSNotifierDecorator extends NotifierDecorator {
        public SMSNotifierDecorator(Notifier notifier) {
            super(notifier);
        }

        public void send(String message) {
            super.send(message);  // First send via wrapped notifier
            System.out.println("Sending SMS: " + message);
        }
    }

    static class SlackNotifierDecorator extends NotifierDecorator {
        public SlackNotifierDecorator(Notifier notifier) {
            super(notifier);
        }

        public void send(String message) {
            super.send(message);
            System.out.println("Sending SLACK message: " + message);
        }
    }

    public static void main(String[] args) {
        // Basic notifier: only Email
        Notifier emailNotifier = new EmailNotifier();
        System.out.println("Basic Email Notification:");
        emailNotifier.send("Your order has been placed.\n");

        // Email + SMS
        Notifier emailSmsNotifier = new SMSNotifierDecorator(new EmailNotifier());
        System.out.println("Email + SMS Notification:");
        emailSmsNotifier.send("Your package is out for delivery.\n");

        // Email + SMS + Slack
        Notifier fullNotifier = new SlackNotifierDecorator(
                                   new SMSNotifierDecorator(
                                       new EmailNotifier()));
        System.out.println("Email + SMS + Slack Notification:");
        fullNotifier.send("Your order has been delivered.");
    }
}
