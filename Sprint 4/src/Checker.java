package src;

import java.awt.*;

public class Checker  {
int count = 0;
    private GUI gui;
    public int scoreRed= 0;
    public int scoreBlue = 0;
    int oldScoreBlue = 0;
    int oldScoreRed=0;
    public Checker(GUI gui){
        this.gui = gui;
    }


    //AC 5.2 Given the game is in progress when a player moves and the game is simple, verify there is no SOS connection
    public boolean checkSimpleGameWinner() {
        count = 0;
        for (int i = 0; i < gui.size - 2; i++) {
            for (int j = 0; j < gui.size; j++) {
                count = 0;
                if (gui.gridButton[i][j]!=null&&gui.gridButton[i][j].getForeground().equals(Color.RED) && gui.gridButton[i][j].getText() == "S") {
                    count++;
                } else
                    count = 0;
                if (gui.gridButton[i + 1][j]!=null&&gui.gridButton[i + 1][j].getForeground().equals(Color.RED) && gui.gridButton[i + 1][j].getText() == "O") {
                    count++;
                } else
                    count = 0;
                if (gui.gridButton[i + 2][j]!=null&&gui.gridButton[i + 2][j].getForeground().equals(Color.RED) && gui.gridButton[i + 2][j].getText() == "S") {
                    count++;
                } else
                    count = 0;
                if (count == 3) {
                    gui.currentTurnLabel.setBackground(Color.RED);
                    gui.bottomPanel.setBackground(Color.RED);
                    gui.currentTurnLabel.setText("RED WINS");
                    gui.gridButton[i][j].setBackground(Color.RED);
                    gui.gridButton[i+1][j].setBackground(Color.RED);
                    gui.gridButton[i+2][j].setBackground(Color.RED);
                    return true;
                }
            }
        }
        // Test AC 5.4
        for (int i = 0; i < gui.size - 2; i++) {
            for (int j = 0; j < gui.size; j++) {
                count = 0;
                if (gui.gridButton[i][j]!=null&&gui.gridButton[i][j].getForeground().equals(Color.BLUE) && gui.gridButton[i][j].getText() == "S") {
                    count++;
                } else
                    count = 0;

                if (gui.gridButton[i + 1][j]!=null&&gui.gridButton[i + 1][j].getForeground().equals(Color.BLUE) && gui.gridButton[i + 1][j].getText() == "O") {
                    count++;
                } else
                    count = 0;
                if (gui.gridButton[i + 2][j]!=null&&gui.gridButton[i + 2][j].getForeground().equals(Color.BLUE) && gui.gridButton[i + 2][j].getText() == "S") {
                    count++;
                } else
                    count = 0;
                if (count == 3) {
                    gui.currentTurnLabel.setBackground(Color.BLUE);
                    gui.bottomPanel.setBackground(Color.BLUE);
                    gui.currentTurnLabel.setText("BLUE WINS");
                    gui.gridButton[i][j].setBackground(Color.BLUE);
                    gui.gridButton[i+1][j].setBackground(Color.BLUE);
                    gui.gridButton[i+2][j].setBackground(Color.BLUE);
                    return true;

                }
            }
        }
        //CHECKING HORIZONTAL NOW
        for (int i = 0; i < gui.size; i++) {
            for (int j = 0; j < gui.size - 2; j++) {
                count = 0;
                if (gui.gridButton[i][j]!=null&&gui.gridButton[i][j].getForeground().equals(Color.RED) && gui.gridButton[i][j].getText() == "S") {
                    count++;
                } else
                    count = 0;
                if (gui.gridButton[i][j + 1]!=null&&gui.gridButton[i][j + 1].getForeground().equals(Color.RED) && gui.gridButton[i][j + 1].getText() == "O") {
                    count++;
                } else
                    count = 0;
                if (gui.gridButton[i][j + 2]!=null&&gui.gridButton[i][j + 2].getForeground().equals(Color.RED) && gui.gridButton[i][j + 2].getText() == "S") {
                    count++;
                } else
                    count = 0;
                if (count == 3) {
                    gui.currentTurnLabel.setBackground(Color.RED);
                    gui.bottomPanel.setBackground(Color.RED);
                    gui.currentTurnLabel.setText("RED WINS");
                    gui.gridButton[i][j].setBackground(Color.RED);
                    gui.gridButton[i][j+1].setBackground(Color.RED);
                    gui.gridButton[i][j+2].setBackground(Color.RED);
                    return true;

                }
            }
        }
        for (int i = 0; i < gui.size; i++) {
            for (int j = 0; j < gui.size - 2; j++) {
                count = 0;
                if (gui.gridButton[i][j]!=null&gui.gridButton[i][j].getForeground().equals(Color.BLUE) && gui.gridButton[i][j].getText() == "S") {
                    count++;
                } else
                    count = 0;

                if (gui.gridButton[i][j + 1]!=null&&gui.gridButton[i][j + 1].getForeground().equals(Color.BLUE) && gui.gridButton[i][j + 1].getText() == "O") {
                    count++;
                } else
                    count = 0;
                if (gui.gridButton[i][j + 2]!=null&&gui.gridButton[i][j + 2].getForeground().equals(Color.BLUE) && gui.gridButton[i][j + 2].getText() == "S") {
                    count++;
                } else
                    count = 0;
                if (count == 3) {
                    gui.currentTurnLabel.setBackground(Color.BLUE);
                    gui.bottomPanel.setBackground(Color.BLUE);
                    gui.currentTurnLabel.setText("BLUE WINS");
                    gui.currentTurnLabel.setText("RED WINS");
                    gui.gridButton[i][j].setBackground(Color.BLUE);
                    gui.gridButton[i][j+1].setBackground(Color.BLUE);
                    gui.gridButton[i][j+2].setBackground(Color.BLUE);
                    return true;
                }
            }
        }
        //CHECKING Diagonal NOW
        for (int i = 0; i < gui.size - 2; i++) {
            for (int j = 0; j < gui.size - 2; j++) {
                count = 0;
                if (gui.gridButton[i][j]!=null&&gui.gridButton[i][j].getForeground().equals(Color.RED) && gui.gridButton[i][j].getText() == "S") {
                    count++;
                } else
                    count = 0;
                if (gui.gridButton[i + 1][j + 1]!=null&&gui.gridButton[i + 1][j + 1].getForeground().equals(Color.RED) && gui.gridButton[i + 1][j + 1].getText() == "O") {
                    count++;
                } else
                    count = 0;
                if (gui.gridButton[i + 2][j + 2]!=null&&gui.gridButton[i + 2][j + 2].getForeground().equals(Color.RED) && gui.gridButton[i + 2][j + 2].getText() == "S") {
                    count++;
                } else
                    count = 0;
                if (count == 3) {
                    gui.currentTurnLabel.setBackground(Color.RED);
                    gui.bottomPanel.setBackground(Color.RED);
                    gui.currentTurnLabel.setText("RED WINS");
                    gui.gridButton[i][j].setBackground(Color.RED);
                    gui.gridButton[i+1][j+1].setBackground(Color.RED);
                    gui.gridButton[i+2][j+2].setBackground(Color.RED);
                    return true;
                }
            }
        }
        for (int i = 0; i < gui.size - 2; i++) {
            for (int j = 0; j < gui.size - 2; j++) {
                count = 0;
                if (gui.gridButton[i][j]!=null&&gui.gridButton[i][j].getForeground().equals(Color.BLUE) && gui.gridButton[i][j].getText() == "S") {
                    count++;
                } else
                    count = 0;

                if (gui.gridButton[i + 1][j + 1]!=null&&gui.gridButton[i + 1][j + 1].getForeground().equals(Color.BLUE) && gui.gridButton[i + 1][j + 1].getText() == "O") {
                    count++;
                } else
                    count = 0;
                if (gui.gridButton[i + 2][j + 2]!=null&&gui.gridButton[i + 2][j + 2].getForeground().equals(Color.BLUE) && gui.gridButton[i + 2][j + 2].getText() == "S") {
                    count++;
                } else
                    count = 0;
                if (count == 3) {
                    gui.currentTurnLabel.setBackground(Color.BLUE);
                    gui.bottomPanel.setBackground(Color.BLUE);
                    gui.currentTurnLabel.setText("BLUE WINS");
                    gui.gridButton[i][j].setBackground(Color.BLUE);
                    gui.gridButton[i+1][j+1].setBackground(Color.BLUE);
                    gui.gridButton[i+2][j+2].setBackground(Color.BLUE);
                    return true;
                }
            }
        }
        //CHECKING OTHER DIAGONAL NOW
        for (int i = 0; i < gui.size-2; i++) {
            for (int j = 2; j < gui.size; j++) {
                count = 0;
                if (gui.gridButton[i][j]!=null&&gui.gridButton[i][j].getForeground().equals(Color.RED) && gui.gridButton[i][j].getText() == "S") {
                    count++;
                } else
                    count = 0;
                if (gui.gridButton[i + 1][j - 1]!=null&&gui.gridButton[i + 1][j - 1].getForeground().equals(Color.RED) && gui.gridButton[i + 1][j - 1].getText() == "O") {
                    count++;
                } else
                    count = 0;
                if (gui.gridButton[i + 2][j - 2]!=null&&gui.gridButton[i + 2][j - 2].getForeground().equals(Color.RED) && gui.gridButton[i + 2][j - 2].getText() == "S") {
                    count++;
                } else
                    count = 0;
                if (count == 3) {
                    gui.currentTurnLabel.setBackground(Color.RED);
                    gui.bottomPanel.setBackground(Color.RED);
                    gui.currentTurnLabel.setText("RED WINS");
                    gui.gridButton[i][j].setBackground(Color.RED);
                    gui.gridButton[i+1][j-1].setBackground(Color.RED);
                    gui.gridButton[i+2][j-2].setBackground(Color.RED);

                    return true;
                }
            }
        }
        for (int i = 0; i < gui.size-2; i++) {
            for (int j = 2; j < gui.size; j++) {
                count = 0;
                if (gui.gridButton[i][j]!=null&&gui.gridButton[i][j].getForeground().equals(Color.BLUE) && gui.gridButton[i][j].getText() == "S") {
                    count++;
                } else
                    count = 0;

                if (gui.gridButton[i + 1][j - 1]!=null&&gui.gridButton[i + 1][j - 1].getForeground().equals(Color.BLUE) && gui.gridButton[i + 1][j - 1].getText() == "O") {
                    count++;
                } else
                    count = 0;
                if (gui.gridButton[i + 2][j - 2]!=null&&gui.gridButton[i + 2][j - 2].getForeground().equals(Color.BLUE) && gui.gridButton[i + 2][j - 2].getText() == "S") {
                    count++;
                } else
                    count = 0;
                if (count == 3) {
                    gui.currentTurnLabel.setBackground(Color.BLUE);
                    gui.bottomPanel.setBackground(Color.BLUE);
                    gui.currentTurnLabel.setText("BLUE WINS");
                    gui.gridButton[i][j].setBackground(Color.BLUE);
                    gui.gridButton[i+1][j-1].setBackground(Color.BLUE);
                    gui.gridButton[i+2][j-2].setBackground(Color.BLUE);
                    return true;
                }
            }
        }
        return checkDraw();
    }

