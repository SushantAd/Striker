import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.net.URL;

public class GameFileInput {
	
	public static void main(String[] args)throws IOException, InterruptedException {
		GameFileInput game= new GameFileInput();
//We can add all the test cases in a folder and set it up here
		URL url = GameFileInput.class.getClassLoader().getResource("testcases");
		File folder = new File(url.getPath());
		File[] listOfFiles = folder.listFiles();
		for (File file : listOfFiles) {
		    if (file.isFile()) {
		    	
		        System.out.println("**********"+file.getName()+"**********");
		        game.startGame(file.getPath(), game);
		    }
		}
	}
	
	public void startGame(String filePath, GameFileInput g1) {
		try {
//Game rules object for setting number of Black Coins and Red Coins
			GameRules gr1 = new GameRules(9,1);
//Player objects, for the current problem we only have 2 players which can be later increased via Player object Array
			Player p1 = new Player();
			Player p2 = new Player();
			int i=0;
			FileReader fr = new FileReader(filePath);
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(fr);
			String line= br.readLine();
			System.out.println(line);
			String[] inputValues = line.trim().split("\\s+");
			
			do {
			int choice=0;
			if(i%2==0) {
				System.out.println("Player 1: Choose an outcome from the list below \n1. Strike \n2. Multistrike \n3. Red strike \n4. Striker strike \n5. Defunct coin \n6. None");
				choice= checkPositiveInteger(inputValues[i]);
				p1.setScore(g1.SelectStriker(choice,p1, gr1));
			}
			else {
				System.out.println("Player 1: Choose an outcome from the list below \n1. Strike \n2. Multistrike \n3. Red strike \n4. Striker strike \n5. Defunct coin \n6. None");
				choice= checkPositiveInteger(inputValues[i]);
				p2.setScore(g1.SelectStriker(choice,p2, gr1));
			}
			System.out.println(choice);
			if(gr1.checkWin(p1, p2)==true)
			{
				g1.showScore(p1,p2);
				break;
			}
			else if(gr1.checkDraw(p1,p2)==true)
			{
				g1.showScore(p1,p2);
				break;
			}
			i++;
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
	
	public int SelectStriker(int n, Player p, GameRules gr1){
		Striker s1 = new Striker();
		int val=0;
		try {
		switch(n) {   
		case 1:
			val=s1.Strike();		
			break;
			
		case 2:
			val= s1.MultiStrike();		
			break;
			
		case 3:
			val= s1.RedStrike();
			break;
			
		case 4:
			val= s1.StrikerStrike();
			break;

		case 5:
			val= s1.Defunct();
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
		val = gr1.checkFoul(p)+gr1.checkNoPocket(p)+ val;
		return val;		
	}
	
	public void showScore(Player p1, Player p2) {
		System.out.println("Score: Player 1: "+p1.getScore()+" Player 2:"+p2.getScore());
	}
	
//check if value is integer/float/rounded/absolute	
	public int checkPositiveInteger(String strVal) 
	{
//to check if string value is integer
		String str = strVal.replaceFirst("^0+(?!$)", "").replaceAll("\\s","");
		try 
		{
		Integer.parseInt(str);
		return (Math.round(Math.abs(Long.parseLong(str))));
		}
		catch (NumberFormatException nfe1) 
		{   	  
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
