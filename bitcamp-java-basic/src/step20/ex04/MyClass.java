// 애노테이션 프로퍼티 값 지정하기 - 프로퍼티 이름 생략
package step20.ex04;

///@MyAnnotation(value="홍길동") // 필수 프로퍼티가 없으면 지정하지 않아도 된다.
@MyAnnotation("홍길동") // OK! value 프로프티는 이름 생략 가능!
public class MyClass {
        
    
}
