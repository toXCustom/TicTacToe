import java.util.Scanner;

public class Main {
    public static void printTable(String[][] inputs) {
        String startAndEnd = "---------";
        String startandEndLine = "|";

        System.out.println(startAndEnd);
        for (int i = 0; i < 3; i++) {
            System.out.print(startandEndLine + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(inputs[i][j] + " ");
            }
            System.out.print(startandEndLine);
            System.out.println();
        }
        System.out.println(startAndEnd);
    }

    public static int controlTheStatus(String[][] inputs, int moves) {
        if (inputs[0][0].equals("X") && inputs[0][1].equals("X") && inputs[0][2].equals("X") ||
                inputs[1][0].equals("X") && inputs[1][1].equals("X") && inputs[1][2].equals("X") ||
                inputs[2][0].equals("X") && inputs[2][1].equals("X") && inputs[2][2].equals("X") ||
                inputs[0][0].equals("X") && inputs[1][0].equals("X") && inputs[2][0].equals("X") ||
                inputs[0][1].equals("X") && inputs[1][1].equals("X") && inputs[2][1].equals("X") ||
                inputs[0][2].equals("X") && inputs[1][2].equals("X") && inputs[2][2].equals("X") ||
                inputs[0][0].equals("X") && inputs[1][1].equals("X") && inputs[2][2].equals("X") ||
                inputs[0][2].equals("X") && inputs[1][1].equals("X") && inputs[2][0].equals("X")) {
            System.out.println("X wins");
            moves = 9;
            return moves;
        } else if (inputs[0][0].equals("O") && inputs[0][1].equals("O") && inputs[0][2].equals("O") ||
                inputs[1][0].equals("O") && inputs[1][1].equals("O") && inputs[1][2].equals("O") ||
                inputs[2][0].equals("O") && inputs[2][1].equals("O") && inputs[2][2].equals("O") ||
                inputs[0][0].equals("O") && inputs[1][0].equals("O") && inputs[2][0].equals("O") ||
                inputs[0][1].equals("O") && inputs[1][1].equals("O") && inputs[2][1].equals("O") ||
                inputs[0][2].equals("O") && inputs[1][2].equals("O") && inputs[2][2].equals("O") ||
                inputs[0][0].equals("O") && inputs[1][1].equals("O") && inputs[2][2].equals("O") ||
                inputs[0][2].equals("O") && inputs[1][1].equals("O") && inputs[2][0].equals("O")) {
            System.out.println("O wins");
            moves = 9;
            return moves;
        } else {
            if (moves == 9) {
                System.out.println("Draw");
            }
        }
        return moves;
    }

    public static int[] readCoordinate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the coordinates: ");
        int coordinateA = scanner.nextInt();
        int coordinateB = scanner.nextInt();
        return new int[] {coordinateA, coordinateB};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] inputs = {{"_", "_", "_"}, {"_", "_", "_"}, {"_", "_", "_"}};

        printTable(inputs);
        //readCoordinate();
        int[] coordinates = new int[2];
        boolean coordinatesBool;
        int coordinatesOne = 0;
        String symbol = "X";
        int moves = 0;
        do {
            coordinatesBool = true;
            do {
                coordinates = readCoordinate();
                //checkIfUsed();
                if (coordinates[0] > 3 || coordinates[0] < 1 || coordinates[1] > 3 || coordinates[1] < 1) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else {
                    switch (coordinates[1]) {
                        case 3:
                            coordinatesOne = 0;
                            break;
                        case 2:
                            coordinatesOne = 1;
                            break;
                        case 1:
                            coordinatesOne = 2;
                            break;
                    }
                    if (!inputs[(coordinatesOne)][(coordinates[0] - 1)].equals("_")) {
                        System.out.println("This cell is occupied! Choose another one!");
                    } else {
                        coordinatesBool = false;
                    }
                }
            } while (coordinatesBool);
            inputs[coordinatesOne][coordinates[0] - 1] = symbol;
            if (symbol.equals("X")) {
                symbol = "O";
                moves++;
            } else {
                symbol = "X";
                moves++;
            }
            printTable(inputs);
            moves = controlTheStatus(inputs, moves);
        } while (moves < 9);
    }
}