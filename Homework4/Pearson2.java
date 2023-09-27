import java.util.Arrays;
import java.util.stream.Collectors;

public class Pearson2 {public static double Pearson(int[] arrayX, int[] arrayY) {
    double xMean = Arrays.stream(arrayX).asDoubleStream().average().getAsDouble();
    double yMean = Arrays.stream(arrayY).asDoubleStream().average().getAsDouble();

    double[] X = Arrays.stream(arrayX).mapToDouble(a -> a - xMean).toArray();
    double[] Y = Arrays.stream(arrayY).mapToDouble(a -> a - yMean).toArray();
    double[] X2 = Arrays.stream(arrayX).mapToDouble(a -> Math.pow((a - xMean),2)).toArray();
    double[] Y2 = Arrays.stream(arrayY).mapToDouble(a -> Math.pow((a - yMean),2)).toArray();

    double[] numArray = Arrays.stream(X).map(i -> i * Y[Arrays.stream(X).boxed().collect(Collectors.toList()).indexOf(i)]).toArray();

    double denomArrayX = Math.pow(Arrays.stream(X2).sum(), 0.5);
    double denomArrayY = Math.pow(Arrays.stream(Y2).sum(), 0.5);

    //double[] Z2 = Arrays.stream(X2).map(i -> i * Y2[Arrays.stream(X2).boxed().collect(Collectors.toList()).indexOf(i)]).toArray();

    double numerator = Arrays.stream(numArray).sum();
    double denominator = denomArrayX * denomArrayY;
    return numerator/denominator;
}
    public static void main(String[] args) {
        int[] arrayA = new int[] {1, 2, 3};
        int[] arrayB = new int[] {1, 2, 3};
        System.out.println(Pearson(arrayA, arrayB));

    }
    }
}
