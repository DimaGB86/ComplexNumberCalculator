class OperationFactory {

    public Operation createOperation(String operation) {
        switch (operation) {
            case "+":
                return new Addition();
            case "*":
                return new Multiplication();
            case "/":
                return new Division();
            default:
                throw new IllegalArgumentException("Неподдерживаемая операция");
        }
    }
}
