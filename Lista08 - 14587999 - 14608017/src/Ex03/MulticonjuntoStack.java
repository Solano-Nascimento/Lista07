package Ex03;

import java.util.Stack;

public class MulticonjuntoStack<T> {
    private Stack<T> elementos;

    public MulticonjuntoStack() {
        this.elementos = new Stack<>();
    }

    public void add(T element) {
        elementos.push(element);
    }

    public void addAll(MulticonjuntoStack<T> m) {
        this.elementos.addAll(m.elementos);
    }

    public int size() {
        return elementos.size();
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MulticonjuntoStack)) return false;
        MulticonjuntoStack<?> that = (MulticonjuntoStack<?>) o;
        return this.elementos.equals(that.elementos);
    }
    
    @Override
    public String toString() {
    	return "MulticonjuntoStack{" +
                "elements=" + elementos +
                '}';
    }
}
