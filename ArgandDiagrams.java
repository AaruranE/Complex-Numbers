// The "ArgandDiagrams" class.
import hsa.*;
import java.awt.*;
import java.awt.geom.*;

public class ArgandDiagrams extends ComplexNum
{
    Console c;

    public void main (String[] args)
    {
	c = new Console ();
	ComplexNum ZERO = new ComplexNum ();
	ZERO.real = 0;
	ZERO.im = 0;
	c.print ("Enter a complex number, with components between -3 and 3");

	c.print ("Enter the real component: ");
	ComplexNum z = new ComplexNum ();
	z.real = c.readDouble ();
	c.print ("Enter the imaginary component (in terms of i): ");
	z.im = c.readDouble ();
	c.clear ();
	createAxes ();
	c.setColor (Color.blue);
	drawVector (ZERO, z);
    } // main method


    public void drawVector (ComplexNum tip, ComplexNum tail)
    {
	//this code draws the body of the vector
	drawLine(tip,Tail);
	
	
	//this code draws the arrowhead
	double theta = (tail.subtract (tip)).Argument ();

    }


    public void createAxes ()
    {
	ComplexNum a = new ComplexNum ();
	a.real = 3;
	a.im = 0;
	ComplexNum b = new ComplexNum ();
	b.real = -3;
	b.im = 0;

	c.drawLine (transformX (a), transformY (a), transformX (b), transformY (b));

	a.real = 0;
	a.im = 3;
	b.real = 0;
	b.im = -3;
	drawLine (a, b);

	for (int i = -3 ; i <= 3 ; i++)
	{
	    a.real = i;
	    b.real = i;
	    a.im = -0.1;
	    b.im = 0.1;
	    drawLine (a, b);
	    a.real = 0.1;
	    b.real = -0.1;
	    a.im = i;
	    b.im = i;
	    drawLine (a, b);
	}
    }


    public void drawLine (ComplexNum a, ComplexNum b)
    {
	c.drawLine (transformX (a), transformY (a), transformX (b), transformY (b));
    } //this code draws a line segment from one complex number tip, to another complex number tail
    //in the complex plane


    public int transformX (ComplexNum z)
    {
	return (int) ((z.real) * 55 + 300);
    }


    public int transformY (ComplexNum z)
    {
	return (int) (250 - (z.im * 55));

    }
} // ArgandDiagrams class
