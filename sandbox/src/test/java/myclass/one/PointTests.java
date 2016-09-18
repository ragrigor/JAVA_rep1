package myclass.one;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Радочка on 18.09.2016.
 */
public class PointTests {

    @Test
    public void testDistance() {
        Point p1 = new Point(11,12);
        Point p2 = new Point(22,24);
        Assert.assertEquals(p1.distance(p1,p2), 16.278820596099706);

        Point p3 = new Point(1,2);
        Point p4 = new Point(7,6);
        Assert.assertEquals(p1.distance(p3,p4),7.211102550927978);

    }




}
