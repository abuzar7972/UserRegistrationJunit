package com.logic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
class ValidEmailId
{
	
	private UserRegistration userRegistration;
	private boolean expectedResult;
	private String emailId;
    public ValidEmailId(String emailId, boolean expectedResult)
    {
			super();
			this.expectedResult = expectedResult;
			this.emailId = emailId;
		}

		@Before
		public void initialize() 
		{
			userRegistration = new UserRegistration();
		}

		@Parameterized.Parameters
		public static Collection emailIds_With_ExpectedResult()
		 {
			return Arrays.asList(new Object[][] { { "abc.syz@bl.co.in", true }, { "abc-100@yahoo.com", true },
					{ "abc.100@yahoo.com", true }, { "abc111@abc.com", true }, { "abc-100@abc.net", true },
					{ "abc.100@abc.com.au", true }, { "abc@1.com", true }, { "abc@gmail.com.com", true },
					{ "abc+100@gmail.com", true }, { "abc", false }, { "abc@.com.my", false }, { "abc123@gmail.a", false },
					{ "abc123@.com", false }, { "abc123@.com.com", false }, { ".abc@abc.com", false },
					{ "abc()*@gmail.com", false }, { "abc@%*.com", false }, { "abc..2002@gmail.com", false },
					{ "abc.@gmail.com", false }, { "abc@abc@gmail.com", false }, { "abc@gmail.com.1a", false },
					{ "abc@gmail.com.aa.au", false } });
		}
		@Test
		public void givenEmailIds_WhenProper_ShouldReturnExpectedResult() throws UserRegestrationTest 
		{
			boolean result = userRegistration.validateEmailId(emailId);
			Assert.assertEquals(this.expectedResult, userRegistration.validateEmailId(emailId));
		}
}
