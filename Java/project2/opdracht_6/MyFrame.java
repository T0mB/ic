package opdracht_6;
 
//hebben org.apache.commons.collections.jar geïmporteerd zodat we gebruik konden maken van Comparator chain
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

import org.apache.commons.collections.comparators.ComparatorChain;

@SuppressWarnings("serial")
public class MyFrame extends JFrame implements ActionListener
{
  private JLabel lab1, lab2, lab3, lijst;
  private JButton b1, b2;
  private Kaart alleKaarten;
  private ArrayList<Kaart> allekaarten = new ArrayList<Kaart>();
  private int count =0;
  
    
  public Kaart getAlleKaarten() {
      return alleKaarten;
  }

   

  public MyFrame()    {
      setLayout(new FlowLayout());
        
      lab1 = new JLabel("Druk op knop Kaart");
      add(lab1);
        
      b1 = new JButton("Kaart");
      add(b1);
      b1.addActionListener(this);
        
      b2 = new JButton("Toon");
      add(b2);
      b2.addActionListener(this);
        
        
      lab2 = new JLabel("Het spel begint");
      add(lab2);
        
      lab3 = new JLabel("");
      add(lab3);
        
      lijst = new JLabel("");
      add(lijst);
        
      setSize(150,150);
      setVisible(true);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
   
   
    
  public void actionPerformed (ActionEvent e)
  {
        
  if(e.getSource()==b1){              
       //genereert een random kaart 
      int randomsoort = 1 + (int)(4*Math.random());
      int randomkaart = 1 + (int)(13*Math.random());
        
      String soort = null;
      String kaart = null;
       
        
      switch(randomsoort)
      {
          case 1: soort = "Schoppen"; break;
          case 2: soort = "Harten";  break;
          case 3: soort = "Klaveren"; break;
          case 4: soort = "Ruiten";  break;
      }
        
      switch(randomkaart)
      {
          case 1: kaart = "Aas"; break;
          case 2: kaart = "2";  break;
          case 3: kaart = "3";  break;
          case 4: kaart = "4";  break;
          case 5: kaart = "5";  break;
          case 6: kaart = "6";  break;
          case 7: kaart = "7";  break;
          case 8: kaart = "8";  break;
          case 9: kaart = "9";  break;
          case 10: kaart = "10";  break;
          case 11: kaart = "Boer";  break;
          case 12: kaart = "Vrouw";  break;
          case 13: kaart = "Heer";  break;         
      }
       
        
      lab2.setText("        " +soort);
      lab3.setText(kaart);
        
      String input = "kt"+count;
      Kaart k = new Kaart(kaart, soort);
      allekaarten.add(k);
       
            
  }
   
  else if(e.getSource()==b2){
      String s = "";
      for(int i = 0; i < allekaarten.size();i++){
          s += ""+ allekaarten.get(i);
      }
       
    //comparator voor soort
      Comparator<Kaart> naamcheck = new Comparator<Kaart>(){
          
          public int compare(Kaart k1, Kaart k2) {
                 String Kaartsoort1 = k1.getSoort().toLowerCase();
                 String Kaartsoort2 = k2.getSoort().toLowerCase();
                  
                 return Kaartsoort1.compareTo(Kaartsoort2);
          }
           
      };
      //comparator voor waarde
      Comparator<Kaart> waardecheck = new Comparator<Kaart>(){
          int soort2 = 0;
          int soort1 = 0;
          public int compare(Kaart k1, Kaart k2){
               
              String Kaartwaarde1 = k1.getWaarde();
              String Kaartwaarde2 = k2.getWaarde();
               
              switch(Kaartwaarde1){
              case "Aas": soort1 = 13; break;
              case "2": soort1 = 1; break;
              case "3": soort1 = 2; break;
              case "4": soort1 = 3; break;
              case "5": soort1 = 4; break;
              case "6": soort1 = 5; break;
              case "7": soort1 = 6; break;
              case "8": soort1 = 7; break;
              case "9": soort1 = 8; break;
              case "10": soort1 = 9; break;
              case "Boer":soort1 = 10; break;
              case "Vrouw":soort1 = 11; break;
              case "Heer": soort1 = 12; break;
               
              }
               
              switch(Kaartwaarde2){
              case "Aas": soort2 = 13; break;
              case "2": soort2 = 1; break;
              case "3": soort2 = 2; break;
              case "4": soort2 = 3; break;
              case "5": soort2 = 4; break;
              case "6": soort2 = 5; break;
              case "7": soort2 = 6; break;
              case "8": soort2 = 7; break;
              case "9": soort2 = 8; break;
              case "10": soort2 = 9; break;
              case "Boer":soort2 = 10; break;
              case "Vrouw":soort2 = 11; break;
              case "Heer": soort2 = 12; break;
               
              }
               
              if (soort1 > soort2)
                  return 1;
              else if (soort1 < soort2)
                  return -1;
              else
                  return 0;
          }
               
      };
       
      ComparatorChain kaartChain = new ComparatorChain();
      kaartChain.addComparator(naamcheck);
      kaartChain.addComparator(waardecheck);
       
      System.out.println("In de arraylist staan:\n" + s);
       
      Collections.sort(allekaarten, kaartChain);
      
      System.out.println("Gesorteerd van klein naar groot:");
     for(Kaart str: allekaarten){
          System.out.print(str);
     }
  }
   
  }

   
    
    
}