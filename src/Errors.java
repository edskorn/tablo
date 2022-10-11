public enum Errors {
    ERR_INCORRECT_FORMAT("\n Incorrect input file, look at the task conditions"),
    ERR_NO_SUCH_FILE("\n No input file, dude!"),
    ERR_CAN_NOT_WRITE("\n Can't write to output file.");
    private final String text;
    Errors(String text) {
        this.text = text;
    }

    public String getText(){
        return text;
    }
}
