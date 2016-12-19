import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ObservableTest {
    public static void main(String[] args) {

        Dog dog = new Dog();
        dog.setSpeed(10.10);
        dog.setAge(7);
        dog.setName("Reks");

        Dog youngdog = new Dog();
        dog.setSpeed(10.10);
        dog.setAge(3);
        dog.setName("Bobby");

        Cat cat = new Cat();
        cat.setColor(1);
        cat.setAge(3);
        cat.setName("Garfield");

        Person oldPerson = new Person(dog);
        oldPerson.setAge(70);
        oldPerson.setFirstName("Alex");
        oldPerson.setLastName("Ivanov");
        oldPerson.setWeight(170);
        oldPerson.setHeight(70);
        oldPerson.setPet(dog);

        Person youngPerson = new Person(dog);
        youngPerson.setAge(20);
        youngPerson.setFirstName("Ivan");
        youngPerson.setLastName("Aleksandrov");
        youngPerson.setWeight(160);
        youngPerson.setHeight(60);
        youngPerson.setPet(dog);


        List<Person> someCollection = new ArrayList<>();
        someCollection.add(youngPerson);
        someCollection.add(oldPerson);

        /*Map m = Observable.of(someCollection)
                    .filter(p -> p.getAge() > 20)
                     .transform( p -> new Person(p.getAge() + 30)))
                     .toMap(p -> p.geName(), p -> p);
        */
        Observable observable = Observable.of(someCollection).filter(p -> p.getAge() > 20);
    }
}
