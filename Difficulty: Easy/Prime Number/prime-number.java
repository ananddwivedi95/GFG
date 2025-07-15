class Solution {
    static boolean isPrime(int n) {
    
    if(n<=1) return false;  // smaller than 1 cannot be even 
    if(n==2) return true;   // only 2 is even prime number 
    if(n%2==0) return false; // even number cannot even except 2 
    
    for(int i=3;i*i<=n;i+=2)
    {
        if(n%i==0) return false;
    }
    return true;
    }
}