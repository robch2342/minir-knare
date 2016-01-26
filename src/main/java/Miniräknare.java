
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

    public String raknesatt(String raknesatt){
        switch (raknesatt){
            case "m":
                return "multi";
            case "s":
                return "sub";
            case "a":
                return "add";
            case "d":
                return "div";
        }
        return "ogiltligt räknesätt";
    }
}