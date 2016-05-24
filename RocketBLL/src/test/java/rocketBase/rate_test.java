package rocketBase;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import exceptions.RateException;
import rocketDomain.RateDomainModel;

public class rate_test {

	//TODO - RocketBLL rate_test
	//		Check to see if a known credit score returns a known interest rate
	
	//TODO - RocketBLL rate_test
	//		Check to see if a RateException is thrown if there are no rates for a given
	//		credit score
	
	//Testing exception, seeing what happens if the score is below 600
	@Test
	public void RateExceptiontest() throws RateException{
		RateBLL.getRate(500);
	}
	
	
	@Test
	public void exception_test() throws RateException{
		assertEquals(RateBLL.getRate(600),5.0,0.1);
		assertEquals(RateBLL.getRate(650),4.5,0.1);
		assertEquals(RateBLL.getRate(700),4,0.1);
		assertEquals(RateBLL.getRate(750),3.5,0.1);
		assertEquals(RateBLL.getRate(800),3.0,0.1);
		
	}

}
