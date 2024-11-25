// Customer Sınıfı
class Customer extends BaseEntity {
    public Customer(int id, String name) {
        super(id, name);
    }

    @Override
    public void BilgiGoster() {
        System.out.println("Müşteri ID: " + getId() + ", Adı: " + getName());
    }
}