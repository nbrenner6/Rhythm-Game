public class Beat
{
   private int time;
   private String name;
   
    public Beat(int t, String n)
    {
      time = t;
      name = n;
    }
    
    public int getTime()
    {
      return time;
    }
    
    public String getName()
    {
      return name;
    }
    
    public void setTime(int t)
    {
      time = t;
    }
    
    public void setName(String n)
    {
      name = n;
    }

}
