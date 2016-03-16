import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BowlingGameTest {
	private Game g;
	
	@Before
	public void before() {
		g = new Game();
	}
	
	@Test
	public void shouldTestAllMissedRolls()  {
		rollMany(20, 0);
		assertEquals(0, g.score());
	}
	
	@Test
	public void shouldTestForOneHitAtEveryRound() {
		rollMany(20, 1);
		assertEquals(20, g.score());
	}
	
	@Test
	public void shouldTestOneSpare() {
		rollSpare();
		g.roll(3);
		rollMany(17, 0);
		assertEquals(16, g.score());
	}
	
	@Test
	public void shouldTestOneStrike() {
		rollStrike();
		g.roll(3);
		g.roll(4);
		rollMany(16, 0);
		assertEquals(24, g.score());
	}
	
	@Test
	public void shouldTestThePerfectGame() {
		rollMany(12, 10);
		assertEquals(300, g.score());
	}
	
	private void rollMany(int n, int pins) {
		for(int i = 0; i < n; i++)
			g.roll(pins);
	}
	
	private void rollStrike() {
		g.roll(10);
	}
	
	private void rollSpare() {
		g.roll(5);
		g.roll(5);
	}

}
