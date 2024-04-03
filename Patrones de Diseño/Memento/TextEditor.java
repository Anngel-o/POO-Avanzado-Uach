package Memento;

import java.util.ArrayList;

public class TextEditor {

    public static class TextWindow {
        private String text;

        public void write(String word) {
            text += word;
        }

        public String display() {
            return text;
        }

        public Memento save() {
            return new Memento(text);
        }

        public void restore(Memento memento) {
            this.text = memento.getMemento();
        }
    }

    public static class Memento {
        private String text;

        public Memento(String text) {
            this.text = text;
        }

        public String getMemento() {
            return text;
        }
    }

    private TextWindow textWindow;
    private ArrayList<Memento> history;

    public TextEditor(TextWindow textWindow) {
        this.textWindow = textWindow;
        this.history = new ArrayList<>();
    }

    public void write(String word) {
        textWindow.write(word);
        save();
    }

    public String display() {
        return textWindow.display();
    }

    public Memento save() {
        Memento memento = textWindow.save();
        history.add(memento);
        return memento;
    }

    public void restore(Memento memento) {
        textWindow.restore(memento);
    }

    // deshacer
    public void undo() {
        if (history.size() > 1) {
            history.remove(history.size() - 1);
            Memento lastMemento = history.get(history.size() - 1);
            textWindow.restore(lastMemento);
        }
    }

    public static void main(String[] args) {
        TextWindow textWindow = new TextWindow();
        TextEditor textEditor = new TextEditor(textWindow);

        // Escribir dos palabras
        textEditor.write("Hola ");
        textEditor.write("Mundo");

        // Guardar
        textEditor.save();

        // Imprimir el texto
        System.out.println("Texto actual: " + textEditor.display());

        // Escribir otra palabra
        textEditor.write("!");

        // Imprimir texto
        System.out.println("Texto después de agregar '!': " + textEditor.display());

        // Reestablecer
        textEditor.undo();

        // Imprimir texto después de restablecer
        System.out.println("Texto después de deshacer: " + textEditor.display());   
    }
}
