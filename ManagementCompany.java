
public class ManagementCompany extends Object{
	static final int MAX_PROPERTY = 5;
	static final int MGMT_DEPTH = 10;
	static final int MGMT_WIDTH = 10;
	private String taxID;
	private String name;
	private double mgmFee;
	private Property[] properties;
	private Plot plot;
	private int propertyCount;
	
	public ManagementCompany() {
		this.taxID = "";
		this.name = "";
		this.mgmFee = 0.0;
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.properties = new Property[MAX_PROPERTY];
        this.propertyCount = 0;
		
	}
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.taxID = taxID;
		this.name = name;
		this.mgmFee = mgmFee;
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		this.properties = new Property[MAX_PROPERTY];
	    this.propertyCount = 0;
	}
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this.taxID = taxID;
		this.name = name;
		this.mgmFee = mgmFee;
		this.plot = new Plot(x, y, width, depth);
		this.properties = new Property[MAX_PROPERTY];
		this.propertyCount = 0;
	
	}
	public ManagementCompany(ManagementCompany otherCompany) { 
		this(otherCompany.getName(), otherCompany.getTaxID(), 
			otherCompany.getMgmFeePer());
		this.plot = new Plot(otherCompany.getPlot());
		this.properties = new Property[MAX_PROPERTY];
		this.propertyCount = otherCompany.propertyCount;
		for (int i = 0; i < otherCompany.propertyCount; i ++) {
			this.properties[i] = new Property(otherCompany.properties[i]);
		}
	}
	
	public int addProperty(Property property) {
        if (propertyCount >= MAX_PROPERTY) {
            return -1; // Property array is full
        }
        properties[propertyCount] = property;
        propertyCount++;
        return propertyCount - 1; // Return the index of the newly added property
    
	}
	public int addProperty(String name, String city, double rent, String owner) {
		return addProperty(new Property(name, city, rent, owner));
	}
	public int addProperty(String name, String city, double rent, String owner, 
			int x, int y, int width, int depth) {
		return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
	}
	public void removeLastProperty() {
		if (propertyCount > 0) {
	        properties[propertyCount - 1] = null;
	        propertyCount--;
		}
	}
	public boolean isPropertiesFull() {
		return propertyCount >= MAX_PROPERTY;
	}
	public boolean isManagementFeeValid() {
		return mgmFee >= 0 && mgmFee <=100;
	}
	public double getTotalRent() {
		double tRent = 0;
		for ( int i = 0; i < propertyCount; i++) {
			tRent += properties[i].getRent();
		}
		return tRent;
	}
	public Property getHighestRentProperty() {
		    if (propertyCount == 0) {
		        return null; 
		    }

		    Property highestRentProperty = properties[0];
		    for (int i = 1; i < propertyCount; i++) {
		        if (properties[i].getRent() > highestRentProperty.getRent()) {
		            highestRentProperty = properties[i];
		        }
		    }
		    return highestRentProperty;
		}
		public String getName() {
		return name;
	}
	public String getTaxID() {
		return taxID;
	}
	public double getMgmFeePer() {
		return mgmFee;
	}
	public Plot getPlot() {
		return plot;
	}
	public Property[] getProperties() {
		Property[] property = new Property[this.propertyCount]; 
		for (int i = 0; i < propertyCount; i++ ) {
			property[i] = properties[i];
		}
		return property;
	}
	public int getPropertiesCount() {
		return propertyCount;
	}
	@Override
	public String toString() {
	    String result = "List of the properties for " + name + ", taxID: " + taxID + "\n";
	    result += "______________________________________________________\n";
	    for (int i = 0; i < propertyCount; i++) {
	        result += properties[i].toString() + "\n";
	    }
	    result += "______________________________________________________\n";
	    result += "\n";
	    double totalManagementFee = getTotalRent() * (mgmFee / 100);
	    result += " total management Fee: " + String.format("%.2f", totalManagementFee);
	    return result;
	}
}
