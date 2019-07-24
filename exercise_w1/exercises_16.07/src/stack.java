import java.util.ArrayDeque;
import java.util.Scanner;

public class stack {

	public static void main(String[] args) {
		ArrayDeque<String> stack=new ArrayDeque<String>();
		Scanner input=new Scanner(System.in);
		String command= input.nextLine();
		while(command!="end")
		{
			switch(command)
			{
			case "pop":
				System.out.println(stack.pop());
				break;
			case "display":
				for(int i=0;i<stack.size();i++)
				{
					System.out.println(stack.pop());
				}
				break;
			case "peek":
				System.out.println(stack.peek());
				break;
			default:
				stack.push(command);
				break;
			}
			command=null;
			command= input.nextLine();		
		}
		
	}

}
