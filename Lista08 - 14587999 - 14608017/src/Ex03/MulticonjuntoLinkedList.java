package Ex03;

import java.util.LinkedList;
import java.util.List;

public class MulticonjuntoLinkedList<T> {
    private List<T> elementos;

    public MulticonjuntoLinkedList() {
        this.elementos = new LinkedList<>();
    }

    public void add(T element) {
        elementos.add(element);
    }

    public void addAll(MulticonjuntoLinkedList<T> m) {
        this.elementos.addAll(m.elementos);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MulticonjuntoLinkedList)) return false;
        MulticonjuntoLinkedList<?> that = (MulticonjuntoLinkedList<?>) o;
        return this.elementos.containsAll(that.elementos) && that.elementos.containsAll(this.elementos);
    }
}
