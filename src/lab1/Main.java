package lab1;

import java.util.List;
import java.util.Scanner;

/**
 * Демонстрация паттерна «Стратегия»: пользователь выбирает и меняет способ перемещения героя.
 */
public class Main {

    private static final List<MoveStrategy> STRATEGIES = List.of(
            new WalkStrategy(),
            new HorseStrategy(),
            new FlyStrategy()
    );

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Hero hero = new Hero("Герой", new Point(0, 0), STRATEGIES.get(0));

        System.out.println("Герой стоит в точке " + hero.getPosition()
                + " и перемещается " + hero.getMoveStrategy().getName() + ".");

        while (true) {
            System.out.println();
            System.out.println("1 — сменить способ перемещения");
            System.out.println("2 — переместиться в точку");
            System.out.println("3 — показать состояние героя");
            System.out.println("0 — выход");
            System.out.print("> ");

            if (!in.hasNextLine()) {
                break;
            }
            switch (in.nextLine().trim()) {
                case "1" -> chooseStrategy(in, hero);
                case "2" -> moveHero(in, hero);
                case "3" -> printState(hero);
                case "0" -> {
                    System.out.println("Выход.");
                    return;
                }
                default -> System.out.println("Нет такого пункта меню.");
            }
        }
    }

    private static void chooseStrategy(Scanner in, Hero hero) {
        for (int i = 0; i < STRATEGIES.size(); i++) {
            System.out.printf("%d — %s%n", i + 1, STRATEGIES.get(i).getName());
        }
        System.out.print("Способ: ");
        if (!in.hasNextLine()) {
            return;
        }
        try {
            int index = Integer.parseInt(in.nextLine().trim()) - 1;
            hero.setMoveStrategy(STRATEGIES.get(index));
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            System.out.println("Нужно ввести номер от 1 до " + STRATEGIES.size() + ".");
        }
    }

    private static void moveHero(Scanner in, Hero hero) {
        System.out.print("Координаты точки через пробел (x y): ");
        if (!in.hasNextLine()) {
            return;
        }
        String[] parts = in.nextLine().trim().replace(',', '.').split("\\s+");
        if (parts.length != 2) {
            System.out.println("Нужно ввести два числа, например: 10 5");
            return;
        }
        try {
            Point target = new Point(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]));
            hero.move(target);
        } catch (NumberFormatException e) {
            System.out.println("Координаты должны быть числами.");
        }
    }

    private static void printState(Hero hero) {
        System.out.printf("%s в точке %s, перемещается %s, всего в пути: %.2f ч.%n",
                hero.getName(), hero.getPosition(), hero.getMoveStrategy().getName(), hero.getTotalHours());
    }
}
