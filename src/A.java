public class A implements Gene{

    @Override
    public char value() {
        return 'A';
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof A){
            return true;
        }
        return false;
    }
}
