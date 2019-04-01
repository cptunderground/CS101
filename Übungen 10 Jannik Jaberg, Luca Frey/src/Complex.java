/* Die Komplexen Zahlen a+b i, mit (a+bi)+(c+di) = (a+c)+(b+d)i und (a+bi)(c+di) = (ac-bd)+(ad+bc)i */
class Complex {

  /* Definieren Sie hier die Daten der Klasse */
  double real;
  double imag;

  /* Der Konstruktor */
  public Complex(double a, double b) { 
    /* Implementieren */
    this.real = a;
    this.imag = b;
  }

  /* Zugriff auf den realen Anteil */
  public double real() {
    return this.real;
  }

  /* Zugriff auf den imaginaeren Anteil */
  public double imag() {
    return this.imag;
  }

  /* Multiplikation ohne Veraenderung der beteiligten Objekte */
  public Complex mult(Complex c) {
    double newReal = this.real()*c.real() - this.imag()*c.imag();
    double newImag = this.imag()*c.real() + this.real() * c.imag();
    return new Complex(newReal, newImag);
  }

  /* Multiplikation mit Veraenderung der beteiligten Objekte. Gibt this zurueck */
  public Complex mult_inplace(Complex c) {
    double real = this.real() * c.real() - this.imag() * c.imag();
    double imag = this.imag() * c.real() + this.real() * c.imag();
    this.real = real;
    this.imag = imag;
	  return this; 
  }

  /* Das Quadrat (c^2 = c*c) ohne Veraenderung der beteiligten Objekte */
  public Complex sqr() {
    return mult(new Complex(this.real(), this.imag()));
  }

  /* Das Quadrat (c^2 = c*c) in place. Veraendert das Objekt und gibt this zurueck. */
  public Complex sqr_inplace() {
    return mult_inplace(this);
  }

  /* Das Quadrat des Betrags */
  public double abs_sqr() {
   // return (Math.sqrt(Math.pow(this.real(), 2)) + Math.pow(this.imag(), 2));
   double sqrt = ((this.real()*this.real()) + (this.imag()*this.imag()));
   return sqrt;
  }

  /* Addition zweier komplexer Zahlen ohne Veraenderung der beteiligten Objekte */
  public Complex add(Complex c) {
    double newReal = this.real() + c.real();
    double newImag = this.imag() + c.imag();
    return new Complex(newReal, newImag);
  }

  /* Addition zweier komplexer Zahlen mit Veraenderung der beteiligten Objekte */
  public Complex add_inplace(Complex c) {
    this.real = this.real() + c.real();
    this.imag = this.imag() + c.imag();
	return this; 
  }
}
