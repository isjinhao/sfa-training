package headfirst._06_command.undo;

/**
 * Created by Gavin on 2017/3/14.
 */
public interface Command {
    void execute();

    void undo();
}
