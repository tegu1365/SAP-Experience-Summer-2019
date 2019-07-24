import java.util.*;

public class BrowserHistory {
	static String command;
	static ArrayDeque<String> history=new ArrayDeque<String>();
 
	public static void main(String[] args) {
		Navigation();
	}
	
	static void Back()
	{
		
		if(history.size()==1)
		{
			System.out.println("no previous URLs");
			//history.push(element);
		}
		else
		{
			System.out.println(history.peek());
		}
	}
	static void Navigation()
	{
		Scanner input=new Scanner(System.in);
		command= input.nextLine();
		while(!command.equals("Home"))
		{
			if(command.equals("back"))
			{
				Back();
			}else
			{
				history.push(command);
				System.out.println(history.peek());
			}
			//System.out.println(history.peek());
			command=null;
			command= input.nextLine();
		}
		
	}
}
