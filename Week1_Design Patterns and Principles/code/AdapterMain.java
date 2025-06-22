public class AdapterMain {

    interface PaymentProcessor {
        void processPayment(double amount);
    }

    static class PayPal {
        public void sendPayment(double amount) {
            System.out.println("Paid ₹" + amount + " using PayPal.");
        }
    }

    static class Stripe {
        public void makePayment(double amount) {
            System.out.println("Paid ₹" + amount + " using Stripe.");
        }
    }

    static class Razorpay {
        public void pay(double amountInINR) {
            System.out.println("Paid ₹" + amountInINR + " using Razorpay.");
        }
    }

    static class PayPalAdapter implements PaymentProcessor {
        private PayPal payPal;

        public PayPalAdapter(PayPal payPal) {
            this.payPal = payPal;
        }

        public void processPayment(double amount) {
            payPal.sendPayment(amount);
        }
    }

    static class StripeAdapter implements PaymentProcessor {
        private Stripe stripe;

        public StripeAdapter(Stripe stripe) {
            this.stripe = stripe;
        }

        public void processPayment(double amount) {
            stripe.makePayment(amount);
        }
    }

    static class RazorpayAdapter implements PaymentProcessor {
        private Razorpay razorpay;

        public RazorpayAdapter(Razorpay razorpay) {
            this.razorpay = razorpay;
        }

        public void processPayment(double amount) {
            razorpay.pay(amount);
        }
    }

    public static void main(String[] args) {
        PaymentProcessor paypalProcessor = new PayPalAdapter(new PayPal());
        PaymentProcessor stripeProcessor = new StripeAdapter(new Stripe());
        PaymentProcessor razorpayProcessor = new RazorpayAdapter(new Razorpay());

        paypalProcessor.processPayment(1500.00);
        stripeProcessor.processPayment(2000.00);
        razorpayProcessor.processPayment(2500.00);
    }
}
