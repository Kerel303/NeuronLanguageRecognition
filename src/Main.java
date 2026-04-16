import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<TextFile> listToTeach;
    static List<TextFile> listToTest;

    static NeuronLayer<TextFile> neuronLayer;

    static int iterationNumber = 20;

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
        System.out.println("Podaj tekst do sprawdzenia języka (Ctrl + D aby zakończyć wpisywanie): ");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            sb.append(line);
        }
        System.out.println("Sklasyfikowano jako: " + neuronLayer.classify(new TextFile(sb.toString())));

//        System.out.println("\nPrawdopodobieństwa: ");
//        Map<String, Double> map = neuronLayer.classifyAll(new TextFile(sb.toString()));
//
//        for (Map.Entry<String, Double> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//        }

        scanner.close();
    }


    static void testAccuracy(){
        double accuracy = neuronLayer.accuracy(listToTest) * 100;
        System.out.println("Celność warstwy perceptronów: " + accuracy + "%");
    }




    private static void getData(){
        listToTeach = new ArrayList<>();
        listToTest = new ArrayList<>();

        String[][] languages = {
                {"PL", "Polski"},
                {"EN", "Angielski"},
                {"DE", "Niemiecki"},
                {"FR", "Francuski"},
                {"ES", "Hiszpański"}
        };

        for (String[] lang : languages) {
            String prefix = lang[0];
            String name = lang[1];

            // teach: 1–4
            for (int i = 1; i <= 4; i++) {
                listToTeach.add(new TextFile("src/TextFiles/" + prefix + i + ".txt", name));
            }

            // test: 5–7
            for (int i = 5; i <= 7; i++) {
                listToTest.add(new TextFile("src/TextFiles/" + prefix + i + ".txt", name));
            }
        }

    }
}
