package com.villtron.loanpicker.filtering;

/**
 * @author mvillere
 *
 */
public class FilterFailure {
	private LoanAttribute attribute;
	private Object badValue;
	private Object thresholdValue;
	
	public FilterFailure(LoanAttribute attribute, Object badValue){
		this.attribute = attribute;
		this.badValue = badValue;
		this.thresholdValue = 0;
	}
	
	public FilterFailure(LoanAttribute attribute, Object badValue, Object thresholdValue){
		this.attribute = attribute;
		this.badValue = badValue;
		this.thresholdValue = thresholdValue;
	}
	
	public String toString() {
		return "Failure Cause: [attribute=" + (attribute == null ? "null" : attribute.name()) + ", offending value="
				+ badValue + "] outside of threshold: " + thresholdValue;
	}
}
