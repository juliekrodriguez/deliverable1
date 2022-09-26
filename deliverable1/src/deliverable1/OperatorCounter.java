package deliverable1;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

public class OperatorCounter extends AbstractCheck {

    int opCounter = 0;

    // init all the ops used - everything found on that tokentype
    int[] toks = { TokenTypes.ASSIGN, TokenTypes.BAND, TokenTypes.BAND_ASSIGN, TokenTypes.BNOT, TokenTypes.BOR,
            TokenTypes.BOR_ASSIGN, TokenTypes.BSR, TokenTypes.BSR_ASSIGN, TokenTypes.BXOR, TokenTypes.BXOR_ASSIGN,
            TokenTypes.COLON, TokenTypes.COMMA, TokenTypes.DEC, TokenTypes.DIV, TokenTypes.DIV_ASSIGN, TokenTypes.DOT,
            TokenTypes.EQUAL, TokenTypes.GE, TokenTypes.GT, TokenTypes.INC, TokenTypes.INDEX_OP, TokenTypes.LAND,
            TokenTypes.LE, TokenTypes.LITERAL_INSTANCEOF, TokenTypes.LNOT, TokenTypes.LOR, TokenTypes.LT,
            TokenTypes.MINUS, TokenTypes.MINUS_ASSIGN, TokenTypes.MOD, TokenTypes.MOD_ASSIGN, TokenTypes.NOT_EQUAL,
            TokenTypes.PLUS, TokenTypes.PLUS_ASSIGN, TokenTypes.POST_DEC, TokenTypes.POST_INC, TokenTypes.QUESTION,
            TokenTypes.SL, TokenTypes.SL_ASSIGN, TokenTypes.SR, TokenTypes.SR_ASSIGN, TokenTypes.STAR,
            TokenTypes.STAR_ASSIGN, TokenTypes.UNARY_MINUS, TokenTypes.UNARY_PLUS };

    @Override
    public void beginTree(DetailAST rootAST) {
        opCounter = 0; // resetting
    }

    @Override
    public int[] getDefaultTokens() {
        // TODO Auto-generated method stub
        return toks;
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

    public void visitToken(DetailAST aAST) {
        opCounter++;
    }

    public int getCount() 
    {
        return opCounter;
    }

    @Override
    public void finishTree(DetailAST rootAST) {
        log(rootAST.getLineNo(), "# of operators: " + opCounter);
    }

}
