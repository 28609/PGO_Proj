interface Explosible {
    void explode();
}

class OverfillException extends Exception {
    public OverfillException(String message) {
        super(message);
    }
}


public class Main {
    public static void main(String[] args) {
        Statek containerShip1 = Statek.createContainerShip(40.0);

        kontenerCiecz liquidContainer = new kontenerCiecz(500, 10, 10, 700, false);
        kontenerGaz gasContainer = new kontenerGaz(1000, 8, 8, 2000, 2.5);
        kontenerChlodniczy refrigeratedContainer = new kontenerChlodniczy(800, 12, 12, 1200, -5);

        containerShip1.addContainer(liquidContainer);
        containerShip1.addContainer(gasContainer);
        containerShip1.addContainer(refrigeratedContainer);


        Statek containerShip2 = Statek.createContainerShip(50.0);

        System.out.println();
        System.out.println("Obecna liczba kontenerow na statku 1: " + containerShip1.getContainers().size());
        System.out.println("Obecna liczba kontenerow na statku 2: " + containerShip2.getContainers().size());

        System.out.println();
        Statek.transferContainers(containerShip1, containerShip2, containerShip1.getContainers());

        System.out.println();
        System.out.println("Obecna liczba kontenerów na statku 1 po przeniesieniu: " + containerShip1.getContainers().size());
        System.out.println("Obecna liczba kontenerów na statku 2 po przeniesieniu: " + containerShip2.getContainers().size());

        containerShip2.getContainers().clear();
        System.out.println();
        System.out.println("Wyczyszczono drugi statek z wszystkich kontenerów.");
    }
}


