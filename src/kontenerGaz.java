class kontenerGaz extends Kontener implements Explosible {
    private double pressureLevel;

    public kontenerGaz(double containerWeight, int containerHeight, int containerLength, double maxWeight, double pressureLevel) {
        super(containerWeight, containerHeight, containerLength, maxWeight);
        this.pressureLevel = pressureLevel;
    }

    public double getPressureLevel() {
        return pressureLevel;
    }

    public void removeContainer() {
        double containerToKeep = getContainerWeight() * 0.05;
        setContainerWeight(containerToKeep);
    }

    @Override
    public void loadContainer(double containerWeight) throws OverfillException {
        if (containerWeight > getMaxWeight()) {
            explode();
            throw new OverfillException("Maksymalna waga kontenera przekroczona.");
        }

        setContainerWeight(containerWeight);
    }

    @Override
    public void explode() {
        System.out.println("Kontener z cieczą o numerze seryjnym: " + getContainerSerialNumber() + " wybuchł!");
    }
}