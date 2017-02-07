package opdr7;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		drukFrequentieTabelAf("Een kapsalon bestaat uit patat, frikandellen, mayo en saus, en een catamaran uit patat, frikandellen, mayo en saus. Yes! Catamaran! No! Kapsalon!");
		drukFrequentieTabelAf("Lorem ipsum dolor sit amet, consectetur adipiscing elit. In vitae tortor vitae tellus accumsan placerat quis quis ipsum. Mauris eu nulla nulla. Nullam quis ligula dolor. Proin auctor, erat ut faucibus imperdiet, ante arcu hendrerit mauris, nec accumsan leo justo eleifend ipsum. Suspendisse elementum arcu eu ante posuere gravida. Nam imperdiet odio quis magna condimentum non congue tortor tincidunt. Integer mattis malesuada velit ac imperdiet. Duis nunc nulla, tempus et ultricies eu, ullamcorper sit amet leo. Morbi viverra, velit ut tincidunt facilisis, neque lectus tempus felis, non sagittis lectus felis a nunc. Aenean non risus ante. Aliquam suscipit lorem non purus posuere a tristique mi rhoncus. Suspendisse eu nisi nibh, a molestie mauris. Vivamus ac lacinia nibh. Etiam quis orci ut neque ullamcorper scelerisque. Proin cursus quam vel ligula tristique pretium. In lacus diam, placerat et gravida sed, mattis a ligula.");
	}
	
	public static void drukFrequentieTabelAf(String tekst) {
		LinkedHashMap<String, Integer> tabel = new LinkedHashMap<String, Integer>();
		
		tekst = remove(tekst, ".");
		tekst = remove(tekst, ",");
		tekst = remove(tekst, "!");
		tekst = remove(tekst, "?");
		
		String[] woorden = tekst.split(" ");
		for (String woord : woorden) {
			woord = capitalizeFirstLetter(woord);
			if (tabel.containsKey(woord)) {
				tabel.replace(woord, tabel.get(woord) + 1);
			} else {
				tabel.put(woord, 1);
			}
		}
		
		for (Map.Entry<String, Integer> entry : tabel.entrySet()) {
			String woord = entry.getKey();
			if (woord.length() < 8) //puur om de woorden netjes op een rijtje te krijgen ind e output
				woord += "\t";
			System.out.println(woord + "\t komt " + entry.getValue() + " keer voor");
		}
		
	}
	
	public static String remove(String tekst, String sequence) {
		return tekst.replace(sequence, "");
	}
	
	public static String capitalizeFirstLetter(String str) {
		return str.substring(0,  1).toUpperCase() + str.substring(1).toLowerCase();
	}
}
