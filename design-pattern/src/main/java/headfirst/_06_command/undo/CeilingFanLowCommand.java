package headfirst._06_command.undo;

/**
 * Created by Gavin on 2017/3/14.
 */
public class CeilingFanLowCommand extends AbstractCeilingFanCommand  {

    public CeilingFanLowCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    public void execute() {
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.low();
    }

}
