import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
	
	public static void main(String[] args)throws IOException {
		Game game1= new Game();
		game1.startGame(game1);	
	}
	
	public void startGame(Game g1) {
		try {
//Game rules object for setting number of Black Coins and Red Coins			
			GameRules gameRules1= new GameRules(9,1);
//Player objects, for current scenario system is based on the assumption 
//that only 2 users will be playing on alternate turns 
			
			Player player1 = new Player();
			Player player2 = new Player();
			int i=0;
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
			do {	
				//temp variable to store choice input
				int choice=0;				
				if(i%2==0) 
				{
					System.out.println("Player 1: Choose an outcome from the list below \n1. Strike \n2. Multistrike \n3. Red strike \n4. Striker strike \n5. Defunct coin \n6. None");
//checkPositiveInteger checks for empty spaces, float, characters and unsigned integers				
				choice=checkPositiveInteger(br.readLine());
				player1.setScore(g1.SelectStriker(choice,player1,gameRules1));
				}
				else 
				{
					System.out.println("Player 1: Choose an outcome from the list below \n1. Strike \n2. Multistrike \n3. Red strike \n4. Striker strike \n5. Defunct coin \n6. None");
				choice=checkPositiveInteger(br.readLine());
				player2.setScore(g1.SelectStriker(choice,player2,gameRules1));
				}				
			i++;
//gamerules checkWin checks for the winner based on given static criteria
			if(gameRules1.checkWin(player1, player2)==true)
			{
				g1.showScore(player1,player2);
				break;
			}
//gamerules checkDraw checks for draws based on given static criteria			
			else if(gameRules1.checkDraw(player1,player2)==true)
			{
				g1.showScore(player1,player2);
				break;
			}
			
			}
			while(true);
			}
			catch(ArrayIndexOutOfBoundsException aie) {
				System.out.println("No more coins can be pocketed...Exiting the game!");
			}
			catch(Exception e) {
				System.out.println(e);
			}
	}
	
//SelectStriker class for selecting and executing all Striker services based on input	
	public int SelectStriker(int choice, Player player, GameRules gameRules1){
		Striker stiker1 = new Striker();
		int val=0;
		try {
		switch(choice) {
		case 1:
			val=stiker1.Strike();		
			break;
			
		case 2:
			val= stiker1.MultiStrike();		
			break;
			
		case 3:
			val= stiker1.RedStrike();
			break;
			
		case 4:
			val= stiker1.StrikerStrike();
			break;

		case 5:
			val= stiker1.Defunct();
			break;
			
		case 6:
			val= 0;
			break;			
		
		default:
			System.out.println("Please enter a correct value in next turn!");
			break;
		}	
			}
		catch(Exception e) {
			System.out.println(e.getMessage());			
		}
		val = gameRules1.checkFoul(player)+gameRules1.checkNoPocket(player)+ val;
		return val;		
	}
	
	public void showScore(Player player1, Player player2) {
		System.out.println("Score: Player 1: "+player1.getScore()+" Player 2:"+player2.getScore());
	}
	
	//check if value is integer/float/rounded/absolute	
		public int checkPositiveInteger(String strVal) {
	//to check if string value is integer
			String str = strVal.replaceFirst("^0+(?!$)", "").replaceAll("\\s","");
			try {
			Integer.parseInt(str);
			return (Math.round(Math.abs(Long.parseLong(str))));
	       }
	       catch (NumberFormatException nfe1) {   	  
	    	   try { 		 
	//to check if string value is float
	    		   return (int)(Math.round(Math.abs(Double.parseDouble(str))));
	    	   }
	    	   catch(NumberFormatException nfe2) {
	//to deal with string values that are actually string e.g abc,abcd
	    		   return 0;  
	    	   }    	   
	       }
		}
	
}
