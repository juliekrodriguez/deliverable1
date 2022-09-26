package deliverable1;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import java.util.ArrayList;
// Halstead Length is the sum of the total number of operators and operand [1,2]

public class HalsteadLength extends AbstractCheck {

    int hLength = 0;

    // operands
    private OperandCounter operandCounter = new OperandCounter();
    private ArrayList<Integer> operandTokens = arrayList(operandCounter.getDefaultTokens());

    // operator
    private OperatorCounter operatorCounter = new OperatorCounter();
    private ArrayList<Integer> operatorTokens = arrayList(operatorCounter.getDefaultTokens());

    @Override
    public void beginTree(DetailAST rootAST) {
        operandCounter.beginTree(rootAST);
        operatorCounter.beginTree(rootAST);
    }

    // converting from the array to a list
    private ArrayList<Integer> arrayList(int[] arr) {
        ArrayList<Integer> newList = new ArrayList<Integer>();
        for (int i : arr) {
            newList.add(i);
        }
        return newList;
    }

    @Override
    public void visitToken(DetailAST ast) {
        if (operandTokens.contains(ast.getType())) {
            operandCounter.visitToken(ast);
        }
        if (operatorTokens.contains(ast.getType())) {
            operatorCounter.visitToken(ast);
        }
    }

    @Override
    public void finishTree(DetailAST rootAST) {
        hLength = getOperandCount() + getOperatorCount();
        log(rootAST.getLineNo(), "Halstead Length: " + hLength);
    }

    // getting counters set up
    public int getOperatorCount() {
        return operatorCounter.getCount();
    }

    public int getOperandCount() {
        return operandCounter.getCount();
    }

    @Override
    public int[] getDefaultTokens() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int[] getAcceptableTokens() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int[] getRequiredTokens() {
        // TODO Auto-generated method stub
        return null;
    }

}
