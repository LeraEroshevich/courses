import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
public class Task2 {
    public static void main (String[] args) {
        ArrayList<HeavyBox> boxes = new ArrayList<>();
        boxes.add(new HeavyBox(20));
        boxes.add(new HeavyBox(30));
        boxes.add(new HeavyBox(40));
        for (HeavyBox box : boxes) {
            System.out.println(box.toString());
        }
        boxes.get(0).setWeight(10); // Изменение веса первого ящика на 10.
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
        Set<Integer> weights = new HashSet<>();
        Iterator<HeavyBox> iterator = boxes.iterator();
        while (iterator.hasNext()) {
            HeavyBox box = iterator.next();
            boolean result = weights.add(box.getWeight());
            System.out.println(result);
            if (result) {
                iterator.remove();
            }
        }
        for (HeavyBox box : boxes) {
            System.out.println(box.toString());
        }
    }
}
