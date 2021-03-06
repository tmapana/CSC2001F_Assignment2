// Hussein's AVL Tree
// 2 April 2017
// Hussein Suleman
// reference: kukuruku.co/post/avl-trees/

public class AVLTree<dataType extends Comparable<? super dataType>> extends BinaryTree<dataType>
{
   static int opCount = 0;
   static int inCount = 0;

   public int height ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
         return node.height;
      return -1;
   }

   public int balanceFactor ( BinaryTreeNode<dataType> node )
   {
      return height (node.right) - height (node.left);
   }

   public void fixHeight ( BinaryTreeNode<dataType> node )
   {
      node.height = Math.max (height (node.left), height (node.right)) + 1;
   }

   public BinaryTreeNode<dataType> rotateRight ( BinaryTreeNode<dataType> p )
   {
      BinaryTreeNode<dataType> q = p.left;
      p.left = q.right;
      q.right = p;
      fixHeight (p);
      fixHeight (q);
      return q;
   }

   public BinaryTreeNode<dataType> rotateLeft ( BinaryTreeNode<dataType> q )
   {
      BinaryTreeNode<dataType> p = q.right;
      q.right = p.left;
      p.left = q;
      fixHeight (q);
      fixHeight (p);
      return p;
   }

   public BinaryTreeNode<dataType> balance ( BinaryTreeNode<dataType> p )
   {
      fixHeight (p);
      if (balanceFactor (p) == 2)
      {
         if (balanceFactor (p.right) < 0)
            p.right = rotateRight (p.right);
         return rotateLeft (p);
      }
      if (balanceFactor (p) == -2)
      {
         if (balanceFactor (p.left) > 0)
            p.left = rotateLeft (p.left);
         return rotateRight (p);
      }
      return p;
   }

   public void insert ( Dam d )
   {
      inCount();
      root = insert (d, root);
   }
   public BinaryTreeNode<dataType> insert ( Dam d, BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return new BinaryTreeNode<dataType> (d, null, null);
      if (d.toString().compareTo (node.data) <= 0)
      {
         //inCount();
         node.left = insert (d, node.left);
      }
      else
      {
         //inCount();
         node.right = insert (d, node.right);
      }
      return balance (node);
   }

   public void delete ( String d )
   {
      root = delete (d, root);
   }
   public BinaryTreeNode<dataType> delete ( String d, BinaryTreeNode<dataType> node )
   {
      if (node == null) return null;
      if (d.compareTo (node.data) < 0)
         node.left = delete (d, node.left);
      else if (d.compareTo (node.data) > 0)
         node.right = delete (d, node.right);
      else
      {
         BinaryTreeNode<dataType> q = node.left;
         BinaryTreeNode<dataType> r = node.right;
         if (r == null)
            return q;
         BinaryTreeNode<dataType> min = findMin (r);
         min.right = removeMin (r);
         min.left = q;
         return balance (min);
      }
      return balance (node);
   }

   public BinaryTreeNode<dataType> findMin ( BinaryTreeNode<dataType> node )
   {
      if (node.left != null)
         return findMin (node.left);
      else
         return node;
   }

   public BinaryTreeNode<dataType> removeMin ( BinaryTreeNode<dataType> node )
   {
      if (node.left == null)
         return node.right;
      node.left = removeMin (node.left);
      return balance (node);
   }

   public BinaryTreeNode<dataType> find ( String d )
   {
      if (root == null)
      {
         opCount();
         return null;
      }
      else
         return find (d, root);
   }

   public BinaryTreeNode<dataType> find ( String d, BinaryTreeNode<dataType> node )
   {
      int position = (node.data).indexOf(",");
      if (d.compareTo ((node.data).substring(0, position)) == 0)
      {
         opCount();
         return node;
      }
      else if (d.compareTo ((node.data).substring(0, position)) < 0)
      {
         opCount();
         return (node.left == null) ? null : find (d, node.left);
      }
      else
      {
         opCount();
         return (node.right == null) ? null : find (d, node.right);
      }
   }

   public void opCount ()
   {
      opCount++;
   }
   public void inCount()
   {
      inCount++;
   }

   public int getOpCount ()
   {
     return opCount;
   }

   public int getInCount()
   {
     return inCount;
   }

}
