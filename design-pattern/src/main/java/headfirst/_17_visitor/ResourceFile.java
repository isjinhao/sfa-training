package headfirst._17_visitor;

public abstract class ResourceFile implements Acceptable {

    protected String filePath;

    public ResourceFile(String filePath) {
        this.filePath = filePath;
    }

}