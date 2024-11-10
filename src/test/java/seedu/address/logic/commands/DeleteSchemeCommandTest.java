package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalIndexes.INDEX_THIRD_PERSON;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook3;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

public class DeleteSchemeCommandTest {
    private final Model model = new ModelManager(getTypicalAddressBook3(), new ArrayList<>(), new UserPrefs());
    private final Model expectedModel = new ModelManager(getTypicalAddressBook3(), new ArrayList<>(), new UserPrefs());

    @Test
    public void execute_noSchemeAvail_failure() {
        ArrayList<Index> indexes = new ArrayList<>();
        indexes.add(INDEX_FIRST_PERSON);
        assertCommandFailure(new DeleteSchemeCommand(INDEX_THIRD_PERSON, indexes), model,
                String.format(Messages.MESSAGE_INVALID_SCHEMES_DISPLAYED_INDEX));
    }
}
