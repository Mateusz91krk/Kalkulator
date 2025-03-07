import javax.swing.*;

public class Kalkulator {

    private static double pierwszaLiczba = 0;
    private static double drugaLiczba = 0;
    private static String operator = "";

    public static void main(String[] args) {
        // Tworzymy okno aplikacji
        JFrame frame = new JFrame("Kalkulator");
        frame.setSize(300, 400); // Ustawienie rozmiaru okna
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Zamknięcie aplikacji po kliknięciu "X"
        frame.setLayout(null); // Włączamy domyślny układ

        // Tworzenie pola tekstowego
        JTextField poleTekstowe = new JTextField();
        poleTekstowe.setBounds(20, 20, 240, 40); // Ustawienie pozycji i rozmiaru
        frame.add(poleTekstowe); // Dodanie pola do okna

        // Tablica do przechowywania przycisków
        JButton[] cyfry = new JButton[10];

        // Układ przycisków jak w klasycznym kalkulatorze
        int[][] pozycjeCyfr = {
                {20, 180}, {90, 180}, {160, 180}, // 1, 2, 3
                {20, 130}, {90, 130}, {160, 130}, // 4, 5, 6
                {20, 80}, {90, 80}, {160, 80}, // 7, 8, 9
                {20, 230} // 0 na dole, po lewej
        };

        // Tablica do przechowywania przycisków operacji
        JButton[] operacje = {new JButton("+"), new JButton("-"), new JButton("*"), new JButton("/")};
        JButton btnEquals = new JButton("=");

        // Układ przycisków operacji matematycznych
        int[][] pozycjeOperacji = {
                {230, 80},  // "+"
                {230, 130}, // "-"
                {230, 180}, // "*"
                {230, 230}  // "/"
        };
        btnEquals.setBounds(160, 230, 60, 40); // "=" pod przyciskiem "9"
        frame.add(btnEquals);

        //Tworzenie i rozmieszczanie przycisków cyfr
        for (int i = 1; i < 10; i++) {
            cyfry[i] = new JButton(String.valueOf(i));
            cyfry[i].setBounds(pozycjeCyfr[i - 1][0], pozycjeCyfr[i -1][1], 60, 40);
            frame.add(cyfry[i]);
        }

        // Tworzenie przycisku "0"
        cyfry[0] = new JButton("0");
        cyfry[0].setBounds(pozycjeCyfr[9][0], pozycjeCyfr[9][1], 60, 40); // "0" na dole, po lewej
        frame.add(cyfry[0]);

        // Tworzenie i rozmieszczenie przycisków operacji matematycznych
        for (int i = 0; i < operacje.length; i++) {
            operacje[i].setBounds(pozycjeOperacji[i][0], pozycjeOperacji[i][1], 50, 40);
            frame.add(operacje[i]);
        }

        // Przypisanie akcji do przycisków operacji
        operacje[0].addActionListener(e -> {
            pierwszaLiczba = Double.parseDouble(poleTekstowe.getText());
            operator = "+";
            poleTekstowe.setText("");
        });

        operacje[1].addActionListener(e -> {
            pierwszaLiczba = Double.parseDouble(poleTekstowe.getText());
            operator = "-";
            poleTekstowe.setText("");
        });

        operacje[2].addActionListener(e -> {
            pierwszaLiczba = Double.parseDouble(poleTekstowe.getText());
            operator = "*";
            poleTekstowe.setText("");
        });

        operacje[3].addActionListener(e -> {
            pierwszaLiczba = Double.parseDouble(poleTekstowe.getText());
            operator = "/";
            poleTekstowe.setText("");
        });

        // Przypisanie akcji do przycisku "="
        btnEquals.addActionListener(e -> {
            if (poleTekstowe.getText().isEmpty()) {
                drugaLiczba = Double.parseDouble(poleTekstowe.getText());
                double wynik = 0;

                switch (operator) {
                    case "+":
                        wynik = pierwszaLiczba + drugaLiczba;
                        break;
                    case "-":
                        wynik = pierwszaLiczba - drugaLiczba;
                        break;
                    case "*":
                        wynik = pierwszaLiczba * drugaLiczba;
                        break;
                    case "/":
                        if (drugaLiczba != 0) {
                            wynik = pierwszaLiczba / drugaLiczba;
                        } else {
                            poleTekstowe.setText("Błąd");
                            return;
                        }
                        break;
                }
                poleTekstowe.setText(String.valueOf(wynik)); // Wyświetlenie wyniku
            }
        });

      // Wyświetlanie okna
        frame.setVisible(true);
    }
}