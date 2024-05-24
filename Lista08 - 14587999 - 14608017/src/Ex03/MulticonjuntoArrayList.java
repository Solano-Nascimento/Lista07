package Ex03;

import java.util.ArrayList;
import java.util.List;

public class MulticonjuntoArrayList<T> {
    private List<T> elementos;

    public MulticonjuntoArrayList() {
        this.elementos = new ArrayList<>();
    }

    public void add(T element) {
        elementos.add(element);
    }

    public void addAll(MulticonjuntoArrayList<T> m) {
        this.elementos.addAll(m.elementos);
    }

    public int getSize() {
        return elementos.size();
    }

    public boolean containsAll(List<T> otherElements) {
        return this.elementos.containsAll(otherElements);
    }

    public boolean equals(Object o) {
    	
    	// verifica se as referências dos dois objetos são exatamente as mesmas
        if (this == o) return true;
        // verifica se o objeto passado como parâmetro é uma instância da classe MulticonjuntoArrayList
        if (!(o instanceof MulticonjuntoArrayList)) return false;
        MulticonjuntoArrayList<?> that = (MulticonjuntoArrayList<?>) o;
        // compara o conteúdo dos dois objetos
        return this.elementos.containsAll(that.elementos) && that.elementos.containsAll(this.elementos);
    }
    @Override
    public String toString() {
    	return "MulticonjuntoArrayList{" +
                "elements=" + elementos +
                '}';
    }
}
