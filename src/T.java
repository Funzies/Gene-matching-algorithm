public class T implements Gene{

    @Override
    public char value() {
        return 'T';
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof T){
            return true;
        }
        return false;
    }
}
