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
        System.out.println("Book: " + title);
        for (Element e : content) {
            e.print();
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