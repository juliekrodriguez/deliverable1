package deliverable1;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

import java.util.HashSet;


// pulling from semicheck, pushing to hash to count occ of the operands
//Halstead Length is the sum of the total number of operators and operand [1,2]
//Halstead Vocabulary is the sum of the number of unique operators and unique operands [1,2]
public class OperandCounter extends AbstractCheck {
    int opCounter = 0;

    @Override
    public int[] getDefaultTokens() {
        // TODO Auto-generated method stub
        return new int[] { TokenTypes.NUM_DOUBLE, TokenTypes.IDENT, TokenTypes.NUM_LONG, TokenTypes.NUM_FLOAT,
                TokenTypes.NUM_INT };
    }

    @Override
    public int[] getAcceptableTokens() {
        // TODO Auto-generated method stub
        return getDefaultTokens();
    }

    @Override
    public int[] getRequiredTokens() {
        // TODO Auto-generated method stub
        return getDefaultTokens();
    }

    @Override
    public void beginTree(DetailAST rootAST) {
        // this is just resetting everything so we begin new tree
        opCounter = 0;
    }

    @Override
    public void visitToken(DetailAST aAST) {
        opCounter++;
    }

    public int getCount() {
        return opCounter; // just returning count
    }

    // now you can finish the tree
    @Override
    public void finishTree(DetailAST rootAST) {
        log(rootAST.getLineNo(), "# of operand's: " + opCounter);
    }

}
