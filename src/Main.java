import services.StandardService;

public class Main {
    public static void main(String[] args) {
        StandardService standardService = new StandardService();
        System.out.println(standardService.calculateAndOrderByPoints());
    }
}