    public boolean checkGeneralGameWinner() {
        count = 0;

        for (int i = 0; i < gui.size - 2; i++) {
            for (int j = 0; j < gui.size; j++) {
                count = 0;
                if (gui.gridButton[i][j]!=null&&gui.gridButton[i][j].getForeground().equals(Color.RED) && gui.gridButton[i][j].getText() == "S") {
                    count++;
                } else
                    count = 0;
                if (gui.gridButton[i + 1][j]!=null&&gui.gridButton[i + 1][j].getForeground().equals(Color.RED) && gui.gridButton[i + 1][j].getText() == "O") {
                    count++;
                } else
                    count = 0;
                if (gui.gridButton[i + 2][j]!=null&&gui.gridButton[i + 2][j].getForeground().equals(Color.RED) && gui.gridButton[i + 2][j].getText() == "S") {
                    count++;
                } else
                    count = 0;
                if (count == 3) {
                    gui.gridButton[i][j].setBackground(Color.RED);
                    gui.gridButton[i + 1][j].setBackground(Color.RED);
                    gui.gridButton[i + 2][j].setBackground(Color.RED);
                    scoreRed++;
                }
            }
        }
        // Test AC 5.4
        for (int i = 0; i < gui.size - 2; i++) {
            for (int j = 0; j < gui.size; j++) {
                count = 0;
                if (gui.gridButton[i][j]!=null&&gui.gridButton[i][j].getForeground().equals(Color.BLUE) && gui.gridButton[i][j].getText() == "S") {
                    count++;
                } else
                    count = 0;

                if (gui.gridButton[i + 1][j]!=null&&gui.gridButton[i + 1][j].getForeground().equals(Color.BLUE) && gui.gridButton[i + 1][j].getText() == "O") {
                    count++;
                } else
                    count = 0;
                if (gui.gridButton[i + 2][j]!=null&&gui.gridButton[i + 2][j].getForeground().equals(Color.BLUE) && gui.gridButton[i + 2][j].getText() == "S") {
                    count++;
                } else
                    count = 0;
                if (count == 3) {

                    gui.gridButton[i][j].setBackground(Color.BLUE);
                    gui.gridButton[i + 1][j].setBackground(Color.BLUE);
                    gui.gridButton[i + 2][j].setBackground(Color.BLUE);

                    scoreBlue++;

                }
            }
        }
        //CHECKING HORIZONTAL NOW
        for (int i = 0; i < gui.size; i++) {
            for (int j = 0; j < gui.size - 2; j++) {
                count = 0;
                if (gui.gridButton[i][j]!=null&&gui.gridButton[i][j].getForeground().equals(Color.RED) && gui.gridButton[i][j].getText() == "S") {
                    count++;
                } else
                    count = 0;
                if (gui.gridButton[i][j + 1]!=null&&gui.gridButton[i][j + 1].getForeground().equals(Color.RED) && gui.gridButton[i][j + 1].getText() == "O") {
                    count++;
                } else
                    count = 0;
                if (gui.gridButton[i][j + 2]!=null&&gui.gridButton[i][j + 2].getForeground().equals(Color.RED) && gui.gridButton[i][j + 2].getText() == "S") {
                    count++;
                } else
                    count = 0;
                if (count == 3) {
                    gui.gridButton[i][j].setBackground(Color.RED);
                    gui.gridButton[i][j + 1].setBackground(Color.RED);
                    gui.gridButton[i][j + 2].setBackground(Color.RED);
                    scoreRed++;
                }
            }
        }
        for (int i = 0; i < gui.size; i++) {
            for (int j = 0; j < gui.size - 2; j++) {
                count = 0;
                if (gui.gridButton[i][j]!=null&gui.gridButton[i][j].getForeground().equals(Color.BLUE) && gui.gridButton[i][j].getText() == "S") {
                    count++;
                } else
                    count = 0;

                if (gui.gridButton[i][j + 1]!=null&&gui.gridButton[i][j + 1].getForeground().equals(Color.BLUE) && gui.gridButton[i][j + 1].getText() == "O") {
                    count++;
                } else
                    count = 0;
                if (gui.gridButton[i][j + 2]!=null&&gui.gridButton[i][j + 2].getForeground().equals(Color.BLUE) && gui.gridButton[i][j + 2].getText() == "S") {
                    count++;
                } else
                    count = 0;
                if (count == 3) {
                    gui.gridButton[i][j].setBackground(Color.BLUE);
                    gui.gridButton[i][j + 1].setBackground(Color.BLUE);
                    gui.gridButton[i][j + 2].setBackground(Color.BLUE);
                    scoreBlue++;

                }
            }
        }
        //CHECKING Diagonal NOW
        for (int i = 0; i < gui.size - 2; i++) {
            for (int j = 0; j < gui.size - 2; j++) {
                count = 0;
                if (gui.gridButton[i][j]!=null&&gui.gridButton[i][j].getForeground().equals(Color.RED) && gui.gridButton[i][j].getText() == "S") {
                    count++;
                } else
                    count = 0;
                if (gui.gridButton[i + 1][j + 1]!=null&&gui.gridButton[i + 1][j + 1].getForeground().equals(Color.RED) && gui.gridButton[i + 1][j + 1].getText() == "O") {
                    count++;
                } else
                    count = 0;
                if (gui.gridButton[i + 2][j + 2]!=null&&gui.gridButton[i + 2][j + 2].getForeground().equals(Color.RED) && gui.gridButton[i + 2][j + 2].getText() == "S") {
                    count++;
                } else
                    count = 0;
                if (count == 3) {
                    gui.gridButton[i][j].setBackground(Color.RED);
                    gui.gridButton[i + 1][j + 1].setBackground(Color.RED);
                    gui.gridButton[i + 2][j + 2].setBackground(Color.RED);

                    scoreRed++;
                }
            }
        }
        for (int i = 0; i < gui.size - 2; i++) {
            for (int j = 0; j < gui.size - 2; j++) {
                count = 0;
                if (gui.gridButton[i][j]!=null&&gui.gridButton[i][j].getForeground().equals(Color.BLUE) && gui.gridButton[i][j].getText() == "S") {
                    count++;
                } else
                    count = 0;

                if (gui.gridButton[i + 1][j + 1]!=null&&gui.gridButton[i + 1][j + 1].getForeground().equals(Color.BLUE) && gui.gridButton[i + 1][j + 1].getText() == "O") {
                    count++;
                } else
                    count = 0;
                if (gui.gridButton[i + 2][j + 2]!=null&&gui.gridButton[i + 2][j + 2].getForeground().equals(Color.BLUE) && gui.gridButton[i + 2][j + 2].getText() == "S") {
                    count++;
                } else
                    count = 0;
                if (count == 3) {
                    gui.gridButton[i][j].setBackground(Color.BLUE);
                    gui.gridButton[i + 1][j + 1].setBackground(Color.BLUE);
                    gui.gridButton[i + 2][j + 2].setBackground(Color.BLUE);
                    scoreBlue++;

                }
            }
        }
        //CHECKING OTHER DIAGONAL NOW
        for (int i = 0; i < gui.size-2; i++) {
            for (int j = 2; j < gui.size; j++) {
                count = 0;
                if (gui.gridButton[i][j]!=null&&gui.gridButton[i][j].getForeground().equals(Color.RED) && gui.gridButton[i][j].getText() == "S") {
                    count++;
                } else
                    count = 0;
                if (gui.gridButton[i + 1][j - 1]!=null&&gui.gridButton[i + 1][j - 1].getForeground().equals(Color.RED) && gui.gridButton[i + 1][j - 1].getText() == "O") {
                    count++;
                } else
                    count = 0;
                if (gui.gridButton[i + 2][j - 2]!=null&&gui.gridButton[i + 2][j - 2].getForeground().equals(Color.RED) && gui.gridButton[i + 2][j - 2].getText() == "S") {
                    count++;
                } else
                    count = 0;
                if (count == 3) {

                    gui.gridButton[i][j].setBackground(Color.RED);
                    gui.gridButton[i+1][j-1].setBackground(Color.RED);
                    gui.gridButton[i+2][j-2].setBackground(Color.RED);
                    scoreRed++;
                }
            }
        }
        for (int i = 0; i < gui.size-2; i++) {
            for (int j = 2; j < gui.size; j++) {
                count = 0;
                if (gui.gridButton[i][j]!=null&&gui.gridButton[i][j].getForeground().equals(Color.BLUE) && gui.gridButton[i][j].getText() == "S") {
                    count++;
                } else
                    count = 0;

                if (gui.gridButton[i + 1][j - 1]!=null&&gui.gridButton[i + 1][j - 1].getForeground().equals(Color.BLUE) && gui.gridButton[i + 1][j - 1].getText() == "O") {
                    count++;
                } else
                    count = 0;
                if (gui.gridButton[i + 2][j - 2]!=null&&gui.gridButton[i + 2][j - 2].getForeground().equals(Color.BLUE) && gui.gridButton[i + 2][j - 2].getText() == "S") {
                    count++;
                } else
                    count = 0;
                if (count == 3) {
                    gui.gridButton[i][j].setBackground(Color.BLUE);
                    gui.gridButton[i+1][j-1].setBackground(Color.BLUE);
                    gui.gridButton[i+2][j-2].setBackground(Color.BLUE);
                    scoreBlue++;

                }
            }
        }
        if (oldScoreBlue != scoreBlue){
            gui.blueAgain=true;
            oldScoreBlue=scoreBlue;
            if (!gui.simpleGameMode) {
                gui.currentTurnLabel.setText("Go again, Blue");
            }
        }
        if (oldScoreRed!=scoreRed){
            gui.redAgain=true;
            oldScoreRed=scoreRed;
            if(!gui.simpleGameMode) {
                gui.currentTurnLabel.setText("Go again, Red");
            }
        }
        System.out.println("Blue: "+scoreBlue +"\nRed: "+scoreRed);
        return checkDraw();
    }

