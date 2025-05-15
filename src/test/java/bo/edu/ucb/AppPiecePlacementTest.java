package bo.edu.ucb;

import org.junit.Test;

public class AppPiecePlacementTest {

    @Test(expected = IllegalArgumentException.class)
    public void testPiezaFueraDelEjeX() {
        App app = new App();
        app.placePiece(-1, 1); // X fuera de rango
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPiezaFueraDelEjeY() {
        App app = new App();
        app.placePiece(1, 3); // Y fuera de rango
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPiezaEnLugarOcupado() {
        App app = new App();
        app.placePiece(1, 1); // Primer movimiento válido
        app.placePiece(1, 1); // Segundo movimiento en el mismo lugar, debe fallar
    }
}