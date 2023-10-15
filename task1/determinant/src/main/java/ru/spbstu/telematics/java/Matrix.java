package ru.spbstu.telematics.java;


import org.apache.commons.math3.linear.*;

public class Matrix{
    private double[][] matrix; // Field with matrix
    

    public Matrix(double[][] data){
        // Constructor
        int rows = data.length;
        int cols = data[0].length;

        // Check for correct matrix sizes
        for(int i = 1;i < rows;i++){
            if(data[i].length != cols){
                throw new IllegalArgumentException("Matrix sizes incorrect. Rows must to be simmiliar sizes.");
            }
        }
        
        this.matrix = data;
    }

    private double calcDeterminant(double[][] matrix){
        int n = matrix.length;
        
        // For matrix N=1,2,3 we know formula
        if(n == 1){
            return matrix[0][0];
        }
        if(n == 2){
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }
        if(n == 3){
            return 
                (matrix[0][0] * matrix[1][1] * matrix[2][2] +
                matrix[0][1] * matrix[1][2] * matrix[2][0] +
                matrix[1][0] * matrix[2][1] * matrix[0][2]) -
                (matrix[2][0] * matrix[1][1] * matrix[0][2]) -
                (matrix[0][1] * matrix[1][0] * matrix[2][2]) -
                (matrix[0][0] * matrix[2][1] * matrix[1][2])
                ;
        }

        double det = 0;
        
        for(int i = 0;i < n;i++){
            double[][] submatrix = new double[n-1][n-1];
            for (int j = 1; j < n; j++){
                for (int k = 0; k < n; k++) {
                    if (k < i) {
                        submatrix[j-1][k] = matrix[j][k];
                    } else if (k > i) {
                        submatrix[j - 1][k - 1] = matrix[j][k];
                    }
                }
            }
            det += matrix[0][i] * Math.pow(-1, i) * calcDeterminant(submatrix);
        }
    
        return det;
    }

    public double determinant(){
        if (this.matrix.length != this.matrix[0].length){
            throw new IllegalArgumentException("Matrix must be square NxN");
        }

        return calcDeterminant(this.matrix);
    }

    public double apacheDeterminant(){
        RealMatrix realMatrix = MatrixUtils.createRealMatrix(matrix);
        LUDecomposition luDecomposition = new LUDecomposition(realMatrix);
        return luDecomposition.getDeterminant();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder("");

        for (int i = 0; i < matrix.length; i++) {
            StringBuilder row = new StringBuilder("");
            for (int j = 0; j < matrix[i].length; j++) {
                row.append(matrix[i][j]).append(" ");
            }
            res.append(row).append("\n");
        }

        return res.toString();
    }
}