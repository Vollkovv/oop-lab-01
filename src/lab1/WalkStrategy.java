package lab1;

/**
 * Пешком: только по дорогам, 5 км/ч.
 */
public class WalkStrategy implements MoveStrategy {

    private static final double SPEED = 5.0;

    @Override
    public String getName() {
        return "пешком";
    }

    @Override
    public double move(String heroName, Point from, Point to) {
        double distance = from.roadDistanceTo(to);
        double time = distance / SPEED;
        System.out.printf("%s идёт пешком по дорогам из %s в %s: %.1f км, %.2f ч.%n",
                heroName, from, to, distance, time);
        return time;
    }
}
