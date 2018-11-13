package com.company;

import java.util.Optional;

public class DoubleMatcher implements TokenMatcher{

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
                            case '.':
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

//        return null;
//    }
}

