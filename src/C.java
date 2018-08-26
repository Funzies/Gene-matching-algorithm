public class C implements Gene{

    @Override
    public char value() {
        return 'C';
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof C){
            return true;
        }
        return false;
    }
}
