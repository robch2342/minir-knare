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
        switch (raknesatt){
            case "m":
                return multiplikation(input1, input2);
            case "s":
                return subtraktion(input1, input2);
            case "a":
                return addition(input1, input2);
            case "d":
                return division(input1, input2);
        }
        return 0;
    }

    public boolean checkValidRaknesatt(String raknesatt) {
        String[] validRaknesatt ={"m", "s", "a", "d"};

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