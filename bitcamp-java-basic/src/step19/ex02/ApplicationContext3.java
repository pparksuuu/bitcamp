// 디렉토리 경로 대신 패키지 이름을 입력 받아
// 
package step19.ex02;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ApplicationContext3 {
    private ArrayList<File> list = new ArrayList<>();
    
    public ApplicationContext3(String packageName) {
        // 1)
        String path = packageName.replace('.', '/');
        System.out.println(path);
        //
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        URL url = classLoader.getResource(path);
        
        // 3) URL에서 실제 경로를 뽑아 File 객체를 생성한다.
        System.out.println(url.getPath());
        //findFiles(dir);
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
