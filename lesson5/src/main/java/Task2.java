import java.util.ArrayList;
public class Task2 {
    public static void main (String[] args) {
        ArrayList<HeavyBox> boxes = new ArrayList<>();
        boxes.add(new HeavyBox(20));
        boxes.add(new HeavyBox(30));
        boxes.add(new HeavyBox(40));
        for (HeavyBox box : boxes) {
            System.out.println(box.toString());
        }
        boxes.set(0, new HeavyBox(10)); // Изменение веса первого ящика на 10.
        boxes.get(1).setWeight(boxes.get(0).getWeight()); // Установка веса второго ящика такой же как у первого.
        boxes.remove(boxes.size() - 2); // Удаление предпоследнего элемента
        // Первый способ
        HeavyBox[] boxesArray1 = boxes.toArray(new HeavyBox[boxes.size()]);
        for (HeavyBox box : boxesArray1) {
            System.out.println(box.toString());
        }
        // Второй способ
        HeavyBox[] boxesArray2 = new HeavyBox[boxes.size()];
        boxes.toArray(boxesArray2);
        for (HeavyBox box : boxesArray2) {
            System.out.println(box.toString());
        }
        // Удаление всех ящиков с разным весом
        int firstWeight = boxes.get(0).getWeight();
        for (int i = boxes.size() - 1; i >= 0; i--) {
            if (boxes.get(i).getWeight() != firstWeight) {
                boxes.remove(i);
            }
        }
        for (HeavyBox box : boxes) {
            System.out.println(box.toString());
        }
    }
}
