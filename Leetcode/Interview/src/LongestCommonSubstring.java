import java.util.ArrayList;

/**
 * Created by shoulongli on 5/14/16.
 */
public class LongestCommonSubstring {

    public static void main(String[] argv)
    {
        String a = "ABAB";
        String b = "BABAA";
        LongestCommonSubstring test = new LongestCommonSubstring();
        int[][] matrix = test.getLCSuffix(a,b);
        test.printMatrix(matrix);

        int[][] matrix1 = test.getLCPrefix(a,b);
        test.printMatrix(matrix1);
        System.out.println(test.getLCSubstr(a, b));
        System.out.println(test.getLCSubstrII(a, b));
    }
    public void printMatrix(int[][] matrix)
    {

        for(int i = 0; i < matrix.length ;i++)
        {
            System.out.println();
            for(int j = 0; j < matrix[0].length; j++)
            {
                System.out.print(matrix[i][j] + ", ");
            }
        }
    }
    public int[][] getLCSuffix(String a, String b)
    {
        int m = a.length();
        int n = b.length();
        int[][] matrix = new int[m][n];

        for(int i = 0;i< m; i++)
        {
            for(int j = 0;j<n;j++)
            {
                if(a.charAt(i) == b.charAt(j))
                {
                    if(i == 0 || j == 0)
                    {
                        matrix[i][j] = 1;
                    }
                    else
                    {
                        matrix[i][j] = matrix[i-1][j-1] + 1;
                    }
                }
                else
                {
                    matrix[i][j] = 0;
                }
            }
        }
        return matrix;
    }
    public int[][] getLCPrefix(String a, String b)
    {
        int m = a.length();
        int n = b.length();
        int[][] matrix = new int[m][n];

        for(int i = m-1; i>=0;i--)
        {
            for(int j =n-1;j>=0;j--)
            {
                if(a.charAt(i) == b.charAt(j))
                {
                    if(i == m-1 || j == n-1)
                        matrix[i][j] = 1;
                    else
                        matrix[i][j] = matrix[i+1][j+1] + 1;
                }
                else
                {
                    matrix[i][j] = 0;
                }
            }
        }



        return matrix;
    }
    public ArrayList<String> getLCSubstr(String a, String b)
    {
        int m = a.length();
        int n = b.length();
        int[][] matrix = new int[m][n];

        int max = 0;
        ArrayList<String> result = new ArrayList<String>();
        for(int i = 0;i< m; i++)
        {
            for(int j = 0;j<n;j++)
            {
                if(a.charAt(i) == b.charAt(j))
                {
                    if(i == 0 || j == 0)
                    {
                        matrix[i][j] = 1;
                    }
                    else
                    {
                        matrix[i][j] = matrix[i-1][j-1] + 1;
                    }
                    if(matrix[i][j] > max)
                    {
                        max = matrix[i][j];
                        result.clear();
                        result.add(a.substring(i+1-max,i+1));
                    }
                    else if(matrix[i][j] == max)
                    {
                        result.add(a.substring(i+1-max,i+1));
                    }
                }
                else
                {
                    matrix[i][j] = 0;
                }
            }
        }




        return result;
    }
    public ArrayList<String> getLCSubstrII(String a, String b)
    {
        int m = a.length();
        int n = b.length();
        int[][] matrix = new int[m][n];
        int max= 0;
        ArrayList<String> result = new ArrayList<String>();
        for(int i = m-1; i>=0;i--)
        {
            for(int j =n-1;j>=0;j--)
            {
                if(a.charAt(i) == b.charAt(j))
                {
                    if(i == m-1 || j == n-1)
                        matrix[i][j] = 1;
                    else
                        matrix[i][j] = matrix[i+1][j+1] + 1;

                    if(matrix[i][j] > max)
                    {
                        max = matrix[i][j];
                        result.clear();
                        result.add(a.substring(i,i+max));
                    }
                    else if(matrix[i][j] == max)
                    {
                        result.add(a.substring(i, i+max));
                    }

                }
                else
                {
                    matrix[i][j] = 0;
                }
            }
        }
        return result;
    }
}
