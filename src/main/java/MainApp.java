import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        try {
            LoggingControl.registerMBean();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String input = scanner.nextLine();

        StringTransformer transformer = new StringTransformer();
        String result = transformer.transform(input);

        System.out.println("Transformed string: " + result);
    }
}

