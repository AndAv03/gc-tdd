package bo.edu.ucb;

import java.util.Scanner;

public class App {
    private char[][] board = new char[3][3];
    private char currentPlayer = 'X';

    public App() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = ' ';
    }

    public void placePiece(int x, int y) {
        if (x < 0 || x >= 3) throw new IllegalArgumentException("X está fuera del tablero");
        if (y < 0 || y >= 3) throw new IllegalArgumentException("Y está fuera del tablero");
        if (board[x][y] != ' ') throw new IllegalArgumentException("Espacio ya ocupado");

        // Validar carácter del jugador
        if (currentPlayer != 'X' && currentPlayer != '+') {
            throw new IllegalStateException("Jugador inválido: " + currentPlayer);
        }

        board[x][y] = currentPlayer;
        switchPlayer();
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? '+' : 'X';
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public char checkWinner() {
        // Revisión de filas
        for (int i = 0; i < 3; i++)
            if (board[i][0] != ' ' &&
                board[i][0] == board[i][1] &&
                board[i][1] == board[i][2])
                return board[i][0];

        // Revisión de columnas
        for (int j = 0; j < 3; j++)
            if (board[0][j] != ' ' &&
                board[0][j] == board[1][j] &&
                board[1][j] == board[2][j])
                return board[0][j];

        // Revisión de diagonales
        if (board[0][0] != ' ' &&
            board[0][0] == board[1][1] &&
            board[1][1] == board[2][2])
            return board[0][0];

        if (board[0][2] != ' ' &&
            board[0][2] == board[1][1] &&
            board[1][1] == board[2][0])
            return board[0][2];

        return ' ';
    }

    public void printBoard() {
        System.out.println("Tablero actual:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("[" + board[i][j] + "]");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        App juego = new App();

        while (true) {
            juego.printBoard();
            System.out.println("Turno del jugador: " + juego.getCurrentPlayer());

            try {
                System.out.print("Ingrese X (0-2): ");
                int x = scanner.nextInt();

                System.out.print("Ingrese Y (0-2): ");
                int y = scanner.nextInt();
                scanner.nextLine(); // Limpiar el salto de línea

                juego.placePiece(x, y);

                char ganador = juego.checkWinner();
                if (ganador != ' ') {
                    juego.printBoard();
                    System.out.println("¡Jugador " + ganador + " ha ganado!");
                    break;
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine(); // Limpiar entrada inválida para evitar bucle
            }
        }

        scanner.close();
    }
}