import java.util.Scanner;

public class d1 {
    public static String numberToWords(int num) {
        if (num == 0) return "zero";
        
        String[] ones = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] teens = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        String[] thousands = {"", "thousand", "million", "billion", "trillion"};
        
        if (num < 0) return "negative " + numberToWords(-num);
        
        int groupIndex = 0;
        String result = "";
        
        while (num > 0) {
            if (num % 1000 != 0) {
                result = convertHundreds(num % 1000, ones, teens, tens) + thousands[groupIndex] + " " + result;
            }
            num /= 1000;
            groupIndex++;
        }
        
        return result.trim();
    }
    
    private static String convertHundreds(int num, String[] ones, String[] teens, String[] tens) {
        String result = "";
        
        if (num / 100 > 0) {
            result += ones[num / 100] + " hundred ";
        }
        
        int remainder = num % 100;
        if (remainder >= 20) {
            result += tens[remainder / 10] + " ";
            if (remainder % 10 > 0) {
                result += ones[remainder % 10] + " ";
            }
        } else if (remainder >= 10) {
            result += teens[remainder - 10] + " ";
        } else if (remainder > 0) {
            result += ones[remainder] + " ";
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        String words = numberToWords(number);
        System.out.println(words);
        sc.close();
    }
}
