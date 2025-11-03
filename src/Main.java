public class Main{

    public static int cheapestKeyboard(int[] keyboards) {
        return java.util.Arrays.stream(keyboards).min().orElse(-1);
    }

    public static int mostExpensiveItem(int[] keyboards, int[] usb) {
        int maxK = java.util.Arrays.stream(keyboards).max().orElse(0);
        int maxU = java.util.Arrays.stream(usb).max().orElse(0);
        return Math.max(maxK, maxU);
    }

    public static int mostExpensiveUsbWithinBudget(int[] usb, int budget) {
        return java.util.Arrays.stream(usb)
                .filter(u -> u <= budget)
                .max()
                .orElse(-1);
    }

    public static int maxSpent(int[] keyboards, int[] usb, int budget) {
        int max = -1;
        for (int k : keyboards) {
            for (int u : usb) {
                int sum = k + u;
                if (sum <= budget && sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] keyboards = {40, 50, 60};
        int[] usb = {8, 12};
        int budget = 60;

        System.out.println("Cea mai ieftina tastatura: " + cheapestKeyboard(keyboards));
        System.out.println("Cel mai scump articol: " + mostExpensiveItem(keyboards, usb));
        System.out.println("Cel mai scump USB in buget: " + mostExpensiveUsbWithinBudget(usb, 30));
        System.out.println("Suma maxima cheltuita: " + maxSpent(keyboards, usb, budget));
    }
}
