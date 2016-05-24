package exceptions;
import rocketData.LoanRequest;
import rocketDomain.RateDomainModel;

public class RateException extends Exception {

	//	TODO - RocketBLL RateException - RateDomainModel should be an attribute of RateException
	//	* Add RateRomainModel as an attribute
	//	* Create a constructor, passing in RateDomainModel
	//	* Create a getter (no setter, set value only in Constructor)
	
	
	private LoanRequest lq;
	
	public RateException(LoanRequest lq){
		this.lq = lq;
	}

	public LoanRequest getLq() {
		return lq;
	}
	
	
}