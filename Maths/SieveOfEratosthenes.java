public class SieveOfEratosthenes {
    public static void main(String[] args) {
        int n=10;
        System.out.println(countPrimes(n));
    }
    public static int countPrimes(int n) {
        //no role of 0 and 1 (not prime)
        boolean isPrime[] = new boolean[n+1]; // 0 to n
        Arrays.fill(isPrime,true); // intitally mark every number as prime(true)

        for(int i=2; i<=(int)Math.sqrt(isPrime.length); i++){
            //for every prime number
            if(isPrime[i]==true){
                //making factors/multiples not primes
                for(int j=i+i; j<isPrime.length; j=j+i){
                    isPrime[j]=false; //not prime
                }
            }
        }

        //print count of all prime
        int count=0;
        for(int i=2; i<n; i++){
            if(isPrime[i]==true){
                count++;
            }
        }
        return count;
    }
}
