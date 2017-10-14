import calc.Calc;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;



public class Proba {
    Calc c = new Calc();

    @Test
     public void test1() throws ParseException {
       Assert.assertEquals(1,c.parse("1+1-1*1/(1-0)+-0"),0.1);// !!!
        // выражение 1+(1-1*1/1-0+0);  1+1-1*1/(1-0)+(-0);  тест не проходит
    }
    @Test
    public void test2() throws ParseException {
        Assert.assertEquals(1,c.parse("1+1-1*1/(1+-0)+-0"),0.1);//!!!!!!!!
    }
    @Test
    public void test3() throws ParseException {
        Assert.assertEquals(1,c.parse("1+1-1*1/(1+-0)--0"),0.1);//!!!!!!!!
        // 1+1-1*1/(1+-0)-+0 ne prohodit
    }
    @Test
    public void test4() throws ParseException {
        Assert.assertEquals(1,c.parse("1+1-1*1/1+(0+0)"),0.1);//!!!!!!!! Actual   :Infinity
    }
    @Test
    public void Proba1() throws ParseException {
        Assert.assertEquals(3.0,c.parse("9.0/3.0"),0.1);
    }
    @Test
    public void Proba2() throws ParseException {
        Assert.assertEquals(15,c.parse("3*5"),0.1);
    }
    @Test
    public void Proba3() throws ParseException {
        Assert.assertEquals(-20.0,c.parse("(-2)*(-5)+(-40)"),0.1);//the problem with brecets
        // output to the screen:  Given expression is not matching mathematical pattern: -2)*-5.0+(-40
    }
    @Test
    public void Proba4() throws ParseException {
        Assert.assertEquals(-20,c.parse("-40+20"),0.1);
    }
    @Test
    public void Proba5() throws ParseException {
        Assert.assertEquals(20,c.parse("(-40)+20-(-40)"),0.1);//(-40)+20-(-40)
        // String index out of range: -6 при решении Main
    }
    @Test
    public void Proba6() throws ParseException {
        Assert.assertEquals(5.0,c.parse("5.0"),0.1);
    }
    @Test
    public void Proba7(){
        Assert.assertEquals(24,c.plus(6,4,12,2),0.1);
    }

    @Test
    public void Poba8() throws ParseException {
        Assert.assertEquals(0,c.parse("0/0"),0.1);//test ne proiden NaN
    }
    @Test
    public void Probe9() throws ParseException {
        Assert.assertEquals(0,c.parse("-9223372036854775808-(-9223372036854775808)"),0.1);
    //Given expression is not matching mathematical pattern: -9223372036854775808--9.223372036854776E18
    }
    @Test
    public void Probe10() throws ParseException {
        Assert.assertEquals(0,c.parse("1.7e+308-(-1.7e+308)"),0.1);
        //Given expression is not matching mathematical pattern: -1.7e+308
    }


