public class Entry
{
  private String _word;
  private char _gender;

  public Entry(String word, char gender)
  {
    _word = word;
    _gender = gender;
  }

  public String getWord() { return _word; }
  public char getGender() { return _gender; }
}
