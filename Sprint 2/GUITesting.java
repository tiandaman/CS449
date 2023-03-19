import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.awt.event.ActionEvent;

import static org.junit.Assert.*;

public class GUITesting extends GUI{
    private GUI gui;

    @Before
    public void setUp() {
        gui = new GUI();
        gui.recreateGrid(5);
    }

    // Test for AC 5.3 & 5.4

    // Test for AC 2.1
    @Test
    public void testSimpleGameMode(){
        setUp();
        gui.simpleGame.doClick();
        assertTrue(simpleGameMode = true);
    }
    @Test
    public void testSimpleGameMode2(){
        gui.generalGame.setSelected(false);
        assertTrue(simpleGameMode = true);
    }

    @Test
    public void testGeneralGameMode2(){
        setUp();
        gui.generalGame.doClick();
        assertTrue(simpleGameMode);
    }
    // Test for AC 5.3 and 5.4
    @Test
    public void testCheckSimpleGameWinner() {
        setUp();
        //Test for a simple win
        gui.redPlayerTurn = true;
        gui.gridButton[0][0].setText("S");
        gui.redPlayerTurn = true;
        gui.gridButton[0][1].setText("O");
        gui.redPlayerTurn = true;
        gui.gridButton[0][2].setText("S");
        assertTrue(gui.checkSimpleGameWinner());
    }
    @Test
    public void testCheckSimpleGameWinnerForDrawFalse(){
        //Test for a draw
        gui.size=3;
        gui.recreateGrid(gui.size);
        gui.gridButton[1][0].setText("O");
        gui.gridButton[1][1].setText("S");
        gui.gridButton[1][2].setText("O");
        gui.gridButton[2][0].setText("S");
        gui.gridButton[2][1].setText("O");
        gui.gridButton[2][2].setText("S");
        assertFalse(gui.checkSimpleGameWinner());
    }
    @Test
    public void testCheckSimpleGameWinnerForDrawTrue(){
        // Test for a draw
        gui.size=3;
        gui.recreateGrid(gui.size);
        gui.gridButton[0][0].setText("O");
        gui.gridButton[0][1].setText("O");
        gui.gridButton[0][2].setText("O");
        gui.gridButton[1][0].setText("O");
        gui.gridButton[1][1].setText("O");
        gui.gridButton[1][2].setText("O");
        gui.gridButton[2][0].setText("O");
        gui.gridButton[2][1].setText("O");
        gui.gridButton[2][2].setText("O");
        assertTrue(gui.checkSimpleGameWinner());
    }
    @Test
    public void testRecreateGridLarge() {
        //test that grid is correctly recreated with update dsize
        gui.recreateGrid(7);
        assertEquals(7, gui.size);
        assertEquals(7, gui.gridButton.length);
        assertEquals(7, gui.gridButton[0].length);
    }
    @Test
    public void testNewGameButton() {
        //Ttest that it resets the game
        setUp();
        size = 5;
        redPlayerTurn = true;
        gui.gridButton[0][0].doClick();
        gui.gridButton[0][1].setText("O");
        gui.gridButton[0][2].setText("S");
        assertSame(gui.gridButton[0][0].getText(),"S");
        gui.newGameButton.doClick();
        assertSame(gui.gridButton[0][0].getText(),"");
    }
    @Test
    public void testRecreateGridSmall(){
        gui.recreateGrid(2);
        assertThrows(RuntimeException.class, () ->gui.recreateGrid(2));

    }
    @Test
    public void testNewGameButtonActionListener() {

        gui.newGameButton.doClick();
        assertTrue(gui.newGameButton.getActionListeners().length > 0);
    }
    @Test
    public void testNewGameButtonActionListenerBackground() {
        gui.newGameButton.doClick();
        assertNull(gui.bottomPanel.getBackground());
    }
    //Test AC 3.2
    @Test
    public void testNewGameActionPerformed() {
        size = 5;
        recreateGrid(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                assertEquals("", gridButton[i][j].getText());
            }
        }
    }
    //Test AC 4.1
    @Test
    public void testRedSSelected() {
        setUp();
        size = 5;
        redS.setSelected(true);
        redPlayerTurn = true;
        gridButton[2][3].doClick();
        assertEquals("S", gridButton[2][3].getText());

    }
    //Test AC 4.2
    @Test
    public void testRedOSelected() {
        setUp();
        size = 5;
        gui.redO.setSelected(true);
        gui.redPlayerTurn = true;
        gui.gridButton[2][3].doClick();
        assertEquals("O", gui.gridButton[2][3].getText());
    }
    //Test AC 4.3
    @Test
    public void testBlueSSelected() {
        size = 5;
        blueS.setSelected(true);
        redPlayerTurn = false;
        gridButton[2][3].doClick();
        assertEquals("S",gridButton[2][3].getText());
    }
    //Test AC 4.4
    @Test
    public void testBlueOSelected() {
        size = 5;
        blueO.setSelected(true);
        redPlayerTurn = false;
        gridButton[2][3].doClick();
        assertEquals("O", gridButton[2][3].getText());
    }
    //Test AC 4.5
    @Test
    public void testInvalidMoveSelected() {
        setUp();
        redS.setSelected(true);
        redPlayerTurn = true;
        assertThrows(RuntimeException.class, () ->(gridButton[6][3]).setText("O"));
    }
    @Test
    //Test AC 4.6
    public void testNonBlankSpot(){
        setUp();
        gui.gridButton[0][0].setText("S");
        gui.blueO.setSelected(true);
        gui.gridButton[0][0].doClick();
        assertEquals("S", gui.gridButton[0][0].getText());
    }


}
