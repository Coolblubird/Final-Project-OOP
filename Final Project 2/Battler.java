
//Jordan Ashe 4-15-21

public class Battler {
	public static void main(String[] args) {
		
	}
	private String name = "Blanky Blankerton";
	boolean status;
	boolean block;
	int mHP = 10;
	int cHP = 10;
	int dmg = 2;
	int spd = 2;
	
	protected Battler() {
		
	}

	protected Battler(String c, boolean f) {
		
	}

	public String getName() {
		return name;
	}
	
	public void setCHP(int newCHP) {
		this.cHP = newCHP;
	}
		
	public int getMHP() {
		return this.mHP;
	}	
	
	public int getCHP() {
		return this.cHP;
	}

	public void setStatus(Boolean s) {
		this.status = s;
	}

	public boolean isDead() {
		return status;
	}

	public void setBlock(Boolean s) {
		this.block = s;
	}

	public boolean isBlocking() {
		return block;
	}
	
}