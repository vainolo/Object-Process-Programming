package com.vainolo.opm.model.io;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.eclipsesource.json.JsonObject;
import com.vainolo.opm.model.OPModelFactory;
import com.vainolo.opm.model.OPPoint;
import com.vainolo.opm.model.OPRectangle;

public class OPJSONWriterTest {

	private OPJSONWriter serializer;
	
	@SuppressWarnings("unused")
	private static final int X1 = 10, X2 = 15, X3 = 20,
			                 Y1 = 5, Y2 = 15, Y3 = 25,
			                 W1 = 10, W2 = 50, W3 = 75,
			                 H1 = 25, H2 = 55, H3 = 85;
	
	private OPPoint createPoint1() {
		OPPoint point = OPModelFactory.createOPPoint();
		point.setX(X1);
		point.setY(Y1);
		return point;
	}
	
	private OPRectangle createRectangle1() {
		OPRectangle rect = OPModelFactory.createOPRectangle();
		rect.getPoint().setX(X1);
		rect.getPoint().setY(Y1);
		rect.setWidth(W1);
		rect.setHeight(H1);
		return rect;
	}

	@Test
	public void test_SerializeOPPoint() {
		OPPoint point = createPoint1();
		
		JsonObject res = serializer.writeOPPoint(point);
		
		assertEquals(res.get("x").asInt(), X1);
		assertEquals(res.get("y").asInt(), Y1);
	}
	
	@Test
	public void test_SerializeOPConstraints() {
		OPRectangle rectangle = createRectangle1();

		JsonObject res = serializer.writeOPRectangle(rectangle);
		
		assertEquals(res.get("point").asObject().get("x").asInt(), X1);
		assertEquals(res.get("point").asObject().get("y").asInt(), Y1);
		assertEquals(res.get("width").asInt(), W1);
		assertEquals(res.get("height").asInt(), H1);
	}
	
	@Before
	public void createObjects() {
		serializer = new OPJSONWriter();
	}

}
