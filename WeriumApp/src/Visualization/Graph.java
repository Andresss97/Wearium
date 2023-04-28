/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Visualization;

import java.awt.Dimension;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import static org.jfree.ui.RefineryUtilities.centerFrameOnScreen;

/**
 *
 * @author andre
 */
public class Graph {
    private XYSeriesCollection dataset;
    public Graph() {
        this.dataset = new XYSeriesCollection();
    }
    
    public void createGraph(ArrayList<Float> times, ArrayList<Float> ids, float b, float a, float r) {
        
        XYSeries series = new XYSeries("Fitts study");
        XYSeries line = new XYSeries("Equation line");
        
        float [] t = this.convertListToArray(times);
        float [] is = this.convertListToArray(ids);
        
        for(int i = 0; i < times.size(); i++) {
            series.add(is[i],t[i]);
        }
        
        for(int i = 0 ; i < times.size(); i++) {
            double idValue = a+b*i;
            
            line.add(i,idValue);
        }
        dataset.addSeries(series);
        dataset.addSeries(line);
        
        XYLineAndShapeRenderer sh = new XYLineAndShapeRenderer();
        
        sh.setSeriesLinesVisible(0, false);
        sh.setSeriesLinesVisible(1, true);
        
        sh.setSeriesShapesVisible(0, true);
        sh.setSeriesShapesVisible(1, false);
        
        JFreeChart plot = ChartFactory.createXYLineChart("y = "+a+" + " + b +"*x  " + "r = " +r + " TP = " + (1/b)*1000, "IDs (bits)", "Time (ms)", dataset);
        
        plot.getXYPlot().setRenderer(sh);
        
        ChartFrame chart = new ChartFrame("Results", plot);
        chart.setSize(new Dimension(530,370));
        centerFrameOnScreen(chart);
        chart.setVisible(true);
    }
    
    private float[] convertListToArray(ArrayList<Float> l) {
        float [] a = new float[l.size()];
        for(int i = 0; i <l.size(); i++) {
            a[i] = l.get(i);
        }
        
        return a;
    }
}
