package misc;

import java.math.BigInteger;

public class ConstantTimeAPGenerator {
	
	public static void main(String[] args) {
		
		BigInteger numOfHits = new BigInteger("1000000000");
		
		
		BigInteger result = numOfHits.multiply(numOfHits.add(BigInteger.ONE)).divide(BigInteger.TWO);
		System.out.println("Constant Time Code:: " + result);
		
	}

}


