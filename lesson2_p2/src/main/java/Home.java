public class Home {
    /*
      Создайте массив из 20-ти первых чисел Фибоначчи и выведите его на экран.
      Напоминаем, что первый и второй члены последовательности равны единицам,
       а каждый следующий — сумме двух предыдущих.
       */
        public static void main (String[] args) {
        int [] num = new int[20];
        for(int i=0; i< num.length; i++) {
            if(i<2){
                num[i] = 1;
            } else {
                num[i] = num[i-1] + num[i-2];
            }
            System.out.print(num[i] + " ");
        }
    }

}


