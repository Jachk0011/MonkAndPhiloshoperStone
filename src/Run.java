import java.io.*;
import java.util.StringTokenizer;


public class Run {
	static Bag harry = new Bag();
	static Bag monk = new Bag();
	static Run run = new Run();
	
	public void loadHarry(int[] arr)
	{
		for(int i=0; i<arr.length; i++)
			harry.push(new Coin(arr[i]));
	}
	
	public void instruccions(String[] arr, int x, int[] worths)
	{
		this.loadHarry(worths);//load harry bag, at moment zero it's empty
		
		for(int i=0; i < arr.length; i++)
		{
			if(arr[i].equals("Harry")) //decrement harry's bag
			{
				int temp = 0;
				if(harry.isEmpty())
					break; //because here is nothing to do
				else
				{	
					if(i == arr.length-1)
					{				
						temp = harry.pop();																	
						monk.push(new Coin(temp));						
						System.out.println("monk bag counter: "+ monk.counter());
						System.exit(0); // stop the all the program
					}
					
					else if(monk.sleep(x))	
					{
						//System.out.println("Harry bag counter after: "+ harry.counter());
						System.out.println("monk bag counter: "+ monk.counter());
						System.exit(0); // stop the all the program
					}
						
					else 
					{
						temp = harry.pop();																	
						monk.push(new Coin(temp));						
					}					
				}			
			}
			else if(arr[i].equals("Remove"))
			{
				if(monk.sleep(x))						
				{
					//System.out.println("Harry bag counter after: "+ harry.counter());
					System.out.println("monk bag counter: "+ monk.counter());
					System.exit(0); // stop the all the program
				}
				else 
					monk.pop();								
			}
		}
	}
	
	public void readFile()
	{
		File archivo = null;
	      FileReader fr = null;
	      BufferedReader br = null;

	      try 
	      {
			 archivo = new File ("test5.txt");
			 fr = new FileReader (archivo);
			 br = new BufferedReader(fr);
			
			
			 String line;
			 int num = Integer.MIN_VALUE, 
				 stop = Integer.MIN_VALUE, 
				 numInstructions = 0;
			 int[] values = null;
			 String[] instructions = null;
			 
			 
			 while((line=br.readLine()) != null)
			 {
				 values = new int[Integer.parseInt(line)];
				 StringTokenizer st = new StringTokenizer (br.readLine());
				 for(int i=0; i < values.length; i++)
					 values[i] = Integer.parseInt(st.nextToken());
				 
				 st = new StringTokenizer (br.readLine());
				 while(st.hasMoreTokens())
				 {
					 numInstructions = Integer.parseInt(st.nextToken());
					 stop = Integer.parseInt(st.nextToken());
				 }
				 
				 instructions = new String[numInstructions];
				 for(int i=0; i < instructions.length; i++)
					 instructions[i] = br.readLine();
					 		         
			 }
			 
			 run.instruccions(instructions, stop, values);
	      }
	      catch(Exception e)
	      {
	    	  e.printStackTrace();
	      }
	      finally
	      {	         
			 try{                    
			    if( fr != null ){   
			       fr.close();     
			    }                  
			 }catch (Exception e2){ 
			    e2.printStackTrace();
			 }
	      }
	}
	
	public static void main(String[] args) {
				
		run.readFile();	
	}
}