import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class kontenerChlodniczy extends Kontener {
    private double temperature;
    private List<String> products;

    {
        products = new ArrayList<>();
        String[] productList = {"banany", "czekolada", "ryba", "mieso", "lody czekoladowe", "mrozona pizza",
                "ser", "kielbaski", "maslo", "mleko"};

        Random random = new Random();
        int index = random.nextInt(productList.length);
        for (int i = 0; i <= index; i++) {
            products.add(productList[i]);
        }
    }

    public kontenerChlodniczy(double containerWeight, int containerHeight, int containerLength, double maxWeight, double temperature) {
        super(containerWeight, containerHeight, containerLength, maxWeight);
        this.temperature = temperature;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public List<String> getProducts() {
        return products;
    }
}