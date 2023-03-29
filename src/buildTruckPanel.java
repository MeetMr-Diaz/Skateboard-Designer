import javax.swing.*;
import java.awt.event.ItemEvent;
public class buildTruckPanel extends JPanel {
    private JPanel truckAssembliesPanel;
    private JLabel truckLabel;
    private JTextField priceText;
    private JComboBox truckComboBox;
    private  String[] truckAssembliesItems = {"7.75-inch axle","8-inch axle","8.5-inch axle"};
    private  double[] itemsPrice= {35.0,40.0,45.0};
    public buildTruckPanel(){
        truckAssembliesPanel = new JPanel();
        truckLabel = new JLabel("Truck Assemblies");
        priceText = new JTextField(15);
        priceText.setEditable(false);
        truckComboBox = new JComboBox(truckAssembliesItems);
        truckComboBox.addItemListener(new comboBoxListener());

        truckAssembliesPanel.add(truckLabel);
        truckAssembliesPanel.add(truckComboBox);
        truckAssembliesPanel.add(priceText);
        add(truckAssembliesPanel);

    }
    private class comboBoxListener implements java.awt.event.ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            int selectedItemIndex = truckComboBox.getSelectedIndex();
            double wheelAccPrice = itemsPrice[selectedItemIndex];
            priceText.setText(String.valueOf(wheelAccPrice));

            double truckTotal = truckTotalPrice(wheelAccPrice);
            // Update total with truck wheelAccPrice
            buildMiscellaneousPanel miscPanel = (buildMiscellaneousPanel) getParent().getComponent(3);
            miscPanel.setTruckPrice(truckTotal);
        }
    }
    private double truckTotalPrice(double price){
        double truckPrice = price;
        return truckPrice;
    }
}
