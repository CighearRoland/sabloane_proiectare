import java.util.concurrent.TimeUnit;

public class Image implements Element {
    private String imageName;

    // Constructorul cu delay-ul cerut
    public Image(String name) {
        this.imageName = name;
        try {
            TimeUnit.SECONDS.sleep(5); // Simularea incarcarii lente[cite: 10]
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void print() {
        System.out.println("Image with name: " + imageName);
    }

    // Metodele din Element (neutilizate aici)
    @Override
    public void add(Element element) {}
    @Override
    public void remove(Element element) {}
    @Override
    public Element get(int index) { return null; }
}