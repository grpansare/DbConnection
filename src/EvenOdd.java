import java.util.Scanner;

public class EvenOdd {
    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        System.out.println("enter number");

         n=sc.nextInt();
        int ans=n/2;
        int b=ans*2;
        if(b==n){
            System.out.println("even number");
        }else{
            System.out.println("odd number");
        }
    }
}
