package com.italianDudes.dnd_extension.common.sheet.components;

@SuppressWarnings("unused")
public class SpellComponent {

    //Attributes
    private String componentName;
    private String amount;
    private String description;

    //Constructors
    public SpellComponent(String componentName){
        this(componentName,null,null);
    }
    public SpellComponent(String componentName, String amount){
        this(componentName,amount,null);
    }
    public SpellComponent(String componentName, String amount, String description){
        this.componentName = componentName;
        if(amount==null)
            this.amount = "";
        else
            this.amount = amount;
        if(description==null)
            this.description = "";
        else
            this.description = description;
    }

    //Methods
    public String getComponentName() {
        return componentName;
    }
    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }
    public String getAmount() {
        return amount;
    }
    public void setAmount(String amount) {
        this.amount = amount;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof SpellComponent))
            return false;
        SpellComponent spellComponent = (SpellComponent) obj;
        return spellComponent.componentName.equals(this.componentName) &&
                spellComponent.amount.equals(this.amount) &&
                spellComponent.description.equals(this.description);
     }
    @Override
    public String toString() {
        return "Component Name: "+componentName+"\n"+
                "Amount: "+amount+"\n"+
                "Descriptor: "+description;
    }
}
