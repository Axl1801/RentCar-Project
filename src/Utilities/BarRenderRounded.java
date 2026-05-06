package Utilities;

import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.data.category.CategoryDataset;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.geom.Rectangle2D;

public class BarRenderRounded extends BarRenderer {

    private final int radius;

    public BarRenderRounded(int radius) {
        this.radius = radius;
        setBarPainter(new StandardBarPainter());
        setShadowVisible(false);
    }

    @Override
    public void drawItem(Graphics2D g2,
                         CategoryItemRendererState state,
                         Rectangle2D dataArea,
                         CategoryPlot plot,
                         CategoryAxis domainAxis,
                         ValueAxis rangeAxis,
                         CategoryDataset dataset,
                         int row,
                         int column,
                         int pass) {

        Number value = dataset.getValue(row, column);
        if (value == null) return;

        double java2DValue = rangeAxis.valueToJava2D(
                value.doubleValue(),
                dataArea,
                plot.getRangeAxisEdge()
        );

        double barW = state.getBarWidth();

        double categoryStart = domainAxis.getCategoryStart(
                column,
                getColumnCount(),
                dataArea,
                plot.getDomainAxisEdge()
        );

        double categoryEnd = domainAxis.getCategoryEnd(
                column,
                getColumnCount(),
                dataArea,
                plot.getDomainAxisEdge()
        );

        // Centrar la barra dentro de la categoría
        double x = categoryStart + (categoryEnd - categoryStart - barW) / 2;

        double y = Math.min(java2DValue,
                rangeAxis.valueToJava2D(0.0, dataArea, plot.getRangeAxisEdge()));

        double height = Math.abs(
                rangeAxis.valueToJava2D(0.0, dataArea, plot.getRangeAxisEdge()) - java2DValue
        );

        // 🔥 Barra redondeada real
        RoundRectangle2D bar = new RoundRectangle2D.Double(
                x,
                y,
                barW,
                height,
                radius,
                radius
        );

        g2.setPaint(getItemPaint(row, column));
        g2.fill(bar);
    }
}