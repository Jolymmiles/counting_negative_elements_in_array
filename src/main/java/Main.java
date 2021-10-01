import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int sum = 0, count_negative = 0;
        Scanner sc = new Scanner(System.in);
        String input_data = sc.nextLine();
        String[] data_int = input_data.split(" ");
        for (String ind_digit : data_int) {
            int int_digit = Integer.parseInt(ind_digit);
            if (int_digit < 0){
                count_negative++;
                sum += int_digit;
            }
        }
        System.out.println(count_negative + " " + sum);

    }
}
