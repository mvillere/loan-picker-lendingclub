package com.villtron.loanpicker.filtering;

/**
 * @author mvillere
 *
 */
public enum LoanAttribute {
	id, //A unique LC assigned ID for the loan listing.
	memberId, //A unique LC assigned Id for the borrower member.

	// LC Housekeeping
	AsOfDate, //As of date
	acceptD, //The date which the borrower accepted the offer
	expD, //The date the listing will expire
	listD, //The date which the borrower's application was listed on the platform.
	creditPullD, //The date LC pulled credit for this loan
	reviewStatusD, //The date the loan application was reviewed by LC		
	reviewStatus, //The status of the loan during the listing period. Values: APPROVED, NOT_APPROVED.
	initialListStatus, //The initial listing status of the loan. Possible values are W, F.				
	ilsExpD, //The date and time when the loan will no longer be in the initial listing status. After this date is past, the initialListStatus below will not have any effect and the loan will be treated as a FRACTIONAL loan.

	// Investor progress.
	fundedAmount, //The total amount funded by investors for that loan at that point in time.
	investorCount, //The Number of investor members who have purchased notes from this loan

	
	// Loan details
	loanAmount, // Amount of the loan
	term, //The Number of payments on the loan. Values are in months and can be either 36 or 60.
	intRate, //Interest Rate on the loan
	expDefaultRate, //The expected default rate of the loan.
	serviceFeeRate, //Service fee rate paid by the investor for this loan.
	installment, //The monthly payment owed by the borrower if the loan originates.
	grade, //LC assigned loan grade
	subGrade, //LC assigned loan subgrade

	
	// Buyer Details: Motivation
	desc, //Loan description provided by the borrower
	purpose, //A category provided by the borrower for the loan request. Values are: debt_consolidation, medical, home_improvement, renewable_energy, small_business, wedding, vacation, moving, house, car, major_purchase, credit_card, other

	// Buyer Details: Geographics
	homeOwnership, //The home ownership status provided by the borrower during registration. Our values are: RENT, OWN, MORTGAGE, OTHER
	addrZip, //The first 3 numbers of the ZIP code provided by the borrower in the loan application.
	addrState, //The address state provided by the borrower during loan application
			
	// Buyer Details: Income
	empTitle, //Employment title
	empLength, //Employment length in months. Possible values are whole numbers from 0 and higher. Null indicates not employed.
	annualInc, //The annual income provided by the borrower during registration.
	isIncV, //Indicates if income is verified by LC
	
	// Buyer Details: Credit
	ficoRangeLow, //The lower boundary of range the borrower's FICO belongs to.
	ficoRangeHigh, //The upper boundary of range the borrower's FICO belongs to.

	// Buyer Financial Situation
	mortAcc, //Number of mortgage accounts.
	openAcc, //The Number of open credit lines in the borrower's credit file.
	totalBalExMort, //Total credit balance excluding mortgage.		
	revolBal, //Total credit revolving balance.
	totalBcLimit, //Total bankcard high credit/credit limit.
	totalAcc, //The total Number of credit lines currently in the borrower's credit file
	totalIlHighCreditLimit, //Total installment high credit/credit limit
	numRevAccts, //Number of revolving accounts
	numSats, //Number of satisfactory accounts
	totHiCredLim, //Total high credit/credit limit		
	totCurBal, //Total current balance of all accounts
	numBcTl, //Number of bankcard accounts
	numActvBcTl, //Number of currently active bankcard accounts		
	numBcSats, //Number of satisfactory bankcard accounts
	numIlTl, //Number of installment accounts
	numActvRevTl, //Number of currently active revolving trades
	totalRevHiLim, //Total revolving high credit/credit limit
	numRevTlBalGt0, //Number of revolving trades with balance > 0
	numOpRevTl, //Number of open revolving accounts
	
					

	// Buyer History
	earliestCrLine, //The date the borrower's earliest reported credit line was opened
	accOpenPast24Mths, //Number of trades opened in past 24 months.
	inqLast6Mths, //The Number of inquiries by creditors during the past 6 months.				
	mthsSinceRecentInq, //Months since most recent inquiry.
	mthsSinceRecentBc, //Months since most recent bankcard account opened.
	numTlOpPast12m, //Number of accounts opened in past 12 months
	moSinRcntTl, //Months since most recent account opened		
	moSinOldIlAcct, //Months since oldest installment account opened
	moSinOldRevTlOp, //Months since oldest revolving account opened
	moSinRcntRevTlOp, //Months since most recent revolving account opened
	
						
						
	// Useless Metrics
	dti, //The borrower's debt to income ratio, calculated using the monthly payments on the total debt obligations, excluding mortgage, divided by self-reported monthly income.
	bcOpenToBuy, //Total open to buy on revolving bankcards.
	percentBcGt75, //Percentage of all bankcard accounts > 75% of limit.
	bcUtil, //Ratio of total current balance to high credit/credit limit for all bankcard accounts.
	revolUtil, //Revolving line utilization rate, or the amount of credit the borrower is using relative to all available revolving credit.
	avgCurBal, //Average current balance of all accounts



	// Negatives
	pctTlNvrDlq, //Percent of trades never delinquent
	accNowDelinq, //The Number of accounts on which the borrower is now delinquent.
	delinq2Yrs, //The Number of 30+ days past-due incidences of delinquency in the borrower's credit file for the past 2 years.
	delinqAmnt, //The past-due amount owed for the accounts on which the borrower is now delinquent.
	mthsSinceLastDelinq, //The Number of months since the borrower's last delinquency.
	mthsSinceLastRecord, //The Number of months since the last public record.
	mthsSinceRecentRevolDelinq, //Months since most recent revolving delinquency.
	mthsSinceRecentBcDlq, //Months since most recent bankcard delinquency.
	pubRec, //Number of derogatory public records.
	pubRecBankruptcies, //Number of public record bankruptcies.
	numAcctsEver120Ppd, //Number of accounts ever 120 or more days past due.
	chargeoffWithin12Mths, //Number of charge-offs within 12 months.
	collections12MthsExMed, //Number of collections in 12 months excluding medical collections.
	taxLiens, //Number of tax liens
	mthsSinceLastMajorDerog, //Months since most recent 90-day or worse rating.
	numTl90gDpd24m, //Number of accounts 90 or more days past due in last 24 months
	numTl30dpd, //Number of accounts currently 30 days past due (updated in past 2 months)
	numTl120dpd2m, //Number of accounts currently 120 days past due (updated in past 2 months)
	totCollAmt, //Total collection amounts ever owed
}
