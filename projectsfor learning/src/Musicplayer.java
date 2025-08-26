import javax.sound.midi.*;
public class Musicplayer {
    public void play() {
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            System.out.println("Successfully got a sequencer");

        } catch (MidiUnavailableException ex) {
            System.out.println("bummer");
        }
    }

    public static void main(String[] org) {
        Musicplayer musicplayer=new Musicplayer();
        musicplayer.play();
    }
}
