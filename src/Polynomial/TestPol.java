package Polynomial;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestPol {

    @Test
    public void TestPol(){
        Polinom p1 = new Polinom();
        Polinom p2 = new Polinom();

        p1.crearePolinom("x^3-2x^2+6x^1-5");
        p2.crearePolinom("x^2-1");

        Polinom p3 = new Polinom();
        p3.adunarePolinom(p1, p2);
        assertTrue(p3.toString().equals("x^3-x^2+6x-6"));

        p3.scaderePolinom(p1, p2);
        assertTrue(p3.toString().equals("x^3-3x^2+6x-4"));

        p3.inmultirePolinom(p1, p2);
        assertTrue(p3.toString().equals("x^5-2x^4+5x^3-3x^2-6x+5"));

        Polinom cat = new Polinom();
        Polinom rest = new Polinom();
        cat.impartirePolinom(p1, p2, cat, rest);
        assertTrue(cat.toString().equals("x-2"));
        assertTrue(rest.toString().equals("7x-7"));

        Polinom deriv;
        deriv = p1.derivata();
        assertTrue(deriv.toString().equals("3x^2-4x+6"));

        Polinom integral = p1.integrala();
        assertTrue(integral.toString().equals("0.25x^4-0.67x^3+3x^2-5x+C"));
    }
}
