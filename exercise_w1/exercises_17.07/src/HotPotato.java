import java.util.Scanner;

public class HotPotato {

	static int tosses;
	static String children[];//list
	static int lastKidWithThePotato=0;
	
	public static void main(String[] args) {
		input();
		game();
	}

	static void input() {
		Scanner scan = new Scanner(System.in);
		children = scan.nextLine().split(" ");
		tosses = scan.nextInt();
	}

	static void game() {
		int numOfChildren = children.length;		
		while (numOfChildren !=1) {
			int currentRoundTosses = tosses-1;
			if(tosses==1) {
				currentRoundTosses=1;
			}
			while (currentRoundTosses>0) {
				for (int i = lastKidWithThePotato; i < children.length; i++) {
					if (children[i] != null) {
						if(tosses==1) {
							currentRoundTosses=0;
						}
						if (currentRoundTosses == 0) {
							numOfChildren--;
							System.out.printf("Removed %s\n", children[i]);
							children[i] = null;
							lastKidWithThePotato=i+1;
							if(lastKidWithThePotato==children.length) {
								lastKidWithThePotato=0;
							}							
							break;							
						}
						currentRoundTosses--;
						if(lastKidWithThePotato+1==children.length) {
							lastKidWithThePotato=0;
						}
					}else {
						if(i==children.length-1)
						{
							i=-1;
						}
					}
			
				}
			}
		}
		
		for (int i = 0; i < children.length; i++) {
			if (children[i] != null) {
				System.out.printf("Last is %s\n", children[i]);
			}
		}
	}
}
