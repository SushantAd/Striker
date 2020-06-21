
public class Player {

	private int score=0;
	private int foul=1;
	private int noPocket=1;


	public void setScore(int score) {
		this.score = this.score+score;
		if(score<0) {
			this.foul++;
		}
		if(score==0) {
			this.noPocket++;
		}
	}
	
	public void setNoPocket(int n) {
		this.noPocket=n;
	}
	
	public void setFoul(int n) 
	{
		this.foul=n;
	}
	
	public int getFoul() {
		return foul;
	}
	
	public int getNoPocket() {
		return noPocket;
	}
	
	public int getScore() 
	{
		return score;
	}
}
