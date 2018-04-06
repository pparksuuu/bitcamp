// 하위 폴더의 파일을 가져온다.
package step19.ex01;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ApplicationContext2 {
    private ArrayList<File> list = new ArrayList<>();
    
    public ApplicationContext2(File dir) {
        findFiles(dir);
    }
    
    void findFiles(File dir) {
        File[] files = dir.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                findFiles(f);
            } else {
                this.list.add(f);
            }
        }
    }
    
    public List<File> getFiles() {
        return this.list;
    }
}
