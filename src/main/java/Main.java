import java.util.Scanner;

public class Main {

    static Miniräknare miniräknare = new Miniräknare();
    static Scanner scanner =  new Scanner(System.in);

    public static void main(String args[]){
        while (1==1) {
            System.out.println("Mata in räknesätt");
            String raknesatt = scanner.nextLine();

            System.out.println(miniräknare.raknesatt(raknesatt));

            continue;
        }
    }
}
