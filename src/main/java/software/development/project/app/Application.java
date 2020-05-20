package software.development.project.app;

import software.development.project.draw.Drawer;
import software.development.project.draw.SubjectDrawApi;
import software.development.project.draw.SubjectDrawApiImpl;
import software.development.project.models.Subject;
import software.development.project.parser.Parse;
import software.development.project.parser.Parser;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Application extends JPanel {
    static Double WIDTH = 1600.;
    static Double HEIGHT = 900.;

    Parse parse = new Parser();

    Subject subject = parse.parseFromCsvToSubject("./Module_overview_BWI_2020.csv");

    public static void main(String[] args) {

        Frame frame = new JFrame();
        frame.add(new Application());
        frame.setBounds(20, 20, WIDTH.intValue(), HEIGHT.intValue());
        frame.setVisible(true);

    }

    public void paint(Graphics g) {
        System.out.println("#");
        BufferedImage bi = new BufferedImage(WIDTH.intValue(), HEIGHT.intValue(), BufferedImage.TYPE_INT_ARGB);
        g = bi.createGraphics();

        g.setColor(Color.decode("#F2F2F2"));
        g.fillRect(0, 0, WIDTH.intValue(), HEIGHT.intValue());

        SubjectDrawApi subjectDrawApi = new SubjectDrawApiImpl(new Drawer(), g, HEIGHT, WIDTH);

        for (int i = 1; i <= 7; i++) {
            subjectDrawApi.drawSemester(i, subject.getModulesWithSameSemester(i), subject.getLegend());
        }
        subjectDrawApi.drawLegend(subject.getLegend());

        try {
            ImageIO.write(bi, "png", new File("./save.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
