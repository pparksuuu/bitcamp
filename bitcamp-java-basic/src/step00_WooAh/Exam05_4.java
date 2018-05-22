package step00_WooAh;

public class Exam05_4 {
    
    public static void main(String[] args) {
        int A = 10;
        int B = 2;
        int C = 3;
        int D = 5;
        
        int[] arr = {A, B, C, D};
        
    }
    
    public static int[] perm(int[] arr, int depth, int n, int k) {
        
        int[] newArr = new int[4];     
        if (depth == k) {
            putArr(newArr,k);
            return newArr;
        }
        
        for (int i = depth; i < n; i++) {
            swap(arr, i, depth);
            perm(arr, depth + 1, n, k);
            swap(arr, i, depth);
        }
    }
    
    public static void swap(int[] arr, int i, int j) { 
        int temp = arr[i]; 
        arr[i] = arr[j]; 
        arr[j] = temp; 
        } 
    
    
    public static void putArr(int[] newArr, int k) {
        for (int i = 0; i < k; i++) {
            if (i == k - 1)
                
            else 
                
        }
    }
    // 거리계산함수
    public static double computeDistance(int x, int y, int x1, int y1) {
        return (Math.pow(Math.abs(x1-x), 2) + Math.pow(Math.abs(y1-y), 2));
                
    }
}

