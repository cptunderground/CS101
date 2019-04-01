class MandelbrotBenchmark {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Das Programm muss mit folgenden Parametern aufgerufen werden: \n");
            System.out.println("java MandelbrotBenchmark <int> Colorpalette <double> Faktor [<int> Anzahl Threads <booelan> Benchmark]");
        } else {
            int colPal = Integer.parseInt(args[0]);
            double fact = Double.parseDouble(args[1]);
            int threads = Integer.parseInt(args[2]);
            boolean benchmark = Boolean.parseBoolean(args[3]);

            Mandelbrot m1 = new Mandelbrot(colPal, fact, threads, benchmark);

            long start1 = System.currentTimeMillis();
            m1.show_mandelbrot(new Complex(-2.5, -1.3), 0.05 / fact, 1000, false, "Mandelbrot 1 : Regular"); // regular
            long end1 = System.currentTimeMillis();
            System.out.println("m1.show_mandelbrot_regular()...");
            System.out.println("Time taken: " + (end1 - start1) + "ms");


            long start2 = System.currentTimeMillis();
            m1.show_mandelbrot(new Complex(-2.5, -1.3), 0.05 / fact, 1000, true, "Mandelbrot 1 : Inplace");  // inplace
            long end2 = System.currentTimeMillis();
            System.out.println("m1.show_mandelbrot_inplace()...");
            System.out.println("Time taken: " + (end2 - start2) + "ms");



            Mandelbrot m2 = new Mandelbrot(colPal, fact, threads, benchmark);

            long start3 = System.currentTimeMillis();
            m2.show_mandelbrot(new Complex(-0.755, -0.1), 0.0002 / fact, 1000, false, "Mandelbrot 2 : Regular"); // regular
            long end3 = System.currentTimeMillis();
            System.out.println("m2.show_mandelbrot_regular()...");
            System.out.println("Time taken: " + (end3 - start3) + "ms");


            long start = System.currentTimeMillis();
            m2.show_mandelbrot(new Complex(-0.755, -0.1), 0.0002 / fact, 1000, true, "Mandelbrot 2 : Inplace");  // inplace
            long end = System.currentTimeMillis();
            System.out.println("m4.show_mandelbrot_inplace()...");
            System.out.println("Time taken: " + (end - start) + "ms");


        }
    }

}