public class CodeError {

    private Integer lineNumber;
    private Integer columnnNumber;
    private String  errorText;

    public CodeError(Integer lineNumber, Integer columnnNumber, String errorText) {
        this.lineNumber = lineNumber;
        this.columnnNumber = columnnNumber;
        this.errorText = errorText;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public Integer getColumnnNumber() {
        return columnnNumber;
    }

    public String getErrorText() {
        return errorText;
    }
}
