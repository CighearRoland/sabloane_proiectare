public class AlignRight implements AlignStrategy {
    @Override
    public void render(Paragraph context) {
        System.out.println(context.getText() + " >>");
    }
}