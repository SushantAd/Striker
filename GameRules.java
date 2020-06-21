
public class GameRules {

//GameRules global objects to store number of black and red coins
	static int bCoins=0;
	static int rCoin=0;

//when object is initialized the number of coins to begin with are configured	
	GameRules(int bCoins,int rCoin){
		GameRules.bCoins=bCoins;
		GameRules.rCoin=rCoin;
	}
	
//check for 3 fouls and reduce value	
	int checkFoul(Player p){
		if(p.getFoul()%3==0 && p.getFoul()>0) {
			System.out.println("3 Fouls!!! 1 point deducted");			
			p.setFoul(0);
			return ConfigurationValues.foulReduce;
		}
		else {
			return ConfigurationValues.defaultZero;
		}
	}

//check for 3 Nopockets and reduce value
	int checkNoPocket(Player p) {
		if(p.getNoPocket()%3==0 && p.getNoPocket()>0) {
			System.out.println("3 No Pockets!!! 1 point deducted");			
			p.setNoPocket(0);
			return ConfigurationValues.nopocketReduce;
		}
		else {
			return ConfigurationValues.defaultZero;
		}
	}
		
//check for Play win satisfying the below condition: 
	boolean checkWin(Player p1,Player p2) 
	{
		if(p1.getScore()>=5 && (p1.getScore()-p2.getScore())>=3) {
			System.out.println("Player 1 has won... Exiting System!");
			return true;
		}
		else if(p2.getScore()>=5 && (p2.getScore()-p1.getScore())>=3)
		{
			System.out.println("Player 2 has won... Exiting System!");
			return true;
		}		
		return false;
	}
	
//check for draw if no coins are left satisfying below condition	
	boolean checkDraw(Player p1,Player p2) 
	{
		if(GameRules.bCoins<=0 && GameRules.rCoin<=0) 
		{	
		int temp= (p1.getScore()>p2.getScore())?p1.getScore():p2.getScore();
		if((Math.abs(p1.getScore()-p2.getScore()))<3 || temp<5) {
			System.out.println("The Game is now a draw... Exiting System!");
			return true;
		}
		}
		return false;
	}
}
