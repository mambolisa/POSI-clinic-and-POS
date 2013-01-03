/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.all.inv;

import java.awt.FlowLayout;
import javax.swing.event.TreeSelectionEvent;

/**
 *
 * @author Aquarius
 */
public class inventoryJTree{
    private static javax.swing.JTree tree;
    private static javax.swing.JScrollPane treeView;
    private static javax.swing.tree.DefaultMutableTreeNode top, node, nodeSub;
    
    private static java.awt.Component c;
    
    public inventoryJTree(){
        top = new javax.swing.tree.DefaultMutableTreeNode("Inventory List view");
        
        inventoryJTree.createNodes("Show",new String [] {"Show by category","Show by expiry","Show by reorder","Inventory list"});
        inventoryJTree.createNodes("Recent",new String [] {"Recently removed","Recently updated","Recently added"});
        
        tree = new javax.swing.JTree(top);
        tree.setShowsRootHandles(true);
       
        tree.getSelectionModel().setSelectionMode(javax.swing.tree.TreeSelectionModel.SINGLE_TREE_SELECTION);
        
        tree.addTreeSelectionListener(new treeSelectionListener());
                
        treeView = new javax.swing.JScrollPane(tree);
        treeView.setPreferredSize(new java.awt.Dimension(210, 300));
    }
    
    public javax.swing.JScrollPane getContent(){
        return treeView;
    }
    
    public static javax.swing.JScrollPane updateTree(){
        top = new javax.swing.tree.DefaultMutableTreeNode("Reports");
        createNodes("Stock",new String [] {"Recent","Recently ","Recently added"});
        createNodes("Items",new String [] {"Show by category","Show by expiry","Show by reorder"});
        createNodes("Graphs",new String [] {"All graphical reports"});
        
        tree = new javax.swing.JTree(top);
        tree.setShowsRootHandles(true);
       
        tree.getSelectionModel().setSelectionMode(javax.swing.tree.TreeSelectionModel.SINGLE_TREE_SELECTION);
        
        tree.addTreeSelectionListener(new treeSelectionListener());
                
    return new javax.swing.JScrollPane(tree);      
    }
    
    private static void createNodes(String title,String [] namesSub){
        node = new javax.swing.tree.DefaultMutableTreeNode( title );;
        top.add(node);
        
        createSubNode(node, namesSub);
    }
    
    private static void createSubNode(javax.swing.tree.DefaultMutableTreeNode node, String [] names){
        for (int i = 0; i < names.length; i++){
            nodeSub = new javax.swing.tree.DefaultMutableTreeNode( names[i] );
            node.add(nodeSub);
        }
    }
    
    static class treeSelectionListener implements javax.swing.event.TreeSelectionListener{
        @Override
        public void valueChanged(TreeSelectionEvent e) {
            javax.swing.tree.DefaultMutableTreeNode node = (javax.swing.tree.DefaultMutableTreeNode)tree.getLastSelectedPathComponent();

            if ( node == null )
                    
            return;

            Object nodeInfo = node.getUserObject();
           
            /*
             * Remove dummy data
             */              
                    
                  
            String[] columnNames = {"First Name",
                        "Last Name",
                        "Sport",
                        "# of Years",
                        "Vegetarian"};

            Object[][] data = {
                                {"Mary", "Campione",
                                 "Snowboarding", new Integer(5), new Boolean(false)},
                                {"Alison", "Huml",
                                 "Rowing", new Integer(3), new Boolean(true)},
                                {"Kathy", "Walrath",
                                 "Knitting", new Integer(2), new Boolean(false)},
                                {"Sharon", "Zakhour",
                                 "Speed reading", new Integer(20), new Boolean(true)},
                                {"Philip", "Milne","Pool", "10", "false"}
                            };

            if (node.isLeaf()) {
                if("Recently removed".equals(node.toString())){
                    c = (java.awt.Component)new javax.swing.JButton("Recently removed");
                }else if("Recently updated".equals(node.toString())){
                    //javax.swing.JScrollPane scrollpane = new invTables().tableScrollPane();
                    //c = (java.awt.Component)scrollpane;
                    c = (java.awt.Component)new javax.swing.JButton("Recently updated");
                }else if("Recently added".equals(node.toString())){
                   // javax.swing.JScrollPane scrollpane = new invTables().tableScrollPane();
                   // c = (java.awt.Component)scrollpane;
                    c = (java.awt.Component)new javax.swing.JButton("Recently added");
                }else if("Show by category".equals(node.toString())){
                    //javax.swing.JScrollPane scrollpane = new invTables().tableScrollPane();
                   // c = (java.awt.Component)scrollpane;
                    c = (java.awt.Component)new javax.swing.JButton("Cat");
                }else if("Show by expiry".equals(node.toString())){
                    javax.swing.JScrollPane scrollpane = new invTables(data, columnNames).tableScrollPane();
                    c = (java.awt.Component)scrollpane;
                   // c = (java.awt.Component)new javax.swing.JButton("Cat");
                }else if("Show by reorder".equals(node.toString())){
                    javax.swing.JScrollPane scrollpane = new invTables(data,columnNames).tableScrollPane();
                    c = (java.awt.Component)scrollpane;
                   // c = (java.awt.Component)new javax.swing.JButton("Cat");
                }else if("Show all".equals(node.toString())){
                    //javax.swing.JScrollPane scrollpane = new invTables().tableScrollPane();
                    //c = (java.awt.Component)scrollpane;
                    c = (java.awt.Component)new javax.swing.JButton("All");
                }
              // c = (java.awt.Component)new javax.swing.JTable(5,6);
                //
                inventoryMngt.tabbedPane.addTabs(node.toString(), c, null);
                
            } 
        }
        
    }
}
/*
 * Get the root of the tree:
 tree.getModel().getRoot();

then get the number of children of this root node:
 tree.getModel().getChildCount(rootNode)

then go from 0 to the number of children and call
tree.getModel().getChild(rootNode, i)

to get the children of the root node.
 * 
 * 
 */
