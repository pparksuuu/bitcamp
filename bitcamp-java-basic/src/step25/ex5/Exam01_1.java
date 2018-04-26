// Data Persistence Framework 도입 - Mybatis
package step25.ex5;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Exam01_1 {
    public static void main(String[] args) throws Exception {
        // => mybatis 설정 파일을 읽을 도구를 준비한다.
        InputStream inputStream = Resources.getResourceAsStream(
                "step25/ex5/mybatis-config.xml");
        
        // Mybatis 설정 파일을 가지고 Builder를 이용하여 
        // SqlSession 공장 객체를 생성한다.
        SqlSessionFactory factory = 
                new SqlSessionFactoryBuilder().build(inputStream);
        
        // SqlSession 공장 객체로부터 sqlSession 객체를 얻는다.
        SqlSession sqlSession = factory.openSession();
        
        // SqlSession 객체를 이용하여 SQl 맵퍼 파일에 작성한 SQL 문을 실행한다.
        // => SQL 문장 = 그룹명 + "." + SQL문장 아이디
        List<Board> list = 
                sqlSession.selectList("step25.ex5.BoardDao.selectBoard");
        
        for (Board board : list) {
            System.out.printf("%d, %s, %s, %s \n",
                    board.getNo(),
                    board.getTitle(),
                    board.getContent(),
                    board.getRegisteredDate());
        }
        
        sqlSession.close();
    }
}
