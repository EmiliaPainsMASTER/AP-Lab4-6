package Lab4Part3;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Locale;

public class Lab4Part3 extends JFrame {
    public Lab4Part3(){
        Container contentPane = getContentPane();
        JPanel panel = getJPanel();
        contentPane.add(panel);
        settings();
    }

    private JPanel getJPanel() {
        JPanel panel = new JPanel();
        Locale[] availableLocales = Locale.getAvailableLocales();
        String[] localities = getStrings(availableLocales);
        JComboBox<String> locales = new JComboBox<>(localities);
        JTextArea localizedText = new JTextArea();
        localizedText.setEditable(false);
        locales.addActionListener(e -> {
        String selectedLocale = locales.getSelectedItem().toString();
            for(Locale locale : availableLocales){
                if(locale.getDisplayName().equals(selectedLocale)){
                    localized(locale, localizedText);
                }}
    });
        panel.add(locales);
        panel.add(localizedText);
        return panel;
    }

    private static String[] getStrings(Locale[] availableLocales) {
        String[] localities = new String[availableLocales.length];
        for(int i = 0; i < availableLocales.length; i++){
            localities[i] = availableLocales[i].getDisplayName();
        }
        Arrays.sort(localities);
        return localities;
    }

    public void settings() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(300, 300);
        setResizable(false);
        setSize(800, 600);
        setVisible(true);
    }
    public void localized(Locale locale,JTextArea localizedText){
        setTitle(locale.getDisplayName());

    }

    public static void main(String[] args) {
        new Lab4Part3();
    }
}
