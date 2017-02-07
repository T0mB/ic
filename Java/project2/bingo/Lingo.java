package bingo;
 
import java.awt.*;
import java.awt.event.ActionListener;
 
import javax.swing.JFrame;
 
import java.awt.event.ActionEvent;
import java.util.ArrayList;
 
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
 
 
 
@SuppressWarnings("serial")
public class Lingo extends JFrame implements ActionListener{
     
    private JTextField input = new JTextField("", 5);
    private JButton submit = new JButton("Voer in");
    private Timer timer;
    private ArrayList<String> antworden = new ArrayList<String>();
    private String antwoord = "pingu";
    private String html = "<html>";
    private String htmlE = "</html>";
    private String bouwwoord ="";
    private String woord = antwoord.charAt(0)+"....";
    private int maxBedenktijd = 30; //in seconden
    private int bedenktijd = maxBedenktijd;
    private int antcount = 0;
    private int speler = 1;
    private int poging1 = 1;
    private int poging2 = 1;
    private JPanel container;
    private JPanel invoer;
    private JPanel display;
    private JLabel[] woorden = new JLabel[6];
    private JLabel bedenktijd_label = new JLabel();
    private JLabel heyListen = new JLabel();
    private JLabel tiktok = new JLabel();
    private JLabel spelerstatus = new JLabel("speler: 1, poging: "+poging1);
    private String leescheck = "";
    private Font font = new Font("Arial", Font.BOLD, 20);
     
    public Lingo(){
     
         
        container = new JPanel(new BorderLayout()); 
        container.setBackground(Color.WHITE);
        invoer = new JPanel(new GridLayout(10,1,5,5));
        invoer.setBorder(new EmptyBorder(5, 5, 5, 5));
        display = new JPanel(new GridLayout(10,1,5,5));
        display.setBackground(Color.WHITE);
         
        for (int i = 0; i<5; i++){
            woorden[i] = new JLabel(woord);
            woorden[i].setFont(font);
            display.add(woorden[i]);
        }
         
        submit.addActionListener(this);
        invoer.add(input);
        invoer.add(submit);
        invoer.add(spelerstatus);
        invoer.add(tiktok);
        invoer.add(heyListen);
        invoer.add(bedenktijd_label);
        container.add("East",invoer);
        container.add("West",display);
         
         
         
        timer = new Timer(1000,this);
        timer.start();
         
         
        JFrame frame = new JFrame("lingo");
        frame.setContentPane(container);
        frame.setSize(500,500);
        frame.setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
}
     
