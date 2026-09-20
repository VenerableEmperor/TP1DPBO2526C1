<?php
class Film {
    private $id;
    private $nama;
    private $genre;
    private $harga;
    private $jual;

    // Constructor mimicking the C++ implementation
    public function __construct($id = "kosong", $nama = "", $genre = "", $harga = 0, $jual = 0) {
        $this->id = $id;
        $this->nama = $nama;
        $this->genre = $genre;
        $this->harga = $harga;
        $this->jual = $jual;
    }

    // Getters
    public function getId() { return $this->id; }
    public function getNama() { return $this->nama; }
    public function getGenre() { return $this->genre; }
    public function getHarga() { return $this->harga; }
    public function getJual() { return $this->jual; }

    // Setters
    public function setId($text) { $this->id = $text; }
    public function setNama($text) { $this->nama = $text; }
    public function setGenre($text) { $this->genre = $text; }
    public function setHarga($angka) { $this->harga = $angka; }
    public function setJual($angka) { $this->jual = $angka; }
}
?>