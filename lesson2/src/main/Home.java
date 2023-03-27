public class Home {
        /* @Test
    @DisplayName("Какой суффикс используется для написания литералов типа long? Вариантов ответа может быть больше 1")
    void task1() {

        используется "L" и "l"
         */


    /*
    В переменных a и b лежат положительные длины катетов прямоугольного треугольника.
    Вычислить и вывести на экран площадь треугольника и его периметр.
     */
    public static void main (String[] args) {
        int a = 40, b = 45;
        int S = (a * b) / 2;
        System.out.println("S =" + S);

        double c = Math.sqrt(a * a + b * b);
        double P = (int) (a + b + c);
        System.out.println("P=" + P );
    }
}
