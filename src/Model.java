import Polynomial.Polinom;

public class Model {
    private View v;
    private Polinom operand1 = new Polinom();
    private Polinom operand2 = new Polinom();
    private Polinom result1 = new Polinom();
    private Polinom result2 = new Polinom();

    public Model ( View v){
        this.v = v;
    }

    public void addition(String s1, String s2){
        operand1.crearePolinom(s1);
        operand2.crearePolinom(s2);
        result1.adunarePolinom(operand1, operand2);
        v.getRes1().setText(result1.toString());
    }

    public void subtraction(String s1, String s2){
        operand1.crearePolinom(s1);
        operand2.crearePolinom(s2);
        result1.scaderePolinom(operand1, operand2);
        v.getRes1().setText(result1.toString());
    }

    public void multiplication(String s1, String s2){
        operand1.crearePolinom(s1);
        operand2.crearePolinom(s2);
        result1.inmultirePolinom(operand1, operand2);
        v.getRes1().setText(result1.toString());
    }

    public void division(String s1, String s2){
        operand1.crearePolinom(s1);
        operand2.crearePolinom(s2);
        result1.impartirePolinom(operand1, operand2, result1, result2);
        v.getRes1().setText(result1.toString());
        v.getRes2().setText(result2.toString());
    }

    public void derivative(String s1){
        operand1.crearePolinom(s1);
        result1 = operand1.derivata();
        v.getRes1().setText(result1.toString());
    }

    public void integral(String s1){
        operand1.crearePolinom(s1);
        result1 = operand1.integrala();
        v.getRes1().setText(result1.toString());
    }
}
