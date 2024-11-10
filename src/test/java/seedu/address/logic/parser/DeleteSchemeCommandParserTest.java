package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_PERSON;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.DeleteSchemeCommand;

public class DeleteSchemeCommandParserTest {

    private DeleteSchemeCommandParser parser = new DeleteSchemeCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                DeleteSchemeCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validArgs_returnsDeleteSchemeCommand() {
        ArrayList<Index> indexes = new ArrayList<>();
        indexes.add(INDEX_FIRST_PERSON);
        assertParseSuccess(parser, "1 i/1", new DeleteSchemeCommand(INDEX_FIRST_PERSON, indexes));
    }

    @Test
    public void parse_validMultipleArgs_returnsDeleteSchemeCommand() {
        ArrayList<Index> indexes = new ArrayList<>();
        indexes.add(INDEX_FIRST_PERSON);
        indexes.add(INDEX_SECOND_PERSON);
        assertParseSuccess(parser, "1 i/1, 2", new DeleteSchemeCommand(INDEX_FIRST_PERSON, indexes));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertParseFailure(parser, "a i/1", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                DeleteSchemeCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_invalidIndex_throwsParseException() {
        assertParseFailure(parser, "-1 i/1", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                DeleteSchemeCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_invalidSchemeIndex_throwsParseException() {
        assertParseFailure(parser, "1 i/-1", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                DeleteSchemeCommand.MESSAGE_USAGE));
        assertParseFailure(parser, "1 i/", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                DeleteSchemeCommand.MESSAGE_USAGE));
    }
}
