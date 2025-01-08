public class  Complex_Numbers {
    static  class ComplexNumber{
        private double a;
        private double b;

        public ComplexNumber(double a, double b){
            this.a=a;
            this.b=b;
        }


        public ComplexNumber(){
            this.a=0;
            this.b=0;
        }
        @Override
        public String toString() {
            String c="";
            if(a==0&&this.b!=0) c=b+"i";
            if(a==0&&b==0) c="0";
            if(a!=0&&b==0) c=a+"";
            if(a!=0&&b>0) c=a+"+"+b+"i";
            if(a!=0&&b<0) c=a+""+b+"i";
            return c;
        }


        public void add(ComplexNumber m){
            this.a+=m.a;
            this.b+=m.b;
        }


        public void substract(ComplexNumber m){
            this.a-=m.a;
            this.b-=m.b;
        }

        public void multiply(ComplexNumber m){
            double a1 = this.a;
            double a2 = m.a;
            double b1 = this.b;
            double b2 = m.b;

            this.a=a1*a2-b1*b2;
            this.b=a1*b2+a2*b1;
        }



        public void divide(ComplexNumber m){
            double a1 = this.a;
            double a2 = m.a;
            double b1 = this.b;
            double b2 = m.b;

            this.a=(a1*a2+b1*b2)/(Math.pow(a2, 2)+Math.pow(b2, 2));
            this.b=(a2*b1-a1*b2)/(Math.pow(a2, 2)+Math.pow(b2, 2));
        }


    }

    static  class Matrix extends ComplexNumber{
        private double[][] elements;

        public Matrix(int rows, int cols) {
            elements = new double[rows][cols];
        }

        public Matrix(double[][] a){
            elements = a;
        }



        public void setElement(int row, int col, double value) {
            elements[row][col] = value;
        }

        public double getElement(int row, int col) {
            return elements[row][col];
        }

        @Override
        public String toString() {
            String result = "";
            for (double[] row : elements) {
                for (double val : row) {
                    result += val + " ";
                }
                result += "\n";
            }
            return result;
        }


        public void add(Matrix m) {
            if (this.elements.length != m.elements.length || this.elements[0].length != m.elements[0].length) {
                System.out.println("无法计算：矩阵维度不匹配。");
                return;
            }
            int rows = elements.length;
            int cols = elements[0].length;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    this.elements[i][j] += m.getElement(i, j);
                }
            }
        }


        public void subtract(Matrix m) {
            if (this.elements.length != m.elements.length || this.elements[0].length != m.elements[0].length) {
                System.out.println("无法计算：矩阵维度不匹配。");
                return;
            }
            int rows = elements.length;
            int cols = elements[0].length;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    this.elements[i][j] -= m.getElement(i, j);
                }
            }
        }


        public void multiply(Matrix m) {
            if (this.elements[0].length != m.elements.length) {
                System.out.println("无法计算：矩阵维度不匹配。");
                return;
            }
            int rows = elements.length;
            int cols = m.elements[0].length;
            int commonDim = elements[0].length;
            double[][] result = new double[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    double sum = 0;
                    for (int k = 0; k < commonDim; k++) {
                        sum += this.elements[i][k] * m.getElement(k, j);
                    }
                    result[i][j] = sum;
                }
            }
            this.elements = result;
        }



    }



    public static void main(String[] args) {
        ComplexNumber c = new ComplexNumber();
        ComplexNumber d = new ComplexNumber(1, 0);
        ComplexNumber e = new ComplexNumber(0, 1);
        c.add(d);
        System.out.println(c); // this should print 1.0
        System.out.println(d); // this should print 1.0
        System.out.println(e); // this should print 1.0i
        ComplexNumber f = new ComplexNumber(0, -1);
        System.out.println(f); // this should print -1.0i
        ComplexNumber g = new ComplexNumber(2.3, 1);
        System.out.println(g); // this should print 2.3+1.0i
        ComplexNumber h = new ComplexNumber(2, -1);
        System.out.println(h); // this should print 2.0-1.0i
        ComplexNumber i = new ComplexNumber(-5, -10);
        System.out.println(i); // this should print -5.0-10.0i




        Matrix matrix1 = new Matrix(2, 2);
        matrix1.setElement(0, 0, 1.0);
        matrix1.setElement(0, 1, 2.0);
        matrix1.setElement(1, 0, 3.0);
        matrix1.setElement(1, 1, 4.0);
        System.out.println("Matrix 1:");
        System.out.println(matrix1);

        Matrix matrix2 = new Matrix(2, 2);
        matrix2.setElement(0, 0, 5.0);
        matrix2.setElement(0, 1, 6.0);
        matrix2.setElement(1, 0, 7.0);
        matrix2.setElement(1, 1, 8.0);
        System.out.println("Matrix 2:");
        System.out.println(matrix2);

        matrix1.add(matrix2);
        System.out.println("Matrix 1 + Matrix 2:");
        System.out.println(matrix1);

        
        Matrix matrix5 = new Matrix(new double[][]{
            {1.0, 2.0},
            {3.0, 4.0}
        });

        Matrix matrix6 = new Matrix(new double[][]{
            {1.0, 1.0},
            {5.0, 3.0}
        });
        matrix5.subtract(matrix6);
        System.out.println("Matrix 5 - Matrix 6:");
        System.out.println(matrix5);

        matrix5.multiply(matrix6);
        System.out.println("Matrix 5 * Matrix 6:");
        System.out.println(matrix5);


        Matrix matrix3 = new Matrix(new double[][]{
            {1.0, 2.0},
            {3.0, 4.0},
            {5.0, 6.0}
        });
        System.out.println("Matrix 3:");
        System.out.println(matrix3);

        Matrix matrix4 = new Matrix(new double[][]{
            {7.0, 8.0, 9.0, 10.0, 11.0},
            {12.0, 13.0, 14.0, 15.0, 16.0}
        });
        System.out.println("Matrix 4:");
        System.out.println(matrix4);

        matrix3.multiply(matrix4);
        System.out.println("Matrix 3 * Matrix 4:");
        System.out.println(matrix3);


    }
		
 }
    

