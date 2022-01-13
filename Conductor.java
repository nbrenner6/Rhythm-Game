/*
track measure
track beat
Synchronize
*/

import javax.sound.midi.*;
import java.io.*;

public class Conductor {
   private int bpm;
   private int spb;
   private int songPosSec;
   private int songPosBeat;
   
   public Conductor(int b, int s, int pos1, int pos2) {
      bpm = b;
      spb = s;
      songPosSec = pos1;
      songPosBeat = pos2;
   }
   
   public void Start() {
      String path = "C:\\Users\\1497008\\Downloads\\twinkle-twinkle-little-star.mid";
      File twinkle = new File(path);
      try {
         Sequencer sequencer = MidiSystem.getSequencer(); // Get the default Sequencer
         sequencer.open();
         Sequence sequence = MidiSystem.getSequence(twinkle);
         sequencer.setSequence(sequence); // load it into sequencer
         //sequencer.start();  // start the playback
         int res = sequence.getResolution();
      }
      catch (MidiUnavailableException | InvalidMidiDataException | IOException ex) {
         ex.printStackTrace();
      }
      //music source
   }
   
}