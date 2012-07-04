package com.vainolo.phd.opm.interpreter;

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * The class <code>TestAll</code> builds a suite that can be used to run all
 * of the tests within its package as well as within any subpackages of its
 * package.
 *
 * @generatedBy CodePro at 03/07/12 09:16
 * @author vainolo
 * @version $Revision: 1.0 $
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	OPDAnalyzerTest.class,
	VariableManagerTest.class,
	OPMCompoundProcessInstanceTest.class,
	InterpreterTest.class,
	OPMAbstractProcessInstanceTest.class,
	OPMProcessInstanceFactoryTest.class,
	com.vainolo.phd.opm.interpreter.builtin.TestAll.class,
})
public class TestAll {

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 03/07/12 09:16
	 */
	public static void main(String[] args) {
		JUnitCore.runClasses(new Class[] { TestAll.class });
	}
}
