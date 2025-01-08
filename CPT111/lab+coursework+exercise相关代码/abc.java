public class abc {

    private static final char SYMBOL_GREEN = 'G';
    private static final char SYMBOL_INFECTED = 'I';
    private static final char SYMBOL_DEFOLIATED = 'D';

    private static final char[][] DEFAULT_FOREST_1 = { // forest for task 1
            { SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN } //
            , { SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_INFECTED, SYMBOL_GREEN, SYMBOL_GREEN } //
            , { SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_DEFOLIATED, SYMBOL_DEFOLIATED, SYMBOL_GREEN } //
            , { SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN } //
            , { SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN } //
    };

    private static final char[][] DEFAULT_FOREST_2 = { // forest for task 2
            { SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_INFECTED, SYMBOL_GREEN, SYMBOL_DEFOLIATED } //
            , { SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN } //
            , { SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN } //
            , { SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN } //
            , { SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN, SYMBOL_GREEN } //
    };

    public static void main(String[] args) {
        System.out.println("\nParasite Simulation\n");

        char[][] forestState = DEFAULT_FOREST_1;

        int numOfGenerations = 30;
        for (int gen = 0; gen < numOfGenerations; gen++) {
            simulateGeneration(forestState);
            System.out.println("Generation " + (gen + 1) + ":");
            printForest(forestState);
        }
    }

    private static void simulateGeneration(char[][] forest) {
        char[][] newForest = new char[forest.length][forest[0].length];

        for (int i = 0; i < forest.length; i++) {
            for (int j = 0; j < forest[i].length; j++) {
                if (forest[i][j] == SYMBOL_INFECTED) {
                    newForest[i][j] = SYMBOL_DEFOLIATED;
                } else if (forest[i][j] == SYMBOL_DEFOLIATED) {
                    newForest[i][j] = SYMBOL_GREEN;
                } else if (forest[i][j] == SYMBOL_GREEN) {
                    if (i > 0 && forest[i - 1][j] == SYMBOL_INFECTED) newForest[i][j] = SYMBOL_INFECTED;
                    if (i < forest.length - 1 && forest[i + 1][j] == SYMBOL_INFECTED) newForest[i][j] = SYMBOL_INFECTED;
                    if (j > 0 && forest[i][j - 1] == SYMBOL_INFECTED) newForest[i][j] = SYMBOL_INFECTED;
                    if (j < forest[i].length - 1 && forest[i][j + 1] == SYMBOL_INFECTED) newForest[i][j] = SYMBOL_INFECTED;
                }
            }
        }

        for (int i = 0; i < forest.length; i++) {
            System.arraycopy(newForest[i], 0, forest[i], 0, forest[i].length);
        }
    }

    private static void printForest(char[][] forest) {
        for (char[] row : forest) {
            System.out.println(new String(row));
        }
        System.out.println();
    }

}
