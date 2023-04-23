package src;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class GUI implements ActionListener {
    Checker checker = new Checker(this);
    int randI = (int) (Math.random() * 3);
    int randJ = (int) (Math.random() * 3);
    public boolean redAgain = false;
    public boolean blueAgain = false;

    boolean redPlayerTurn = true;
    boolean simpleGameMode = true;

    public int size = 5;
    public JFrame frame;
    public JPanel gridPanel;
    public JPanel leftPanel;
    public JPanel rightPanel;
    public JPanel topPanel;
    public JPanel topRightPanel;
    public JPanel bottomPanel;
    public JPanel bottomLeftPanel;
    public JPanel bottomRightPanel;
    public JPanel button_panel;
    public JButton[][] gridButton;
    public JTextField bSizeText;
    public JRadioButton redHuman;
    public JRadioButton redComputer;
    public JRadioButton redS;
    public JRadioButton redO;
    public JRadioButton blueHuman;
    public JRadioButton blueComputer;
    public JRadioButton blueS;
    public JRadioButton blueO;
    public JRadioButton simpleGame;
    public JRadioButton generalGame;
    public JCheckBox recordGameCheckBox;
    public JLabel currentTurnLabel;
    public JButton replayButton;
    public JButton newGameButton;

    ButtonGroup redLetter;
    ButtonGroup redPerson;
    ButtonGroup blueLetter;
    ButtonGroup bluePerson;
    ButtonGroup gameType;

    public GUI() {
        frame = new JFrame();
        gridPanel = new JPanel(new GridLayout(3, 3));
        leftPanel = new JPanel(new GridLayout(4, 1));
        rightPanel = new JPanel(new GridLayout(4, 1));
        topPanel = new JPanel(new GridLayout(1, 2));
        topRightPanel = new JPanel(new GridLayout(3, 2));
        bottomPanel = new JPanel(new BorderLayout());
        bottomLeftPanel = new JPanel(new BorderLayout());
        bottomRightPanel = new JPanel(new GridLayout(2, 1));
        button_panel = new JPanel();
        gridButton = new JButton[size][size];
        bSizeText = new JTextField("5");
        redHuman = new JRadioButton("Red Human");
        redComputer = new JRadioButton("Red Computer");
        redS = new JRadioButton("S");
        redO = new JRadioButton("O");
        blueHuman = new JRadioButton("Blue Human");
        blueComputer = new JRadioButton("Blue Computer");
        blueS = new JRadioButton("S");
        blueO = new JRadioButton("O");
        simpleGame = new JRadioButton("Simple Game");
        generalGame = new JRadioButton("General Game");
        recordGameCheckBox = new JCheckBox("Record Game");
        currentTurnLabel = new JLabel("Current Turn: Red");
        replayButton = new JButton("Replay");
        newGameButton = new JButton("New Game");

        redLetter = new ButtonGroup();
        redPerson = new ButtonGroup();
        blueLetter = new ButtonGroup();
        bluePerson = new ButtonGroup();
        gameType = new ButtonGroup();

        frame = new JFrame("SOS Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);

        button_panel.setLayout(new GridLayout(size, size));

        redPerson.add(redHuman);
        redHuman.setSelected(true);
        redPerson.add(redComputer);
        redLetter.add(redS);
        redS.setSelected(true);
        redLetter.add(redO);

        bluePerson.add(blueHuman);
        blueHuman.setSelected(true);
        bluePerson.add(blueComputer);
        blueLetter.add(blueS);
        blueS.setSelected(true);
        blueLetter.add(blueO);

        gameType.add(simpleGame);
        simpleGame.setSelected(true);
        gameType.add(generalGame);

        leftPanel.add(blueHuman);
        leftPanel.add(blueS);
        leftPanel.add(blueO);
        leftPanel.add(blueComputer);

        rightPanel.add(redHuman);
        rightPanel.add(redS);
        rightPanel.add(redO);
        rightPanel.add(redComputer);

        topPanel.add(simpleGame);
        topPanel.add(generalGame);

        topRightPanel.add(new JLabel(""));
        topRightPanel.add(new JLabel(""));
        topRightPanel.add(new JLabel("Board Size"));
        topRightPanel.add(bSizeText);
        topRightPanel.add(new JLabel(""));
        topRightPanel.add(new JLabel(""));

        bottomPanel.add(currentTurnLabel);

        bottomLeftPanel.add(recordGameCheckBox);

        bottomRightPanel.add(replayButton);
        bottomRightPanel.add(newGameButton);

        gridPanel.add(new JLabel("SOS")); // add an SOS label to the first location in the grid
        gridPanel.add(topPanel, BorderLayout.NORTH); // add an empty label to the second location in the grid
        gridPanel.add(topRightPanel); // add an empty label to the third location in the grid
        gridPanel.add(leftPanel); // add an empty label to the fourth location in the grid
        gridPanel.add(button_panel);       // add the button to the fifth location in the grid
        gridPanel.add(rightPanel); // add an empty label to the sixth location in the grid
        gridPanel.add(bottomLeftPanel); // add an empty label to the seventh location in the grid
        gridPanel.add(bottomPanel); // add an empty label to the eighth location in the grid
        gridPanel.add(bottomRightPanel); // add an empty label to the ninth location in the grid
        recreateGrid(size);
        frame.add(gridPanel);
        frame.pack();
        frame.setVisible(true);
        newGameButton.addActionListener(this);
    }
    // AC 5.3

    //AC1.1 Given the game screen is displayed\
    void recreateGrid(int setSize) {

        //AC 1.2 - Choose board size
        // Given: the game is displayed
        //  When: the player picks a size
        //Then: verify it is not too small
        size = setSize;
        if (size <= 2) {
            throw new RuntimeException();
        }

            /* AC 1.1 - Choose board size
            Given the game screen is displayed\
            When the player inputs a board size
            Then create a board with that size*/
        //AC 3.2
        //Given: the game is over
        //When: player hits new game
        //Then: reinistialize the board to blank
        button_panel.removeAll();
        button_panel.setLayout(new GridLayout(size, size));
        gridButton = new JButton[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                gridButton[i][j] = new JButton("");
                gridButton[i][j].setFont(new Font("Arial", Font.BOLD, 20));
                gridButton[i][j].addActionListener(this);
                button_panel.add(gridButton[i][j]);
                gridButton[i][j].setOpaque(true);
            }
        }
        // AC 2.1
        //Given: the game is displayed\
        // When: player picks mode
        //Then: update game to mode
        if (simpleGame.isSelected()) {
            simpleGameMode = true;
        } else {
            simpleGameMode = false;
        }

        frame.pack();
    }

    //AC 3.1 with many others
    @Override
    public void actionPerformed(ActionEvent e) {
        newGameButton.addActionListener(new ActionListener() {
            //AC 3.2
            //Given: the game is over
            //When: player hits new game
            //Then: reinistialize the board to blank
            public void actionPerformed(ActionEvent e) {

                size = Integer.parseInt(bSizeText.getText());
                // Recreate the grid with the new size
                recreateGrid(size);
                bottomPanel.setBackground(null);
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        gridButton[i][j].setEnabled(true);
                    }
                }
            }
        });
        //AC 6.1 to 6.6
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                //AC 4.5
                //Given: the game is being played
                //When: Player turn selects size > board
                //Then: do not mark spot and make them choose a valid spot
                if (redHuman.isSelected() && blueHuman.isSelected()) {
                    if (e.getSource() == gridButton[i][j]) {
                        if (redAgain) {
                            redPlayerTurn = true;
                            currentTurnLabel.setText("Go again, Red");
                            redAgain = false;
                        } else if (blueAgain) {
                            redPlayerTurn = false;
                            currentTurnLabel.setText("Go again, Blue");
                            blueAgain = false;
                        }
                        if (redPlayerTurn) {
                            //AC 4.6
                            //Given: the game is being played
                            //When: Player turn selects a non-blank spot
                            //Then: do not mark spot and make them choose a valid spot
                            if (gridButton[i][j].getText().equals("")) {
                                gridButton[i][j].setForeground(Color.RED);
                                // AC 4.1
                                //Given: the game is being played and it is red's turn
                                //When: They pick to place an S
                                //Then: mark spot with selection
                                if (redS.isSelected()) {
                                    gridButton[i][j].setText("S");
                                } else {
                                    //AC 4.2
                                    //Given: the game is being played and it is red's turn
                                    //When: They pick to place an O
                                    //Then: mark spot with selection
                                    gridButton[i][j].setText("O");
                                }
                                redPlayerTurn = false;
                                currentTurnLabel.setText("Blue's Turn");
                                //AC 5.3
                                // given the game is being played
                                // when a player completes a valid move,
                                // then check to see if there is a connection
                                if (simpleGameMode) {
                                    //AC 5.2
                                    //Given: The game is in progress
                                    //When: a player moves and the game is simple
                                    //Then: verify that there is no SOS connection
                                    checker.checkSimpleGameWinner();
                                }

                            }
                        } else {
                            if (gridButton[i][j].getText() == "") {
                                gridButton[i][j].setForeground(Color.BLUE);
                                //AC 4.3
                                //Given: the game is being played and it is blue's turn
                                //When: They pick to place an S
                                //Then: mark spot with selection
                                if (blueS.isSelected()) {
                                    gridButton[i][j].setText("S");
                                }
                                //AC 4.4
                                //Given: the game is being played and it is blue's turn
                                //When: They pick to place an O
                                //Then: mark spot with selection
                                else {
                                    gridButton[i][j].setText("O");
                                }

                                redPlayerTurn = true;
                                currentTurnLabel.setText("Red's Turn");
                                //AC 5.3
                                // given the game is being played
                                // when a player completes a valid move,
                                // then check to see if there is a connection
                                if (simpleGameMode) {
                                    //AC 5.2
                                    //Given: The game is in progress
                                    //When: a player moves and the game is simple
                                    //Then: verify that there is no SOS connection
                                    checker.checkSimpleGameWinner();
                                }
                            }
                        }
                    }
                    //end of human vs human
                }

                //START OF REDHUMAN VS BLUE COMPUTER
                else if (redHuman.isSelected() && blueComputer.isSelected()) {
                    if (e.getSource() == gridButton[i][j]) {
                        if (redAgain) {
                            redPlayerTurn = true;
                            currentTurnLabel.setText("Go again, Red");
                            redAgain = false;
                        } else if (blueAgain) {
                            redPlayerTurn = false;
                            currentTurnLabel.setText("Go again, Blue");
                            blueAgain = false;
                        }
                        if (redPlayerTurn) {
                            //AC 4.6
                            //Given: the game is being played
                            //When: Player turn selects a non-blank spot
                            //Then: do not mark spot and make them choose a valid spot
                            if (gridButton[i][j].getText().equals("")) {
                                gridButton[i][j].setForeground(Color.RED);
                                // AC 4.1
                                //Given: the game is being played and it is red's turn
                                //When: They pick to place an S
                                //Then: mark spot with selection
                                if (redS.isSelected()) {
                                    gridButton[i][j].setText("S");
                                } else {
                                    //AC 4.2
                                    //Given: the game is being played and it is red's turn
                                    //When: They pick to place an O
                                    //Then: mark spot with selection
                                    gridButton[i][j].setText("O");
                                }
                                redPlayerTurn = false;
                                currentTurnLabel.setText("Blue's Turn");
                                //AC 5.3
                                // given the game is being played
                                // when a player completes a valid move,
                                // then check to see if there is a connection
                                if (simpleGameMode) {
                                    //AC 5.2
                                    //Given: The game is in progress
                                    //When: a player moves and the game is simple
                                    //Then: verify that there is no SOS connection
                                    checker.checkSimpleGameWinner();
                                }
                            }
                        } else {
                            while (!gridButton[randI][randJ].getText().equals("")) {
                                // if the randomly chosen spot is already taken, choose another spot
                                randI = (int) (Math.random() * size);
                                randJ = (int) (Math.random() * size);
                            }
                            //AC 4.3
                            //Given: the game is being played and it is blue's turn
                            //When: They pick to place an S
                            //Then: mark spot with selection
                            if (Math.round((Math.random()))==0) {
                                blueS.setSelected(true);
                                gridButton[randI][randJ].setText("S");
                                gridButton[randI][randJ].setForeground(Color.BLUE);
                            }
                            else
                            {
                                blueO.setSelected(true);
                                gridButton[randI][randJ].setText("O");
                                gridButton[randI][randJ].setForeground(Color.BLUE);
                            }

                            redPlayerTurn = true;
                            currentTurnLabel.setText("Red's Turn");
                            //AC 5.3
                            // given the game is being played
                            // when a player completes a valid move,
                            // then check to see if there is a connection
                            if (simpleGameMode) {
                                //AC 5.2
                                //Given: The game is in progress
                                //When: a player moves and the game is simple
                                //Then: verify that there is no SOS connection
                                checker.checkSimpleGameWinner();
                            }
                        }
                    }
                }
                //DONE DONT MOVE STUFF ABOVE THIS
                //redcomputer, bluehuman
                else if (redComputer.isSelected() && blueHuman.isSelected()) {
                    if (e.getSource() == gridButton[i][j]) {
                        if (redAgain) {
                            redPlayerTurn = true;
                            currentTurnLabel.setText("Go again, Red");
                            redAgain = false;
                        } else if (blueAgain) {
                            redPlayerTurn = false;
                            currentTurnLabel.setText("Go again, Blue");
                            blueAgain = false;
                        }
                        if (redPlayerTurn) {
                            //AC 4.6
                            //Given: the game is being played
                            //When: Player turn selects a non-blank spot
                            //Then: do not mark spot and make them choose a valid spot
                            while (!gridButton[randI][randJ].getText().equals("")) {
                                // if the randomly chosen spot is already taken, choose another spot
                                randI = (int) (Math.random() * size);
                                randJ = (int) (Math.random() * size);
                            }
                            //AC 4.3
                            //Given: the game is being played and it is blue's turn
                            //When: They pick to place an S
                            //Then: mark spot with selection
                            if (Math.round((Math.random()))==0) {
                                redS.setSelected(true);
                                gridButton[randI][randJ].setText("S");
                                gridButton[randI][randJ].setForeground(Color.RED);
                            }
                            else
                            {
                                redO.setSelected(true);
                                gridButton[randI][randJ].setText("O");
                                gridButton[randI][randJ].setForeground(Color.RED);
                            }

                            redPlayerTurn = false;
                            currentTurnLabel.setText("Blue's Turn");
                            //AC 5.3
                            // given the game is being played
                            // when a player completes a valid move,
                            // then check to see if there is a connection
                            if (simpleGameMode) {
                                //AC 5.2
                                //Given: The game is in progress
                                //When: a player moves and the game is simple
                                //Then: verify that there is no SOS connection
                                checker.checkSimpleGameWinner();
                            }
                        }
                        else {
                            if (gridButton[i][j].getText() == "") {
                                gridButton[i][j].setForeground(Color.BLUE);
                                //AC 4.3
                                //Given: the game is being played and it is blue's turn
                                //When: They pick to place an S
                                //Then: mark spot with selection
                                if (blueS.isSelected()) {
                                    gridButton[i][j].setText("S");
                                }
                                //AC 4.4
                                //Given: the game is being played and it is blue's turn
                                //When: They pick to place an O
                                //Then: mark spot with selection
                                else {
                                    gridButton[i][j].setText("O");
                                }

                                redPlayerTurn = true;
                                currentTurnLabel.setText("Red's Turn");
                                //AC 5.3
                                // given the game is being played
                                // when a player completes a valid move,
                                // then check to see if there is a connection
                                if (simpleGameMode) {
                                    //AC 5.2
                                    //Given: The game is in progress
                                    //When: a player moves and the game is simple
                                    //Then: verify that there is no SOS connection
                                    checker.checkSimpleGameWinner();
                                }
                            }
                        }
                    }
                }
                //redcomputer, bluecomputer
                else if (redComputer.isSelected() && blueComputer.isSelected()) {
                    if (e.getSource() == gridButton[i][j]) {
                        if (redAgain) {
                            redPlayerTurn = true;
                            currentTurnLabel.setText("Go again, Red");
                            redAgain = false;
                        } else if (blueAgain) {
                            redPlayerTurn = false;
                            currentTurnLabel.setText("Go again, Blue");
                            blueAgain = false;
                        }
                        if (redPlayerTurn) {
                            //AC 4.6
                            //Given: the game is being played
                            //When: Player turn selects a non-blank spot
                            //Then: do not mark spot and make them choose a valid spot
                            while (!gridButton[randI][randJ].getText().equals("")) {
                                // if the randomly chosen spot is already taken, choose another spot
                                randI = (int) (Math.random() * size);
                                randJ = (int) (Math.random() * size);
                            }
                            //AC 4.3
                            //Given: the game is being played and it is blue's turn
                            //When: They pick to place an S
                            //Then: mark spot with selection
                            if (Math.round((Math.random()))==0) {
                                redS.setSelected(true);
                                gridButton[randI][randJ].setText("S");
                                gridButton[randI][randJ].setForeground(Color.RED);
                            }
                            else
                            {
                                redO.setSelected(true);
                                gridButton[randI][randJ].setText("O");
                                gridButton[randI][randJ].setForeground(Color.RED);
                            }

                            redPlayerTurn = false;
                            currentTurnLabel.setText("Blue's Turn");
                            //AC 5.3
                            // given the game is being played
                            // when a player completes a valid move,
                            // then check to see if there is a connection
                            if (simpleGameMode) {
                                //AC 5.2
                                //Given: The game is in progress
                                //When: a player moves and the game is simple
                                //Then: verify that there is no SOS connection
                                checker.checkSimpleGameWinner();
                            }
                        }
                        else {
                            while (!gridButton[randI][randJ].getText().equals("")) {
                                // if the randomly chosen spot is already taken, choose another spot
                                randI = (int) (Math.random() * size);
                                randJ = (int) (Math.random() * size);
                            }
                            //AC 4.3
                            //Given: the game is being played and it is blue's turn
                            //When: They pick to place an S
                            //Then: mark spot with selection
                            if (Math.round((Math.random()))==0) {
                                blueS.setSelected(true);
                                gridButton[randI][randJ].setText("S");
                                gridButton[randI][randJ].setForeground(Color.BLUE);
                            }
                            else
                            {
                                blueO.setSelected(true);
                                gridButton[randI][randJ].setText("O");
                                gridButton[randI][randJ].setForeground(Color.BLUE);
                            }

                            redPlayerTurn = true;
                            currentTurnLabel.setText("Red's Turn");
                            //AC 5.3
                            // given the game is being played
                            // when a player completes a valid move,
                            // then check to see if there is a connection
                            if (simpleGameMode) {
                                //AC 5.2
                                //Given: The game is in progress
                                //When: a player moves and the game is simple
                                //Then: verify that there is no SOS connection
                                checker.checkSimpleGameWinner();
                            }
                        }
                    }

                }
            }

        }
        checker.checkGeneralGameWinner();
    }
}



