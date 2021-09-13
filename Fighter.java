package boxing;

public class Fighter {
	
	String name;
	int damage, health, weight, dodge; //dodge: bloklama yeteneði
	
	public Fighter(String name, int damage, int health, int weight, int dodge) {
		
		this.name = name;
		this.damage = damage;
		this.health = health;
		this.weight = weight;
		
		if(dodge >= 0 && dodge <= 100)
			this.dodge = dodge;
		else
			this.dodge = 0;
	}
	
	boolean isDodge() // Bloklama þansý hesaplamasý
	{
		double randomNumber = Math.random() * 100;
		return randomNumber <= this.dodge;
 	}
	
	int hit(Fighter foe) //foe rakip
	{
		System.out.println(this.name + " => " + foe.name + " damage: " + this.damage );
		
		if(foe.isDodge())
		{
			System.out.println(foe.name + " blocked incoming damage \n");
			return foe.health; //hasarý blokladýðý için caný azalmaz
		}
		
		if(foe.health - this.damage < 0)
		{
			return 0;  //negatif can olmaz, o yüzden sýfýrla
		}
		
		return foe.health - this.damage;
	}

}
