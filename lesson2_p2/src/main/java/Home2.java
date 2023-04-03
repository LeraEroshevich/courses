public class Home2 {
    /*
        Создать двумерный массив из 5 строк по 8 столбцов в каждой из случайных целых чисел из отрезка [-99;99].
        Вывести массив на экран.
        После на отдельной строке вывести на экран значение максимального элемента этого массива
        (его индекс не имеет значения).
         */
    public static void main(String[] args) {
        int[][] num = new int[5][8];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 8; j++) {
                num[i][j] = (int) (Math.random() * 199) - 99;
                if (num[i][j] > max) {
                    max = num[i][j];
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(num[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Максимальный элемент массива: " + max);
    }
}
