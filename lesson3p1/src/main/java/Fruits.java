/*
           Создать абстрактный класс Фрукт и классы Яблоко, Груша, Абрикос расширяющие его.
           Класс Фрукт содержит:
           а) переменную вес,
           б) завершенный метод printManufacturerInfo(){System.out.print("Made in Ukraine");}
           в) абстрактный метод, возвращающий стоимость фрукта, который должен быть переопределен в каждом классе
            наследнике. Метод должен учитывать вес фрукта.
           Создать несколько объектов разных классов.
           Подсчитать общую стоимость проданных фруктов.
        */
public abstract class Fruits {
    private double weight;
    public Fruits(double weight) {
        this.weight = weight;
    }
    public double getWeight() {
        return weight;
    }
    public void printManufacturerInfo() {
        System.out.print("Made in Ukraine");
    }
    public abstract double getCost();
}
