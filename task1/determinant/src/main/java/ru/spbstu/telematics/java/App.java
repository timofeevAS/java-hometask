package ru.spbstu.telematics.java;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        double[][] matrixData = {
            {1.0,3.0,4.0,-5.0},
            {-1.0,2.0,22.0,2.0},
            {32.0,2.0,21.0,1.0},
            {1321.0,1231.0,2314.0,1321.0},
        };

        Matrix matrix = new Matrix(matrixData);
        double determinant = matrix.determinant();
        double apacheDeterminant = Math.ceil(matrix.apacheDeterminant());

        System.out.println("Matrix:\n" + matrix.toString());
        System.out.println(new StringBuilder().append("Determinant: ").append(determinant));
        System.out.println(new StringBuilder().append("Determinant: ").append(apacheDeterminant));
    }
}
