package State;

import java.util.HashMap;
import java.util.Map;

interface State {
    void handle(TrafficLightContext context);
    String getColor();
}

class GreenState implements State {
    @Override
    public void handle(TrafficLightContext context) {
        System.out.println("Cambiando a amarillo");
        context.setState(new YellowState());
    }

    @Override
    public String getColor() {
        return "verde";
    }
}

class YellowState implements State {
    @Override
    public void handle(TrafficLightContext context) {
        System.out.println("Cambiando a rojo");
        context.setState(new RedState());
    }

    @Override
    public String getColor() {
        return "amarillo";
    }
}

class RedState implements State {
    @Override
    public void handle(TrafficLightContext context) {
        System.out.println("Cambiando a verde");
        context.setState(new GreenState());
    }

    @Override
    public String getColor() {
        return "rojo";
    }
}

interface TransitionAction {
    void perform(TrafficLightContext context);
}

class TrafficLightContext {
    private State currentState;
    private Map<Class<? extends State>, TransitionAction> stateTransitions = new HashMap<>();

    public TrafficLightContext() {
        // Inicializar con el estado verde
        currentState = new GreenState();
        setupStateTransitions();
    }

    private void setupStateTransitions() {
        stateTransitions.put(GreenState.class, context -> System.out.println("Puede avanzar"));
        stateTransitions.put(YellowState.class, context -> System.out.println("Disminuir velocidad"));
        stateTransitions.put(RedState.class, context -> System.out.println("No puede avanzar"));
    }

    public void nextColor() {
        currentState.handle(this);
    }

    public String getCurrentColor() {
        return currentState.getColor();
    }

    public void advance() {
        stateTransitions.get(currentState.getClass()).perform(this);
    }

    public void setState(State state) {
        this.currentState = state;
    }
}

public class Main {
    public static void main(String[] args) {
        TrafficLightContext trafficLight = new TrafficLightContext();

        System.out.println("Color actual: " + trafficLight.getCurrentColor());
        trafficLight.advance();

        trafficLight.nextColor();

        System.out.println("Color actual: " + trafficLight.getCurrentColor());
        trafficLight.advance();
    }
}
