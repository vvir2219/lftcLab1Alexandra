import tables.CodeTable;

import java.util.Optional;

public class CodeTableMatcher implements TokenMatcher{
    CodeTable codeTable;

    public CodeTableMatcher(CodeTable codeTable) {
        this.codeTable = codeTable;
    }

    @Override
    public Match match(StringIterator iterator) {
        StringIterator tempIter = new StringIterator(iterator);
        StringBuilder prefix = new StringBuilder();
        Optional<String> match = Optional.empty();

        while (tempIter.valid()) {
            prefix.append(tempIter.current());
            String currentPrefix = String.valueOf(prefix);

            if (!codeTable.any(x -> x.startsWith(currentPrefix)))
                break;

            if (codeTable.any(x -> x.equals(currentPrefix)))
                match = Optional.of(currentPrefix);

            tempIter.next();
        }

        if (!match.isPresent())
            return new Match();
        else {
            iterator.copyFrom(tempIter);
            return new Match(match.get(), Optional.ofNullable(codeTable.getCode(match.get())));
        }
    }
}
