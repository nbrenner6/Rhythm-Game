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
   private String name;
   
   public Conductor(int s, int pos1, int pos2, String n) {
      updateBPM();
      spb = s;
      songPosSec = pos1;
      songPosBeat = pos2;
      name = n;
   }
   
   public void updateBPM() {
      String path = "C:\\Users\\1496668\\Downloads\\" + name + ".mid";
      File song = new File(path);
      try {
         Sequencer sequencer = MidiSystem.getSequencer(); // Get the default Sequencer
         sequencer.open();
         Sequence sequence = MidiSystem.getSequence(song);   
         sequencer.setSequence(sequence); // load it into sequencer
         //sequencer.start();  // start the playback
         /*
         int res = sequence.getResolution();
         System.out.println(res);
         double test = Math.pow(res * 1000 * 60, -1);
         System.out.println(test);
         */
         int test = 0;
         Track[] tracks = sequence.getTracks();
         for (int i = 0; i < tracks[0].size(); i++) {
            MidiEvent event = tracks[0].get(i);
            MidiMessage message = event.getMessage();
            if (message instanceof MetaMessage) {
                MetaMessage mm = (MetaMessage) message;
                if(mm.getType()==0x51) {
                    mm.getData();
                    byte[] data = mm.getData();
                    int tempo = (data[0] & 0xff) << 16 | (data[1] & 0xff) << 8 | (data[2] & 0xff);
                    test = 60000000 / tempo; //bpm of the piece
                    //System.out.println(test);
                }
            }
         }
         setBPM(test);
         
      }
      catch (MidiUnavailableException | InvalidMidiDataException | IOException ex) {
         ex.printStackTrace();
      }
   }

   public void setBPM(int b) {
      bpm = b;
   }

   public int getBPM() {
      return bpm;
   }
   
   public String getName()
   {
      return name;
   }

   public void playTrack() {

      String path = "C:\\Users\\1496668\\Downloads\\" + name + ".mid";

      File twinkle = new File(path);
      
      try {
         Sequencer sequencer = MidiSystem.getSequencer(); // Get the default Sequencer
         sequencer.open();
         Sequence sequence = MidiSystem.getSequence(twinkle);
         sequencer.setSequence(sequence); // load it into sequencer
         sequencer.start();  // start the playback       
      }
      catch (MidiUnavailableException | InvalidMidiDataException | IOException ex) {
            ex.printStackTrace();
      }
     
     
   }
   
}
