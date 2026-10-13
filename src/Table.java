public class Table implements Element {
    private String title;

    public Table(String title) {
        this.title = title;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this); // Accepta vizitatorul
    }

    @Override
    public void print() {
        System.out.println("Table: " + title);
    }

    public String getTitle() { return this.title; }

    @Override public void add(Element element) {}
    @Override public void remove(Element element) {}
    @Override public Element get(int index) { return null; }
}