import java.util.Arrays;

public class ConsecutiveElements
{
  public static void main(String[] args)
  {
    int[] inputArray = new int[args.length];
    try
    {
      for (int index = 0; index < args.length; index++)
        inputArray[index] = Integer.parseInt(args[index]);
    } catch (NumberFormatException e)
    {
      System.err.println("Arguments must be strictly numeric.");
      System.exit(1);
    }

    System.out.println("Input array: " + Arrays.toString(inputArray));
    System.out.println("Consecutive: " + Boolean.toString(isConsecutive(inputArray)));
  }

  public static boolean isConsecutive(int[] array)
  {
    
    for (int offset = 0; offset < array.length; offset++)
      System.out.println("At offset " + Integer.toString(offset) + ", the [min, max] of array " + Arrays.toString(array) + " is " +
	Arrays.toString(getMinMax(array, offset)));
    return false;
  }

  public static int[] getMinMax(int[] array)
  {
    int[] minmax = new int[] { array[0], array[0] };
    for (int index = 1; index < array.length; index++)
    {
      if (minmax[0] > array[index])
        minmax[0] = array[index];
      if (minmax[1] < array[index])
        minmax[1] = array[index];
    }
    return minmax;
  }

  public static int[] getMinMax(int[] array, int offset)
  {
    if (offset == 0)
      return getMinMax(array);
    int[] shorterArray = new int[array.length - offset];
    System.arraycopy(array, offset, shorterArray, 0, array.length - offset);
    return getMinMax(shorterArray);
  }
}
