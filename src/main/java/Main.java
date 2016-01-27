import java.util.Scanner;

public class Main {

    private static Miniräknare miniräknare = new Miniräknare();
    private static Scanner scanner =  new Scanner(System.in);

    public static void main(String args[]){

        double input1;
        double input2;

        String raknesatt = "";

        while (!miniräknare.checkValidRaknesatt(raknesatt)) {
            System.out.println("m = multiplikation");
            System.out.println("s = subtraktion");
            System.out.println("a = addition");
            System.out.println("d = divition");
            System.out.println("Mata in räknesätt");
            raknesatt = scanner.nextLine();

            if (raknesatt.equals("avsluta")){
                miniräknare.avsluta();
            }
        }
        do {
            System.out.println("Skriv in ett tal:");
            while (!scanner.hasNextDouble()){
                System.out.println("De där är inget tal, var god att skriv ett tal.");
                scanner.next();
            }
            input1 = scanner.nextDouble();
        } while (input1 == 0);

        do {
            System.out.println("Skriv in de andra talet");
            while (!scanner.hasNextDouble()){
                System.out.println("De där är inget tal, var god att skriv ett tal.");
                scanner.next();
            }
            input2 = scanner.nextDouble();
        } while (input2 == 0);

        System.out.println("Resultat: " + miniräknare.getSum(raknesatt, input1, input2));
    }
}
