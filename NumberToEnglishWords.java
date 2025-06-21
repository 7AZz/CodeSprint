public class NumberToEnglishWords {
    private static final String[] below20 = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
            "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
    private static final String[] tens = { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
            "Ninety" };
    private static final String[] thousands = { "", "Thousand", "Million", "Billion" };

    public static String numberToWords(int num) {
        if (num == 0)
            return "Zero";
        return helper(num).trim();
    }

    private static String helper(int num) {
        if (num == 0)
            return "";
        if (num < 20)
            return below20[num] + " ";
        if (num < 100)
            return tens[num / 10] + (num % 10 != 0 ? " " + helper(num % 10) : " ");
        if (num < 1000)
            return below20[num / 100] + " Hundred" + (num % 100 != 0 ? " " + helper(num % 100) : " ");
        for (int i = 1, unit = 1000; i < thousands.length; i++, unit *= 1000) {
            if (num < unit * 1000) {
                return helper(num / unit) + thousands[i] + (num % unit != 0 ? " " + helper(num % unit) : " ");
            }
        }
        return "";
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(numberToWords(num));
    }
}
