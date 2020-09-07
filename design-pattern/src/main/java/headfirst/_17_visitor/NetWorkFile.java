package headfirst._17_visitor;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/8/23
 */
public class NetWorkFile implements Acceptable {

    PdfFile pdfFile = new PdfFile("network file");

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(pdfFile);
    }
}
