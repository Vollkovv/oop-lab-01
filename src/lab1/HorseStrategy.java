package lab1;

/**
 * На лошади: по дорогам, 20 км/ч, но лошади нужен отдых каждые 30 км.
 */
public class HorseStrategy implements MoveStrategy {

    private static final double SPEED = 20.0;
    private static final double KM_BEFORE_REST = 30.0;
    private static final double REST_HOURS = 0.5;

    @Override
    public String getName() {
        return "на лошади";
    }

    @Override
    public double move(String heroName, Point from, Point to) {
        double distance = from.roadDistanceTo(to);
        int rests = (int) Math.ceil(distance / KM_BEFORE_REST) - 1;
        rests = Math.max(rests, 0);
        double time = distance / SPEED + rests * REST_HOURS;
        System.out.printf("%s скачет на лошади из %s в %s: %.1f км, привалов: %d, %.2f ч.%n",
                heroName, from, to, distance, rests, time);
        return time;
    }
}
