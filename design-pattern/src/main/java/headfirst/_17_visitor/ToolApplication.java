package headfirst._17_visitor;

import java.util.ArrayList;
import java.util.List;

public class ToolApplication {

    public static void main(String[] args) {

        /**
         * Allows for one or more operation to be applied to a set of objects at runtime,
         * decoupling the operations from the object structure.
         */

        List<ResourceFile> resourceFiles = listAllResourceFiles();
        Extractor extractor = new Extractor();
        for (ResourceFile resourceFile : resourceFiles) {
            resourceFile.accept(extractor);
        }

        Compressor compressor = new Compressor();
        for(ResourceFile resourceFile : resourceFiles) {
            resourceFile.accept(compressor);
        }

    }

    private static List<ResourceFile> listAllResourceFiles() {
        List<ResourceFile> resourceFiles = new ArrayList<>();
        resourceFiles.add(new PdfFile("a.pdf"));
        resourceFiles.add(new WordFile("b.word"));
        resourceFiles.add(new PPTFile("c.ppt"));
        return resourceFiles;
    }
}