// BinarySearchTree program
// Tlotliso Mapana
// 12 March 2018
/*
  *This program uses inheritance to use methods and variable from BinaryTree to search through the binary tree
*/
public class BinarySearchTree<dataType extends Comparable<? super dataType >> extends BinaryTree<dataType >
{

  static int opCount = 0;

  public void insert ( Dam d )
  {
     if (root == null)
        root = new BinaryTreeNode<dataType> (d, null, null);
     else
        insert (d, root);
  }

  public void insert ( Dam d, BinaryTreeNode<dataType> node )
  {
     if (d.toString().compareTo (node.data) <= 0)
     {
        if (node.left == null)
           node.left = new BinaryTreeNode<dataType> (d, null, null);
        else
           insert (d, node.left);
     }
     else
     {
        if (node.right == null)
           node.right = new BinaryTreeNode<dataType> (d, null, null);
        else
           insert (d, node.right);
     }
  }

  public BinaryTreeNode<dataType> find ( String d )
  {
     if (root == null)
     {
          count();
	        return null;
     }
     else
     {
	        return find (d, root);
     }
  }

  public BinaryTreeNode<dataType> find ( String d, BinaryTreeNode<dataType> node )
  {
     int position = (node.data).indexOf(",");
     if (d.compareTo ((node.data).substring(0, position)) == 0)
     {
        count();
        return node;
     }

     else if (d.compareTo ((node.data).substring(0, position)) < 0)
     {
        count();
        return (node.left == null) ? null : find (d, node.left);
     }

     else
     {
        count();
        return (node.right == null) ? null : find (d, node.right);
     }
  }

  public void count ()
  {
     opCount++;
  }

  public int getCount ()
  {
    return opCount;
  }

}
