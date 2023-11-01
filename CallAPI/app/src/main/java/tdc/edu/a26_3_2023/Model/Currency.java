package tdc.edu.a26_3_2023.Model;

import tdc.edu.a26_3_2023.Model.Error;

public class Currency {
    private boolean success;
    private Error error;

    public boolean getHello() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}
