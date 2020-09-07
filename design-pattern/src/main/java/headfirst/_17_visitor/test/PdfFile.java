package headfirst._17_visitor.test;

public class PdfFile extends ResourceFile {
    public PdfFile(String filePath) {
        super(filePath, ResourceFileType.PDF);
    }
}