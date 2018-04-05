// 디렉토리에 들어있는 파일(디렉토리) 목록을 꺼낼 때 필터 적용하기
package step16.ex01;

import java.io.File;
import java.io.FilenameFilter;

public class Exam06_2 {

    static class JavaFilter implements FilenameFilter {

        @Override
        public boolean accept(File dir, String name) {
            if (name.endsWith(".java"))
                return true; //조회 결과에 포함시켜라!
            return false; //조회 결과에서 제외하라!
        }
        
    }
    
    public static void main(String[] args) {
        File dir = new File(".");

        JavaFilter javaFilter = new JavaFilter();
        
        File[] files = dir.listFiles(javaFilter);
        
        for (File file : files) {
            System.out.printf("%s %12d %s\n", 
                    file.isDirectory() ? "d" : "-",
                    file.length(),
                    file.getName());
        }
    }

}
