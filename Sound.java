import javax.sound.midi.*;

public class Sound
{
   protected static MidiChannel[] channels = null;
   protected static Instrument[] instr;
   protected static final int PIANO = 0;
   protected static final int TIMPANI = 48;;
   
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
   
   public static void tap()
   {
      channels[0].programChange(instr[38].getPatch().getProgram());
      int pitch = 50;
      int velocity = 30;
      channels[0].noteOn(pitch, velocity);
   }
   
   public static void click()
   {
      channels[0].programChange(instr[120].getPatch().getProgram());
      int pitch = 50;
      int velocity = 30;
      channels[0].noteOn(pitch, velocity);
   }
}
