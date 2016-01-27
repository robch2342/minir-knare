import java.util.Scanner;

public class Main {

    private static Miniräknare miniräknare = new Miniräknare();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) {

        String input1;
        String input2;
        double parsedInput1 = 0;
        double parsedInput2 = 0;

        String raknesatt = "";


        while (parsedInput1 == 0) {
            System.out.println("Skriv in ett tal:");
            input1 = scanner.next();
            parsedInput1 = miniräknare.inputValidating(input1);
        }

        while (!miniräknare.checkValidRaknesatt(raknesatt)) {
        }

        while (parsedInput2 == 0) {
            System.out.println("Skriv in de andra talet");
            input2 = scanner.next();
            parsedInput2 = miniräknare.inputValidating(input2);
        }
        System.out.println("Resultat: " + miniräknare.getSum(raknesatt, parsedInput1, parsedInput2));
    }
}