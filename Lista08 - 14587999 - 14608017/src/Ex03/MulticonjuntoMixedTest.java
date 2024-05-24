package Ex03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MulticonjuntoMixedTest {

    @Test
    public void testMulticonjuntoArrayList() {
        MulticonjuntoArrayList<Integer> multiconjunto1 = new MulticonjuntoArrayList<>();
        multiconjunto1.add(1);
        multiconjunto1.add(2);
        multiconjunto1.add(2);

        MulticonjuntoArrayList<Integer> multiconjunto2 = new MulticonjuntoArrayList<>();
        multiconjunto2.add(1);
        multiconjunto2.add(2);
        multiconjunto2.add(2);

        assertTrue(multiconjunto1.equals(multiconjunto2), "Os multiconjuntos devem ser iguais");

        MulticonjuntoArrayList<Integer> multiconjunto3 = new MulticonjuntoArrayList<>();
        multiconjunto3.add(3);
        multiconjunto3.addAll(multiconjunto1);

        assertEquals("MulticonjuntoArrayList{elements=[3, 1, 2, 2]}", multiconjunto3.toString(), "A junção dos multiconjuntos não está correta");
    }

    @Test
    public void testMulticonjuntoSet() {
        MulticonjuntoSet<Integer> multiconjunto1 = new MulticonjuntoSet<>();
        multiconjunto1.add(1);
        multiconjunto1.add(2);
        multiconjunto1.add(2);

        MulticonjuntoSet<Integer> multiconjunto2 = new MulticonjuntoSet<>();
        multiconjunto2.add(1);
        multiconjunto2.add(2);

        assertTrue(multiconjunto1.equals(multiconjunto2), "Os multiconjuntos devem ser iguais");

        MulticonjuntoSet<Integer> multiconjunto3 = new MulticonjuntoSet<>();
        multiconjunto3.add(3);
        multiconjunto3.addAll(multiconjunto1);

        assertEquals("MulticonjuntoSet{elements=[1, 2, 3]}", multiconjunto3.toString(), "A junção dos multiconjuntos não está correta");
    }

    @Test
    public void testMulticonjuntoLinkedList() {
        MulticonjuntoLinkedList<Integer> multiconjunto1 = new MulticonjuntoLinkedList<>();
        multiconjunto1.add(1);
        multiconjunto1.add(2);
        multiconjunto1.add(2);

        MulticonjuntoLinkedList<Integer> multiconjunto2 = new MulticonjuntoLinkedList<>();
        multiconjunto2.add(1);
        multiconjunto2.add(2);
        multiconjunto2.add(2);

        assertTrue(multiconjunto1.equals(multiconjunto2), "Os multiconjuntos devem ser iguais");

        MulticonjuntoLinkedList<Integer> multiconjunto3 = new MulticonjuntoLinkedList<>();
        multiconjunto3.add(3);
        multiconjunto3.addAll(multiconjunto1);

        assertEquals("MulticonjuntoLinkedList{elements=[3, 1, 2, 2]}", multiconjunto3.toString(), "A junção dos multiconjuntos não está correta");
    }

    @Test
    public void testMulticonjuntoStack() {
        MulticonjuntoStack<Integer> multiconjunto1 = new MulticonjuntoStack<>();
        multiconjunto1.add(1);
        multiconjunto1.add(2);
        multiconjunto1.add(2);

        MulticonjuntoStack<Integer> multiconjunto2 = new MulticonjuntoStack<>();
        multiconjunto2.add(1);
        multiconjunto2.add(2);
        multiconjunto2.add(2);

        assertTrue(multiconjunto1.equals(multiconjunto2), "Os multiconjuntos devem ser iguais");

        MulticonjuntoStack<Integer> multiconjunto3 = new MulticonjuntoStack<>();
        multiconjunto3.add(3);
        multiconjunto3.addAll(multiconjunto1);

        assertEquals("MulticonjuntoStack{elements=[3, 1, 2, 2]}", multiconjunto3.toString(), "A junção dos multiconjuntos não está correta");
    }
    
    
}

