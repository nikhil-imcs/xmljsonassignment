package com.imcs.jaxb.xml.apps;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.imcs.jaxb.xml.Address;
import com.imcs.jaxb.xml.Customer;
import com.imcs.jaxb.xml.PaymentMethod;

public class JSONApp {

	public static void main(String[] args) throws ParseException, DatatypeConfigurationException, JAXBException, JsonGenerationException, JsonMappingException, IOException {
		Address address=new Address();
		address.setStreet("6445 Love Dr");
		address.setAptNo("1036");
		address.setCity("Irving");
		address.setState("TX");
		address.setZipcode("75059");
		
		PaymentMethod method=new PaymentMethod();
		method.setCardName("VISA");
		method.setCardNumber("7487632437477");
		method.setCardType("CREDITCARD");
		
		SimpleDateFormat s=new SimpleDateFormat("MM/dd/yyyy");
		Date d1=s.parse("01/10/2016");
		GregorianCalendar c1 = new GregorianCalendar();
		c1.setTime(d1);
		XMLGregorianCalendar startDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(c1);
		
		method.setDateFrom(startDate);
		
		Date d2=s.parse("01/10/2020");
		GregorianCalendar c2 = new GregorianCalendar();
		c2.setTime(d2);
		XMLGregorianCalendar endDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(c2);
		
		method.setDateExp(endDate);
		
		Customer customer=new Customer();
		customer.setCustomerId("100");
		customer.setCustName("Nikhil");
		customer.setAddress(address);
		customer.setAnnualSalary(60000f);
		
		Date d3=s.parse("06/10/1990");
		GregorianCalendar c3 = new GregorianCalendar();
		c3.setTime(d3);
		XMLGregorianCalendar dob = DatatypeFactory.newInstance().newXMLGregorianCalendar(c3);
		
		customer.setDob(dob);
		
		customer.getPaymentMethod().add(method);
		
		JSONOperations operations=new JSONOperations();
		System.out.println("Serializing........");
		operations.serialize(customer);
		
		/*System.out.println("DeSerializing.......");
		operations.deserialize();*/
		
		
		

	}

}
