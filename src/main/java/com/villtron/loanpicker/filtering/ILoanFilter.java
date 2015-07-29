package com.villtron.loanpicker.filtering;

import com.ypei.loanpicker.beans.Loan;

/**
 * @author mvillere
 *
 */
public interface ILoanFilter {
	String Name();
	FilterFailure FilterLoan(Loan loan);
}
