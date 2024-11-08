import java.io.*;
import java.util.Scanner;

public class AdventureTime {

    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        try {
            int challengeOneAnswer = challengeOne("inputOneTwo.txt");
            System.out.println("Challenge 1 Answer: " + challengeOneAnswer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            int challengeTwoAnswer = challengeTwo("inputOneTwo.txt");
            System.out.println("Challenge 2 Answer: " + challengeTwoAnswer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            int challengeThreeAnswer = challengeThree("inputThreeFour.txt");
            System.out.println("Challenge 3 Answer: " + challengeThreeAnswer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            int challengeFourAnswer = challengeFour("inputThreeFour.txt");
            System.out.println("Challenge 4 Answer: " + challengeFourAnswer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /** TODO 1
     *
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */
    public static int challengeOne(String fileName) throws IOException {
        Scanner scanner = new Scanner(new File(fileName));
        int increaseCount = 0;

        if (!scanner.hasNextInt()) {
            scanner.close();
            return 0;
        }

        int previousDepth = scanner.nextInt();

        while (scanner.hasNextInt()) {
            int currentDepth = scanner.nextInt();
            if (currentDepth > previousDepth) {
                increaseCount++;
            }
            previousDepth = currentDepth;
        }

        scanner.close();
        return increaseCount;
    }

    /** TODO 2
     *
     * Challenge 2
     *
     * @param fileName
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */
    public static int challengeTwo(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        int increaseCount = 0;

        if (!scanner.hasNextInt()) {
            scanner.close();
            return 0;
        }
        int first = scanner.nextInt();
        int second = scanner.hasNextInt() ? scanner.nextInt() : 0;
        int third = scanner.hasNextInt() ? scanner.nextInt() : 0;

        int previousSum = first + second + third;

        while (scanner.hasNextInt()) {
            int next = scanner.nextInt();
            int currentSum = second + third + next;

            if (currentSum > previousSum) {
                increaseCount++;
            }

            previousSum = currentSum;
            first = second;
            second = third;
            third = next;
        }

        scanner.close();
        return increaseCount;
    }

    /** TODO 3
     *
     * Challenge 3
     *
     * @param fileName
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */
    public static int challengeThree(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        int horizontalPosition = 0;
        int depth = 0;

        while (scanner.hasNext()) {
            String direction = scanner.next();
            int value = scanner.nextInt();

            switch (direction) {
                case "forward":
                    horizontalPosition += value;
                    break;
                case "down":
                    depth += value;
                    break;
                case "up":
                    depth -= value;
                    break;
                default:
                    System.out.println("Unknown command: " + direction);
            }
        }

        scanner.close();
        return horizontalPosition * depth;
    }

    /** TODO 4
     *
     * Challenge 4
     *
     * @param filename
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename));
        int horizontalPosition = 0;
        int depth = 0;
        int aim = 0;

        while (scanner.hasNext()) {
            String direction = scanner.next();
            int value = scanner.nextInt();

            switch (direction) {
                case "forward":
                    horizontalPosition += value;
                    depth += aim * value;
                    break;
                case "down":
                    aim += value;
                    break;
                case "up":
                    aim -= value;
                    break;
                default:
                    System.out.println("Unknown command: " + direction);
            }
        }

        scanner.close();
        return horizontalPosition * depth;
    }

    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }

    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }
}
