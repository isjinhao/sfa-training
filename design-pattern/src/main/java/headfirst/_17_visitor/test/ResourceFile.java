package headfirst._17_visitor.test;

public abstract class ResourceFile {

    protected ResourceFileType resourceFileType;

    protected String filePath;
    public ResourceFile(String filePath, ResourceFileType resourceFile) {
        this.filePath = filePath;
        this.resourceFileType = resourceFile;
    }

    enum ResourceFileType {
        PDF, WORD, PPT;
    }

}