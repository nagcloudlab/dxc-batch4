import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex1 {
    public static void main(String[] args) {

        // ssn validation
        // ssn format: 000-00-0000

//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter your SSN: ");
//        String ssn = scanner.nextLine();

        //---------------------------------------------------------
        // Programmatic way
        //---------------------------------------------------------

//        boolean isValid = true;
//        int length = ssn.length();
//        if (length != 11) {
//            isValid = false;
//        } else {
//            for (int i = 0; i < 11; i++) {
//                if (i == 3 || i == 6) {
//                    if (ssn.charAt(i) != '-') {
//                        isValid = false;
//                        break;
//                    }
//                } else {
//                    if (!Character.isDigit(ssn.charAt(i))) {
//                        isValid = false;
//                        break;
//                    }
//                }
//            }
//        }
//        if (!isValid) {
//            System.out.println("Invalid SSN");
//        } else {
//            System.out.println("Valid SSN");
//        }

        //---------------------------------------------------------
        // Pattern matching with Regular Expression
        //--------------------------------------------------------

//        String ssnPattern = "\\d{3}-\\d{2}-\\d{4}";
//        Pattern pattern = Pattern.compile(ssnPattern);
//        Matcher matcher = pattern.matcher(ssn);
//
//        if (matcher.matches()) {
//            System.out.println("Valid SSN");
//        } else {
//            System.out.println("Invalid SSN");
//        }

        //---------------------------------------------------------

        String userComment = "This is a bad comment ";
        Pattern pattern1 = Pattern.compile("bad");
        Matcher matcher1 = pattern1.matcher(userComment);
        String moderatedComment=matcher1.replaceAll("*");
        System.out.println(moderatedComment);

        //---------------------------------------------------------


    }
}
