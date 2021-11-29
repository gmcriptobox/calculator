import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculate calc = new Calculate();
        while(true) {
            try {
                calc.parser(sc.nextLine());
                calc.setRes();
                calc.printResult();
            } catch (CalculateException e) {
                System.exit(0);
            }
        }

    }
}
