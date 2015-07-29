package com.villtron.loanpicker.customfilters;

import java.util.Set;

import com.villtron.loanpicker.filtering.FilterFailure;
import com.villtron.loanpicker.filtering.ILoanFilter;
import com.villtron.loanpicker.filtering.LoanAttribute;
import com.ypei.loanpicker.beans.Loan;

/**
 * @author mvillere
 * 
 *         Eliminate loans that are owned.
 */
public class NoOwnedLoansFilter implements ILoanFilter {

	private Set<Long> ownedNotesIds;

	public NoOwnedLoansFilter(Set<Long> ownedNotesIds) {
		this.ownedNotesIds = ownedNotesIds;
	}

	public String Name() {
		return "NoOwnedLoansFilter";
	}

	public FilterFailure FilterLoan(Loan loan) {
		if (ownedNotesIds.contains(loan.id)) {
			return new FilterFailure(LoanAttribute.id, loan.id,
					"loan id owned.");
		}

		return null;
	}
}
