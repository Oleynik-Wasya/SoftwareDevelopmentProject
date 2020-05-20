package software.development.project.draw;

import software.development.project.models.Legend;
import software.development.project.models.Module;

import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SubjectDrawApiImpl implements SubjectDrawApi {

    private Draw draw;
    private Graphics graphics;
    private Double margin;
    private Double screenHeight;
    private Double screenWidth;
    private Double blockHeight;
    private Double blockMinWidth;
    private int rows = 8;
    private int cols = 6;
    private int maxCreditPoint = 30;
    private int minCreditPoint = 5;
    private Double leftMargin;
    private Font defaultFont;
    private Font smallFont;
    private Double legendMargin;

    public SubjectDrawApiImpl(Draw draw, Graphics graphics, Double screenHeight, Double screenWidth) {
        this.margin = screenWidth / 100.;
        this.leftMargin = screenWidth / 40.;
        this.legendMargin = margin * 2;
        this.graphics = graphics;
        this.screenHeight = screenHeight;
        this.screenWidth = screenWidth;
        this.blockHeight = (screenHeight - margin * (rows + 1) - legendMargin) / rows;
        this.blockMinWidth = (screenWidth - margin * cols - leftMargin) / maxCreditPoint;
        System.out.println(screenHeight + " - " + margin + " * " + cols + " - " + legendMargin + " = " + ((screenWidth - margin * cols - leftMargin) / maxCreditPoint));
        this.draw = draw;
        this.defaultFont = new Font("Ubuntu", Font.PLAIN, (int) (blockHeight / 5));
        this.smallFont = new Font("Ubuntu", Font.BOLD, (int) (blockHeight / 6));
    }

    @Override
    public void drawSemester(int number, List<Module> modules, Legend legend) {
        FontMetrics metricsSmall = graphics.getFontMetrics(smallFont);
        Double range = leftMargin;
        String semester = "Semester " + number;

        Double rectY = margin + (blockHeight * (number - 1) + margin * (number - 1));
        System.out.println(metricsSmall.stringWidth(semester));

        draw.drawVerticalText(graphics, semester, smallFont, (int) (leftMargin / 2. + metricsSmall.getHeight() / 2), (int) ((rectY + blockHeight) - ((blockHeight - metricsSmall.stringWidth(semester)) / 2)), Color.gray);
        for (Module module : modules) {
            draw.drawBlock(graphics, module.getName(), defaultFont, new Rectangle(range.intValue(), rectY.intValue(), (int) (blockMinWidth * module.getCredits() + margin * (module.getCredits() / minCreditPoint - 1)), blockHeight.intValue()), Color.decode("#1B1B1B"), legend.getColor(module.getScience()));
            range += blockMinWidth * module.getCredits() + margin * module.getCredits() / minCreditPoint;
        }
    }

    @Override
    public void drawLegend(Legend legend) {
        FontMetrics metricsSmall = graphics.getFontMetrics(smallFont);
        Double range = leftMargin;
        Double rectY = blockHeight * (rows - 1) + margin * rows + legendMargin / 2;
        Double legendBlockWidth = (screenWidth - leftMargin - margin * legend.getSubjects().size()) / legend.getSubjects().size();

        draw.drawRect(graphics, new Rectangle(0, (int)(rectY - margin), screenWidth.intValue(), (int)(blockHeight + margin * 2)), Color.decode("#FFFFFF"), Color.decode("#DCDCDC"));
        draw.drawVerticalText(graphics, "Legend", smallFont, (int) (leftMargin / 2. + metricsSmall.getHeight() / 2), (int) ((rectY + blockHeight) - ((blockHeight - metricsSmall.stringWidth("Legend")) / 2)), Color.gray);
        for (Map.Entry<String, Color> entry : legend.getSubjects().entrySet()) {
            draw.drawBlock(graphics, entry.getKey(), defaultFont, new Rectangle(range.intValue(), rectY.intValue(), legendBlockWidth.intValue(), blockHeight.intValue()), Color.black, entry.getValue());
            range += legendBlockWidth + margin;
        }
    }
}
