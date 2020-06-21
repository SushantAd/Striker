
public class Striker {
	
//Single strike	Coins -1 * Score +1
	public int Strike() {
		return	pocketedBlack(ConfigurationValues.reduceSingleCoin)?ConfigurationValues.pocketStrike:ConfigurationValues.pocketNone;
	}
	
//Single strike	Coins -2 * Score +2
	public int MultiStrike() {
		return	pocketedBlack(ConfigurationValues.reduceMultiCoin)?ConfigurationValues.pocketMultiSrike:ConfigurationValues.pocketNone;
	}
	
//Single strike	RedCoins -1 * Score +3
	public int RedStrike() {
		return	pocketedRed(ConfigurationValues.reduceRedCoin)?ConfigurationValues.pocketRed:ConfigurationValues.pocketNone;
	}
	
//Single strike	Score -1	
	public int StrikerStrike() {
		return ConfigurationValues.strikerHitReduce;
	}
	
//Single strike	Coins -1 * Score -1
	public int Defunct() {
		return	pocketedBlack(ConfigurationValues.defunctReduce)?ConfigurationValues.reduceDefuntCoin:ConfigurationValues.pocketNone;
	}
	
//Pocket function to verify amount of coins left and pocket them
	public boolean pocketedBlack(int val)  {
		try {
		if(GameRules.bCoins<1) {
			System.out.println("No more Black coins!");			
			return false;
		}
		else 
		{
			GameRules.bCoins= GameRules.bCoins - val;
			return true;
		}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return false;			
	}
	
	public boolean pocketedRed(int val)  {
		try 
		{			
			if(GameRules.rCoin<=0) {
			throw new Exception("No more red coins!");
			}
			else 
			{
			GameRules.rCoin= GameRules.rCoin - val;
			return true;
			}
		}
		catch(Exception e) 
		{
			System.out.println(e.getMessage());
		}
		return false;
	}
}