    @Test
    public void Probe11() throws ParseException {
        Assert.assertEquals(0,c.parse("0-0+1-1*1/1"),0.1);
    }
    @Test
    public void Probe12() throws ParseException {
        Assert.assertEquals(0,c.parse(" "),0.1);// ""   Expression string is empty

    }
    @Test
    public void Probe13() throws ParseException {
        Assert.assertEquals(0,c.parse("+0"),0.1); //-0 prohodit
        //Given expression is not matching mathematical pattern: +0

    }
    @Test
    public void Probe14() throws ParseException {
        Assert.assertEquals(0,c.parse("0    -"),0.1); //!!!
        //Given expression is not matching mathematical pattern: +0

    }
    @Test
    public void Probe15() throws ParseException {
        Assert.assertEquals(1,c.parse("(1)+(1)*(1)-(1)-(1)+(1)/(1)"),0.1);
        //Given expression is not matching mathematical pattern: 1)-1.0-(1

    }
    @Test
    public void Probe16() throws ParseException {
        Assert.assertEquals(-1,c.parse("1+1-1-1+1-1+1-1+1-1-1-1+1/1-1+1*1/1"),0.1);//!!! na calcul -1
        //Expected :-1.0    Actual   :1.0

    }
    @Test
    public void Probe17() throws ParseException {
        Assert.assertEquals(0.4,c.parse("0.1+0.1+0.1+0.1-0.1+0.1-0.1+0.1-0.1+0.1"),0.1);// !!!
       //vivod na consol 0.1
        // esli delta 1 test prohodit

    }
    @Test
    public void Probe18() throws ParseException {
        Assert.assertEquals(0.4,c.parse("0.1+.1+0.1+0.1-0.1+0.1-0.1+0.1-0.1+0.1"),0.1);// !!!
        // net odnogo nula(vtoroe chislo)
        //Expected :0.4   Actual :0.20000000000000004
        // esli delta 1 test prohodit
    }
    @Test
    public void Probe19() throws ParseException {
        Assert.assertEquals(0.4,c.parse(".1+0.1+0.1+0.1-0.1+0.1-0.1+0.1-0.1+0.1"),0.1);// !!!
        // net pervogo nula
        //Expected :0.4   Actual :0.0
        // esli delta 1 test prohodit
    }
    @Test
    public void Probe20() throws ParseException {
        Assert.assertEquals(0.4,c.parse("0.1+.1+.1+.1-.1+.1-.1+.1-.1+.1"),0.1);// !!!
        //net nuley
        //Expected :0.4   Actual :0.20000000000000004
        //esli delta 1 test prohodit

    }
    @Test
    public void Probe21() throws ParseException {
        Assert.assertEquals(0.4,c.parse("0.1+(0.1)+0.1+0.1-(0.1)+0.1-0(.1+0).1-0.1+0.1"),0.1);// !!!
        //java.lang.StringIndexOutOfBoundsException: String index out of range: -8

    }
    @Test
    public void Probe21_1() throws ParseException {
        Assert.assertEquals(0.4,c.parse("0.1+(0.1)+0.1+0.1-(0.1)+0.1-0(.1+0).1-0.1+0.1"),0.1);// !!!
        //java.text.ParseException: Given expression is not matching mathematical pattern: 0.1)+0.1+0.1-0.1+0.1-0(.1+0

    }
    @Test
    public void Probe22() throws ParseException {
        Assert.assertEquals(0.4,c.parse("0.1+0.1+0.1+0.1-0.1(+)0.1-0.1+0.1-0.1+0.1"),0.1);// !!!
        // plus v skobkah
        //Given expression is not matching mathematical pattern: +

    }
    @Test
    public void Probe23() throws ParseException {
        Assert.assertEquals(0.4,c.parse("0.1+0.1+0.1+0.1- -0.1+0.1-0.1+0.1-0.1+0.1"),0.1);// !!!
        //test prohodt s deltoi 0.1 toghe viragenie vishe no bez probela i minusa ne prohodilo
        //dva minusa i probel

    }
    @Test
    public void Probe24() throws ParseException {
        Assert.assertEquals(0.4,c.parse("0.1+0.1++0.1+0.1- -0.1+0.1-0.1+0.1-0.1+0.1"),0.1);// !!!
        //dva minusa i probel i dva plusa
        //java.text.ParseException: Given expression is not matching mathematical pattern: 0.1+0.1++0.1+0.1--0.1+0.1-0.1+0.1-0.1+0.1
    }
    @Test
    public void Probe25() throws ParseException {
        Assert.assertEquals(0.4,c.parse("0.1+0.1+-0.1+0.1- -0.1+0.1-0.1+0.1-0.1+0.1"),0.1);// !!!
        //dva minusa i probel i plus-minus
        //Expected :0.4  Actual   :-0.2
        //// esli delta 1 test prohodit
    }
    @Test
    public void Probe26() throws ParseException {
        Assert.assertEquals(1,c.parse("1/1/1/1/1     /1/1/1/1/1/1/1/1/1"),0.1);// !!!
        //s probelami prohodit

    }
    @Test
    public void Probe27() throws ParseException {
        Assert.assertEquals(1,c.parse("1.0/1.0/1.0/1.0/1     /1/1.0/1/1.     0/1/1.0/1/1.0/1"),0.1);// !!!
        //s probelami prohodit

    }
    @Test
    public void Probe28() throws ParseException {
        Assert.assertEquals(1,c.parse("1  .0/1 .0/1. 0/1.0 / 1     /1/1.0/1/1.     0/1/1.0/1/1.0/1"),0.1);
        // !!!
        //s probelami prohodit

    }

    @Test
    public void Probe29() throws ParseException {
        Assert.assertEquals(20,c.parse("5+ 15 + -5 +10    +5 -   10"),0.1);// !!!
        //s probelami prohodit
        //Expected :20.0    Actual   :-9.0

    }
    @Test
    public void Probe30() throws ParseException {
        Assert.assertEquals(20,c.parse("5+ -----15 + -5 +10    +5 -   10"),0.1);// !!!
        //java.text.ParseException: Given expression is not matching mathematical pattern: 5+-----15+-5+10+5-10
    }
    @Test
    public void Probe31() throws ParseException {
        Assert.assertEquals(20,c.parse("5+ -15 + -5 +10    +5 -   10"),0.1);// !!!
        //Expected :20.0 Actual   :-11.0
    }
    @Test
    public void Probe32() throws ParseException {
        Assert.assertEquals(20,c.parse("5+15+5+10+5-10"),0.1);// !!!
        //Expected :20.0 Actual :-110.0
    }






}
