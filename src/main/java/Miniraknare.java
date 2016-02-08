import java.util.ArrayList;
import java.util.Scanner;


public class Miniraknare {

    private static Scanner scanner = new Scanner(System.in);
    private ArrayList<String> history = new ArrayList<String>();
    private int historyIndex = -1;

    public String getName() {
        return "Miniräknarn";
    }

    public String getVersion() {
        return "0.95";
    }

    public void printHelp() {
        System.out.println("Funktioner:");
        System.out.println("+, -, *, /, pi och sqrt\n");
        System.out.printf("Skriv in 'x' eller 'avsluta' för att avsluta.\n");
        System.out.println("Exempel:");
        System.out.println("pi [ENTER] sqrt [ENTER]");
        System.out.println("4.20 [ENTER] + [ENTER] 23 [ENTER]\n");
    }

    /**
     * Prompt som läser och skriver från/till stdin/stdout.
     */
    public void miniraknare() {

        double input1;
        double input2;

        System.out.println("Skriv in ett tal:");
        input1 = readDouble();

        System.out.println("Ange räknesätt:");

        String raknesatt = readRaknesatt();

        double result = 0;

        if (raknesatt.toLowerCase().equals("sqrt")) {
            result = kvadratroten(input1);
        } else {
            System.out.println("Skriv in det andra talet");
            input2 = readDouble();
            result = getSum(raknesatt, input1, input2);
        }

        System.out.println("Resultat: " + inputValidating("" + result));

    }

    /**
     * Läser in en operator från stdin. Kommer loopa tills en giltig operator eller avslutningskommandot skrivits in.
     * @return Operatorn som användaren matade in.
     */
    public String readRaknesatt() {
        String raknesatt = scanner.nextLine();
        checkAvsluta(raknesatt);
        while (!checkValidRaknesatt(raknesatt)) {
            System.out.println("ID10T ERROR! Ange räknesätt:");
            raknesatt = scanner.nextLine();
            checkAvsluta(raknesatt);
        }
        return raknesatt;
    }

    /**
     * Läser in en double från stdin. Kommer loopa tills en double eller avslutningskommandot skrivits in.
     * @return Talet som användaren matade in.
     */
    public double readDouble() {
        double result = 0;
        boolean done = false;
        while (!done) {
            try {
                String input = scanner.nextLine();
                checkAvsluta(input);
                result = inputValidating(input, 10);
                done = true;
            } catch (Exception e) {
                System.out.println("ID10T ERROR! Skriv in ett tal:");
            }
        }
        return result;
    }

    public double addition(double x, double y) {
        return x + y;
    }

    public double pi() {
        return Math.PI;
    }

    public double multiplikation(double x, double y) {
        return x * y;
    }

    public double division(double x, double y) {
        return x / y;
    }

    public double kvadratroten(double x) {
        return Math.sqrt(x);
    }

    public double subtraktion(double x, double y) {
        return x - y;
    }

    /**
     * Räknar ett uttryck med de fyra räknesätten.
     * @param raknesatt operatorn. +, -, * eller /.
     * @param input1 första talet.
     * @param input2 andra talet.
     * @return
     */
    public double getSum(String raknesatt, double input1, double input2){
        if (raknesatt.equals("*")) {
            return multiplikation(input1, input2);
        } else if (raknesatt.equals("-")) {
            return subtraktion(input1, input2);
        } else if (raknesatt.equals("+")) {
            return addition(input1, input2);
        } else if (raknesatt.equals("/")) {
            return division(input1, input2);
        }
        //Dummy value. Kommer ej att inträffa förutsatt att raknesatt är korrekt.
        return 0;
    }

    /**
     * Tolkar en sträng som ett matematiskt uttryck med en operator (+, - *, /) eller ett tal. Används av GUIt.
     * @param input Strängen som ska tolkas.
     * @return Resultatet av operationen som en sträng, eller "Syntax error" om uttrycket ej är giltigt.
     */
    public String parseString(String input) {
        double result = 0;
        boolean foundOperator = false;

        //Kontrollera om uttrycket är ett tal.
        try {
            result = inputValidating(input);
            foundOperator = true;
        } catch (Exception e) {

        }

        //Anta att uttrycket är två tal separerade av en operator.
        for (int i = 0; i < input.length() && !foundOperator; i++) {
            if (checkValidRaknesatt(input.charAt(i) + "")) {
                try {
                    result = inputValidating("" + getSum(
                            input.charAt(i) + "",
                            inputValidating(input.substring(0, i), 12),
                            inputValidating(input.substring(i + 1, input.length()), 12)
                    ));
                    foundOperator = true;
                } catch (Exception e) {

                }
            }
        }

        String resultString = "";
        //Kontrollera om vi ej lyckades tolka uttrycket. Returnera isf ett felmeddelande.
        if (!foundOperator) {
            return "Syntax error";
        //Kontrollera om resultatet är ett heltal och ta isf bort decimalerna.
        } else if (Math.round(result) == result) {
            resultString += (int) result;
        } else {
            resultString += result;
        }
        //Spara resultatet i historiken.
        addToHistory(resultString);
        //Returnera resultatet.
        return resultString;
    }

    /**
     * Adderar en sträng till historiken.
     * @param s Strängen som ska adderas.
     */
    private void addToHistory(String s) {
        history.add(s);
        historyIndex = history.size() - 1;
    }

    /**
     * Returnerar nästa tal i historiken.
     * @return
     */
    public String getNextHistory() {
        if (historyIndex == -1) {
            return "";
        } else if (historyIndex < history.size() - 1) {
            historyIndex++;
        }
        return history.get(historyIndex);
    }

    /**
     * Returnerar föregående tal i historiken.
     * @return
     */
    public String getPrevHistory() {
        if (historyIndex == -1) {
            return "";
        } else if (historyIndex > 0) {
            historyIndex--;
        }
        return history.get(historyIndex);
    }

    /**
     * Kontrollerar om en sträng representerar ett giltigt räknesätt.
     * @param raknesatt
     * @return
     */
    public boolean checkValidRaknesatt(String raknesatt) {
        String[] validRaknesatt ={"*", "-", "+", "/", "sqrt"};

        for (String name : validRaknesatt) {
            if (name.toLowerCase().equals(raknesatt)){
                return true;
            }
        }
        return false;
    }

    public void avsluta(){
        System.exit(0);
    }

    public boolean checkAvsluta(String input){

        if (input.equals("x") || input.equals("avsluta")){
            avsluta();
            return true;
        }
        return false;
    }

    public double inputValidating(String input) {
        return inputValidating(input, 10);
    }

    public double inputValidating(String input, int decimals){
        double result = 0;
        input = input.replaceAll(" ", "");
        if (input.toLowerCase().equals("pi")) {
            result = pi();
        }else if (input.toLowerCase().equals("-pi")) {
            result =  -pi();
        } else {
            result = Double.parseDouble(input);
        }
        //Begränsa antalet decimaler
        input = String.format("%." + decimals + "g%n", result);
        return Double.valueOf(input);
    }
}