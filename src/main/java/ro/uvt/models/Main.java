package ro.uvt.models;

public class Main {
    public static void main(String[] args) throws Exception {
        Section cap1 = new Section("Capitolul 1");

        Paragraph p1 = new Paragraph("main.java.ro.uvt.models.Paragraph 1");
        cap1.add(p1);
        Paragraph p2 = new Paragraph ("main.java.ro.uvt.models.Paragraph 2");
        cap1.add(p2);
        Paragraph p3 = new Paragraph ("main.java.ro.uvt.models.Paragraph 3");
        cap1.add(p3);
        Paragraph p4 = new Paragraph ("main.java.ro.uvt.models.Paragraph 4");
        cap1.add(p4);
        cap1.add(new ImageProxy("ImageOne"));
        cap1.add(new Image("ImageTwo"));
        cap1.add(new Paragraph("Some text"));
        cap1.add(new Table("main.java.ro.uvt.models.Table 1"));

        System.out.println("Printing content via main.java.ro.uvt.models.RenderContentVisitor:");
        RenderContentVisitor renderVisitor = new RenderContentVisitor();
        cap1.accept(renderVisitor);

        System.out.println("\n--------------------------\n");

        BookStatistics stats = new BookStatistics();
        cap1.accept(stats);
        stats.printStatistics();
    }
}