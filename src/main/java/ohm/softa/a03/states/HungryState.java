package ohm.softa.a03.states;

import ohm.softa.a03.Cat;
import ohm.softa.a03.State;

public class HungryState extends State {
    public HungryState(int duration) {
        super(duration);
    }

    @Override
    protected State successor(Cat cat) {
        logger.info("I've been starving for a long time...");
        return new DeadState();
    }

    public State feed(Cat cat){
        logger.info("Eating...");
        return new DigestingState(cat.getDigest(), getDuration() - getTime());
    }
}
