import java.util.Random;

public class Kontener {
    private static final int CONTAINER_INDEX = 28609;
    private double containerWeight;
    private int containerHeight;
    private int containerLength;
    private int containerSerialNumber;
    private double maxWeight;

    {
        Random random = new Random();
        containerSerialNumber = random.nextInt(CONTAINER_INDEX);
    }

    public Kontener(double containerWeight, int containerHeight, int containerLength, double maxWeight) {
        this.containerWeight = containerWeight;
        this.containerHeight = containerHeight;
        this.containerLength = containerLength;
        this.maxWeight = maxWeight;
    }

    public double getContainerWeight() {
        return containerWeight;
    }

    public void setContainerWeight(double containerWeight) {
        this.containerWeight = containerWeight;
    }

    public int getContainerHeight() {
        return containerHeight;
    }

    public void setContainerHeight(int containerHeight) {
        this.containerHeight = containerHeight;
    }

    public int getContainerLength() {
        return containerLength;
    }

    public void setContainerLength(int containerLength) {
        this.containerLength = containerLength;
    }

    public int getContainerSerialNumber() {
        return containerSerialNumber;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void unloadContainer() {
        containerWeight = 0;
    }

    public void loadContainer(double containerWeight) throws OverfillException {
        if (containerWeight > maxWeight) {
            throw new OverfillException("Przekroczono maksymalną wagę kontenera.");
        }

        this.containerWeight = containerWeight;
    }

    public int getContainerIndex() {
        return CONTAINER_INDEX;
    }
}