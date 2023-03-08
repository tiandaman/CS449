import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
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

	public int size = 5;

  public GUI() {
	  
	  JFrame frame = new JFrame();
	  JPanel gridPanel = new JPanel(new GridLayout(3, 3));
	  JPanel leftPanel = new JPanel(new GridLayout(4,1));
	  JPanel rightPanel = new JPanel(new GridLayout(4,1));
	  JPanel topPanel = new JPanel(new GridLayout(1,2));
	  JPanel topRightPanel = new JPanel(new GridLayout(3,2));
	  JPanel bottomPanel = new JPanel(new BorderLayout());
	  JPanel bottomLeftPanel= new JPanel(new BorderLayout());
	  JPanel bottomRightPanel = new JPanel(new GridLayout(2,1));
	  JPanel button_panel = new JPanel();
	  JButton[][] gridButton = new JButton[size][size];
	  JTextField bSizeText = new JTextField("2");
	  JRadioButton redHuman = new JRadioButton("Human");
	  JRadioButton redComputer = new JRadioButton("Computer");
	  JRadioButton redS = new JRadioButton("S");
	  JRadioButton redO = new JRadioButton("O");
	  JRadioButton blueHuman = new JRadioButton("Human");
	  JRadioButton blueComputer = new JRadioButton("Computer");
	  JRadioButton blueS = new JRadioButton("S");
	  JRadioButton blueO = new JRadioButton("O");
	  JRadioButton simpleGame = new JRadioButton("Simple Game");
	  JRadioButton generalGame = new JRadioButton("General Game");
	  JCheckBox recordGameCheckBox = new JCheckBox("Record Game");
	  JLabel currentTurnLabel = new JLabel("Current Turn");
	  JButton replayButton = new JButton("Replay");
	  JButton newGameButton = new JButton("New Game");
	  
	  
	  ButtonGroup redLetter = new ButtonGroup();
	  ButtonGroup redPerson = new ButtonGroup();
	  ButtonGroup blueLetter = new ButtonGroup();
	  ButtonGroup bluePerson = new ButtonGroup();
	  ButtonGroup gameType = new ButtonGroup();
	  
	  frame = new JFrame("SOS Game");
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  
	  button_panel.setLayout(new GridLayout(size,size));
			  
	  redPerson.add(redHuman);
	  redPerson.add(redComputer);
	  redLetter.add(redS);
	  redLetter.add(redO);
	  
	  bluePerson.add(blueHuman);
	  bluePerson.add(blueComputer);
	  blueLetter.add(blueS);
	  blueLetter.add(blueO);
	  
	  gameType.add(simpleGame);
	  gameType.add(generalGame);
	  
	  leftPanel.add(blueHuman);
	  leftPanel.add(blueComputer);
	  leftPanel.add(blueS);
	  leftPanel.add(blueO);
	  
	  rightPanel.add(redHuman);
	  rightPanel.add(redS,Font.BOLD);
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
	  
	  for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++) {
				gridButton[i][j] = new JButton();
				button_panel.add(gridButton[i][j]);
				gridButton[i][j].setFont(new Font("MV Boli",Font.BOLD,20));
				gridButton[i][j].setFocusable(false);
				gridButton[i][j].addActionListener(this);
			}	
		}

	  gridPanel.add(new JLabel("SOS")); // add an empty label to the first location in the grid
	  gridPanel.add(topPanel,BorderLayout.NORTH); // add an empty label to the second location in the grid
	  gridPanel.add(topRightPanel); // add an empty label to the third location in the grid
	  gridPanel.add(leftPanel); // add an empty label to the fourth location in the grid
	  gridPanel.add(button_panel);       // add the button to the fifth location in the grid
	  gridPanel.add(rightPanel); // add an empty label to the sixth location in the grid
	  gridPanel.add(bottomLeftPanel); // add an empty label to the seventh location in the grid
	  gridPanel.add(bottomPanel); // add an empty label to the eighth location in the grid
	  gridPanel.add(bottomRightPanel); // add an empty label to the ninth location in the grid

	
    frame.add(gridPanel);
	    frame.pack();
	    frame.setVisible(true);
    

  }

  public static void main(String[] args) {
    new GUI();
    
  }

@Override
public void actionPerformed(ActionEvent e) {
	//this will be how i update buttons and stuff.
	
	
	
}
  
  
}

