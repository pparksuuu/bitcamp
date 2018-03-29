package step12.ex02;

public class LinkedList {
    
    // 값을 저장할 바구니 클래스를 만든다.
    // 그 클래스는 LinkedList에서만 만들 것이기 때문에
    // 일반적인 클래스인 패키지 멤버 클래스로 정의하지 않고,
    // LinkedList 안에 정의한다. 
    // 이렇게 클래스 안에 정의된 클래스를 "중첩 클래스(nested class)" 또는
    // "내부 클래스(inner class)"라고 부른다.
    class Bucket {
        // 이 클래스의 역할은 기차에서 사람이나 물건을 싣는 객차의 역할을 수행한다.
        Object value; // 이 변수에 값을 저장한다.
        Bucket next; // 이 변수에는 다음 객차 주소를 저장한다.
        Bucket prev; // 이 변수에는 이전 객차 주소를 저장한다.
    }

    Bucket head; // 리스트에서 맨 엎 객차의 주소를 저장할 인스턴스 변수
    Bucket tail; // 리스트에서 맨 뒤 객차의 주소를 저장할 인스턴스 변수
    
    public LinkedList() {
        head = new Bucket();
    }

    public void add(String s1) {
        // TODO Auto-generated method stub
        
    }
    
    // 리스트에서 맨 앞 객차의 주소를 저장하는 변수.
    
}
