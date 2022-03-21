import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class Solution {
    static class Food {
        int idx;
        int time;
        public Food(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }
    }

    public int solution(int[] food_times, long k) {
        int n = food_times.length;
        List<Food> foods = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            foods.add(new Food(i + 1, food_times[i]));
        }

        foods.sort(Comparator.comparingInt(o -> o.time));

        int preTime = 0;
        int i = 0;

        for (Food food : foods) {
            long diff = food.time - preTime;
            if (diff != 0) {
                long spend = diff * n;
                if (spend <= k) {
                    k -= spend;
                    preTime = food.time;
                }
                else {
                    k %= n;
                    foods.subList(i, food_times.length).sort(Comparator.comparingInt(o -> o.idx));
                    return foods.get(i + (int) k).idx;
                }
            }
            i++;
            n--;
        }

        return -1;
    }
}