import javax.swing.*;
import java.awt.*;

public class View {
    private JFrame frame = new JFrame("Polynomial Calculator");

    private JPanel panelIO = new JPanel();
    private JLabel labelPol1 = new JLabel ("First Polynomial");
    private JTextField pol1 = new JTextField(20);
    private JLabel labelPol2 = new JLabel ("Second Polynomial");
    private JTextField pol2 = new JTextField(20);
    private JLabel labelRes1 = new JLabel("Result");
    private JLabel res1 = new JLabel("");
    private JLabel labelRes2 = new JLabel("Remainder");
    private JLabel res2 = new JLabel();

    private JPanel operationTitle = new JPanel();
    private JLabel opTitle = new JLabel("Select operation");

    private JPanel operations = new JPanel();
    private JButton plus = new JButton("Addition");
    private JButton minus = new JButton("Subtraction");
    private JButton multiplication = new JButton("Multiplication");
    private JButton division = new JButton("Division");
    private JButton derivative = new JButton("Derivative");
    private JButton integral = new JButton("Integral");

    private JPanel calcButton = new JPanel();
    private JButton calculate = new JButton("Calculate!");

    private GridLayout layout31 = new GridLayout(3,1);
    private GridLayout layout41 = new GridLayout(4,1);

    private JPanel pGeneral = new JPanel();

    public View(){
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(450,250));
        frame.setLocationRelativeTo(null);

        panelIO.setLayout(layout31);

        panelIO.add(labelPol1);
        panelIO.add(pol1);

        panelIO.add(labelPol2);
        panelIO.add(pol2);


        panelIO.add(labelRes1);
        panelIO.add(res1);

        operationTitle.add(opTitle);

        operations.setLayout(new GridLayout(3,2));
        operations.add(plus);
        operations.add(minus);
        operations.add(multiplication);
        operations.add(division);
        operations.add(derivative);
        operations.add(integral);

        calcButton.add(calculate);

        pGeneral.add(panelIO);
        pGeneral.add(operationTitle);
        pGeneral.add(operations);
        pGeneral.add(calcButton);
        pGeneral.setLayout(new BoxLayout(pGeneral, BoxLayout.Y_AXIS));
        //pGeneral.setLayout(new GridLayout(4,1));

        frame.setContentPane(pGeneral);
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public JTextField getPol1() {
        return pol1;
    }

    public JLabel getLabelPol2() {
        return labelPol2;
    }

    public JTextField getPol2() {
        return pol2;
    }

    public JLabel getLabelRes1() {
        return labelRes1;
    }

    public JLabel getRes1() {
        return res1;
    }

    public JLabel getLabelRes2() {
        return labelRes2;
    }

    public JLabel getRes2() {
        return res2;
    }

    public JButton getPlus() {
        return plus;
    }

    public JButton getMinus() {
        return minus;
    }

    public JButton getMultiplication() {
        return multiplication;
    }

    public JButton getDivision() {
        return division;
    }

    public JButton getDerivative() {
        return derivative;
    }

    public JButton getIntegral() {
        return integral;
    }

    public JButton getCalculate() {
        return calculate;
    }

    public JLabel getOpTitle() {
        return opTitle;
    }

    public JPanel getPanelIO() {
        return panelIO;
    }
}
