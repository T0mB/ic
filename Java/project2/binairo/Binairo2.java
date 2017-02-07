package binairo;

// org.apache.commons.lang3.StringUtils geïmporteerd voor het controleren van de rijen en kolommen
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import org.apache.commons.lang3.StringUtils;

@SuppressWarnings("serial")
public class Binairo2 extends JFrame implements ActionListener {

	private ArrayList<String> lijst = new ArrayList<>();
	private ArrayList<String> startLijst = new ArrayList<>();
	private JLabel[] label = new JLabel[144];
	private JPanel panel = new JPanel();
	private JPanel panel2 = new JPanel();
	private JButton start, voeg0, voeg1, wis;
	private String s, setter, mirror;
	private int wiscount = 0;
	private int count = 0;

	private LinkedHashMap<String, JLabel> labels = new LinkedHashMap<String, JLabel>();

	public Binairo2() throws IOException {

		panel.setLayout(new GridLayout(12, 12, 3, 3));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		add(panel, BorderLayout.CENTER);
		add(panel2, BorderLayout.SOUTH);

		start = new JButton("start");
		start.addActionListener(this);
		voeg0 = new JButton("voeg 0 toe");
		voeg0.addActionListener(this);
		voeg1 = new JButton("voeg 1 toe");
		voeg1.addActionListener(this);
		wis = new JButton("wis");
		wis.addActionListener(this);

		panel2.add(start);
		panel2.add(voeg0);
		panel2.add(voeg1);
		panel2.add(wis);

		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		labels();

	}

	public void labels() {

		for (int i = 0; i < 144; i++) {
			label[i] = new JLabel("  ");
			panel.add(label[i]);
			label[i].setBackground(Color.white);
			label[i].setOpaque(true);
		}
		setVisible(true);
	}

