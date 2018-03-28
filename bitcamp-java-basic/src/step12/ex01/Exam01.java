package step12.ex01;

public class Exam01 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        
        print(list);
        
        list.remove(2);
        
        print(list);
        
        list.remove(0);
        
        print(list);
        
        list.remove(4);
        
        print(list); //bbb, ddd,
        
        list.add(1, "xxx");
        list.add(1, "yyy");
        list.add(0, "zzz");
        list.add(5, "ttt");
        
        print(list);
        
        list.set(1, "aaa");
        
        print(list);
        
        list.add("ccc");
        list.add("eee");
        
        print(list);
    }
    
    static void print(ArrayList list) {
        for(int i = 0; i < list.size(); i++) {
            System.out.print((list.get(i) + ", "));
        }
        System.out.println();
    }
}
