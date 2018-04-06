// 디렉토리 경로 대신 패키지 이름을 입력 받아
// 
package step19.ex04;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ApplicationContext5 {
    private ArrayList<String> list = new ArrayList<>();
    
    public ApplicationContext5(String packageName) {
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
        
        findFiles(dir, packageName);
    }
    
    // 파일 경로에서 패키지명과 클래스명을 추출할 수 없다.
    // 그래서 파일을 찾을 때 패키지이름을 따로 관리해야한다.
    void findFiles(File dir, String packageName) {
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
                findFiles(f, packageName + "." + f.getName());
            } else {
                String classname = f.getName();
                
                this.list.add(packageName + "." + classname.substring(0, classname.length() - 6));
            }
        }
    }
    
    public List<String> getFiles() {
        return this.list;
    }
}
