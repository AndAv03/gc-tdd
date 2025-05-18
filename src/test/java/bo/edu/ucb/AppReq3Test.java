package bo.edu.ucb;

import org.junit.Test; // Cambiado de org.junit.jupiter.api.Test
import static org.junit.Assert.assertEquals; // Cambiado de org.junit.jupiter.api.Assertions.assertEquals

public class AppReq3Test {

    // Prueba: Si no se cumple la condicion de victoria, entonces no hay ganador
    @Test
    public void testNoWinner_PartiallyFilledBoard() { // 'public' es requerido en JUnit 4 para los métodos de prueba
        App game = new App();
        // Configuración del tablero para un caso claro sin ganador:
        // X X +
        // + + .
        // X . .
        // Secuencia de jugadas para lograr el estado:
        game.placePiece(0,0); // X, jugador actual -> +
        game.placePiece(1,0); // +, jugador actual -> X
        game.placePiece(0,1); // X, jugador actual -> +
        game.placePiece(1,1); // +, jugador actual -> X
        game.placePiece(2,0); // X, jugador actual -> +
        game.placePiece(0,2); // +, jugador actual -> X
        
        assertEquals("Debería ser ' ' (sin ganador) para un tablero parcialmente lleno sin línea ganadora.", ' ', game.checkWinner()); // Parámetros de assertEquals cambiados de orden para JUnit 4 (mensaje opcional primero)
    }

    @Test
    public void testNoWinner_EmptyBoard() { // 'public' es requerido
        App game = new App();
        assertEquals("Debería ser ' ' (sin ganador) para un tablero vacío.", ' ', game.checkWinner()); // Parámetros de assertEquals cambiados
    }

    // Prueba: Un jugador gana cuando toda una linea horizontal es ocupada por sus piezas
    @Test
    public void testHorizontalWin_PlayerX_Row1() { // 'public' es requerido
        App game = new App();
        // X X X
        // + . +
        // . + .
        game.placePiece(0,0); // X en (0,0), current = +
        game.placePiece(1,0); // + en (1,0), current = X
        game.placePiece(0,1); // X en (0,1), current = +
        game.placePiece(1,2); // + en (1,2), current = X
        game.placePiece(0,2); // X en (0,2) -> X gana
        assertEquals("X debería ganar con la primera fila completa.", 'X', game.checkWinner()); // Parámetros de assertEquals cambiados
    }

    @Test
    public void testHorizontalWin_PlayerPlus_Row3() { // 'public' es requerido
        App game = new App();
        // X . X
        // X X +
        // + + +
        game.placePiece(0,0); // X en (0,0), current = +
        game.placePiece(2,0); // + en (2,0), current = X
        game.placePiece(0,2); // X en (0,2), current = +
        game.placePiece(2,1); // + en (2,1), current = X
        game.placePiece(1,0); // X en (1,0), current = +
        game.placePiece(2,2); // + en (2,2) -> + gana
        assertEquals("+ debería ganar con la tercera fila completa.", '+', game.checkWinner()); // Parámetros de assertEquals cambiados
    }

    // Prueba: Un jugador gana cuando toda una linea vertical es ocupada por sus piezas
    @Test
    public void testVerticalWin_PlayerX_Col1() { // 'public' es requerido
        App game = new App();
        // X + .
        // X + X
        // X . .
        game.placePiece(0,0); // X en (0,0), current = +
        game.placePiece(0,1); // + en (0,1), current = X
        game.placePiece(1,0); // X en (1,0), current = +
        game.placePiece(1,1); // + en (1,1), current = X
        game.placePiece(2,0); // X en (2,0) -> X gana
        assertEquals("X debería ganar con la primera columna completa.", 'X', game.checkWinner()); // Parámetros de assertEquals cambiados
    }

    @Test
    public void testVerticalWin_PlayerPlus_Col3() { // 'public' es requerido
        App game = new App();
        // X X +
        // . X +
        // X . +
        game.placePiece(0,0); // X en (0,0), current = +
        game.placePiece(0,2); // + en (0,2), current = X
        game.placePiece(0,1); // X en (0,1), current = +
        game.placePiece(1,2); // + en (1,2), current = X
        game.placePiece(2,0); // X en (2,0), current = +
        game.placePiece(2,2); // + en (2,2) -> + gana
        assertEquals("+ debería ganar con la tercera columna completa.", '+', game.checkWinner()); // Parámetros de assertEquals cambiados
    }

    // Prueba: Un jugador gana cuando toda una linea diagonal es ocupada por sus piezas
    @Test
    public void testDiagonalWin_PlayerX_MainDiagonal() { // De esquina superior-izquierda a inferior-derecha // 'public' es requerido
        App game = new App();
        // X + .
        // + X .
        // . . X
        game.placePiece(0,0); // X en (0,0), current = +
        game.placePiece(0,1); // + en (0,1), current = X
        game.placePiece(1,1); // X en (1,1), current = +
        game.placePiece(1,0); // + en (1,0), current = X
        game.placePiece(2,2); // X en (2,2) -> X gana
        assertEquals("X debería ganar con la diagonal principal completa.", 'X', game.checkWinner()); // Parámetros de assertEquals cambiados
    }

    @Test
    public void testDiagonalWin_PlayerPlus_AntiDiagonal() { // De esquina superior-derecha a inferior-izquierda // 'public' es requerido
        App game = new App();
        // X X +
        // X + .
        // + . X
        game.placePiece(0,0); // X en (0,0), current = +
        game.placePiece(0,2); // + en (0,2), current = X
        game.placePiece(0,1); // X en (0,1), current = +
        game.placePiece(1,1); // + en (1,1), current = X
        game.placePiece(1,0); // X en (1,0), current = +
        game.placePiece(2,0); // + en (2,0) -> + gana
        assertEquals("+ debería ganar con la diagonal secundaria completa.", '+', game.checkWinner()); // Parámetros de assertEquals cambiados
    }
}
