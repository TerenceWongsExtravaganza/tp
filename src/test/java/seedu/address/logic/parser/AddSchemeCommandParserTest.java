package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.AddSchemeCommand;

public class AddSchemeCommandParserTest {

    private AddSchemeCommandParser parser = new AddSchemeCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                AddSchemeCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_multipleArgs_throwsParseException() {
        assertParseFailure(parser, "1 i/1, 2", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                AddSchemeCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validArgs_returnsAddSchemeCommand() {
        assertParseSuccess(parser, "1 i/1", new AddSchemeCommand(INDEX_FIRST_PERSON, INDEX_FIRST_PERSON));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertParseFailure(parser, "a i/1", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                AddSchemeCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_invalidIndex_throwsParseException() {
        assertParseFailure(parser, "-1 i/1", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                AddSchemeCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_invalidSchemeIndex_throwsParseException() {
        assertParseFailure(parser, "1 i/-1", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                AddSchemeCommand.MESSAGE_USAGE));
        assertParseFailure(parser, "1 i/", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                AddSchemeCommand.MESSAGE_USAGE));
    }
}
