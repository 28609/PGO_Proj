import java.util.ArrayList;
import java.util.List;

class Statek {
    private List<Kontener> containers;
    private double maxSpeed;
    private static int maxContainerCount;

    static {
        int indexNumber = 28609;

        if (indexNumber % 2 == 0) {
            maxContainerCount = indexNumber / 2;
        } else {
            maxContainerCount = indexNumber / 5;
        }
    }

    public Statek(double maxSpeed) {
        this.containers = new ArrayList<>();
        this.maxSpeed = maxSpeed;
    }

    public List<Kontener> getContainers() {
        return containers;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public int getMaxContainerCount() {
        return maxContainerCount;
    }

    public void addContainer(Kontener container) {
        if (containers.size() >= maxContainerCount) {
            System.out.println("Maksymalna ilosc kontenerow.");
        } else {
            containers.add(container);
            System.out.println("Wprowadzono nowy kontener z numerem seryjnym: " + container.getContainerSerialNumber());
        }
    }

    public void addContainers(List<Kontener> newContainers) {
        int availableSpace = maxContainerCount - containers.size();
        int containersToAdd = Math.min(availableSpace, newContainers.size());

        containers.addAll(newContainers.subList(0, containersToAdd));

        if (containersToAdd > 0) {
            System.out.println("Zaladowano " + containersToAdd + " kontenerow.");
        } else {
            System.out.println("Maksymalna ilosc kontenerow.");
        }
    }

    public void removeContainer(Kontener container) {
        if (containers.remove(container)) {
            System.out.println("Skasowano kontener identyfikowany numerem seryjnym: " + container.getContainerSerialNumber());
        } else {
            System.out.println("Kontener nie znajduje sie na statku");
        }
    }

    public void removeContainers(List<Kontener> containersToRemove) {
        containers.removeAll(containersToRemove);
        System.out.println("Wyjeto " + containersToRemove.size() + " kontenerow.");
    }

    public void replaceContainer(int position, Kontener newContainer) {
        if (position >= 0 && position < containers.size()) {
            containers.set(position, newContainer);
            System.out.println("Kontener zostal przeniesiony z miejsca " + position);
        } else {
            System.out.println("Bledne umiejscowienie kontenera");
        }
    }

    public static void transferContainers(Statek sourceShip, Statek destinationShip, List<Kontener> containers) {
        if (destinationShip.getContainers().size() + containers.size() > destinationShip.getMaxContainerCount()) {
            System.out.println("Transfer kontenerow nie jest mozliwy, poniewaz statki docelowe nie maja wystarczajacej przestrzeni.");
        } else {
            int transferredContainers = containers.size();
            destinationShip.getContainers().addAll(containers);
            sourceShip.getContainers().removeAll(containers);
            System.out.println("Kontenery w liczbie " + transferredContainers + " zostaly przeniesione z jednego statku na drugi.");
        }
    }

    public static Statek createContainerShip(double maxSpeed) {
        Statek containerShip = new Statek(maxSpeed);
        System.out.println("Powstal nowy statek do transportu kontenerow.");
        return containerShip;
    }
}