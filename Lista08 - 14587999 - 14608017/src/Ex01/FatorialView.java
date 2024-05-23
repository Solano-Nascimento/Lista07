package Ex01;

import Ex02.TestableOptionPane;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;

public class FatorialView extends JFrame {
    private static final long serialVersionUID = -8497602691846879841L;
    private JTextField inputField;
    private JButton calculateButton;
    private JTextArea resultArea;
    private JProgressBar progressBar;

    public FatorialView() {
        super("Calculadora de Fatorial");
        setLayout(new FlowLayout());
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }

    public JButton getButton() {
        return calculateButton;
    }

    public JTextField getInputField() {
        return inputField;
    }

    public JTextArea getResultArea() {
        return resultArea;
    }

    private void initComponents() {
        inputField = new JTextField(10);
        calculateButton = new JButton("Calcular");
        resultArea = new JTextArea(5, 20);
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);

        progressBar = new JProgressBar(0, 100);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);

        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        add(inputField);
        add(calculateButton);
        add(scrollPane);
        add(progressBar);

        calculateButton.addActionListener(e -> handleCalculateAction());
    }

    private void handleCalculateAction() {
        int num;
        try {
            num = Integer.parseInt(inputField.getText());
        } catch (NumberFormatException ex) {
            TestableOptionPane.showMessageDialog(FatorialView.this,
                    "Por favor, insira um número inteiro válido.",
                    "Erro de Formato", JOptionPane.ERROR_MESSAGE);
            return;
        }

        FatorialWorker worker = new FatorialWorker(num);
        worker.execute();
    }

    private class FatorialWorker extends SwingWorker<BigDecimal, Integer> {
        private final int num;

        public FatorialWorker(int num) {
            this.num = num;
        }

        @Override
        protected BigDecimal doInBackground() {
            try {
                return FatorialController.calcularFatorial(num, this::publish);
            } catch (IllegalArgumentException e) {
                // Handle the illegal argument exception for negative numbers
                cancel(true);
                return null;
            }
        }

        @Override
        protected void process(java.util.List<Integer> chunks) {
            // Update progress bar with the last value in chunks
            if (!chunks.isEmpty()) {
                int progress = chunks.get(chunks.size() - 1);
                progressBar.setValue(progress);
            }
        }

        @Override
        protected void done() {
            try {
                if (isCancelled()) {
                    resultArea.setText("Erro ao calcular fatorial.");
                } else {
                    BigDecimal result = get();
                    resultArea.setText(result.toString());
                }
            } catch (Exception ex) {
                resultArea.setText("Erro ao calcular fatorial.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FatorialView view = new FatorialView();
            view.setVisible(true);
        });
    }
}
