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
        float [] t = this.convertListToArray(times);
        float [] is = this.convertListToArray(ids);
        
        for(int i = 0; i < times.size(); i++) {
            series.add(is[i],t[i]);
        }
        
        dataset.addSeries(series);
        
        JFreeChart scatterPlot = ChartFactory.createScatterPlot("Fitts Law", "IDs (bits)", "MT (ms)", dataset);
        
        ChartFrame chart = new ChartFrame("Results", scatterPlot);
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
