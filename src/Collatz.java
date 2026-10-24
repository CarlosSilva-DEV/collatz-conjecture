public class Collatz {
    public static void map(int seed) {
        validate(seed); // it can be any positive integer number greater than 0

        int n = seed; // used only to preserve the original seed for printing
        int steps = 0; // tracks the number of steps the orbit takes to reach a trivial cycle 
        int peak = seed; // tracks the largest number reached by the orbit

        // collatz map algorithm 
        while (n > 1) {
            if (isEven(n)) n /= 2;
            else n = 3 * n + 1;

            if (peak < n) peak = n; // checks if the current number is eligible to be the peak 
            steps++; // each loop iteration is considered to be a step, therefore incrementing the pointer 
        } 

        // data printing
        System.out.printf("Seed number: %d\n", seed);
        System.out.printf("Total stopping time: %d\n", steps);
        System.out.printf("Peak: %d\n", peak);
    }

    // checks if the current number is even
    private static boolean isEven(int num) { 
        return num % 2 == 0;
    }

    // input validation method
    private static void validate(int num) { 
        if (num <= 0) throw new IllegalArgumentException("You should type a positive number greater than zero");
        if (num == 1) return; // if n is 1, it takes 0 steps to reach a trivial cycle and the peak is 1 
    }

    // cli running 
    public static void main(String[] args) {
        if (args.length < 1) throw new IllegalArgumentException("Missing required argument: <seed>"); 

        try {
            int num = Integer.parseInt(args[0]);
            map(num);
        } catch (NumberFormatException exception) {
            System.err.println("Error: The argument must be a valid integer number");
        }
    }
}
