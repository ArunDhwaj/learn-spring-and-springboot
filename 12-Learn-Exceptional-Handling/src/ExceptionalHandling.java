// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class ExceptionalHandling {
    public static void main(String[] args) {
        method1();
        System.out.println("Main ended");
    }

    private static void method1() {
        method2();
        System.out.println("Method1 ended");
    }

    private static void method2() {
        try {
            String str = null;
            str.length();
            System.out.println("Method2 ended");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

}