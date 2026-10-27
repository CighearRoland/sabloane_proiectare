package ro.uvt.models;

import jakarta.persistence.*;
import java.util.concurrent.TimeUnit;

@Entity
public class Image extends BaseElement {
    private String imageName;

    public Image() {}

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
        System.out.println("ro.uvt.models.Image with name: " + imageName);
    }

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