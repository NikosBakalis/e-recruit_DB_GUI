/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamysql.model;

/**
 *
 * @author Nikos
 */
public class Sectors {
    
    private String title, description, belongsTo;

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the belongsTo
     */
    public String getBelongsTo() {
        return belongsTo;
    }

    /**
     * @param belongsTo the belongsTo to set
     */
    public void setBelongsTo(String belongsTo) {
        this.belongsTo = belongsTo;
    }
    
}
