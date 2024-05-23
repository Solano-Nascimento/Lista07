package Ex01;

import java.math.BigDecimal;

public class FatorialController {

    public static BigDecimal calcularFatorial(int num, java.util.function.IntConsumer progressCallback) {
        if (num < 0) {
            throw new IllegalArgumentException("Número negativo não é permitido.");
        }
        BigDecimal result = BigDecimal.ONE;
        for (int i = 1; i <= num; i++) {
            result = result.multiply(BigDecimal.valueOf(i));
            int progress = (int) ((i / (double) num) * 100);
            progressCallback.accept(progress);
            try {
                // Simulating time-consuming calculation
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        return result;
    }
}
