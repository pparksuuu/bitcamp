// Mybatis - SQL에 파라미터 지정하기
package step25.ex6;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Exam02_1 {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = Resources.getResourceAsStream(
                "step25/ex6/mybatis-config04.xml");
        
        SqlSessionFactory factory = 
                new SqlSessionFactoryBuilder().build(inputStream);
        
        SqlSession sqlSession = factory.openSession();
        
        // SQL을 실행할 때 파라미터 값을 전달하려면 
        // 두 번째 파라미터로 전달해야 한다.
        // 여러 개의 값을 전달해야 한다면,
        // Map 객체에 담아 전달하라!
        HashMap<String,Object> paramMap = new HashMap<>();
        paramMap.put("startIndex", 9); //key는 SQL 맵퍼 파일에 지정된 이름과 같아야 한다.
        paramMap.put("pageSize", 3);
        
        List<Board> list = 
                sqlSession.selectList("BoardMapper.selectBoard", paramMap);
        
        for (Board board : list) {
            System.out.printf("%d, %s, %s, %s \n",
                    board.getNo(),
                    board.getTitle(),
                    board.getContent(),
                    board.getRegisteredDate());
        }
        // 실행 오류 발생 ! 이유?
        // => mybatis에서 결과 값을 Board 객체에 담지 못했기 때문
        //
        // 왜 결과 값을 Board에 담지 못했는가?
        // => mybatis에서 결과의 컬럼 값을 Board 객체에 담을 때
        //    컬럼 이름과 같은 이름을 가진 프로퍼티(셋터 메서드)를 찾는다.
        // =>
        
        sqlSession.close();
    }
}
