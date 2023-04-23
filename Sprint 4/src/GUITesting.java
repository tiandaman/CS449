package src;

import org.junit.Before;
import org.testng.annotations.Test;

import javax.management.RuntimeErrorException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

public class GUITesting extends GUI{
    private GUI gui;
    private Checker checker;

    @Before
    public void setUp() {
        gui = new GUI();
        gui.recreateGrid(5);
        checker = new Checker(gui);
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
        assertTrue(checker.checkSimpleGameWinner());
    }
    @Test
    public void testCheckSimpleGameWinner1() {
        setUp();
        //Test for a simple win
        gui.redPlayerTurn = true;
        gui.gridButton[1][0].setText("S");
        gui.redPlayerTurn = true;
        gui.gridButton[2][0].setText("O");
        gui.redPlayerTurn = true;
        gui.gridButton[3][0].setText("S");
        assertTrue(checker.checkSimpleGameWinner());
    }
    @Test
    public void testCheckSimpleGameWinner2() {
        setUp();
        //Test for a simple win
        gui.redPlayerTurn = true;
        gui.gridButton[0][0].setText("S");
        gui.redPlayerTurn = true;
        gui.gridButton[1][1].setText("O");
        gui.redPlayerTurn = true;
        gui.gridButton[2][2].setText("S");
        assertTrue(checker.checkSimpleGameWinner());
    }
    @Test
    public void testCheckSimpleGameWinner3() {
        setUp();
        //Test for a simple win
        gui.redPlayerTurn = true;
        gui.gridButton[0][2].setText("S");
        gui.redPlayerTurn = true;
        gui.gridButton[1][1].setText("O");
        gui.redPlayerTurn = true;
        gui.gridButton[2][0].setText("S");
        assertTrue(checker.checkSimpleGameWinner());
    }
    @Test
    public void testCheckSimpleGameWinnerRedMove() {
        setUp();
        //Test for a simple win
        gui.redPlayerTurn = true;
        gui.gridButton[0][2].setText("S");
        gui.redPlayerTurn = true;
        gui.gridButton[1][1].setText("S");
        gui.redPlayerTurn = true;
        gui.gridButton[2][0].setText("S");
        assertTrue(checker.checkSimpleGameWinner());
    }

