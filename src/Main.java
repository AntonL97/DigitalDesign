import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    /*
  Проверка валидности входящей строки!
   */
    public static boolean validateLine(String input) {
        Pattern pattern = Pattern.compile("(\\d\\[(\\w+)\\]|([a-z])+|\\d\\[[0-9]+\\[[a-z]+\\]\\])+");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    /*
   Из строки выделяю массив символов!
    */
    public static String[] symbolArray(String string) {
        String cleaning = string.replaceAll("[^\\w]", "");
        String split = cleaning.replaceAll("[0-9]+", " ");
        String split1 = split.replaceAll("^\\s", "");
        String[] sArray = split1.split("\\s");
        return sArray;
    }

    /*
   Из строки выделяю массив цифр!
    */
    public static String[] numericArray(String string) {
        String cleaning = string.replaceAll("[^\\w]", "");
        String split = cleaning.replaceAll("\\D+", " ");
        String split1 = split.replaceAll("^\\s", "");
        String[] nArray = split1.split("\\s");
        return nArray;
    }

    /*
    Общий метод, в котором сначала проверяется длинна массивов, если у нас массив символов длиннее, это значит, что строка была формата
    "xx2[xx]" и тп, следовательно сначала выводим символы, а потом символы с заданым количеством раз. Другой вариант описывает
    ситуацию, формата "2[xx]3[xx]" и тп, тут сразу выводим символы нужное количество раз!
     */
    public static void unpacking(String string) {

        if (symbolArray(string).length > numericArray(string).length) {
            System.out.print(symbolArray(string)[0]);
            for (int i = 0; i < numericArray(string).length; i++) {
                for (int j = 0; j < Integer.parseInt(numericArray(string)[i]); j++) {
                    System.out.print(symbolArray(string)[i + 1]);
                }
            }
            System.out.println();

        } else {
            for (int i = 0; i < numericArray(string).length; i++) {
                for (int j = 0; j < Integer.parseInt(numericArray(string)[i]); j++) {
                    System.out.print(symbolArray(string)[i]);
                }
            }
            System.out.println();

        }

    }


    public static void main(String[] args) {
        while (true) {
            System.out.println("Введите строку!");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (validateLine(input)) {
                unpacking(input);
            } else System.out.println("Неверный формат!");
        }

    }
}


