package step11.ex13;

public class Customer3 {
    //외부에서 인스턴스 변수에 직접 접근하지 못하도록 막는다.!
    private String name;
    private int age;
    private int weight;
    private int height;
    
    // 외부에서 인스턴스 변수에 접근하지 못하기 때문에, 이를 가능하게 하는 수단/방법(method)를 제공.
    
    public void setName(String name) {
        // 이 메서드에서 이름 값이 유효한지 검사.
        if (name == null)
            this.name = "이름없음";
        
        if (name.length() < 2) 
            this.name = "이름없음";
        
        //이름은 최대 5자만 넣는다.
        this.name = name.substring(0, 5);
        
    }
}