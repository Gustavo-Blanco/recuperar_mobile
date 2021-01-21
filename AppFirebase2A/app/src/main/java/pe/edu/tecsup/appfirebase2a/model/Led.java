package pe.edu.tecsup.appfirebase2a.model;

public class Led {
    private String led1;
    private String led2;
    private String led3;

    public Led() {
    }

    public Led(String led1, String led2, String led3) {
        this.led1 = led1;
        this.led2 = led2;
        this.led3 = led3;
    }

    public String getLed1() {
        return led1;
    }

    public void setLed1(String led1) {
        this.led1 = led1;
    }

    public String getLed2() {
        return led2;
    }

    public void setLed2(String led2) {
        this.led2 = led2;
    }

    public String getLed3() {
        return led3;
    }

    public void setLed3(String led3) {
        this.led3 = led3;
    }

    @Override
    public String toString() {
        return "Led{" +
                "led1='" + led1 + '\'' +
                ", led2='" + led2 + '\'' +
                ", led3='" + led3 + '\'' +
                '}';
    }
}
