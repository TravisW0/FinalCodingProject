package rocketBase;

import java.util.ArrayList;
import org.apache.poi.ss.formula.functions.*;
import exceptions.RateException;
import rocketData.LoanRequest;
import rocketDomain.RateDomainModel;

public class RateBLL {

	private static RateDAL _RateDAL = new RateDAL();
	private static RateDomainModel RateDomainModel;

	public static double getRate(int GivenCreditScore) throws RateException {

		// TODO - RocketBLL RateBLL.getRate - make sure you throw any
		// exception

		// Call RateDAL.getAllRates... this returns an array of rates
		// write the code that will search the rates to determine the
		// interest rate for the given credit score
		// hints: you have to sort the rates... you can do this by using
		// a comparator... or by using an OrderBy statement in the HQL

		ArrayList<RateDomainModel> rates = new ArrayList<RateDomainModel>(RateDAL.getAllRates());
		double InterestRate = -1.0;

		for (RateDomainModel rate : rates) {
			if (rate.getiMinCreditScore() <= GivenCreditScore) {
				InterestRate = rate.getdInterestRate();
			}
		}

		if (InterestRate == -1.0) {
			LoanRequest lq = new LoanRequest();
			lq.setiCreditScore(GivenCreditScore);
			throw new RateException(lq);
		}

		return InterestRate;
	}

	// TODO - RocketBLL RateBLL.getRate
	// obviously this should be changed to return the determined rate

	// TODO - RocketBLL RateBLL.getPayment
	// how to use:
	// https://poi.apache.org/apidocs/org/apache/poi/ss/formula/functions/FinanceLib.html

	// r - rate
	// n - number of periods
	// y - payment in each period
	// p - present value
	// t - payment in each period??
	// f - future value
	public static double getPayment(double r, double n, double p, double f, boolean t) {

		return (Math.abs(FinanceLib.pmt(r/100/12, n, p, f, t)));
		
	}
}
