import java.util.ArrayList;
import java.util.List;

public class Salon extends BaseEntity {
    private Movie movie; // Oynatılan film
    private List<Customer> customers; // Salondaki müşteriler

    public Salon(int id, String name) {
        super(id, name);
        this.customers = new ArrayList<>();
    }
    public void ekle(List<Salon> salonListesi) {
        salonListesi.add(this); // Bu nesneyi listeye ekler
        System.out.println(this.getName() + " başarıyla listeye eklendi.");
    }


    @Override
    public void BilgiGoster() {

    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Movie getMovie() {
        return movie;
    }


    public void addCustomer(Customer customer) {
        customers.add(customer); // Listeye müşteri ekle
    }

  // Müşteri Listeleme
    public void listCustomers() {
        if (customers.isEmpty()) {
            System.out.println(getName() + " salonunda müşteri bulunmamaktadır.");
        } else {
            System.out.println(getName() + " salonundaki müşteriler:");
            for (Customer customer : customers) {
                System.out.println("ID: " + customer.getId() + ", Ad: " + customer.getName());
            }
        }
    }


    public List<Customer> getCustomers() {
        return customers;
    }
}

