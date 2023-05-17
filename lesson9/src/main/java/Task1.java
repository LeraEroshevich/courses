public class Task1 {
    public static void main(String[] args) {
        IFunction division = (val1, val2) -> {
            try {
                double x = Double.parseDouble(val1);
                double y = Double.parseDouble(val2);
                double result = x / y;
                return String.valueOf(result);
            } catch (NumberFormatException e) {
                throw new RuntimeException(e);
            }
        };

        String val1 = "20";
        String val2 = "2";
        String result = division.getResult(val1, val2);
        System.out.println("Result = " + result);
    }


}
