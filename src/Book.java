import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private List<Element> content = new ArrayList<>();

    public Book(String title) {
        this.title = title;
    }

    public void addContent(Element element) { // metoda apelata in main[cite: 11, 13]
        content.add(element);
    }

    public void print() {
        System.out.println("Book: " + title);
        for (Element e : content) {
            e.print();
        }
    }
}