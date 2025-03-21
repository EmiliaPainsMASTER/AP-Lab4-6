package Lab4Part1;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class EverydayObjectSoundGUI extends JFrame {
    public EverydayObjectSoundGUI() {
        Container c = getContentPane();
        c.setLayout(new GridLayout(1,3));

        JLabel title = new JLabel("Everyday Object Sound");
        JLabel imageLabel = new JLabel();
        JPanel buttonPanel = makeButtonPanel(new JPanel(), new JButton(), new JButton(), new JButton(), title, imageLabel);

        c.add(buttonPanel);
        c.add(imageLabel);
        c.add(title);
        settings();
    }
    private void playAudio(File file) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(file.toURI().toURL());
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();

    }

    private JPanel makeButtonPanel(JPanel panel, JButton soundOneButton, JButton soundTwoButton, JButton soundThreeButton, JLabel title, JLabel imageLabel) {
        panel.setLayout(new GridLayout(3, 1));
        soundOneButton.setText("Sound One");
        soundTwoButton.setText("Sound Two");
        soundThreeButton.setText("Sound Three");
        soundOneButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                File soundOne = new File("Lab4Part1/Lab4Part1/MONKEY_1.wav");
                try {
                    playAudio(soundOne);
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                    e.printStackTrace();
                }
                title.setText("Hail DONDUS!");
                imageLabel.setIcon(new ImageIcon("Lab4Part1/Lab4Part1/dondus.png"));
            }
        });
        soundTwoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                File soundTwo = new File("Lab4Part1/Lab4Part1/bottle-open.wav");
                try {
                    playAudio(soundTwo);
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                    e.printStackTrace();
                }
                title.setText("Sound Two 'Bottle Open' Pressed");
                imageLabel.setIcon(new ImageIcon("Lab4Part1/Lab4Part1/bottleOpen.png"));
            }
        });
        soundThreeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                File soundThree = new File("Lab4Part1/Lab4Part1/Imperial-March-Star-Wars.wav");
                try {
                    playAudio(soundThree);
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                    e.printStackTrace();
                }
                title.setText("Sound Three 'MARCH' pressed");
                imageLabel.setIcon(new ImageIcon("Lab4Part1/Lab4Part1/march.png"));
            }
        });
        panel.add(soundOneButton);
        panel.add(soundTwoButton);
        panel.add(soundThreeButton);

        return panel;
    }

    public void settings() {
        setTitle("Everyday Object Sound GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(300, 300);
        setResizable(false);
        setSize(800, 600);
        setVisible(true);
    }

    public static void main(String[] args) {
        new EverydayObjectSoundGUI();
    }
}
