package step11.ex13;

public class Customer4 {
    //외부에서 인스턴스 변수에 직접 접근하지 못하도록 막는다.!
    private String name;
    private int age;
    private int weight;
    private int height;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    
    
    
    
}