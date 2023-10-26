import javax.swing.*;

public class Tamagotchi {
    private String name;
    private int hunger;
    private int happiness;
    private boolean isAlive;

    private JLabel hungerLabel;
    private JLabel happinessLabel;
    private JButton feedButton;
    private JButton playButton;
    private JButton sleepButton;

    public Tamagotchi(String name) {
        this.name = name;
        this.hunger = 0;
        this.happiness = 0;
        this.isAlive = true;

        // Create the GUI components
        JFrame frame = new JFrame("Tamagotchi");
        JPanel panel = new JPanel();
        hungerLabel = new JLabel(name + "'s hunger: " + hunger);
        happinessLabel = new JLabel(name + "'s happiness: " + happiness);
        feedButton = new JButton("Feed");
        playButton = new JButton("Play");
        sleepButton = new JButton("Sleep");

        // Add action listeners to the buttons
        feedButton.addActionListener(e -> feed());
        playButton.addActionListener(e -> play());
        sleepButton.addActionListener(e -> sleep());

        // Add the components to the panel
        panel.add(hungerLabel);
        panel.add(happinessLabel);
        panel.add(feedButton);
        panel.add(playButton);
        panel.add(sleepButton);

        // Set up the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public void feed() {
        if (isAlive) {
            hunger--;
            happiness++;
            updateLabels();
            checkStatus();
        } else {
            JOptionPane.showMessageDialog(null, "Sorry, " + name + " is no longer alive.");
        }
    }

    public void play() {
        if (isAlive) {
            hunger++;
            happiness++;
            updateLabels();
            checkStatus();
        } else {
            JOptionPane.showMessageDialog(null, "Sorry, " + name + " is no longer alive.");
        }
    }

    public void sleep() {
        if (isAlive) {
            hunger++;
            happiness--;
            updateLabels();
            checkStatus();
        } else {
            JOptionPane.showMessageDialog(null, "Sorry, " + name + " is no longer alive.");
        }
    }

    private void checkStatus() {
        if (hunger > 5 || happiness < -5) {
            isAlive = false;
            JOptionPane.showMessageDialog(null, name + " has passed away. Game over.");
        }
    }

    private void updateLabels() {
        hungerLabel.setText(name + "'s hunger: " + hunger);
        happinessLabel.setText(name + "'s happiness: " + happiness);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            String name = JOptionPane.showInputDialog("Enter your Tamagotchi's name:");
            Tamagotchi tamagotchi = new Tamagotchi(name);
        });
    }
}
