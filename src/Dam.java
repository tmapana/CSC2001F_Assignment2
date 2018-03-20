// Dam object program
// Tlotliso Mapana
// 06 March 2018
/*
  *This class creates Dam objects with name fsc and level
*/
public class Dam
{
  String name;
  String fsc;
  String damLvl;

  public Dam (){}

  public Dam(String n, String f, String lvl)
  {
    name = n;
    fsc = f;
    damLvl = lvl;
  }

  public String getName ()
  {
    return name;
  }

  public String getFSC()
  {
    return fsc;
  }

  public String getDamLevel()
  {
    return damLvl;
  }

  public String toString ()
  {
    return name + ", the FSC is " + fsc + " and the most recent dam level is " + damLvl;
  }

  public boolean equalsTo(String n)
  {
    return getName().equals(n);
  }

}
