package opdracht_U_8;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;

import org.apache.commons.csv.*;

@SuppressWarnings({ "serial", "unused" })
public class MyFrame extends JFrame implements ActionListener {
	private JButton register;
	private JLabel stockPrice;
	private JLabel image;
	private JTextField from;
	private JTextField to;
	private JTextField stock;
	private BufferedImage myPicture;
	private CSVParser parser;
	private Timer timer;
	private int iteration = 0;
	private int status = 2;
	private int lastValue;
	private String color;

	public MyFrame() {
		setLayout(new FlowLayout());
		register = new JButton("Voer uit");
		from = new JTextField("Van	");
		to = new JTextField("Tot:	");
		stock = new JTextField("Stock	");
		stockPrice = new JLabel("Prijs van aandeel");
		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO
					.read(new File("/home/martijn/images/mood/1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JLabel image = new JLabel(new ImageIcon(myPicture));
		add(from);
		add(to);
		add(stock);
		add(stockPrice);
		add(register);
		add(image);
		register.addActionListener(this);
		setSize(350, 250);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == register) {
			// Timer
			timer = new Timer(1000, this);
			timer.start();
			register.setEnabled(false);
			if (stock.getText() != "Stock") {
				DownloadStats dl = new DownloadStats(
						"https://www.google.com/finance/historical?output=csv&q="
								+ stock.getText(), "stats.csv");
			} else {
				System.out.println("Geen input gegeven");
			}
		}
		if (e.getSource() == timer) {
			parseStats();
			iteration++;
		}
	}

	public void parseStats() {
		if (true){
		// TODO: Check of download goed is gegaan
		//if (dl.downloadSuc == true) {
			if (true) {
				CSVFormat format = CSVFormat.RFC4180.withHeader()
						.withDelimiter(',');
				try {
					parser = new CSVParser(new FileReader("stats.csv"), format);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				List<Numbers> emps = new ArrayList<Numbers>();
				for (CSVRecord record : parser) {
					Numbers emp = new Numbers();
					emp.setHigh(record.get("Close"));
					emps.add(emp);
				}
				// close the parser
				try {
					parser.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// Dit doet pijn aan mijn ogen, maar werkt
				if (Integer.valueOf(String.valueOf(emps.get(iteration))) > lastValue) {
					color = "green";
				}
				else {
					color = "red";
				}
				stockPrice.setText("<html>Waarde was: <font color='" + color + "'>"
						+ String.valueOf(emps.get(iteration)) + "</font></html>");
				// image.setIcon(getImage("NotIm"));
			}
		}
	}

	public BufferedImage getImage(String newStatus) {
		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new File("/home/martijn/images/mood/"
					+ status + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myPicture;
	}
}