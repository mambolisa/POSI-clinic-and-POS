/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.all.inv;

import java.awt.event.MouseEvent;
import posi.sys.expeditors.sundry;

/**
 *
 * @author Aquarius
 */
public  class ManageTabs extends javax.swing.JTabbedPane {
    private TabCloseUI closeUI;
    
    private static java.util.ArrayList<Object[]> tabList;
    
    private javax.swing.JScrollPane scrollpane;
    
    private int counter = 0;
    
    public static int current = 0;
    
    private javax.swing.JViewport viewport;
    
    public ManageTabs(){
        closeUI = new TabCloseUI(this);
        tabList = new java.util.ArrayList<Object []>();
    }
    
    public String getTabTitleAt(int index) {
	return super.getTitleAt(index).trim();
    }
    
    public int getTabIndex (String title){
        return super.indexOfTab(title);
    }
   
   public void addTabs(String title,java.awt.Component c, String tooltip){
       String cl = "";
       
       try{
            cl = c.getClass().getName();
       }catch (java.lang.NullPointerException e){
           
       }
       
       if("javax.swing.JScrollPane".equals(cl.toString())){
        scrollpane = (javax.swing.JScrollPane)c;
        
       }
       
       if(scrollpane.getViewport() != null){
          viewport = scrollpane.getViewport();
       }  
       
       javax.swing.JTable table = (viewport != null) ? (javax.swing.JTable)viewport.getView() : new javax.swing.JTable(); 
       
        if (indexOfTab(title) == -1 ){
            addTab(title,sundry.createImageIcon("images/Cancel.gif", new java.awt.Dimension(17, 17)),c);
            setSelectedIndex( indexOfTab( title ) );
            current = getTabIndex(title);
            
            tabList.add(new Object[] {counter, title, c, table});
            counter++;
        }else {
            setSelectedIndex( indexOfTab( title ) );
            current = getTabIndex(title);
        }
    }
    
    public void removeTab(String title){
        
    }
    
    public static Object [] getCurrentComponents(){
        //showListContent();
        System.out.print("Current: "+ current + "\t Size: "+ tabList.size());
        return tabList.get(current);
    }
    
    @Override
    public void removeTabAt(int index){
        super.removeTabAt(index);
        tabList.remove(index);   
        counter--;
    }
    
    public static void showListContent(){
        int list  = tabList.size();
        Object [] obj ;
        for (int i = 0; i < list; i++){
            obj = tabList.get(i);
            System.out.println(obj[0] + ": \t"+ obj[1] + "\t"+ obj[2] + "\t"+ obj[3] + "\n");
        }
    }
    public void removeAllTabs(){
        
    }
     
    class TabCloseUI implements java.awt.event.MouseListener, java.awt.event.MouseMotionListener{
        int x_coord , y_coord, closeX = 0 , closeY = 0;      
        private int selectedTab;
	private final int  width = 8, height = 8;
        
        private ManageTabs tabbedpane;
        
        public TabCloseUI( ){
            
        }
        
        public TabCloseUI(ManageTabs tabs){
            tabbedpane = tabs;
            tabbedpane.addMouseListener(this);
            tabbedpane.addMouseMotionListener(this);
        }

        @Override
        public void mouseClicked(MouseEvent e) { }

        @Override
        public void mousePressed(MouseEvent e) { }

        @Override
        public void mouseReleased(MouseEvent e) { //System.out.println("Mouse Released\nX \t"+ e.getX()+"\nY \t"+e.getY());
            x_coord = e.getX();
            y_coord = e.getY();
            if((mouseOverTab(x_coord, y_coord))){
                if(closeUnderMouse(x_coord, y_coord)){
                    boolean isToCloseTab = tabAboutToClose(selectedTab);
                    if (isToCloseTab && selectedTab > -1){			
                        removeTabAt(selectedTab);
                    }
                    selectedTab = getSelectedIndex();
                }
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) { }

        @Override
        public void mouseExited(MouseEvent e) { }

        @Override
        public void mouseDragged(MouseEvent e) { }

        @Override
        public void mouseMoved(MouseEvent e) { 
            x_coord = e.getX();
            y_coord = e.getY();
            
            if(mouseOverTab( x_coord , y_coord ) ) {
		controlCursor( );
            }
        }
	
      private void controlCursor() {
            if( getTabCount() > 0){
            	if( closeUnderMouse( x_coord, y_coord ) ){
                    setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));	
                    if( selectedTab > -1 ) {
                        setToolTipTextAt(selectedTab, "Close " + getTitleAt(selectedTab));
                    }
		}
		else{
                    setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                    
                    if( selectedTab > -1 ) {
                        setToolTipTextAt(selectedTab,"");
                    }
		}
            }
      }
              
      private boolean closeUnderMouse(int x, int y) {		
            if((x >= closeX && x <= closeX + width ) && (y >= closeY && y <= closeY + height )){
                return true;
            }
	return false;
      }
          
      public boolean tabAboutToClose(int tabIndex) {
            String tab = getTabTitleAt(tabIndex);
            int choice = javax.swing.JOptionPane.showConfirmDialog(null,
						"You are about to close '" + tab
								+ "'\nDo you want to proceed ?",
						"Confirmation Dialog", javax.swing.JOptionPane.INFORMATION_MESSAGE);
				return choice == 0; 
      }
       
      private boolean mouseOverTab(int x, int y) {
            int tabCount = getTabCount();
            for(int j = 0; j < tabCount; j++) {
                if(getBoundsAt(j).contains(x_coord, y_coord)){
                        selectedTab = j;
                        closeX = getBoundsAt(j).x + 15;
                        closeY = getBoundsAt(j).y + 5;					
                return true;
                }
            }
	return false;
     }
        
  }
    
}
