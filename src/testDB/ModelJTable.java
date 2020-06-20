package testDB;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ModelJTable extends JFrame {
  private DefaultTableModel model;

  private JTable table;

  public ModelJTable() {
    super();
    model = new DefaultTableModel();
    model.addColumn("First Name");
    model.addColumn("Last Name");
    model.addColumn("Years");

    String[] socrates = { "Socrates", "", "469-399 B.C." };
    model.addRow(socrates);

    String[] plato = { "Plato", "", "428-347 B.C." };
    model.addRow(plato);

    String[] aquinas = { "Thomas", "Aquinas", "1225-1274" };
    model.addRow(aquinas);

    String[] kierkegaard = { "Soren", "Kierkegaard", "1813-1855" };
    model.addRow(kierkegaard);

    String[] kant = { "Immanuel", "Kant", "1724-1804" };
    model.addRow(kant);

    String[] nietzsche = { "Friedrich", "Nietzsche", "1844-1900" };
    model.addRow(nietzsche);

    String[] arendt = { "Hannah", "Arendt", "1906-1975" };
    model.addRow(arendt);

    table = new JTable(model);

    JButton addButton = new JButton("Add Philosopher");
    addButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent event) {
        String[] philosopher = { "", "", "" };
        model.addRow(philosopher);
      }
    });

    JButton removeButton = new JButton("Remove Selected Philosopher");

    removeButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent event) {
        model.removeRow(table.getSelectedRow());
      }
    });
    JPanel inputPanel = new JPanel();
    inputPanel.add(addButton);
    inputPanel.add(removeButton);

    Container container = getContentPane();
    container.add(new JScrollPane(table), BorderLayout.CENTER);
    container.add(inputPanel, BorderLayout.NORTH);

    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(400, 300);
    setVisible(true);
  } 
  public static void main(String args[]) {
    new ModelJTable();
  }
}
           
         
  








