import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class FinallyHandling {
    public static void main(String[] args) {
        Scanner scanner = null;

        try {
            scanner = new Scanner(System.in);
            int[] nums = {1, 2, 3, 4, 5};

            int num = nums[21];

        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        finally {
            System.out.println("Before scanner close");
            if(scanner !=null)
                scanner.close();
        }
    }
}