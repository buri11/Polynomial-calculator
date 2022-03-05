import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private Model model;
    private View view;
    private String operation = "";

    public Controller(View v, Model m){
        view = v;
        model = m;

        view.getPlus().addActionListener(new AddListener());
        view.getMinus().addActionListener(new SubListener());
        view.getMultiplication().addActionListener(new MulListener());
        view.getDivision().addActionListener(new DivListener());
        view.getDerivative().addActionListener(new DervListener());
        view.getIntegral().addActionListener(new IntgListener());
        view.getCalculate().addActionListener(new CalcListener());
    }

    class AddListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            view.getOpTitle().setText("You have selected +");
            view.getLabelRes1().setText("Addition:");
            operation = "+";
            //daca nu este selectata impartirea, dar a fost inainte
            // si nici butonul de calculare nu a fost apasat
            //scoatem restul din view
            if ( view.getPanelIO().getComponentCount() == 8 ){
                JPanel panel = view.getPanelIO();
                panel.setLayout(new GridLayout(3,1));
                panel.remove(view.getLabelRes2());
                panel.remove(view.getRes2());
            }
            if ( view.getPanelIO().getComponentCount() <= 6 ){
                JPanel panel = view.getPanelIO();
                //daca operatia este oricare alta cu doi operanzi inafara de impartire
                //se adauga al doilea operand si se setaza layout-ul corespunzator
                panel.setLayout(new GridLayout(3,1));
                panel.add(view.getLabelPol2(),2);
                panel.add(view.getPol2(),3);
            }
            //daca nu este apasat butonul de calcul
            //se curata campurile rezultat de la calculele anterioare
            view.getRes1().setText("");
            view.getRes2().setText("");
            view.getFrame().pack();
        }
    }

    class SubListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            view.getOpTitle().setText("You have selected -");
            view.getLabelRes1().setText("Subtraction:");
            operation = "-";
            //daca nu este selectata impartirea, dar a fost inainte
            // si nici butonul de calculare nu a fost apasat
            //scoatem restul din view
            if ( view.getPanelIO().getComponentCount() == 8 ){
                JPanel panel = view.getPanelIO();
                panel.setLayout(new GridLayout(3,1));
                panel.remove(view.getLabelRes2());
                panel.remove(view.getRes2());
            }
            if ( view.getPanelIO().getComponentCount() <= 6 ){
                JPanel panel = view.getPanelIO();
                //daca operatia este oricare alta cu doi operanzi inafara de impartire
                //se adauga al doilea operand si se setaza layout-ul corespunzator
                panel.setLayout(new GridLayout(3,1));
                panel.add(view.getLabelPol2(),2);
                panel.add(view.getPol2(),3);
            }
            //daca nu este apasat butonul de calcul
            //se curata campurile rezultat de la calculele anterioare
            view.getRes1().setText("");
            view.getRes2().setText("");
            view.getFrame().pack();
        }
    }

    class MulListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            view.getOpTitle().setText("You have selected *");
            view.getLabelRes1().setText("Multiplication:");
            operation = "*";
            //daca nu este selectata impartirea, dar a fost inainte
            // si nici butonul de calculare nu a fost apasat
            //scoatem restul din view
            if ( view.getPanelIO().getComponentCount() == 8 ){
                JPanel panel = view.getPanelIO();
                panel.setLayout(new GridLayout(3,1));
                panel.remove(view.getLabelRes2());
                panel.remove(view.getRes2());
            }
            if ( view.getPanelIO().getComponentCount() <= 6 ){
                JPanel panel = view.getPanelIO();
                //daca operatia este oricare alta cu doi operanzi inafara de impartire
                //se adauga al doilea operand si se setaza layout-ul corespunzator
                panel.setLayout(new GridLayout(3,1));
                panel.add(view.getLabelPol2(),2);
                panel.add(view.getPol2(),3);
            }
            //daca nu este apasat butonul de calcul
            //se curata campurile rezultat de la calculele anterioare
            view.getRes1().setText("");
            view.getRes2().setText("");
            view.getFrame().pack();
        }
    }

    class DivListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            view.getOpTitle().setText("You have selected /");
            view.getLabelRes1().setText("Quotient:");
            operation = "/";
            if ( view.getPanelIO().getComponentCount() <= 6 ){
                JPanel panel = view.getPanelIO();
                panel.setLayout(new GridLayout(4,1));
                panel.add(view.getLabelRes2());
                panel.add(view.getRes2());
            }
            if ( view.getPanelIO().getComponentCount() <= 6 ){
                JPanel panel = view.getPanelIO();
                //daca operatia selectata este impartirea
                //si inainte nu exista al doilea operand acesta este aduagat
                //tinandu-se cont de layout, pentru o aliniere placuta
                panel.setLayout(new GridLayout(4,1));
                panel.add(view.getLabelPol2(),2);
                panel.add(view.getPol2(),3);
            }
            //daca nu este apasat butonul de calcul
            //se curata campurile rezultat de la calculele anterioare
            view.getRes1().setText("");
            view.getRes2().setText("");
            view.getFrame().pack();
        }
    }

    class DervListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            view.getOpTitle().setText("You have selected ∂");
            view.getLabelRes1().setText("Derivative:");
            operation = "'";
            JPanel panel = view.getPanelIO();
            panel.setLayout(new GridLayout(3,1));
            panel.remove(view.getLabelPol2());
            panel.remove(view.getPol2());
            //daca inainte a fost operatia de impartire si acum e selecata derivata sau integrala
            //scoatem din view si restul
            if ( view.getPanelIO().getComponentCount() == 6 ){
                panel.remove(view.getLabelRes2());
                panel.remove(view.getRes2());
                panel.setLayout(new GridLayout(2,1));
            }
            //daca nu este apasat butonul de calcul
            //se curata campurile rezultat de la calculele anterioare
            view.getRes1().setText("");
            view.getRes2().setText("");
            view.getFrame().pack();
        }
    }

    class IntgListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            view.getOpTitle().setText("You have selected ∫");
            view.getLabelRes1().setText("Integral:");
            operation = "∫";
            JPanel panel = view.getPanelIO();
            panel.setLayout(new GridLayout(3,1));
            panel.remove(view.getLabelPol2());
            panel.remove(view.getPol2());
            //daca inainte a fost operatia de impartire si acum e selecata derivata sau integrala
            //scoatem din view si restul
            if ( view.getPanelIO().getComponentCount() == 6 ){
                panel.remove(view.getLabelRes2());
                panel.remove(view.getRes2());
                panel.setLayout(new GridLayout(2,1));
            }
            //daca nu este apasat butonul de calcul
            //se curata campurile rezultat de la calculele anterioare
            view.getRes1().setText("");
            view.getRes2().setText("");
            view.getFrame().pack();
        }
    }

    class CalcListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (operation.equals("")){
                view.getOpTitle().setText("No operation selected!");
            }
            else{
                if (operation.equals("+")){
                    String op1 = view.getPol1().getText();
                    String op2 = view.getPol2().getText();
                    model.addition(op1, op2);
                }
                if (operation.equals("-")){
                    String op1 = view.getPol1().getText();
                    String op2 = view.getPol2().getText();
                    model.subtraction(op1, op2);
                }
                if (operation.equals("*")){
                    String op1 = view.getPol1().getText();
                    String op2 = view.getPol2().getText();
                    model.multiplication(op1, op2);
                }
                if (operation.equals("/")){
                    String op1 = view.getPol1().getText();
                    String op2 = view.getPol2().getText();
                    model.division(op1, op2);
                }
                if (operation.equals("'")){
                    String op1 = view.getPol1().getText();
                    model.derivative(op1);
                }
                if (operation.equals("∫")){
                    String op1 = view.getPol1().getText();
                    model.integral(op1);
                }
            }
            view.getFrame().pack();
        }
    }
}
