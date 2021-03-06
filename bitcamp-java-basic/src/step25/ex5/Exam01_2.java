// Mybatis - SQL문 실행
package step25.ex5;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Exam01_2 {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = Resources.getResourceAsStream(
                "step25/ex5/mybatis-config.xml");
        
        SqlSessionFactory factory = 
                new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = factory.openSession();
        
        // SqlSession 객체를 이용하여 SQl 맵퍼 파일에 작성한 SQL 문을 실행한다.
        // => select 문장
        //    - sqlSession.selectList() : 목록 리턴
        //    - sqlSession.selectOne() : 한 개의 결과 리턴
        // => insert 문장
        //    - sqlSession.insert()
        // => update 문장
        //    - sqlSession.update()
        // => delete 문장
        //    - sqlSession.update()
        // => insert/update/delete인 경우 insert()/update()/delete() 메서드 중 
        //    아무거나 호출해도 된다. 하지만 일관된 유지보수를 위해 
        // 
        // => SQL 문장 = 그룹명 + "." + SQL문장 아이디
        List<Board> list = 
                sqlSession.selectList("BoardMapper.selectBoard");
        
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
