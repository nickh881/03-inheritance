package ohm.softa.a03.states;

import ohm.softa.a03.Cat;
import ohm.softa.a03.State;

public class DigestingState extends State {
    private final int remainingAwakeTime;
    public DigestingState(int duration, int remainingAwakeTime) {
        super(duration);
        this.remainingAwakeTime = remainingAwakeTime;
    }

    @Override
    protected State successor(Cat cat) {
        logger.info("Getting in a playful mood!");
        return new PlayfulState(remainingAwakeTime - cat.getDigest());
    }
}
