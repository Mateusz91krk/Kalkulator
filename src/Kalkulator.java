import javax.swing.*;

public class Kalkulator {

    private static double pierwszaLiczba = 0;
    private static double drugaLiczba = 0;
    private static String operator = "";
    private static boolean wpisywanieDrugiejLiczby = false;

    public static void main(String[] args) {
        // Tworzenie okna aplikacji
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
                {20, 230}, {90, 230}, {160, 230}, // 1, 2, 3
                {20, 180}, {90, 180}, {160, 180}, // 4, 5, 6
                {20, 130}, {90, 130}, {160, 130}, // 7, 8, 9
                {20, 280} // 0 na dole, po lewej
        };

        // Tablica do przechowywania przycisków operacji
        JButton[] operacje = {new JButton("+"), new JButton("-"), new JButton("*"), new JButton("/")};
        JButton btnEquals = new JButton("=");

        // Układ przycisków operacji matematycznych
        int[][] pozycjeOperacji = {
                {230, 130},  // "+"
                {230, 180}, // "-"
                {230, 230}, // "*"
                {230, 280}  // "/"
        };
        btnEquals.setBounds(160, 280, 60, 40); // "=" pod przyciskiem "9"
        frame.add(btnEquals);

        //Tworzenie i rozmieszczanie przycisków cyfr (1-9)
        for (int i = 1; i < 10; i++) {
            cyfry[i] = new JButton(String.valueOf(i));
            cyfry[i].setBounds(pozycjeCyfr[i - 1][0], pozycjeCyfr[i -1][1], 60, 40);
            frame.add(cyfry[i]);
        }

        // Tworzenie przycisku "0" przed dodawaniem ActionListener
        cyfry[0] = new JButton("0");
        cyfry[0].setBounds(pozycjeCyfr[9][0], pozycjeCyfr[9][1], 60, 40); // "0" na dole, po lewej
        frame.add(cyfry[0]);

        // Tworzenie przycisku "C"
        JButton btnClear = new JButton("C");
        btnClear.setBounds(160, 80, 120, 40); // "C" w prawym górnym rogu
        frame.add(btnClear);
        btnClear.addActionListener(e -> poleTekstowe.setText(""));

        // Tworzenie przecinka
        JButton btnComma = new JButton(",");
        btnComma.setBounds(90, 280, 60, 40); // "," między "0" a "="
        frame.add(btnComma);
        btnComma.addActionListener(e -> {
            if (!poleTekstowe.getText().contains(",")) { // Sprawdzanie, czy nie ma już przecinka
                poleTekstowe.setText(poleTekstowe.getText() + ",");
            }
        });

        // Teraz cyfra "0" istnieje, więc można dodać ActionListener
        for (int i = 0; i < 10; i++) {
            int numer = i; // Potrzebne do poprawnego działania w lambdzie
            cyfry[i].addActionListener(e -> {
                if (wpisywanieDrugiejLiczby) {
                    poleTekstowe.setText(String.valueOf(numer));
                    wpisywanieDrugiejLiczby = false;
                } else {
                    poleTekstowe.setText(poleTekstowe.getText() + numer);
                }
            });
        }

        // Tworzenie i rozmieszczenie przycisków operacji matematycznych
        for (int i = 0; i < operacje.length; i++) {
            operacje[i].setBounds(pozycjeOperacji[i][0], pozycjeOperacji[i][1], 50, 40);
            frame.add(operacje[i]);
        }

        // Przypisanie akcji do przycisków operacji
        operacje[0].addActionListener(e -> {
            pierwszaLiczba = Double.parseDouble(poleTekstowe.getText().replace(",", "."));
            operator = "+";
            wpisywanieDrugiejLiczby = true;
        });

        operacje[1].addActionListener(e -> {
            pierwszaLiczba = Double.parseDouble(poleTekstowe.getText().replace(",", "."));
            operator = "-";
            wpisywanieDrugiejLiczby = true;
        });

        operacje[2].addActionListener(e -> {
            pierwszaLiczba = Double.parseDouble(poleTekstowe.getText().replace(",", "."));
            operator = "*";
            wpisywanieDrugiejLiczby = true;
        });

        operacje[3].addActionListener(e -> {
            pierwszaLiczba = Double.parseDouble(poleTekstowe.getText().replace(",", "."));
            operator = "/";
            wpisywanieDrugiejLiczby = true;
        });

        // Przypisanie akcji do przycisku "="
        btnEquals.addActionListener(e -> {
            if (!poleTekstowe.getText().isEmpty()) { //Sprawdzanie, czy pole NIE jest puste
                drugaLiczba = Double.parseDouble(poleTekstowe.getText().replace(",", "."));
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

                // Sprawdzenie, czy wynik jest liczbą całkowitą
                if (wynik == (int) wynik) {
                    poleTekstowe.setText(String.format("%d", (int) wynik)); // Wyświetlanie jako liczba całkowita
                } else {
                    poleTekstowe.setText(String.format("%s", String.valueOf(wynik).replace(".", ",")));
                    // Wyświetlanie jako liczba dziesiętna
                }
            }
        });

      // Wyświetlanie okna
        frame.setVisible(true);
    }
}