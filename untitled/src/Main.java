import java.util.ArrayList;
import java.util.List;

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




        TextFile tf = new TextFile("src/TextFiles/PL1", "Polski");

        double[] input = tf.getInput();
        for(int i = 0; i < input.length; i++){
            System.out.println(input[i]);
        }

    }




    private static void getData(){
        listToTeach = new ArrayList<>();
        listToTest = new ArrayList<>();


    }
}
