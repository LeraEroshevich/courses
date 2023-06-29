package page;

public class Order {

    private Long id;
    private Long petId;
    private Long quantity;
    private String shipDate;
    private String status;
    private boolean complete;

    public Order(Long id, Long petId,Long quantity, String shipDate, String status, boolean complete) {
        this.id = id;
        this.petId = petId;
        this.quantity = quantity;
        this.shipDate = shipDate;
        this.status = status;
        this.complete = complete;
    }

    @Override
    public String toString(){
        return "Order{" + "id": 0,
            "petId": 0,
            "quantity": 0,
            "shipDate": "2023-06-27T18:57:01.919Z",
            "status": "placed",
            "complete": true
    }
    public Order(){

    }

    public Long getId() {
        return id;
    }

    public Long getPetId() {
        return petId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public String getShipDate() {
        return shipDate;
    }

    public String getStatus() {
        return status;
    }

    public boolean isComplete() {
        return complete;
    }
}
