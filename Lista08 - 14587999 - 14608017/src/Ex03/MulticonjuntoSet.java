package Ex03;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class MulticonjuntoSet<T> {
    private Set<T> elementos;

    public MulticonjuntoSet() {
        this.elementos = new HashSet<>();
    }

    public void add(T element) {
        elementos.add(element);
    }

    public void addAll(MulticonjuntoSet<T> m) {
        elementos.addAll(m.elementos);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MulticonjuntoSet)) return false;
        MulticonjuntoSet<?> that = (MulticonjuntoSet<?>) o;
        return this.elementos.equals(that.elementos);
    }

    public Set<T> getElementos() {
        return new HashSet<>(elementos);
    }

    public int getSize() {
        return elementos.size();
    }

    @Override
    public String toString() {
        return "MulticonjuntoSet{" +
                "elements=" + elementos +
                '}';
    }
}
