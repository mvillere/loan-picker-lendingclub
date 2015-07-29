package com.villtron.loanpicker.pickers;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ypei.loanpicker.ILoanPicker;
import com.ypei.loanpicker.IRule;
import com.ypei.loanpicker.beans.Loan;

/**
 * @author mvillere
 *
 *	Pick loans using a filter rule.
 */
public class FilterRuleLoanPicker implements ILoanPicker {
	private static Logger logger = Logger.getLogger(FilterRuleLoanPicker.class);

	private IRule rule;
	
	public FilterRuleLoanPicker(IRule rule) {
		this.rule = rule;
	}
	
	public List<Loan> pickLoans(List<Loan> loansLoaded) {

		List<Loan> loansPicked = new ArrayList<Loan>();

		try {
			for (Loan loan : loansLoaded) {

				if (rule.pickBasedOnRule(loan)) {
					loansPicked.add(loan);
				}
			}
			
			int i = 1, len = loansPicked.size();
			for (Loan l : loansPicked) {

				logger.info("");
				logger.info("-----------------------------------------------");
				logger.info("PRE_PICKED_LOANS__" + rule.getName() + "__" + i + "/" + len + " :"
						+ l.toString());
				i++;
			}

			logger.info("-----------------------------------------------");
			logger.info("PRE_PICKED_LOANS__" + rule.getName() + "__SIZE: " + loansPicked.size() + " OUT_OF "
					+ loansLoaded.size()  + " RECENT_LISTED_LOANS");

		} catch (Throwable e) {
			logger.error("fail", e);
		}

		return loansPicked;
	}
}