import java.util.Arrays;

public class NMJacobi {
    private int N;  // Dimension of the matrix
    private double[][] a;  // The symmetric matrix
    private double[] eigenvalues;  // Array to store eigenvalues
    private double[][] eigenvectors;  // Array to store eigenvectors

    public NMJacobi(double[][] matrix) {
        N = matrix.length;
        a = new double[N][N];
        eigenvalues = new double[N];
        eigenvectors = new double[N][N];

        // Copy the input matrix to the 'a' matrix
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                a[i][j] = matrix[i][j];
            }
        }
    }

    // Helper method to perform the Jacobi rotation
    private void jacobiRotate(int p, int q) {
        double d = (a[q][q] - a[p][p]) / (2.0 * a[p][q]);
        double t = (d >= 0) ? 1.0 / (d + Math.sqrt(1.0 + d * d)) : -1.0 / (-d + Math.sqrt(1.0 + d * d));
        double c = 1.0 / Math.sqrt(1.0 + t * t);
        double s = c * t;

        // Update the matrix 'a'
        double apq = a[p][q];
        double app = a[p][p];
        double aqq = a[q][q];
        a[p][p] = app * c * c + aqq * s * s - 2.0 * apq * c * s;
        a[q][q] = app * s * s + aqq * c * c + 2.0 * apq * c * s;
        a[p][q] = 0.0;
        a[q][p] = 0.0;

        for (int i = 0; i < N; i++) {
            if (i != p && i != q) {
                double aip = a[i][p];
                double aiq = a[i][q];
                a[i][p] = aip * c - aiq * s;
                a[p][i] = a[i][p];
                a[i][q] = aiq * c + aip * s;
                a[q][i] = a[i][q];
            }
        }
    }

    // Helper method to find the maximum off-diagonal element
    private double maxOffDiagonal() {
        double max = 0.0;
        int p = 0;
        int q = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (Math.abs(a[i][j]) > max) {
                    max = Math.abs(a[i][j]);
                    p = i;
                    q = j;
                }
            }
        }

        return max;
    }

    // Perform Jacobi eigenvalue decomposition
    public void jacobiEigenvalueDecomposition() {
        double tolerance = 10e-30;  // Tolerance for convergence
        int maxIterations = 50;  // Maximum number of iterations

        for (int iter = 0; iter < maxIterations; iter++) {
            double maxOffDiag = maxOffDiagonal();
            if (maxOffDiag < tolerance) {
                break;  // Converged
            }

            for (int p = 0; p < N; p++) {
                for (int q = p + 1; q < N; q++) {
                    jacobiRotate(p, q);
                }
            }
        }

        // Extract eigenvalues and eigenvectors from the 'a' matrix
        for (int i = 0; i < N; i++) {
            eigenvalues[i] = a[i][i];
            for (int j = 0; j < N; j++) {
                eigenvectors[i][j] = (i == j) ? 1.0 : 0.0;
            }
        }
    }

    // Getter methods for eigenvalues and eigenvectors
    public double[] getEigenvalues() {
        return eigenvalues;
    }

    public double[][] getEigenvectors() {
        return eigenvectors;
    }

    public void sortEigenvaluesAndEigenvectors() {
        for (int i = 1; i < N; i++) {
            double currentEigenvalue = eigenvalues[i];
            double[] currentEigenvector = Arrays.copyOf(eigenvectors[i], N);
            int j = i - 1;

            // Move elements of eigenvalues and eigenvectors[ ] that are greater than currentEigenvalue
            while (j >= 0 && eigenvalues[j] < currentEigenvalue) {
                eigenvalues[j + 1] = eigenvalues[j];
                eigenvectors[j + 1] = Arrays.copyOf(eigenvectors[j], N);
                j--;
            }

            eigenvalues[j + 1] = currentEigenvalue;
            eigenvectors[j + 1] = currentEigenvector;
        }
    }
}
