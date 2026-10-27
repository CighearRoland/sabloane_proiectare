package ro.uvt.models;

import jakarta.persistence.*;

@Entity
public class Paragraph extends BaseElement {
    private String text;

    @Transient
    private AlignStrategy textAlignment;

    public Paragraph() {}

    public Paragraph(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public AlignStrategy getTextAlignment() {
        return this.textAlignment;
    }

    public void setAlignStrategy(AlignStrategy strategy) {
        this.textAlignment = strategy;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void print() {
        if (this.textAlignment != null) {
            this.textAlignment.render(this);
        } else {
            System.out.println(this.text);
        }
    }

    @Override
    public void add(Element element) {}

    @Override
    public void remove(Element element) {}

    @Override
    public Element get(int index) {
        return null;
    }
}