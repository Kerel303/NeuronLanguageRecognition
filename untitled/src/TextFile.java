import Interfaces.Trainable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TextFile implements Trainable {

    List<String> lines =  new ArrayList<>();
    String label;
    double[] TabOfLetters = new double[26];

    TextFile(String filename, String label) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            while( (line = br.readLine()) != null ) {
                String buffer = line.toLowerCase().replaceAll("[^a-z]", "");
                if(!buffer.isEmpty()) {
                    lines.add(buffer);
                    System.out.println(buffer);

                    // Liczenie liter w aktualnej linii
                    for (int i = 0; i < buffer.length(); i++) {
                        char c = buffer.charAt(i);
                        // 'a' ma kod ASCII 97, więc odejmując 'a' od znaku,
                        // otrzymujemy indeks 0 dla 'a', 1 dla 'b' itd. :D
                        TabOfLetters[c - 'a']++;
                    }
                }
            }
            this.label = label;
        }catch(Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public double[] getInput() {
        return TabOfLetters;
    }

    @Override
    public String getLabel() {
        return label;
    }
}
