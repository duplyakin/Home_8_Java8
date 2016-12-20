import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class Observable<T> {

    List<T> list = new LinkedList<>();

    public static <R> Observable<R> of(List<R> list) {
        Observable<R> observable = new Observable<>();
        observable.list.addAll(list);
        return observable;
    }

    public Observable<T> filter(Predicate<? super T> predicate) {
        for (T element : list) {
            if (!predicate.test(element)) {
                list.remove(element);
            }
        }
        return this;
    }

    public <R> Observable<R> transform(Function<? super T, ? extends R> mapper
    ) {
        Observable<R> observable = new Observable<>();
        for (T element : list) {
            observable.list.add(mapper.apply(element));
        }
        return observable;
    }

    public <K, V> Map<K, V> toMap(Function<? super T, ? extends K> mapperKey, Function<? super T, ? extends V> mapperValue) {
        Map<K, V> map = new HashMap<>();
        for (T element : list) {
            K key = mapperKey.apply(element);
            V value = mapperValue.apply(element);
            map.put(key, value);
        }
        return map;
    }
}

