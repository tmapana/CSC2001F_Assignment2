// BinaryTreeNode program
// Tlotliso Mapana
// 12 March 2018
/*
  *This program creates a node of Dam type to be added to a binary tree
*/
public class BinaryTreeNode<dataType>
{
   String data;
   BinaryTreeNode<dataType> left;
   BinaryTreeNode<dataType> right;
   int height;

   public BinaryTreeNode ( Dam d, BinaryTreeNode<dataType> l, BinaryTreeNode<dataType> r )
   {
      data = d.toString();
      left = l;
      right = r;
      height = 0;
   }

   BinaryTreeNode<dataType> getLeft () { return left; }
   BinaryTreeNode<dataType> getRight () { return right; }

}
