import javax.swing.*;
import java.awt.event.ItemEvent;
public class buildWheelPanel extends JPanel {
    private JPanel wheelPanel;
    private  JLabel wheelLabel;
    private  JTextField wheelTextFieldPrice;
    private JComboBox wheelComboBox;
    private String[] Wheels = {"51 mm","55 mm","58 mm","61 mm"};
    private double[] itemPrice= {20.0,22.0,24.0,28};

    public buildWheelPanel(){
        wheelPanel = new JPanel();
        wheelLabel = new JLabel("Wheels                                 ");

        wheelTextFieldPrice = new JTextField(15);
        wheelTextFieldPrice.setEditable(false);
        wheelComboBox = new JComboBox(Wheels);
        wheelComboBox.addItemListener(new comboBoxListener());

        wheelPanel.add(wheelLabel);
        wheelPanel.add(wheelComboBox);
        wheelPanel.add(wheelTextFieldPrice);
        add(wheelPanel);
    }
    private class comboBoxListener implements java.awt.event.ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            int selectedIndex = wheelComboBox.getSelectedIndex();
            double price = itemPrice[selectedIndex];
            wheelTextFieldPrice.setText(String.valueOf(price));

            double wheelPrice = wheelTotal(price);
            // Update total with truck price
            buildMiscellaneousPanel miscPanel = (buildMiscellaneousPanel) getParent().getComponent(3);
            miscPanel.setWheelPrice(wheelPrice);
        }
    }
    private double wheelTotal(double price){
        double wheelPrice = price;
        return wheelPrice;
    }
}
