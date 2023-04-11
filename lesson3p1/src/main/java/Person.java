public class Person {
    /*
        Создать класс Person, который содержит:
            - переменные fullName, age;
            - методы move() и talk(), в которых просто вывести на консоль значение переменной fullName.
            - Добавьте два конструктора  - Person() и Person(fullName, age).
            - Создайте два объекта этого класса. Один объект инициализируется конструктором Person(),
            другой - Person(fullName, age).
            - Вызовите методы move() и talk()
         */
    String fullName;
    int age;

    public Person() {
        fullName = "";
        age = 0;
    }

    public Person(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    void move() {

        System.out.println(fullName + " is moving.");
    }

    void talk() {

        System.out.println(fullName + " is talking.");
    }

    public static void main(String[] args) {
        Person person1 = new Person();
        Person person2 = new Person("Petya", 25);

        person1.move();
        person1.talk();

        person2.move();
        person2.talk();
    }
}
