public class ProxyMain {
    interface Image {
        void display();
    }

    static class RealImage implements Image {
        private String filename;

        public RealImage(String filename) {
            this.filename = filename;
            loadFromRemoteServer();
        }

        private void loadFromRemoteServer() {
            System.out.println("Loading " + filename + " from remote server...");
        }

        public void display() {
            System.out.println("Displaying " + filename);
        }
    }

    static class ProxyImage implements Image {
        private RealImage realImage;
        private String filename;

        public ProxyImage(String filename) {
            this.filename = filename;
        }

        public void display() {
            if (realImage == null) {
                realImage = new RealImage(filename); // Lazy loading
            }
            realImage.display();
        }
    }

    public static void main(String[] args) {
        Image image = new ProxyImage("image1.jpg");

        System.out.println("Calling display first time:");
        image.display();

        System.out.println("\nCalling display second time:");
        image.display();
    }
}