	{
		try {
			FileReader fr = new FileReader(
					"C:/Users/Tom/workspace/Java/project2/binairo/Puzzel.txt");
			BufferedReader br = new BufferedReader(fr);

			while (true) {

				s = br.readLine();
				if (s == null) {
					break;
				}

				startLijst.add(s);

				lijst.add(s);

			}
			br.close();

		}

		catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	// deze methode tekent de labels aan het begin met de inhoud van het
	// textfile
	// en wordt later ook gebruikt om cijfers aan de labels toe te voegen
	public void draw() {
		panel.removeAll();
		for (int i = 0; i < 144; ++i) {
			labels.put(lijst.get(i), new JLabel(lijst.get(i)));
			panel.add(labels.get(lijst.get(i)));
			labels.get(lijst.get(i)).setBackground(Color.white);
			if (startLijst.get(i).equals("0") || startLijst.get(i).equals("1")) {
				labels.get(lijst.get(i)).setForeground(Color.red);
			}
			labels.get(lijst.get(i)).setOpaque(true);
		}
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void copy() {
		draw();
		rij();
		// kolom(); dacht dat deze er ook in moest maar dat hoeft niet
		// mocht de speler het spel moeilijker willen maken kan je de "//" weghalen
		wiscount = count;
		count++;
		System.out.println("count=" + wiscount);
		System.out.println("wiscount=" + wiscount);

	}

	public void toevoegen() {
		while (count < 144) {
			if (startLijst.get(count).equals("-")) {

				if (count < 2 || (count > 11 && count < 14)
						|| (count > 23 && count < 26)
						|| (count > 35 && count < 38)
						|| (count > 47 && count < 50)
						|| (count > 59 && count < 62)
						|| (count > 71 && count < 74)
						|| (count > 83 && count < 86)
						|| (count > 95 && count < 98)
						|| (count > 107 && count < 110)
						|| (count > 119 && count < 122)
						|| (count > 131 && count < 134)) {
					lijst.set(count, setter);
					copy();
					break;

				}

				if (lijst.get(count - 1).equals(setter)
						&& lijst.get(count - 2).equals(setter)) {
					JOptionPane
							.showMessageDialog(null,
									"Er mogen niet meer dan 2 dezelfde cijfers naast elkaar");
					lijst.set(count, mirror);
					copy();
					break;
				}

				if (lijst.get(count - 1).equals(setter)
						&& lijst.get(count + 1).equals(setter)) {
					JOptionPane
							.showMessageDialog(null,
									"Er mogen niet meer dan 2 dezelfde cijfers naast elkaar");
					lijst.set(count, mirror);
					copy();
					break;
				}
				
				if (lijst.get(count + 1).equals(setter)
						&& lijst.get(count + 2).equals(setter)) {
					JOptionPane
							.showMessageDialog(null,
									"Er mogen niet meer dan 2 dezelfde cijfers naast elkaar");
					lijst.set(count, mirror);
					copy();
					break;
				}

				else {
					lijst.set(count, setter);
					copy();
					System.out.println("count=" + wiscount);
					System.out.println("wiscount=" + wiscount);
					break;
				}
			} else {
				count++;
				System.out.println("count=" + wiscount);
				System.out.println("wiscount=" + wiscount);
			}

		}
	}

	public void actionPerformed(ActionEvent e) {

		// Start
		if (e.getSource() == start) {

			while (wiscount >= 0) {
				if (startLijst.get(wiscount).equals("-")) {
					lijst.set(wiscount, "-");
					wiscount--;
				} else {
					wiscount--;
				}
			}
			draw();
			count = 0;
			wiscount = 0;
		}

		// Wissen
		if (e.getSource() == wis) {
			while (wiscount >= 0) {
				if (startLijst.get(wiscount).equals("-")) {
					lijst.set(wiscount, "-");
					draw();
					count = wiscount;
					wiscount--;
					break;
				} else {
					draw();
					count = wiscount;
					wiscount--;
				}
			}
		}

		// voeg 0 toe
		if (e.getSource() == voeg0) {
			setter = "0";
			mirror = "1";
			toevoegen();
			if (!lijst.get(143).equals("-")) {
				JOptionPane.showMessageDialog(null, "U heeft gewonnen");
			}
		}

		// Voeg 1 toe
		if (e.getSource() == voeg1) {
			setter = "1";
			mirror = "0";
			toevoegen();
			if (!lijst.get(143).equals("-")) {
				JOptionPane.showMessageDialog(null, "U heeft gewonnen");
			}
		}
	}

	public void rij() {
		String r1 = lijst.get(0) + lijst.get(1) + lijst.get(2) + lijst.get(3)
				+ lijst.get(4) + lijst.get(5) + lijst.get(6) + lijst.get(7)
				+ lijst.get(8) + lijst.get(9) + lijst.get(10) + lijst.get(11);
		int count1 = StringUtils.countMatches(r1, "0");
		int count13 = StringUtils.countMatches(r1, "1");
		if (count1 > 6 || count13 > 6) {
			JOptionPane.showMessageDialog(null, "WIS");

		}

		String r2 = lijst.get(12) + lijst.get(13) + lijst.get(14)
				+ lijst.get(15) + lijst.get(16) + lijst.get(17) + lijst.get(18)
				+ lijst.get(19) + lijst.get(20) + lijst.get(21) + lijst.get(22)
				+ lijst.get(23);
		int count2 = StringUtils.countMatches(r2, "0");
		int count14 = StringUtils.countMatches(r2, "1");
		if (count2 > 6 || count14 > 6) {
			JOptionPane.showMessageDialog(null, "WIS");
		}

		String r3 = lijst.get(24) + lijst.get(25) + lijst.get(26)
				+ lijst.get(27) + lijst.get(28) + lijst.get(29) + lijst.get(30)
				+ lijst.get(31) + lijst.get(32) + lijst.get(33) + lijst.get(34)
				+ lijst.get(35);
		int count3 = StringUtils.countMatches(r3, "0");
		int count15 = StringUtils.countMatches(r3, "1");
		if (count3 > 6 || count15 > 6) {
			JOptionPane.showMessageDialog(null, "WIS");
		}

		String r4 = lijst.get(36) + lijst.get(37) + lijst.get(38)
				+ lijst.get(39) + lijst.get(40) + lijst.get(41) + lijst.get(42)
				+ lijst.get(43) + lijst.get(44) + lijst.get(45) + lijst.get(46)
				+ lijst.get(47);
		int count4 = StringUtils.countMatches(r4, "0");
		int count16 = StringUtils.countMatches(r4, "1");
		if (count4 > 6 || count16 > 6) {
			JOptionPane.showMessageDialog(null, "WIS");
		}

		String r5 = lijst.get(48) + lijst.get(49) + lijst.get(50)
				+ lijst.get(51) + lijst.get(52) + lijst.get(53) + lijst.get(54)
				+ lijst.get(55) + lijst.get(56) + lijst.get(57) + lijst.get(58)
				+ lijst.get(59);
		int count5 = StringUtils.countMatches(r5, "0");
		int count17 = StringUtils.countMatches(r5, "1");
		if (count5 > 6 || count17 > 6) {
			JOptionPane.showMessageDialog(null, "WIS");
		}

		String r6 = lijst.get(60) + lijst.get(61) + lijst.get(62)
				+ lijst.get(63) + lijst.get(64) + lijst.get(65) + lijst.get(66)
				+ lijst.get(67) + lijst.get(68) + lijst.get(69) + lijst.get(70)
				+ lijst.get(71);
		int count6 = StringUtils.countMatches(r6, "0");
		int count18 = StringUtils.countMatches(r6, "1");
		if (count6 > 6 || count18 > 6) {
			JOptionPane.showMessageDialog(null, "WIS");
		}

		String r7 = lijst.get(72) + lijst.get(73) + lijst.get(74)
				+ lijst.get(75) + lijst.get(76) + lijst.get(77) + lijst.get(78)
				+ lijst.get(79) + lijst.get(80) + lijst.get(81) + lijst.get(82)
				+ lijst.get(83);
		int count7 = StringUtils.countMatches(r7, "0");
		int count19 = StringUtils.countMatches(r7, "1");
		if (count7 > 6 || count19 > 6) {
			JOptionPane.showMessageDialog(null, "WIS");
		}

		String r8 = lijst.get(84) + lijst.get(85) + lijst.get(86)
				+ lijst.get(87) + lijst.get(88) + lijst.get(89) + lijst.get(90)
				+ lijst.get(91) + lijst.get(92) + lijst.get(93) + lijst.get(94)
				+ lijst.get(95);
		int count8 = StringUtils.countMatches(r8, "0");
		int count20 = StringUtils.countMatches(r8, "1");
		if (count8 > 6 || count20 > 6) {
			JOptionPane.showMessageDialog(null, "WIS");
		}

		String r9 = lijst.get(96) + lijst.get(97) + lijst.get(98)
				+ lijst.get(99) + lijst.get(100) + lijst.get(101)
				+ lijst.get(102) + lijst.get(103) + lijst.get(104)
				+ lijst.get(105) + lijst.get(106) + lijst.get(107);
		int count9 = StringUtils.countMatches(r9, "0");
		int count21 = StringUtils.countMatches(r9, "1");
		if (count9 > 6 || count21 > 6) {
			JOptionPane.showMessageDialog(null, "WIS");
		}

		String r10 = lijst.get(108) + lijst.get(109) + lijst.get(110)
				+ lijst.get(111) + lijst.get(112) + lijst.get(113)
				+ lijst.get(114) + lijst.get(115) + lijst.get(116)
				+ lijst.get(117) + lijst.get(118) + lijst.get(119);
		int count10 = StringUtils.countMatches(r10, "0");
		int count22 = StringUtils.countMatches(r10, "1");
		if (count10 > 6 || count22 > 6) {
			JOptionPane.showMessageDialog(null, "WIS");
		}

		String r11 = lijst.get(120) + lijst.get(121) + lijst.get(122)
				+ lijst.get(123) + lijst.get(124) + lijst.get(125)
				+ lijst.get(126) + lijst.get(127) + lijst.get(128)
				+ lijst.get(129) + lijst.get(130) + lijst.get(131);
		int count11 = StringUtils.countMatches(r11, "0");
		int count23 = StringUtils.countMatches(r11, "1");
		if (count11 > 6 || count23 > 6) {
			JOptionPane.showMessageDialog(null, "WIS");
		}

		String r12 = lijst.get(132) + lijst.get(133) + lijst.get(134)
				+ lijst.get(135) + lijst.get(136) + lijst.get(137)
				+ lijst.get(138) + lijst.get(139) + lijst.get(140)
				+ lijst.get(141) + lijst.get(142) + lijst.get(143);
		int count12 = StringUtils.countMatches(r12, "0");
		int count24 = StringUtils.countMatches(r12, "1");
		if (count12 > 6 || count24 > 6) {
			JOptionPane.showMessageDialog(null, "WIS");
		}
	}

	public void kolom() {
		String k1 = lijst.get(0) + lijst.get(12) + lijst.get(24)
				+ lijst.get(36) + lijst.get(48) + lijst.get(60) + lijst.get(72)
				+ lijst.get(84) + lijst.get(96) + lijst.get(108)
				+ lijst.get(120) + lijst.get(132);
		int kolom1 = StringUtils.countMatches(k1, "0");
		int kolom13 = StringUtils.countMatches(k1, "1");
		if (kolom1 > 6 || kolom13 > 6) {
			JOptionPane.showMessageDialog(null, "WIS");

		}

		String k2 = lijst.get(1) + lijst.get(13) + lijst.get(25)
				+ lijst.get(37) + lijst.get(49) + lijst.get(61) + lijst.get(73)
				+ lijst.get(85) + lijst.get(97) + lijst.get(109)
				+ lijst.get(121) + lijst.get(133);
		int kolom2 = StringUtils.countMatches(k2, "0");
		int kolom14 = StringUtils.countMatches(k2, "1");
		if (kolom2 > 6 || kolom14 > 6) {
			JOptionPane.showMessageDialog(null, "WIS");

		}

		String k3 = lijst.get(2) + lijst.get(14) + lijst.get(26)
				+ lijst.get(38) + lijst.get(50) + lijst.get(62) + lijst.get(74)
				+ lijst.get(86) + lijst.get(98) + lijst.get(110)
				+ lijst.get(122) + lijst.get(134);
		int kolom3 = StringUtils.countMatches(k3, "0");
		int kolom15 = StringUtils.countMatches(k3, "1");
		if (kolom3 > 6 || kolom15 > 6) {
			JOptionPane.showMessageDialog(null, "WIS");

		}

		String k4 = lijst.get(3) + lijst.get(15) + lijst.get(27)
				+ lijst.get(39) + lijst.get(51) + lijst.get(63) + lijst.get(75)
				+ lijst.get(87) + lijst.get(99) + lijst.get(111)
				+ lijst.get(123) + lijst.get(135);
		int kolom4 = StringUtils.countMatches(k4, "0");
		int kolom16 = StringUtils.countMatches(k4, "1");
		if (kolom4 > 6 || kolom16 > 6) {
			JOptionPane.showMessageDialog(null, "WIS");

		}

		String k5 = lijst.get(4) + lijst.get(16) + lijst.get(28)
				+ lijst.get(40) + lijst.get(52) + lijst.get(64) + lijst.get(76)
				+ lijst.get(88) + lijst.get(100) + lijst.get(112)
				+ lijst.get(124) + lijst.get(136);
		int kolom5 = StringUtils.countMatches(k5, "0");
		int kolom17 = StringUtils.countMatches(k5, "1");
		if (kolom5 > 6 || kolom17 > 6) {
			JOptionPane.showMessageDialog(null, "WIS");

		}

		String k6 = lijst.get(5) + lijst.get(17) + lijst.get(29)
				+ lijst.get(41) + lijst.get(53) + lijst.get(65) + lijst.get(77)
				+ lijst.get(89) + lijst.get(101) + lijst.get(113)
				+ lijst.get(125) + lijst.get(137);
		int kolom6 = StringUtils.countMatches(k6, "0");
		int kolom18 = StringUtils.countMatches(k6, "1");
		if (kolom6 > 6 || kolom18 > 6) {
			JOptionPane.showMessageDialog(null, "WIS");

		}

		String k7 = lijst.get(6) + lijst.get(18) + lijst.get(30)
				+ lijst.get(42) + lijst.get(54) + lijst.get(66) + lijst.get(78)
				+ lijst.get(90) + lijst.get(102) + lijst.get(114)
				+ lijst.get(126) + lijst.get(138);
		int kolom7 = StringUtils.countMatches(k7, "0");
		int kolom19 = StringUtils.countMatches(k7, "1");
		if (kolom7 > 6 || kolom19 > 6) {
			JOptionPane.showMessageDialog(null, "WIS");

		}

		String k8 = lijst.get(7) + lijst.get(19) + lijst.get(31)
				+ lijst.get(43) + lijst.get(55) + lijst.get(67) + lijst.get(79)
				+ lijst.get(91) + lijst.get(103) + lijst.get(115)
				+ lijst.get(127) + lijst.get(139);
		int kolom8 = StringUtils.countMatches(k8, "0");
		int kolom20 = StringUtils.countMatches(k8, "1");
		if (kolom8 > 6 || kolom20 > 6) {
			JOptionPane.showMessageDialog(null, "WIS");

		}

		String k9 = lijst.get(8) + lijst.get(20) + lijst.get(32)
				+ lijst.get(44) + lijst.get(56) + lijst.get(68) + lijst.get(80)
				+ lijst.get(92) + lijst.get(104) + lijst.get(116)
				+ lijst.get(128) + lijst.get(140);
		int kolom9 = StringUtils.countMatches(k9, "0");
		int kolom21 = StringUtils.countMatches(k9, "1");
		if (kolom9 > 6 || kolom21 > 6) {
			JOptionPane.showMessageDialog(null, "WIS");

		}

		String k10 = lijst.get(9) + lijst.get(21) + lijst.get(33)
				+ lijst.get(45) + lijst.get(57) + lijst.get(69) + lijst.get(81)
				+ lijst.get(93) + lijst.get(105) + lijst.get(117)
				+ lijst.get(129) + lijst.get(141);
		int kolom10 = StringUtils.countMatches(k10, "0");
		int kolom22 = StringUtils.countMatches(k10, "1");
		if (kolom10 > 6 || kolom22 > 6) {
			JOptionPane.showMessageDialog(null, "WIS");

		}

		String k11 = lijst.get(10) + lijst.get(22) + lijst.get(34)
				+ lijst.get(46) + lijst.get(58) + lijst.get(70) + lijst.get(82)
				+ lijst.get(94) + lijst.get(106) + lijst.get(118)
				+ lijst.get(130) + lijst.get(142);
		int kolom11 = StringUtils.countMatches(k11, "0");
		int kolom23 = StringUtils.countMatches(k11, "1");
		if (kolom11 > 6 || kolom23 > 6) {
			JOptionPane.showMessageDialog(null, "WIS");

		}

		String k12 = lijst.get(11) + lijst.get(23) + lijst.get(35)
				+ lijst.get(47) + lijst.get(59) + lijst.get(71) + lijst.get(83)
				+ lijst.get(95) + lijst.get(107) + lijst.get(119)
				+ lijst.get(131) + lijst.get(143);
		int kolom12 = StringUtils.countMatches(k12, "0");
		int kolom24 = StringUtils.countMatches(k12, "1");
		if (kolom12 > 6 || kolom24 > 6) {
			JOptionPane.showMessageDialog(null, "WIS");

		}

	}

}
