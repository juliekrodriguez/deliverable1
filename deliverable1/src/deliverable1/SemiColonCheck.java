package deliverable1;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

// in class example of semi colon operand
public class SemiColonCheck extends AbstractCheck {
    int counter = 0;

    @Override
    public int[] getDefaultTokens() {
        // TODO Auto-generated method stub
        return new int[] { TokenTypes.SEMI };
    }

    @Override
    public int[] getAcceptableTokens() {
        // TODO Auto-generated method stub
        return new int[] { TokenTypes.SEMI }; // new int token type
    }

    @Override
    public int[] getRequiredTokens() {
        // TODO Auto-generated method stub -
        return new int[] { TokenTypes.SEMI };
    }

    // when we see the semi or something go in here
    // detail ast = checksytle inturpret the contents of the code (in this case, a
    // semi)
    public void visitToken(DetailAST ast) {
        counter++;
    }

    public void beginTree(DetailAST rootAST) {
        counter = 0;
    }

    // you finished here
    public void finishTree(DetailAST rootAST) {
        // generate a long
        log(rootAST.getLineNo(), "# of semi colon is: " + counter);
        counter = 0;
    }

}
