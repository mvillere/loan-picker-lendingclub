package com.ypei.loanpicker;

import com.ypei.loanpicker.beans.Loan;

public interface IRule {
	public boolean pickBasedOnRule (Loan loan);
}
