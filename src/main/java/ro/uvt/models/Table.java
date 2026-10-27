package ro.uvt.models;

import jakarta.persistence.Entity;

@Entity
public class Table extends BaseElement {
    private String title;

    public Table() {} // Obligatoriu pentru JPA

    public Table(String title) {
        this.title = title;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void print() {
        System.out.println("ro.uvt.models.Table: " + title);
    }

    public String getTitle() {
        return this.title;
    }

    @Override public void add(Element element) {}
    @Override public void remove(Element element) {}
    @Override public Element get(int index) { return null; }
}