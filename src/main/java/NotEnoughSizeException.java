public class NotEnoughSizeException extends Exception {
    int requiredSize;
    int currentSize;
    public NotEnoughSizeException(int requiredSize, int currentSize){
        super("The required size is " + requiredSize + " but the current size is " + currentSize);
        this.requiredSize = requiredSize;
        this.currentSize = currentSize;
    }

    public int getRequiredSize(){
        return requiredSize;
    }

    public int getCurrentSize(){
        return currentSize;
    }
}
