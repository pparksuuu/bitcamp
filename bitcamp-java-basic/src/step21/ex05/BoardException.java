package step21.ex05;

public class BoardException extends RuntimeException {

    // 이 클래스의 생성자를 호출하면 수퍼 클래스의 생성자를 호출하는 
    // 일 외에는 다른 작업을 수행하지 않는다.
    //
    // 아니, 기능을 추가할 것도 아니면서 왜 RuntimeException을 상속 받았는가?
    // => 이 클래스는 기존의 예외 클래스 기능을 확장하기 위함이 아니라,
    //    의미있는 이름을 가진 예외 클래스를 만드는 것이 목적이다.
    // => 즉 클래스 이름을 사용하기 위해 만든 것이다.
    //    
    
    public BoardException() {
        super();
        // TODO Auto-generated constructor stub
    }

    public BoardException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        // TODO Auto-generated constructor stub
    }

    public BoardException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public BoardException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public BoardException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }
    
}
