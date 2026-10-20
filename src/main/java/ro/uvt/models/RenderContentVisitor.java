package ro.uvt.models;

public class RenderContentVisitor implements Visitor {

    @Override
    public void visit(Book book) {
        System.out.println("main.java.ro.uvt.models.Book: " + book.getTitle());
    }

    @Override
    public void visit(Section section) {
        System.out.println(section.getTitle());
    }

    @Override
    public void visit(TableOfContents toc) {
        System.out.println("main.java.ro.uvt.models.Table of Contents");
    }

    @Override
    public void visit(Paragraph paragraph) {
        if (paragraph.getTextAlignment() != null) {
            paragraph.getTextAlignment().render(paragraph);
        } else {
            System.out.println("main.java.ro.uvt.models.Paragraph: " + paragraph.getText());
        }
    }

    @Override
    public void visit(ImageProxy imageProxy) {
        imageProxy.loadImage().accept(this);
    }

    @Override
    public void visit(Image image) {
        System.out.println("main.java.ro.uvt.models.Image with name: " + image.getImageName());
    }

    @Override
    public void visit(Table table) {
        System.out.println("main.java.ro.uvt.models.Table: " + table.getTitle());
    }
}