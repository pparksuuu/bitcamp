package bitcamp.java106.step11;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class Car {
    String model;
    String maker;
    int cc;
    boolean auto;
    Date createdDate; 
    Engine engine;
     
    
    public Car(Engine engine) {
        this.engine = engine;
    }
    
    @Override
    public String toString() {
        return "Car [model=" + model + ", maker=" + maker + ", cc=" + cc
                + ", auto=" + auto + ", createdDate=" + createdDate
                + ", engine=" + engine + "]";
    }


    /*
     * 의존 객체는 작업하는데 사용하라고 외부에서 주입하는 객체이기 때문에
     * 셋터나 겟터를 정의할 필요가 없다.
    public Engine getEngine() {
        return engine;
    }


    public void setEngine(Engine engine) {
        this.engine = engine;
    }
    */

    public boolean isAuto() {
        return auto;
    }
    public void setAuto(boolean auto) {
        this.auto = auto;
    }
    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getMaker() {
        return maker;
    }
    public void setMaker(String maker) {
        this.maker = maker;
    }
    public int getCc() {
        return cc;
    }
    public void setCc(int cc) {
        this.cc = cc;
    }
    


    
    
}
