import java.util.Objects;
/* Die Komplexen Zahlen a+b i, mit (a+bi)+(c+di) = (a+c)+(b+d)i und (a+bi)(c+di) = (ac-bd)+(ad+bc)i */
class Complex {

  /* Definieren Sie hier die Daten der Klasse */
  double re;
  double im;

  /* Der Konstruktor */
  public Complex(double real, double imag) { 
    /* Implementieren */
    this.re = real;
    this.im = imag;
  }

  /* Zugriff auf den realen Anteil */
  public double real() 
  { 
  	return re;
  }

  /* Zugriff auf den imaginaeren Anteil */
  public double imag() 
  {
  	return im;
  }

  /* Multiplikation ohne Veraenderung der beteiligten Objekte */
  public Complex mult(Complex b) 
  {
  	double real = this.re * b.real() - this.im * b.imag();
  	double imag = this.re * b.real() + this.im * b.imag();
  	return new Complex(real, imag);
  }

  /* Multiplikation mit Veraenderung der beteiligten Objekte. Gibt this zurueck */
  public Complex mult_inplace(Complex b)
  {
  	double real = this.re * b.real() - this.im * b.imag();
  	double imag = this.re * b.real() + this.im * b.imag();
  	this.re=real;
  	this.im=imag;
  	return this;
  }

  /* Das Quadrat (c^2 = c*c) ohne Veraenderung der beteiligten Objekte */
  public Complex sqr() 
  {
  	double real = this.re * this.re - this.im * this.im;
  	double imag = this.re * this.im + this.re * this.im;
  	return new Complex(real,imag);
  }

  /* Das Quadrat (c^2 = c*c) in place. Veraendert das Objekt und gibt this zurueck. */
  public Complex sqr_inplace() 
  {
  	double real = this.re * this.re - this.im * this.im;
  	double imag = this.re * this.im + this.re * this.im;
  	this.re=real;
  	this.im=imag;
  	return this;
  }

  /* Das Quadrat des Betrags */
  public double abs_sqr() 
  {
  	double sq = this.re * this.re + this.im * this.im;
  	return sq;
  }

  /* Addition zweier komplexer Zahlen ohne Veraenderung der beteiligten Objekte */
  public Complex add(Complex c) 
  {
  	return new Complex(this.re + c.real(), this.im + c.imag());
  }

  /* Addition zweier komplexer Zahlen mit Veraenderung der beteiligten Objekte */
  public Complex add_inplace(Complex c) 
  {
  	this.re = this.re + c.real();
  	this.im = this.im + c.imag();
  	return this;
  }
}
