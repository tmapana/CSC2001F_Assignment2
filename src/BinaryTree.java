// BinaryTree program
// Tlotliso Mapana
// 12 March 2018
/*
  *This program adds nodes to the binary tree and performs operations on the tree
*/
public class BinaryTree<dataType>
{
   BinaryTreeNode<dataType> root;

   public BinaryTree ()
   {
      root = null;
   }

   public int getHeight ()
   {
      return getHeight (root);
   }

   public int getHeight ( BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return -1;
      else
         return 1 + Math.max (getHeight (node.getLeft ()), getHeight (node.getRight ()));
   }

   public int getSize ()
   {
      return getSize (root);
   }

   public int getSize ( BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return 0;
      else
         return 1 + getSize (node.getLeft ()) + getSize (node.getRight ());
   }

   public void inOrder ()
   {
      inOrder (root);
   }
   public void inOrder ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
      {
         inOrder (node.getLeft ());
         visit (node);
         inOrder (node.getRight ());
      }
   }

   public void preOrder ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
      {
         visit (node);
         preOrder (node.getLeft ());
         preOrder (node.getRight ());
      }
   }

   public void postOrder ()
   {
      postOrder (root);
   }
   public void postOrder ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
      {
         postOrder (node.getLeft ());
         postOrder (node.getRight ());
         visit (node);
      }
   }

   public void visit ( BinaryTreeNode<dataType> node )
   {
      System.out.println (node.data);
   }

}
