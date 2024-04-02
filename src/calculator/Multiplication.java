class Multiplication implements Operation {
    @Override
    public ComplexNumber operate(ComplexNumber num1, ComplexNumber num2) {
        double real = num1.getReal() * num2.getReal() - num1.getImaginary() * num2.getImaginary();
        double imaginary = num1.getReal() * num2.getImaginary() + num2.getReal() * num1.getImaginary();
        return new ComplexNumber(real, imaginary);
    }
}