import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SnakeGame {
    public static void main(String[] args) {
        List<List<Integer>> foodPos = new LinkedList<>();
        foodPos.add(Arrays.asList(1, 1));
        foodPos.add(Arrays.asList(3, 2));

        List<List<Integer>> snakePos = new LinkedList<>();
        List<Integer> position = new LinkedList<>();
        position.add(0);
        position.add(0);
        snakePos.add(position);
        boolean flag = true;
        Scanner scan = new Scanner(System.in);
        flag = moveSnake(foodPos, snakePos, 5);

        while (flag) {
            System.out.print("Enter Direction : ");
            String direction = scan.next();
            if (direction.equalsIgnoreCase("U")) {
                snakePos = findPos(snakePos, foodPos, 0, -1, 5);
            } else if (direction.equalsIgnoreCase("D")) {
                snakePos = findPos(snakePos, foodPos, 0, 1, 5);
            } else if (direction.equalsIgnoreCase("L")) {
                snakePos = findPos(snakePos, foodPos, 1, -1, 5);
            } else if (direction.equalsIgnoreCase("R")) {
                snakePos = findPos(snakePos, foodPos, 1, 1, 5);
            }
            if (snakePos != null) {
                foodPos = checkPos(snakePos, foodPos);
                flag = moveSnake(foodPos, snakePos, 5);
            } else {
                flag = false;
            }
        }
        scan.close();
    }

    static List<List<Integer>> checkPos(List<List<Integer>> snakePos, List<List<Integer>> foodPos) {
        for (List<Integer> list : snakePos) {
            if (foodPos.contains(list)) {
                foodPos.remove(list);
            }
        }
        return foodPos;
    }

    static List<List<Integer>> findPos(List<List<Integer>> snakePos, List<List<Integer>> foodPos, int idx, int a,
            int maxLimit) {
        List<Integer> list = new LinkedList<>(snakePos.get(0));
        int val = list.get(idx);
        val += a;
        list.set(idx, val);
        if (!snakePos.contains(list) && foodPos.contains(list)) {
            snakePos.add(0, list);
        } else {
            if (list.contains(-1) || list.contains(5) || snakePos.contains(list)) {
                System.out.println("Invalid Direction Game Over ...!");
                return null;
            }
            snakePos.add(0, list);
            snakePos.remove(snakePos.size() - 1);
        }
        return snakePos;
    }

    static boolean moveSnake(List<List<Integer>> foodPos, List<List<Integer>> snakePos, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (snakePos.size() < size * size) {
                    List<Integer> eachPos = new LinkedList<>();
                    eachPos.add(i);
                    eachPos.add(j);
                    if (snakePos.contains(eachPos)) {
                        System.out.print("S");
                    } else if (foodPos.contains(eachPos)) {
                        System.out.print("F");
                    } else {
                        System.out.print("|");
                    }
                }
            }
            System.out.println();
        }
        return true;
    }
}
