package Lab4Part3;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormatSymbols;
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
        JTextArea localizedText = new JTextArea(7,30);
        localizedText.setEditable(false);
        locales.addActionListener(e -> {
            for(Locale locale : availableLocales){
                if(locale.getDisplayName().equals(locales.getSelectedItem().toString())){
                    localized(locale, localizedText);
                }}
    });
        panel.setLayout(new BorderLayout());
        panel.add(locales,BorderLayout.NORTH);
        panel.add(localizedText, BorderLayout.SOUTH);
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
        DateFormatSymbols localizedCalender = new DateFormatSymbols(locale);
        String[] localWeekdays = localizedCalender.getWeekdays();
        StringBuilder formattedLocalWeekDays = new StringBuilder();
        for(int increment = 1; increment < localWeekdays.length; increment++){
            formattedLocalWeekDays.append(localWeekdays[increment]).append("\n");
        }
        localizedText.setText(formattedLocalWeekDays.toString());

    }

    public static void main(String[] args) {
        new Lab4Part3();
    }
}
