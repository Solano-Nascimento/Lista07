package Extra;

public class StringVsStringBuffer {

    public static void main(String[] args) {
        // Número de concatenações
        int n = 100000;
        
        // Testando com String
        long startTimeString = System.currentTimeMillis();
        String testString = "";
        for (int i = 0; i < n; i++) {
            testString += "a";  // Concatenação com String
        }
        long endTimeString = System.currentTimeMillis();

        // Testando com StringBuffer
        long startTimeBuffer = System.currentTimeMillis();
        StringBuffer testBuffer = new StringBuffer();
        for (int i = 0; i < n; i++) {
            testBuffer.append("a");  // Concatenação com StringBuffer
        }
        long endTimeBuffer = System.currentTimeMillis();

        // Resultados
        System.out.println("Tempo de execução com String: " + (endTimeString - startTimeString) + " ms");
        System.out.println("Tempo de execução com StringBuffer: " + (endTimeBuffer - startTimeBuffer) + " ms");
    }
}

/*Explicação: Em termos de desempenho, StringBuffer é consideravelmente mais rápido do que usar String para muitas concatenações. 
 * Isso é claramente evidenciado quando você executa o programa acima, especialmente à medida que o número de operações de concatenação aumenta. 
 * Para um pequeno número de concatenações, o tempo no String ainda será maior que no StringBuffer, mas não será tão significativo,
 * mas para muitas operações, como no teste acima, StringBuffer oferece uma melhoria de desempenho substancial. 
 * StringBuffer possui melhor desempenho em números elevados de concatenações, pois ela usa um array de caracteres
 * que cresce conforme necessário. A principal vantagem é que StringBuffer minimiza o número de realocações necessárias ao manter um buffer interno
 * onde os dados são armazenados.
 */