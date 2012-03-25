import java.util.ArrayList;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Gender
{
  public static void main(String[] args)
  {
    Random rand = new Random();
    ArrayList<Entry> entries = new ArrayList<Entry>();
    try
    { 
      BufferedReader file = new BufferedReader(new FileReader("words.txt"));
      String fileEntry = file.readLine();
      while (fileEntry != null)
      {
        entries.add(new Entry(fileEntry.substring(0, fileEntry.indexOf("|")),
          fileEntry.charAt(fileEntry.indexOf("|") + 1)));
        fileEntry = file.readLine();
      }
      file.close();
    } catch (IOException e)
    {
      System.err.println("Could not read words.txt. Aborting.");
      System.exit(1);
    }

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int currentIndex;
    char inputGender = 'a';
    while (true)
    {
      try
      {
        input.mark(2);
      } catch (IOException e)
      {
        System.err.println("Bullocks");
        System.exit(3);
      }
      currentIndex = rand.nextInt(entries.size());
      System.out.println("What is the gender of '\u001B[33m" + entries.get(currentIndex).getWord() + "\u001B[0m'?");
      try
      {
        inputGender = (char)input.read();
      } catch (IOException e)
      {
        System.err.println("Error reading from the console. Aborting program.");
        System.exit(2);
      }
      if (inputGender == entries.get(currentIndex).getGender())
      {
        System.out.println("\u001B[32mCorrect!\u001B[0m");
      } else
      {
        System.out.print("\u001B[31mIncorrect! It is actually '");
        if (entries.get(currentIndex).getGender() == 'n')
          System.out.print("\u001B[33mdas");
        else if (entries.get(currentIndex).getGender() == 'm')
          System.out.print("\u001B[33mder");
        else
          System.out.print("\u001B[33mdie");
        System.out.println("\u001B[33m " + entries.get(currentIndex).getWord() + "\u001B[0m'.");
      }
      System.out.println("");
      try
      {
        input.skip(1);
      } catch (IOException e)
      {
        System.err.println("Darn it.");
        System.exit(4);
      }
    }
  }
}
