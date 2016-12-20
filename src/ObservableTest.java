import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

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

        Person oldPerson = new Person();
        oldPerson.setAge(70);
        oldPerson.setFirstName("Alex");
        oldPerson.setLastName("Ivanov");
        oldPerson.setWeight(170);
        oldPerson.setHeight(70);

        Person youngPerson = new Person();
        youngPerson.setAge(20);
        youngPerson.setFirstName("Ivan");
        youngPerson.setLastName("Aleksandrov");
        youngPerson.setWeight(160);
        youngPerson.setHeight(60);


        List<Person> someCollection = new ArrayList<>();
        someCollection.add(youngPerson);
        someCollection.add(oldPerson);

        /*Map m = Observable.of(someCollection)
                    .filter(p -> p.getAge() > 20)
                     .transform( p -> new Person(p.getAge() + 30)))
                     .toMap(p -> p.geName(), p -> p);
        */
        //Observable observable = Observable.of(someCollection).filter(p -> { return p.getAge() > 20; });

        Map<String,Person> personMap = Observable.of(someCollection)
                .filter(p -> { return p.getAge() > 20; })
                .transform( p ->{ Person p1 =new Person(p); p1.setAge(p.getAge() + 30); return p1;})
                .toMap(p -> p.getFirstName(), p -> p);

        /*.transform(new Function<Person, Person>() {
            @Override
            public Person apply(Person person) {
                Person person1 = new Person(person.getPet());
                person1.setAge(person.getAge() + 30);
                return person1;
            }
        });*/

        /*Map map = observable.toMap(new Function<Person, Person>() {
            @Override
            public Person apply(Person person) {
                Person person1 = new Person(person.getPet());
                person1.setFirstName(person.getFirstName());
                return person1;

            }
        }, new Function<Person, Person>() {
            @Override
            public Person apply(Person person) {
                return person;

            }
        });
        */



    }
}
