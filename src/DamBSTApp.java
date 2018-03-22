// Binary search tree
// Tlotliso Mapana
// 10 March 2018

import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
/*
  *This program implements the BinarySearchTree program and uses printAllDams and printDam methods to search
*/
public class DamBSTApp
{

  public static void printDam (String name, BinarySearchTree<String> bst)
  {
    String output = (bst.find(name)).data;
    System.out.println(output);
  }

  public static void printAllDams (BinarySearchTree<String> bst)
  {
    bst.inOrder();
  }

  public static void main ( String [] args )
  {
    Scanner inputFile = null;
    Scanner nameOfDam = new Scanner (System.in);

    Dam dam = new Dam();
    BinaryTreeNode<String> btn = new BinaryTreeNode<String> (dam, null, null);
    BinarySearchTree<String> binTree = new BinarySearchTree<String> ();

    try
    {
      inputFile = new Scanner (new FileReader ("Dam_Levels.csv"));
    }
    catch (FileNotFoundException err)
    {
      System.out.println("Error! Problem Opening File");
      System.exit(0);
    }

    inputFile.nextLine();
    for (int i=0; i<211; i++)
    {
      String[] damDetails = inputFile.nextLine().split(",", -1);
      dam = new Dam(damDetails[2].trim(), damDetails[10].trim(), damDetails[42].trim());
      btn = new BinaryTreeNode<String> (dam, null, null);
      binTree.insert(dam);
    }

    if (args.length == 0)
    {
      printAllDams(binTree);
      System.out.println("Insertion operations made: " + binTree.getInCount());
    }

    else
    {
      System.out.println("Searching for '" + args[0] + "'...");

      try {
        printDam(args[0], binTree);
        System.out.println("Comparison operations made for the search of " + args[0] + " is " + binTree.getOpCount());
      }

      catch (Exception e)
      {
        System.out.println("Dam not found");
	      System.out.println("Comparison operations made for the search of " + args[0] + " is " + binTree.getOpCount());
      }
    }
  }

}
