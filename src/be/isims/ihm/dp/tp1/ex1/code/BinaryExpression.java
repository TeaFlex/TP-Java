package be.isims.ihm.dp.tp1.ex1.code;

public class BinaryExpression extends Operation {
    private Operation leftValue;
    private Operation rightValue;

    public BinaryExpression(Operation left, Operation right) {
        leftValue = left;
        rightValue = right;
        this.calculateResult("+");
    }

    public BinaryExpression(Operation left, Operation right, String op) {
        operation = op;
        leftValue = left;
        rightValue = right;
        this.calculateResult(op);
    }

    public void calculateResult(String op) {
        switch (op) {
            case "*":
                this.result = leftValue.result * rightValue.result;
                break;
            case "-":
                this.result = leftValue.result - rightValue.result;
                break;
            case "/":
                this.result = leftValue.result / rightValue.result;
                break;
            case "+":
            default:
                this.operation = "+";
                this.result = leftValue.result + rightValue.result;
                break;
        }
    }

    public String toString() {
        return "("+this.result + " = " +leftValue+" "+this.operation+" "+this.rightValue+")";
    }
}
