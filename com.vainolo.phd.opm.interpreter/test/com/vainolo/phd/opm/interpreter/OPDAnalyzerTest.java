package com.vainolo.phd.opm.interpreter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.util.List;

import org.eclipse.draw2d.geometry.Rectangle;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMProcess;

/**
 * The class <code>OPDAnalyzerTest</code> contains tests for the class <code>{@link OPDAnalyzer}</code>.
 * 
 * @generatedBy CodePro at 6/21/12 2:57 PM
 * @author vainolo
 * @version $Revision: 1.0 $
 */
public class OPDAnalyzerTest {

	/**
	 * Run the OPMProcess getTopmostProcess(OPMObjectProcessDiagram) method test.
	 * 
	 * @generatedBy CodePro at 6/21/12 2:57 PM
	 */
	@Test
	public void testGetTopmostProcess() {
		final OPMObjectProcessDiagram opd = OPMFactory.eINSTANCE.createOPMObjectProcessDiagram();

		// Add one process, should be the first one.
		final OPMProcess process1 = OPMFactory.eINSTANCE.createOPMProcess();
		process1.setConstraints(new Rectangle(5, 5, 0, 0));
		opd.getNodes().add(process1);
		OPMProcess result = OPDAnalyzer.findTopmostProcess(opd);
		assertEquals(process1, result);

		// Add another process below the first one. The first one should be returned.
		final OPMProcess process2 = OPMFactory.eINSTANCE.createOPMProcess();
		process2.setConstraints(new Rectangle(5, 6, 0, 0));
		opd.getNodes().add(process2);
		result = OPDAnalyzer.findTopmostProcess(opd);
		assertEquals(process1, result);

		// Add another process above the first one. The new one should be returned.
		final OPMProcess process3 = OPMFactory.eINSTANCE.createOPMProcess();
		process3.setConstraints(new Rectangle(5, 4, 0, 0));
		opd.getNodes().add(process3);
		result = OPDAnalyzer.findTopmostProcess(opd);
		assertEquals(process3, result);

		// Check that x value does not affect the first selected process.
		final OPMProcess process4 = OPMFactory.eINSTANCE.createOPMProcess();
		process4.setConstraints(new Rectangle(1, 5, 0, 0));
		opd.getNodes().add(process4);
		result = OPDAnalyzer.findTopmostProcess(opd);
		assertEquals(process3, result);

	}

	@Test
	public void testFindInitialProcesses() {
		final OPMObjectProcessDiagram opd = OPMFactory.eINSTANCE.createOPMObjectProcessDiagram();

		// Add one process, the returned list should contain only this process.
		// @formatter:off
		//					   XXXXX
		//					  X     X
		//					 X   1   X
		//					  X     X
		//					   XXXXX
		// @formatter:on

		final OPMProcess process1 = OPMFactory.eINSTANCE.createOPMProcess();
		process1.setConstraints(new Rectangle(10, 10, 10, 10));
		opd.getNodes().add(process1);
		List<OPMProcess> processes = OPDAnalyzer.findInitialProcesses(opd);
		assertEquals(1, processes.size());
		assertEquals(process1, processes.get(0));

		// Add one process below the end of the first process. Only the first process should be returned.
		// @formatter:off
		//             XXXXX
		//            X     X
		//           X   1   X
		//            X     X
		//             XXXXX
		//
		//
		//
		//   XXXXX
		//  X     X
		// X   2   X
		//  X     X
		//   XXXXX
		// @formatter:on
		final OPMProcess process2 = OPMFactory.eINSTANCE.createOPMProcess();
		process2.setConstraints(new Rectangle(10, 25, 10, 10));
		opd.getNodes().add(process2);
		processes = OPDAnalyzer.findInitialProcesses(opd);
		assertEquals(1, processes.size());
		assertEquals(process1, processes.get(0));

		// Add one process slightly below the first process. The two processes (this and the first one) should be
		// returned.
		// @formatter:off 
		//       XXXXX
		//      X     X       XXXXX
		//     X   1   X     X     X
		//      X     X     X   3   X
		//       XXXXX       X     X
		//                    XXXXX
		//
		//
		//  XXXXX
		// X     X
		//X   2   X
		// X     X
		//  XXXXX
		// @formatter:on
		final OPMProcess process3 = OPMFactory.eINSTANCE.createOPMProcess();
		process3.setConstraints(new Rectangle(50, 11, 10, 10));
		opd.getNodes().add(process3);
		processes = OPDAnalyzer.findInitialProcesses(opd);
		assertEquals(2, processes.size());
		for (final OPMProcess process : processes) {
			assertNotSame(process2, process);
		}

		// Add one process slightly above the first process. This process should also be returned.
		// @formatter:off
		//   XXXXX
		//  X     X    XXXXX
		// X   4   X  X     X       XXXXX
		//  X     X  X   1   X     X     X
		//   XXXXX    X     X     X   3   X
	    //             XXXXX       X     X
	    //                          XXXXX
		//
		//
		//   XXXXX
		//  X     X
		// X   2   X
		//  X     X
		//   XXXXX		
		// @formatter:on
		final OPMProcess process4 = OPMFactory.eINSTANCE.createOPMProcess();
		process4.setConstraints(new Rectangle(34, 8, 10, 10));
		opd.getNodes().add(process4);
		processes = OPDAnalyzer.findInitialProcesses(opd);
		assertEquals(3, processes.size());
		for (final OPMProcess process : processes) {
			assertNotSame(process2, process);
		}

		// Add one process that starts after process4 ends but before process1 ends. It should not be returned.
		// @formatter:off
		//   XXXXX
		//  X     X    XXXXX
		// X   4   X  X     X       XXXXX
		//  X     X  X   1   X     X     X
		//   XXXXX    X     X     X   3   X
		//             XXXXX       X     X      XXXXXXX
		//                          XXXXX     XX       XX
		//                                   X     5     X
		//                                    XX       XX
		//   XXXXX                              XXXXXXX
		//  X     X
		// X   2   X
		//  X     X
		//   XXXXX
		// @formatter:on
		final OPMProcess process5 = OPMFactory.eINSTANCE.createOPMProcess();
		process5.setConstraints(new Rectangle(60, 19, 10, 10));
		opd.getNodes().add(process5);
		processes = OPDAnalyzer.findInitialProcesses(opd);
		assertEquals(3, processes.size());
		for (final OPMProcess process : processes) {
			assertNotSame(process2, process);
			assertNotSame(process5, process);
		}

	}

	/**
	 * Perform pre-test initialization.
	 * 
	 * @throws Exception
	 *             if the initialization fails for some reason
	 * 
	 * @generatedBy CodePro at 6/21/12 2:57 PM
	 */
	@Before
	public void setUp() throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 * 
	 * @throws Exception
	 *             if the clean-up fails for some reason
	 * 
	 * @generatedBy CodePro at 6/21/12 2:57 PM
	 */
	@After
	public void tearDown() throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 * 
	 * @param args
	 *            the command line arguments
	 * 
	 * @generatedBy CodePro at 6/21/12 2:57 PM
	 */
	public static void main(final String[] args) {
		new org.junit.runner.JUnitCore().run(OPDAnalyzerTest.class);
	}
}