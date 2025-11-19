public class Primes {
    public static boolean isPrime(int n){
        for(int i = 2; i < n- 1; i++)
            if(n % i == 0)
                return false;
        return true;
    }
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]), counter = 0;
        System.out.println("Prime numbers up to " + n +":");
        for(int i = 2; i <= n; i++) {
            if(isPrime(i)) {
                System.out.println(i);
                counter++;
            }
        }
        System.out.println("There are " + counter + " primes between 2 and " + n + " (" + (int)((double)counter / (double)(n - 2) * 100)  + "% are primes)");
    }
}