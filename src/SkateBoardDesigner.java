import javax.swing.*;
public class SkateBoardDesigner extends JFrame {
    public SkateBoardDesigner(){
        setTitle("Skate board designer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,600);

        buildDecksPanel decksPanel = new buildDecksPanel();
        buildTruckPanel truckPanel = new buildTruckPanel();
        buildWheelPanel wheelPanel1 = new buildWheelPanel();
        buildMiscellaneousPanel miscellaneousPanel= new buildMiscellaneousPanel();

        setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
        add(decksPanel);
        add(truckPanel);
        add(wheelPanel1);
        add(miscellaneousPanel);

        pack();
        setVisible(true);
    }
    public static void main(String[] args) {

        new SkateBoardDesigner();
    }
}