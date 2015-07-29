package com.villtron.loanpicker.filtering;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ypei.loanpicker.IRule;
import com.ypei.loanpicker.beans.Loan;

/**
 * 
 * check here for what does each attribute means:
 * https://www.lendingclub.com/developers/listed-loans.action
 * example:
 * 
 * 	"loans": [
	{
	
		// Tracking
		"id":111111,			//A unique LC assigned ID for the loan listing.
		"memberId":222222,		//A unique LC assigned Id for the borrower member.

		// LC Housekeeping
		"AsOfDate":"",			//As of date
		"acceptD":"2014-08-25T10:56:29.000-07:00",	//The date which the borrower accepted the offer
		"expD":"2014-09-08T10:57:13.000-07:00", //The date the listing will expire
		"listD":"2014-08-25T10:50:20.000-07:00", //The date which the borrower's application was listed on the platform.
		"creditPullD":"2014-08-25T10:56:18.000-07:00",//The date LC pulled credit for this loan
		"reviewStatusD":"2014-09-03T14:41:53.957-07:00", //The date the loan application was reviewed by LC		
		"reviewStatus":"NOT_APPROVED", //The status of the loan during the listing period. Values: APPROVED, NOT_APPROVED.
		"initialListStatus":"F",		//The initial listing status of the loan. Possible values are W, F.				
		"ilsExpD":"2014-08-25T11:00:00.000-07:00", //The date and time when the loan will no longer be in the initial listing status. After this date is past, the initialListStatus below will not have any effect and the loan will be treated as a FRACTIONAL loan.

		// Investor progress.
		"fundedAmount":25.0,	//The total amount funded by investors for that loan at that point in time.
		"investorCount":"",		//The Number of investor members who have purchased notes from this loan

		// Loan details
		"loanAmount":1750.0,
		"term":36,				//The Number of payments on the loan. Values are in months and can be either 36 or 60.
		"intRate":10.99,		//Interest Rate on the loan
		"expDefaultRate":3.5,	//The expected default rate of the loan.
		"serviceFeeRate":0.85,	//Service fee rate paid by the investor for this loan.
		"installment":57.29,	//The monthly payment owed by the borrower if the loan originates.
		"grade":"B",			//LC assigned loan grade
		"subGrade":"B3",		//LC assigned loan subgrade

		// Buyer Motivation
		"desc":"Loan description", //Loan description provided by the borrower
		"purpose":"debt_consolidation", //A category provided by the borrower for the loan request. Values are: debt_consolidation, medical, home_improvement, renewable_energy, small_business, wedding, vacation, moving, house, car, major_purchase, credit_card, other

		// Buyer Geographics
		"homeOwnership":"OWN",	//The home ownership status provided by the borrower during registration. Our values are: RENT, OWN, MORTGAGE, OTHER
		"addrZip":"904xx",		//The first 3 numbers of the ZIP code provided by the borrower in the loan application.
		"addrState":"CA",		//The address state provided by the borrower during loan application
				
		// Buyer Income
		"empTitle":"",			//Employment title
		"empLength":0,			//Employment length in months. Possible values are whole numbers from 0 and higher. Null indicates not employed.
		"annualInc":123432.0,	//The annual income provided by the borrower during registration.
		"isIncV":"Requested",	//Indicates if income is verified by LC


		// Buyer Credit Summary
		"ficoRangeLow":750,		//The lower boundary of range the borrower's FICO belongs to.
		"ficoRangeHigh":754,	//The upper boundary of range the borrower's FICO belongs to.


		// Buyer Financial Situation
		"mortAcc":23,				//Number of mortgage accounts.
		"openAcc":3,				//The Number of open credit lines in the borrower's credit file.
		"totalBalExMort":13944,		//Total credit balance excluding mortgage.		
		"revolBal":1.0,				//Total credit revolving balance.
		"totalBcLimit":23,			//Total bankcard high credit/credit limit.
		"totalAcc":4,				//The total Number of credit lines currently in the borrower's credit file
		"totalIlHighCreditLimit":12,	//Total installment high credit/credit limit
		"numRevAccts":28,			//Number of revolving accounts
		"numSats":8,				//Number of satisfactory accounts
		"totHiCredLim":12,				//Total high credit/credit limit		
		"totCurBal":12,				//Total current balance of all accounts
		"numBcTl":12,					//Number of bankcard accounts
		"numActvBcTl":12,				//Number of currently active bankcard accounts		
		"numBcSats":7,					//Number of satisfactory bankcard accounts
		"numIlTl":12,				//Number of installment accounts
		"numActvRevTl":12,				//Number of currently active revolving trades
		"totalRevHiLim":12,				//Total revolving high credit/credit limit
		"numRevTlBalGt0":12,		//Number of revolving trades with balance > 0
		"numOpRevTl":12,				//Number of open revolving accounts
		
						
	
		// Buyer History
		"earliestCrLine":"1984-09-15T00:00:00.000-07:00",	//The date the borrower's earliest reported credit line was opened
		"accOpenPast24Mths":23,		//Number of trades opened in past 24 months.
		"inqLast6Mths":0,			//The Number of inquiries by creditors during the past 6 months.				
		"mthsSinceRecentInq":14,	//Months since most recent inquiry.
		"mthsSinceRecentBc":23,		//Months since most recent bankcard account opened.
		"numTlOpPast12m":0,				//Number of accounts opened in past 12 months
		"moSinRcntTl":12,			//Months since most recent account opened		
		"moSinOldIlAcct":12,		//Months since oldest installment account opened
		"moSinOldRevTlOp":12,			//Months since oldest revolving account opened
		"moSinRcntRevTlOp":11,				//Months since most recent revolving account opened
		
							
							
		// Useless Metrics
		"dti":0.0,					//The borrower's debt to income ratio, calculated using the monthly payments on the total debt obligations, excluding mortgage, divided by self-reported monthly income.
		"bcOpenToBuy":30000,		//Total open to buy on revolving bankcards.
		"percentBcGt75":23.0,		//Percentage of all bankcard accounts > 75% of limit.
		"bcUtil":23.0,				//Ratio of total current balance to high credit/credit limit for all bankcard accounts.
		"revolUtil":0.0,			//Revolving line utilization rate, or the amount of credit the borrower is using relative to all available revolving credit.
		"avgCurBal":12,					//Average current balance of all accounts



		// Negatives
		"pctTlNvrDlq":12,			//Percent of trades never delinquent
		"accNowDelinq":"",			//The Number of accounts on which the borrower is now delinquent.
		"delinq2Yrs":1,				//The Number of 30+ days past-due incidences of delinquency in the borrower's credit file for the past 2 years.
		"delinqAmnt":0.0,			//The past-due amount owed for the accounts on which the borrower is now delinquent.
		"mthsSinceLastDelinq":90,	//The Number of months since the borrower's last delinquency.
		"mthsSinceLastRecord":0,	//The Number of months since the last public record.
		"mthsSinceRecentRevolDelinq":23,	//Months since most recent revolving delinquency.
		"mthsSinceRecentBcDlq":52,		//Months since most recent bankcard delinquency.
		"pubRec":0,					//Number of derogatory public records.
		"pubRecBankruptcies":0,			//Number of public record bankruptcies.
		"numAcctsEver120Ppd":12,		//Number of accounts ever 120 or more days past due.
		"chargeoffWithin12Mths":0,	//Number of charge-offs within 12 months.
		"collections12MthsExMed":0,	//Number of collections in 12 months excluding medical collections.
		"taxLiens":0,				//Number of tax liens
		"mthsSinceLastMajorDerog":12,	//Months since most recent 90-day or worse rating.
		"numTl90gDpd24m":12,		//Number of accounts 90 or more days past due in last 24 months
		"numTl30dpd":12,			//Number of accounts currently 30 days past due (updated in past 2 months)
		"numTl120dpd2m":12,			//Number of accounts currently 120 days past due (updated in past 2 months)
		"totCollAmt":12,				//Total collection amounts ever owed

	
	}]
 * @author mvillere
 *
 */
public class FilterRule implements IRule {
	
	private static Logger logger = Logger.getLogger(FilterRule.class);
	
	private String name = "FilterRule";
	private List<ILoanFilter> filterList;
	
	public FilterRule(String name, List<ILoanFilter> filterList){
		this.name = name;
		this.filterList = filterList;
	}
	
	public FilterRule(ILoanFilter filter){
		ArrayList<ILoanFilter> filterList = new ArrayList<ILoanFilter>();
		filterList.add(filter);
		this.filterList = filterList;
		this.name = filter.Name();
	}
	
	public boolean pickBasedOnRule (Loan loan){
		for(ILoanFilter filter : filterList){
			FilterFailure failure = filter.FilterLoan(loan);
			
			if(failure != null){
				logger.info("[" + filter.Name() + "] filter failed loan [" + loan.id + "]. Cause of failure: " + failure);
				return false;
			}
		}
		
		// none of the filters activated, so loan is pickable.
		return true;
	}

	public String getName() {
		return name;
	}
}
