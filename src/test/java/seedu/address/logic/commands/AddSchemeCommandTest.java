package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalIndexes.INDEX_THIRD_PERSON;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook3;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import seedu.address.logic.Messages;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
public class AddSchemeCommandTest {
    private final Model model = new ModelManager(getTypicalAddressBook3(), new ArrayList<>(), new UserPrefs());
    private final Model expectedModel = new ModelManager(getTypicalAddressBook3(), new ArrayList<>(), new UserPrefs());

    @Test
    public void execute_noSchemeAvail_success() {
        assertCommandFailure(new AddSchemeCommand(INDEX_THIRD_PERSON, INDEX_FIRST_PERSON), model,
                String.format(Messages.MESSAGE_NO_SCHEMES_AVAILABLE));
    }
}
