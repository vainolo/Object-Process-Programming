package com.vainolo.opm.model.util;

import static org.junit.Assert.*;
import static com.vainolo.opm.model.util.OPModelUtils.*;

import org.junit.Test;

import com.vainolo.opm.model.OPModelFactory;
import com.vainolo.opm.model.OPNodeView;
import com.vainolo.opm.model.OPObjectProcessDiagram;
import com.vainolo.opm.model.OPThingView;

public class OPModelUitlsTest {

	@Test
	public void test_GetObjectProcessDiagram_OneLevel() {
		OPObjectProcessDiagram opd = OPModelFactory.createObjectProcessDiagram();
		OPNodeView node = OPModelFactory.createOPNodeView();
		node.setContainer(opd);
		
		OPObjectProcessDiagram result = getObjectProcessDiagram(node);
		
		assertEquals(opd, result);
	}
	
	@Test
	public void test_GetObjectProcessDiagram_TwoLevels() {
		OPObjectProcessDiagram opd = OPModelFactory.createObjectProcessDiagram();
		OPThingView node = OPModelFactory.createThingView();
		node.setContainer(opd);
		OPNodeView node2 = OPModelFactory.createOPNodeView();
		node2.setContainer(node);
	}

}
