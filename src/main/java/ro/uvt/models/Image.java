package ro.uvt.models;

import java.util.concurrent.TimeUnit;

public class Image implements Element {
    private String imageName;

    public Image(String name) {
        this.imageName = name;
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void print() {
        System.out.println("main.java.ro.uvt.models.Image with name: " + imageName);
    }

    // Metodele din main.java.ro.uvt.models.Element
    @Override
    public void add(Element element) {}
    @Override
    public void remove(Element element) {}
    @Override
    public Element get(int index) { return null; }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getImageName() { return this.imageName; }
}