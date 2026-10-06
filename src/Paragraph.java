public class Paragraph implements Element {
    private String text;
    private AlignStrategy textAlignment;

    public Paragraph(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public void setAlignStrategy(AlignStrategy strategy) {
        this.textAlignment = strategy;
    }

    @Override
    public void print() {
        if (this.textAlignment != null) {
            this.textAlignment.render(this);
        } else {
            System.out.println(this.text);
        }
    }

    // Metode din interfata Element care nu sunt folosite specific aici
    @Override
    public void add(Element element) {
        // Un paragraf nu poate contine alte elemente in aceasta implementare
    }

    @Override
    public void remove(Element element) {}

    @Override
    public Element get(int index) {
        return null;
    }
}