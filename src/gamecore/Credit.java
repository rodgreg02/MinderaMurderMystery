package gamecore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Credit extends JPanel implements ActionListener {

        private static Timer timer;
        private static String introText = "Rodrigo - Lead developer, QA and just plain awesome\n\n\n\n\n\n\n\n\n\nPedro - Lead developer, Lead Writer and Creative Lead\n\n\n\n\n\n\n\n\n\nBruna - Lead developer, Assistant writer and Manager\n\n\n\n\n\n\n\n\n\nTiago - Lead developer, Lead Sound Designer and vibe setter\n\n\n\n\n\n\n\n\n\nChatGPT - Literally Everything\n\n\n\n\n\n\n\n\n\nSpecial thanks:\n\nMarco\nMarcos\nGisela\nPedro(not the lead dev)\nJesus Christ\nChatGPT\n\n\n\n\n\n\n\n\n\n\nInvestors:\nMarco\nRicardo\nFrancisco"; // Your text here
        private int textXCoordinate = 400; // Adjusted X position
        private int textYCoordinate = 600; // Starting from the bottom
        private int textSpeed = 2;
        private JTextArea textArea;
        private BufferedImage image; // The image to display
        private int imageXCoordinate = 500; // X position of the image
        private int imageYCoordinate = 100; // Y position of the image

        public Credit() {
            timer = new Timer(20, this);
            timer.start();

            textArea = new JTextArea(introText);
            textArea.setForeground(Color.WHITE);
            textArea.setBackground(Color.BLACK);
            textArea.setFont(new Font("Serif", Font.BOLD, 36));
            textArea.setEditable(false);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            add(textArea);

        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            textArea.setBounds(textXCoordinate, textYCoordinate, 1000, 50000);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            textYCoordinate -= textSpeed; // Move text upward
            repaint();


        }

        public static void playCredit() {
            JFrame frame = new JFrame("credit");
            frame.setBackground(Color.BLACK);
            Credit intro = new Credit();
            intro.setBackground(Color.BLACK);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1680, 1050);
            frame.add(intro);
            frame.setVisible(true);
        }
    }

