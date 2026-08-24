import java.io.*; 
import java.util.ArrayList;
 
public class GradeAnalyzer {
    public static int invalidLines = 0;
    public static int countA=0, countB=0, countC=0, countD=0, countF=0;
    public static void main(String[] args) {
        //ArrayList<Integer> goodScores = readScores("emptyscores.txt");  
                //Passed with all 0 scores, but had to fix lowest/highest score condition

        ArrayList<Integer> goodScores = readScores("scores.txt");
        ArrayList<Integer> testList = new ArrayList<>();
            testList.add(100);
            testList.add(100); 
            testList.add(99);
            //Total should be 299, avg of 99.666        (Confirmed in debug)
        double testAverage = calculateAverage(testList);

        double avgReturned = calculateAverage(goodScores);

        //Step 5 & 6 
        //min and max score search
        //Also including Grade band search
        int highestScore = 0, lowestScore = 100;        //assuming grade scores must be between 0-100
        //int countA=0, countB=0, countC=0, countD=0, countF=0;
        if (goodScores.size() > 0)
        {
        for (int i=0; i < goodScores.size(); i++)
        {
            if (goodScores.get(i) > highestScore)
                highestScore = goodScores.get(i);
            if (goodScores.get(i) < lowestScore)
                lowestScore = goodScores.get(i);

            if(goodScores.get(i) >= 90)
                countA ++;
            else if(goodScores.get(i) >= 80)
                countB ++;
            else if(goodScores.get(i) >= 70)
                countC ++;
            else if(goodScores.get(i) >= 60)
                countD ++;
            else if(goodScores.get(i) < 60)
                countF ++;
        }
    }
    else
    {
        System.out.println("Scores List was Empty - check file");
        highestScore = 0;
        lowestScore = 0;
    }

        writeReport(goodScores, avgReturned, highestScore, lowestScore, "report.txt");
        // Step 1: read scores from file
        // Step 2: calculate statistics
        // Step 3: write and print report
    } 
 
    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) 
    {
        ArrayList<Integer> goodScores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) 
        {
            String line;
            int lineValue;
            while ((line = reader.readLine()) != null)
            {
                line = line.trim();
                if (line.isBlank() || line.isEmpty())
                    continue;
                try 
                {
                    lineValue = Integer.parseInt(line);
                }
                catch (NumberFormatException e) 
                {   
                    System.out.println("Could not read number, exception Number Format");  
                    invalidLines ++;
                    continue;    
                }
                System.out.println(line);
                goodScores.add(lineValue);
            }
        } 
        catch (IOException e) 
        {   System.out.println("Could not read file: " + e.getMessage());               }
        
        return goodScores;
    }
 
    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        if (scores.size() ==0 )
            return 0.0;
        else 
        {
            double totalScores = 0.0;
            for (int i=0; i < scores.size(); i++)
                totalScores = totalScores + scores.get(i);

            return totalScores / scores.size();
        }
    } 
 
    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores,
                                   double avg, int high, int low,
                                   String outputFile)
    {
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            writer.write("=== Grade Analysis Report ===");
            writer.newLine();
            writer.write(String.format("Total scores processed:  %d%n", scores.size()));
            writer.write(String.format("Invalid lines skipped:   %d%n%n", invalidLines));
            writer.write(String.format("Average score:   %.2f%n", avg));
            writer.write(String.format("Highest score:   %d%n", high));
            writer.write(String.format("Lowest score:     %d%n%n",low));
            writer.write("Grade distribution:");
            writer.newLine();
            writer.write(String.format("   A (90-100): \t%d%n",countA ));
            writer.write(String.format("   B (80-89): \t%d%n",countB));
            writer.write(String.format("   C (70-79): \t%d%n",countC));
            writer.write(String.format("   D (60-69): \t%d%n",countD));
            writer.write(String.format("   F (below 60): %d%n",countF));
            writer.flush();
            writer.close();

            BufferedReader reader = new BufferedReader(new FileReader(outputFile));
            String line;
            while ((line = reader.readLine()) != null)
                System.out.println(line);
        }
        catch(IOException ex)
        {
            System.out.println("Caught Exception with IO:" + ex.getMessage());
        }
        // your code here
    }
} 