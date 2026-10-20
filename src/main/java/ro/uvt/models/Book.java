package ro.uvt.models;

import java.util.ArrayList;
import java.util.List;

public class Book implements Element {
    private String title;
    private List<Element> content = new ArrayList<>();

    public Book(String title) {
        this.title = title;
    }

    public void addContent(Element element) {
        content.add(element);
    }

    public String getTitle() { return this.title; }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        for (Element child : content) {
            child.accept(visitor);
        }
    }

    @Override
    public void print() {
        System.out.println("main.java.ro.uvt.models.Book: " + title);
        for (Element e : content) {
            e.print();
        }
    }

    public Book() {}

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Element> getContent() {
        return content;
    }

    public void setContent(List<Element> content) {
        this.content = content;
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