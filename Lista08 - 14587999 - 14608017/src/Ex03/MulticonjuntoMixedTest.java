package Ex03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MulticonjuntoMixedTest {

    @Test
    public void testAdditionAndEquality() {
        MulticonjuntoArrayList<Integer> arrayListMultiset = new MulticonjuntoArrayList<>();
        MulticonjuntoSet<Integer> setMultiset = new MulticonjuntoSet<>();
        
        // Adicionando elementos em ambas as estruturas
        arrayListMultiset.add(1);
        arrayListMultiset.add(2);
        arrayListMultiset.add(2);

        setMultiset.add(1);
        setMultiset.add(2);
        setMultiset.add(2);

        // Comparando se ambas as estruturas têm os mesmos elementos
        assertEquals(arrayListMultiset.getSize(), setMultiset.getElementos().size());
        assertTrue(setMultiset.getElementos().containsKey(1) && setMultiset.getCount(1) == 2);
        assertTrue(setMultiset.getElementos().containsKey(2) && setMultiset.getCount(2) == 2);
    }

    @Test
    public void testAddAllFromDifferentTypes() {
        MulticonjuntoArrayList<Integer> arrayListMultiset = new MulticonjuntoArrayList<>();
        MulticonjuntoSet<Integer> setMultiset = new MulticonjuntoSet<>();
        
        arrayListMultiset.add(1);
        setMultiset.add(2);
        setMultiset.add(2);
        setMultiset.add(3);

        // Testando adição de todos os elementos de um MulticonjuntoSet em um MulticonjuntoArrayList
        arrayListMultiset.addAll(convertSetToList(setMultiset));

        // Verifica se todos os elementos foram adicionados corretamente
        assertEquals(4, arrayListMultiset.getSize());
        assertTrue(arrayListMultiset.containsAll(java.util.Arrays.asList(2, 2, 3)));
    }

    // Helper method to convert a MulticonjuntoSet to a MulticonjuntoArrayList
    private MulticonjuntoArrayList<Integer> convertSetToList(MulticonjuntoSet<Integer> setMultiset) {
        MulticonjuntoArrayList<Integer> result = new MulticonjuntoArrayList<>();
        setMultiset.getElementos().forEach((element, count) -> {
            for (int i = 0; i < count; i++) {
                result.add(element);
            }
        });
        return result;
    }
}
