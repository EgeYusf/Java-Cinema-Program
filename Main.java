// Main Sınıfı
import java.util.ArrayList; //Array List kullanmak için
import java.util.List;  //List kullanmak için
import java.util.Scanner; // Kullanıcıdan input almaya yarar.

public class Main { // Statik olarak tanımlamamın nedeni Main sınıfının bir nesnesini oluşturmadan kullanılabilir.
    private static List<Movie> movies = new ArrayList<>(); // Bu kısım filmlerin,salonların ve müşterilerin listesini tutar.
    private static List<Salon> salons = new ArrayList<>();
    private static List<Customer> customers = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {  // Burada movie sınıfından tanımladığım özelliklerin nesnesini oluşturup içeriğini dolduruyorum.
        movies.add(new Movie("Recep İvedik 6", 104, "Komedi"));
        movies.add(new Movie("Spiderman", 80, "Aksiyon"));
        movies.add(new Movie("Harry Potter", 110, "Aksiyon"));
        movies.add(new Movie("Dabbe 2", 116, "Korku"));
        movies.add(new Movie("Terminatör", 70, "Aksiyon"));
        movies.add(new Movie("Venom: Son Dans", 110, "Aksiyon, Komedi, Fantastik"));

        // Burada da salon nesnelerini oluşturdum.
        Salon salon = new Salon(1, "Salon 1");
        salon.ekle(salons);
        Salon salon2 = new Salon(2, "Salon 2");
        salon2.ekle(salons);
        Salon salon3 = new Salon(3, "Salon 3");
        salon3.ekle(salons);
        Salon salon4 = new Salon(4, "Salon 4");
        salon4.ekle(salons);
        Salon salon5 = new Salon(5, "Salon 5");
        salon5.ekle(salons);
        Salon salon6 = new Salon(6, "Salon 6");
        salon6.ekle(salons);

        customers.add(new Customer(1, "Andrew"));
        customers.add(new Customer(2, "Ege"));
        customers.add(new Customer(3, "Selin"));
        customers.add(new Customer(4, "Ali"));
        customers.add(new Customer(5, "Diana"));
        customers.add(new Customer(6, "Helin"));
        customers.add(new Customer(7, "Ali"));
        customers.add(new Customer(8, "Ayse"));
        customers.add(new Customer(9, "Fatma"));
        customers.add(new Customer(10, "Memet"));
        customers.add(new Customer(11, "Yigitcan"));
        customers.add(new Customer(12, "Drake"));



        int secim;
        do { // do-while kullanmamın nedeni her türlü menüyü göstersin.
            System.out.println("\n--- Sinema Sistemi ---");
            System.out.println("1. Yeni Müşteri Ekle");
            System.out.println("2. Yeni Film Ekle");
            System.out.println("3. Yeni Salon Ekle");
            System.out.println("4. Filmleri Listele");
            System.out.println("5. Salonlara Film Ata");
            System.out.println("6. Salondaki Müşterileri Listele");
            System.out.println("0. Çıkış");
            System.out.print("Seçiminiz: ");
            secim = scanner.nextInt();
            scanner.nextLine(); // Satır atlamayı temizle
            // Burada bize lazım olan metodları önce oluşturup(aşağıdaki) sonra switch-case ile seçim yaptırttım.
            switch (secim) {
                case 1:
                    yeniMusteriEkle();
                    break;
                case 2:
                    yeniFilmEkle();
                    break;
                case 3:
                    yeniSalonEkle();
                    break;
                case 4:
                    filmleriListele();
                    break;
                case 5:
                    salonaFilmAta();
                    break;
                case 6:
                    salonMusterileriListele();
                    break;
                case 0:
                    System.out.println("Sistemden çıkılıyor...");
                    break;
                default:
                    System.out.println("Geçersiz seçim. Tekrar deneyin.");
            }
        } while (secim != 0);
    }

