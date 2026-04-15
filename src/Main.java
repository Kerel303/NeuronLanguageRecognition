import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<TextFile> listToTeach;
    static List<TextFile> listToTest;

    static NeuronLayer<TextFile> neuronLayer;

    static int iterationNumber = 100;

    public static void main(String[] args) {
        getData();

        List<String> classes = List.of(
                "Polski",
                "Angielski",
                "Niemiecki",
                "Francuski",
                "Hiszpański"
        );// Języki które mogą wystąpić

        neuronLayer = new NeuronLayer<>(classes, 26);// 26 liter od a do z

        neuronLayer.train(listToTeach, iterationNumber);

        testAccuracy();

        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();
        System.out.println("Podaj tekst do sprawdzenia języka: "); // Ctrl + D aby zakończyć wpisywanie
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            sb.append(line);
        }
        System.out.println("Sklasyfikowano jako: " + neuronLayer.classify(new TextFile(sb.toString())));

        scanner.close();
    }


    static void testAccuracy(){
        double accuracy = neuronLayer.accuracy(listToTest) * 100;
        System.out.println("Celność warstwy perceptronów: " + accuracy + "%");
    }




    private static void getData(){
        listToTeach = new ArrayList<>();
        listToTest = new ArrayList<>();

        listToTeach.add(new TextFile("src/TextFiles/PL1.txt", "Polski"));
        listToTeach.add(new TextFile("src/TextFiles/PL2.txt", "Polski"));
        listToTeach.add(new TextFile("src/TextFiles/PL3.txt", "Polski"));
        listToTeach.add(new TextFile("src/TextFiles/PL4.txt", "Polski"));
        listToTest.add(new TextFile("src/TextFiles/PL5.txt", "Polski"));
        listToTest.add(new TextFile("src/TextFiles/PL6.txt", "Polski"));
        listToTest.add(new TextFile("src/TextFiles/PL7.txt", "Polski"));
        listToTeach.add(new TextFile("src/TextFiles/EN1.txt", "Angielski"));
        listToTeach.add(new TextFile("src/TextFiles/EN2.txt", "Angielski"));
        listToTeach.add(new TextFile("src/TextFiles/EN3.txt", "Angielski"));
        listToTeach.add(new TextFile("src/TextFiles/EN4.txt", "Angielski"));
        listToTest.add(new TextFile("src/TextFiles/EN5.txt", "Angielski"));
        listToTest.add(new TextFile("src/TextFiles/EN6.txt", "Angielski"));
        listToTest.add(new TextFile("src/TextFiles/EN7.txt", "Angielski"));
        listToTeach.add(new TextFile("src/TextFiles/DE1.txt", "Niemiecki"));
        listToTeach.add(new TextFile("src/TextFiles/DE2.txt", "Niemiecki"));
        listToTeach.add(new TextFile("src/TextFiles/DE3.txt", "Niemiecki"));
        listToTeach.add(new TextFile("src/TextFiles/DE4.txt", "Niemiecki"));
        listToTest.add(new TextFile("src/TextFiles/DE5.txt", "Niemiecki"));
        listToTest.add(new TextFile("src/TextFiles/DE6.txt", "Niemiecki"));
        listToTest.add(new TextFile("src/TextFiles/DE7.txt", "Niemiecki"));
        listToTeach.add(new TextFile("src/TextFiles/FR1.txt", "Francuski"));
        listToTeach.add(new TextFile("src/TextFiles/FR2.txt", "Francuski"));
        listToTeach.add(new TextFile("src/TextFiles/FR3.txt", "Francuski"));
        listToTeach.add(new TextFile("src/TextFiles/FR4.txt", "Francuski"));
        listToTest.add(new TextFile("src/TextFiles/FR5.txt", "Francuski"));
        listToTest.add(new TextFile("src/TextFiles/FR6.txt", "Francuski"));
        listToTest.add(new TextFile("src/TextFiles/FR7.txt", "Francuski"));
        listToTeach.add(new TextFile("src/TextFiles/ES1.txt", "Hiszpański"));
        listToTeach.add(new TextFile("src/TextFiles/ES2.txt", "Hiszpański"));
        listToTeach.add(new TextFile("src/TextFiles/ES3.txt", "Hiszpański"));
        listToTeach.add(new TextFile("src/TextFiles/ES4.txt", "Hiszpański"));
        listToTest.add(new TextFile("src/TextFiles/ES5.txt", "Hiszpański"));
        listToTest.add(new TextFile("src/TextFiles/ES6.txt", "Hiszpański"));
        listToTest.add(new TextFile("src/TextFiles/ES7.txt", "Hiszpański"));

    }
}
