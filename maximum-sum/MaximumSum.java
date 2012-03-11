import java.util.Arrays;

public class MaximumSum
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
      System.err.println("Arguments should be only integer values.");
      System.exit(1);
    }
    System.out.println("Input array: " + Arrays.toString(inputArray));
    int[] maxSum = getMaximumSum(inputArray);
    System.out.println("Maximum sum: " +
	Integer.toString(maxSum[0] + maxSum[1]) +
	" " +
	Arrays.toString(maxSum));
  }

  public static int[] getMaximumSum(int[] inputArray)
  {
    int[] maxSum = new int[2];
    int currentSum = 0;
    for (int currentIndex = 0; currentIndex < inputArray.length; currentIndex++)
      for (int searchIndex = 0; searchIndex < inputArray.length; searchIndex++)
      {
        if (searchIndex == currentIndex - 1 || searchIndex == currentIndex + 1 || searchIndex == currentIndex)
	  continue;
        if (inputArray[currentIndex] + inputArray[searchIndex] > currentSum)
        {
          maxSum[0] = inputArray[currentIndex];
          maxSum[1] = inputArray[searchIndex];
          currentSum = maxSum[0] + maxSum[1];
        }
      }
    return maxSum;
  }
}
