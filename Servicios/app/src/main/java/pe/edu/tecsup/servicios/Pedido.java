package pe.edu.tecsup.servicios;

import androidx.annotation.NonNull;

public class Pedido {

    private String food;
    private String address;

    public Pedido() {
    }

    public Pedido(String food, String address) {
        this.food = food;
        this.address = address;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "food='" + food + '\'' +
                ", address='" + address + '\'' +
                '}';
    }


}
