package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.ViewPersonSchemeCommand;

public class ViewPersonSchemeCommandParserTest {

    private ViewPersonSchemeCommandParser parser = new ViewPersonSchemeCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                ViewPersonSchemeCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validArgs_returnsViewPersonSchemeCommand() {
        assertParseSuccess(parser, "1", new ViewPersonSchemeCommand(INDEX_FIRST_PERSON));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertParseFailure(parser, "a", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                ViewPersonSchemeCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_invalidIndex_throwsParseException() {
        assertParseFailure(parser, "-1", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                ViewPersonSchemeCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validMultiArgs_returnsViewPersonSchemeCommands() {
        assertParseFailure(parser, "1, 2", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                ViewPersonSchemeCommand.MESSAGE_USAGE));
    }

}
