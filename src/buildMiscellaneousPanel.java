import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
public class buildMiscellaneousPanel extends JPanel {
    private JPanel MiscellaneousPanel, selectedMisItemsPanel, CalculatorPanel;
    private JLabel label,totalLabel,spacer,taxLabel;
    private JButton button,totalButton;
    private JTextField text1;
    private JList<String> list, selectedItemsList;
    private JScrollPane scrollPane,scrollPane2;
    private String[] items ={"Grip Tape  $10","Bearings $30","Riser pads $2","Nuts & bolts kit $3"};
    private double[] itemPrice= {10.0,30.0,2.0,3.0};
    private final double tax = 0.06;
    private double deckPrice;
    private  double truckPrice;
    private double wheelPrice;
    public void setWheelPrice(double price) {
        this.wheelPrice= price;
    }
    public void setDeckPrice(double price){
        this.deckPrice= price;
    }
    public void setTruckPrice(double price){
        this.truckPrice= price;
    }
    public buildMiscellaneousPanel(){

        MiscellaneousPanel = new JPanel();

        setLayout(new BorderLayout());
        label = new JLabel("Miscellaneous     ");
        list = new JList<>(items);
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        list.setVisibleRowCount(6);
        scrollPane= new JScrollPane(list);

        MiscellaneousPanel.add(label);
        MiscellaneousPanel.add(scrollPane);

        calculator();
        itemsSelected();

        add(MiscellaneousPanel,BorderLayout.NORTH);
        add(selectedMisItemsPanel,BorderLayout.CENTER);
        add(CalculatorPanel,BorderLayout.SOUTH);
    }
    public  void itemsSelected(){
        selectedMisItemsPanel = new JPanel();
        button = new JButton("Get Selected items");
        button.addActionListener(new ButtonListener());

        selectedItemsList = new JList();
        selectedItemsList.setVisibleRowCount(4);
        scrollPane2 = new JScrollPane(selectedItemsList);

        selectedMisItemsPanel.add(scrollPane2);
        selectedMisItemsPanel.add(button);
    }
    private void calculator(){

        CalculatorPanel = new JPanel();
        CalculatorPanel.setLayout(new GridLayout(7,2));

        spacer =new JLabel();
        CalculatorPanel.add(spacer);

        totalButton = new JButton("Calculate total");
        totalButton.addActionListener(new ActionListener() {
            double sumTotal = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] selectedItems = list.getSelectedValuesList().toArray(new String[0]);
                selectedItemsList.setListData(selectedItems);

                double sumTotal = deckPrice+truckPrice+wheelPrice;

                for (int i = 0; i < selectedItems.length; i++) {
                    int index = Arrays.asList(items).indexOf(selectedItems[i]);
                    if (index != -1) {
                        sumTotal += itemPrice[index];
                    }
                }
                double taxes =(sumTotal*tax);
                totalLabel.setText(String.format("%.2f",sumTotal+taxes));
                text1.setText(String.valueOf(taxes));
            }
        });
        CalculatorPanel.add(totalButton);

        JLabel messageLabel= new JLabel("Total sales: ");
        taxLabel = new JLabel("Tax 6 %");
        text1 = new JTextField(15);
        text1.setEditable(false);

        totalLabel = new JLabel( );
        CalculatorPanel.add(taxLabel);
        CalculatorPanel.add(text1);
        CalculatorPanel.add(messageLabel);
        CalculatorPanel.add(totalLabel);
    }
    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
           selectedItemsList.setListData(list.getSelectedValuesList().toArray(new String[0]));
        }
    }
}
