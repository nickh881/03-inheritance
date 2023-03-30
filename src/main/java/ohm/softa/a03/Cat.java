package ohm.softa.a03;

import ohm.softa.a03.states.DigestingState;
import ohm.softa.a03.states.HungryState;
import ohm.softa.a03.states.PlayfulState;
import ohm.softa.a03.states.SleepingState;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static ohm.softa.a03.Cat.State.*;

public class Cat {
	private static final Logger logger = LogManager.getLogger();

	// valid states
	// public enum State {SLEEPING, HUNGRY, DIGESTING, PLAYFUL, DEAD}

	// initially, animals are sleeping
	private State state;

	// state durations (set via constructor), ie. the number of ticks in each state
	private final int sleep;
	private final int awake;
	private final int digest;

	private final String name;

	private int time = 0;
	private int timeDigesting = 0;

	public Cat(String name, int sleep, int awake, int digest) {
		this.name = name;
		this.sleep = sleep;
		this.awake = awake;
		this.digest = digest;

		state = new SleepingState(sleep);
	}

	public void tick() {
		logger.info("tick()");
		state = state.tick(this);
	}



	/**
	 * This would be a user interaction: feed the cat to change its state!
	 */
	public void feed(){
		if (!isHungry())
			throw new IllegalStateException("Can't stuff a cat...");

		logger.info("You feed the cat...");

		// change state and reset the timer
		state = ((HungryState)state).feed(this);
	}

	public boolean isAsleep() {
		return state instanceof SleepingState;
	}

	public boolean isPlayful() {
		return state instanceof PlayfulState;
	}

	public boolean isHungry() {
		return state instanceof HungryState;
	}

	public boolean isDigesting() {
		return state instanceof DigestingState;
	}

	public boolean isDead() {
		return state == State.DEAD;
	}
	public int getAwake(){
		return awake;
	}
	public int getSleeping(){
		return sleep;
	}
	public int getDigest(){
		return digest;
	}

	@Override
	public String toString() {
		return name;
	}

}
