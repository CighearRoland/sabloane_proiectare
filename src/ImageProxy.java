public class ImageProxy implements Element {
    private String url;
    private Image realImage; // Referinta catre obiectul real (initial null)

    public ImageProxy(String url) {
        this.url = url;
    }

    // Metoda ajutatoare pentru a incarca imaginea reala la cerere
    public Image loadImage() {
        if (realImage == null) {
            realImage = new Image(url); // Imaginea este incarcata pe loc
        }
        return realImage;
    }

    @Override
    public void print() {
        // La momentul printarii, instantiem sau apelam imaginea reala
        loadImage().print();
    }

    @Override
    public void add(Element element) {}
    @Override
    public void remove(Element element) {}
    @Override
    public Element get(int index) { return null; }
}