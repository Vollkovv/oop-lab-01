package lab1;

/**
 * Полёт: по прямой, 60 км/ч, плюс время на взлёт и посадку.
 */
public class FlyStrategy implements MoveStrategy {

    private static final double SPEED = 60.0;
    private static final double TAKEOFF_LANDING_HOURS = 0.25;

    @Override
    public String getName() {
        return "по воздуху";
    }

    @Override
    public double move(String heroName, Point from, Point to) {
        double distance = from.distanceTo(to);
        double time = distance / SPEED + TAKEOFF_LANDING_HOURS;
        System.out.printf("%s летит по прямой из %s в %s: %.1f км, %.2f ч (с учётом взлёта и посадки).%n",
                heroName, from, to, distance, time);
        return time;
    }
}