    @Test
    public void testCheckSimpleGameWinnerBlueMove() {
        setUp();
        //Test for a simple win
        gui.redPlayerTurn = false;
        gui.gridButton[0][2].setText("S");
        gui.redPlayerTurn = false;
        gui.gridButton[1][1].setText("S");
        gui.redPlayerTurn = false;
        gui.gridButton[2][0].setText("S");
        assertTrue(checker.checkSimpleGameWinner());
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
        assertFalse(checker.checkSimpleGameWinner());
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
        assertTrue(checker.checkSimpleGameWinner());
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

    @Test
    public void testGameActionPerformed() {
        size = 5;
        recreateGrid(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                assertEquals("", gridButton[i][j].getText());
            }
        }
        //assertThrows(RuntimeException) -> () gui.gridButton[6][6].setText("S");
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
    @Test
    public void testCheckGeneralGameWinner() {
        setUp();
        gui.gridButton[0][0].setForeground(Color.RED);
        gui.gridButton[0][0].setText("S");
        gui.gridButton[1][0].setForeground(Color.RED);
        gui.gridButton[1][0].setText("O");
        gui.gridButton[2][0].setForeground(Color.RED);
        gui.gridButton[2][0].setText("S");
        gui.gridButton[3][0].setForeground(Color.RED);
        gui.gridButton[3][0].setText("S");
        gui.gridButton[4][0].setForeground(Color.RED);
        gui.gridButton[4][0].setText("O");
        gui.gridButton[0][1].setForeground(Color.RED);
        gui.gridButton[0][1].setText("S");
        gui.gridButton[1][1].setForeground(Color.RED);
        gui.gridButton[1][1].setText("O");
        gui.gridButton[2][1].setForeground(Color.RED);
        gui.gridButton[2][1].setText("S");
        gui.gridButton[3][1].setForeground(Color.RED);
        gui.gridButton[3][1].setText("S");
        gui.gridButton[4][1].setForeground(Color.RED);
        gui.gridButton[4][1].setText("O");
        gui.gridButton[0][2].setForeground(Color.RED);
        gui.gridButton[0][2].setText("S");
        gui.gridButton[1][2].setForeground(Color.RED);
        gui.gridButton[1][2].setText("O");
        gui.gridButton[2][2].setForeground(Color.RED);
        gui.gridButton[2][2].setText("S");
        gui.gridButton[3][2].setForeground(Color.RED);
        gui.gridButton[3][2].setText("S");
        gui.gridButton[4][2].setForeground(Color.RED);
        gui.gridButton[4][2].setText("O");
        gui.gridButton[0][3].setForeground(Color.BLUE);
        gui.gridButton[0][3].setText("S");
        gui.gridButton[1][3].setForeground(Color.RED);
        gui.gridButton[1][3].setText("O");
        gui.gridButton[2][3].setForeground(Color.BLUE);
        gui.gridButton[2][3].setText("S");
        gui.gridButton[3][3].setForeground(Color.RED);
        gui.gridButton[3][3].setText("S");
        gui.gridButton[4][3].setForeground(Color.BLUE);
        gui.gridButton[4][3].setText("O");
        gui.gridButton[0][4].setForeground(Color.BLUE);
        gui.gridButton[0][4].setText("S");
        gui.gridButton[1][4].setForeground(Color.BLUE);
        gui.gridButton[1][4].setText("O");
        gui.gridButton[2][4].setForeground(Color.BLUE);
        gui.gridButton[2][4].setText("S");
        gui.gridButton[3][4].setForeground(Color.RED);
        gui.gridButton[3][4].setText("S");
        gui.gridButton[4][4].setForeground(Color.RED);
        gui.gridButton[4][4].setText("O");
        assertTrue(checker.checkGeneralGameWinner());

    }

    @Test
    public void testCheckDraw() {
        // Given
        setUp();
        gui.simpleGameMode = true; // Enable simple game mode
        gui.gridButton[0][0].setForeground(Color.RED);
        gui.gridButton[0][0].setText("S");
        for (int i = 0; i < gui.size; i++) {
            for (int j = 0; j < gui.size; j++) {
                gui.gridButton[i][j].setText("S");
                }
            }
        gui.checker.checkSimpleGameWinner();
        gui.checker.checkDraw();
        assertEquals("DRAW", gui.currentTurnLabel.getText()); // Verify that the label displays "DRAW"
        //assertEquals(Color.YELLOW, gui.bottomPanel.getForeground()); // Verify that the bottom panel is yellow
    }

    @Test
    public void testCheckDrawGeneralMode() {
        // Given
        setUp();
        gui.simpleGameMode = true; // Enable simple game mode
        gui.gridButton[0][0].setForeground(Color.RED);
        gui.gridButton[0][0].setText("S");
        for (int i = 0; i < gui.size; i++) {
            for (int j = 0; j < gui.size; j++) {
                gui.gridButton[i][j].setText("S");
            }
        }
        gui.checker.checkGeneralGameWinner();
        gui.checker.checkDraw();
        assertThat(gui.currentTurnLabel.getText(),containsString("DRAW"));// Verify that the label displays "DRAW"
    }

    @Test
    public void testCheckRedTurn() {
        // Given
        setUp();
        gui.simpleGameMode = true; // Enable simple game mode
        gui.gridButton[0][0].setForeground(Color.RED);
        gui.gridButton[0][0].setText("S");
        gui.gridButton[0][0].setText("S");
        gui.gridButton[0][0].setForeground(Color.RED);
        gui.gridButton[1][0].setText("0");
        gui.gridButton[1][0].setForeground(Color.RED);
        gui.gridButton[2][0].setText("S");
        gui.gridButton[2][0].setForeground(Color.RED);
        for (int i = 0; i < gui.size; i++) {
            for (int j = 0; j < gui.size; j++) {
                if (gui.gridButton[i][j].equals(""))
                {
                    gui.gridButton[0][j].setText("S");
                    gui.gridButton[0][j].setForeground(Color.RED);
                }
            }
        }
        gui.checker.checkSimpleGameWinner();
        gui.checker.checkDraw();
        assertEquals("Current Turn: Red", gui.currentTurnLabel.getText()); // Verify that the label displays "DRAW"
    }
    @Test
    public void testCheckDrawBlueWins2() {
        setUp();
        gui.recreateGrid(3);
        gui.simpleGameMode = false;
        gui.gridButton[0][0].setForeground(Color.BLUE);
        gui.gridButton[0][0].setText("S");
        gui.gridButton[1][0].setForeground(Color.BLUE);
        gui.gridButton[1][0].setText("O");
        gui.gridButton[2][0].setForeground(Color.BLUE);
        gui.gridButton[2][0].setText("S");
        for (int i = 0; i < gui.size; i++) {
            for (int j = 0; j < gui.size; j++) {
                if (gui.gridButton[i][j].equals(""))
                {
                    gui.gridButton[0][j].setText("S");
                    gui.gridButton[0][j].setForeground(Color.RED);
                }
            }
        }
        checker.scoreRed = 2;
        checker.scoreBlue = 3;
        gui.checker.checkGeneralGameWinner();
        assertThat(gui.currentTurnLabel.getText(), containsString("Blue"));
    }
    @Test
    public void testCheckDrawDraw2() {
        setUp();
        gui.recreateGrid(5);
        gui.simpleGameMode = false;
        gui.gridButton[0][0].setForeground(Color.RED);
        gui.gridButton[0][0].setText("S");
        gui.gridButton[1][0].setForeground(Color.RED);
        gui.gridButton[1][0].setText("O");
        gui.gridButton[2][0].setForeground(Color.RED);
        gui.gridButton[2][0].setText("S");
        gui.gridButton[3][0].setForeground(Color.RED);
        gui.gridButton[3][0].setText("0");
        gui.gridButton[4][0].setForeground(Color.RED);
        gui.gridButton[4][0].setText("S");
        gui.gridButton[0][1].setForeground(Color.BLUE);
        gui.gridButton[0][1].setText("S");
        gui.gridButton[1][1].setForeground(Color.BLUE);
        gui.gridButton[1][1].setText("O");
        gui.gridButton[2][1].setForeground(Color.BLUE);
        gui.gridButton[2][1].setText("S");
        gui.gridButton[3][1].setForeground(Color.BLUE);
        gui.gridButton[3][1].setText("O");
        gui.gridButton[4][1].setForeground(Color.BLUE);
        gui.gridButton[4][1].setText("S");
        gui.gridButton[0][2].setForeground(Color.BLUE);
        gui.gridButton[0][2].setText("O");
        gui.gridButton[1][2].setForeground(Color.BLUE);
        gui.gridButton[1][2].setText("O");
        gui.gridButton[2][2].setForeground(Color.RED);
        gui.gridButton[2][2].setText("O");
        gui.gridButton[3][2].setForeground(Color.RED);
        gui.gridButton[3][2].setText("O");
        gui.gridButton[4][2].setForeground(Color.RED);
        gui.gridButton[4][2].setText("O");
        gui.gridButton[0][3].setForeground(Color.BLUE);
        gui.gridButton[0][3].setText("O");
        gui.gridButton[1][3].setForeground(Color.RED);
        gui.gridButton[1][3].setText("O");
        gui.gridButton[2][3].setForeground(Color.BLUE);
        gui.gridButton[2][3].setText("O");
        gui.gridButton[3][3].setForeground(Color.RED);
        gui.gridButton[3][3].setText("O");
        gui.gridButton[4][3].setForeground(Color.BLUE);
        gui.gridButton[4][3].setText("O");
        gui.gridButton[0][4].setForeground(Color.BLUE);
        gui.gridButton[0][4].setText("O");
        for (JButton jButton : Arrays.asList(gui.gridButton[1][4], gui.gridButton[2][4])) {
            jButton.setForeground(Color.BLUE);
            jButton.setText("O");
        }
        gui.gridButton[3][4].setForeground(Color.RED);
        gui.gridButton[3][4].setText("S");
        gui.gridButton[4][4].setForeground(Color.RED);
        gui.gridButton[4][4].setText("O");
        checker.scoreRed = 2;
        checker.scoreBlue = 2;
        boolean result = checker.checkDraw();
        assertTrue(result);
        assertEquals("DRAW \n Blue: 2+ \nRed: 2", gui.currentTurnLabel.getText());
    }

// 8.1 AC
    @Test
    public void testRedComputerVsBlueHuman() {
        setUp();
        gui.redComputer.setSelected(true);
        gui.blueHuman.setSelected(true);

        gui.gridButton[0][0].doClick();
        assertEquals("wrong label", "Blue's Turn", gui.currentTurnLabel.getText());

        // Test making a valid move for the blue
        gui.gridButton[0][0].doClick();
        assertEquals("wrong label", "Red's Turn", gui.currentTurnLabel.getText());

        gui.redPlayerTurn=true;
        // Test making a valid move for the red computer
        for (int i = 0; i < gui.size; i++) {
            for (int j = 0; j < gui.size; j++) {
                if (gui.gridButton[i][j].getText().equals("")) {
                    gui.gridButton[i][j].doClick();
                    break;
                }
            }
        }
        assertEquals("wrong label", "Blue's Turn", gui.currentTurnLabel.getText());

        // Test completing a line in simple mode
        newGameButton.doClick();
        gui.simpleGame.setSelected(true);
        redPlayerTurn = true;
        gui.gridButton[1][1].setText("S");
        redPlayerTurn = true;
        gui.gridButton[1][2].setText("O");
        redPlayerTurn = true;
        gui.gridButton[1][3].setText("S");
        gui.checker.checkSimpleGameWinner();
        assertTrue("game over simple", gui.checker.checkSimpleGameWinner());
    }

//8.3 AC
    @Test
    public void testRedComputerVsBlueComputer() {
        setUp();
        gui.redComputer.setSelected(true);
        gui.blueComputer.setSelected(true);

        assertTrue("Red should have the first turn", gui.redPlayerTurn);
        assertEquals("wrong label", "Current Turn: Red", gui.currentTurnLabel.getText());

        // Test making a valid move for the red computer
        for (int i = 0; i < gui.size; i++) {
            for (int j = 0; j < gui.size; j++) {
                if (gui.gridButton[i][j].getText().equals("")) {
                    gui.gridButton[i][j].doClick();
                    break;
                }
            }
        }
        assertEquals("wrong label", "Blue's Turn", gui.currentTurnLabel.getText());

        // Test making a valid move for the blue computer
        for (int i = 0; i < gui.size; i++) {
            for (int j = 0; j < gui.size; j++) {
                if (gui.gridButton[i][j].getText().equals("")) {
                    gui.gridButton[i][j].doClick();
                    break;
                }
            }
        }
        assertEquals("wrong label", "Red's Turn", gui.currentTurnLabel.getText());

        // Test completing a line in simple mode
        gui.newGameButton.doClick();
        gui.simpleGame.setSelected(true);
        assertTrue("Red should have the first turn", gui.redPlayerTurn);
        redPlayerTurn=true;
        gui.gridButton[1][1].setText("S");
        assertFalse("Red should not have won yet", gui.checker.checkSimpleGameWinner());
        redPlayerTurn=true;
        gui.gridButton[1][2].setText("O");
        assertFalse("Red should not have won yet", gui.checker.checkSimpleGameWinner());
        redPlayerTurn=true;
        gui.gridButton[1][3].setText("S");
        assertTrue("game over red wins", gui.checker.checkSimpleGameWinner());
    }

    //8.2 AC
    @Test
    public void testRedHumanVsBlueComputer() {
        setUp();
        gui.redHuman.setSelected(true);
        gui.blueComputer.setSelected(true);


        // Test making a valid move for the red human
        gui.gridButton[0][0].doClick();
        assertEquals("wrong label", "Blue's Turn", gui.currentTurnLabel.getText());

        // Test making a valid move for the blue computer
        for (int i = 0; i < gui.size; i++) {
            for (int j = 0; j < gui.size; j++) {
                if (gui.gridButton[i][j].getText().equals("")) {
                    gui.gridButton[i][j].doClick();
                    break;
                }
            }
        }
        assertEquals("wrong label", "Red's Turn", gui.currentTurnLabel.getText());

        // Test completing a line in simple mode
        newGameButton.doClick();
        gui.simpleGame.setSelected(true);
        redPlayerTurn = true;
        gui.gridButton[1][1].setText("S");
        redPlayerTurn = true;
        gui.gridButton[1][2].setText("O");
        redPlayerTurn = true;
        gui.gridButton[1][3].setText("S");
        gui.checker.checkSimpleGameWinner();
        assertTrue("game over simple", gui.checker.checkSimpleGameWinner());

    }
}