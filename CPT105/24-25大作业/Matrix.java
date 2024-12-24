public class Matrix {
    private int row;
    private int col;
    private double[][] matrix;


    public Matrix(double[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            throw new IllegalArgumentException("The matrix must have at least one number.");
        }
        this.row = matrix.length;
        this.col = matrix[0].length;
        this.matrix = new double[this.row][this.col];
    
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }
    }


    public Matrix add(Matrix other) {
        if (this.row != other.row || this.col != other.col) {
            throw new IllegalArgumentException("Matrix dimensions do not match.");
        }
        Matrix newMatrix = new Matrix(new double[this.row][this.col]); 
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                newMatrix.matrix[i][j] = this.matrix[i][j] + other.matrix[i][j];
            }
        }
        return newMatrix;
    }

    public Matrix subtract(Matrix other){
        if(this.row != other.row || this.col != other.col){
            throw new IllegalArgumentException("Matrix dimensions do not match.");
        }
        Matrix newMatrix = new Matrix(new double[this.row][this.col]); 
        for(int i = 0; i < this.row; i++){
            for(int j = 0; j < this.col; j++){
                newMatrix.matrix[i][j] = this.matrix[i][j] - other.matrix[i][j];
            }
        }
        return newMatrix;
    }


    public Matrix multiply(Matrix other) {
        if (this.col != other.row) {
            throw new IllegalArgumentException("Matrix dimensions do not match for multiplication.");
        }

        Matrix newMatrix = new Matrix(new double[this.row][other.col]); 

        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < other.col; j++) {
                double sum = 0;
                for (int k = 0; k < this.col; k++) {
                    sum += this.matrix[i][k] * other.matrix[k][j];
                }
                newMatrix.matrix[i][j] = sum;
            }
        }
        return newMatrix;
    }



    public Matrix transpose(){
        Matrix newMatrix = new Matrix(new double[this.col][this.row]);
        for(int i = 0; i < this.row; i++){
            for(int j = 0; j < this.col; j++){
                newMatrix.matrix[i][j] = this.matrix[j][i];
            }
        }
        return newMatrix;
    }

    public double determinant() {
        if (this.row != this.col) {
            throw new IllegalArgumentException("Matrix must be square to calculate the determinant.");
        }

        if (this.row == 2) {
            return this.matrix[0][0] * this.matrix[1][1] - this.matrix[0][1] * this.matrix[1][0];
        }

        if (this.row == 3) {
            return this.matrix[0][0] * (this.matrix[1][1] * this.matrix[2][2] - this.matrix[1][2] * this.matrix[2][1])
                    - this.matrix[0][1] * (this.matrix[1][0] * this.matrix[2][2] - this.matrix[1][2] * this.matrix[2][0])
                    + this.matrix[0][2] * (this.matrix[1][0] * this.matrix[2][1] - this.matrix[1][1] * this.matrix[2][0]);
        }

        if (this.row > 3) {
            return Double.NaN;
        }
        return 0;

    }

    public double[][] getData() {
        return this.matrix;
    }

    private static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        double[][] data1 = {{1, 2}, {3, 4}};
        double[][] data2 = {{5, 6}, {7, 8}};

        Matrix matrix1 = new Matrix(data1);
        Matrix matrix2 = new Matrix(data2);

        Matrix sum = matrix1.add(matrix2);
        Matrix difference = matrix1.subtract(matrix2);
        Matrix product = matrix1.multiply(matrix2);
        Matrix transpose = matrix1.transpose();
        double determinant = matrix1.determinant();

        // Print results
        System.out.println("Sum:");
        printMatrix(sum.getData());
        System.out.println("Difference:");
        printMatrix(difference.getData());
        System.out.println("Product:");
        printMatrix(product.getData());
        System.out.println("Transpose:");
        printMatrix(transpose.getData());
        System.out.println("Determinant:");
        System.out.println(determinant);
    }



}








