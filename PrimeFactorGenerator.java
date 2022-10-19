package FactorGen;
import java.util.ArrayList;

public class PrimeFactorGenerator {
    
    private int x;
    private boolean[] primes;
    private ArrayList<Integer> output;

    /**
     * Constructs new Prime Factor Generator
     * @param integer The integer to find factor of
     */
    public PrimeFactorGenerator(int integer) {
        x = integer;
        output = new ArrayList<Integer>();
        seiveOfE();
    }

    /**
     * Uses a seive of Eratosthenes to generate list of primes 
     */
    public void seiveOfE() {
        int j;
        primes = new boolean[x + 1];
        for (int i = 2; i*i <= x; i++) {
            if (!primes[i]) {
                j = i*i;
                while (j <= x) {
                    primes[j] = true;
                    j += i;
                }
            }
        }
    }

    /**
     * Finds the next prime number
     * @param last The last prime number
     * @return The next prime number
     */
    public int nextPrime(int last) {
        int next = 1;
        for (int i = last + 1; i <= x; i++) {
            if (!primes[i]) {
                next = i;
                break;
            }
        }
        return next;
    }

    /**
     * Gets prime factors using iteration
     * @param num the integer to find prime factors of
     */
    public void getF(int num) {
        int f = nextPrime(1);
        while (num != 1) {
            if (num % f == 0) {
                num /= f;
                output.add(f);
            }
            else {
                f = nextPrime(f);
            }
        }
    }

    /**
     * Gets prime factors using recursion
     * @param numm the integer to find prime factors of
     * @param factors the last factor used
     */
    public void getFactors(int num, int...factors) {
        if (num < 2) {
            return;
        }
        int f = 2;
        if (factors.length > 0) {
            f = factors[0];
        }
        if (num % f == 0) {
            output.add(f);
            getFactors(num / f, f);
        }
        else {
            getFactors(num, nextPrime(f));
        }
    }

    public ArrayList<Integer> getOutput() {
        if (output.size() == 0) {
            return null;
        }
        return output;
    }

    public void clearOutput() {
        output.clear();
    }
}


/*public void getFactors(int n) {
    int f = nextPrime(1);
    if (f == x) {
        output.add(f);
        return;
    }
    if (n % f == 0) {
        output.add(f);
        getFactors(n / f, f);
    }
}

public void getFactors(int n, int p) {
    if (n % p == 0) {
        output.add(p);
        getFactors(n / p, p);
        return;
    }
    int f = nextPrime(p);
    if (f == 1 || n == 1) {
        return;
    }
    else if (n % f == 0) {
        output.add(f);
        getFactors(n / f, f);
    }
    else {
        getFactors(n, f);
    }
}*/