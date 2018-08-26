public class G implements Gene{

    @Override
    public char value() {
        return 'G';
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof G){
            return true;
        }
        return false;
    }
}
