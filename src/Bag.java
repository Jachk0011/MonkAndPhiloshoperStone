public class Bag
{
	Coin head = null;
	
	public Coin peek()
	{
		return this.head;
	}
	
	public boolean isEmpty()
	{
		return this.peek()==null?true:false;
	}
	
	public void push(Coin coin)
	{
		Coin temp = this.peek();
		if(this.isEmpty())
			head = coin;
		else
		{
			temp = this.peek();
			
			{
				head = coin;
				coin.ptr = temp;
			}
		}
			
	}

	public void print()
	{
		Coin temp = this.peek();
		System.out.print("[");
		while(temp != null)
		{
			System.out.print(" " +temp.coin + " ");
			temp = temp.ptr;
		}
		System.out.print("]");
	}

	public int pop()
	{
		int coin = 0;
		Coin temp = this.peek();
		head = this.peek().ptr;
		coin = temp.coin;
		temp.ptr = null;
		return coin;
	}
	
	public Coin getTail()
	{
		Coin temp = this.peek();
		while(temp.ptr != null)
			temp = temp.ptr;
		return temp;
	}
	
	public int sum()
	{
		Coin temp = this.peek();
		int sum = 0;
		
		if(this.isEmpty())
			return -1;
		else
		{
			while(temp.ptr != null)
			{
				sum += temp.coin;
				temp = temp.ptr;			
			}		
			return sum + this.getTail().coin;	
		}
		
	}
	
	public int counter(){
		int counter = 1;
		if(this.isEmpty())
			return -1;
		else
		{
			Coin temp = this.peek();
			while(temp.ptr != null)
			{
				counter++;
				temp = temp.ptr;
			}
			
			return counter;
		}
	}
	
	public boolean sleep(int x)
	{
		if(this.sum() < x)
			return false;
		else if(this.sum() == x)
			return true;
		else
			return true;
					
	}
}