// 해당 패키지의 클래스를 알아내 인스턴스를 생성한다.
// 
package step19.ex06;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ApplicationContext7 {
    private ArrayList<Object> list = new ArrayList<>();
    
    public ApplicationContext7(String packageName) throws Exception {
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
        
        findClasses(dir, packageName);
    }
    
    // 파일 경로에서 패키지명과 클래스명을 추출할 수 없다.
    // 그래서 파일을 찾을 때 패키지이름을 따로 관리해야한다.
    void findClasses(File dir, String packageName) throws Exception {
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
                findClasses(f, packageName + "." + f.getName());
                continue;
            } 

            String classname = f.getName();
            Class clazz = Class.forName(packageName + "." + 
                    classname.substring(0, classname.length() - 6));
            Object obj = createObject(clazz);
            if (obj != null)
             this.list.add(obj);
        }
    }
    
    private Object createObject(Class clazz) {
        // 파라미터가 없는 기본 생성자를 찾는다.
        try {
            clazz.getConstructor();
            return clazz.newInstance(); //기본 생성자를 호출하여 객체를 생성
        } catch (Exception e) {
            return null;
        }
    }

    public List<Object> getObjects() {
        return this.list;
    }
}
