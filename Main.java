package FactorGen;

public class Main {

    public static void main(String[] args) {
        //int x = 204830472;
        int x = 1122018;
        PrimeFactorGenerator gen = new PrimeFactorGenerator(x);
        long startTime = System.nanoTime();
        gen.getF(x);
        long endTime = System.nanoTime();
        System.out.println(gen.getOutput());
        System.out.println(endTime - startTime);
        gen.clearOutput();

        x = 1122018;
        long startTime2 = System.nanoTime();
        gen.getFactors(x);
        long endTime2 = System.nanoTime();
        System.out.println(gen.getOutput());
        System.out.println(endTime2 - startTime2);
    }


}