    public boolean checkDraw() {
        //AC 5.1
        //Given: The game is in progress
        //When: a player moves
        //Then: verify that there are empty spots to still move
        int counter = 0;
        for (int i = 0; i < gui.size; i++) {
            for (int j = 0; j < gui.size; j++) {
                if (gui.gridButton[i][j].getText().equals("")) {
                    counter++;
                }
            }
        }
        if (counter == 0 && gui.simpleGameMode)
        {
            gui.currentTurnLabel.setText("DRAW");
            gui.bottomPanel.setForeground(Color.YELLOW);
            return true;
        }
        if(counter == 0)
        {
            if (scoreRed > scoreBlue){
                gui.currentTurnLabel.setText("RED WINS!\n Blue: " + scoreBlue + "\nRed: "+scoreRed);
                gui.bottomPanel.setForeground(Color.RED);
                return false;
            }
            else if (scoreBlue > scoreRed){
                gui.currentTurnLabel.setText("BLUE WINS! \n Blue: " + scoreBlue + "\nRed: "+scoreRed);
                gui.bottomPanel.setForeground(Color.BLUE);
                return false;
            }
            else {
                gui.currentTurnLabel.setText("DRAW \n Blue: "+ scoreBlue + "+ \nRed: "+scoreRed);
                gui.bottomPanel.setForeground(Color.YELLOW);
                return true;
            }
        }
        scoreRed=0;
        scoreBlue=0;
        return false;
    }
}
