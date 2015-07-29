package com.ypei.loanpicker;

import com.ypei.loanpicker.beans.Loan;

public interface IRule {
	String getName();
	boolean pickBasedOnRule (Loan loan);
}
