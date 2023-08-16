package opensnzTech.shopWindows.beans.response;

import opensnzTech.shopWindows.beans.PharmaLabo;

public class PharmaLaboResponse {
	
    private boolean exists;
    private PharmaLabo pharmaLabo;

    public PharmaLaboResponse(boolean exists, PharmaLabo pharmaLabo) {
        this.exists = exists;
        this.pharmaLabo = pharmaLabo;
    }

	public boolean isExists() {
		return exists;
	}

	public void setExists(boolean exists) {
		this.exists = exists;
	}

	public PharmaLabo getPharmaLabo() {
		return pharmaLabo;
	}

	public void setPharmaLabo(PharmaLabo pharmaLabo) {
		this.pharmaLabo = pharmaLabo;
	}

}
