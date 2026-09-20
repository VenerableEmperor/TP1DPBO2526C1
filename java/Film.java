public class Film {
    private String id;
    private String nama;
    private String genre;
    private int harga;
    private int jual;

    // constructor I
    public Film() {
        this.id = "kosong";
    }

    // constructor II (ada parameter)
    public Film(String id, String nama, String genre, int harga, int jual) {
        this.id = id;
        this.nama = nama;
        this.genre = genre;
        this.harga = harga;
        this.jual = jual;
    }

    // getter
    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getGenre() {
        return genre;
    }

    public int getHarga() {
        return harga;
    }

    public int getJual() {
        return jual;
    }

    // setter
    public void setId(String text) {
        id = text;
    }

    public void setNama(String text) {
        nama = text;
    }

    public void setGenre(String text) {
        genre = text;
    }

    public void setHarga(int angka) {
        harga = angka;
    }

    public void setJual(int angka) {
        jual = angka;
    }
}
