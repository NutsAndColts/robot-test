/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nutsandcolts.miscellaneous;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.parsing.ISensor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Zach Kimberg
 */
public class Vision implements ISensor, PIDSource{
    
    private static double[] distances = new double[4];
    private static double[] widths = new double[4];
    private static double[] midx = new double[4];
    private static double[] aspect = new double[4];
    private static int count;
    private static double seperation;
    private static double wallDistance;
    
    /**
     * Load data from SmartDashboard to compute
     */
    private void load(){
        count = (int) SmartDashboard.getNumber("BLOB_COUNT");
        for(int i=0; i<count; i++){
            distances[i] = SmartDashboard.getNumber("Distance"+i);
            widths[i] = SmartDashboard.getNumber("WidthX"+i);
            midx[i] = SmartDashboard.getNumber("MidX"+i);
            aspect[i] = SmartDashboard.getNumber("Aspect"+i);
        }
    }
    
    /**
     * Returns only the strips that are vertically oriented
     * @return 
     */
    private int[] getVertical(){
        if(count<2) return new int[0];
        int numVertical = 0;
        for(int i=0; i<count; i++){
            if(aspect[i] > 1) numVertical++;
        }
        if(numVertical<2) return new int[0];
        int[] order = {1,2,3,4};
        sortVertical(order);
        int[] using = {order[0],order[1]};
        if(midx[using[0]] > midx[using[1]]){
            int[] r = {order[1],order[0]};
            return r;
        } else {
            return using;
        }
    }
    
    /**
     * ???
     * @param a 
     */
    private void sortVertical(int[] a){
        for(int i=0; i<a.length-1; i++){
            int maxPosition = i;
            for(int j=0; j<a.length; j++){
                if(aspect[a[j]] > aspect[a[maxPosition]]) maxPosition = j;
            }
            if(maxPosition!=i){
                int temp = a[i];
                a[i] = a[maxPosition];
                a[maxPosition] = temp;
            }
        }
    }
    
    /**
     * Basic power function
     * @param base
     * @param exponent
     * @return 
     */
    private double power(double base, int exponent){
        if(exponent == 1) return base;
        if(exponent%2==0){
            double sqrt = power(base,exponent/2);
            return sqrt*sqrt;
        } else {
            double a = power(base,(exponent-1)/2);
            double b = power(base, (exponent+1)/2);
            return a*b;
        }
    }
    
    /**
     * Computes wallDistance
     * @return 
     */
    public double findWallDistance(){
        load();
        int[] vertical = getVertical();
        if(vertical.length != 2) return 0.0;
        int left = vertical[0];
        int right = vertical[1];
        seperation = midx[right]-midx[left]-(widths[left]+widths[right])/2;
        
        double t1 = power(distances[left], 4);
        double t2 = 2*power(distances[left],2)*power(distances[right],2);
        double t3 = 2*power(distances[left],2)*power(seperation,2);
        double t4 = power(distances[right],4);
        double t5 = 2*power(distances[right],2)*power(seperation,2);
        double t6 = power(seperation,4);
        double sq = t1-t2-t3+t4-t5+t6;
        wallDistance = Math.abs(Math.sqrt(Math.abs(sq))/2.0*seperation);
        
        return wallDistance;
    }
    
    public double pidGet() {
        return findWallDistance();
    } 
    
}
