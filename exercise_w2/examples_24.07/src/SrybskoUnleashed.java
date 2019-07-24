import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

//Input: singer @venue ticketsPrice ticketsCount
//output: #{2*space}{singer}{space}->{space}{total money}
public class SrybskoUnleashed {
	static String inputLine = new String();
	static Map<String[], Integer> singersProfit = new HashMap<String[], Integer>();
	static ArrayDeque<String> venues = new ArrayDeque<String>();
	static Map<String, HashSet<String>> singersByVenue = new HashMap<String, HashSet<String>>();

	public static void main(String[] args) {
		program();
		System.out.print(output());
	}

	static void input() {
		Scanner scan = new Scanner(System.in);
		do {
				inputLine = scan.nextLine();
		}
		while(inputLine.length()-inputLine.replaceAll(" ","").length()<3&&!inputLine.equals("End"));
		
	}

	static String output() {
		StringBuilder list = new StringBuilder();
		Set<Map.Entry<String[], Integer>> st = singersProfit.entrySet();
		while (!venues.isEmpty()) {
			String venue = venues.pop();
			HashSet<String> singers = singersByVenue.get(venue);
			// System.out.println(singers);
			list.append(venue + "\n");
			for (String singer : singers) {
				//String[] singerAndVenue = { singer, venue };
				// System.out.println(singerAndVenue+"\n"+singersProfit.entrySet());
				int profit=0;
				for (Map.Entry<String[], Integer> me : st) {
					if(me.getKey()[0].equals(singer)&&me.getKey()[1].equals(venue))
					{
						profit=me.getValue();
					}
				}

				list.append("#  " + singer + " -> " + profit + "\n");
			}
		}

		return list.toString();
	}

	static String inputGetSinger() {
		String singer = inputLine.substring(0, inputLine.indexOf('@') - 1);
		// System.out.println(singer);
		return singer;
	}

	static String inputGetVenue() {

		String venue = inputLine.substring(inputLine.indexOf('@') + 1, inputGetI() - 1);
		// System.out.println(venue);
		return venue;
	}

	static int inputGetI() {
		int i = inputLine.indexOf('@');
		while (inputLine.charAt(i) < '0' || inputLine.charAt(i) > '9') {
			i++;
		}
		return i;
	}

	static int inputGetProfit() {
		int profit = Integer.parseInt(inputLine.substring(inputGetI(), inputLine.lastIndexOf(' ')))
				* Integer.parseInt(inputLine.substring(inputLine.lastIndexOf(' ') + 1, inputLine.length()));
		// System.out.println(Integer.parseInt(inputLine.substring(inputGetI(),
		// inputLine.lastIndexOf(' '))) + " "
		// + Integer.parseInt(inputLine.substring(inputLine.lastIndexOf(' ') + 1,
		// inputLine.length())));
		return profit;
	}

	static void program() {
		input();
		while (!inputLine.equals("End")) {
			String singer = inputGetSinger();
			String venue = inputGetVenue();
			String[] singerAndVenue = { singer, venue };
			int profit = inputGetProfit();
			if (!venues.contains(venue)) {
				venues.add(venue);
			}
			if (singersByVenue.containsKey(venue)) {
				singersByVenue.get(venue).add(singer);
				// System.out.println(singersByVenue.get(venue));
			} else {
				HashSet<String> singers = new HashSet<String>();
				singers.add(singer);
				singersByVenue.put(venue, singers);
			}

			if (singersProfit.containsKey(singerAndVenue)) {
				profit += singersProfit.get(singerAndVenue);
			}
			singersProfit.put(singerAndVenue, profit);
			// System.out.println(singersProfit.get(singerAndVenue)+"\n"+singersProfit.entrySet());
			input();
		}
	}

}
