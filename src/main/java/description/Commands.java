package description;

public enum Commands {
    ADD("add","add book to the library"),
    SAVE("save","save your new added books"),
    SHOW("show","show list of books"),
    EXIT("exit","close the app"),
    HELP("help","provide list of available commands");


    public final String value;
    public final String description;

    Commands(String value, String description) {
        this.value = value;
        this.description = description;

    }
}

