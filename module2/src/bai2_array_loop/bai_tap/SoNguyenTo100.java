package bai2_array_loop.bai_tap;

public class SoNguyenTo100 {
    public static void main(String[] args) {
        for (int i=2; i<100;i++){
            boolean check=true;
           for (int j=2;j <= Math.sqrt(i);j++){
               if (i % j == 0) {
                   check = false;
                   break;
               }
           }
           if (check){
               System.out.print(i+" ");
           }
        }
    }
}