package step11.ex13;

public class Customer3 {
    //외부에서 인스턴스 변수에 직접 접근하지 못하도록 막는다.!
    private String name;
    private int age;
    private int weight;
    private int height;
    
    // 외부에서 인스턴스 변수에 접근하지 못하기 때문에, 이를 가능하게 하는 수단/방법(method)를 제공.
    // 이런 메서드 -> setter.
    
    public void setName(String name) {
        // 이 메서드에서 이름 값이 유효한지 검사.
        if (name == null) {
            this.name = "이름없음";
            return;
        }
        
        if (name.length() < 2) { 
            this.name = "이름없음";
            return;
        }
        //이름은 최대 5자만 넣는다.
        if (name.length() > 5) {
            this.name = name.substring(0, 5);
        } else {
            this.name = name;
        }
        
    }
    public void setAge(int age) {
    // 인스턴스 변수 age의 값을 넣는 메서드.
    // => 나이 값이기 때문에 유효한 값은 1 ~ 120이다.
        if (age < 1 || age > 120) {
            this.age = 0;
            return;
        }
        this.age = age;
    }
    
    // 인스턴스 변수 weight의 값을 넣는 메서드
    // => 몸무게는 1 ~ 200 이다.
    
    public void setWeight(int weight) {
        if (weight < 1 || weight > 200) { 
            this.weight = 0;
            return;
        }
        this.weight = weight;
    }
    
    public void setHeight(int height) {
        if(height < 1 || height > 300) {
            this.height = 0;
            return;
        }
        this.height = height;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getAge() {
        return this.age;
    }
    
    public int getWeight() {
        return this.weight;
    }
    
    public int getHeight() {
        return this.height;
    }
}