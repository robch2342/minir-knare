public class Main {

    private static Miniraknare miniraknare = new Miniraknare();

    public static void main(String args[]) {
        System.out.println(miniraknare.getName() + " " + miniraknare.getVersion() + "\n");
        miniraknare.printHelp();
        while(true){
            miniraknare.miniraknare();
        }
    }
}
