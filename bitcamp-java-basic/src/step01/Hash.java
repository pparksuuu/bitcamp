package step01;

public class Hash {
    public static void main(String[] args) {
        String a = "김소영";
        String b = "김소영";
        
        Integer c = 11;
        Integer d = 11;
        
        
        
        if (a.hashCode() == b.hashCode()) 
            System.out.println("같다");
        
        if (c.hashCode() == d.hashCode()) 
            System.out.println("같다");
        
        if (a == b) 
            System.out.println("같다");
         
        if (a.equals(b)) 
            System.out.println("같다");
    }
}
