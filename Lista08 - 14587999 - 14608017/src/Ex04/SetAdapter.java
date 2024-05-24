package Ex04;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import Ex03.MulticonjuntoSet;

public class SetAdapter<T> implements Iterable<T> {
    private MulticonjuntoSet<T> multiconjuntoSet;

    public SetAdapter(MulticonjuntoSet<T> multiconjuntoSet) {
        this.multiconjuntoSet = multiconjuntoSet;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Iterator<T> setIterator = multiconjuntoSet.getElementos().iterator();
            private T currentElement = null;

            @Override
            public boolean hasNext() {
                return setIterator.hasNext();
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                currentElement = setIterator.next();
                return currentElement;
            }
        };
    }

    public static void main(String[] args) {
        MulticonjuntoSet<Integer> multiconjuntoSet = new MulticonjuntoSet<>();
        multiconjuntoSet.add(1);
        multiconjuntoSet.add(2);
        multiconjuntoSet.add(3);
        multiconjuntoSet.add(4);
        multiconjuntoSet.add(5);

        SetAdapter<Integer> setAdapter = new SetAdapter<>(multiconjuntoSet);
        for (Integer element : setAdapter) {
            System.out.println(element);  // Saída esperada: 1, 2, 3, 4, 5
        }
    }
}
