package ohm.softa.a03;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class State {
    protected static Logger logger = LogManager.getLogger();
    int time = 0;
    final int duration;

    protected State(int duration) {
        this.duration = duration;
    }

    final State tick(Cat cat){
        this.time++;
        if(this.time < this.duration){
            logger.info("Still in {}", getClass().getSimpleName());
            return this;
        }
        else{
            return successor(cat);
        }
    }
    protected abstract State successor(Cat cat);
    public int getTime(){
        return time;
    }
    public int getDuration(){
        return duration;
    }
}
