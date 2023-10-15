package ru.spbstu.telematics.java;

import static org.junit.Assert.assertEquals;
import org.junit.Test;



/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void testDeterminantOne(){
        double data[][] = {{1,2},{3,4}};
        Matrix matrix = new Matrix(data);

        double determinant = matrix.determinant();

        assertEquals(matrix.apacheDeterminant(), determinant, 0.0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMatrixIncorrectSize(){
        double data[][] = {{1,2,3},{4,5}};

        new Matrix(data);
    }

    @Test(expected =  IllegalArgumentException.class)
    public void testDeterminantNotSquareMatrix(){
        double data[][] = {{1,2,3},{4,5,6}};

        Matrix matrix = new Matrix(data);

        matrix.determinant();
    }

    @Test
    public void testBigMatrixDeterminant(){

        final int MAX_DIM_MATRIX = 9;

        for (int i = 1; i <= MAX_DIM_MATRIX; i++) {
            Matrix m = generateRandomMatrix(i);
            assertEquals(m.determinant(), m.apacheDeterminant(), 0.0001);
        }
    }


    private Matrix generateRandomMatrix(int size){
        double[][] data = new double[size][size]; // create data

        java.util.Random random = new java.util.Random();

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                data[i][j] = random.nextDouble() * 10.0;
            }
        }


        return new Matrix(data);
    }
}
