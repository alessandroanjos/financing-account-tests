package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Financing;

public class FinancingTests {

	@Test
	public void constructorShouldCreateObjectWhenValidData() {
		
		double amount = 100000.00;
		double income = 2000.0;
		int months = 80;
		
		Financing f = new Financing(amount, income, months);
		
		Assertions.assertEquals(2000.0, f.getIncome());
		Assertions.assertEquals(100000.00, f.getTotalAmount());
		Assertions.assertEquals(80, f.getMonths());
	}
	
	@Test
	public void throwExceptionWhenInvalidDataFinancing() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			double amount = 100000.00;
			double income = 2000;
			int months = 20;
			
			new Financing(amount, income, months);
			
		});
	}
	
	@Test
	public void setTotalAmountShouldUpdateDataWhenFinancingIsValid() {
		
		double amount = 100000.00;
		double income = 2000;
		int months = 80;
		
		Financing f = new Financing(amount, income, months);
		
		f.setTotalAmount(50000.0);  
		
		Assertions.assertEquals(50000.0, f.getTotalAmount());
	}
	
	@Test
	public void setTotalAmountShouldThrowIlllegalArgumentExpectionWhenInvalidData() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			double amount = 100000.00;
			double income = 2000;
			int months = 80;
			
			Financing f = new Financing(amount, income, months);
			f.setTotalAmount(100001.0);  
		});
	}
	
	@Test
	public void setIncomeAmountShouldUpdateDataWhenFinancingIsValid() {
		
		double amount = 100000.00;
		double income = 2000;
		int months = 80;
		
		Financing f = new Financing(amount, income, months);
		
		f.setIncome(4000.0);  
		
		Assertions.assertEquals(4000.0, f.getIncome());
	}
	
	@Test
	public void setIncomeAmountShouldThrowIlllegalArgumentExpectionWhenInvalidData() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			double amount = 100000.00;
			double income = 2000;
			int months = 80;
			
			Financing f = new Financing(amount, income, months);
			f.setIncome(1500.0);
		});
	}
	
	
	@Test
	public void setMonthsAmountShouldUpdateDataWhenFinancingIsValid() {
		
		double amount = 100000.00;
		double income = 2000;
		int months = 80;
		
		Financing f = new Financing(amount, income, months);
		
		f.setMonths(82);  
		
		Assertions.assertEquals(82, f.getMonths());
	}
	
	@Test
	public void setMonthsAmountShouldThrowIlllegalArgumentExpectionWhenInvalidData() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			double amount = 100000.00;
			double income = 2000;
			int months = 80;
			
			Financing f = new Financing(amount, income, months);
			f.setMonths(75);
		});
	}
	
	
	@Test
	public void entryShouldCalculateCorrectlyEntryValueFinancing() {
		
		double amount = 100000.00;
		double income = 2000;
		int months = 80;
		
		Financing f = new Financing(amount, income, months);
		double expectEntryValue = 20000.0;  
		
		Assertions.assertEquals(expectEntryValue, f.entry());
	}
	
	@Test
	public void entryShouldCalculateCorrectlyQuotaValueFinancing() {
		
		double amount = 100000.00;
		double income = 2000;
		int months = 80;
		
		Financing f = new Financing(amount, income, months);
		double expectQuotaValue = 1000.0;  
		
		Assertions.assertEquals(expectQuotaValue, f.quota());
	}

}
