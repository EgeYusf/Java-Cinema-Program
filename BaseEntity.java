// BaseEntity Sınıfı Diğer Sınıflar Bu Sınıftan miras alır.
public abstract class BaseEntity {  // abstract yaptım çünkü bu sınıftan miras alıcak diğer sınıflar ve böylece kod tekrarını azalltık.
    private int id;                 // ve buradan newleyip yeni nesne oluşturamayız.Hata alırız.
    private String name;

    public BaseEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Ortak bir metot
    public abstract void BilgiGoster();

}