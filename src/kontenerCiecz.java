class kontenerCiecz extends Kontener implements Explosible {
    private boolean isDangerous;

    public kontenerCiecz(double containerWeight, int containerHeight, int containerLength, double maxWeight, boolean isDangerous) {
        super(containerWeight, containerHeight, containerLength, maxWeight);
        this.isDangerous = isDangerous;
    }


    public boolean Dangerous() {
        return isDangerous;
    }

    @Override
    public void loadContainer(double containerWeight) throws OverfillException {
        double threshold;

        if (isDangerous) {
            threshold = getMaxWeight() / 2;
        } else {
            threshold = getMaxWeight() * 0.9;
        }

        if (containerWeight > threshold) {
            explode();
            throw new OverfillException("Maksymalna waga przekroczona.");
        }

        setContainerWeight(containerWeight);
    }

    @Override
    public void explode() {
        System.out.println("Kontener z cieczą o numerze seryjnym: " + getContainerSerialNumber() + " wybuchł!");
    }
}