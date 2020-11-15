package org.apache.commons.mail;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.subethamail.smtp.server.Session;

public class EmailTest {
	
	
	private static final String[] TEST_EMAILS = {
			"test1@test.com", "test2@test.com",
			"test3@test.com", "test4@test.com"
	};
	
	private static final String[] TEST_EMAILS2 = {
			"test5@test.com", "test6@test.com",
			"test7@test.com", "test8@test.com",
			"test9@test.com", "test10@test.com",
			"test11@test.com", "test12@test.com"
	};
	
	private static final String[] TEST_CC = {
			"test1@test.com", "test2@test.com",
			"test3@test.com"
	};
	
	private static final String[] TESTNULL = {
		
	};
	
	private EmailConcrete email;
	
	//setup method
	@Before
	public void setUpEmailTest() throws Exception {
		email = new EmailConcrete();
		
	}
	
	//teardown methods
	@After public void tearDownEmailTest() throws Exception {
	//the unit tests are not long running processes
	// so teardown method can be ignored	
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	//test addBcc method
	//assert that the size of emails added is the same as expected
	//4 emails expected in this case
	@Test
	public void testAddBcc1() throws Exception {
		
		email.addBcc(TEST_EMAILS);
		
		assertEquals(4, email.getBccAddresses().size());
	}
	
	//test addBcc method
	//assert that the size of emails added is the same as expected
	//8 emails expected in this case
	@Test
	public void testAddBcc2() throws Exception {
	
		email.addBcc(TEST_EMAILS2);
		
		assertEquals(8, email.getBccAddresses().size());
		
	}
	
	//Expect EmailException when there are no emails
	@Test(expected = EmailException.class)
	public void testAddBccEmailException() throws Exception {
	
		email.addBcc(TESTNULL);
		
	}
	
	
	
}