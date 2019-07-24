import java.util.*;

public class HotPotato_v2 {

	static int tosses;
	static ArrayList<String> children = new ArrayList<String>();
	static int kidToRemove = 0;
	static int numOfKids;

	public static void main(String[] args) {
		input();
		game();
	}

	static void input() {
		Scanner scan = new Scanner(System.in);
		children=new ArrayList<String>(Arrays.asList(scan.nextLine().split(" ")));
		tosses = scan.nextInt();
		numOfKids=children.size();
	}

	static void game() {
		while(numOfKids>1)
		{
			findKidToRemove();
			kidToRemove-=1;
			System.out.printf("Removed %s\n", children.get(kidToRemove));
			children.remove(kidToRemove);
			numOfKids--;
		}
		System.out.printf("Last is %s", children);
	}
	
	static void findKidToRemove()
	{
		if((tosses+kidToRemove)%numOfKids==0)
		{
			kidToRemove=numOfKids;
		}
		else {
			kidToRemove=(tosses+kidToRemove)%numOfKids;
		}
	}

}
