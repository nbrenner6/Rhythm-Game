<<<<<<< HEAD
import javax.sound.midi.*;

public class Sound
{
   protected static MidiChannel[] channels = null;
   protected static Instrument[] instr;
   protected static final int PIANO = 0;
   protected static final int VIOLIN = 41;
   protected static final int CELLO = 43;
   
   public static void initialize()
   {
      try
      {
         Synthesizer synth = MidiSystem.getSynthesizer();
         synth.open();
         Sound.channels = synth.getChannels();
         Sound.instr = synth.getDefaultSoundbank().getInstruments();
      }
      catch(Exception ignored)
      {}
      channels[0].programChange(instr[PIANO].getPatch().getProgram());
      silence();
   }
   
   public static void silence()
   {
      channels[0].allNotesOff();
   }
}