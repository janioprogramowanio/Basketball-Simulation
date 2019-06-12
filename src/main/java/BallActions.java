import java.util.ArrayList;

public interface BallActions {
	
	void passBall(Team t);
	void reclaimBall(Team t , OpponnentTeam o);
	void rebound(Team t , Player p);
	int checkBall(ArrayList<Player> playerList);
}
