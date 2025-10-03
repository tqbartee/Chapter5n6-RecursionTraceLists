import javax.swing.*;
import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class RealTimeStackDisplay {
    private final Deque<String> stack;
    private final JFrame frame;
    private final JTextArea stackArea;

    public RealTimeStackDisplay() {
        this.stack = new ArrayDeque<>();
        this.frame = new JFrame("Java Stack Emulator with Stack Frames");

        // Display area
        this.stackArea = new JTextArea();
        this.stackArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
        this.stackArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(stackArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        // Ensure visible width for 140 characters
        stackArea.setColumns(140);
        stackArea.setRows(20);

        frame.add(scrollPane);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        stackWithDisplay();
    }

    public void stackWithDisplay() {
        refreshDisplay();
    }

    public void addLastToStack(String value) {
        stack.addLast(value);
        refreshDisplay();
    }

    public void removeLastFromStack() {
        if (!stack.isEmpty()) {
            stack.removeLast();
            refreshDisplay();
        } else {
            JOptionPane.showMessageDialog(frame,
                    "Stack is empty, cannot remove element.",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    private void refreshDisplay() {
        StringBuilder sb = new StringBuilder();
        if (stack.isEmpty()) {
            sb.append("[empty stack]");
        } else {
            // Print top at the top of the window
            Object[] arr = stack.toArray();
            for (int i = arr.length - 1; i >= 0; i--) {
                if (i == arr.length - 1) {
                    sb.append(arr[i]).append("   <-- TOP\n");
                } else {
                    sb.append(arr[i]).append("\n");
                }
            }
        }
        stackArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RealTimeStackDisplay display = new RealTimeStackDisplay();

            // Example workflow
            display.addLastToStack("First element - methodA()");
            display.addLastToStack("Second element - methodB()");
            display.addLastToStack("Third element - methodC()");

            // Remove later element (simulate runtime)
            new Timer(3000, e -> display.removeLastFromStack()).start();
        });
    }
}
