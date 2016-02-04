public class Main {

    private static Miniräknare miniräknare = new Miniräknare();

    public static void main(String args[]) {
        System.out.println(miniräknare.getName() + " " + miniräknare.getVersion() + "\n");
        miniräknare.printHelp();
        while(true){
            miniräknare.miniräknare();
        }
    }
}
