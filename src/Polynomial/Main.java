package Polynomial;

public class Main {
    public static void main(String[] args){
        Polinom p1 = new Polinom();
        Polinom p2 = new Polinom();
        //p1.crearePolinom("7x^5+2-4x^2+5x^1-2x^5-5x^1-6x^3+2x^2+6");
        p1.crearePolinom("x^3-2x^2+6x^1-5");
        //p2.crearePolinom("3x^5+3x^3-4x^2+4x^1+2");
        p2.crearePolinom("x^2-1");

        Polinom p3 = new Polinom();
        p3.adunarePolinom(p1, p2);

        System.out.println("Adunare:");
        System.out.println(p3.toString());
        //assertTrue(p3.toString().equals("x^3-x^2+6x-6"));

        p3.scaderePolinom(p1, p2);
        System.out.println("Scadere");
        System.out.println(p3.toString());

        p3.inmultirePolinom(p1, p2);
        System.out.println("Inmultire");
        System.out.println(p3.toString());

        Polinom cat = new Polinom();
        Polinom rest = new Polinom();
        cat.impartirePolinom(p1, p2, cat, rest);
        System.out.println("Cat");
        System.out.println(cat.toString());
        System.out.println("Rest");
        System.out.println(rest.toString());

        Polinom deriv;
        deriv = p1.derivata();
        System.out.println("Derivata");
        System.out.println(deriv.toString());

        Polinom integral = p1.integrala();
        System.out.println("Integrala");
        System.out.println(integral.toString());
    }


}
