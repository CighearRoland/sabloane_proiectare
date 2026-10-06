public class AlignCenter implements AlignStrategy {
    @Override
    public void render(Paragraph context) {
        System.out.println("== " + context.getText() + " ==");
    }
}