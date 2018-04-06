package step19.ex01;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ApplicationContext {
    private ArrayList<File> list = new ArrayList<>();
    
    public ApplicationContext(File dir) {
        findFiles(dir);
    }
    
    void findFiles(File dir) {
        File[] files = dir.listFiles();
        for (File f : files) {
            this.list.add(f);
        }
    }
    
    public List<File> getFiles() {
        return this.list;
    }
}
