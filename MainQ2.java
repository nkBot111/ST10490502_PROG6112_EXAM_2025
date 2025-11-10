package java;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class MainQ2 extends JFrame {
    private static final int SALES_LIMIT = 500;

    private final JTextArea textArea = new JTextArea(8, 30);
    private final JLabel yearsProcessedLabel = new JLabel("Years Processed: 0");

    // sample data from the exam: rows=years, cols=[Microphone, Speakers, Mixing Desk]
    private final int[][] sampleData = {
            {300, 150, 700}, // year 1
            {250, 200, 600}  // year 2
    };

    private ProductSalesQ2 currentProductSales = null;

    public MainQ2() {
        super("Product Sales Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initUI();
        pack();
        setLocationRelativeTo(null);
    }

    private void initUI() {
        // Menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);

        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem loadItem = new JMenuItem("Load Product Data");
        JMenuItem saveItem = new JMenuItem("Save Product Data");
        JMenuItem clearItem = new JMenuItem("Clear");

        loadItem.addActionListener(e -> loadProductData());
        saveItem.addActionListener(e -> saveProductDataToFile());
        clearItem.addActionListener(e -> clearData());

        toolsMenu.add(loadItem);
        toolsMenu.add(saveItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);

        // Buttons
        JButton loadButton = new JButton("Load Product Data");
        JButton saveButton = new JButton("Save Product Data");
        loadButton.addActionListener(e -> loadProductData());
        saveButton.addActionListener(e -> saveProductDataToFile());

        JPanel topPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        topPanel.add(loadButton);
        topPanel.add(saveButton);

        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(scrollPane, BorderLayout.CENTER);
        bottomPanel.add(yearsProcessedLabel, BorderLayout.SOUTH);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout(8, 8));
        cp.add(topPanel, BorderLayout.NORTH);
        cp.add(bottomPanel, BorderLayout.CENTER);
    }

    private void loadProductData() {
        currentProductSales = new ProductSalesQ2(sampleData, SALES_LIMIT);
        displayResults(currentProductSales);
    }

    private void displayResults(ProductSalesQ2 ps) {
        if (ps == null) return;
        int total = ps.GetTotalSales();
        int avgRounded = (int) Math.round(ps.GetAverageSales());
        int over = ps.GetSalesOverLimit();
        int under = ps.GetSalesUnderLimit();
        int years = ps.GetProductsProcessed();

        StringBuilder sb = new StringBuilder();
        sb.append("Total Sales: ").append(total).append("\n");
        sb.append("Average Sales: ").append(avgRounded).append("\n");
        sb.append("Sales over limit: ").append(over).append("\n");
        sb.append("Sales under limit: ").append(under).append("\n");

        textArea.setText(sb.toString());
        yearsProcessedLabel.setText("Years Processed: " + years);
    }

    private void saveProductDataToFile() {
        if (currentProductSales == null) {
            JOptionPane.showMessageDialog(this, "No data loaded. Please load product data first.",
                    "No Data", JOptionPane.WARNING_MESSAGE);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("DATA LOG\n");
        sb.append("***************************\n");
        sb.append("Total Sales: ").append(currentProductSales.GetTotalSales()).append("\n");
        sb.append("Average Sales: ").append(Math.round(currentProductSales.GetAverageSales())).append("\n");
        sb.append("Sales over limit: ").append(currentProductSales.GetSalesOverLimit()).append("\n");
        sb.append("Sales under limit: ").append(currentProductSales.GetSalesUnderLimit()).append("\n");
        sb.append("***************************\n");

        try (FileWriter fw = new FileWriter("data.txt")) {
            fw.write(sb.toString());
            JOptionPane.showMessageDialog(this, "Saved to data.txt", "Saved", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearData() {
        currentProductSales = null;
        textArea.setText("");
        yearsProcessedLabel.setText("Years Processed: 0");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainQ2 app = new MainQ2();
            app.setVisible(true);
        });
    }
}
