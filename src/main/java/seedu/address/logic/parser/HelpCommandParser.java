package seedu.address.logic.parser;

import seedu.address.logic.commands.HelpCommand;


public class HelpCommandParser {

    /**
     * @return a List of Command Instruction for users.
     */
    public HelpCommand parse() {
        return new HelpCommand();
    }
}
