package com.vainolo.phd.opm.interpreter;

import java.math.BigDecimal;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OPMObjectInstanceTest {

	OPMObjectInstance instance1, instance2, instance3;;
	BigDecimal number1, number2, number3;
	String string1, string2, string3;
	String state1, state2, state3;
	
	@Test
	public void test_CreateNumericalInstance() {
		instance1 = OPMObjectInstance.createFromValue(number1);
		assertEquals(number1, instance1.getValue());
	}
	
	@Test
	public void test_CreateStringInstance() {
		instance1 = OPMObjectInstance.createFromValue(string1);
		assertEquals(string1, instance1.getValue());
	}
	
	@Test
	public void test_CreateStateInstance() {
		instance1 = OPMObjectInstance.createFromState(state1);
		assertEquals(state1, instance1.getState());
	}
	
	@Test
	public void test_CreateCompoundInstance() {
		instance1 = OPMObjectInstance.createCompositeInstance();
	}
	
	@Test
	public void test_AddPartsToCompoundInstance() {
		instance1 = OPMObjectInstance.createCompositeInstance();
		instance2 = OPMObjectInstance.createFromState(state1);
		instance3 = OPMObjectInstance.createFromValue(string1);
		instance1.addPart("part1", instance2);
		instance1.addPart("part2", instance3);
		
		assertTrue(instance1.isComposite());
		assertEquals(instance1.getParts().size(), 2);
		assertEquals(instance1.getPart("part1"), instance2);
		assertEquals(instance1.getPart("part2"), instance3);
	}
	
	@Test(expected=IllegalStateException.class)
	public void test_GetValueFromCompountInstance_ExpectException() {
		instance1 = OPMObjectInstance.createCompositeInstance();
		instance1.getValue();
	}

	@Test(expected=IllegalStateException.class)
	public void test_GetStateFromCompoundInstance_ExpectException() {
		instance1 = OPMObjectInstance.createCompositeInstance();
		instance1.getState();
	}

	@Test(expected=IllegalStateException.class)
	public void test_GetPartsFromValueInstance_ExpectException() {
		instance1 = OPMObjectInstance.createFromValue(number1);
		instance1.getParts();
	}
	
	@Test(expected=IllegalStateException.class) 
	public void test_AddPartToValueInstance_ExpectException() {
		instance1 = OPMObjectInstance.createFromValue(number1);
		instance2 = OPMObjectInstance.createFromValue(number1);
		instance1.addPart("name", instance2);
	}
	
	@Test(expected=IllegalStateException.class) 
	public void test_AddPartToStateInstance_ExpectException() {
		instance1 = OPMObjectInstance.createFromState(state1);
		instance2 = OPMObjectInstance.createFromValue(number1);
		instance1.addPart("name", instance2);
	}

	@Test
	public void test_NumericalValueInstanceToString() {
		instance1 = OPMObjectInstance.createFromValue(number1);
		assertEquals(number1.toString(), instance1.toString());
	}
	
	@Test
	public void test_StringValueInstanceToString() {
		instance1 = OPMObjectInstance.createFromValue(string1);
		assertEquals(string1, instance1.toString());
	}
	
	@Test
	public void tes_CompoundInstanceToString() {
		instance1 = OPMObjectInstance.createCompositeInstance();
		instance2 = OPMObjectInstance.createFromValue(number1);
		instance1.addPart("part1", instance2);
		assertEquals("{part1:"+instance2.toString()+"}", instance1.toString());
		
	}
	
	@Before
	public void setUp() {
		Random r = new Random();
		number1 = new BigDecimal(r.nextInt());
		number2 = new BigDecimal(r.nextInt());
		number3 = new BigDecimal(r.nextInt());
		string1 = (new BigDecimal(r.nextInt())).toString();
		string2 = (new BigDecimal(r.nextInt())).toString();
		string3 = (new BigDecimal(r.nextInt())).toString();
		state1 = (new BigDecimal(r.nextInt())).toString();
		state2 = (new BigDecimal(r.nextInt())).toString();
		state3 = (new BigDecimal(r.nextInt())).toString();
	}
}