    public boolean check(){
        String check = input.getText().toLowerCase();
            for(int i = 0; i <antworden.size(); i++){
                if(antworden.get(i).equals(check)){
                    return true;
                }
        }
            antworden.add(check);
            return false;
    }
 
 
    public void leestekens(){// dit staat los omdat het anders niet werkte
        String woord = input.getText().toLowerCase();
        String dezeniet = "~!@#$%^&*()_,?<>{}[]|/`'+-=";
        for (int i = 0; i < 5; i++){
            String teken = woord.substring(i, i+1);
             
            for(int ii = 0; ii < dezeniet.length(); ii++){
                 
                if (teken.equals(dezeniet.substring(ii, ii+1))){
                leescheck = "nee";  // ik had eerste geprobeerd dit met een boolean te doen maar dat werkte niet
                break;
                }
                else{
                leescheck = "ja";
                }
            }
        }
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==submit){
              
            String woord = input.getText().toLowerCase();
            leestekens();
             
             
             
     
             
            if (woord.equals("")) {
                heyListen.setText("Vul een woord in!");
            }
             
            else if(check()==true){
                heyListen.setText("al geraden");
                woord = "";
                input.setText("");
            }
             
             
         
             
            else if (woord.length() != 5) {
                heyListen.setText("5 leters, AUB");
                woord = "";
                input.setText("");
            }           
            else if (woord.charAt(0)!=antwoord.charAt(0)){
                heyListen.setText("die eerste leter is niet zomaar een sugestie");
                woord = "";
                input.setText("");
            }
             
            else if(leescheck.equals("nee")) {
                heyListen.setText("geen leestenks");
                woord = "";
                input.setText("");
            }
             
            else if (woord.equals(antwoord)){
                heyListen.setText("Bingo");
                timer.stop();
                 
                switch(antcount){
                case 0:
                    woorden[antcount].setText(html+"<font color=red>"+woord+"</font>"+htmlE);
                    System.out.println(html+"<font color=red>"+woord+"</font>"+htmlE);
                    bedenktijd = 30;
                    break;
                case 1:
                    woorden[antcount].setText(html+"<font color=red>"+woord+"</font>"+htmlE);
                    bedenktijd = 30;
                    break;
                case 2:
                    woorden[antcount].setText(html+"<font color=red>"+woord+"</font>"+htmlE);
                    bedenktijd = 30;
                    break;
                case 3:
                    woorden[antcount].setText(html+"<font color=red>"+woord+"</font>"+htmlE);
                    bedenktijd = 30;
                    break;
                case 4:
                    woorden[antcount].setText(html+"<font color=red>"+woord+"</font>"+htmlE);
                    bedenktijd = 30;
                    break;
            }
                 
            }
             
 
             
             
            else {  
                for (int index = 0; index < 5; index++){// checkt voor letters die op de juiste plek staan
                    String letter = woord.substring(index, index +1);
                    if (antwoord.substring(index, index +1).equals(letter)){
                        letter = "<font color=red>" + letter + "</font>";
                    }
                     
                    else{
                        for (int index2 = 0; index2 < 5; index2++){// checkt voor letters die in het woord zitten maar niet op de juiste plek staan
                            if (antwoord.substring(index2,index2 +1).equals(letter)){
                                letter = "<font color=yellow>" + letter + "</font>";
                            }
                        }   
                    }
                    bouwwoord += letter;
                }   
             
                woord = bouwwoord;
                bouwwoord = "";
             
                switch(antcount){
                    case 0:
                        woorden[antcount].setText(html+woord+htmlE);
                        bedenktijd = 30;
                         
                        break;
                    case 1:
                        woorden[antcount].setText(html+woord+htmlE);
                        bedenktijd = 30;
                         
                        break;
                    case 2:
                        woorden[antcount].setText(html+woord+htmlE);
                        bedenktijd = 30;
                     
                        break;
                    case 3:
                        woorden[antcount].setText(html+woord+htmlE);
                        bedenktijd = 30;
                         
                        break;
                    case 4:
                        woorden[antcount].setText(html+woord+htmlE);
                         
                        bedenktijd = 60;
                        woorden[5] = new JLabel("p..."+antwoord.charAt(4));
                        woorden[5].setFont(font);
                        display.add(woorden[5]);
                        if (speler==1){
                            poging2++;
                            spelerstatus.setText("speler: 2, poging1: "+poging2);
                        }
                        else{
                            poging1++;
                            spelerstatus.setText("speler: 1, poging2: "+poging1);
                        }
                        break;
                }
                antcount++;
                input.setText("");
                 
            }
    }
     
         
        else if (e.getSource()==timer){
            tiktok.setText("Bedenktijd: "+bedenktijd);
            bedenktijd--;
            if (bedenktijd==0 && speler ==1){
                if (antcount==4){
                    woorden[4].setText("p..."+antwoord.charAt(4));
                    woorden[5] = new JLabel("p..."+antwoord.charAt(4));
                    woorden[5].setFont(font);
                    display.add(woorden[5]);
                    poging2 ++;
                    spelerstatus.setText("speler: 2, poging: "+poging2);
                    bedenktijd = maxBedenktijd;
                    speler = 2;
                    antcount++;
                }
                else{
                poging2 ++;
                spelerstatus.setText("speler: 2, poging: "+poging2);
                bedenktijd = maxBedenktijd;
                speler = 2;
                }
            }
             
            else if (bedenktijd==0 && speler ==2){
                if (antcount==4){
                    woorden[4].setText("p..."+antwoord.charAt(4));
                    woorden[5] = new JLabel("p..."+antwoord.charAt(4));
                    woorden[5].setFont(font);
                    display.add(woorden[5]);
                    poging1 ++;
                    spelerstatus.setText("speler: 1, poging: "+poging1);
                    bedenktijd = maxBedenktijd;
                    speler = 1;
                    antcount++;
                    if (bedenktijd==0){
                        heyListen.setText("oke niemand wint");
                    }
                }
                else {
                poging1 ++;
                spelerstatus.setText("speler: 1, poging: "+poging1);
                bedenktijd = maxBedenktijd;
                speler = 1;
                }
            }
         
        }
         
    }
}