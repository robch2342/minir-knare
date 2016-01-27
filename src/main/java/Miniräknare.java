public class Miniräknare {

    public double addition(double x, double y) {
        return x + y;
    }

    public double pi() {
        return 3.1415;
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

    public boolean checkValidRaknesatt(String raknesatt) {
        String[] validRaknesatt ={"*", "-", "+", "/"};

        boolean contains = false;

        for (String name : validRaknesatt) {
            if (name.equals(raknesatt)){
                contains = true;
                break;
            }
        }
        return contains;
    }

    public void avsluta(){
        System.exit(0);
    }

    public void checkAvsluta(String input){
        if (input.equals("x") || input.equals("avsluta")){
            avsluta();
        }
    }

    public double inputValidating(String input){
        double parsedInput = 0;
        try {
            parsedInput = Double.parseDouble(input);

        } catch (NumberFormatException e){
            return parsedInput;
        }
        return parsedInput;
    }
}