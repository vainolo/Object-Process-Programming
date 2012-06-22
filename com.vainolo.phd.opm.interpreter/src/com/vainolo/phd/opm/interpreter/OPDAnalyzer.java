/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import java.util.ArrayList;
import java.util.List;

import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMProcess;

/**
 * What this class must do: 1) find which processes must be executed when the OPD is executed. 2) given that a processed
 * finished executing, find all processes that should be executed next.
 * 
 * @author vainolo
 * 
 */
public final class OPDAnalyzer {

	/**
	 * Calculate the starting processes of an OPD. The starting processes are the ones at the top of the OPD - if we
	 * take the topmost process in the OPD, all processes which are located ABOVE the lowest point of this process are
	 * starting processes.
	 * 
	 * @param opd
	 * @return
	 */
	// public static List<OPMProcess> getStartingProcesses(OPMObjectProcessDiagram opd) {
	// List<OPMProcess> processes = opd.getProcesses();
	//
	// }

	/**
	 * Find the processes that should be executed initially when the OPD is executed. These are processes that are the
	 * processes at the top of the OPD. For example:
	 * 
	 * <pre>
	 *            XXXXX
	 *           X     X
	 *          X   p1  X   XXX
	 *           X     X   X   X
	 *            XXXXX   X p2  X
	 *   XXX               X   X
	 *  X   X               XXX
	 * X  p3 X
	 *  X   X
	 *   XXX
	 * </pre>
	 * 
	 * both p1 and p2 are initial processes since they are at the top of the OPD. p3 is not an initial process since
	 * it's top border is below p1's lowest border, so it must start after p1 ends.
	 * 
	 * @param opd
	 * @return
	 */
	public static List<OPMProcess> findInitialProcesses(final OPMObjectProcessDiagram opd) {
		final OPMProcess topmostProcess = findTopmostProcess(opd);
		final List<OPMProcess> retVal = new ArrayList<OPMProcess>();
		// Find all processes that start before this process ends.
		for (final OPMProcess process : opd.getProcesses()) {
			if (process.getConstraints().y <= (topmostProcess.getConstraints().y + topmostProcess.getConstraints().height)) {
				retVal.add(process);
			}
		}
		return retVal;
	}

	/**
	 * Fetch the topmost process (lowest y value) of the OPD. If there is more than one, the first one found if
	 * returned.
	 * 
	 * @param opd
	 *            The OPD to search.
	 * @return the topmost process of the OPD.
	 */
	public static OPMProcess findTopmostProcess(final OPMObjectProcessDiagram opd) {
		final List<OPMProcess> processes = opd.getProcesses();
		int minY = Integer.MAX_VALUE;
		OPMProcess topmostProcess = null;
		for (final OPMProcess process : processes) {
			if (process.getConstraints().y < minY) {
				minY = process.getConstraints().y;
				topmostProcess = process;
			}
		}
		return topmostProcess;
	}

}
