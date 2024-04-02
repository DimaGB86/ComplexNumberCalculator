class ComplexCalculator {
    private OperationFactory operationFactory;

    public ComplexCalculator() {
        this.operationFactory = new OperationFactory();
    }

    public ComplexNumber calculate(String operation, ComplexNumber num1, ComplexNumber num2) {
        Operation op = operationFactory.createOperation(operation);
        return op.operate(num1, num2);
    }
}
