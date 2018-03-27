// DamAVLApp program
// Tlotliso Mapana
// 19 March 2018

import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DamAVLApp
{
  public static void printDam (String name, AVLTree<String> avl)
  {
    String output = (avl.find(name)).data;
    System.out.println(output);
  }

  public static void printAllDams (AVLTree<String> avl)
  {
    avl.inOrder();
  }

  public static void main ( String [] args )
  {
    Scanner inputFile = null;

    Dam dam = new Dam();
    BinaryTreeNode<String> node = new BinaryTreeNode<String> (dam, null, null);
    AVLTree<String> avlTree = new AVLTree<String> ();

    try { inputFile = new Scanner (new FileReader ("Dam_Levels.csv")); }
    catch (FileNotFoundException err)
    {
      System.out.println("Error! Problem Opening File");
      System.exit(0);
    }

    inputFile.nextLine();
    int range = 211;
    for (int i=0; i<range; i++)
    {
      String[] damDetails = inputFile.nextLine().split(",", -1);
      dam = new Dam(damDetails[2].trim(), damDetails[10].trim(), damDetails[42].trim());
      node = new BinaryTreeNode<String> (dam, null, null);
      avlTree.insert(dam);
    }

    if (args.length == 0)
      printAllDams(avlTree);

    else
    {
      System.out.println("Searching for '" + args[0] + "'...");

      try {
        printDam(args[0], avlTree);
        System.out.println("Comparison operations made for the search of " + args[0] + " is " + avlTree.getOpCount());
        System.out.println("Insertion count: " + avlTree.getInCount());
      }

      catch (Exception e)
      {
        System.out.println("Dam not found");
        System.out.println("Comparison operations made for the search of " + args[0] + " is " + avlTree.getOpCount());
      }
    }

}

}
