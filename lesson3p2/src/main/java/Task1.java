public class Task1 {

        /*
        С помощью метода ordinal() получить позицию каждой константы в перечислении Days.
        Результат вывести в консоль через запятую в строчку.
         */
        public static void main(String[] args) {
            Days[] days = Days.values();
            for (int i = 0; i < days.length; i++) {
                System.out.print(days[i].ordinal());
                if (i < days.length - 1) {
                    System.out.print(", ");
                }
            }
        }
}

