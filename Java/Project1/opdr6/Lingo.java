package opdr6;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Lingo extends GUI{
	private JTextField input = new JTextField("", 5);
	private JButton submit = new JButton("Voer in");
	private ArrayList<JLabel> woorden = new ArrayList<JLabel>();
	private JLabel feedback = new JLabel("");
	private Timer timer;
	
	private String antwoord = "worst";
	private int maxBedenktijd = 10; //in seconden
	private int bedenktijd = maxBedenktijd;
	private JLabel bedenktijd_label = new JLabel();
	
	private int speler = 1;
	private int poging = 1;
	private JLabel info = new JLabel();
	
	public Lingo(int width, int height, String title) {
		super(width, height, title);
		//voeg elementen toe aan GUI
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(info);
		gbc.gridy = 1;
		add(bedenktijd_label);
		
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		add(feedback);
		gbc.gridwidth = 1;
		
		gbc.gridy = 3;
		add(input);
		input.addActionListener(this);
		gbc.gridx = 1;
		add(submit);
		submit.addActionListener(this);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		for (int i = 0; i < 5; i++) {
			woorden.add(new JLabel(""));
		}
		for (JLabel label : woorden) {
			add(label, true);
		}
		
		// Geef eerste letter van het atwoord en zet cursor erachter
		input.setText(antwoord.charAt(0) + "");
		input.setCaretPosition(1); 
		
		//Update label text(info & bedenktijd)
		updateLabels();
		
		//Maak GUI zichtbaar
		setVisible(true);
		
		//start bedenktijd
		timer = new Timer(1000, this);
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == timer) {
			bedenktijd--;
			if (bedenktijd <= 0) {
				resetBedenktijd();
				switchSpeler();
				poging = 1;
				
			}
			updateLabels();
		} else if (event.getSource() == submit || event.getSource() == input) {
			// Lees de input van de user af
			String woord = input.getText();
			
			//Controleer of het woord geldig is //TODO 02 Controleer op andere ongeldige woorden
			feedback.setText("");
			if (woord.equals("")) {
				feedback.setText("Vul een woord in!");
				return;
			}
			if (woord.length() != 5) { //TODO 01 ij moet ��n letter zijn
				feedback.setText("Het woord moet 5 letters hebben!");
				return;
			}
			
			// Reset het inputveld
			input.setText(antwoord.substring(0, 1));
			input.setCaretPosition(1); 

			bedenktijd = maxBedenktijd;
			poging++;
			updateLabels();
			
			//Controleer antwoord
			if (woord.equals(antwoord)) { //het antwoord is helemaal goed
				woord = "<html><font color=red>" +  woord;
				reset(); // reset de labels
				feedback.setText("'" + antwoord + "' is het antwoord, gefeliciteerd!");
				timer.stop();
				poging--; // anders staat het aantal pogingen 1 te hoog
				updateLabels();
				submit.setEnabled(false);
				bedenktijd_label.setVisible(false);
				return;
			}
			
			String eind_woord = "<html>";
			//neem iedere letter apart
			for (int index = 0; index < 5; index++) {
				String letter = woord.substring(index, index + 1);
				if (antwoord.substring(index, index + 1).equals(letter)) { // de letter is goed en op de juiste plaats
					letter = "<font color=red>" + letter + "</font>";
				} else {
					for (int i = 0; i < 5; i++) { // loop over de letters van het antwoord
						if (antwoord.substring(i, i + 1).equals(letter)) {// de letter komt overeen met een letter uit het antwoord
							letter = "<font color=yellow>" + letter + "</font>";
						}
					}
				}
				eind_woord += letter;
			}
			eind_woord += "</html>";
			woord = eind_woord;
			
			// Schuif label tekst door
			woorden.get(0).setText(woorden.get(1).getText());
			woorden.get(1).setText(woorden.get(2).getText());
			woorden.get(2).setText(woorden.get(3).getText());
			woorden.get(3).setText(woorden.get(4).getText());
			woorden.get(4).setText(woord);
			
			//Controleer aantal pogingen
			if (poging > 5) {
				switchSpeler();
				poging = 1;
				resetBedenktijd();
				return;
			}
		}		
	}
	
	private void reset() {
		for (JLabel label : woorden) {
			label.setText("");
		}
	}
	
	private void updateLabels()	{
		bedenktijd_label.setText("Bedenktijd: " + bedenktijd + "s");
		info.setText("Speler: " + speler + " Poging: " + poging);
	}
	
	private void switchSpeler() {
		switch (speler) {
		case 1:
			speler = 2;
			break;
		case 2:
			speler = 1;
			break;
		}
	}
	
	private void resetBedenktijd() {
		bedenktijd = maxBedenktijd;
	}
}
