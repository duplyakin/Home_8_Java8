import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class ObservableTest {
    public static void main(String[] args) {
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

        Map<String, Person> personMap = Observable.of(someCollection)
                .filter(p -> {
                    return p.getAge() > 20;
                })
                .transform(p -> {
                    Person p1 = new Person(p);
                    p1.setAge(p.getAge() + 30);
                    return p1;
                })
                .toMap(p -> p.getFirstName(), p -> p);

    }
}
