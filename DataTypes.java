import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i=0; i < T; i++){

            String input = sc.next();

            try {
                long n = Long.parseLong(input);

                System.out.println(n + " can be fitted in:");

                if(n >= Byte.MIN_VALUE && n <= Byte.MAX_VALUE)
                    System.out.println("* byte");

                if(n >= Short.MIN_VALUE && n <= Short.MAX_VALUE)
                    System.out.println("* short");

                if(n >= Integer.MIN_VALUE && n <= Integer.MAX_VALUE)
                    System.out.println("* int");

                System.out.println("* long");

            } catch (Exception e) {
                System.out.println(input + " Can't be fitted anywhere.");
            }
        }
    }
}
