/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posi.sys.all.inv;

/**
 *
 * @author Aquarius
 */
public class newItem extends posi.sys.expeditors.popup {
    private int item_num = -1;
    private posi.sys.all.expeditors.database.db_connect db;
    private Object [] data;
    
    public newItem(){
        super(new java.awt.Dimension(400,500),"New Item");
        this.addContent();
        
    }
    public newItem(int itemNum){
        super(new java.awt.Dimension(400,500),"Edit Item");
        
        this.item_num = itemNum;
        this.addContent();
    }
    
    private void addContent(){
        if(this.item_num == -1 ){
            this.renderContent( true );
        }else{
            data = db.getData("SELECT * FROM items where item_id="+this.item_num);
            this.renderContent( false );
        }        
    }
    
    private void renderContent(boolean ifNewItem){
        this.createSwingComponents();
        if( !ifNewItem ){
            
        }        
    }
    
    private void createSwingComponents(){
        this.addContent(new javax.swing.JButton("New item"));
    }
}
