package headfirst._06_command.undo;

/**
 * Created by Gavin on 2017/3/14.
 */
public class CeilingFanMediumCommand extends AbstractCeilingFanCommand  {

    public CeilingFanMediumCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    public void execute() {
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.medium();
    }

}
