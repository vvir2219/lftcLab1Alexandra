import java.util.Optional;

public class IntegerMatcher implements TokenMatcher{
    /*
    FSM integers
    initial state - 0
    final states - 1 3
    transitions:
        0 1 0
        0 2 +-
        0 3 123456789
        2 3 123456789
        3 3 0123456789
     */
    @Override
    public Match match(StringIterator iterator) {
        StringIterator tempIter = new StringIterator(iterator);
        StringBuilder prefix = new StringBuilder();
        int state = 0;

        while (tempIter.valid()){
            Character current = tempIter.current();
            boolean done = false;

            switch (state) {
                case 0:
                    switch (current) {
                        case '0':
                            state = 1;
                            prefix.append(current);
                            break;
                        case '+': case '-':
                            state = 2;
                            prefix.append(current);
                            break;
                        case '1':case '2':case '3':case '4':case '5':case '6':case '7':case '8':case '9':
                            state = 3;
                            prefix.append(current);
                            break;
                        default:
                            done = true;
                            break;
                    }
                    break;
                case 1:
                    done = true;
                    break;
                case 2:
                    switch (current) {
                        case '0': case '1':case '2':case '3':case '4':case '5':case '6':case '7':case '8':case '9':
                            state = 3;
                            prefix.append(current);
                            break;
                        default:
                            done = true;
                            break;
                    }
                    break;
                case 3:
                    switch (current) {
                        case '0': case '1':case '2':case '3':case '4':case '5':case '6':case '7':case '8':case '9':
                            state = 3;
                            prefix.append(current);
                            break;
                        default:
                            done = true;
                            break;
                    }
                    break;
            }
            if (done)
                break;

            tempIter.next();
        }

        if (state == 1 || state == 3){
            iterator.copyFrom(tempIter);
            return new Match(prefix.toString(), Optional.of(0));
        }else{
            return new Match();
        }
    }
}

