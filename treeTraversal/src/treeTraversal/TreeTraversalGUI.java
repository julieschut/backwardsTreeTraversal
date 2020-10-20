package treeTraversal;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;  


public class TreeTraversalGUI implements TreeSelectionListener {
	
	JFrame f; 
	JTree tree;
	
	public static void main(String[] args) {  
	    new TreeTraversalGUI();  
	}
	
	TreeTraversalGUI(){  
		
	    f = new JFrame();   
	    
	    DefaultMutableTreeNode mainStep = new DefaultMutableTreeNode("Main Step");  
	   
	    DefaultMutableTreeNode step1 = new DefaultMutableTreeNode("STEP1");  
	    DefaultMutableTreeNode step2 = new DefaultMutableTreeNode("STEP2"); 
	    
	    DefaultMutableTreeNode op1 = new DefaultMutableTreeNode("OPERATION1");  
	    DefaultMutableTreeNode op2 = new DefaultMutableTreeNode("OPERATION2");  
	    DefaultMutableTreeNode op3 = new DefaultMutableTreeNode("OPERATION3");  
	    DefaultMutableTreeNode op4 = new DefaultMutableTreeNode("OPERATION4"); 
	    DefaultMutableTreeNode op5 = new DefaultMutableTreeNode("OPERATION5");  
	    
	    mainStep.add(step1);  
	    mainStep.add(step2); 
	    
	    step1.add(op1);
	    step1.add(op2);
	    
	    step2.add(op3);
	    step2.add(op4);
	    step2.add(op5);
	    
	         
	    tree = new JTree(mainStep); 
	    tree.addTreeSelectionListener(this);
	    
	    f.add(tree);  
	    f.setSize(200,200);  
	    f.setVisible(true);    
	    
	}  
	
	/**
	 * Recursively traverses back from the given node to root.
	 * @param treeNode
	 */
	public void getPathToNode(TreeNode treeNode){
		
		
		if (treeNode.getParent() == null){
			System.out.println("0");
			return;
		}
		
		
		else {
			
			getPathToNode(treeNode.getParent());
			System.out.println(treeNode.getParent().getIndex(treeNode));

		}				
	}
	

	@Override
	public void valueChanged(TreeSelectionEvent e) {

	    DefaultMutableTreeNode node = (DefaultMutableTreeNode)
	                       tree.getLastSelectedPathComponent();

	    if (node != null) {
	    	getPathToNode(node);
	    }
	
	}
	
}  