    // Müşteri Kayıt Yeri
    private static void yeniMusteriEkle() {
        System.out.print("Müşteri ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Satır atlamayı temizle
        System.out.print("Müşteri Adı: ");
        String name = scanner.nextLine();
        customers.add(new Customer(id, name));
        System.out.println("Yeni müşteri sisteme eklendi.");
    }

    // Eklenen Filmlerin Kayıt,Süre,Tür Yeri
    private static void yeniFilmEkle() {
        System.out.print("Film Adı: ");
        String name = scanner.nextLine();
        System.out.print("Film Süresi (dakika): ");
        int duration = scanner.nextInt();
        scanner.nextLine(); // Satır atlamayı temizle
        System.out.print("Film Türü: ");
        String genre = scanner.nextLine();
        movies.add(new Movie(name, duration, genre));
        System.out.println("Yeni film sisteme eklendi.");
    }

    // Salon Adı Ve Salon Id Kayıt
    private static void yeniSalonEkle() {
        System.out.print("Salon ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Satır atlamayı temizle
        System.out.print("Salon Adı: ");
        String name = scanner.nextLine();
        Salon salon = new Salon(id, name);
        salons.add(salon); // Doğrudan listeye ekleme
        System.out.println("Salon başarıyla eklendi.");
    }


    // Burada eklenen filmlerin listelenmesini istediğimiz metodu yazdık.
    private static void filmleriListele() {
        System.out.println("\n--- Filmler ---");
        for (Movie movie : movies) { // Burada kodun en başında movies ArrayList diye oluşturduğumuz listin içinde dolaşır.Ve yazdırır bize filmleri.
            movie.BilgiGoster(); // Burada ise Movie.java da tanımladığım movie hakkındaki bilgileri yazdıran metodu çağırır.
        }
    }

    private static void salonaFilmAta() {
        // Salonları listele
        System.out.println("\n--- Salonlar ---");
        for (int i = 0; i < salons.size(); i++) {
            System.out.println((i + 1) + ". " + salons.get(i).getName());
        }
        System.out.print("Film atanacak salonu seçin: ");
        int salonIndex = scanner.nextInt() - 1;

        // Filmleri listele
        System.out.println("\n--- Filmler ---");
        for (int i = 0; i < movies.size(); i++) {
            System.out.println((i + 1) + ". " + movies.get(i).getMovieName());
        }
        System.out.print("Salon için bir film seçin: ");
        int filmIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Boş satırı temizle

        // Salona film atama işlemi
        if (salonIndex >= 0 && salonIndex < salons.size() && filmIndex >= 0 && filmIndex < movies.size()) {
            salons.get(salonIndex).setMovie(movies.get(filmIndex));
            System.out.println("Film başarıyla salona atandı.");

            // Atama sonrası bilgileri göster
            System.out.println("\n--- Atama Bilgisi ---");
            System.out.println("Salon: " + salons.get(salonIndex).getName());
            System.out.println("Atanan Film: " + movies.get(filmIndex).getMovieName());
        } else {
            System.out.println("Geçersiz salon veya film seçimi. Lütfen tekrar deneyin.");
        }
    }


    private static void salonMusterileriListele() {
        System.out.println("\n--- Salonlar ---");
        for (int i = 0; i < salons.size(); i++) { // for döngüsü ile salonların her birine erişilir.
            System.out.println((i + 1) + ". " + salons.get(i).getName()); // i+1 in nedeni normalde 0 dan başlıyor.
        }
        System.out.print("Müşterileri görmek istediğiniz salonu seçin: ");
        int salonIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        salons.get(salonIndex).listCustomers();
    }

    private static void salonaMusteriEkle() {
        // Salonları listele
        System.out.println("\n--- Salonlar ---");
        for (int i = 0; i < salons.size(); i++) {
            System.out.println((i + 1) + ". " + salons.get(i).getName());
        }
        System.out.print("Müşteri eklemek istediğiniz salonu seçin (1-" + salons.size() + "): ");
        int salonIndex = scanner.nextInt() - 1; // Kullanıcı için 1 bazlı seçim

        if (salonIndex < 0 || salonIndex >= salons.size()) { // Geçersiz salon kontrolü
            System.out.println("Geçersiz salon seçimi. Lütfen tekrar deneyin.");
            return;
        }

        // Müşterileri listele
        System.out.println("\n--- Müşteriler ---");
        for (int i = 0; i < customers.size(); i++) {
            System.out.println((i + 1) + ". ID: " + customers.get(i).getId() + ", Ad: " + customers.get(i).getName());
        }
        System.out.print("Salona eklemek istediğiniz müşteriyi seçin (1-" + customers.size() + "): ");
        int musteriIndex = scanner.nextInt() - 1; // Kullanıcı için 1 bazlı seçim
        scanner.nextLine(); // Boş satırı temizle

        if (musteriIndex < 0 || musteriIndex >= customers.size()) { // Geçersiz müşteri kontrolü
            System.out.println("Geçersiz müşteri seçimi. Lütfen tekrar deneyin.");
            return;
        }

        // Hangi müşterinin hangi salona ekleneceği kısım
        salons.get(salonIndex).addCustomer(customers.get(musteriIndex));
        System.out.println(customers.get(musteriIndex).getName() + " başarıyla " + salons.get(salonIndex).getName() + " salonuna eklendi.");
    }

}

