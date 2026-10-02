package lab1;

import java.util.Objects;

/**
 * Герой игры. Способ перемещения задаётся стратегией и может меняться во время работы программы.
 */
public class Hero {

    private final String name;
    private Point position;
    private MoveStrategy moveStrategy;
    private double totalHours;

    public Hero(String name, Point position, MoveStrategy moveStrategy) {
        this.name = Objects.requireNonNull(name);
        this.position = Objects.requireNonNull(position);
        this.moveStrategy = Objects.requireNonNull(moveStrategy);
    }

    public void setMoveStrategy(MoveStrategy moveStrategy) {
        this.moveStrategy = Objects.requireNonNull(moveStrategy);
        System.out.printf("%s теперь перемещается %s.%n", name, moveStrategy.getName());
    }

    /** Переместиться в точку target текущим способом. */
    public void move(Point target) {
        Objects.requireNonNull(target);
        totalHours += moveStrategy.move(name, position, target);
        position = target;
    }

    public String getName() {
        return name;
    }

    public Point getPosition() {
        return position;
    }

    public MoveStrategy getMoveStrategy() {
        return moveStrategy;
    }

    public double getTotalHours() {
        return totalHours;
    }
}
