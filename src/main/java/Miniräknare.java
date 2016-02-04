import java.util.Scanner;

public class Miniräknare {

    private static Scanner scanner = new Scanner(System.in);

    public String getName() {
        return "Miniräknarn";
    }

    public String getVersion() {
        return "0.8";
    }

    public void printHelp() {
        System.out.println("Funktioner:");
        System.out.println("+, -, *, /, pi och sqrt\n");
        System.out.println("Exempel:");
        System.out.println("pi [ENTER] sqrt [ENTER]");
        System.out.println("4 [ENTER] + [ENTER] 20 [ENTER]\n");
    }
    public void miniräknare() {

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
        return 0;
    }

    /**
     * Tolkar en sträng som ett matematiskt uttryck med en operator (+, - *, /). Kan användas av framtida GUI.
     * @param input Strängen som ska tolkas.
     * @return Resultatet av operationen som en sträng, eller "Syntax error" om uttrycket ej är giltigt.
     */
    public String parseString(String input) {
        double result = 0;
        boolean foundOperator = false;
        try {
            result = inputValidating(input);
            foundOperator = true;
        } catch (Exception e) {

        }
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
        if (!foundOperator) {
            return "Syntax error";
        } else if (Math.round(result) == result) {
            return "" + (int) result;
        }
        return "" + result;
    }

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