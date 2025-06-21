package BST;

public class BST
{
    private class Node
    {
        int data;
        Node left=null;
        Node right=null;
        Node(int data)
        {
            this.data=data;
        }
    }

    BST()
    {
        root=null;
    }

    private Node root;


    private StringBuffer TreeToString(Node root,StringBuffer str)
    {
       if(root==null)
       {
           return null;
       }
        str.append(root.data + "");
       if((root.left==null && root.right==null))
           return str;
       str.append("(");
       TreeToString(root.left,str);
       str.append(") ");
       str.append("(");
       TreeToString(root.right,str);
       str.append(")");
       return str;
    }


    private String treeInParentheses()
    {
        StringBuffer str=new StringBuffer();
        str=TreeToString(root,str);
        return String.valueOf(str);
    }

    private Node insertRecursive(Node root,int val)
    {
        if(root==null) {
            root = new Node(val);
            return root;
        }

        if (root.data>val)
            root.left=insertRecursive(root.left,val);
        else
            root.right=insertRecursive(root.right,val);

        return root;
    }

    public String insert(int val)
    {
            root=insertRecursive(root,val);
            return treeInParentheses();
    }

    private Node deleteRecursive(Node root,int val)
    {
        if(root.data>val)
            root.left=deleteRecursive(root.left,val);
        else if (root.data<val)
            root.right=deleteRecursive(root.right,val);
        else
        {
            if(root.left==null && root.right==null)
                return null;
            else
            {
                return root;
            }
        }

        return root;
    }

    public String Delete(int val)
    {
        String Str1=treeInParentheses();
        root=deleteRecursive(root,val);
        String Str2=treeInParentheses();
        if(Str1.equals(Str2))
        {
            return "Invalid operation";
        }
        else
            return Str2;
    }

    private Node findRecursive(Node root, int value) {
        if (root == null || root.data==value)
            return root;
        if (root.data > value)
            return findRecursive(root.left,value);
        return findRecursive(root.right,value);
    }

    public boolean find(int value)
    {
        Node node = root;
        node = findRecursive (node,value);
        return node != null;
    }

    public String Traversal(String s)
    {
        StringBuffer str=new StringBuffer("");
        if(s.equalsIgnoreCase("In"))
        {
            return inorderTraversal(root,str);
        }
        else if (s.equalsIgnoreCase("Pre"))
        {
            return preorderTraversal(root,str);
        }
        else if (s.equalsIgnoreCase("Post"))
        {
            return postorderTraversal(root,str);
        }
        else return null;

    }

    private String inorderTraversal(Node root,StringBuffer str)
    {

        if (root != null)
        {
            inorderTraversal(root.left,str);
            str.append(root.data + " ");
            inorderTraversal(root.right,str);
        }
        return String.valueOf(str);
    }

    private String preorderTraversal(Node root,StringBuffer str)
    {
        if (root == null)
            return null;

            str.append(root.data + " ");
            preorderTraversal(root.left,str);
            preorderTraversal(root.right,str);

        return String.valueOf(str);
    }
    private String postorderTraversal(Node root,StringBuffer str)
    {
        if (root == null)
            return null;

            postorderTraversal(root.left,str);
            postorderTraversal(root.right,str);
            str.append(root.data + " ");

        return String.valueOf(str);
    }

}

