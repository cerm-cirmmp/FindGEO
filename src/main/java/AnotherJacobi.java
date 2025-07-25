public class AnotherJacobi {

    private final double EPSILON = 10e-30;

    public class EigenResult {
        double[] eigenvalues;
        double[][] eigenvectors;

        public EigenResult(double[] eigenvalues, double[][] eigenvectors) {
            this.eigenvalues = eigenvalues;
            this.eigenvectors = eigenvectors;
        }

        public double[] getEigenvalues() {
            return eigenvalues;
        }

        public double[][] getEigenvectors() {
            return eigenvectors;
        }
    }

    public EigenResult jacobiEigenvalueDecomposition(double[][] a, int n) {
        double[] d = new double[n];
        double[][] v = new double[n][n];
        int[] nrot = new int[1];
        double[] b = new double[n];
        double[] z = new double[n];
        // Initialize v as an identity matrix
        for (int i = 0; i < n; i++) {
            v[i][i] = 1.0;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    v[i][j] = 0.0;
                }
            }
        }

        // Initialize d as the diagonal of matrix a
        for (int i = 0; i < n; i++) {
            d[i] = a[i][i];
            b[i] = d[i];
            z[i] = 0.0;
        }

        int maxIter = 50; // Maximum number of iterations
        int iter = 0;

        while (iter < maxIter) {
            double sm = 0.0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    sm += Math.abs(a[i][j]);
                }
            }

            if (sm < EPSILON) {
                break; // Convergence achieved
            }

            double tresh = (iter < 3) ? 0.2 * sm / (n * n) : 0.0;

            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    double g = 100.0 * Math.abs(a[i][j]);

                    if (iter > 3 && Math.abs(d[i]) + g == Math.abs(d[i])
                            && Math.abs(d[j]) + g == Math.abs(d[j])) {
                        a[i][j] = 0.0;
                    } else if (Math.abs(a[i][j]) > tresh) {
                        double h = d[j] - d[i];
                        double t;
                        if (Math.abs(h) + g == Math.abs(h)) {
                            t = a[i][j] / h;
                        } else {
                            double theta = 0.5 * h / a[i][j];
                            t = 1.0 / (Math.abs(theta) + Math.sqrt(1.0 + theta * theta));
                            if (theta < 0.0) {
                                t = -t;
                            }
                        }
                        double c = 1.0 / Math.sqrt(1.0 + t * t);
                        double s = t * c;
                        double tau = s / (1.0 + c);
                        h = t * a[i][j];
                        z[i] -= h;
                        z[j] += h;
                        d[i] -= h;
                        d[j] += h;
                        a[i][j] = 0.0;
                        for (int k = 0; k < i; k++) {
                            // Rotations on left
                            g = a[k][i];
                            h = a[k][j];
                            a[k][i] = g - s * (h + g * tau);
                            a[k][j] = h + s * (g - h * tau);
                        }
                        for (int k = i + 1; k < j; k++) {
                            // Rotations in the middle
                            g = a[i][k];
                            h = a[k][j];
                            a[i][k] = g - s * (h + g * tau);
                            a[k][j] = h + s * (g - h * tau);
                        }
                        for (int k = j + 1; k < n; k++) {
                            // Rotations on the right
                            g = a[i][k];
                            h = a[j][k];
                            a[i][k] = g - s * (h + g * tau);
                            a[j][k] = h + s * (g - h * tau);
                        }
                        for (int k = 0; k < n; k++) {
                            // Update transformation matrix
                            g = v[k][i];
                            h = v[k][j];
                            v[k][i] = g - s * (h + g * tau);
                            v[k][j] = h + s * (g - h * tau);
                        }
                        nrot[0]++;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                // Update d with the sum of Z[i]
                b[i] += z[i];
                d[i] = b[i];
                z[i] = 0.0;
            }

            iter++;
        }

       /* // Sort eigenvalues and corresponding eigenvectors
        for (int i = 0; i < n - 1; i++) {
            int k = i;
            double p = d[i];
            for (int j = i + 1; j < n; j++) {
                if (d[j] > p) {
                    k = j;
                    p = d[j];
                }
            }
            if (k != i) {
                d[k] = d[i];
                d[i] = p;
                for (int j = 0; j < n; j++) {
                    double tmp = v[j][i];
                    v[j][i] = v[j][k];
                    v[j][k] = tmp;
                }
            }
        }*/
        // Sort eigenvalues and corresponding eigenvectors in descending order
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (d[j] > d[maxIndex]) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                // Swap eigenvalues
                double temp = d[i];
                d[i] = d[maxIndex];
                d[maxIndex] = temp;

                // Swap corresponding eigenvectors
                for (int k = 0; k < n; k++) {
                    double tempVec = v[k][i];
                    v[k][i] = v[k][maxIndex];
                    v[k][maxIndex] = tempVec;
                }
            }
        }

        return new EigenResult(d, v);
    }

      /*  public static void main(String[] args) {
            int n = 4; // Size of the matrix
            double[][] a = {
                    {4.0, 1.0, 2.0, 3.0},
                    {1.0, 3.0, 1.0, 2.0},
                    {2.0, 1.0, 5.0, .0},
                    {2.0, 1.0, 5.0, .0}
            };
            double[] d = new double[n];
            double[][] v = new double[n][n];
            int[] nrot = new int[1];

            jacobiEigenvalueDecomposition(a, n, d, v, nrot);

            // Output eigenvalues
            System.out.println("Eigenvalues:");
            for (int i = 0; i < n; i++) {
                System.out.println("lambda[" + i + "] = " + d[i]);
            }

            // Output eigenvectors
            System.out.println("Eigenvectors:");
            for (int i = 0; i < n; i++) {
                System.out.print("v[" + i + "] = [");
                for (int j = 0; j < n; j++) {
                    System.out.print(v[j][i]);
                    if (j < n - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println("]");
            }

            System.out.println("Number of Jacobi rotations: " + nrot[0]);
        }*/
}


