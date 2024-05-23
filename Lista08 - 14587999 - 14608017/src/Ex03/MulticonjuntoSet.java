package Ex03;

import java.util.HashMap;
import java.util.Map;

public class MulticonjuntoSet<T> {
    private Map<T, Integer> elementos;

    public MulticonjuntoSet() {
        this.elementos = new HashMap<>();
    }

    public void add(T element) {
        elementos.put(element, elementos.getOrDefault(element, 0) + 1);
    }

    public void addAll(MulticonjuntoSet<T> m) {
        m.getElementos().forEach((key, value) -> this.elementos.merge(key, value, Integer::sum));
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MulticonjuntoSet)) return false;
        MulticonjuntoSet<?> that = (MulticonjuntoSet<?>) o;
        return this.elementos.equals(that.getElementos());
    }

    public Map<T, Integer> getElementos() {
        return new HashMap<>(elementos); // Retorna uma cópia para proteger a integridade dos dados
    }

    public int getCount(T element) {
        return elementos.getOrDefault(element, 0);
    }
}

