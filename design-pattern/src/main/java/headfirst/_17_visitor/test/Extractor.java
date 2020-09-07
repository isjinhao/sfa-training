package headfirst._17_visitor.test;

public class Extractor extends Action {

    protected void doActionPptFile(PPTFile pptFile) {
        //...
        System.out.println("Extract PPT: " + pptFile.filePath);
    }

    protected void doActionPdfFile(PdfFile pdfFile) {
        //...
        System.out.println("Extract PDF: " + pdfFile.filePath);
    }

    protected void doActionWordFile(WordFile wordFile) {
        //...
        System.out.println("Extract WORD: " + wordFile.filePath);
    }
}