package misc;

import java.math.BigInteger;

public class N2TimeAPGenerator {
	
	public static void main(String[] args) {
		BigInteger numOfHits = new BigInteger("1000000000");
		BigInteger apSum = new BigInteger("0");
		
		for(BigInteger i= new BigInteger("0"); i.compareTo(numOfHits) <= 0; i = i.add(BigInteger.ONE)) {
			apSum = apSum.add(i);
		}
		
		System.out.println("N2 Time Code:: " +apSum);
		
		//500000000500000000
		//500000000500000000
	}

}
