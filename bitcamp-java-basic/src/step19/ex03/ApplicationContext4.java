// 디렉토리 경로 대신 패키지 이름을 입력 받아
// 
package step19.ex03;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ApplicationContext4 {
    private ArrayList<File> list = new ArrayList<>();
    
    public ApplicationContext4(String packageName) {
        // 1)
        String path = packageName.replace('.', '/');
        //
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        URL url = classLoader.getResource(path);
        
        // 3) URL에서 실제 경로를 뽑아 File 객체를 생성한다.
        File dir = new File(url.getPath());
        
        // 4) 해당 파일의 경로가 디렉토리를 가리키고 있다면,
        //    그 디렉토리의 파일 목록을 알아낸다.
        if (!dir.isDirectory()) {
            return;
        } 
        
        findFiles(dir);
    }
    
    void findFiles(File dir) {
        File[] files = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.isDirectory() || 
                        (pathname.getName().endsWith(".class") &&
                        !pathname.getName().contains("$"))) {
                    return true;
                }
                return false;
            }});
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
