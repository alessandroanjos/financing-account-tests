package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;
import tests.factory.AccountFactory;

/**
 * 
 * ACTION should EFFECT [ when SCENARY ]
 * 
 * Pattern AAA 
 * 	Arrange - instance the necessary objects 
 * 	Act - execute the necessary actions
 * 	Assert - declare what should be happen
 */
public class AccountTests {

	@Test
	public void depositShouldIncreaseBalanceAndDiscountFeeWhenPositveAmount() {
		
		//Arrange
		double amount = 200.0;
		double expectedValue = 196.0;
		Account acc = AccountFactory.createEmptyAccount();
		
		
		//Act
		acc.deposit(amount);
		
		
		//assert
		Assertions.assertEquals(expectedValue, acc.getBalance());
	}
	
	@Test
	public void depositShouldDoNothingWhenNegativeAmount() {
		
		double amount = -200.0;
		double expectValue = 100.0;
		Account acc = AccountFactory.createAccount(expectValue);
		
		acc.deposit(amount);
		
		Assertions.assertEquals(expectValue, acc.getBalance());
	}
	
	@Test
	public void fullWithDrawShouldClearBalanceAndReturnFullBalance() {
		double expectedValue = 0.0;
		double initialBalance = 800.0;
		Account acc = AccountFactory.createAccount(initialBalance);
		
		double result = acc.fullWithDraw();
		
		Assertions.assertEquals(expectedValue, acc.getBalance());
		Assertions.assertTrue(result == initialBalance);
		
	}
	
	@Test
	public void withDrawShouldDecreaseBalanceWhenSufficientBalance() {
		Account acc = AccountFactory.createAccount(800.0);
		
		acc.withDraw(500.0);
		
		Assertions.assertEquals(300.0, acc.getBalance());
	}
	
	@Test
	public void withDrawShouldThrowExceptionWhenBalanceInsufficient() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Account acc = AccountFactory.createAccount(800.0);
			acc.withDraw(801.0);
		});
	}
}
