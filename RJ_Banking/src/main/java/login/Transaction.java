package login;

public class Transaction {
    private String userId;
    private float amount;
    private String lasrTransac;
    private float lasrTransaction;
    private String lastTransaction;

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getLasrTransac() {
        return lasrTransac;
    }

    public void setLasrTransac(String lasrTransac) {
        this.lasrTransac = lasrTransac;
    }

    public float getLasrTransaction() {
        return lasrTransaction;
    }

    public void setLasrTransaction(float lasrTransaction) {
        this.lasrTransaction = lasrTransaction;
    }

    public String getLastTransaction() {
        return lastTransaction;
    }

    public void setLastTransaction(String lastTransaction) {
        this.lastTransaction = lastTransaction;
    }

    @Override
    public String toString() {
        return "Transaction [userId=" + userId + ", amount=" + amount + 
               ", lasrTransac=" + lasrTransac + ", lasrTransaction=" + lasrTransaction + 
               ", lastTransaction=" + lastTransaction + "]";
    }
}
