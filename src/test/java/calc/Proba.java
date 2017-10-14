import calc.Calc;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;



public class Proba {
    Calc c = new Calc();

    @Test
     public void test1() throws ParseException {
       Assert.assertEquals(20.0,c.parse("1.0+3.0+16.0"));//"1+3+16" not working
        Assert.assertEquals(2.0,c.parse("10.0-8.0")); //"10-8" not working
        Assert.assertEquals("divide",5.0,c.parse("15/3"));//"15/3" not working

    }
    @Test
    public void Proba2() throws ParseException {
        Assert.assertEquals(3.0,c.parse("9.0/3.0"));
    }
    @Test
    public void Proba3() throws ParseException {
        Assert.assertEquals(15,c.parse("3*5"));
    }
    @Test
    public void Proba() throws ParseException {
        Assert.assertEquals(-20.0,c.parse("(-2)*(-5)+(-40)"));//the problem with brecets
        // output to the screen:  Given expression is not matching mathematical pattern: -2)*-5.0+(-40
    }
    @Test
    public void Proba1() throws ParseException {
        Assert.assertEquals(-20,c.parse("-40+20"));
    }
    @Test
    public void Proba4() throws ParseException {
        Assert.assertEquals(20,c.parse("(-40)+20-(-40)"));//(-40)+20-(-40)
        // String index out of range: -6 при решении Main
    }
    @Test
    public void Proba5() throws ParseException {
        Assert.assertEquals(5.0,c.parse("5.0"));
    }
    @Test
    public void Proba6(){
        Assert.assertEquals(24,c.plus(6,4,12,2));
    }
   
}
