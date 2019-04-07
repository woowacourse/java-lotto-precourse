package exception;

public class LottoException extends RuntimeException {
    public String EXCEPTION_STR;

    public LottoException(){}

    public LottoException(String str){this.EXCEPTION_STR = str;}
}
