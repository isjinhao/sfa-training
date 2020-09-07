package headfirst._17_visitor.test;

import headfirst._17_visitor.test.ResourceFile.ResourceFileType;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/8/23
 */
public abstract class Action {

    public void action(ResourceFile resourceFile) {
        if (resourceFile.resourceFileType == ResourceFileType.PDF) {
            doActionPdfFile((PdfFile) resourceFile);
        } else if (resourceFile.resourceFileType == ResourceFileType.PPT) {
            doActionPptFile((PPTFile) resourceFile);
        } else if (resourceFile.resourceFileType == ResourceFileType.WORD) {
            doActionWordFile((WordFile) resourceFile);
        }
    }

    protected abstract void doActionPptFile(PPTFile pptFile);

    protected abstract void doActionPdfFile(PdfFile pdfFile);

    protected abstract void doActionWordFile(WordFile wordFile);
}
