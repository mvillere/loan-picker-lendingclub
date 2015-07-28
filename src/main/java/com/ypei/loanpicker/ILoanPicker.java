package com.ypei.loanpicker;

import java.util.List;

import com.ypei.loanpicker.beans.Loan;

public interface ILoanPicker {
	List<Loan> pickLoans(List<Loan> loansLoaded);
}
