package com.mycompany.fileminiproject;

import java.io.Serializable;

public class student implements Serializable
{   
    public int roll;
    public String name;
    public double marks;
    
    public student()
    {
    
    }
    
    student(int roll, String name,double marks)
    {
        this.roll = roll;
        this.name = name;
        this.marks = marks;
    }
    
    int getRoll()
    {
       return roll; 
    }
    
    void setRoll(int roll)
    {
           this.roll = roll;
    }
    
    String getName()
    {
        return name;
    }
    
    void setName(String name)
    {
        this.name = name;
    }
    
    double getMarks()
    {
        return marks;
    }
    
    void setMarks(double marks)
    {
        this.marks = marks;
    }
    
}
