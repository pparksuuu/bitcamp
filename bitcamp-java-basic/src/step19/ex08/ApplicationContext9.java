// 객체를 저장할 때 클래스 이름으로 저장하기, 클래스 이름으로 객체 꺼내기
package step19.ex08;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

public class ApplicationContext9 {
    //클래스 이름으로 객체를 저장할 수 있도로 Map을 사용한다.
    private HashMap<String, Object> objPool = new HashMap<>();

    public ApplicationContext9(String packageName) throws Exception {
        String path = packageName.replace('.', '/');
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        URL url = classLoader.getResource(path);

        File dir = new File(url.getPath());

        if (!dir.isDirectory()) {
            return;
        } 

        findClasses(dir, packageName);
    }

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
                this.objPool.put(clazz.getName(), obj);
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

    public Object getBean(String name) {
        return objPool.get(name);
    }
}
