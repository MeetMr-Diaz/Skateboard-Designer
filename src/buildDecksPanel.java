import javax.swing.*;
import java.awt.event.ItemEvent;
public class buildDecksPanel extends JPanel{
    private JPanel deckPanel;
    private JLabel deckLabel1;
    private JTextField priceText;
    private JComboBox deckComboBox;
    private String[] DecksItems ={"The Master Thrasher","The Dictator","The Street King"};
    private double[] itemPrice = {60.0,45.0,50.0};
    public buildDecksPanel() {
        deckPanel = new JPanel();
        deckLabel1 = new JLabel("Deck          ");
        priceText = new JTextField(15);
        priceText.setEditable(false);
        deckComboBox = new JComboBox(DecksItems);
        deckComboBox.addItemListener(new comboBoxListener());

        deckPanel.add(deckLabel1);
        deckPanel.add(deckComboBox);
        deckPanel.add(priceText);
        add(deckPanel);
    }
    private class comboBoxListener implements java.awt.event.ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            int itemIndex = deckComboBox.getSelectedIndex();
            double decksItemPrice = itemPrice[itemIndex];
            priceText.setText(String.valueOf(decksItemPrice));
            decksTotal(decksItemPrice);
        }
    }
    private double decksTotal(double price) {
        double deckPrice= price;
        buildMiscellaneousPanel miscPanel = (buildMiscellaneousPanel) getParent().getComponent(3);
        miscPanel.setDeckPrice(deckPrice);
        return deckPrice;
    }
}
