import java.awt.Point;
public class ComplexNum
{
    double real, im;
    double Real ()
    {
	return real;
    }

    double Imaginary ()
    {
	return im;
    }


    double Modulus () //returns the magnitude/modulus of a compex number
    {
	return Math.sqrt(real * real + im * im);
    }


    double Argument () //returns the argument of a complex number in radians
    {
	if (im == 0 && real < 0)
	    return Math.PI;
	try
	{
	    return Math.atan (im / real);
	}
	catch (ArithmeticException e)
	{
	}
	if (real == 0 && im > 0)
	    return Math.PI / 2;
	else if (real == 0 && im < 0)
	    return 3 * Math.PI / 2;
	else
	    return 0;
    }


    ComplexNum conjugate () //returns the conjugate of a complex number
    {
	ComplexNum c = new ComplexNum ();
	c.real = real;
	c.im = -im;
	return c;
    }


    boolean equals (ComplexNum c) //compares two complex numbers and produces
    {//a boolean to identify whether or not they are equal
	if (c.real == real && im == c.im)
	    return true;
	return false;
    }


    ComplexNum sum (ComplexNum c)//adds two complex numbers together
    {
	ComplexNum z = new ComplexNum ();
	z.real = real + c.real;
	z.im = im + c.im;
	return z;
    }


    ComplexNum sum (ComplexNum[] array) //adds arbitrarily many complex nums 
    {//together
	if (array.length == 1)
	    return array [0];
	else if (array.length == 2)
	{
	    return array [0].sum (array [1]);
	}
	else
	{
	    ComplexNum[] array1 = new ComplexNum [array.length - 1];
	    for (int i = 0 ; i < array1.length ; i++)
		array1 [i] = array [i + 1];
	    return array [0].sum (array1);
	}
    }


    ComplexNum subtract (ComplexNum c)
    {
	ComplexNum z = new ComplexNum ();
	z.real = real - c.real;
	z.im = im - c.im;
	return z;
    }


    boolean real ()
    {
	if (im == 0)
	    return true;
	return false;
    }


    ComplexNum product (ComplexNum c)
    {
	double a = real * c.real - im * c.im;
	double b = im * c.real + real * c.im;
	ComplexNum z = new ComplexNum ();
	z.real = a;
	z.im = b;
	return z;
    }
}
