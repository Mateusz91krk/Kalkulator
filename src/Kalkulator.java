import javax.swing.*;

public class Kalkulator {
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
        int[][] pozycje = {
                {20, 80}, {90, 80}, {160, 80}, // 7, 8, 9
                {20, 130}, {90, 130}, {160, 130}, // 4, 5, 6
                {20, 180}, {90, 180}, {160, 180}, // 1, 2, 3
                {90, 230} // 0 na dole, na środku
        };

        //Tworzenie i rozmieszczanie przycisków cyfr
        for (int i = 1; i < 10; i++) {
            cyfry[i] = new JButton(String.valueOf(i));
            cyfry[i].setBounds(pozycje[i - 1][0], pozycje[i -1][1], 60, 40);
            frame.add(cyfry[i]);

        }

        // Tworzenie przycisku "0"
        cyfry[0] = new JButton("0");
        cyfry[0].setBounds(pozycje[9][0], pozycje[9][1], 60, 40); // "0" na dole, na środku
        frame.add(cyfry[0]);

        // Wyświetlanie okna
        frame.setVisible(true);
    }
}