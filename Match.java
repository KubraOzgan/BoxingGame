package boxing;

public class Match {
	
	Fighter f1;
	Fighter f2;
	
	int minweight, maxweight;

	public Match(Fighter f1, Fighter f2, int minweight, int maxweight) {
		
		this.f1 = f1;
		this.f2 = f2;
		this.minweight = minweight;
		this.maxweight = maxweight;
	}
	
	boolean isCheck()
	{
		return(this.f1.weight >= minweight && this.f1.weight <= maxweight) &&
				(this.f2.weight >= minweight && this.f2.weight <= maxweight);
	}
	
	boolean isWin()
	{
		if(this.f1.health == 0)
		{
			System.out.println(this.f2.name + " is the winner!");
			return true;
		}
		
		if(this.f2.health == 0)
		{
			System.out.println(this.f1.name + " is the winner!");
			return true;
		}
		
		return false;
	}
	
	Fighter isStart() 
	{
		double randomFighter = Math.random() * 100;
		
		if(randomFighter > 50)
			return f1;
		else
			return f2;
	}
	
	void run()
	{
		Fighter f = isStart();
		if(isCheck()) 
		{
			System.out.println(this.f1.name + "'s health at the beginning: " + this.f1.health);
			System.out.println(this.f2.name + "'s health at the beginning: " + this.f2.health);
			
			while(this.f1.health > 0 && f2.health > 0) //canlar� varken d�v��ecekler (buraya true yazsakta olur)
			{
				System.out.println("\n--NEW ROUND--");
				
				/*this.f2.health = this.f1.hit(f2); //f1 ba�l�yor, rakip f2 hit'e g�nderildi
				if(isWin()) // canlar� 0'�n alt�na indi�inde d�v�� devam etmesin diye koyduk, �stteki while ile bunu sa�layamay�z, her seferinde kontrol etmek gerek
					break;
				
				this.f1.health = this.f2.hit(this.f1); //2. vuru� f2'de, s�rayla vuruyorlar
				if(isWin())
					break;*/
				if(f == f1)
				{
					this.f2.health = this.f1.hit(f2); 
					if(isWin())
						break;
					
					this.f1.health = this.f2.hit(this.f1); 
					if(isWin())
						break;
				}
				else if(f == f2)
				{
					this.f1.health = this.f2.hit(this.f1); 
					if(isWin())
						break;
					
					this.f2.health = this.f1.hit(f2); 
					if(isWin()) 
						break;
				}
					
		
				System.out.println(this.f1.name + "'s health: " + this.f1.health);
				System.out.println(this.f2.name + "'s health: " + this.f2.health);
			}
		}
		else
		{
			System.out.println("Athletes' weights do not match.");
		}
	}
	
}
