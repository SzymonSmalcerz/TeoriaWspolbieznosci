package com.smalcerz.TW05vol2;

import javax.swing.JFrame;

import org.math.plot.Plot2DPanel;
import org.math.plot.Plot3DPanel;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        double[] x = {1,2,3,4,3};
        double[] y = {1,2,3,4,5};
        double[] z = {1,2,3,4,5};
        		 
        // create your PlotPanel (you can use it as a JPanel)
        Plot2DPanel plot = new Plot2DPanel();
        
        Plot3DPanel plot3d = new Plot3DPanel();
        
        		 
        		  // add a line plot to the PlotPanel
        plot.addLinePlot("my plot", x, y);
        plot3d.addLinePlot("lol", x, y, z);
        		 
        		  // put the PlotPanel in a JFrame, as a JPanel
        JFrame frame = new JFrame("a plot panel");
        frame.setContentPane(plot3d);
        frame.setVisible(true);
    }
}
