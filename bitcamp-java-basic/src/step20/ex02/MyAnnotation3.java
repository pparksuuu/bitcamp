// 애노테이션 유지정책
// => SOURCE : 소스 파일에만 남긴다. 컴파일 후 제거된다.
// => CLASS : .class 파일에 남긴다. 그러나 실행시에 추출할 순 없다. (기본)
// => RUNTIME : .class 파일에 남긴다. 실행 시에 추출할 수 있다.
package step20.ex02;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// 애노테이션의 유지 정책을 RUNTIME라고 지정하면
// 해당 애노테이션은 .class 파일에도 남아 있고,
// 실행 중에 추출할 수 있다.
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation3 {
    String value(); // default 값을 지정하지 않으면 필수 프로퍼티
                    // 즉 애노테이션을 사용할 떄 반드시 값을 지정해야 한다.
    
}
