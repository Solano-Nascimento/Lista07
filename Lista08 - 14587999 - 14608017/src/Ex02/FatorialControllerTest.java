package Ex02;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Ex01.FatorialController;
import Ex01.FatorialView;


/**
 * Um teste de aceitação diferentemente de um teste automatizado, implementa passo a passos mais manuais e que dependem da 
 * experiência do usuário em analisar se o resultado obtido está correto ou não. Segue abaixo um exemplo simples de como um teste de execução pode
 * ser executado:
 * Teste de Aceitação para Calculadora de Fatorial
 *
 * Instruções para o usuário/testador:
 * - Inicie a aplicação FatorialView.
 * - Para cada conjunto de dados de teste:
 *   1. Insira o valor no campo de entrada.
 *   2. Clique no botão "Calcular".
 *   3. Observe o resultado na área de texto:
 *      - Se o resultado for numérico, compare com o esperado.
 *      - Se inserir um valor inválido (como um negativo), verifique se uma mensagem de erro adequada é exibida.
 * 
 * O teste automatizado simula um usuário realizando os testes diretamente na calculadora, para verificar outros valores basta:
 *  - substituir o número negativo por qualquer outro negativo
 *  - substituir o valor não inteiro por qualquer outro valor não inteiro
 *  - substituir o inteiro positivo por qualquer outro valor e modificar o valor esperado em AssertEquals de acordo.
 */


public class FatorialControllerTest {
	
	FatorialView janela = new FatorialView();
	JButton calculateButton = janela.getButton();
	JTextField inputField = janela.getInputField();
	JTextArea resultArea = janela.getResultArea();
	
   
	
	@BeforeAll
	public void setUp() {
		
        FatorialView janela = new FatorialView();

        System.out.println("Aqui");
		calculateButton = janela.getButton();
		inputField = janela.getInputField();
		resultArea = janela.getResultArea();
		
	}

    @Test
    public void testFatorial() throws InterruptedException {
    	inputField.setText("10");
    	calculateButton.doClick();
    	Thread.sleep(1000);
    	assertEquals("3628800", resultArea.getText());
    	
    	
    }
    
    @Test
    public void testFatorialNegative() throws InterruptedException {
    	inputField.setText("-10");
    	calculateButton.doClick();
    	Thread.sleep(1000);
    	assertEquals("Erro ao calcular fatorial.", resultArea.getText());
    	}
    
    @Test
    public void testFatorialInvalid() throws InterruptedException {
    	inputField.setText("ab");
    	calculateButton.doClick();
    	Thread.sleep(1000);
    	 assertEquals("Por favor, insira um número inteiro válido.", TestableOptionPane.getLastMessage());
    }

}
