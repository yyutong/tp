package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

public class ViewCategoryLabelsCommand extends Command {
    public static final String COMMAND_WORD = "viewCategory";
    public static final String MESSAGE_EXISTING_CATEGORY = "Existing category labels are: \n %s";

    @Override
    public CommandResult execute(Model model) throws CommandException {

//        String categories = model.showCategoryLabels();
        return new CommandResult(MESSAGE_EXISTING_CATEGORY);
    }
}
