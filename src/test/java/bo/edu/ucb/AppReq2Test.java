package bo.edu.ucb;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppReq2Test {
    @Test
    public void testPrimerTurnoEsX() {
        App juego = new App();
        assertEquals("El primer turno debe ser del jugador X", 'X', juego.getCurrentPlayer());
    }

    @Test
    public void testTurnoSiguienteEsMasLuegoDeX() {
        App juego = new App();
        juego.placePiece(0, 0); // X juega
        assertEquals("Después de X, debe jugar +", '+', juego.getCurrentPlayer());
    }

    @Test
    public void testTurnoSiguienteEsXLuegoDeMas() {
        App juego = new App();
        juego.placePiece(0, 0); // X juega
        juego.placePiece(0, 1); // + juega
        assertEquals("Después de +, debe jugar X", 'X', juego.getCurrentPlayer());
    }
}
